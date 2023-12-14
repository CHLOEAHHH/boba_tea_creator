package com.whhs.boba_tea_creator;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

//Userinterface displays score, what ingredient is selected, something else too lowkey forgot.
public class UserInterface {
  
  //fields
  //image related variables
  private Image userInterfaceImage;
  private ImageView userInterfaceImageView;
  
  //number corresponding to the ingredient that is displayed in order for me to make it moveable later.
  private int selectedIngredient;

  //variables keep track how many of each ingredient is created.
  public static int teaCount = 0;
  public static int bobaCount = 0;
  public static int cupCount = 0;

  //ingredients are being made here in order to access them permantly.
  private TeaPitcher teaOne;
  private Cup cupOne;
  private Boba bobaOne;
  
  //constructor
  public UserInterface () {
    
    //creating image and image view
    userInterfaceImage = new Image(getClass().getResource("images/UserInterface.png").toString());
    userInterfaceImageView = new ImageView(userInterfaceImage);
    
    //scaling image
    userInterfaceImageView.setPreserveRatio(true);
    userInterfaceImageView.setFitWidth(100);
    userInterfaceImageView.setFitHeight(300);
    
    //positioning user interface
    userInterfaceImageView.setX(10);
    userInterfaceImageView.setY(0);

    //adding UI to root
    App.root.getChildren().addAll(userInterfaceImageView);

    //calling the method that randomizes what ingredient will be displayed and displays it.
    userInterfaceInteractions();
  }
  
  //methods
  //displays the ingredient that is selected randomly
  public void userInterfaceInteractions(){
    
    //randomizes what ingredient will be displayed
    int ingredientNumber = (int) Math.floor(Math.random() * 3);
    
    //creating a switch statement to create ingredients
    switch (ingredientNumber) {
        //tea pitcher
      case 0:
        //creating tea pitcher
      teaOne = new TeaPitcher();
      //assigned selected ingredient
      selectedIngredient = 0;
      break;
        
      case 1:
        //creating cup
      cupOne = new Cup();
        //assigned selected ingredient
        selectedIngredient = 1;
      break;
        
      case 2:
        //creating boba
      bobaOne = new Boba();
        //assigned selected ingredient
        selectedIngredient = 2;
      break;
        
      default:
        //default case
      System.out.println("Error");
      break;
    }
  }
  
  //getters and setters
  
  public int getSelectedIngredient() {
    return selectedIngredient;
  }
  public void setSelectedIngredient(int selectedIngredient){
    this.selectedIngredient = selectedIngredient;
  }
  
public TeaPitcher getTeaOne() {
    return teaOne;
}

public Boba getBobaOne() {
    return bobaOne;
}

public Cup getCupOne() {
    return cupOne;
}
}
