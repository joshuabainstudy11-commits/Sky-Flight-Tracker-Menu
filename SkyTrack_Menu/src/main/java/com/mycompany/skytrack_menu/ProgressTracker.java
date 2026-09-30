//here is where i make my interface for the classes
package com.mycompany.skytrack_menu;

public interface ProgressTracker {
  double calculateCRI(); //used by the ppl and cpl sub classes
  String getReadinessStatus(); //i need these here as the results of the methods depend on the values within each different subclass, eg needing 45 hours over 200
}


