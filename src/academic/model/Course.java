package academic.model;

<<<<<<< HEAD
import java.util.Objects;

public class Course {
    private String id;
    private String name;
    private int credits;
    private String grade;
    

    // Constructor, getters, and setters

    public Course(String id, String name, int credits, String grade) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
        
    }

    public String getId() {
        return id;
    }

    public int getCreditHours() {
        return credits;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return id.equals(course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    
    @Override
    public String toString() {
        return id + "|" + name + "|" + credits + "|" + grade;
=======
public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade;

    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }  
 
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }
   
    public static class InvalidCourseException extends Exception {
    public InvalidCourseException(String courseCode) {
        super("invalid course|" + courseCode);
    }      
}     
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
>>>>>>> 2e76e852c45c4a33ada86b47e411df6d309749a9
    }
}