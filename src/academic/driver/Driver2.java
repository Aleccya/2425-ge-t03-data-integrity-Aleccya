package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.*;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;
            
            String[] parts = line.split("#");
            if (parts.length == 0) continue;
            
            switch (parts[0]) {
                case "course-add":
                    if (parts.length == 5) {
                        courses.add(new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                    }
                    break;
                
                case "student-add":
                    if (parts.length == 5) {
                        students.add(new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                    }
                    break;
                
                case "enrollment-add":
                    if (parts.length == 5) {
                        boolean courseExists = courses.stream().anyMatch(c -> c.getCode().equals(parts[1]));
                        boolean studentExists = students.stream().anyMatch(s -> s.getId().equals(parts[2]));
                        
                        if (!courseExists) {
                            System.out.println("invalid course|" + parts[1]);
                        } else if (!studentExists) {
                            System.out.println("invalid student|" + parts[2]);
                        } else {
                            enrollments.add(new Enrollment(parts[1], parts[2], parts[3], parts[4]));
                        }
                    }
                    break;
            }
        }
        
        courses.forEach(System.out::println);
        students.forEach(System.out::println);
        enrollments.forEach(System.out::println);
        
        scanner.close();
    }
}
