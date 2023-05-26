/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentThread;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Thread2 extends Thread {

    SharedData sharedData;

    public Thread2(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedData) {
                sharedData.notifyAll();
                try {
                    while (sharedData.getCurrentThread() != SharedData.THREAD_2 && !sharedData.isStop()) {
                        sharedData.wait();
                    }
                    if(sharedData.isStop())break;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                }

                Student student = sharedData.getVaidStudentLast();
                System.out.println("Welcome student has roll number is: " + student.getRollNo());
                System.out.println("Valid collection has length: " + sharedData.getValidRollNumber().size());

                // ghi vao file .dat
                FileOutputStream fos = null;
                ObjectOutputStream oos = null;

                try {
                    fos = new FileOutputStream(student.getRollNo() + ".dat");
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(student);

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (oos != null) {
                        try {
                            oos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                // chuyen thread
                sharedData.setCurrentThread(SharedData.THREAD_1);
            }
        }
        sharedData.setStop(true);
        synchronized (sharedData) {
            sharedData.notifyAll();
        }
    }

}
