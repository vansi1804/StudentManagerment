package schoolmanagement.schoolmanagement;

// import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class StudentList {
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

    public void SortByName() {
        Collections.sort(studentlist, new Comparator<Student>() { 
            @Override public int compare(Student st1, Student st2) { 
              return st1.getName().compareToIgnoreCase(st2.getName()); 
          } });
    }

    public void SortByMark() {
        Collections.sort(studentlist, new Comparator<Student>() { 
            @Override public int compare(Student st1, Student st2) { 
              if(st1.getAvgMark() > st2.getAvgMark())
                return -1;
                else if (st1.getAvgMark() < st2.getAvgMark())
                    return 1;
                return 0;
          } });
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
        String str = "";
        for (Student student : studentlist) {
            if (student.hasScholarship()) {
                str += "\n" + student.toString();
            };
        }
        return str;
    }

    public void init() {
        Add(new Student("A", "1", "1/1/1", "1D", "111", 1, "1@"));
        Add(new Student("B", "0", "1/2/2", "2D", "222", (float) 8.5, "1@"));
        Add(new Student("C", "1", "1/2/3", "3D", "333", 4, "1@"));
        Add(new Student("D", "1", "2/2/2", "4D", "444", 8, "1@"));
        Add(new Student("E", "0", "2/3/3", "5D", "555", 5, "1@"));
        Add(new Student("F", "0", "2/3/4", "6D", "666", 7, "1@"));
        Add(new Student("G", "0", "3/3/3", "7D", "777", 3, "1@"));
        Add(new Student("H", "1", "3/4/4", "8", "888", 9, "1@"));
        Add(new Student("I", "1", "3/4/5", "9D", "999", 0, "1@"));
        Add(new Student("K", "1", "4/4/4", "10D", "101", 10, "1@"));
    }

    // void writeDataToFile(String filename) {
    //     FileOutputStream fos = null;
    //     ObjectOutputStream oos = null;

    //     try {
    //         fos = new FileOutputStream(filename);
    //         oos = new ObjectOutputStream(fos);

    //         oos.writeObject(studentlist);
    //     } catch (FileNotFoundException e) {
    //         e.printStackTrace();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     } finally {
    //         if (fos != null) {
    //             try {
    //                 fos.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //         if (oos != null) {
    //             try {
    //                 oos.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }
    // }

    // void readDataFromFile(String filename) {
    //     FileInputStream fis = null;
    //     ObjectInputStream ois = null;

    //     try {
    //         fis = new FileInputStream(filename);
    //         ois = new ObjectInputStream(fis);

    //         setStudentlist((ArrayList<Student>) ois.readObject());
        
    //     } catch (FileNotFoundException e) {
    //         e.printStackTrace();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     } catch (ClassNotFoundException e) {
    //         e.printStackTrace();
    //     } finally {
    //         if (fis != null) {
    //             try {
    //                 fis.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //         if (ois != null) {
    //             try {
    //                 ois.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }
    // }

}
