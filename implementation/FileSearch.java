package com.lockedme.implementation;

import java.io.*;
import java.util.*;


public class FileSearch {

    public static ArrayList<String> tempFileList = new ArrayList<>();

    public static boolean isFilePresent(){
        System.out.println("Enter the filename to be searched in all the Directories created");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(FileDB.fileList.contains(input)){
            System.out.println("File is present");
            return true;
        }
        else{
            System.out.println("File Not Found");
            return false;
        }
    }

    public static boolean showFileList() throws IOException {
        File f = new File("storeDirLocation.txt");
        if(f.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("storeDirLocation.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                File file = new File(line);
                String arr[] = file.list();
                for (String st : arr) {
                    if(st!=null && !tempFileList.contains(st)) {
                        tempFileList.add(st);
                    }
                }
            }

            Collections.sort(tempFileList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            return true;
        }
        else{
            System.out.println("No files added");
            return false;
        }
    }
}
