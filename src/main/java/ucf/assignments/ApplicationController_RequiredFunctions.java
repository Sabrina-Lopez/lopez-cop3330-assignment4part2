package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

import java.io.*;
import java.util.HashMap;

public class ApplicationController_RequiredFunctions extends Application {

    public static void makeItemFunction(HashMap<String, Application_ItemStorage.ItemComponents> outerMap, String itemTitle, String itemDesc, String itemDeadline, String itemCompletionStatus) {
        Application_ItemStorage.ItemComponents itemStorage = new Application_ItemStorage.ItemComponents();

        itemStorage.setItemTitle(itemTitle);
        itemStorage.setItemDescription(itemDesc);
        itemStorage.setItemDeadline(itemDeadline);
        itemStorage.setItemCompletionFlag(itemCompletionStatus);

        outerMap.put(itemTitle, itemStorage);
    }

    public static void editItemFunction(HashMap<String, Application_ItemStorage.ItemComponents> outerMap, String selectedItemTitle, String newItemTitle, String newItemDesc, String newItemDeadline, String newItemCompletionStatus) {
        outerMap.put(newItemTitle, outerMap.remove(selectedItemTitle));
        outerMap.get(newItemTitle).setItemTitle(newItemTitle);
        outerMap.get(newItemTitle).setItemDescription(newItemDesc);
        outerMap.get(newItemTitle).setItemDeadline(newItemDeadline);
        outerMap.get(newItemTitle).setItemCompletionFlag(newItemCompletionStatus);
    }

    public static void removeItemFunction(HashMap<String, Application_ItemStorage.ItemComponents> outerMap, String selectedItemTitle) {
        outerMap.remove(selectedItemTitle);
    }

    public static void removeAllItemsFunction(HashMap<String, Application_ItemStorage.ItemComponents> outerMap) {
        int numHashmapItems = outerMap.size();

        while(numHashmapItems != 0) {
            String currentItem = (String) outerMap.keySet().toArray()[numHashmapItems - 1];
            removeItemFunction(outerMap, currentItem);
            numHashmapItems--;
        }
    }

    public static String printAllItemsOfList(HashMap<String, Application_ItemStorage.ItemComponents> outerMap) {
        String allItems = null;

        for(int i = 0; i < outerMap.size(); i++) {
            String currentItem = (String) outerMap.keySet().toArray()[i];
            allItems = allItems + currentItem + "\n";
        }

        return allItems;
    }

    public static String printAllCompletedItemsOfList(HashMap<String, Application_ItemStorage.ItemComponents> outerMap) {
        String allCompletedItems = null;

        for(int i = 0; i < outerMap.size(); i++) {
            String currentItem = (String) outerMap.keySet().toArray()[i];

            if(outerMap.get(currentItem).getItemCompletionFlag().equals("1")) {
                allCompletedItems = allCompletedItems + currentItem + "\n";
            }
        }

        return allCompletedItems;
    }

    public static String printAllUncompletedItemsOfList(HashMap<String, Application_ItemStorage.ItemComponents> outerMap) {
        String allUncompletedItems = null;

        for(int i = 0; i < outerMap.size(); i++) {
            String currentItem = (String) outerMap.keySet().toArray()[i];

            if(outerMap.get(currentItem).getItemCompletionFlag().equals("0")) {
                allUncompletedItems = allUncompletedItems + currentItem + "\n";
            }
        }

        return allUncompletedItems;
    }

    public static void saveListFunction(HashMap<String, Application_ItemStorage.ItemComponents> outerMap) throws IOException {
        File saveListFile = new File("src\\main\\java\\ucf\\assignments\\saveListFile.txt");
        FileWriter saveListFileOutput = new FileWriter(saveListFile);

        if (saveListFile.exists()) {
            for (int i = 0; i < outerMap.size(); i++) {
                String currentItem = (String) outerMap.keySet().toArray()[i];

                String currentItemTitle = outerMap.get(currentItem).getItemTitle();
                saveListFileOutput.write("Item: " + currentItemTitle);

                String currentItemDesc = outerMap.get(currentItem).getItemDescription();
                saveListFileOutput.write(", " + currentItemDesc);

                String currentItemDeadline = outerMap.get(currentItem).getItemDeadline();
                saveListFileOutput.write(", " + currentItemDeadline);

                String currentItemCompletionFlag = outerMap.get(currentItem).getItemCompletionFlag();
                saveListFileOutput.write(", " + currentItemCompletionFlag + "\n");
            }
        }

        saveListFileOutput.write("\n");

        saveListFileOutput.close();

        removeAllItemsFunction(outerMap);
    }

    public static void loadListFunction(HashMap<String, Application_ItemStorage.ItemComponents> outerMap) throws IOException {
        File loadListFile = new File("src\\main\\java\\ucf\\assignments\\saveListFile.txt");
        BufferedReader loadListFileReader = new BufferedReader(new FileReader(loadListFile));

        BufferedReader loadListFileLineCounter = new BufferedReader(new FileReader(loadListFile));
        int loadListFileNumLines = 0;
        while (loadListFileLineCounter.readLine() != null) {
            loadListFileNumLines++;
        }

        if(loadListFile.exists()) {
            for (int i = 0; i < (loadListFileNumLines - 1); i++) {
                String currentItemDetails = loadListFileReader.readLine();
                currentItemDetails = currentItemDetails.replace("Item: ", "");
                String[] itemDetailsSplit = currentItemDetails.split(", ");

                Application_ItemStorage.ItemComponents itemStorage = new Application_ItemStorage.ItemComponents();

                itemStorage.setItemTitle(itemDetailsSplit[0]);
                itemStorage.setItemDescription(itemDetailsSplit[1]);
                itemStorage.setItemDeadline(itemDetailsSplit[2]);
                itemStorage.setItemCompletionFlag(itemDetailsSplit[3]);

                outerMap.put(itemDetailsSplit[0], itemStorage);
            }
        }
    }
}