package com.mycompany.skytrack_menu;


// here i import scanner and the array to use them for the student and scanner for when people input into the menu
import java.util.ArrayList;
import java.util.Scanner;



public class SkyTrack_Menu {
    // here i declare the new instance of the scanner and array for student
    private static ArrayList<Student> studentList = new ArrayList <>();
    private static Scanner scanner = new Scanner(System.in);
    
    
    
    public static void main(String[] args) {
     
     //here the choice starts at 0   
     int choice = 0;  
        
     // this is a loop that displays what the Main Menu looks like
     while (choice != 7) {
         System.out.println("\n===============================");  
         System.out.println("        Sky Tracker Menu         ");
         System.out.println("=================================");
         System.out.println("1. Register Student");
         System.out.println("2. View Student Profile");
         System.out.println("3. Log Flight Hours");
         System.out.println("4. Update Theory Score");
         System.out.println("5. View Progress Report");
         System.out.println("6. View Remaining Flight Hours");
         System.out.println("7. Exit");
         System.out.print("\nEnter your choice: ");
        
        //this is here to help prevent a bug from when text is read after a number, as the enter input is kept stored in memory, ill write scanner.nextLine() to help prevent it 
        choice = scanner.nextInt();
        scanner.nextLine();
          
        //now i use a switch statement to help me actually cycle between each choice
        switch (choice) {
           case 1:
             registerStudent();
             break;
           case 2: 
             ViewStudentProfile();
             break;
          case 3: 
             LogFlightHours();
             break;
          case 4: 
             UpdateTheoryScore();
             break;   
          case 5: 
             ViewProgressReport();
             break;   
          case 6: 
             ViewRemainingFlightHours();
             break;   
          case 7: 
              System.out.println("Exiting the System, Goodbye!");
             break;   
          default:
              System.out.println("Please choose between 1-7, try again.");
         // here this catches if anything besides 1-7 is picked  
             
             
             
     }
   }
 }




//==========================================================================
//=======================METHODS FOR THE MENU TO RUN========================
//==========================================================================

