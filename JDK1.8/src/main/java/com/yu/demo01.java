package com.yu;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
public  class demo01 {

    // 初始化
    ArrayList<Student>  students = new ArrayList<Student>() {
        {
            add(new Student(20160001, "孔明", 20, 1, "土木工程", "山东大学"));
            add(new Student(20160001, "孔明", 20, 1, "土木工程", "山东1231大学"));
            add(new Student(20160001, "孔明", 20, 1, "土木工程", "山东123大学"));
            add(new Student(20160001, "伯约", 21, 2, "信息安全", "山东大学"));
            add(new Student(20160003, "玄德", 22, 3, "经济管理", "山东大学"));
            add(new Student(20160004, "云长", 21, 2, "信息安全", "山东大学"));
            add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
            add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
            add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
            add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
            add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
            add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
        }
    };

    public static void main(String[] args) {
        bb();


    }

    /**
     * 整个对象去重 重写 hashCode equals 方法
     */
    private static void cc() {
        List<Student> students = new demo01().getStudents();
        List<Student> collect = students.stream().distinct().collect(Collectors.toList());
        for (Student student : collect) {
            System.out.println(student);
        }
    }

    /**
     * 根据对应的属性去重 （ id ） 去重
     */
    private static void bb() {
        List<Student> students = new demo01().getStudents();
        ArrayList<Student> collect1 = students.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparingLong(Student::getId))), ArrayList::new)
        );
        collect1.forEach(student -> System.out.println(student));
    }

    /**
     * 查询student.getSchool() 山东大学的学生
     */
    private static void aa() {
        List<Student> students = new demo01().getStudents();
        List<Student> collect = students.stream().filter(student -> "山东大学".equals(student.getSchool())).collect(Collectors.toList());
        for (Student student : collect) {
            System.out.println(student);
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
