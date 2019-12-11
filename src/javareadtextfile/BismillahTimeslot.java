/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareadtextfile;

import java.util.Arrays;
import java.util.Random;

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
   public int []degreeterbesar(int [] jumlahDegree, int [] jumlahDegree1){
       int a[]=jumlahDegree;
       int b[]=jumlahDegree1;
       Arrays.sort(b);
       int i[]=new int [jumlahDegree.length];
       for (int k = 0; k < jumlahDegree.length; k++) {
            Arrays.sort(b);
       for (int j = 0; j < jumlahDegree.length; j++) {    
         if(b[jumlahDegree.length-1]==a[j]){
             i[k]=j;
             b[jumlahDegree.length-1]=-1;
             a[j]=-1;
             break;
         }
       }
          
       }
      
       
       return i;
   }
    public int [] alokasiWarna( int totalTimeslot, int matrik[][]){
          int jd1[]=jumlahDegree(matrik);
          int jd2[]=jumlahDegree1(matrik);
          int ud[]=degreeterbesar(jd1, jd2);
        int []timesSlot= new int[matrik.length];
        for (int i = 0; i < timesSlot.length;i++){
            timesSlot[i]=-1;
        }
        for (int k = 0; k < timesSlot.length; k++) {
           // System.out.println(ud[k]);
            for (int j = 0; j < totalTimeslot; j++) {
                boolean a=true;
                for (int y = 0; y < timesSlot.length; y++) {
                    if(matrik[ud[k]][y]!=0 && timesSlot[y]==j){
                        a=false;
                        break;
                   }
               }
                if(a){
                    timesSlot[ud[k]]=j;
                     break;
                }
            }
            
             
        }
	 return timesSlot;
}
    public int [] alokasiwarna1(int totalTimeslot, int [][]matrik){
        int []timeSlot=alokasiWarna(totalTimeslot, matrik);
       Random r =new Random();
       int randomCourses, randomTimeslot;
        while(cekInfeasible(timeSlot)){
         randomCourses = r.nextInt(timeSlot.length-1);
          randomTimeslot=r.nextInt(totalTimeslot-1);
           if(isFeasible(randomCourses, randomTimeslot, timeSlot, matrik)){
              timeSlot[randomCourses]=randomTimeslot;
              for (int i = 0; i < timeSlot.length; i++) {
                 if(timeSlot[i]==-1){
                       for (int j = 0; j < totalTimeslot; j++) {
                         if(isFeasible(i, j, timeSlot, matrik)){
                             timeSlot[i]=j;
                             break;
                         }
                     }
                 }
               
                }}
        }
        return timeSlot;
    }
    public boolean cekInfeasible(int [] timeslot){
        boolean a=false;
        for (int i = 0; i <timeslot.length ; i++) {
            if(timeslot[i]==-1){
                a=true;
                break;
            }
                
        }
        return a;
    }
    public boolean isFeasible(int randomCourses, int randomTimeslot, int[] timeslot, int[][] matrik){
    boolean feasible =true;
    for(int j=0; j<matrik.length; j++){
              if(matrik[randomCourses][j]!=0&&timeslot[j]==randomTimeslot){
                     feasible =false;
                     break;
              }
           }
      return feasible;
}
}