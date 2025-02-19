package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver1 {
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

            // Menambahkan kursus
            if (command.equals("course-add") && parts.length == 5) {
                // Periksa apakah kursus sudah ada berdasarkan kode kursus
                boolean courseExists = false;
                for (Course course : courses) {
                    if (course.getCode().equals(parts[1])) {
                        courseExists = true;
                        break;
                    }
                }
                if (!courseExists) {
                    courses.add(new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                } else {
                    System.out.println("Kursus dengan kode " + parts[1] + " sudah ada.");
                }
            } 
            // Menambahkan mahasiswa
            else if (command.equals("student-add") && parts.length == 5) {
                // Periksa apakah mahasiswa sudah ada berdasarkan ID mahasiswa
                boolean studentExists = false;
                for (Student student : students) {
                    if (student.getId().equals(parts[1])) {
                        studentExists = true;
                        break;
                    }
                }
                if (!studentExists) {
                    students.add(new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                } else {
                    System.out.println("Mahasiswa dengan ID " + parts[1] + " sudah ada.");
                }
            } 
            // Menambahkan pendaftaran
            else if (command.equals("enrollment-add") && parts.length == 5) {
                // Periksa apakah pendaftaran sudah ada untuk kursus, mahasiswa, dan tahun akademik yang sama
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
                } else {
                    System.out.println("Pendaftaran untuk kursus " + parts[1] + " oleh mahasiswa " + parts[2] +
                            " pada tahun akademik " + parts[3] + " sudah ada.");
                }
            }
        }

        // Menampilkan data yang telah dimasukkan
      
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
