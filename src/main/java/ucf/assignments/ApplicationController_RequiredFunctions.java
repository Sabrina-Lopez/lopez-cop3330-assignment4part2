package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

//establish any necessary imports
import java.io.*;
import java.util.HashMap;

//declare and create the class, ApplicationController_RequiredFunctions, to hold the program's required behaviors
public class ApplicationController_RequiredFunctions extends Application {

    //declare and create the function makeItemFunction, a void function that takes in the user-inputted item information from the GUI and creates and inputs a new item into the hashmap
    public static void makeItemFunction(HashMap<String, Application_ItemStorage.ItemComponents> outerMap, String itemTitle, String itemDesc, String itemDeadline, String itemCompletionStatus) {
        //declare and initialize itemStorage, a variable of the Application_ItemStorage.ItemComponents class that holds the item components within a new struct for every new item
        Application_ItemStorage.ItemComponents itemStorage = new Application_ItemStorage.ItemComponents();

        itemStorage.setItemTitle(itemTitle); //using the setItemTitle() method, set the item title of the new item w/ the user's inputted item title
        itemStorage.setItemDescription(itemDesc); //using the setItemDescription() method, set the item description of the new item w/ the user's inputted item description
        itemStorage.setItemDeadline(itemDeadline); //using the setItemDeadline() method, set the item deadline of the new item w/ the user's inputted item deadline
        itemStorage.setItemCompletionFlag(itemCompletionStatus); //using the setItemCompletionFlag() method, set the item completion status of the new item w/ the user's inputted item completion status

        //input the new item into the hashmap, its title being the key and the itemComponents struct as the value to refer to the individual item details later
        outerMap.put(itemTitle, itemStorage);
    }

    //declare and create the function editItemFunction, a void function that takes in the user-inputted item information from the GUI and edits an item within the hashmap
    public static void editItemFunction(HashMap<String, Application_ItemStorage.ItemComponents> outerMap, String selectedItemTitle, String newItemTitle, String newItemDesc, String newItemDeadline, String newItemCompletionStatus) {
        outerMap.put(newItemTitle, outerMap.remove(selectedItemTitle)); //using the put() method and remove() methods, put the contents, or item details, of the old item into the edited item and then remove the old item
        outerMap.get(newItemTitle).setItemTitle(newItemTitle); //using the get() and setItemTitle() methods, change the item title of the newly edited item to the new one that the user inputted
        outerMap.get(newItemTitle).setItemDescription(newItemDesc); //using the get() and setItemTitle() methods, change the item description of the newly edited item to the new one that the user inputted
        outerMap.get(newItemTitle).setItemDeadline(newItemDeadline); //using the get() and setItemTitle() methods, change the item deadline of the newly edited item to the new one that the user inputted
        outerMap.get(newItemTitle).setItemCompletionFlag(newItemCompletionStatus); //using the get() and setItemTitle() methods, change the item completion status of the newly edited item to the new one that the user inputted
    }

    //declare and create the function removeItemFunction, a void function that takes in the user-inputted item information from the GUI and removes an item from the hashmap
    public static void removeItemFunction(HashMap<String, Application_ItemStorage.ItemComponents> outerMap, String selectedItemTitle) {
        outerMap.remove(selectedItemTitle); //using the remove() method, remove the item from the hashmap
    }

    //declare and create the function removeAllItemsFunction, a void function that removes all the current items within the hashmap
    public static void removeAllItemsFunction(HashMap<String, Application_ItemStorage.ItemComponents> outerMap) {
        int numHashmapItems = outerMap.size(); //using the size() method, declare and initialize numHashmapItems, an Integer variable, with the number of items within the hashmap aka the size of the hashmap

        while(numHashmapItems != 0) { //loop while the numHashmapItems doesn't equal 0
            String currentItem = (String) outerMap.keySet().toArray()[numHashmapItems - 1]; //using the keySet().toArray() method, get the key of hashmap at the numHashmapItems index
            removeItemFunction(outerMap, currentItem); //removeItemFunction function call to remove the currentItem from the hashmap
            numHashmapItems--; //decrement the numHashmapItems as there is now one less item within the hashmap, shifting the loop to the next item's index to remove said item
        }
    }

