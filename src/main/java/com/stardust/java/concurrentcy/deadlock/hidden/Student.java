package com.stardust.java.concurrentcy.deadlock.hidden;
public class Student {

    private Teacher teacher;

    private int process;    //答题进度

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public synchronized int getProcess() {
        return process;
    }

    //获取student对象锁
    public synchronized void setProcess(int process) {
        this.process = process;
        if (process == 100) {
        	//获取teacher对象锁
            teacher.studentNotify(this);    //学生答完题，通知老师
        }
    }
}