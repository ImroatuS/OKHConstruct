/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareadtextfile;

import java.util.Random;
import java.lang.Math;

/**
 *
 * @author admin
 */
public class SimulatedAnealing {
    public void resultSA(int []timeslotA, int [][]matrik, int totalStudent,int totalTimeslot){
         EvaluationFunction ev = new EvaluationFunction();
         int [] timeslot = timeslotA;
         int [] timeslotf= timeslotA;
         double  t=0.99999;
         
         double s=ev.evaluationFunction(matrik, timeslot, totalStudent);
          boolean abc =true;
      Random r =new Random();
       int randomCourses, randomTimeslot;
        for (int i = 0; i < 100000; i++) {      
           double rd = r.nextDouble();
             t=t-0.00005;
             double p;
                       
          randomCourses = r.nextInt(timeslot.length-1);
          randomTimeslot=r.nextInt(totalTimeslot-1);
            //System.out.println(isFeasible(randomCourses, randomTimeslot, timeslot, matrik));
         
            if(isFeasible(randomCourses, randomTimeslot, timeslot, matrik)){
              timeslotf[randomCourses]=randomTimeslot;
                double s1=ev.evaluationFunction(matrik, timeslotf, totalStudent);
              double c=s-s1;
              double cabs=Math.abs(c);
              p=Math.exp(-(cabs)/t);
                //System.out.println(s1 + " "+ s);
               if(c>0){   
                   s=s1;
                   timeslot=timeslotf;
               }else{
                   if(p<rd){
                         s=s1;
                   timeslot=timeslotf;
                   }else
                   timeslotf=timeslot;
               }}
             
           
            System.out.println("iterasi ke "+i + ":    " +s );

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




