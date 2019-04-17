package cn.swallow.platform.practice.designpattern.simplelistener;

/**
 * @author shenyu
 * @create 2019/4/11
 */
public class RobotActionEvent {
    private Robot robot;

    public RobotActionEvent(Robot robot) {
        this.robot = robot;
    }

    public Robot getRobot() {
        return robot;
    }

}
