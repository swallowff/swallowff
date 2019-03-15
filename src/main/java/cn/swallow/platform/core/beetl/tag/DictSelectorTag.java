package cn.swallow.platform.core.beetl.tag;

import cn.hutool.core.util.StrUtil;
import cn.swallow.platform.core.common.exception.BizExceptionEnum;
import cn.swallow.platform.core.common.exception.ServiceException;
import cn.swallow.platform.core.util.CommonUtil;
import cn.swallow.platform.modular.system.entity.Dict;
import cn.swallow.platform.modular.system.service.DictService;
import org.beetl.core.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
public class DictSelectorTag extends Tag {

    @Autowired
    DictService dictService;

    @Override
    public void render() {
        //String tagName = (String) this.args[0];
        Map attrs = (Map) args[1];
        if (CommonUtil.isEmpty(attrs.get("code"))) {
            throw new ServiceException(BizExceptionEnum.ERROR_CODE_EMPTY);
        }

        //字典类型编码
        String code = attrs.get("code").toString();
        //控件显示类型select 选择框,radio 单选按钮,checkbox 多选按钮
        String type = CommonUtil.isNotEmpty(attrs.get("type")) ? attrs.get("type").toString() : "select";
        //开启多选
        String multiple = CommonUtil.isNotEmpty(attrs.get("multiple")) ? attrs.get("multiple").toString() : "";
        //字典名称
        String label = CommonUtil.isNotEmpty(attrs.get("label")) ? attrs.get("label").toString() : "";
        //提示
        String placeholder = (CommonUtil.isNotEmpty(attrs.get("placeholder")) ? attrs.get("placeholder").toString() : "");
        //宽度
        String width = CommonUtil.isNotEmpty(attrs.get("width")) ? attrs.get("width").toString() : "248";
        //默认值
        String value = CommonUtil.isNotEmpty(attrs.get("value")) ? attrs.get("value").toString() : "";
        //id
        String id = CommonUtil.isNotEmpty(attrs.get("id")) ? attrs.get("id").toString() : "";
        //name
        String name = CommonUtil.isNotEmpty(attrs.get("name")) ? attrs.get("name").toString() : "";
        //分割线
        String underline = CommonUtil.isNotEmpty(attrs.get("underline")) ? attrs.get("underline").toString() : "";
        //onchange事件
        String onchange = CommonUtil.isNotEmpty(attrs.get("onchange")) ? attrs.get("onchange").toString() : "";
        //readonly属性
        String readonly = CommonUtil.isNotEmpty(attrs.get("readonly")) ? attrs.get("readonly").toString() : "";
        //disabled属性
        String disabled = CommonUtil.isNotEmpty(attrs.get("disabled")) ? attrs.get("disabled").toString() : "";
        //searchnum 下拉选项数量达到多少启用搜索,默认10
        int searchnum = CommonUtil.isNum(attrs.get("searchnum")) ? Integer.parseInt(attrs.get("searchnum").toString()) : 10;
        //根据code查询字典数据
        List<Dict> list = dictService.selectByParentCode(code);

        StringBuffer html = new StringBuffer();
        html.append("<div class=\"form-group\">\r\n");
        html.append("<label class=\"col-sm-3 control-label\">" + label + "</label>\r\n");
        html.append("<div class=\"col-sm-9\">\r\n");

        //单选按钮
        if ("radio".equals(type)) {

            list.forEach(obj -> {
                html.append("<label class=\"radio-inline i-checks\">\r\n<input type=\"radio\" ");
                //判断控件是否禁用
                if ("true".equals(disabled) || "disabled".equals(disabled)) {
                    html.append("disabled ");
                } else {
                    if (CommonUtil.isNotEmpty(name)) {
                        html.append("name=\"" + name + "\" ");
                    }
                }
                if ("true".equals(readonly) || "disabled".equals(readonly)) {
                    html.append("disabled ");
                }
                if (CommonUtil.isNotEmpty(value) && value.equals(obj.getVal())) {
                    html.append("checked ");
                }

                html.append("value=\"" + obj.getVal() + "\" >" + obj.getName() + "</label>\r\n");
            });

            //多选按钮
        } else if ("checkbox".equals(type)) {
            list.forEach(obj -> {
                html.append("<label class=\"checkbox-inline i-checks\">\r\n<input type=\"checkbox\" ");
                //判断控件是否禁用
                if ("true".equals(disabled) || "disabled".equals(disabled)) {
                    html.append("disabled ");
                } else {
                    if (CommonUtil.isNotEmpty(name)) {
                        html.append("name=\"" + name + "\" ");
                    }
                }
                if ("true".equals(readonly) || "disabled".equals(readonly)) {
                    html.append("disabled ");
                }
                if (CommonUtil.isNotEmpty(value) && value.equals(obj.getVal())) {
                    html.append("checked ");
                }

                html.append("value=\"" + obj.getVal() + "\" >" + obj.getName() + "</label>\r\n");
            });

            //默认select
        } else {
            //开启多选
            if ("true".equals(multiple)) {
                if (list.size() >= searchnum) {
                    html.append("<select multiple ");
                } else {
                    html.append("<select multiple=\"multiple\" size=\"10\" ");
                }
            } else {
                html.append("<select ");
            }

            //判断控件是否启用提示
            if (CommonUtil.isNotEmpty(placeholder)) {
                html.append(" data-placeholder=\"" + placeholder + "\" ");
            }

            //判断控件是否禁用
            if ("true".equals(disabled) || "disabled".equals(disabled)) {
                html.append("disabled=\"disabled\" ");
            } else {
                //启用
                if (CommonUtil.isNotEmpty(id)) {
                    html.append("id=\"" + id + "\" ");
                }

                if (CommonUtil.isNotEmpty(name)) {
                    html.append("name=\"" + name + "\" ");
                }
            }

            //判断是否启用搜索框
            //判断下拉数据,如果查询出来的条数达到启用搜索的数量就启用


            if (list.size() >= searchnum) {
                html.append("class=\"form-control chosen-select\" style=\"width:" + width + "px\"  tabindex=\"1\" \r\n");
            } else {
                html.append("class=\"form-control\" style=\"width:" + width + "px\" \r\n");
            }

            //判断控件是否只读
            if ("true".equals(readonly) || "readonly".equals(readonly)) {
                if (list.size() >= searchnum) {
                    html.append("disabled=\"disabled\" ");
                } else {
                    html.append("onfocus=\"this.defaultIndex=this.selectedIndex;\" onchange=\"this.selectedIndex=this.defaultIndex;\" ");
                }
            }

            //判断是否绑定onchange事件
            if (CommonUtil.isNotEmpty(onchange)) {
                html.append("onchange=\"" + onchange + "($(this).children('option:selected').val())\" ");
            }

            html.append(">");
            if (CommonUtil.isNotEmpty(placeholder)) {
                html.append("<option value=\"\">" + placeholder + "</option>\r\n");
            }
            //将查询出来的数据添加到select中
            list.forEach(obj -> {
                if (CommonUtil.isNotEmpty(value) && value.equals(obj.getVal())) {
                    html.append("<option selected value=\"" + obj.getVal() + "\">" + obj.getName() + "</option>\r\n");
                } else {
                    html.append("<option value=\"" + obj.getVal() + "\">" + obj.getName() + "</option>\r\n");
                }
            });
            html.append("</select>\r\n");
        }

        html.append("</div>\r\n</div>\r\n");
        //判断是否添加分割线
        if (CommonUtil.isNotEmpty(underline) && "true".equals(underline)) {
            html.append("<div class=\"hr-line-dashed\" ></div >\r\n");
        }

        try {
            this.ctx.byteWriter.writeString(html.toString());
        } catch (IOException e) {
            throw new RuntimeException("输出字典标签错误");
        }
    }
}