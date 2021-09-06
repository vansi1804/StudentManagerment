package schoolmanagement.schoolmanagement;

 import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import schoolmanagement.schoolmanagement.Sort.*;


public class StudentList implements Serializable{
    private ArrayList<Student> studentlist = new ArrayList<>();

    public ArrayList<Student> getStudentlist() {
        return studentlist;
    }

    public void setStudentlist(ArrayList<Student> studentlist) {
        this.studentlist = studentlist;
    }

    public void Add(Student student) {
        studentlist.add(student);
    }

    public void Show() {
        for (Student student : studentlist) {
            System.out.print("\n");
            student.display();
        }
    }

    Scanner sc = new Scanner(System.in);
    public void Sort() {
        while (true) {
            int choose = 0;
            boolean check = false;
            while (!check) {
                System.out.println("0.Exit");
                System.out.println("1. Sort by Name. ");
                System.out.println("2. Sort by Average Mark. ");
                System.out.print("Choose? __");
                try {
                    choose = Integer.parseInt(sc.nextLine());
                    check = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    check = false;
                }
            }
            switch (choose) {
                case 0: return;
                case 1:  Collections.sort(studentlist, new SortByName());
                    return;
                case 2:  Collections.sort(studentlist, new SortByAVGMark());
                    return;
                default:    System.err.println("\nChoice is not legal");
                    break;
            }
        }
    }

    public int ExistRollnoAtIndex(String rollno) {
        for (int i = 0; i < studentlist.size(); i++) {
            if (studentlist.get(i).getRollno().compareToIgnoreCase(rollno) == 0) {
                return i;
            }
        }
        return -1;
    }
    
    public void FindByRollno(String rollno) {
        int index = ExistRollnoAtIndex(rollno);
        if (index != -1) {
         studentlist.get(index).display();   
        } else System.err.println("Student has rollno " + rollno + " is not exist");
    }

    public String ScholarshipStudentList() {
        String scholarshipStudentList = "";
        for (Student student : studentlist) {
            if (student.hasScholarship()) {
                scholarshipStudentList += "\n" + student.toString();
            };
        }
        return scholarshipStudentList;
    }

    void writeDataToFile(String filename) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentlist);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    void readDataFromFile(String filename) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);

            setStudentlist((ArrayList<Student>) ois.readObject());
            for (Student student : studentlist) {
                System.out.print(student);
            }
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