    //heres the first option for the menu where we register Studets
    private static void registerStudent(){
      
        System.out.println("Enter Student Name: ");
        String name = scanner.nextLine();
        
    // now we use validation if letters werent used to show an error   
        if (!name.matches("[a-zA-Z ]+")){ //this checks for if numbers are between a -z and if any spaces are used with the + outside 
            System.out.println("PLease use letters and use spaces as well");
            return;
            }
        
        System.out.println("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();//i put this here to prevent a bug for numbers to text for the scanner
        
        System.out.println("Enter Contact Number: ");
        String contact = scanner.nextLine();
    // here we check that it contains numbers only
       if (!contact.matches("\\d+")){ //the \\d checks for any digits between 0-9 and the + with that checks the entire string if theres only digits inside the input, i put this here to follow the validation rules requested
           System.out.println("Must be numbers for contacts only");
           return;
           
       }    
    // this will keep info on if the student is doing the cpl or ppl course for later use in the code
        System.out.println("Select the programme of the Student");
        System.out.println("1. PPL");
        System.out.println("2. CPL");
        System.out.println("Choice?: ");
        int ProgrammeChoice = scanner.nextInt();
        
        
        
        System.out.println("Enter flight hours done: ");
        double hours = scanner.nextDouble();
        scanner.nextLine(); //this helps prevent a bug if a negative was put in and then you are returned to the menu
         if (hours < 0){
             System.out.println("Flight hours cant be negative!");
             return;
             
         }

        System.out.println("Enter Theory Score: ");
        double score = scanner.nextDouble();
         if (score < 0 || score > 100){ //here i made sure it checks whether the score falls in the excpected range of 0-100
           System.out.println("Score has to between 0 and 100!");
           return;
           
           
    }
    
    // here i wil use polymorphism to check wether the student is a ppl or a cpl and use it later for when we view the students hours or CRI
        Student newStudent;
        switch (ProgrammeChoice) {
            case 1:
                newStudent = new PPLStudent (name, age, contact, hours, score);
                break;
            case 2:
                newStudent = new CPLStudent (name, age, contact, hours, score);
                break;
            default:
                System.out.println("Please select between 1 and 2");
                return;
        }
    
    
        studentList.add(newStudent); //this adds a newly made student to the list i made
        System.out.println("Student registerd Successfully!");
        
        newStudent.displayProgress();//here i call the overloaded simple method frommy Student class to display a small message
  }


//=========================================================
//=======================METHOD TWO========================
//========================================================= 
  
    
    
   // here will be the second option Viewing students
    private static void ViewStudentProfile(){
        System.out.println("Enter Student's name: ");
        String name = scanner.nextLine();
        
   // i use my getter method at the end of the file to find their name through the list
        Student student = findStudentName(name);
         if (student == null){
             System.out.println("Student isnt in the system yet");
              return;
         }
   
   // here i use the newStudent and interface to display the information of the chosen student with results matching if they are ppl or cpl      
        ProgressTracker tracker = (ProgressTracker) student;
        
         System.out.println("Name              : " + student.getName()); //i call to the student class methods until theory score
         System.out.println("Age               : " + student.getAge());
         System.out.println("Contact Number    : " + student.getContactNumber());
         System.out.println("Flight Hours      : " + student.getFlightHours());
         System.out.println("Required Hours    : " + student.GetRequiredHours());
         System.out.println("Thoery Score      : " + student.getTheoryScore() + "%");
         System.out.println("Programme         : " + (student instanceof PPLStudent? "PPL" : "CPL")); //here i use the polymorhp method to determine which programme the student is part of cpl or ppl
         System.out.println("CRI               : " + String.format("%.2f", tracker.calculateCRI())); //here i call to the progress tracker interface and use its method for the appropriate sub class, i also rounded it down to 2 decimal points
         System.out.println("Ready Status      : " + tracker.getReadinessStatus()); // here i also call to the interface to determine their stauts based on the sub class
         
    }
    
    
    
//=========================================================
//=======================METHOD THREE======================
//========================================================= 
    
   //heres the third option for the menu
    private static void LogFlightHours(){
        System.out.println("Enter student name to log more hours: ");
        String name = scanner.nextLine();
       
        //i use my getter method again here to find their name in the list
        Student student = findStudentName(name);
         if (student == null){
             System.out.println("Student isnt in the system yet");
              return;
         }
        
       //here you put in the hours to add and, its with a ty catch to see if theres any negatives 
        System.out.println("Enter additional flight hours you would like to add: ");
        double moreHours = scanner.nextDouble();
        scanner.nextLine();
        
         if (moreHours < 0){
             System.out.println("No negative flight hours can exist");
             return;
         }
              
       // here the flight hours will be updated for the students in the list
        student.setFlightHours(student.getFlightHours() + moreHours);
        System.out.println("Flight hours updated successfully!");
        
              
    }
    
    
//=========================================================
//=======================METHOD FOUR========================
//========================================================= 
    
    
    
    
    
   //here is the fourth method to update the theory scores of the students
    private static void UpdateTheoryScore(){
         System.out.println("Enter Students name: ");
         String name = scanner.nextLine();
         
          Student student = findStudentName(name);
         if (student == null){
             System.out.println("Student isnt in the system yet");
              return;
         }
         
         System.out.println("Add new theory score: ");
         double newScore = scanner.nextDouble();
         scanner.nextLine(); //to prevent a bug when adding text after numbers
         
         
         if (newScore < 0 || newScore > 100){ //here i wrote for the fact that the score must still be between 0-100 
             System.out.println("Score must be between 0 and 100");
             return;
         }
         
         student.setTheoryScore(newScore); //here i just updated the newly changed score in the student instance
         System.out.println("Theory score updatted successfully");
         
     }
     
    
//=========================================================
//=======================METHOD FIVE========================
//=========================================================     
    
    
    
    //now i add the fith option
    private static void ViewProgressReport(){
         System.out.println("Enter the Students name: ");
         String name = scanner.nextLine();
         
         Student student = findStudentName(name);
         if (student == null){
             System.out.println("Student isnt in the system yet");
              return;
         }
        
     //i use the overloaded method to use the interface and display the three different readiness methods
        ProgressTracker tracker = (ProgressTracker) student;// here i basically tell java that the student relates to the tracker variable and keeps its relevant data to use for the get readiness status later down
        
        //i use the overloaded  more detailed method i made back in my student class
        student.displayProgress(tracker);
        
        //here the message gets displayed based on the status using the get readiness method
        String status = tracker.getReadinessStatus();
        switch (status) {
            case "Not Ready":
                System.out.println("Focus on accumulating flight hours and revising theory.");
                break;
            case "In Progress":
                System.out.println("Good progress. Continue practising and preparing for your certification.");
                break;
            case "Exam Ready!":
                System.out.println("Congratulations! You are ready to book your certification examination.");
                break;
            default:
                break;
        }
                
      }
    
//=========================================================
//=======================METHOD Six========================
//=========================================================     
    
    
    
    
   //now the sixth option for the menu
    private static void ViewRemainingFlightHours(){
        System.out.println("Enter Students name: ");
        String name = scanner.nextLine();
        
        Student student = findStudentName(name);
         if (student == null){
             System.out.println("Student isnt in the system yet");
              return;
         }   
         
        //i made a new variable called remainingHours which stores the difference between the amount of hours required for the student of whichever programme theyre in minus the ammount of hours the student has flown 
         double remainingHours = student.GetRequiredHours() - student.getFlightHours();
          
         if (remainingHours <= 0){ //this says if theyre ready for the exam, if they have flown more or equal to the required hours
             System.out.println("The Minimum flight hours have been achieved.");
         }
         else{
             System.out.println("The remaining flight hours required are: " + remainingHours + "hours");
         }   
       }
       

    
    
    
//here i made a getter method to find a students name in the Student list to help me not type as much in every other method 
    private static Student findStudentName(String name){
      for(Student s : studentList){ //here this basically checks the array i made foe the student name foe the other methods in the menu
        if (s.getName().equalsIgnoreCase(name)){ //here this ignores different cases, so you dont have to be spot on with spelling
            return s;
             }
           }
       return null; //this returns empty if no student by that name exists
    }
        
       

       




}
