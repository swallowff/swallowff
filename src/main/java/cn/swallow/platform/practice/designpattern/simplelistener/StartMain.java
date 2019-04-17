package cn.swallow.platform.practice.designpattern.simplelistener;

/**
 * @author shenyu
 * @create 2019/4/11
 */
public class StartMain {

    public static void main(String[] args){
        Robot robot = new Robot();
        robot.registerListener(new MyRobotListener());
        robot.speak();
    }


}