    //declare and create the function printAllItemsFunction, a String-returning function that concatenates a String with all the current items within the hashmap
    public static String printAllItemsOfList(HashMap<String, Application_ItemStorage.ItemComponents> outerMap) {
        String allItems = null; //declare and initialize allItems, a String variable to hold the concatenation of the items of the hashmap to display to the user in the GUI

        for(int i = 0; i < outerMap.size(); i++) { //for the current index of the hashmap and until all the indexes of the hashmap have been gone through
            String currentItem = (String) outerMap.keySet().toArray()[i]; //using the keySet().toArray() method, get the key of hashmap at the numHashmapItems index
            allItems = allItems + currentItem + "\n"; //concatenate the currentItem to the allItems String
        }

        return allItems; //return the allItems String
    }

    //declare and create the function printAllCompletedItemsFunction, a String-returning function that concatenates a String with all the current completed items within the hashmap
    public static String printAllCompletedItemsOfList(HashMap<String, Application_ItemStorage.ItemComponents> outerMap) {
        String allCompletedItems = null; //declare and initialize allCompletedItems, a String variable to hold the concatenation of the completed items of the hashmap to display to the user in the GUI

        for(int i = 0; i < outerMap.size(); i++) { //for the current index of the hashmap and until all the indexes of the hashmap have been gone through
            String currentItem = (String) outerMap.keySet().toArray()[i]; //using the keySet().toArray() method, get the key of hashmap at the numHashmapItems index

            if(outerMap.get(currentItem).getItemCompletionFlag().equals("1")) { //using the get(), getItemCompletionFlag(), and equals() methods, determine if the current item's completion status is completed
                allCompletedItems = allCompletedItems + currentItem + "\n"; //if so, concatenate the currentItem to the allCompletedItems String
            }
        }

        return allCompletedItems; //return the allCompletedItems String
    }

    //declare and create the function printAllUncompletedItemFunction, a String-returning function that concatenates a String with all the current uncompleted items within the hashmap
    public static String printAllUncompletedItemsOfList(HashMap<String, Application_ItemStorage.ItemComponents> outerMap) {
        String allUncompletedItems = null; //declare and initialize allUncompletedItems, a String variable to hold the concatenation of the uncompleted items of the hashmap to display to the user in the GUI

        for(int i = 0; i < outerMap.size(); i++) { //for the current index of the hashmap and until all the indexes of the hashmap have been gone through
            String currentItem = (String) outerMap.keySet().toArray()[i]; //using the keySet().toArray() method, get the key of hashmap at the numHashmapItems index

            if(outerMap.get(currentItem).getItemCompletionFlag().equals("0")) { //using the get(), getItemCompletionFlag(), and equals() methods, determine if the current item's completion status is uncompleted
                allUncompletedItems = allUncompletedItems + currentItem + "\n"; //if so, concatenate the currentItem to the allUncompletedItems String
            }
        }

        return allUncompletedItems; //return the allUncompletedItems String
    }

    //declare and create the function saveListFunction, a void function that saves all the items of the list into an external file, deleting the items from the hashmap in the process
    public static void saveListFunction(HashMap<String, Application_ItemStorage.ItemComponents> outerMap) throws IOException {
        //declare and initialize saveListFile, a variable of the File class to hold the location of the external file in which the items will be saved to
        File saveListFile = new File("src\\main\\java\\ucf\\assignments\\saveListFile.txt");

        //declare and initialize saveListFileOutput, a variable of the FileWriter class to write the items and their components to the external text file
        FileWriter saveListFileOutput = new FileWriter(saveListFile);

        if (saveListFile.exists()) { //if the saveListFile does exist
            for (int i = 0; i < outerMap.size(); i++) { //for the current index of the hashmap and until all the indexes of the hashmap have been gone through
                String currentItem = (String) outerMap.keySet().toArray()[i]; //using the keySet().toArray() method, get the key of hashmap at the numHashmapItems index

                String currentItemTitle = outerMap.get(currentItem).getItemTitle(); //using the get() and getItemTitle() methods, get the current item's item title from the ItemComponents struct
                saveListFileOutput.write("Item: " + currentItemTitle); //using the write() method, write the item title into the external file

                String currentItemDesc = outerMap.get(currentItem).getItemDescription(); //using the get() and getItemDescription() methods, get the current item's item description from the ItemComponents struct
                saveListFileOutput.write(", " + currentItemDesc); //using the write() method, write the item description into the external file

                String currentItemDeadline = outerMap.get(currentItem).getItemDeadline(); //using the get() and getItemDeadline() methods, get the current item's item deadline from the ItemComponents struct
                saveListFileOutput.write(", " + currentItemDeadline); //using the write() method, write the item deadline into the external file

                String currentItemCompletionFlag = outerMap.get(currentItem).getItemCompletionFlag(); //using the get() and getItemCompletionStatus() methods, get the current item's completion status title from the ItemComponents struct
                saveListFileOutput.write(", " + currentItemCompletionFlag + "\n"); //using the write() method, write the item completion status into the external file
            }
        }

        saveListFileOutput.write("\n"); //using the write() method, add a newline character

        saveListFileOutput.close(); //using the close() method, stop the File Writer

        removeAllItemsFunction(outerMap); //using the removeAllItemsFunction function all and since all the items saved to the external file, remove the items from the hashmap
    }

