package com.stardust.java.concurrentcy.deadlock.hidden;

import java.util.ArrayList;
import java.util.List;

public class HiddenDeadLockTest {
    public static void main(String[] args) throws InterruptedException {
    	final Teacher teacher = new Teacher();
    	final List<Student> students = new ArrayList<Student>();
    	Student temp;
    	for(int i=0;i<10;i++){
    		temp = new Student();
    		temp.setTeacher(teacher);
    		students.add(temp);
    	}
    	teacher.setStudents(students);
    	
		Thread teacherThread = new Thread(new Runnable() {
			public void run() {
                 teacher.getAllStudentStatus();
			}
		});
		
		Thread studentThread = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0; i < students.size(); i++) {
					students.get(i).setProcess(i);
				}
				
			}
		});
		//Thread.sleep(2000L);
		teacherThread.start();
		studentThread.start();
	}
}
