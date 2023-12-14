package com.whhs.boba_tea_creator;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.paint.Color;
/**
 * JavaFX App
 */

public class App extends Application 
{ 
  //play stage
  public static Group root = new Group();
  //game menu
  public static Group menuRoot = new Group();

  public static Scene playScene;

  public static UserInterface userInterfaceOne;
  @Override
  
  public void start(Stage primaryStage) {
  //parent root, width, height
    userInterfaceOne = new UserInterface();
    playScene = new Scene(root, 500, 500);

    //creating playScene nodes
    Grid gridOne = new Grid();
    
    Rectangles rectanlgesOne = new Rectangles();
    
    primaryStage.setTitle("Boba Creation");
    primaryStage.setScene(playScene);
    primaryStage.show();
    
  } 
  public static void main(String[] args) {
    launch(args);
  }
} 
