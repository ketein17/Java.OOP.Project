package OceanTech.training.service;


import OceanTech.training.model.Student;
import OceanTech.training.model.StudentScoreCompare;
import OceanTech.training.utils.EmailFormatException;
import OceanTech.training.utils.IDFormatException;
import OceanTech.training.utils.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    public List<Student> addStudent(List<Student> studentList, Scanner scanner) {
        String loop, id, name, score, email;
        Student student;
        do {
            student = new Student();
            do {
                System.out.println("Enter id: ");
                id = scanner.nextLine();
                try {
                    student.setId(id);
                } catch (IDFormatException e) {
                    System.err.println("Please enter id again! " + e.getMessage());
                    continue;
                }
                break;
            } while (true);

            System.out.println("Enter name: ");
            name = scanner.nextLine();
            student.setName(name);

            do {
                System.out.println("Enter score: ");
                score = scanner.nextLine();
                try {
                    double diem = Validator.parseDoubleNumber(score);
                    if (diem >= 0 && diem <= 10) {
                        student.setDiem(Validator.parseDoubleNumber(score));
                    } else {
                        throw new NumberFormatException("Score is invalid!");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Please enter score again!");
                    continue;
                }
                break;
            } while (true);

            do {
                System.out.println("Enter email: ");
                email = scanner.nextLine();
                try {
                    student.setEmail(email);
                } catch (EmailFormatException e) {
                    System.err.println("Please enter email again!");
                    continue;
                }
                break;
            } while (true);
            if (!checkID(studentList, student)) {
                studentList.add(student);
            }
            System.out.println("Do you want to continue to add student(Y/N)?:");
            loop = scanner.nextLine();
        } while (loop.charAt(0) == 'Y' | loop.charAt(0) == 'y');
        return studentList;
    }

    private boolean checkID(List<Student> studentList, Student student) {
        boolean check = false;
        String id = student.getId();
        for (Student student1 : studentList) {
            if (id.equalsIgnoreCase(student1.getId())) {
                System.out.println("ID already exist!");
                check = true;
            }
        }
        return check;
    }

    public void displayListStudent(List<Student> studentList) {
        System.out.println("--------------------Student List--------------------------");
        for (Student student : studentList) {
            student.display();
        }
    }

    public void searchByScoreRange(List<Student> studentList, Scanner scanner) {
        String s1, s2;
        double d1, d2;
        do {
            do {
                System.out.println("Enter score 1: ");
                s1 = scanner.nextLine();
                try {
                    d1 = Validator.parseDoubleNumber(s1);
                } catch (NumberFormatException e) {
                    System.err.println("Score is invalid!");
                    continue;
                }
                break;
            } while (true);

            do {
                System.out.println("Enter score 1: ");
                s2 = scanner.nextLine();
                try {
                    d2 = Validator.parseDoubleNumber(s2);
                } catch (NumberFormatException e) {
                    System.err.println("Score is invalid!");
                    continue;
                }
                break;
            } while (true);
            if (d1 > d2) {
                System.out.println("Enter score range again!");
            }
            break;
        } while (d1 > d2);
        List<Student> rangeList = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getDiem() >= d1 && student.getDiem() <= d2) {
                rangeList.add(student);
            }
        }

        if (!rangeList.isEmpty()) {
            for (Student student : rangeList) {
                student.display();
            }
        } else {
            System.out.println("No data!");
        }

    }

    private int getIndexByID(List<Student> studentList, Scanner scanner) {
        String id;
        int i = -1;
        System.out.println("Enter id: ");
        id = scanner.nextLine();
        for (Student student : studentList) {
            if (id.equalsIgnoreCase(student.getId())) {
                i = studentList.indexOf(student);
            }
        }
        return i;
    }

    public void searchStudentByID(List<Student> studentList, Scanner scanner) {
        int i = getIndexByID(studentList, scanner);
        if (i != -1) {
            System.out.println("-----------------Information of student-------------------");
            studentList.get(i).display();
        } else {
            System.out.println("No data!");
        }
    }

    public void sortAndDisplay(List<Student> studentList) {
        List<Student> sortList = new ArrayList<>();
        sortList.addAll(studentList);
        Collections.sort(sortList, new StudentScoreCompare());
        System.out.println("--------------------Student List--------------------------");
        for (Student student : sortList) {
            student.display();
        }
    }

    public void searchByRank(List<Student> studentList, Scanner scanner) {
        String rank;
        List<Student> students = new ArrayList<>();
        System.out.println("Enter rank: ");
        rank = scanner.nextLine();
        for (Student student : studentList) {
            if (rank.equalsIgnoreCase(student.getRank())) {
                students.add(student);
            }
        }
        if (!students.isEmpty()) {
            sortAndDisplay(students);
        } else {
            System.out.println("No data");
        }
    }

}
