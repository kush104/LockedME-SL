package com.lockedme.implementation;

import java.io.IOException;
import java.util.Scanner;

public class FileOperations {

    public static boolean FileOperationsContext = true;

    public static void showFileOperationOptions(){
        System.out.println("Please select from below options: ");
        System.out.println("1. Add a file to the existing directory");
        System.out.println("2. Delete a user file");
        System.out.println("3. Search for a user file");
        System.out.println("4. Return to Main Menu\n");
    }

    public static void showFileOperationsMenu() throws IOException {
            FileOperations.showFileOperationOptions();
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    // add file
                    FileDB.AddFile();
                    break;
                case 2:
                    //delete file
                    FileDelete.deleteFile();
                    break;
                case 3:
                    //Search file
                    FileSearch.isFilePresent();
                    break;
                case 4:
                    FileOperationsContext = false;
                    break;
                default:
                    System.out.println("Please select a valid option\n");
                    break;
        }
    }
}
