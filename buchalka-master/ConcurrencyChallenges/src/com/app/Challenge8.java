package com.app;

public class Challenge8 {
    public static void main(String[] args) {
        Object lock = new Object();
        Tutor tutor = new Tutor(lock);
        Student student = new Student(tutor, lock);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                tutor.studyTime();
            }
        });

        Thread studentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                student.handInAssignment();
            }
        });

        tutorThread.start();
        studentThread.start();
    }
}

class Tutor {
    private Student student;
    private final Object lock;

    public Tutor(Object lock) {
        this.lock = lock;
    }

    public void setStudent(Student student) {
        synchronized (lock) {
            this.student = student;
        }
    }

    public void studyTime() {
        synchronized (lock) {
            System.out.println("Tutor has arrived");
            try {
                // wait for student to arrive and hand in assignment
                Thread.sleep(300);
            }
            catch (InterruptedException e) {

            }
            student.startStudy();
            System.out.println("Tutor is studying with student");
        }
    }

    public void getProgressReport() {
        synchronized (lock) {
            // get progress report
            System.out.println("Tutor gave progress report");
        }
    }
}

class Student {
    private Tutor tutor;
    private final Object lock;

    Student(Tutor tutor, Object lock) {
        this.tutor = tutor;
        this.lock = lock;
    }

    public void startStudy() {
        synchronized (lock) {
            // study
            System.out.println("Student is studying");
        }
    }

    public void handInAssignment() {
        synchronized (lock) {
            tutor.getProgressReport();
            System.out.println("Student handed in assignment");
        }
    }
}
