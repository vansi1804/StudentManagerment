package schoolmanagement.schoolmanagement;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Person {
    private String name;
    private String gender;
    private String birthDay;
    private String address;

    public Person() {}

    public Person(String name, String gender, String birthDay, String address) {
        setName(name);
        setGender(gender);
        setBirthDay(birthDay);
        setAddress(address);
    }
    
    public Person(Person per) {
        this.name = per.getName();
        this.gender = per.getGender();
        this.birthDay = per.getBirthDay();
        this.address = per.getAddress();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = (gender.equalsIgnoreCase("male") || Integer.parseInt(gender) == 1)?
                       "male":"female";
    }

    public boolean checkGender(String gender){
        try {
            if(!gender.equalsIgnoreCase("male") && 
                Integer.parseInt(gender) != 1 &&
                !gender.equalsIgnoreCase("female") &&
                Integer.parseInt(gender) != 0){
                    System.err.println("\t->>>Enter (0/1 or male/female) for gender. ");
                    return false;
            } else return true;
        } catch (Exception e) {
            System.err.println("\t->>>Enter (0/1 or male/female) for gender. ");
            return false;
        }
        
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public boolean checkBirthDay(String birthDay){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(birthDay);
            return true;
        } catch (Exception e) {
            System.err.println("\t->>>Birthday is illegal. ");
            return false;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    Scanner sc = new Scanner(System.in);
    public void input(){
        System.out.print("Name: ");
        setName(sc.nextLine());
        
        String scan;

        do{
            System.out.print("Gender (0/1 or male/female): ");
            scan = sc.nextLine();
        }while(!checkGender(scan));
        setGender(scan);

        do{
            System.out.print("Birthday (dd/mm/yyyy): ");
            scan = sc.nextLine();
        }while(!checkBirthDay(scan));
        setBirthDay(scan);

        System.out.print("Address: ");
        setAddress(sc.nextLine());
    }

    public void display(){
        System.out.print(this);
    }

    @Override 
    public String toString(){
        return name + ", " + gender + ", " + birthDay + ", " + address;
    }
}
