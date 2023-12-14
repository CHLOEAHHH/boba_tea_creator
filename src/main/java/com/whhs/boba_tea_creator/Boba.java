package com.whhs.boba_tea_creator;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class Boba {
  //fields
  private Image bobaImage;
  private ImageView bobaImageView;
  //static array list to hold boba that are created
  public static ArrayList<Boba> bobas = new ArrayList<Boba>();
  //variable will get the boba's index that has been created
  public static int currentBobaIndex = 0;
  //assigns invidiaul indexes to each cup
  private int bobaIndex;

  //constructor 
  public Boba (){
    //image creation
    bobaImage = new Image(getClass().getResource("images/Boba.png").toString());

    //image View node creation
    bobaImageView = new ImageView(bobaImage);
    
    bobaImageView.setX(45);
    bobaImageView.setY(165);

    
    //adding to root
    App.root.getChildren().addAll(bobaImageView);

    ////setting each boba to have a different index
    bobaIndex = currentBobaIndex;
    
    //adding to arrayList
    bobas.add(this);
  }
  //getters and setters
  public ImageView getBobaImageView() {
    return bobaImageView;
  }
  public void setBobaImageView(ImageView bobaImageView) {
    this.bobaImageView = bobaImageView;
  }
  public int getBobaIndex() {
    return bobaIndex;
  }
}