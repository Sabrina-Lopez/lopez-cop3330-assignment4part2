package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

//establish any necessary imports
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

//declare and create the class, ApplicationController_RequiredFunctionsTest, to hold the test code that tests the functions in the ApplicationController_RequiredFunctions
public class ApplicationController_RequiredFunctionsTest  {
    @Test
    //declare and create main() method to store the test code
    public void main() throws IOException {
        //declare testOuterMap, a variable of the HashMap<String, Application_ItemStorage.ItemComponents> class to hold the list of items
        // and their respective information (e.g., title, description, deadline, completion status) within a copy of the ItemComponents struct
        HashMap<String, Application_ItemStorage.ItemComponents> testOuterMap = new HashMap<>();

        String testItemTitle1 = "testItemTitle1"; //declare and initialize testItemTitle1, a String variable to hold an item title to input in functions for testing purposes
        String testItemDesc1 = "testItemDesc1"; //declare and initialize testItemDesc1, a String variable to hold an item description to input in functions for testing purposes
        String testItemDeadline1 = "2021-11-11"; //declare and initialize testItemDeadline1, a String variable to hold an item deadline to input in functions for testing purposes
        String testItemCompletionStatus1 = "0"; //declare and initialize testItemCompletionStatus1, a String variable to hold an item completion status to input in functions for testing purposes

        //function call to the makeItemFunction in the ApplicationController_RequiredFunctions java file to test whether the function makes and inputs a new item into the hashmap
        ApplicationController_RequiredFunctions.makeItemFunction(testOuterMap, testItemTitle1, testItemDesc1, testItemDeadline1, testItemCompletionStatus1);
        assertEquals(testItemTitle1, testOuterMap.keySet().toArray()[0]); //using the assertEquals() method, if the hashmap now has the new item in its first index, then the makeItemFunction was successful

        String testItemTitle2 = "testItemTitle2"; //declare and initialize testItemTitle2, a String variable to hold an item title to input in functions for testing purposes
        String testItemDesc2 = "testItemDesc2"; //declare and initialize testItemDesc2, a String variable to hold an item description to input in functions for testing purposes
        String testItemDeadline2 = "2021-11-12"; //declare and initialize testItemDeadline2, a String variable to hold an item deadline to input in functions for testing purposes
        String testItemCompletionStatus2 = "1"; //declare and initialize testItemCompletionStatus2, a String variable to hold an item completion status to input in functions for testing purposes

        //function call to the editItemFunction in the ApplicationController_RequiredFunctions java file to test whether the function edits an item within the hashmap
        ApplicationController_RequiredFunctions.editItemFunction(testOuterMap, testItemTitle1, testItemTitle2, testItemDesc2, testItemDeadline2, testItemCompletionStatus2);
        assertEquals(testItemTitle2, testOuterMap.keySet().toArray()[0]); //using the assertEquals() method, if the hashmap now has the edited item in its first index, then the editItemFunction was successful

        //using the assertEquals method, if the edited item's description has changed and matches to the new description, then the editItemFunction was successful
        assertEquals(testItemDesc2, testOuterMap.get(testItemTitle2).getItemDescription());

        //using the assertEquals method, if the edited item's deadline has changed and matches to the new deadline, then the editItemFunction was successful
        assertEquals(testItemDeadline2, testOuterMap.get(testItemTitle2).getItemDeadline());

        //using the assertEquals method, if the edited item's completion status has changed and matches to the new completion status, then the editItemFunction was successful
        assertEquals(testItemCompletionStatus2, testOuterMap.get(testItemTitle2).getItemCompletionFlag());

        //function call to the removeItemFunction in the ApplicationController_RequiredFunctions java file to test whether the function removes an item from the hashmap
        ApplicationController_RequiredFunctions.removeItemFunction(testOuterMap, testItemTitle2);

        //since there's only one item in the hashmap currently, then the remove function should remove the one item and leave the hashmap empty
        // so, using the assertEquals() method, if the testOuterMap hashmap is empty, then the removeItemFunction was successful
        assertEquals(0, testOuterMap.size());

        //function call to the makeItemFunction in the ApplicationController_RequiredFunctions java file to add multiple items to the hashmap for future tests of the program's required behaviors
        ApplicationController_RequiredFunctions.makeItemFunction(testOuterMap, testItemTitle1, testItemDesc1, testItemDeadline1, testItemCompletionStatus1);
        ApplicationController_RequiredFunctions.makeItemFunction(testOuterMap, testItemTitle2, testItemDesc2, testItemDeadline2, testItemCompletionStatus2);

        //using the assertTrue() method, if the resulting String of the ApplicationController_RequiredFunctions.printAllItemsOfList(testOuterMap) function call contains
        // all the item titles currently within the hashmap, then the function was successful
        assertTrue(ApplicationController_RequiredFunctions.printAllItemsOfList(testOuterMap).contains(testItemTitle1));
        assertTrue(ApplicationController_RequiredFunctions.printAllItemsOfList(testOuterMap).contains(testItemTitle2));

        //using the assertTrue() method, if the resulting String of the ApplicationController_RequiredFunctions.printAllItemsOfList(testOuterMap) function call contains
        // all the completed item titles currently within the hashmap, then the function was successful
        assertTrue(ApplicationController_RequiredFunctions.printAllCompletedItemsOfList(testOuterMap).contains(testItemTitle2));

        //using the assertTrue() method, if the resulting String of the ApplicationController_RequiredFunctions.printAllItemsOfList(testOuterMap) function call contains
        // all the uncompleted item titles currently within the hashmap, then the function was successful
        assertTrue(ApplicationController_RequiredFunctions.printAllUncompletedItemsOfList(testOuterMap).contains(testItemTitle1));

        //function call to the removeAllItemsFunction in the ApplicationController_RequiredFunctions java file to test whether it deletes all the current items within the hashmap or not
        ApplicationController_RequiredFunctions.removeAllItemsFunction(testOuterMap);

        //since this function call is meant to delete all the items within the hashmap, then the hashmap should be left empty
        // so, using the assertEquals() method, if the testOuterMap hashmap is empty, then the removeAllItemsFunction was successful
        assertEquals(0, testOuterMap.size());

        //function call to the makeItemFunction in the ApplicationController_RequiredFunctions java file to add multiple items to the hashmap for future tests of the program's required behaviors
        ApplicationController_RequiredFunctions.makeItemFunction(testOuterMap, testItemTitle1, testItemDesc1, testItemDeadline1, testItemCompletionStatus1);
        ApplicationController_RequiredFunctions.makeItemFunction(testOuterMap, testItemTitle2, testItemDesc2, testItemDeadline2, testItemCompletionStatus2);

        //declare and initialize saveListFile, a variable of the File class to hold the location of the external file in which the items will be saved to and loaded from
        File saveListFile = new File("src\\main\\java\\ucf\\assignments\\saveListFile.txt");

        //function call to the saveListFunction in the ApplicationController_RequiredFunctions java file to test whether the current items in the list will be transferred to an external file or not
        ApplicationController_RequiredFunctions.saveListFunction(testOuterMap);
        assertTrue(saveListFile.exists()); //using the assertTrue() method, if the creation of the file was successful and
        assertTrue(saveListFile.length() != 0); //the file is not empty, then the saveListFunction was successful

        //function call to the loadListFunction in the ApplicationController_RequiredFunctions java file to test whether the current items in the external file will be added back to the hashmap or not
        ApplicationController_RequiredFunctions.loadListFunction(testOuterMap);

        //as a result of the loadListFunction, the items once saved to the external file should be added back to the hashmap, thus making the hashmap not empty
        assertTrue(testOuterMap.size() != 0); //using the assertTrue method(), if the hashmap is not empty, then the loadListFunction was successful
    }
}