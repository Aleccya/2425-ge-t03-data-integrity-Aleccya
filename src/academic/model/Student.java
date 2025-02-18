package academic.model;

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
