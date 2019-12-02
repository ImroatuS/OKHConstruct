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
public class BismillahTimeslot {
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
   
    public void alokasiWarna( int totalTimeslot, int matrik[][],int []degree){
      
        int []timesSlot= new int[degree.length];
        for (int i = 0; i < timesSlot.length;i++){
            timesSlot[i]=-1;
        }
        for (int i = 0; i < timesSlot.length; i++) {
                           boolean a=true;
                         
                     for (int j = 0; j < totalTimeslot; j++) {
                         for (int k = 0; k < degree.length; k++) {
                             if(matrik[degree[i]][k] !=0 && timesSlot[k]==j+1){
                                   a=false;
                                   
                             }
                         }
                         System.out.println(a);
                         if(a){
                             timesSlot[degree[i]]=j+1;
                           
                             break;
                         }
                         
            }
        }
        
        
        
        
       
        
    }
    
  
}
