/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareadtextfile;
import java.util.HashSet;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class DriverClass {

    public static void main(String[] args) {
        
        ReadFile rf = new ReadFile();
        Fleksibel f =new Fleksibel();
        MatriksConflict mc =new MatriksConflict();
        TimeSlot ts = new TimeSlot();
        OuputFile of = new OuputFile();
        EvaluationFunction ev=new EvaluationFunction();
        HillClimbing hc=new HillClimbing();
        try
        {int jmhTimeslot=43;
            /*Input String 
            0:car-f-92.stu
            1:car-s-91.stu
            2:uta-s-92.stu
            3:rye-s-93.stu
            4:pur-s-93.stu
            5:ute-s-92.stu
            6:tre-s-92.stu
            7:lse-f-91.stu
            8:kfu-s-93.stu
            9:yor-f-83.stu
            10:hec-s-92.stu
            11:ear-f-83.stu
            12:sta-f-83.stu*/
            int file=2;
            String[] lines = rf.readLines(f.fileInputName(file));
           
           int [][]matrik =mc.createMatriks(f.totalCourse(file), lines);
           int []timeSlot=ts.graphColoring(matrik);
            of.outputMatrik( matrik, f.fileMatrikName(file));
         of.outputTimeSlot(timeSlot, f.fileTimeslotName(file));
           // System.out.println(ev.evaluationFunction(matrik, timeSlot, lines.length));
            
            System.out.println(hc.resultHC(timeSlot, matrik, jmhTimeslot, lines.length));
        }
        catch(IOException e)
        {
            // Print out the exception that occurred
            System.out.println("Unable to create "+": "+e.getMessage());              
        }
       
    }
  
    
}
