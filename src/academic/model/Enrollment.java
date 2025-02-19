package academic.model;

<<<<<<< HEAD

import java.util.Objects;

public class Enrollment {
    private String courseId;
=======
public class Enrollment {
    private String courseCode;
>>>>>>> 2e76e852c45c4a33ada86b47e411df6d309749a9
    private String studentId;
    private String academicYear;
    private String semester;

<<<<<<< HEAD
    // Constructor, getters, and setters

    public Enrollment(String courseId, String studentId, String academicYear, String semester) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
    }
    

    public String getCourseId() {
        return courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Enrollment enrollment = (Enrollment) obj;
        return courseId.equals(enrollment.courseId) && studentId.equals(enrollment.studentId) &&
               academicYear.equals(enrollment.academicYear) && semester.equals(enrollment.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, studentId, academicYear, semester);
=======
    public Enrollment(String courseCode, String studentId, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
    } 
  
    public String getCourseCode() {
        return courseCode;
    }  
      
    public String getStudentId() {
        return studentId;
    }   

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
>>>>>>> 2e76e852c45c4a33ada86b47e411df6d309749a9
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return courseId + "|" + studentId + "|" + academicYear + "|" + semester + "|None";
=======
        return courseCode + "|" + studentId + "|" + academicYear + "|" + semester + "|None";
>>>>>>> 2e76e852c45c4a33ada86b47e411df6d309749a9
    }
}