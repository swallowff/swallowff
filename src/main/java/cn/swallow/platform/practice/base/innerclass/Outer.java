package cn.swallow.platform.practice.base.innerclass;

public class Outer {

    private String outerProp;

    private static String outerStaticProp;

    private void outerMethod(){

    }

    private static void outerStaticMethod(){

    }

    /**
     * 成员内部类
     * 成员内部类是依附外部类而存在的，也就是说，如果要创建成员内部类的对象，前提是必须存在一个外部类的对象
     * 成员内部类不能拥有静态属性和静态方法
     */
    public class Inner{
        private String innerProp;

        public void innerMethod(){

        }

        /**
         * 成员内部类可以随意访问外部类的所有私有成员和方法
         */
        public void getOuterProp(){
            String a = outerProp;
            outerMethod();

            //如果内部类拥有和外部类相同的成员和方法时,外部类的成员和方法会被隐藏,需要使用this关键字来区分
            String s = Outer.this.outerProp;
            String x = Inner.this.innerProp;
        }
    }

    /**
     * 外部类访问成员内部类时,需要先创建一个内部类对象
     */
    public void getInnerProp(){
        Inner inner = new Inner();
    }


    /**
     * 静态内部类
     * 静态内部类不需要依附外部对象,但是不能访问外部类的非静态成员变量和非静态方法
     * 静态内部类可以拥有静态属性和静态方法
     */
    public static class StaticInner{
        private String staticInnerProp;

        //静态内部类可以拥有静态属性
        private static String innerProp;

        public void getOuterProp(){
            //静态内部类只能访问外部类的静态成员和静态方法
            String a = outerStaticProp;
            outerStaticMethod();

        }

        //静态内部类可以拥有静态方法,外部可以直接访问
        private static void staticInnerMethod(){

        }


    }


    public static void main(String[] args){
        //创建成员内部类对象时必须先创建外部类对象
        Inner inner = new Outer().new Inner();

        //静态内部类可以不依附于外部类对象
        StaticInner staticInner = new StaticInner();
        String a = StaticInner.innerProp;
    }
}