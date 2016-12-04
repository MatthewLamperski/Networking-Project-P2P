/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byte_copy_file;
//package com.name.file;

import java.io.File;
import java.io.IOException;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sarah
 */
public class Byte_Copy_File {
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
       
       // --------------------------------------------------
       // TEST: Copy file from one directory o another
       // --------------------------------------------------
       
        int i = 10;
        // Just testing
        System.out.println("Message length:" + i);
        
        // Define source and destination files by their paths
        String source = "c:\\Users\\sarah\\Documents\\zzzz_CodeTesting\\syllabus.pdf";
        String destination = "c:\\Users\\sarah\\Documents\\zzzz_CodeTesting\\newFolder\\syllabus.pdf";
        File f1 = new File(source);
        File f2 = new File(destination);
        
        // Copy the file from one place to another
        Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Copy Done");
       
       // ---------------------------------------------------------------------
       // TEST: Make file into byte array. Then, recreat file from byte array.
       // ---------------------------------------------------------------------
       
        // define byte array
        byte[] dataa;
        // define path of original file
        Path path1 = Paths.get("c:\\Users\\sarah\\Documents\\zzzz_CodeTesting\\syllabus.pdf");
        // define path of future location of copied byte array of file
        Path path2 = Paths.get("c:\\Users\\sarah\\Documents\\zzzz_CodeTesting\\syllabus_copy.pdf");

        // read file into byte array
        dataa = Files.readAllBytes(path1);

        System.out.print("Bytes read\n");
        System.out.print("length of byte string is: " + dataa.length + "\n");
            
        // Write byte array to a new file elsewhere
        Files.write(path2, dataa);
        System.out.print("Bytes written\n");
    }    
}
