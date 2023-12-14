package com.whhs.boba_tea_creator;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
//purpose of class is to have rectangle be called 48 times to make the 48 grid slots from Grid.java.

public class Rectangles {
  
  //fields
  //The arraylist will keep track of all the rectangles created in the for loop in order for me to access them and store them nicely. 
  public static ArrayList<Unit> gridRectangles = new ArrayList<Unit>();
  
  //Grid X and Y represent the start coordinates of the rectangle which will vary depending on     what i is at in the for loop.
  private int gridRectX = 137;
  private int gridRectY = 9;
  
  //Creating an object from Unit.java to put into my for loop.
  private Unit unitConstruction;
  
  //constructor
  public Rectangles() {
    
    //creating Unit.java 48 times.
    for (int i = 1; i < 49; i++){
      
    //if a new row starts then move Y value accordingly. Reset X to begin at the begining to the     inital X
    if(i == 9 || i == 17 || i == 25 || i == 33 || i == 41){
    //<3 <3
      gridRectY += 49;
      gridRectX = 137;
      
      unitConstruction = new Unit(gridRectX, gridRectY);
      
      //adding to arrayList
      gridRectangles.add(unitConstruction);
      
      //moving the rectangle X
      gridRectX += 38;
      } else {
      //(x coord, y coord, width, height)
      unitConstruction = new Unit(gridRectX, gridRectY);
      //adding to arrayList
      gridRectangles.add(unitConstruction);
      //moving the rectangle's X
      gridRectX += 38;
      }
    }
    System.out.println("HELLO Rectangles");
  }
  //methods
 
}
