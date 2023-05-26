/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentThread;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Thread3 extends Thread {

    SharedData sharedData;

    public Thread3(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("unvalid.txt", true);
            while (true) {
                synchronized (sharedData) {
                    sharedData.notifyAll();

                    try {
                        while (sharedData.getCurrentThread() != SharedData.THREAD_3 && !sharedData.isStop()) {
                            sharedData.wait();
                        }
                        if(sharedData.isStop())break;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread3.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    String rollNo = sharedData.getUnvalidRollNoLast();
                    System.out.println("Unvalid roll number: " + rollNo);

                    // ghi unvalid roll number vao file
                    rollNo += '\n';
                    byte[] b = rollNo.getBytes();
                    fos.write(b);

                    // chuyen thread
                    sharedData.setCurrentThread(SharedData.THREAD_1);
                }
            }
            sharedData.setStop(true);
            synchronized (sharedData) {
                sharedData.notifyAll();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Thread3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Thread3.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Thread3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
