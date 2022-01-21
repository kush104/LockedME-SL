package com.lockedme.implementation;

import java.io.*;

public class FileDelete {

    public static void deleteFile() throws IOException {
        System.out.println("Enter the specific file to be deleted");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileToDelete = br.readLine();
        if(FileDB.fileList.contains(fileToDelete)){
            //Delete the file from the Dir location
            String internalDir = FileDB.fileToDirMapping.get(fileToDelete);
            String UserDirectory = System.getProperty("user.dir");
            String completePath = UserDirectory + '/' + internalDir;
            File f = new File(completePath,fileToDelete);
            /*
            FileWriter fw = new FileWriter(f);
            fw.write("Are you there ?");
            */
            if(f.delete()){
                //Remove from the File to Dir. Mapping
                FileDB.fileToDirMapping.remove(fileToDelete);
                //Remove the file from fileList
                FileDB.fileList.remove(fileToDelete);
                //Remove the file from tempList
                FileSearch.tempFileList.remove(fileToDelete);
                System.out.println("Specified File is deleted from the system");
            }
            else
            {
                System.out.println("File Not able to be deleted");
            }
        }
        else{
            System.out.println("File Not Found !!");
        }
    }
}
