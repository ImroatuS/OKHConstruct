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
import java.util.Random;


public class DriverClass {

    public static void main(String[] args) {
        
        ReadFile rf = new ReadFile();
        Fleksibel f =new Fleksibel();
        MatriksConflict mc =new MatriksConflict();
        ArrayIndex ts = new ArrayIndex();
        OuputFile of = new OuputFile();
        EvaluationFunction ev=new EvaluationFunction();
        HillClimbing hc=new HillClimbing();
        SimulatedAnealing sa = new SimulatedAnealing();
      
        VSN vsn = new VSN();
        try
        {
       
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
            int file=0;
            //3 Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 483
            String[] lines = rf.readLines(f.fileInputName(file));
           // mc.createMatriksKhusus(file, lines);
        
           int [][]matrikTS =mc.createMatriks(f.totalCourse(file), lines);
            int [][]matrik =mc.createMatriks(f.totalCourse(file), lines);
           int a []=ts.alokasiWarna(f.maxTimesSlot(file), matrikTS);
           //hc = hill climbing
           //sa = simulated anealing
           //ngerunnya satu satu hc dulu atau sa dulu
//           hc.resultHC(a, matrik, lines.length, f.maxTimesSlot(file));
             sa.resultSA(a, matrik, lines.length, f.maxTimesSlot(file));
      
         //   of.outputMatrik( matrik, f.fileMatrikName(file))
        // of.outputTimeSlot(timeSlot, f.fileTimeslotName(file));
         //   System.out.println(ev.evaluationFunction(matrik, a, lines.length));
            
          
          // vsn.resultVSN(a, matrik, lines.length, f.maxTimesSlot(file));
        }
        catch(IOException e)
        {
            // Print out the exception that occurred           System.out.println("Unable to create "+": "+e.getMessage());             --
        }}}