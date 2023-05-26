/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentThread;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Le Lien
 */
public class SharedData {

    public static final int THREAD_1 = 1;
    public static final int THREAD_2 = 2;
    public static final int THREAD_3 = 3;

    List<Student> validRollNumber;
    List<String> unvalidRollNumber;

    int currentThread = 1;
    boolean stop = false;

    public SharedData() {
        validRollNumber = new ArrayList<>();
        unvalidRollNumber = new ArrayList<>();
    }

    // them Student vao danh sach validRollNumber
    private void addValidRollNumber(String rollNo) {
        Student student = new Student(rollNo);
        validRollNumber.add(student);
    }

    // them roll number vao danh sach unvalidRollNumber
    private void addUnvalidRollNumber(String rollNo) {
        unvalidRollNumber.add(rollNo);
    }

    // lay ra Student o cuoi danh sach validRollNumber
    public Student getVaidStudentLast() {
        return validRollNumber.get(validRollNumber.size() - 1);
    }

    // lay ra roll number o cuoi danh sach unvalidRollNumber
    public String getUnvalidRollNoLast() {
        return unvalidRollNumber.get(unvalidRollNumber.size() - 1);
    }

    // kiem tra roll number thoa man dieu kien khong
    public boolean checkValidRollNo(String RollNo) {
        String exp = "^AT[0-9]{2}[A-Z][0-9]{4}$";
        Pattern pattern = Pattern.compile(exp);
        Matcher matcher = pattern.matcher(RollNo);

        if (matcher.find()) {
            addValidRollNumber(RollNo);
            return true;
        } else {
            addUnvalidRollNumber(RollNo);
            return false;
        }
    }

    public List<Student> getValidRollNumber() {
        return validRollNumber;
    }

    public void setValidRollNumber(List<Student> validRollNumber) {
        this.validRollNumber = validRollNumber;
    }

    public List<String> getUnvalidRollNumber() {
        return unvalidRollNumber;
    }

    public void setUnvalidRollNumber(List<String> unvalidRollNumber) {
        this.unvalidRollNumber = unvalidRollNumber;
    }

    public int getCurrentThread() {
        return currentThread;
    }

    public void setCurrentThread(int currentThread) {
        this.currentThread = currentThread;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

}
