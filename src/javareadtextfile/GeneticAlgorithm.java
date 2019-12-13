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
public class GeneticAlgorithm {
    
    public int [][] generateInitialSolution(int [] timeslot, int [][]matrik){
   
        int populationA[][]=new int [10][timeslot.length];
        
        for(int i=0; i<10; i++){
            for (int j = 0; j < timeslot.length; j++) {
                 populationA[i][j]=timeslot[j];
            } 
        }
        return populationA;
    }
    public double [] evaluasiChromosome(int [][] initial,int [][]matrik, int totalStudent){
        EvaluationFunction ev = new EvaluationFunction();
        double EC[]=new double [initial[0].length];
         int a[] = new int [matrik.length];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < matrik.length; j++) {
               
                a[j]=initial[i][j];
                 
            }
           EC[i]=ev.evaluationFunction(matrik, a, totalStudent);
        }
        
        return EC;
    }
     public double [] evaluasiChromosome1(int [][] initial,int [][]matrik, int totalStudent){
        EvaluationFunction ev = new EvaluationFunction();
        double EC[]=new double [initial[0].length];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < matrik.length; j++) {
                int a[] = new int [matrik.length];
                a[j]=initial[i][j];
                 EC[i]=ev.evaluationFunction(matrik, a, totalStudent);
            }
           
        }
        
        return EC;
    }
    public int [][] selection(int [][] initial, double EC []){
        Random r = new Random();
         int populationA[][]=new int [10][initial[0].length];
         //fitness[i]     = 1 / (fungsi_objektif[1]+1)
         double fitnes[]=new double[10];
         double totalFitness=0.0;
         for ( int i = 0; i < 10; i++) {
           fitnes[i] =1/EC[i];
           totalFitness=totalFitness+fitnes[i];
        }
         //mencari probabilitas: P[i] = fitness[i] / total_fitness
         double p[]=new double[10];
          for ( int i = 0; i < 10; i++) {
           p[i] =fitnes[i]/totalFitness;
        }
         //gunakan roulete wheel, untuk itu kita harus mencari dahulu nilai kumulatif probabilitasnya:
         double c[]=new double[10];
           c[0] =p[0];
           c[1] =p[0]+p[1];
           c[2] =p[0]+p[1]+p[2];
           c[3] =p[0]+p[1]+p[2]+p[3];
           c[4] =p[0]+p[1]+p[2]+p[3]+p[4];
           c[5] =p[0]+p[1]+p[2]+p[3]+p[4]+p[5];
           c[6] =p[0]+p[1]+p[2]+p[3]+p[4]+p[5]+p[6];
           c[7] =p[0]+p[1]+p[2]+p[3]+p[4]+p[5]+p[6]+p[7];
           c[8] =p[0]+p[1]+p[2]+p[3]+p[4]+p[5]+p[6]+p[7]+p[8];
           c[9] =p[0]+p[1]+p[2]+p[3]+p[4]+p[5]+p[6]+p[7]+p[8]+p[9];
        
        //random 0-1
        double rd[]=new double[10];
          for ( int i = 0; i < 10; i++) {
           rd[i] =r.nextDouble();
        }
         //pilih dg rumus  C[k-1] <= R < C[k].
         int m=0;
          for ( int i = 0; i < 10; i++) {
           if(rd[i]<=c[0]){
               for (int j = 0; j < initial[0].length; j++) {
                   populationA[i][j]=initial[0][j];
               }
           }else if(rd[i]>c[0]&&rd[i]<=c[1]){
               for (int j = 0; j < initial[1].length; j++) {
                   populationA[i][j]=initial[0][j];
               }
           }else if(rd[i]>c[1]&&rd[i]<=c[2]){
               for (int j = 0; j < initial[0].length; j++) {
                   populationA[i][j]=initial[2][j];
               }
           }else if(rd[i]>c[2]&&rd[i]<=c[3]){
               for (int j = 0; j < initial[0].length; j++) {
                   populationA[i][j]=initial[3][j];
               }
           }else if(rd[i]>c[3]&&rd[i]<=c[4]){
               for (int j = 0; j < initial[0].length; j++) {
                   populationA[i][j]=initial[4][j];
               }
           }else if(rd[i]>c[4]&&rd[i]<=c[5]){
               for (int j = 0; j < initial[0].length; j++) {
                   populationA[i][j]=initial[5][j];
               }
           }else if(rd[i]>c[5]&&rd[i]<=c[6]){
               for (int j = 0; j < initial[0].length; j++) {
                   populationA[i][j]=initial[6][j];
               }
           }else if(rd[i]>c[6]&&rd[i]<=c[7]){
               for (int j = 0; j < initial[0].length; j++) {
                   populationA[i][j]=initial[7][j];
               }
           }else if(rd[i]>c[7]&&rd[i]<=c[8]){
               for (int j = 0; j < initial[0].length; j++) {
                   populationA[i][j]=initial[8][j];
               }
           }else if(rd[i]>c[8]&&rd[i]<=c[9]){
               for (int j = 0; j < initial[0].length; j++) {
                   populationA[i][j]=initial[9][j];
               }
           }
        }
         
         return populationA;
    }
    public int [][] crossOver(int [][] population, int matrik[][],int totalStudent ){
        Random r =new Random();
         int populationA[][]=population;
         double rd = r.nextDouble();
         double crossP=0.6;
         int rdCross= r.nextInt(population[0].length-6);
         int panjang =rdCross+5;
         if(rd<0.6){
         double EC []=evaluasiChromosome(population, matrik, totalStudent);
         double EC1[]=evaluasiChromosome1(population, matrik, totalStudent);
         Arrays.sort(EC1);
         int a = 0,n=0;
        
         for (int j = 0; j < 10; j++) {
            if(EC1[8]==EC[j]){
                n=j;
                break;
            }
        }
          for (int i = 0; i < 10; i++) {
            if(EC1[9]==EC[i]){
                a=i;
                break;
            }
        }
         
            int [] child1=new int[population[0].length];
             int [] child2=new int[population[0].length];
                 for (int kx = 0; kx < population[0].length; kx++) {//0=a
                     if(kx>=rdCross&&kx<panjang)
                         child1[kx]=populationA[n][kx];
                     else
                         child1[kx]=populationA[a][kx];
                 }
                 for (int kx = 0; kx < population[0].length; kx++) {
                     if(kx>=rdCross&&kx<panjang)
                         child2[kx]=populationA[a][kx];
                     else
                         child2[kx]=populationA[n][kx];
                 }
                
                     boolean abc=true;
                     for (int j = rdCross; j < panjang; j++) {
                         if(isFeasible(j, child1[j], child1, matrik)){
                             abc=true;
                         }else{
                             abc=false;
                             break;
                         }           
                         }
                      boolean abc1=true;
                     for (int j = rdCross; j < panjang; j++) {
                         if(isFeasible(j, child2[j], child2, matrik)){
                             abc1=true;
                         }else{
                             abc1=false;
                             break;
                         }           
                         }
                     if(abc){
                         for (int i = 0; i < child1.length; i++) {
                             populationA[a][i]=child1[i];
                         }
                     }
                     if(abc){
                         for (int i = 0; i < child1.length; i++) {
                             populationA[n][i]=child2[i];
                         }
                     }
             
        }
         return populationA;
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
    public int [][] Mutasi(int [][]population, int [][]matrik, int jmhTimeslot){
        Random r= new Random();
        int [][] populationA=population;
        double p=0.1;
        double rd=r.nextDouble();
          int a[]=new int[matrik.length];
        if(rd<p){
          double rdC[]=new double[10];
          for ( int i = 0; i < 10; i++) {
           rdC[i] =r.nextDouble();
                if(rdC[i]<p){
                    int randomCourse=r.nextInt(matrik.length);
                     int randomTS=r.nextInt(jmhTimeslot);
                     for (int kj = 0; kj < matrik.length; kj++) {
                       
                        a[kj]=populationA[i][kj];
                    }
                     if(isFeasible(randomCourse, randomTS, a, matrik)){
                         populationA[i][randomCourse]=randomTS;
                     }
                }
           }
            
        }
        
        
        return populationA;
    }
    public int [] resultGA(int [] timeslot, int [][]matrik, int jumlahstudent, int maxTimesSlot){
        int a[]=new int [matrik.length];
        for (int i = 0; i < 500; i++) {
        int [][] initialSolution = generateInitialSolution(timeslot, matrik);
        double[] ev = evaluasiChromosome(initialSolution, matrik, jumlahstudent);
        int [][] resultSelection =selection(initialSolution, ev);
        int [][]resultCrossOver = crossOver(resultSelection, matrik, jumlahstudent);
        int [][]resultMutasi = Mutasi(resultCrossOver, matrik, maxTimesSlot);
        
          for(int j=0;j<matrik.length; j++){
              a[j]=resultMutasi[0][j];
          }
        double[] evend = evaluasiChromosome(resultMutasi, matrik, jumlahstudent);
       Arrays.sort(evend);
        System.out.println(ev[0]);
        }
      return a;
    }
}
