package cn.swallow.platform.practice.base.comparator;

import cn.swallow.platform.core.util.json.GsonHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author shenyu
 * @create 2019/4/12
 */
public class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.age,o.age);
    }

    public static void main(String[] args){
        Student a = new Student("StudentA",18);
        Student b = new Student("StudentB",20);

        List<Student> students = new ArrayList<>();
        students.add(b);
        students.add(a);
        System.out.println(GsonHelper.toJson(students));
        Collections.sort(students);
        System.out.println(GsonHelper.toJson(students));
    }
}
