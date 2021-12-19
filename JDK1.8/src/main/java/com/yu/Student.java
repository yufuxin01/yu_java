package com.yu;

import lombok.*;

import java.util.Objects;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    /** 学号 */
    private long id;

    private String name;

    private int age;

    /** 年级 */
    private int grade;

    /** 专业 */
    private String major;

    /** 学校 */
    private String school;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                age == student.age &&
                grade == student.grade &&
                Objects.equals(name, student.name) &&
                Objects.equals(major, student.major) &&
                Objects.equals(school, student.school);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, grade, major, school);
    }
}
