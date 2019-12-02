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
public class EvaluationFunction {
    public double evaluationFunction(int [][]matrik, int[]timeslot, int totalStudent){
        double temp=0, w, ev, temp1=0;
        int range=0;
      
          for(int i=0; i<matrik.length-1; i++){
                for(int j=i+1; j<matrik.length; j++){ 
                    range=timeslot[j]-timeslot[i];
                    if(range<=5 && range>=1)
                   w=Math.pow(2, 4-(timeslot[j]-timeslot[i]));
                    else
                        w=0;
                 temp=matrik[i][j]*w;
                 temp1=temp1+temp;
                 
            }  
                
          }
         
          ev=temp1/totalStudent;    
         for (int i = 0; i < timeslot.length; i++) {
            if(timeslot[i]==-1)
                ev=ev+1000;
        }
          
        return ev;
    }
}
