package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");
            if (parts.length < 5) continue;

            String command = parts[0];

            if (command.equals("course-add") && parts.length == 5) {
                // Check for duplicate course
                boolean courseExists = false;
                for (Course course : courses) {
                    if (course.getCourseCode().equals(parts[1])) {
                        courseExists = true;
                        break;
                    }
                }
                if (!courseExists) {
                    courses.add(new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                }
            } 
            else if (command.equals("student-add") && parts.length == 5) {
                // Check for duplicate student
                boolean studentExists = false;
                for (Student student : students) {
                    if (student.getStudentId().equals(parts[1])) {
                        studentExists = true;
                        break;
                    }
                }
                if (!studentExists) {
                    students.add(new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                } 
            } 
            else if (command.equals("enrollment-add") && parts.length == 5) {
                // Check for duplicate enrollment
                boolean enrollmentExists = false;
                for (Enrollment enrollment : enrollments) {
                    if (enrollment.getCourseCode().equals(parts[1]) &&
                        enrollment.getStudentId().equals(parts[2]) &&
                        enrollment.getAcademicYear().equals(parts[3])) {
                        enrollmentExists = true;
                        break;
                    }
                }
                if (!enrollmentExists) {
                    enrollments.add(new Enrollment(parts[1], parts[2], parts[3], parts[4]));
                }
            }
        }

        for (Course course : courses) {
            System.out.println(course);
        }
        for (Student student : students) {
            System.out.println(student);
        }
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        scanner.close();
    }
}
