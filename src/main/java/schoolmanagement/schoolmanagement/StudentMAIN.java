package schoolmanagement.schoolmanagement;

import java.util.Scanner;

public class StudentMAIN {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        studentList.init();
        studentList.Show();
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
                    System.out.print("Student list is sorted. ");
                    break;

                case 5:
                        System.out.println(studentList.ScholarshipStudentList());
                    break;

                // case 6: studentList.writeDataToFile("studentlist.dat");
                //     break;

                // case 7: studentList.readDataFromFile("studentlist.dat");
                //     break;

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
        // System.out.println("\t\t\t\t\t\t\t6.Save to file.");
        // System.out.println("\t\t\t\t\t\t\t7.Read from file.");
        System.out.print("\t\t\t\t\t\t\t\tChoose? __");
    }
    
}
