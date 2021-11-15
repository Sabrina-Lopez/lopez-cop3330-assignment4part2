package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

//get any necessary imports
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;

//create Application class to hold the initial program launch functions
public class Application extends javafx.application.Application {

    public static void main(String[] args) { //declare the main function/method
        launch(); //utilize launch method to start the program
    }

    @Override //incorporate override statement
    //declare the start function/method with throws Exception in case there was an exception not considered in creating and launching the program
    public void start(Stage stage) throws Exception {

        //declare a Parent variable, root, to hold the components of the fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomeScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        stage.setScene(scene); //create the program window / stage for the scene
        stage.setTitle("To-Do App"); //create the program window / stage title, To-Do App
        stage.show(); //show the program window / stage
    }
}