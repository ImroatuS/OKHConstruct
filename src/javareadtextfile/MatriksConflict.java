/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareadtextfile;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author admin
 */
public class MatriksConflict {
    public  int [][] createMatriks(int total_courses, String[] lines) throws IOException{
         int matrik [][]=new int [total_courses][total_courses];   
            for(int j=0; j<lines.length; j++){   
            String kata []=lines[j].split(" ");
            int c=kata.length;
             int angka [] = new int [c];
            for(int i=0; i<kata.length; i++){ 
                
                angka[i] =Integer.parseInt(kata[i]);
              
            }//System.out.println(" ke-" + j);
               
            for(int a=0; a<angka.length-1; a++){
     
               for(int b=a+1; b<angka.length; b++){      
                
                   
                   // System.out.println(j+" "+angka[a]+ " "+angka[b]);
               matrik[angka[a]-1][angka[b]-1]++;
               matrik[angka[b]-1][angka[a]-1]++;
               // System.out.println(j+" "+matrik[angka[a]-1]+ " "+matrik[angka[b]-1]);
               }//System.out.println("");
               }
            }
            
            
             return matrik;
    }
    public  void createMatriksKhusus(int total_courses, String[] lines) throws IOException{
         int matrik [][]=new int [total_courses][total_courses];   
            for(int j=0; j<lines.length; j++){   
            String kata []=lines[j].split(" ");
            int c=kata.length;
             int angka [] = new int [c];
            for(int i=0; i<kata.length; i++){ 
                
                //angka[i] =Integer.parseInt(kata[i]);
                System.out.print("|"+kata[i]+"| ");
            }
                System.out.println("");
           /* for(int a=0; a<angka.length-1; a++){ 
               for(int b=1; b<angka.length; b++){ 
               matrik[angka[a]-1][angka[b]-1]++;
               matrik[angka[b]-1][angka[a]-1]++;
            }
            }
        } 
            
             return matrik;*/
    }}
}
