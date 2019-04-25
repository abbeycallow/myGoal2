package com.company;
import java.io.*;
import java.util.Scanner;

//making an app that saves user input to a file
//and user is able to view their goals even when app is closed/reopened
//also able to create new goal while still being able to view previous goal



public class Goals {
    //creating user choice variable to use in switch case
    String userChoice;
    // creating scanner to take in input from user
    Scanner scanner = new Scanner(System.in);


    public void goals() throws IOException {
        //do loop making sure the menu continues roll through
        do {
            //showing the menu for GOALS and inputing info 1/2 to direct you to where in the app u want to go
            System.out.println(" ----YOUR GOALS----");
            System.out.println("Would you like to create a new goal? Press 1");
            System.out.println("would you like to view your goal? press 2");
            System.out.println("Save and start over? press 3");

            userChoice = scanner.nextLine();

            //switch case creates menu
            switch (Integer.parseInt(userChoice)) {

                case 1:
                  createGoal();
                    break;

                case 2:
                    viewGoal();
                    break;

                case 3:
                   createGoal();
                    break;
            }
        }
        //end of loop
        while ((Integer.parseInt(userChoice)) != 3);

    }

        private void createGoal() throws IOException {
            //creating a file and making sure the info saves to the file even if
            //you create a new goal or exit app
            BufferedWriter buffer = new BufferedWriter(new FileWriter("goals.txt", true));
            String userInput;

            //this next portion takes in user input and answers the questions that are prompted
            //and saves them to a file
            System.out.println("\nWrite a goal that you would like to accomplish in a day : ");
            userInput = scanner.nextLine();
            buffer.write("\nDaily goal : ");
            buffer.write(userInput);
            buffer.newLine();

            System.out.println("\nWrite a goal that you would like to accomplish in a week : ");
            userInput = scanner.nextLine();
            buffer.write("\nWeekly goal : ");
            buffer.write(userInput);
            buffer.newLine();

            System.out.println("\nWrite a goal that you would like to accomplish in a month : ");
            userInput = scanner.nextLine();
            buffer.write("\nMonthly goal : ");
            buffer.write(userInput);
            buffer.newLine();

            System.out.println("\nWrite a goal that you would like to accomplish in 6 months?: ");
            userInput = scanner.nextLine();
            buffer.write("\nMid year goal : ");
            buffer.write(userInput);
            buffer.newLine();

            System.out.println("\nWrite a goal that you would like to accomplish in a year : ");
            userInput = scanner.nextLine();
            buffer.write("\nEnd of year goal : ");
            buffer.write(userInput);
            buffer.newLine();

            buffer.write(" --------------------------------------------------");
            buffer.newLine();

            //closes reader
            buffer.close();
        }

        private void viewGoal() throws IOException {
            //user able to see their goals
            System.out.println("\n YOUR  GOALS : ");
            FileReader file = new FileReader("goals.txt");
            BufferedReader buffer = new BufferedReader(file);

            //this loop files the char and prints them to screen.
            int i;
            while((i=buffer.read())!=-1){
                System.out.print((char)i);
            }

            //closes reader
            buffer.close();
            //closes file
            file.close();
        }
    }


