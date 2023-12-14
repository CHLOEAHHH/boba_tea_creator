package com.whhs.boba_tea_creator;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class Cup {
  //fields
  private Image cupShape;
  private ImageView cupShapeImageView;
  //static array list to hold cups that are created
  public static ArrayList<Cup> cups = new ArrayList<Cup>();
  //variable will get the new cup's index that has been created
  public static int currentCupIndex = 0;

  //assigns invidiaul indexes to each cup
  private int cupIndex;
  
  //constructor 
  public Cup(){
    //creating image
    cupShape = new Image(getClass().getResource("images/EmptyCup.png").toString());
   
    //creating image view  
    cupShapeImageView = new ImageView(cupShape);

    //setting X and Y coordinates
    cupShapeImageView.setX(45);
    cupShapeImageView.setY(165);

    cupIndex = currentCupIndex;

    //adding to root
    App.root.getChildren().addAll(cupShapeImageView);

    //adding to arraylist
    cups.add(this);
  }

  //getters and setters
  public ImageView getCupShapeImageView() {
    return cupShapeImageView;
  }
  public void setCupShapeImageView(ImageView cupShapeImageView) {
    this.cupShapeImageView = cupShapeImageView;
  }
  public int getCupIndex() {
    return cupIndex;
  }
}
