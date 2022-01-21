package com.lockedme.implementation;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

    public static void showOptions(){
        System.out.println("Please select from below options :");
        System.out.println("1. Display current files in ascending order");
        System.out.println("2. Operations on File");
        System.out.println("3. Close the application\n");
    }

    public void showMenu() throws IOException {
        boolean ContinueContext = true;
        while(ContinueContext){
            FileOperations.FileOperationsContext = true;
            MainMenu.showOptions();
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    if(FileSearch.showFileList()){
                        System.out.println(FileSearch.tempFileList);
                    }
                    break;
                case 2:
                    while(FileOperations.FileOperationsContext) {
                        FileOperations.showFileOperationsMenu();
                    }
                    break;
                case 3:
                    ContinueContext = false;
                    break;
                default:
                    System.out.println("Please select a valid option\n");
                    break;
            }
        }
    }

    public void appDetails(){
        System.out.println("Locked ME Application");
        System.out.println("Developed by Kumar Kushagra");
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        MainMenu MM = new MainMenu();
        MM.appDetails();
        MM.showMenu();
    }
}
