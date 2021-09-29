package vistual_classroom;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    static  Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        execution();
    }

    public static void execution() {
        Logical logic= new Logical();
        int k=0;
        while(k==0){
            System.out.println();
        System.out.println("1.Strudent login\n2.Faculty login\n3.Administartor login\n4.Exit");
            switch (scan.nextInt()) {
                case 1:
                    int x=0;
                    while(x==0) {
                        System.out.println("1.sign up\n2.Login\n3.Exit");
                        int option = scan.nextInt();
                        if (option == 1) {
                            System.out.println(logic.studentSignup(studentDetails()));
                        }
                        else if (option == 2) {
                            StudentInfo info = new StudentInfo();
                            System.out.println("Enter register No");
                            info.setRegisterNo(scan.nextLong());
                            System.out.println("Enter password");
                            info.setPassword(scan.next());
                            String value = logic.studentLogin(info);
                            System.out.println(value);
                            if (value.equals("Login Successfully")) {
                                int i = 0;
                                while (i == 0) {
                                    System.out.println();
                                    System.out.println("1.Edit profile\n2.studyMaterial & videoLecture\n3.Doubt\n4.Answers\n5.Exit");
                                    switch (scan.nextInt()) {
                                        case 1:
                                            System.out.println(logic.studentProfileUpdation(studentDetails()));
                                            break;
                                        case 2:
                                            for (Map.Entry<Integer, ArrayList<String>> entry : logic.getFacultyLectures().entrySet()) {
                                                ArrayList<String> list = entry.getValue();
                                                for (String val : list)
                                                    System.out.println(val);
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Ask questions");
                                            scan.nextLine();
                                            String question = scan.nextLine();
                                            logic.studentDoubts(question, info);
                                            break;

                                        case 4:
                                            for (Map.Entry entry : logic.getFacultyAnswers().entrySet()) {
                                                System.out.println("Question asked by : " + entry.getKey());
                                                System.out.println("Answer : " + entry.getValue());
                                            }
                                            break;
                                        case 5:
                                            i++;
                                            break;
                                    }
                                }
                            }
                        }
                        else if(option==3)
                            x++;
                        else
                            System.out.println("Invalid option");
                    }
                    break;
                case 2:
                    System.out.println("1.signup\n2.log in");
                    int choice =scan.nextInt();
                    if (choice == 1) {
                        System.out.println(logic.facultySignup(facultyDetails()));
                    } else if (choice == 2) {
                        FacultyInfo info = new FacultyInfo();
                        System.out.println("Enter faculty Id");
                        info.setFacultyId(scan.nextInt());
                        System.out.println("Enter password");
                        info.setPassword(scan.next());
                        System.out.println(logic.facultyLogin(info));
                        int i=0;
                        while(i==0) {
                            System.out.println();
                            System.out.println("1.Edit profile\n2.studyMaterial & videoLecture\n3.Doubt\n4.Answers\n5.Exit");
                            switch (scan.nextInt()) {
                                case 1:
                                    System.out.println(logic.facultyProfileUpdation(facultyDetails()));
                                    break;
                                case 2:
                                    System.out.println("1.post\n2.remove");
                                    LectureInfo lectureInfo = new LectureInfo();
                                    if (scan.nextInt() == 1) {
                                        System.out.println("Enter type");
                                        scan.nextLine();
                                        lectureInfo.setType(scan.nextLine());
                                        System.out.println("Enter the subject");
                                        lectureInfo.setLectureName(scan.nextLine());
                                        System.out.println(logic.lecturesPost(lectureInfo, info));
                                    } else if (scan.nextInt() == 2) {
                                        System.out.println("Enter the nth lecture");
                                        System.out.println(logic.lectureRemove(info, scan.nextInt()));
                                    }
                                    break;
                                case 3:
                                    for (Map.Entry entry : logic.getDoubtMap().entrySet()) {
                                        System.out.println(entry.getKey());
                                        System.out.println(entry.getValue());
                                    }
                                    break;

                                case 4:
                                    System.out.println("For whose question");
                                    long regNo = scan.nextLong();
                                    System.out.println("Enter answer");
                                    scan.nextLine();
                                    String answer = scan.nextLine();
                                    logic.facultyAnswer(regNo, answer);
                                    break;

                                case 5:
                                    i++;
                                    break;
                            }
                        }
                    }
                    break;
                case 3:
                    int i=0;
                    while(i==0) {
                        System.out.println();
                        System.out.println("1.sudent/Faculty\n2.student/nfaculty req\n3.question/Answers\n4.Exit");
                        switch (scan.nextInt()) {
                            case 1:
                                System.out.println("Student List");
                                for (Map.Entry entry : logic.getStudentDetails().entrySet()) {
                                    System.out.println("Register No : " + entry.getKey());
                                    System.out.println(entry.getValue());
                                }
                                System.out.println();
                                System.out.println("Faculty List");
                                for (Map.Entry entry : logic.getFacultyDetails().entrySet()) {
                                    System.out.println("Faculty Id : " + entry.getKey());
                                    System.out.println(entry.getValue());
                                }
                                break;
                            case 2:
                                //********************
                                System.out.println("Incompleted");
                                break;
                            case 3:
                                System.out.println("Questions Asked by the students");
                                System.out.println();
                                for (Map.Entry entry : logic.getDoubtMap().entrySet()) {
                                    System.out.println(entry.getKey());
                                    System.out.println(entry.getValue());
                                }
                                System.out.println("Answers posted by the faculty");
                                System.out.println();
                                for (Map.Entry entry : logic.getFacultyAnswers().entrySet()) {
                                    System.out.println("Question asked by : " + entry.getKey());
                                    System.out.println("Answer : " + entry.getValue());
                                }
                            break;
                            case 4:
                                i++;
                                break;

                        }
                    }
                    break;
                case 4:
                    k++;
                    break;
            }
        }
    }

    public static FacultyInfo facultyDetails() {
        FacultyInfo info = new FacultyInfo();
        System.out.println("Enter name");
        info.setName(scan.next());
        System.out.println("Enter faculty Id");
        info.setFacultyId(scan.nextInt());
        System.out.println("Enter password");
        info.setPassword(scan.next());
        return info;
    }

    public static StudentInfo studentDetails() {
        StudentInfo info = new StudentInfo();
        System.out.println("Enter Name");
        scan.nextLine();
        info.setName(scan.nextLine());
        System.out.println("Enter Register No");
        info.setRegisterNo(scan.nextLong());
        System.out.println("Enter branch");
        info.setBranch(scan.next());
        System.out.println("Enter password");
        info.setPassword(scan.next());
        return info;
    }

}
