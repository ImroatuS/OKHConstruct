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
import java.util.Arrays;
import java.util.Random;


public class DriverClass {

    public static void main(String[] args) {
        
        ReadFile rf = new ReadFile();
        Fleksibel f =new Fleksibel();
        MatriksConflict mc =new MatriksConflict();
        BismillahTimeslot ts = new BismillahTimeslot();
        OuputFile of = new OuputFile();
        EvaluationFunction ev=new EvaluationFunction();
        HillClimbing hc=new HillClimbing();
        SimulatedAnealing sa = new SimulatedAnealing();
        VSN vsn= new VSN();
        GeneticAlgorithm ga =new GeneticAlgorithm();
        
        try
        {
       
            /*Input String 
            0:car-f-92.stu     Carleton92
            1:car-s-91.stu     Carleton91
            2:uta-s-92.stu	TorontoAS92 
            3:rye-s-93.stu       feasible initialnya tpi lama
            4:pur-s-93.stu
            5:ute-s-92.stu	TorontoE92 
            6:tre-s-92.stu	Trent92
            7:lse-f-91.stu	LSE91     
            8:kfu-s-93.stu   	KingFahd93
            9:yor-f-83.stu  	YorkMills83 
            10:hec-s-92.stu    EdHEC92     
            11:ear-f-83.stu    EarlHaig83  
            12:sta-f-83.stu  St.Anderws83 */         
            int file=1;
            //3 Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 483
            String[] lines = rf.readLines(f.fileInputName(file));
           // mc.createMatriksKhusus(file, lines);
          
      //   int [][]matrikTS =mc.createMatriks(f.totalCourse(file), lines);
          int [][]matrik =mc.createMatriks(f.totalCourse(file), lines);
    //    int a[]=  ts.jumlahDegree(matrik);
        int a[]=ts.alokasiwarna1(f.maxTimesSlot(file), matrik);
      //  ts.degreeterbesar(a, b);
            ga.resultGA(a, matrik, lines.length, f.maxTimesSlot(file));
        // vsn.resultVSN(a, matrik, lines.length, f.maxTimesSlot(file));
   // int [] hasil=  hc.resultHC(a, matrik, lines.length, f.maxTimesSlot(file));
             //sa.resultSA(a, matrik, lines.length, f.maxTimesSlot(file));
      
       //of.outputMatrik( matrik, f.fileMatrikName(file))
  //  of.outputTimeSlot(a, f.fileTimeslotName(file));
       //  System.out.println(ev.evaluationFunction(matrikTS, a, lines.length));
            // int coba[]={28,11,23,6,31,17,22,10,0,17,3,5,7,19,27,18,31,5,10,13,31,1,14,7,30,8,23,23,26,23,30,22,11,8,8,29,23,11,12,14,12,12,22,12,12,12,13,3,4,24,30,1,15,15,12,29,18,23,7,31,3,19,21,26,30,5,3,31,0,7,14,3,29,26,8,3,12,18,1,29,9,23,15,25,5,26,10,6,15,31,28,4,4,16,13,27,28,6,13,7,15,22,27,1,4,8,24,12,2,23,0,17,9,20,31,16,29,9,7,13,14,2,1,7,18,30,12,22,31,6,12,20,16,16,19,4,25,15,5,3,11,19,23,0,0,9,28,28,13,17,15,11,22,20,16,30,8,23,27,14,24,31,9,13,22,2,2,27,0,6,12,22,24,24,21,3,3,5,5,31,31,18,27,26,24,14,2,17,0,0,1,12,30,28,7,14,24,20,30,23,5,25,8,10,10,3,8,10,2,2,1,16,2,31,27,10,22,31,15,22,4,10,0,21,16,19,15,1,30,7,25,0,22,23,10,17,2,23,29,22,6,15,13,25,0,31,0,20,1,31,7,28,26,5,20,20,20,20,20,20,20,23,26,23,27,5,28,30,11,3,19,18,18,25,6,1,19,5,14,0,12,31,28,21,7,23,0,0,0,0,0,1,1,1,1,1,13,5,5,16,19,21,9,9,25,27,1,26,7,29,23,16,6,18,29,12,10,3,20,7,0,29,15,22,28,17,4,27,31,31,31,31,28,8,18,26,30,11,25,16,15,16,19,8,26,31,17,31,3,13,0,14,15,31,25,25,24,28,26,23,5,7,6,30,12,8,24,7,26,2,14,18,9,2,17,25,8,2,21,27,16,11,31,14,25,21,2,27,20,3,9,16,8,24,0,14,6,6,7,6,6,14,6,12,0,29,9,29,24,15,24,2,24,20,7,0,28,30,18,14,29,30,29,29,27,16,15,12,12,29,31,17,29,26,31,13,2,18,6,1,20,14,31,21,14,8,0,0,30,18,18,21,23,21,21,26,0,24,18,4,20,0,22,28,0,17,14,6,31,2,15,9,7,7,8,14,11,25,5,31,0,1,31,7,14,30,11,21,0,25,7,23,11,31,31,0,17,15,4,12,30,18,6,20,20,1,2,0,15,31,13,0,10,31,24,0,25,18,27,5,28,9,26,3,0,4,2,8,22,15,10,25,5,26,8,2,8,14,4,16,21,7,17};
//           System.out.println(ev.evaluationFunction(matrik, a, 18419));
     
          
        }
        catch(IOException e)
        {
            // Print out the exception that occurred           System.out.println("Unable to create "+": "+e.getMessage());             --
        }}}