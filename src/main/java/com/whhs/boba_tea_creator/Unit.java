package com.whhs.boba_tea_creator;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import java.util.ArrayList;

//Create one singluar rectangle
//create gridrectangles array list to create all the rectangles in a for loop
//Cookie cutter for creating a rectangle.

public class Unit {
  //fields
  //creating a rectangle object.
  private Rectangle gridRect;
  //boolean that checks if the rectangle is selected
  private boolean isSelected;
  //int counting number of rectangles selected (will be the same for any unit creation)
  private static int selectedCount = 0;
  //variables that are x and y to set where the ingredient's x and y will be 
  private double ingredientSpawnX;
  private double ingredientSpawnY;
  //creating a custom color for selected rectangles
  private static Color selectedColor = Color.rgb(250, 252, 210, 0.5);
  //boolean that checks if rectangle is filled with an ingredient
  private boolean isFilledIngredient;
  //String that holds what specific ingredient is inside the rectangle
  private String ingredientInside;
  //numUnits keeps track of how many units are created
  public static int numUnits = 0;
  //rectanglesIndex is the index of the rectangle in the arraylist
  private int rectanglesIndex;
  //variable that counts how many ingredients are on the grid
  private static int ingredientsPlaced = 0;
  //each rectangle needs to account for what ingredient is placed inside it and what index that ingredient is.
  private int ingredientInsideIndex;
  //ints represent index from each ingredient's arrayList
  private int cupInsideRectangleIndex = 0;
  private int teaInsideRectangleIndex = 0;
  private int bobaInsideRectangleIndex = 0;
  
  //constructor
  public Unit(int rectX, int rectY) {
    
    //creating initizating the rectangle object
    gridRect = new Rectangle(rectX, rectY, 35, 47);
      
    //coloring and adding to root
    gridRect.setFill(Color.TRANSPARENT);
    gridRect.setStroke(Color.BLACK);
    App.root.getChildren().addAll(gridRect);

    //initizalizing isSelected
    isSelected = false;

    //initizaling rectanglesIndex because the index starts at 0 it offsets the modulus operator that verifies     if a rectangle is the edge rectangles
    rectanglesIndex = numUnits;
    //increaing numUnits each time Unit is created
    numUnits++;

    //initializing isFilledIngredient
    isFilledIngredient = false;
    //calling method that checks if mouse presses on a rectangle
    rectangleMouseInput();
    rectangleKeyInput();
  }

  //methods
  //method that checks if mouse presses on a rectangle
  public void rectangleMouseInput(){
      //creating a lambda expression that checks if mouse presses on a rectangle
      gridRect.setOnMousePressed((MouseEvent me) -> {
        
        //if statement unselects and uncolors the rectangle
        if(isSelected == true){

          //changing color
          
          gridRect.setFill(Color.TRANSPARENT);

          //altering isSelected to false

          isSelected = false;

          //updating the count of selected rectangles

          selectedCount--;

        } else if(selectedCount == 0 && isSelected == false){ //the purpose of this is to make sure another rectangle from units is not selected
          
      //changing color
      gridRect.setFill(selectedColor);
      
      //changing boolean
          
      isSelected = true;

      //updating the count of selected rectangles
      
      selectedCount++;

      //initializing ingredientSpawnX and ingredientSpawnY
      ingredientSpawnX = (gridRect.getX() + 5);
      ingredientSpawnY = (gridRect.getY() - 5);
      } else {

          //Verifiying that another rectangle is not selected
          
          System.out.println("Code is working at Unit 94");
      }
    });
  }

