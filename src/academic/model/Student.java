package academic.model;

<<<<<<< HEAD
/**
 * @autor 12S23004 Fernando Alexander Silitonga
 * @autor 12S23044 Gracia Pardede
 */

import java.util.Objects;

public class Student {
    private String id;
    private String name;
    private int year;
    private String major;
    

    // Constructor, getters, and setters

    public Student(String id, String name, int year, String major) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + year + "|" + major;
    }
}
=======
public class Student {
    private String id;
    private String name;
    private int tahun;
    private String prodi;

    public Student(String id, String name, int tahun, String prodi) {
        this.id= id;
        this.name = name;
        this.tahun = tahun;
        this.prodi = prodi; 
    }
  public String getId() {
        return id;
    }   
    public void setId(String id) {
        this.id = id; 
    }     
    public String getName() {
        return name;
    } 
    public void setName(String name) {
        this.name = name;
    }
    public int getTahun() {
        return tahun;
    }
    public void setTahun(int tahun) {
        this.tahun = tahun;
    }
    public String getProdi() {
        return prodi;
    }

    public static class InvalidStudentException extends Exception {
    public InvalidStudentException(String studentId) {
        super("invalid student|" + studentId);
    }
} 

    @Override   
    public String toString() {
        return id + "|" + name + "|" + tahun + "|" + prodi;
    }   
} 
>>>>>>> 2e76e852c45c4a33ada86b47e411df6d309749a9
