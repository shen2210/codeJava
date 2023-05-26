/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentThread;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Le Lien
 */
public class Thread1 extends Thread {

    SharedData sharedData;

    public Thread1(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bReader = null;

        try {
            fis = new FileInputStream("students.txt");
            reader = new InputStreamReader(fis);
            bReader = new BufferedReader(reader);

            String line = null;

            while (true) {
                synchronized (sharedData) {
                    line = bReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.isEmpty()) {
                        continue;
                    }

                    boolean isValid = sharedData.checkValidRollNo(line);
                    if (isValid) {
                        //chuyen thread
                        sharedData.setCurrentThread(SharedData.THREAD_2);
                    } else {
                        //chuyen thread
                        sharedData.setCurrentThread(SharedData.THREAD_3);
                    }
                    sharedData.notifyAll();
                    try {
                        while (sharedData.getCurrentThread() != SharedData.THREAD_1 && !sharedData.isStop()) {
                            sharedData.wait();
                        }
                        if(sharedData.isStop())break;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            sharedData.setStop(true);
            synchronized (sharedData) {
                sharedData.notifyAll();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (bReader != null) {
                try {
                    bReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
