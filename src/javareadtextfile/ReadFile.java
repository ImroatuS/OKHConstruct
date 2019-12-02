/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareadtextfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
class ReadFile {
     public String[] readLines(String filename) throws IOException 
    {
        FileReader fileReader = new FileReader(filename);
         
        List<String> lines;
         try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
             lines = new ArrayList<>();
             String line;
             while ((line = bufferedReader.readLine()) != null)
             {
                 lines.add(line);
             }}
         
        return lines.toArray(new String[lines.size()]);
    }   
}
