package academic.driver;

import academic.model.Course;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Course[] courses = new Course[100]; // Array untuk menyimpan courses, maksimal 100
        int count = 0;
  
        while (true) {  
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }  
 
            String[] parts = input.split("#");
            if (parts.length == 4) {
                String code = parts[0];
                String name = parts[1];
                int credits = Integer.parseInt(parts[2]);
                String grade = parts[3];

                courses[count] = new Course(code, name, credits, grade);
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.println(courses[i]);
        }

        scanner.close();
    }
}
