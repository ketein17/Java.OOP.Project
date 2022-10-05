package OceanTech.training.main;

import OceanTech.training.model.Student;
import OceanTech.training.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {
    private static final List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        String choice;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("-------------------Menu----------------------");
                System.out.println("""
                        1.Add student
                        2.Display student
                        3.Search by score range
                        4.Search by rank
                        5.Search by id
                        6.Sort list student by score
                        """);
                System.out.println("Select: ");
                choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> studentService.addStudent(studentList, scanner);
                    case "2" -> studentService.displayListStudent(studentList);
                    case "3" -> studentService.searchByScoreRange(studentList, scanner);
                    case "4" -> studentService.searchByRank(studentList, scanner);
                    case "5" -> studentService.searchStudentByID(studentList, scanner);
                    case "6" -> studentService.sortAndDisplay(studentList);
                    default -> {
                    }
                }
            } while (!choice.equalsIgnoreCase("10"));
        }
    }
}
