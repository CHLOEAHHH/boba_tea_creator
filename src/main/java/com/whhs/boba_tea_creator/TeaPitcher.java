package com.whhs.boba_tea_creator;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class TeaPitcher {
  //fields
  private Image teaImage;
  private ImageView teaImageView;
  //static array list to hold teas that are created
  public static ArrayList<TeaPitcher> teaPitchers = new ArrayList<TeaPitcher>();
  //variable will get the tea's index that has been created
  public static int currentTeaIndex = 0;
  //assigns invidiaul indexes to each cup
  private int teaIndex;

  //constructor 
  public TeaPitcher() {
    //image creation
    teaImage = new Image(getClass().getResource("images/TeaPitcher.png").toString());
    //image view node creation
    teaImageView = new ImageView(teaImage);

    //setting x and y
    teaImageView.setX(45);
    teaImageView.setY(165);

    //adding to root
    App.root.getChildren().addAll(teaImageView);

    //setting each tea to have a different index
    teaIndex = currentTeaIndex;
    
    //adding to arraylist
    teaPitchers.add(this);
    }
    //getters and setters
    public ImageView getTeaImageView() {
      return teaImageView;
    }
    public void setTeaImageView(ImageView teaImageView) {
      this.teaImageView = teaImageView;
    }
    public int getTeaIndex() {
      return teaIndex;
    }
}
