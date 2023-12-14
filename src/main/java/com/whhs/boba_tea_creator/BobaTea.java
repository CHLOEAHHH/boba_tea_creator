package com.whhs.boba_tea_creator;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class BobaTea {
  //fields
  private Rectangle bobaTeaShape;
  //holds all the boba teas created
  public static ArrayList<BobaTea> bobaTeas = new ArrayList<BobaTea>();

  //constructor
  public BobaTea(double x, double y){
    bobaTeaShape = new Rectangle();
    try {
      bobaTeaShape.setX(x);
      bobaTeaShape.setY(y);
      bobaTeaShape.setWidth(30);
      bobaTeaShape.setHeight(45);
      App.root.getChildren().addAll(bobaTeaShape);
      System.out.println("BobaTea has been added");
    } catch (NullPointerException e){
      System.out.println("Uh oh");
    }
    bobaTeas.add(this);
  }
}