  //this method checks if the user has pressed enter which will move the ingredient selected to the selected recctangle
  public void rectangleKeyInput(){
    
    //creating lamdda expression that checks if the user has pressed enter
    App.playScene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
      //enter key pressed
      if(key.getCode() == KeyCode.ENTER && isSelected && !isFilledIngredient){
        System.out.println(isSelected + "from 110 is selected");
        //if statement that checks if the rectangle is selected
        if(isSelected == true){
          //ingredient 
          //creating a switch statement to move each ingredient when it is the selected ingredient
          int selectedIngredient = App.userInterfaceOne.getSelectedIngredient();
          switch(selectedIngredient) {
              
            case 0:
              //tea pitcher
              System.out.println("I am a tea pitcher");

              //setting the x and y of the ingredient in user interface and increasing index count
              TeaPitcher.teaPitchers.get(TeaPitcher.currentTeaIndex).getTeaImageView().setX(ingredientSpawnX);
                  TeaPitcher.teaPitchers.get(TeaPitcher.currentTeaIndex).getTeaImageView().setY(ingredientSpawnY);
              TeaPitcher.teaPitchers.get(TeaPitcher.currentTeaIndex).getTeaImageView().toFront();
              //setting the rectangle's ingredientInsideIndex equal to the current ingredient index that way each rectangle keeps track of what index the ingredient inside it is
              ingredientInsideIndex = TeaPitcher.currentTeaIndex; //App.userInterfaceOne.getTeaOne().getTeaIndex());
              ingredientInside = "Tea Pitcher";
              System.out.println(ingredientInsideIndex + " ingredientInsideIndex 139");
              //increasing the ingredient index
              TeaPitcher.currentTeaIndex++;
            break;
              
            case 1:
              //cup
              System.out.println("I am a cup");

              //setting the x and y of the ingredient in user interface and increasing index count
              Cup.cups.get(Cup.currentCupIndex).getCupShapeImageView().setX(ingredientSpawnX);
              Cup.cups.get(Cup.currentCupIndex).getCupShapeImageView().setY(ingredientSpawnY);
              Cup.cups.get(Cup.currentCupIndex).getCupShapeImageView().toFront();
              ingredientInsideIndex = Cup.currentCupIndex; 
              System.out.println(ingredientInsideIndex + " incredientInsideIndex 153");
              ingredientInside = "Cup";
              System.out.println("I have increased cup index");
              Cup.currentCupIndex++;
            break;
              
            case 2:
              //boba
              System.out.println("I am boba");

              //setting the x and y of the ingredient in user interface and increasing index count
              Boba.bobas.get(Boba.currentBobaIndex).getBobaImageView().setX(ingredientSpawnX);
              Boba.bobas.get(Boba.currentBobaIndex).getBobaImageView().setY(ingredientSpawnY);
              Boba.bobas.get(Boba.currentBobaIndex).getBobaImageView().toFront();
              ingredientInsideIndex = Boba.currentBobaIndex;
              System.out.println(ingredientInsideIndex + " ingredientInsideIndex 168");
              ingredientInside = "Boba";
              System.out.println("I have increased boba index");
              Boba.currentBobaIndex++;
            break;
              
            default:
              //default case
              System.out.println("Error");
            break;
              
          }  
          //automatically unselected the selected rectangle that the ingredient is placed into

          gridRect.setFill(Color.TRANSPARENT); //coloring properly

          isSelected = false; //changing boolean

          selectedCount--;  //reducing selected count (should be 0)

          //once an ingredient is placed on the grid the counter goes up
          ingredientsPlaced++;

          //setting isFilledIngredient to true bc an ingredient has entered the rectangle
          isFilledIngredient = true;

          App.userInterfaceOne.userInterfaceInteractions();

            bobaTeaChecker();
          
        } else if (isSelected == false) {
          System.out.println("isSelected: " + isSelected);
          System.out.println("Unit 123");
        } else {
          System.out.println("isSelected: " + isSelected);
          System.out.println("Unit 127");
        }
      }
    });
  }
  public void bobaTeaChecker() {
      System.out.println("bobaTeaChecker is active");
      //Creating an arrayList of ingredients to compare to
      ArrayList<String> bobaTeaIngredients = new ArrayList<String>();
      bobaTeaIngredients.add("Tea Pitcher");
      bobaTeaIngredients.add("Cup");
      bobaTeaIngredients.add("Boba");
  
      //ints represent the indexes for the arrayList gridRectangles
      int topIndex = rectanglesIndex - 8;
      int leftIndex = rectanglesIndex - 1;
      int rightIndex = rectanglesIndex + 1;
      int bottomIndex = rectanglesIndex + 8;
      int topTopIndex = rectanglesIndex - 16;
      int bottomBottomIndex = rectanglesIndex + 16;
      int leftLeftIndex = rectanglesIndex - 2;
      int rightRightIndex = rectanglesIndex + 2;
      int placedIngredientIndex = rectanglesIndex;
      //Strings accesses what element is removed
      String firstRemoval = "";
      String secondRemoval = "";
      String thirdRemoval = "";
  
      //int represents the index for bobaTeaIngredients
      int i = 0;

      //loops through the gridRectangles arrayList to access each rectangle
      for (int j = 0; j < 48; j++) {
        if (placedIngredientIndex % 7 == 0 || placedIngredientIndex % 8 == 7 || placedIngredientIndex == 0 || placedIngredientIndex % 8 == 0) {
            System.out.println("Ingredient is placed on edge");
            //while statement runs three times to identify if ingredientInside matches an element from boba tea ingredients list.
            while (bobaTeaIngredients.size() == 3){
              //if there is no ingredient inside the rectangle the loop will go to the next iteration
              if (Rectangles.gridRectangles.get(j).ingredientInside == null) {
                continue;
              }
              //if statement runs through each element in bobaTeaIngredient
              if (Rectangles.gridRectangles.get(j).ingredientInside.equals(bobaTeaIngredients.get(i))) {
                switch (i) {
                  case 0:
                    teaInsideRectangleIndex = Rectangles.gridRectangles.get(j).ingredientInside;
                    System.out.println(teaInsideRectangleIndex + " Tea inside Rectangle Index (placed)");
                    break;
                  case 1:
                    cupInsideRectangleIndex = Rectangles.gridRectangles.get(j).ingredientInside;
                    System.out.println(cupInsideRectangleIndex + " cup inside Rectangle Index (placed)");
                    break;
                  case 2:
                    bobaInsideRectangleIndex = Rectangles.gridRectangles.get(j).ingredientInside;
                    System.out.println(bobaInsideRectangleIndex + " boba inside Rectangle Index (placed)");
                    break;
                  default:
                    System.out.println("Cannot set ingredient inside rectanlge index (placed)");
                    break;
                }
                firstRemoval = bobaTeaIngredients.remove(i);
                //bobaTeaIngredients.remove(i);
                System.out.println(firstRemoval + " first Removal");
                System.out.println(bobaTeaIngredients);
              }
              //increasing i to check next element in bobaTeaIngredients
              i++;
            }
            i = 0;
          //stops if there is no ingredientInside top index
          if (Rectangles.gridRectangles.get(topIndex).ingredientInside == null) {
            continue;
          }
            //waits to run until ingredientsPlaced = 2 to run
            while (bobaTeaIngredients.size() == 2) {
            //if statement takes in account what ingredient has been removed first
              try {
                if (firstRemoval == "Cup"){
                  //if statement stops the loop if a top index does not exist
                  if (topIndex < 0) {
                    continue;
                  }
                  //if statement runs through each element in bobaTeaIngredient
                    if (Rectangles.gridRectangles.get(topIndex).ingredientInside.equals(bobaTeaIngredients.get(i))) {
                      System.out.println("Top Index: " + topIndex);
                      switch (i) {
                        case 0:
                          teaInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                          System.out.println(teaInsideRectangleIndex + " Tea inside Rectangle Index (top)");
                          break;
                        case 1:
                          bobaInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                          System.out.println(bobaInsideRectangleIndex + " boba inside Rectangle Index (top)");
                          break;
                        default:
                          System.out.println("Cannot set ingredient inside rectanlge index (top)");
                          break;
                      }
                      secondRemoval = bobaTeaIngredients.remove(i);
                      System.out.println(secondRemoval + " second removal");
                      //bobaTeaIngredients.remove(i);
                      System.out.println(bobaTeaIngredients);
                    }
                  //increasing i to check next element in bobaTeaIngredients
                  i++;
              }
                if (firstRemoval == "Tea Pitcher"){
                  //if statement moves to the next iteration of the loop if a top index does not exist
                  if (topIndex < 0) {
                    continue;
                  }
                  //if statement runs through each element in bobaTeaIngredient
                  System.out.println(topIndex + " top Index 316");
                  System.out.println(bobaTeaIngredients.get(i) + " bobaTeaIngredients i 317");
                  System.out.println(i + " i 318");
                  if (Rectangles.gridRectangles.get(topIndex).ingredientInside.equals(bobaTeaIngredients.get(i))) {
                    System.out.println("Top Index: " + topIndex);
                    switch (i) {
                      case 0:
                        cupInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                        System.out.println(cupInsideRectangleIndex + " cup inside Rectangle Index (top)");
                        break;
                      case 1:
                        bobaInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                        System.out.println(bobaInsideRectangleIndex + " boba inside Rectangle Index (top)");
                        break;
                      default:
                        System.out.println("Cannot set ingredient inside rectanlge index (top)");
                        break;
                    }
                    secondRemoval = bobaTeaIngredients.remove(i);
                    System.out.println(secondRemoval + " second removal");
                    System.out.println(bobaTeaIngredients);
                  }
                  //increasing i to check next element in bobaTeaIngredients
                  i++;
                }
                if (firstRemoval == "Boba") {
                //if statement stops the loop if a top index does not exist
                if (topIndex < 0) {
                  break;
                }
                //if statement runs through each element in bobaTeaIngredient
                if (Rectangles.gridRectangles.get(topIndex).ingredientInside.equals(bobaTeaIngredients.get(i))) {
                  System.out.println("Top Index: " + topIndex);
                  switch (i) {
                    case 0:
                      teaInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(teaInsideRectangleIndex + " Tea inside Rectangle Index (top)");
                      break;
                    case 1:
                      cupInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(cupInsideRectangleIndex + " cup inside Rectangle Index (top)");
                      break;
                    default:
                      System.out.println("Cannot set ingredient inside rectanlge index (top)");
                      break;
                  }
                  secondRemoval = bobaTeaIngredients.remove(i);
                  System.out.println(secondRemoval + " second removal");
                  System.out.println(bobaTeaIngredients);
                }
                //increasing i to check next element in bobaTeaIngredients
                i++;
              }  
              }
              catch (ArrayIndexOutOfBoundsException e){
                System.out.println("top index equals first removal");
                i = 0;
                //moves onto the next iteration
                if(bottomBottomIndex > 49){
                  continue;
                }
                //checks if the bottom ingredient, and bottom bottom ingredient are equal to the reApping ingredients in the bobaIngredients arrayList
                if (Rectanlges.gridRectangles.get(bottomIndex).ingredientInside.equals(bobaTeaIngredients.get(i)).ingredientInside.equals(bobaIngredients.get(i))){
                  System.out.println("bottom index equals "+ boba.Ingredients.get(i));

                }
              }
            }
            i = 0;
            //waits to run until ingredientsPlaced = 3 to run
          //stops if there is no ingredientInside bottom index
          if (Rectangles.gridRectangles.get(bottomIndex).ingredientInside == null) {
            continue;
          }
          //if statement moves onto the next iteration of the loop if a bottom index does not exist
          if (Rectangles.gridRectangles.get(j).(bottomIndex) > 49) {
            continue;
          }
          while (bobaTeaIngredients.size() == 1) {
            //if statement checks to see if second removal equals first removal the loop will move onto the next iteration
            if (Rectangles.gridRectangles.get(j).secondRemoval.equals(firstRemoval)) {
              continue;
            }
            if (secondRemoval == "Cup"){
              if (Rectangles.gridRectangles.get(bottomIndex).ingredientInside.equals(secondRemoval)) {
                continue;
              }
                //if statement runs through each element in bobaTeaIngredient
                if (Rectangles.gridRectangles.get(bottomIndex).ingredientInside.equals(bobaTeaIngredients.get(i))) {
                  System.out.println("Bottom Index " + bottomIndex);
                  switch (i) {
                    case 0:
                      teaInsideRectangleIndex = Rectangles.gridRectangles.get(bottomIndex).ingredientInsideIndex;
                      System.out.println(teaInsideRectangleIndex + " Tea inside Rectangle Index (top)");
                      break;
                    case 1:
                      bobaInsideRectangleIndex = Rectangles.gridRectangles.get(bottomIndex).ingredientInsideIndex;
                      System.out.println(bobaInsideRectangleIndex + " boba inside Rectangle Index (top)");
                      break;
                    default:
                      System.out.println("Cannot set ingredient inside rectanlge index (top)");
                      break;
                  }
                  thirdRemoval = bobaTeaIngredients.remove(i);
                  System.out.println(bobaTeaIngredients);
                }
                //increasing i to check next element in bobaTeaIngredients
                i++;
            }
            if (secondRemoval == "Tea Pitcher"){
                //if statement runs through each element in bobaTeaIngredient
                if (Rectangles.gridRectangles.get(bottomIndex).ingredientInside.equals(bobaTeaIngredients.get(i))) {
                  System.out.println("Bottom Index " + bottomIndex);
                  switch (i) {
                    case 0:
                      cupInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(cupInsideRectangleIndex + " cup inside Rectangle Index (bottom)");
                      break;
                    case 1:
                      bobaInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(bobaInsideRectangleIndex + " boba inside Rectangle Index (bottom)");
                      break;
                    default:
                      System.out.println("Cannot set ingredient inside rectanlge index (bottom)");
                      break;
                  }
                  thirdRemoval = bobaTeaIngredients.remove(i);
                  System.out.println(bobaTeaIngredients);
                }
                //increasing i to check next element in bobaTeaIngredients
                i++;
            }
            if (secondRemoval == "Boba") {
                //if statement runs through each element in bobaTeaIngredient
                if (Rectangles.gridRectangles.get(bottomIndex).ingredientInside.equals(bobaTeaIngredients.get(i))) {
                  System.out.println("Bottom Index " + bottomIndex);
                  switch (i) {
                    case 0:
                      teaInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(teaInsideRectangleIndex + " Tea inside Rectangle Index (bottom)");
                      break;
                    case 1:
                      cupInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(cupInsideRectangleIndex + " cup inside Rectangle Index (bottom)");
                      break;
                    default:
                      System.out.println("Cannot set ingredient inside rectanlge index (bottom)");
                      break;
                  }
                  thirdRemoval = bobaTeaIngredients.remove(i);
                  System.out.println(thirdRemoval + "third removal 452");
                  System.out.println(bobaTeaIngredients);
                }
                //increasing i to check next element in bobaTeaIngredients
                i++;
            }
          }
        }
          else {
          while (bobaTeaIngredients.size() == 3){
            //if statement runs through each element in bobaTeaIngredient
            if (ingredientInside.equals(bobaTeaIngredients.get(i))) {
              switch (i) {
                case 0:
                  teaInsideRectangleIndex = ingredientInsideIndex;
                  System.out.println(teaInsideRectangleIndex + " Tea inside Rectangle Index (placed)");
                  break;
                case 1:
                  cupInsideRectangleIndex = ingredientInsideIndex;
                  System.out.println(cupInsideRectangleIndex + " cup inside Rectangle Index (placed)");
                  break;
                case 2:
                  bobaInsideRectangleIndex = ingredientInsideIndex;
                  System.out.println(bobaInsideRectangleIndex + " boba inside Rectangle Index (placed)");
                  break;
                default:
                  System.out.println("Cannot set ingredient inside rectanlge index (placed)");
                  break;
              }
              firstRemoval = bobaTeaIngredients.remove(i);
              System.out.println(firstRemoval + " first Removal");
              System.out.println(bobaTeaIngredients);
            }
            //increasing i to check next element in bobaTeaIngredients
            i++;
          }
          i = 0;
          //stops loop if there is less than three ingredients placed
          if (ingredientsPlaced < 3){
            break;
          }
          //stops if there is no ingredientInside top index
          if (Rectangles.gridRectangles.get(topIndex).ingredientInside == null) {
            break;
          }
          //waits to run until ingredientsPlaced = 2 to run
          if (ingredientsPlaced > 2) {
            //if statement takes in account what ingredient has been removed first
            if (firstRemoval == "Cup"){
              while (bobaTeaIngredients.size() == 2){
                //if statement stops the loop if a top index does not exist
                if (topIndex < 0) {
                  break;
                }
                //if statement runs through each element in bobaTeaIngredient
                if (Rectangles.gridRectangles.get(topIndex).ingredientInside.equals(bobaTeaIngredients.get(i))) {
                  System.out.println("Top Index: " + topIndex);
                  switch (i) {
                    case 0:
                      teaInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(teaInsideRectangleIndex + " Tea inside Rectangle Index (top)");
                      break;
                    case 1:
                      bobaInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(bobaInsideRectangleIndex + " boba inside Rectangle Index (top)");
                      break;
                    default:
                      System.out.println("Cannot set ingredient inside rectanlge index (top)");
                      break;
                  }
                  secondRemoval = bobaTeaIngredients.remove(i);
                  System.out.println(secondRemoval + " second removal");
                  //bobaTeaIngredients.remove(i);
                  System.out.println(bobaTeaIngredients);
                }
                //increasing i to check next element in bobaTeaIngredients
                i++;
              }
            }
            if (firstRemoval == "Tea Pitcher"){
              while (bobaTeaIngredients.size() == 2){
                //if statement stops the loop if a top index does not exist
                if (topIndex < 0) {
                  break;
                }
                //if statement runs through each element in bobaTeaIngredient
                if (Rectangles.gridRectangles.get(topIndex).ingredientInside.equals(bobaTeaIngredients.get(i))) {
                  System.out.println("Top Index: " + topIndex);
                  switch (i) {
                    case 0:
                      cupInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(cupInsideRectangleIndex + " cup inside Rectangle Index (top)");
                      break;
                    case 1:
                      bobaInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(bobaInsideRectangleIndex + " boba inside Rectangle Index (top)");
                      break;
                    default:
                      System.out.println("Cannot set ingredient inside rectanlge index (top)");
                      break;
                  }
                  secondRemoval = bobaTeaIngredients.remove(i);
                  System.out.println(secondRemoval + " second removal");
                  System.out.println(bobaTeaIngredients);
                }
                //increasing i to check next element in bobaTeaIngredients
                i++;
              }
              i = 0;
            }
            if (firstRemoval == "Boba") {
              while (bobaTeaIngredients.size() == 2){
                //if statement stops the loop if a top index does not exist
                if (topIndex < 0) {
                  break;
                }
                //if statement runs through each element in bobaTeaIngredient
                if (Rectangles.gridRectangles.get(topIndex).ingredientInside.equals(bobaTeaIngredients.get(i))) {
                  System.out.println("Top Index: " + topIndex);
                  switch (i) {
                    case 0:
                      teaInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(teaInsideRectangleIndex + " Tea inside Rectangle Index (top)");
                      break;
                    case 1:
                      cupInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(cupInsideRectangleIndex + " cup inside Rectangle Index (top)");
                      break;
                    default:
                      System.out.println("Cannot set ingredient inside rectanlge index (top)");
                      break;
                  }
                  secondRemoval = bobaTeaIngredients.remove(i);
                  System.out.println(secondRemoval + " second removal");
                  //bobaTeaIngredients.remove(i);
                  System.out.println(bobaTeaIngredients);
                }
                //increasing i to check next element in bobaTeaIngredients
                i++;
              }
              i = 0;
            }  
          }
          i = 0;
          //stops if there is no ingredientInside bottom index
          if (Rectangles.gridRectangles.get(bottomIndex).ingredientInside == null) {
            break;
          }
          //waits to run until ingredientsPlaced >= 3 to run
          if (ingredientsPlaced >= 3) {
            //if statement takes in account what ingredient has been removed second
            if (secondRemoval == "Cup"){
              while (bobaTeaIngredients.size() == 1){
                //if statement stops the loop if a top index does not exist
                if (bottomIndex > 49) {
                  break;
                }
                //if statement runs through each element in bobaTeaIngredient
                if (Rectangles.gridRectangles.get(bottomIndex).ingredientInside.equals(bobaTeaIngredients.get(i))) {
                  System.out.println("Bottom Index " + bottomIndex);
                  switch (i) {
                    case 0:
                      teaInsideRectangleIndex = Rectangles.gridRectangles.get(bottomIndex).ingredientInsideIndex;
                      System.out.println(teaInsideRectangleIndex + " Tea inside Rectangle Index (top)");
                      break;
                    case 1:
                      bobaInsideRectangleIndex = Rectangles.gridRectangles.get(bottomIndex).ingredientInsideIndex;
                      System.out.println(bobaInsideRectangleIndex + " boba inside Rectangle Index (top)");
                      break;
                    default:
                      System.out.println("Cannot set ingredient inside rectanlge index (top)");
                      break;
                  }
                  thirdRemoval = bobaTeaIngredients.remove(i);
                  System.out.println(bobaTeaIngredients);
                }
                //increasing i to check next element in bobaTeaIngredients
                i++;
              }
              i = 0;
            }
            if (secondRemoval == "Tea Pitcher"){
              while (bobaTeaIngredients.size() == 1){
                //if statement stops the loop if a top index does not exist
                if (bottomIndex > 49) {
                  break;
                }
                //if statement runs through each element in bobaTeaIngredient
                if (Rectangles.gridRectangles.get(bottomIndex).ingredientInside.equals(bobaTeaIngredients.get(i))) {
                  System.out.println("Bottom Index " + bottomIndex);
                  switch (i) {
                    case 0:
                      cupInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(cupInsideRectangleIndex + " cup inside Rectangle Index (bottom)");
                      break;
                    case 1:
                      bobaInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(bobaInsideRectangleIndex + " boba inside Rectangle Index (bottom)");
                      break;
                    default:
                      System.out.println("Cannot set ingredient inside rectanlge index (bottom)");
                      break;
                  }
                  thirdRemoval = bobaTeaIngredients.remove(i);
                  System.out.println(bobaTeaIngredients);
                }
                //increasing i to check next element in bobaTeaIngredients
                i++;
              }
            }
            if (secondRemoval == "Boba") {
              while (bobaTeaIngredients.size() == 1){
                //if statement stops the loop if a top index does not exist
                if (bottomIndex > 49) {
                  break;
                }
                //if statement runs through each element in bobaTeaIngredient
                if (Rectangles.gridRectangles.get(bottomIndex).ingredientInside.equals(bobaTeaIngredients.get(i))) {
                  System.out.println("Bottom Index " + bottomIndex);
                  switch (i) {
                    case 0:
                      teaInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(teaInsideRectangleIndex + " Tea inside Rectangle Index (bottom)");
                      break;
                    case 1:
                      cupInsideRectangleIndex = Rectangles.gridRectangles.get(topIndex).ingredientInsideIndex;
                      System.out.println(cupInsideRectangleIndex + " cup inside Rectangle Index (bottom)");
                      break;
                    default:
                      System.out.println("Cannot set ingredient inside rectanlge index (bottom)");
                      break;
                  }
                  thirdRemoval = bobaTeaIngredients.remove(i);
                  System.out.println(thirdRemoval + "third removal 452");
                  System.out.println(bobaTeaIngredients);
                }
                //increasing i to check next element in bobaTeaIngredients
                i++;
              }
            }
            i = 0;
            System.out.println(thirdRemoval + " third removal");
          }
        }
        //to check ingredients that are not on the edge
        if (bobaTeaIngredients.size() == 0){
          System.out.println("Boba Tea Ingredients equals 0");
          //creating a bobaTea object
          BobaTea bobaTeaa = new BobaTea(ingredientSpawnX, ingredientSpawnY);
          //removing the ingredients used to create bobaTea
          //App.root.getChildren().removeAll().getCupShapeImageView()
          //removing ingredient inside top rectangle
          System.out.println(Rectangles.gridRectangles.get(topIndex).ingredientInside);
          //tea
          if (Rectangles.gridRectangles.get(topIndex).ingredientInside.equals("Tea Pitcher")) {
          App.root.getChildren().remove(TeaPitcher.teaPitchers.get(Rectangles.gridRectangles.get(topIndex).getTeaInsideRectangleIndex()).getTeaImageView());
            TeaPitcher.teaPitchers.remove(getTeaInsideRectangleIndex());
            System.out.println("Top tea has been removed");
          }
          //cup
          if (Rectangles.gridRectangles.get(topIndex).ingredientInside.equals("Cup")) {
          App.root.getChildren().remove(Cup.cups.get(Rectangles.gridRectangles.get(topIndex).getCupInsideRectangleIndex()).getCupShapeImageView());
            Cup.cups.remove(getCupInsideRectangleIndex());
            System.out.println("Top cup has been removed");
          }
          //boba
          if (Rectangles.gridRectangles.get(topIndex).ingredientInside.equals("Boba")) {
          App.root.getChildren().remove(Boba.bobas.get(Rectangles.gridRectangles.get(topIndex).getBobaInsideRectangleIndex()).getBobaImageView());
            Boba.bobas.remove(getBobaInsideRectangleIndex());
            System.out.println("Bottom boba has been removed");
          }

          //removing ingredient inside bottom rectangle
          System.out.println(Rectangles.gridRectangles.get(bottomIndex).ingredientInside);
          //tea
          if (Rectangles.gridRectangles.get(bottomIndex).ingredientInside.equals("Tea Pitcher")) {
            App.root.getChildren().remove(TeaPitcher.teaPitchers.get(Rectangles.gridRectangles.get(bottomIndex).getTeaInsideRectangleIndex()).getTeaImageView());
              TeaPitcher.teaPitchers.remove(getTeaInsideRectangleIndex());
              System.out.println("Bottom tea has been removed");
            }
          //cup
          if (Rectangles.gridRectangles.get(bottomIndex).ingredientInside.equals("Cup")) {
          App.root.getChildren().remove(Cup.cups.get(Rectangles.gridRectangles.get(bottomIndex).getCupInsideRectangleIndex()).getCupShapeImageView());
            Cup.cups.remove(getCupInsideRectangleIndex());
            System.out.println("Bottom cup has been removed");
          }
          //boba
          if (Rectangles.gridRectangles.get(bottomIndex).ingredientInside.equals("Boba")) {
            App.root.getChildren().remove(Boba.bobas.get(Rectangles.gridRectangles.get(bottomIndex).getBobaInsideRectangleIndex()).getBobaImageView());
              Boba.bobas.remove(getBobaInsideRectangleIndex());
              System.out.println("Bottom boba has been removed");
        }

          //removing ingredients inside the middle/placed rectangle
          System.out.println(Rectangles.gridRectangles.get(placedIngredientIndex).ingredientInside);
          //tea
            if (Rectangles.gridRectangles.get(placedIngredientIndex).ingredientInside.equals("Tea Pitcher")) {
              App.root.getChildren().remove(TeaPitcher.teaPitchers.get(Rectangles.gridRectangles.get(placedIngredientIndex).getTeaInsideRectangleIndex()).getTeaImageView());
                TeaPitcher.teaPitchers.remove(getTeaInsideRectangleIndex());
                System.out.println("Cetner tea has been removed");
              }
            //cup
            if (Rectangles.gridRectangles.get(placedIngredientIndex).ingredientInside.equals("Cup")) {
            App.root.getChildren().remove(Cup.cups.get(Rectangles.gridRectangles.get(placedIngredientIndex).getCupInsideRectangleIndex()).getCupShapeImageView());
              Cup.cups.remove(getCupInsideRectangleIndex());
              System.out.println("Center cup has been removed");
            }
            //boba
            if (Rectangles.gridRectangles.get(placedIngredientIndex).ingredientInside.equals("Boba")) {
              App.root.getChildren().remove(Boba.bobas.get(Rectangles.gridRectangles.get(placedIngredientIndex).getBobaInsideRectangleIndex()).getBobaImageView());
                Boba.bobas.remove(getBobaInsideRectangleIndex());
                System.out.println("Center boba has been removed");
          }
          TeaPitcher.currentTeaIndex--;
          Cup.currentCupIndex--;
          Boba.currentBobaIndex--;
          break;
        }
      } 
    }
  
  //creating getters for the ingredientsInsideIndex
  public int getTeaInsideRectangleIndex() {
    return teaInsideRectangleIndex;
  }
  public int getCupInsideRectangleIndex() {
    return cupInsideRectangleIndex;
  }
  public int getBobaInsideRectangleIndex() {
    return bobaInsideRectangleIndex;
  }
  public int getRectanglesIndex() {
    return rectanglesIndex;
  }
}
