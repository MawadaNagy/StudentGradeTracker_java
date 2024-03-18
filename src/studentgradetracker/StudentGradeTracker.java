
package studentgradetracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class StudentGradeTracker {
    private static final String teachers_password = "teacher";
    private static final int NoOfAttempts = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Are you a teacher? (yes/no)");
        String userType = sc.next().toLowerCase();
        
        if(!userType.equals("yes")){
            System.out.println("Access Denied!, Accessable only by Teachers.");
            return;
        }
        
        int attempts = 0;
        boolean authenticated = false;
        while(attempts<NoOfAttempts){
            System.out.println("Enter the password: ");
            String pass = sc.next();

            if(!pass.equals(teachers_password)){
                attempts++;
                if(attempts<NoOfAttempts){
                    System.out.println("Incorrect Password. Try Again."); 
                }else{
                    System.out.println("Access Denied!");
                    return;
                }
            }else{
                authenticated = true;
                break;
            } 
        }
        
        if(!authenticated){
            System.out.println("Access Denied!");
            return;
        }
        
        
        ArrayList<Integer> grades = new ArrayList<>();
        
        System.out.println("Enter number of students: ");
        int num = sc.nextInt();
        
//        System.out.println("Enter the grades of the " + num + "students: ");
        for(int i = 0; i < num; i++){
            System.out.println("Enter the grades of the " + (i + 1) + " students: ");
            int grade = sc.nextInt();
            grades.add(grade);
        }
        
        String average = AverageGrade(grades);
        int highest = HighestGrade(grades);
        int lowest = LowestGrade(grades);
        
        System.out.println("The Average Grade is: " + average);
        System.out.println("The Highest Grade is: " + highest);
        System.out.println("The Lowest Grade is: " + lowest);
    }
    
    public static String AverageGrade(ArrayList<Integer> grades){
        int sum = 0;
        for(int grade : grades){
            sum += grade;
        }
        double average  = (double) sum/grades.size();
        
        if(average == (int) average){
            return String.valueOf((int) average);
        }else{
            return String.format("%.2f", average);
        }
    }
    
    public static int HighestGrade(ArrayList<Integer> grades){
        return Collections.max(grades);
    }
    
    public static int LowestGrade(ArrayList<Integer> grades){
        return Collections.min(grades);
    }
    
}
