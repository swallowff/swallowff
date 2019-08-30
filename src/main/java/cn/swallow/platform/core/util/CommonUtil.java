package cn.swallow.platform.core.util;

import cn.swallow.platform.common.exception.ServiceException;
import cn.swallow.platform.common.exception.constant.CoreExceptionEnum;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author shenyu
 * @create 2019/3/12
 */
public class CommonUtil {

    public static String packageToPath(String var1){
        if (null != var1){
            var1 = File.separator+var1.replace("\u002E",File.separator);
        }
        return var1;
    }

    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        } else {
            if (o instanceof String) {
                if (o.toString().trim().equals("")) {
                    return true;
                }
            } else if (o instanceof List) {
                if (((List)o).size() == 0) {
                    return true;
                }
            } else if (o instanceof Map) {
                if (((Map)o).size() == 0) {
                    return true;
                }
            } else if (o instanceof Set) {
                if (((Set)o).size() == 0) {
                    return true;
                }
            } else if (o instanceof Object[]) {
                if (((Object[])((Object[])o)).length == 0) {
                    return true;
                }
            } else if (o instanceof int[]) {
                if (((int[])((int[])o)).length == 0) {
                    return true;
                }
            } else if (o instanceof long[] && ((long[])((long[])o)).length == 0) {
                return true;
            }

            return false;
        }
    }

    public static boolean isOneEmpty(Object... os) {
        Object[] var1 = os;
        int var2 = os.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Object o = var1[var3];
            if (isEmpty(o)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isAllEmpty(Object... os) {
        Object[] var1 = os;
        int var2 = os.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Object o = var1[var3];
            if (!isEmpty(o)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNum(Object obj) {
        try {
            Integer.parseInt(obj.toString());
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static byte[] toByteArray(String filename) {
        File f = new File(filename);
        if (!f.exists()) {
            throw new ServiceException(CoreExceptionEnum.FILE_NOT_FOUND);
        } else {
            FileChannel channel = null;
            FileInputStream fs = null;

            try {
                fs = new FileInputStream(f);
                channel = fs.getChannel();
                ByteBuffer byteBuffer = ByteBuffer.allocate((int)channel.size());

                while(channel.read(byteBuffer) > 0) {
                    ;
                }

                byte[] var5 = byteBuffer.array();
                return var5;
            } catch (IOException var17) {
                throw new ServiceException(CoreExceptionEnum.FILE_READING_ERROR);
            } finally {
                try {
                    channel.close();
                } catch (IOException var16) {
                    throw new ServiceException(CoreExceptionEnum.FILE_READING_ERROR);
                }

                try {
                    fs.close();
                } catch (IOException var15) {
                    throw new ServiceException(CoreExceptionEnum.FILE_READING_ERROR);
                }
            }
        }
    }

    public static String getExceptionMsg(Throwable e) {
        StringWriter sw = new StringWriter();

        try {
            e.printStackTrace(new PrintWriter(sw));
        } finally {
            try {
                sw.close();
            } catch (IOException var8) {
                var8.printStackTrace();
            }

        }

        return sw.getBuffer().toString().replaceAll("\\$", "T");
    }
}
