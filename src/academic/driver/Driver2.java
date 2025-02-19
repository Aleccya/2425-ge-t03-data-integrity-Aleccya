package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
<<<<<<< HEAD


import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
=======
import academic.model.Course.InvalidCourseException;
import academic.model.Student.InvalidStudentException;
import java.util.*;
>>>>>>> 2e76e852c45c4a33ada86b47e411df6d309749a9

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
<<<<<<< HEAD
        LinkedList<Course> courses = new LinkedList<>();
        LinkedList<Student> students = new LinkedList<>();
        LinkedList<Enrollment> enrollments = new LinkedList<>();
        HashSet<String> courseIds = new HashSet<>();
        LinkedHashSet<String> studentIds = new LinkedHashSet<>();
        HashSet<String> enrollmentIds = new HashSet<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");
            if (parts.length < 5) continue;
 
            String command = parts[0];

            if (command.equals("course-add") && parts.length == 5) {
                if (!courseIds.contains(parts[1])) {
                    courses.add(new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                    courseIds.add(parts[1]);
                }
                
            } 
            else if (command.equals("student-add") && parts.length == 5) {
                if (!studentIds.contains(parts[1])) {
                    students.add(new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                    studentIds.add(parts[1]);
                }
            } 
            else if (command.equals("enrollment-add") && parts.length == 5) {
                String courseId = parts[1];
                String studentId = parts[2];
                if (!courseIds.contains(courseId)) {
                    System.out.println("invalid course|" + courseId);
                } else if (!studentIds.contains(studentId)) {
                    System.out.println("invalid student|" + studentId);
                } else {
                    String enrollmentId = courseId + "#" + studentId + "#" + parts[3] + "#" + parts[4];
                    if (!enrollmentIds.contains(enrollmentId)) {
                        enrollments.add(new Enrollment(courseId, studentId, parts[3], parts[4]));
                        enrollmentIds.add(enrollmentId);
                    }
                }
            }
        }

        // Reverse the order of courses
        Collections.reverse(courses);

        // Print reversed courses
        for (Course course : courses) {
            System.out.println(course);
        }

        // Print students in the order they were added
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort enrollments by course ID and then by student ID
        enrollments.sort((e1, e2) -> {
            int courseCompare = e1.getCourseId().compareTo(e2.getCourseId());
            return courseCompare != 0 ? courseCompare : e1.getStudentId().compareTo(e2.getStudentId());
        });

        // Print sorted enrollments
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        scanner.close();
    }
}
=======
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();
        List<String> errors = new ArrayList<>();
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;
             
            String[] parts = line.split("#");
            if (parts.length == 0) continue;
                             
            switch (parts[0]) { 
                case "course-add":
                    if (parts.length == 5) {
                        try {
                            String code = parts[1];
                            String name = parts[2];
                            int credits = Integer.parseInt(parts[3]);
                            String instructor = parts[4];
                            courses.add(new Course(code, name, credits, instructor));
                        } catch (NumberFormatException e) {
                            errors.add("Invalid credit value for course: " + parts[3]);
                        }
                    } else {
                        errors.add("Invalid number of arguments for course-add.");
                    }
                    break;
                
                case "student-add":
                    if (parts.length == 5) {
                        try {
                            String id = parts[1];
                            String name = parts[2];
                            int age = Integer.parseInt(parts[3]);
                            String major = parts[4];
                            students.add(new Student(id, name, age, major));
                        } catch (NumberFormatException e) {
                            errors.add("Invalid age value for student: " + parts[3]);
                        }
                    } else {
                        errors.add("Invalid number of arguments for student-add.");
                    }
                    break;
                
                case "enrollment-add":
                    if (parts.length == 5) {
                        try {
                            String courseCode = parts[1];
                            String studentId = parts[2];
                            String enrollmentDate = parts[3];
                            String status = parts[4];
                            
                            boolean courseExists = courses.stream().anyMatch(c -> c.getCode().equals(courseCode));
                            boolean studentExists = students.stream().anyMatch(s -> s.getId().equals(studentId));
                            
                            if (!courseExists) {
                                throw new InvalidCourseException(courseCode);
                            } else if (!studentExists) {
                                throw new InvalidStudentException(studentId);
                            } else {
                                enrollments.add(new Enrollment(courseCode, studentId, enrollmentDate, status));
                            }
                        } catch (InvalidCourseException | InvalidStudentException e) {
                            errors.add(e.getMessage());
                        }
                    } else {
                        errors.add("Invalid number of arguments for enrollment-add.");
                    }
                    break;
                
                default:
                    errors.add("Unknown command: " + parts[0]);
            }
        }
        
        // Cetak error terlebih dahulu
        errors.forEach(System.out::println);
        
        // Urutkan courses berdasarkan kode
        courses.stream().sorted(Comparator.comparing(Course::getCode)).forEach(System.out::println);
        
        // Urutkan students berdasarkan ID
        students.stream().sorted(Comparator.comparing(Student::getId)).forEach(System.out::println);
        
        // Urutkan enrollments
        enrollments.stream().sorted(Comparator.comparing(Enrollment::getCourseCode).thenComparing(Enrollment::getStudentId))
            .forEach(e -> System.out.println(e + " |None"));
        
        scanner.close();
    }
}
>>>>>>> 2e76e852c45c4a33ada86b47e411df6d309749a9
