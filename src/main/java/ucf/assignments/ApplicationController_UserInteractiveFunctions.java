package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

//establish any necessary imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

//declare and create the class, ApplicationController_UserInteractiveFunctions, to hold the functions that work as middle men between the GUI and the required behaviors
public class ApplicationController_UserInteractiveFunctions extends Application {
    HashMap<String, Application_ItemStorage.ItemComponents> outerMap = new HashMap<>();

    @FXML
    private TextField welcomeScreenItemList;

    @FXML
    private TextField itemScreenItemComponents;

    @FXML
    private TextField userSelectedItemInput;

    @FXML
    private TextField userItemTitleInput;

    @FXML
    private TextField userItemDescInput;

    @FXML
    private DatePicker userItemDeadlineInput;

    @FXML
    private TextField userItemCompletionStatusInput;

    String selectedUserItem;

    public String takeUserSelectedItem() {
        selectedUserItem = userSelectedItemInput.getText();

        return  selectedUserItem;
    }

    public void onMakeItemClick(ActionEvent actionevent) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("makeItemScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method
    }

    public void onEditItemClick(ActionEvent actionevent) throws IOException {
        selectedUserItem = takeUserSelectedItem();

        if(selectedUserItem.equals("")) {
            onBackToHomeClick(actionevent);
        }

        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("editItemScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method
    }

    public void onRemoveItemClick(ActionEvent actionevent) throws IOException {
        selectedUserItem = takeUserSelectedItem();

        if(selectedUserItem.equals("")) {
            onBackToHomeClick(actionevent);
        }

        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("removeItemScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method
    }

    public void onRemoveOneItemClick(ActionEvent actionevent) throws IOException {
        ApplicationController_RequiredFunctions.removeItemFunction(outerMap, selectedUserItem);

        onBackToHomeClick(actionevent);

        String allItems = ApplicationController_RequiredFunctions.printAllItemsOfList(outerMap);
        welcomeScreenItemList.clear();
        welcomeScreenItemList.appendText(allItems);
    }

    public void onRemoveAllItemsClick() {
        ApplicationController_RequiredFunctions.removeAllItemsFunction(outerMap);

        String allItems = ApplicationController_RequiredFunctions.printAllItemsOfList(outerMap);
        welcomeScreenItemList.clear();
        welcomeScreenItemList.appendText(allItems);
    }

    public void onBackToHomeClick(ActionEvent actionevent) throws IOException {
        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomeScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method
    }

    public void onShowItemDetailsClick(ActionEvent actionevent) throws IOException {
        selectedUserItem = takeUserSelectedItem();

        if(selectedUserItem.equals("")) {
            onBackToHomeClick(actionevent);
        }

        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ItemScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method

        itemScreenItemComponents.clear();
        itemScreenItemComponents.appendText("Title: " + outerMap.get(selectedUserItem).getItemTitle());
        itemScreenItemComponents.appendText("Description: " + outerMap.get(selectedUserItem).getItemDescription());
        itemScreenItemComponents.appendText("Deadline: " + outerMap.get(selectedUserItem).getItemDeadline());
        itemScreenItemComponents.appendText("Completion Status: " + outerMap.get(selectedUserItem).getItemCompletionStatus());
    }

    public void onShowCompletedItemsClick() {
        String completedItems = ApplicationController_RequiredFunctions.printAllCompletedItemsOfList(outerMap);
        welcomeScreenItemList.clear();
        welcomeScreenItemList.appendText(completedItems);
    }

    public void onShowUncompletedItemsClick() {
        String uncompletedItems = ApplicationController_RequiredFunctions.printAllUncompletedItemsOfList(outerMap);
        welcomeScreenItemList.clear();
        welcomeScreenItemList.appendText(uncompletedItems);
    }

    public void onSaveItemsClick(ActionEvent actionevent) throws IOException {
        ApplicationController_RequiredFunctions.saveListFunction(outerMap);

        onBackToHomeClick(actionevent);

        String allItems = ApplicationController_RequiredFunctions.printAllItemsOfList(outerMap);
        welcomeScreenItemList.clear();
        welcomeScreenItemList.appendText(allItems);
    }

    public void onLoadItemsClick(ActionEvent actionevent) throws IOException {
        ApplicationController_RequiredFunctions.loadListFunction(outerMap);

        onBackToHomeClick(actionevent);

        String allItems = ApplicationController_RequiredFunctions.printAllItemsOfList(outerMap);
        welcomeScreenItemList.clear();
        welcomeScreenItemList.appendText(allItems);
    }

    public void onSubmitNewItemClick(ActionEvent actionevent) throws IOException {
        String userItemTitle = userItemTitleInput.getText();
        String userItemDesc = userItemDescInput.getText();
        String userItemDeadline = userItemDeadlineInput.toString() ;
        String userItemCompletionStatus = userItemCompletionStatusInput.getText();

        ApplicationController_RequiredFunctions.makeItemFunction(outerMap, userItemTitle, userItemDesc, userItemDeadline, userItemCompletionStatus);

        onBackToHomeClick(actionevent);

        String allItems = ApplicationController_RequiredFunctions.printAllItemsOfList(outerMap);
        welcomeScreenItemList.clear();
        welcomeScreenItemList.appendText(allItems);
    }

    public void onSubmitEditedItemClick(ActionEvent actionevent) throws IOException {
        String userItemTitle = userItemTitleInput.getText();
        String userItemDesc = userItemDescInput.getText();
        String userItemDeadline = userItemDeadlineInput.toString();
        String userItemCompletionStatus = userItemCompletionStatusInput.getText();

        ApplicationController_RequiredFunctions.editItemFunction(outerMap, selectedUserItem, userItemTitle, userItemDesc, userItemDeadline, userItemCompletionStatus);

        onBackToHomeClick(actionevent);

        String allItems = ApplicationController_RequiredFunctions.printAllItemsOfList(outerMap);
        welcomeScreenItemList.clear();
        welcomeScreenItemList.appendText(allItems);
    }
}