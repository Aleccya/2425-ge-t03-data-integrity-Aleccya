package academic.model;

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
    }
}