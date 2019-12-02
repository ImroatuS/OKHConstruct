/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareadtextfile;

import java.util.Random;

/**
 *
 * @author admin
 */
public class HillClimbing {
  public void resultHC(int []timeslotA, int [][]matrik, int totalStudent,int totalTimeslot){  
      EvaluationFunction ev = new EvaluationFunction();
      int [] timeslot = timeslotA;
      int [] timeslotf= timeslotA;
     // int[][] matrik =matrikA;
      double s=ev.evaluationFunction(matrik, timeslot, totalStudent);
    //  double s1=0.0;
      Random r =new Random();
       int randomCourses, randomTimeslot;
       boolean abc =true;
      
      for(int a=0; a<1000000; a++){
         System.out.println("iterasi ke "+a + ":    " +s );
          
          randomCourses = r.nextInt(timeslot.length-1);
          randomTimeslot=r.nextInt(totalTimeslot-1);
            //System.out.println(isFeasible(randomCourses, randomTimeslot, timeslot, matrik));
         
            if(isFeasible(randomCourses, randomTimeslot, timeslot, matrik)){
              timeslotf[randomCourses]=randomTimeslot;
              for (int i = 0; i < timeslot.length; i++) {
                 if(timeslotf[i]==-1){
                       for (int j = 0; j < totalTimeslot; j++) {
                         if(isFeasible(i, j, timeslotf, matrik)){
                             timeslotf[i]=j;
                             break;
                         }
                     }
                 }
               
                }
          
              
              double s1=ev.evaluationFunction(matrik, timeslotf, totalStudent);
                //System.out.println(s1 + " "+ s);
               if(s1<s){
                   s=s1;
                   timeslot=timeslotf;
               }else
                   timeslotf=timeslot;
                   
          }
         
  }
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







