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
  public double resultHC(int [] timeslot, int [][]matrik, int totalTimeslot, int totalStudent){
      EvaluationFunction ev = new EvaluationFunction();
      double currentSolution=ev.evaluationFunction(matrik, timeslot, totalStudent);
      double s1=0.0;
      Random r =new Random();
      for(int i=0; i<1000; i++){
          int randomC = r.nextInt(timeslot.length);
          int randomT=r.nextInt(totalTimeslot);        
          for(int j=0; j<matrik.length; j++){
              if(matrik[randomC][j]!=0&&timeslot[j]!=randomT){
                 
                     timeslot[randomC]=randomT;
                     s1=ev.evaluationFunction(matrik, timeslot, totalStudent);
                  
              }
          }
          if(s1<currentSolution)
              currentSolution=s1;
      }
      
      return currentSolution;
      
  }
}
