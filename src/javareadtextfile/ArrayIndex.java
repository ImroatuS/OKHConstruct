/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareadtextfile;
import java.util.Arrays;
/**
 *
 * @author admin
 */
// Java program to get index of array 
// element in sorted array 

class ArrayIndex { 

	
	 public int [] jumlahDegree(int matrik[][]){
        int []jumlahdegree=new int[matrik.length];
        for(int i=0; i<matrik.length; i++){
            for(int j=0; j<matrik.length; j++){
               if(matrik[i][j]!=0)
                   jumlahdegree[i]++;
             }
        }
        int []a=jumlahdegree;
        
        return a;
    }//2,3,3,5
  //2,3,3,5
         
	 public int [] jumlahDegree1(int matrik[][]){
        int []jumlahdegree=new int[matrik.length];
        for(int i=0; i<matrik.length; i++){
            for(int j=0; j<matrik.length; j++){
               if(matrik[i][j]!=0)
                   jumlahdegree[i]++;
             }
        }
        int []a=jumlahdegree;
        
        return a;
    }//
   public int degreeterbesar(int [] jumlahDegree, int [] jumlahDegree1){
       int a[]=jumlahDegree;
       int b[]=jumlahDegree1;
       Arrays.sort(b);
       int i=0;
       for (int j = 0; j < jumlahDegree.length; j++) {
         if(b[jumlahDegree1.length-1]==a[j])
             i=j;
       }
       
       return i;
   }
    public int [] alokasiWarna( int totalTimeslot, int matrik[][]){
      
        int []timesSlot= new int[matrik.length];
        for (int i = 0; i < timesSlot.length;i++){
            timesSlot[i]=-1;
        }
        int [] jmhd1;
        int [] jmhd2;
        int degreeTerbesar;
        for (int i = 0; i < timesSlot.length; i++) {
            
                jmhd1=jumlahDegree(matrik);
                jmhd2=jumlahDegree1(matrik);
                degreeTerbesar=degreeterbesar(jmhd1, jmhd2);
       
                           
                          
                     for (int j = 0; j < totalTimeslot; j++) {
                         boolean a=true;
                       
                         for (int k = 0; k < timesSlot.length; k++) {
                             if(matrik[degreeTerbesar][k] !=0 && timesSlot[k]==j){
                                
                                   a=false;}
                         }
                     
                         if(a){
                             timesSlot[degreeTerbesar]=j;
                             
                             for (int q = 0; q < matrik.length; q++) {
                                 matrik[degreeTerbesar][q]=0;
                             }
                            
                             break;
                         }
                         
            }
              
        }
        
        
        
        
       return timesSlot;
        
    }
} 


