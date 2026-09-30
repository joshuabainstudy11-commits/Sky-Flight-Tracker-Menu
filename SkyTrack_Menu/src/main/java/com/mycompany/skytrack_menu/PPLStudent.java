
package com.mycompany.skytrack_menu;

//here this subclass PPLStudent inherits from the student class, using extends, and will use the methods of the interface ProgressTracker, by using implements
public class PPLStudent extends Student implements ProgressTracker {
   
  public PPLStudent (String name, int age, String contactNumber, double flightHours, double theoryScore){
   super (name, age, contactNumber, flightHours, theoryScore);
  }
   
  
  //here we add the methods from the other classes and interface to use it through inheritance in the PPLStudent class
  @Override //i use overide to basically modify the method to function how i want it to for the cpl and ppl classes
  public double GetRequiredHours(){
   return 45; //its 45 as thats the ammount needed for the PPl students
  
  }
  
  
  //heres the maths formula needed to caluculate the CRI and to use for later on in the menu
  
  //i had to use the getters here as it was private in the student class
  @Override
   public double calculateCRI(){
    return ((getFlightHours() / GetRequiredHours()) * 50) + ((getTheoryScore() / 100.00) * 50); 
  
    }
  
   // here i use and if statement to determine what level of readiness they are at based on their score calculated above
  @Override
   public String getReadinessStatus(){
    double CRI = calculateCRI();
    if (CRI < 40) {
    return "Not Ready";
    }
    
    else if (CRI < 75){
    return "In Progress";
    }
    
    else {
    return "Exam Ready!";
    }
  
  }





}
