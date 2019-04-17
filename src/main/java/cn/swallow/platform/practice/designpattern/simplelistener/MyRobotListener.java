package cn.swallow.platform.practice.designpattern.simplelistener;

/**
 * @author shenyu
 * @create 2019/4/11
 */
public class MyRobotListener implements RobotListener{

    @Override
    public void robotSpeaked(RobotActionEvent event) {
        System.out.println("监听到机器人说了一句话:"+event.getRobot());
    }

}
