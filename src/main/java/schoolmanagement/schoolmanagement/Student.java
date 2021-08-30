package schoolmanagement.schoolmanagement;

import java.io.Serializable;
import java.util.Scanner;

public class Student extends Person implements Serializable{
    private String rollno;
    private float avgMark;
    private String email;
    public Student() {
        super();
        this.rollno = null;
        this.avgMark = 0;
        this.email = null;
    }
    public Student(String name, String gender, String birthDay, String address, String rollno, float avgMark,
            String email) {
        super(name, gender, birthDay, address);
        setRollno(rollno);
        setAvgMark(avgMark);
        setEmail(email);
    }
    public Student(Student student) {
        super(student.getName(),student.getGender(),student.getBirthDay(),student.getAddress());
        this.rollno = student.getRollno();
        this.avgMark = student.getAvgMark();
        this.email = student.getEmail();
    }
    public String getRollno() {
        return rollno;
    }
    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public float getAvgMark() {
        return avgMark;
    }
    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public boolean checkAvgMark(float avgMark){
        if(avgMark < 0 || avgMark > 10){
            System.err.println("\t->>>Mark is illegal (0<=mark<=10).");
            return false;
        }
        return true;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean checkEmail(String email){
        if(email.indexOf("@")==-1 || email.indexOf(" ")!=-1){
            System.err.println("\t->>>Email is illegal (email must have character '@' and not have space).");
            return false;
        } 
        return true; 
    }

    public boolean hasScholarship() {
        if(avgMark >= 8){
            return true;
        }
        return false;
    }

    Scanner sc = new Scanner(System.in);
    public void input(){
        super.input();
        System.out.print("Rollno: ");
        setRollno(sc.nextLine());
        boolean check;
        do{
            System.out.print("Mark: ");
            try {
                avgMark = Float.parseFloat(sc.nextLine());
                check = true;
            } catch (Exception e) {
                e.printStackTrace();
                check = false;
            }
        }while(!checkAvgMark(avgMark) || !check);

        do{
            System.out.print("Email: ");
            email = sc.nextLine();
        }while(!checkEmail(email));
    }

    public void display(){
        System.out.print(this);
    }

    @Override 
    public String toString(){
        return super.toString() + "," + rollno + ", " + avgMark + ", " + email;
    }
}