    //declare and create the function loadListFunction, a void function that loads all the items of the list from an external file, adding the items back into the hashmap in the process
    public static void loadListFunction(HashMap<String, Application_ItemStorage.ItemComponents> outerMap) throws IOException {
        //declare and initialize loadListFile, a variable of the File class to hold the location of the external file in which the items will be loaded from
        File loadListFile = new File("src\\main\\java\\ucf\\assignments\\saveListFile.txt");

        //declare and initialize loadListFileReader, a variable of the BufferedReader class to read the lines of the loadListFile and take the items from each line to then add them back to the hashmap
        BufferedReader loadListFileReader = new BufferedReader(new FileReader(loadListFile));

        //declare and initialize loadListFileLineCounter, a variable of the BufferedReader class to count the number of lines/items that are within the loadListFile currently
        BufferedReader loadListFileLineCounter = new BufferedReader(new FileReader(loadListFile));
        int loadListFileNumLines = 0; //starting at 0 since there are no lines/items accounted for yet, declare and initialize loadListFileNumLines, an Integer to hold the number of lines/items within the loadListFile
        while (loadListFileLineCounter.readLine() != null) { //while there are lines in the loadListFile with information
            loadListFileNumLines++; //increment the loadListFileNumLines
        }

        if(loadListFile.exists()) { //if the loadListFile does exist
            for (int i = 0; i < (loadListFileNumLines - 1); i++) { //for the current item/line from the loadListFile and until all the items/lines have been loaded and added back into the hashmap
                String currentItemDetails = loadListFileReader.readLine(); //declare and initialize currentItemDetails, a String to hold the current item/line from the loadListFile
                currentItemDetails = currentItemDetails.replace("Item: ", ""); //using the replace() method, replace the "Item: " with " " to leave the item with only it's details
                String[] itemDetailsSplit = currentItemDetails.split(", "); //using the split() method, split the item details into a declared and initialized String array, itemDetailsSplit, to temporarily hold the details till inputted into the hashmap

                //declare and initialize itemStorage, a variable of the Application_ItemStorage.ItemComponents class that holds the item components within a new struct for every new item
                Application_ItemStorage.ItemComponents itemStorage = new Application_ItemStorage.ItemComponents();

                itemStorage.setItemTitle(itemDetailsSplit[0]); //using the setItemTitle() method, set the item title of the newly loaded item w/ the user's inputted item title
                itemStorage.setItemDescription(itemDetailsSplit[1]); //using the setItemDescription() method, set the item description of the newly loaded item w/ the user's inputted item description
                itemStorage.setItemDeadline(itemDetailsSplit[2]); //using the setItemDeadline() method, set the item deadline of the newly loaded item w/ the user's inputted item deadline
                itemStorage.setItemCompletionFlag(itemDetailsSplit[3]); //using the setItemCompletionFlag() method, set the item completion status of the newly loaded item w/ the user's inputted item completion status

                //input the newly loaded item into the hashmap, its title being the key and the itemComponents struct as the value to refer to the individual item details later
                outerMap.put(itemDetailsSplit[0], itemStorage);
            }
        }
    }
}