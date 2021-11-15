package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

public class Application_ItemStorage extends Application {
    public static class ItemComponents { //declare a public static class to utilize as a struct and hold the information for each item
        private String itemTitle; //declare a String variable, itemTitle, to hold the name or title of the item
        private String itemDeadline; //declare a String variable, itemDeadline, to hold the deadline of the item
        private String itemDescription; //declare a String variable, itemDescription, to hold the description of the item
        private String itemCompletionStatus; //declare an Integer variable, itemCompletionStatus, to hold whether the item has been marked in its respective checkbox or not

        public String getItemTitle() {
            return itemTitle; //return the item title to the function to retrieve the item title from the constructor
        } //create getter for item's title

        public void setItemTitle(String newItemTitle) {
            this.itemTitle = newItemTitle; //use the this.(object) method to take the user input and place it into the item title variable in the constructor
        } //create setter for item's title

        public String getItemDeadline() {
            return itemDeadline; //return the item deadline to the function to retrieve the item due date from the constructor
        } //create getter for item's deadline

        public void setItemDeadline(String newItemDeadline) {
            this.itemDeadline = newItemDeadline; //use the this.(object) method to take the user input and place it into the item due date variable in the constructor
        } //create setter for item's deadline

        public String getItemDescription() {
            return itemDescription; //return the item description to the function to retrieve the item description from the constructor
        } //create getter for item's description

        public void setItemDescription(String newItemDescription) {
            this.itemDescription = newItemDescription; //use the this.(object) method to take the user input and place it into the item description variable in the constructor
        } //create setter for item's description

        public String getItemCompletionStatus() {
            return itemCompletionStatus; //return the item completion status to the function to retrieve the item completion status from the constructor
        } //create getter for item's completion Status / checkbox marker

        public void setItemCompletionStatus(String itemCompletionStatus) { //create setter for item's completion Status / checkbox marker
            this.itemCompletionStatus = itemCompletionStatus; //use the this.(object) method to take the user input and place it into the item completion status variable in the constructor
        }
    }
}