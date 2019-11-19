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
        double temp, w, ev, temp1=0;
          for(int i=0; i<matrik.length-1; i++)
                for(int j=i+1; j<matrik.length; j++){ 
                   w=Math.pow(2, 5-(timeslot[j]-timeslot[i]));
                 temp=matrik[i][j]*w;
                 temp1=temp1+temp;
            }        
          ev=temp1/totalStudent;     
        return ev;
    }
}
