
package com.mycompany.skytrack_menu;
//now ill make the abstract class so that the sub classes can use the attributes of the student class but with their own distinct attributes as well
public abstract class Student {
   
   //here i'll make the attributes private to help with encapuslating the classes variables
   private String name;
   private int age;
   private String contactNumber;
   private double flightHours;
   private double theoryScore; 
   
   
//======================================= 
//==========Constructer=================
//=======================================
  

   //here i use a constructor to instantiate the variables of the student class
   public Student(String name, int age, String contactNumber, double flightHours, double theoryScore){
   this.name = name; //i use this to tell java im refering to this specific name and age ect
   this.age = age;
   this.contactNumber = contactNumber;        
   this.flightHours = flightHours;        
   this.theoryScore = theoryScore;        
   }
  
   
  //======================================= 
  //==========Getters and Setters==========
  //======================================= 
   
   
   
//here ill write my getters and setters to be able to access the variables that are private later
//the getters that i wrote here are for when the methods need to access the attributes of the private abstract class student   
   public String getName(){
     return name;
   }
 //this setter is here so only the student class can update or alter the values of itself, this applies to all below this one  
   public void setName(String name){
     this.name = name;
   }
   
   
   public int getAge(){
     return age;
   }
   
   public void setAge(int age){
     this.age = age;
   }
   
   
   public String getContactNumber(){
     return contactNumber;
   }
   
   public void setContactNumber(String contactNumber){
     this.contactNumber = contactNumber;
   }
   
   
   public double getFlightHours(){
     return flightHours;
   }
  
   public void setFlightHours(double flightHours){
     this.flightHours = flightHours;
   }
   
  
   public double getTheoryScore(){
     return theoryScore;
   }
   
    public void setTheoryScore(double theoryScore){
     this.theoryScore = theoryScore;
   }
   
   
//======================================= 
//==========Abstract method==========
//=======================================   
   
  //this is the abstract method to get the flight hours for the subclasses 
     public abstract double GetRequiredHours();
     
           
     
     
//======================================= 
//==========Overloaded method==========
//=======================================    
     
     
   
 // here i will i create a method to display method overloading, one will be rather simple and the other will show a more detailed method, using a parameter  
   
 //this is a simple method for showing the students name and that their progress is being tracked    
    public void displayProgress(){ // i will use this simple one to display after registering a student, and this message eill display
        System.out.println("Student: " + getName());
        System.out.println("Students Progres:  they'just been registerd! Select any other option to view their info in more detail " );
    
    }
   
  //this is the more detailed method to display the name and the CRI, alongside the readiness status, the way this is method overloading due to the paramater using the progress tracker interface
    public void displayProgress(ProgressTracker tracker){  // here i named the parameter to call later, tracker
        System.out.println("Student : " + getName());
        System.out.println("CRI : " + String.format("%.2f", tracker.calculateCRI())); // //here it will show the method for the CRI, i formated it into a string and round it to 2 decimal points
        System.out.println("Status : " + tracker.getReadinessStatus()); //here it will show the interfaces method for the readiness status
        
    
    }
   
   
   
   
   
}
