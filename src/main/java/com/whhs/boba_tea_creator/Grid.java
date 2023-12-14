package com.whhs.boba_tea_creator;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.Cursor;

public class Grid {
  
  //fields
  private Image gridImage;
  private ImageView gridImageView;
  
  //constructor
  public Grid () {
    
    //creating image: image address, width, height, fixed ratio, smooth
    gridImage = new Image(getClass().getResource("images/GridLayout.png").toString());
    //creating image view
    gridImageView = new ImageView(gridImage);
    
    //scaling image
    gridImageView.setPreserveRatio(true);
    gridImageView.setFitWidth(310);
    gridImageView.setFitHeight(310);
    //positioning grid image view
    gridImageView.setX(130);
    gridImageView.setY(0);
    
    //adding grid imagenode to root
    App.root.getChildren().addAll(gridImageView);

    //calling methods
    gridInteractions();
    }//constructor bracket
  //methods
  public void gridInteractions(){
    //click on grid point and item goes there
    gridImageView.setOnMouseClicked((MouseEvent me) ->{
      System.out.println(me.getSceneX() + ", " + me.getSceneY());
      int mouseX = (int) me.getSceneX();
      int mouseY = (int) me.getSceneY();
    });
   }
}
