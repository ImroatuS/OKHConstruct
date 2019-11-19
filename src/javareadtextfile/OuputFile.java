/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareadtextfile;

/**
 *
 * @author admin
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OuputFile {
    public void outputMatrik(int matrik[][], String file)throws IOException{
        FileWriter m = new FileWriter(file);
            for(int x=0; x<matrik.length; x++){
                for(int y=0; y<matrik.length; y++){
                 m.write(Integer.toString(matrik[x][y])+" ");
            }
                m.write("\n");
            }
             m.close();
    }
    public void outputTimeSlot(int matrik[], String file)throws IOException{
        FileWriter m = new FileWriter(file);
     
                for(int y=0; y<matrik.length; y++){
                 m.write(Integer.toString(matrik[y])+" ");
                }
             m.close();
    }
}
