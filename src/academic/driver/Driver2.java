package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import academic.model.Course.InvalidCourseException;
import academic.model.Student.InvalidStudentException;
import java.util.*;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
