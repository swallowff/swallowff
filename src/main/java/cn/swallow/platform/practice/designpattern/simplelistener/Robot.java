package cn.swallow.platform.practice.designpattern.simplelistener;

import java.util.ArrayList;

/**
 * @author shenyu
 * @create 2019/4/11
 */
public class Robot {
    private ArrayList<RobotListener> listeners;

    public void registerListener(RobotListener listener){
        if (null == listeners){
            listeners = new ArrayList<>();
        }
        if (null != listener){
            listeners.add(listener);
        }
    }

    public void speak(){
        System.out.println("机器人说:你好");
        RobotActionEvent actionEvent = new RobotActionEvent(this); //把事件信息封装传递给监听器
        for (RobotListener listener : listeners){
            listener.robotSpeaked(actionEvent);
        }
    }

}
