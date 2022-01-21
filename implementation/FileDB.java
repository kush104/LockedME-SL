package com.lockedme.implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class FileDB {

    private static String fileLocation;
    private static boolean firstFileToBeAdded= true;
    public static Map<String,String> fileToDirMapping = new TreeMap<>();
    public static ArrayList<String> fileList= new ArrayList<String>();
    private static String internalDir;

    public static void OperationToAddFirstFile(BufferedReader br) throws IOException {
        String UserDirectory = System.getProperty("user.dir");
        System.out.println("Adding First file, Name the new Directory or Use below Directories");
        File storeLocation = new File(UserDirectory, "storeDirLocation.txt");
        if(!storeLocation.exists()) {
            storeLocation.createNewFile();
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader("storeDirLocation.txt"));
        String line;
        while((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        System.out.println("To Use From Above Directories, Enter the Directory Name, else Enter \"New\"");
        String selectOption = br.readLine();
        System.out.println("Selected Directory : " + selectOption);
        if(selectOption.equals("New"))
        {
            System.out.println("Enter the New Directory Name");
            internalDir = br.readLine();
            fileLocation = UserDirectory + '/' + internalDir;
            File f = new File(fileLocation);
            f.mkdir();
            FileWriter fw = new FileWriter(storeLocation,true);
            fw.write(internalDir);
            fw.append(System.getProperty("line.separator"));
            fw.close();
        }
        else{
            fileLocation = UserDirectory + "/" + selectOption;
        }
        firstFileToBeAdded = false;
    }
    public static void AddFile() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if(firstFileToBeAdded){
            FileDB.OperationToAddFirstFile(br);
        }
        System.out.println("Enter the filename");
        String filename = br.readLine();
        File file = new File(fileLocation,filename);
        //fdb.setFileLocation(fileLocation);
        if(file.createNewFile()) {
            System.out.println("Successfully added file: " + file.getName() + " at Directory path : " + file.getAbsolutePath());
            //Adding the file to the File to Dir. Mapping
            fileToDirMapping.put(filename,internalDir);
            //Adding the file to the List of files maintained
            fileList.add(filename);
        }
        else {
            System.out.println("File with same name already exists");
        }
    }
    /*
     public String getFileLocation() {
         return fileLocation;
     }

     public void setFileLocation(String fileLocation) {
         FileDB.fileLocation = fileLocation;
     }

    */
}
