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
        int range=0, ranges=0;
      
          for(int i=0; i<matrik.length-1; i++){
                for(int j=i+1; j<matrik.length; j++){
                    int cij=matrik[i][j];
                    range=timeslot[j]-timeslot[i];
                    ranges=Math.abs(range);
                 //   System.out.println(range);
                    if(ranges<=5 && ranges>=1)
                   w=Math.pow(2, (5-ranges));
                    else
                        w=0;
                 temp=cij*w;
                 temp1=temp1+temp;
                  
            }  
                    
          }
          ev=temp1/totalStudent;    
        return ev;
    }
}
