package schoolmanagement.schoolmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMAIN {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        System.out.println("\n\nBan đầu danh sách rỗng, hãy khởi tạo 1 danh sách, xem danh sách, lưu file và đọc file");
        while (true) {
            int choose = 0;
            boolean check = false;
            while (!check) {
                Menu();
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
                case 1: System.out.println("Enter student's information: ");
                        Student student = new Student();
                        student.input();
                        if (studentList.ExistRollnoAtIndex(student.getRollno()) == -1) {
                            studentList.Add(student);
                        } else System.err.println("Rollno is exist. ");
                    break;

                case 2: studentList.Show();
                    break;

                case 3:
                        System.out.print("Enter the student's rollno you want to find: ");
                        String rollno = sc.nextLine();
                        studentList.FindByRollno(rollno);
                    break;

                case 4: studentList.Sort();
                        System.out.print("->>>>>Student list is sorted. ");
                    break;

                case 5:
                        System.out.println(studentList.ScholarshipStudentList());
                    break;

                case 6: studentList.writeDataToFile("studentlist.dat");
                    break;

                case 7: studentList.readDataFromFile("studentlist.dat");
                    break;
                
                case 8: studentList.setStudentlist(initStudentList());
                        System.out.print("->>>>>A Student list is init. ");
                    break;

                default:    System.err.println("\n\n\t\t\t\t\tChoice is not legal");
                    break;
            }
        }
    }

    public static void Menu(){
        System.out.println("\n\n\t\t\t\t\t==================================================");
        System.out.println("\t\t\t\t\t\t\t\tMENU");
        System.out.println("\t\t\t\t\t==================================================");
        System.out.println("\t\t\t\t\t\t\t0.Exit");
        System.out.println("\t\t\t\t\t\t\t1.Add student");
        System.out.println("\t\t\t\t\t\t\t2.Show student's information all");
        System.out.println("\t\t\t\t\t\t\t3.Find student");
        System.out.println("\t\t\t\t\t\t\t4.Sort student list");
        System.out.println("\t\t\t\t\t\t\t5.Show student's information who has scholarship");
        System.out.println("\t\t\t\t\t\t\t6.Save file.");
        System.out.println("\t\t\t\t\t\t\t7.Read file.");
        System.out.println("\t\t\t\t\t\t\t8.Init a student list.");
        System.out.print("\t\t\t\t\t\t\t\tChoose? __");
    }

    public static ArrayList<Student> initStudentList() {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("A", "1", "1/1/1", "1D", "111", 1, "1@"));
        list.add(new Student("B", "0", "1/2/2", "2D", "222", (float) 8.5, "1@"));
        list.add(new Student("3", "1", "1/2/3", "3D", "333", 4, "1@"));
        list.add(new Student("D", "1", "2/2/2", "4D", "444", 8, "1@"));
        list.add(new Student("2", "0", "2/3/3", "5D", "555", 5, "1@"));
        list.add(new Student("C", "0", "2/3/4", "6D", "666", 7, "1@"));
        list.add(new Student("7", "0", "3/3/3", "7D", "777", 3, "1@"));
        list.add(new Student("H", "1", "3/4/4", "8", "888", 9, "1@"));
        list.add(new Student("1", "1", "3/4/5", "9D", "999", 0, "1@"));
        list.add(new Student("E", "1", "4/4/4", "10D", "101", 10, "1@"));
        return list;
    }
}
