package com.stardust.java.concurrentcy.deadlock.hidden;
import java.util.List;

public class Teacher {

    List<Student> students;

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public synchronized void studentNotify(Student student) {
        students.remove(student);   //将已完成考试的学生从列表中移除
    }
    
    // 获取teacher对象锁
    public synchronized void getAllStudentStatus() {
        for (Student student : students) {
        	//student.getProcess()获取student对象锁
            System.out.println(student.getProcess());
        }
    }
}