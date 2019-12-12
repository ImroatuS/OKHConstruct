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
import java.util.Random;
public class VSN {
    public void resultVSN(int []timeslotA, int [][]matrik, int totalStudent,int totalTimeslot){
        int [] timeslot = timeslotA;
      int [] timeslotf= timeslotA;
      
      //inisial solusi
      EvaluationFunction ev = new EvaluationFunction();
       double s=ev.evaluationFunction(matrik, timeslot, totalStudent);
        System.out.println(s);
        for(int i=0; i<200000; i++){
            System.out.println("Iterasi ke "+i+" :"+s);
             for(int k=0; k<6; k++){
        Random r =new Random();
        int rCourse1=r.nextInt(timeslot.length);
        int rCourse2=r.nextInt(timeslot.length);
        int rCourse3=r.nextInt(timeslot.length);
        int rCourse4=r.nextInt(timeslot.length);
        int rTS1=r.nextInt(totalTimeslot);
        int rTS2=r.nextInt(totalTimeslot);
        int rTS3=r.nextInt(totalTimeslot);
        int rTS4=r.nextInt(totalTimeslot);
                 if(pilihIsFeasibleK(k, rCourse1, rCourse2, rCourse3, rCourse4, rTS1, rTS2, rTS3, rTS4, timeslot, matrik)){
                    timeslotf=generateSolution(k, rCourse1, rCourse2, rCourse3, rCourse4, rTS1, rTS2, rTS3, rTS4, timeslot);
                    double s1=ev.evaluationFunction(matrik, timeslotf, totalStudent);
                //System.out.println(s1 + " "+ s);
                     if(s1<s){
                         k-=1;
                         s=s1;
                    timeslot=timeslotf;
               }else
                   timeslotf=timeslot;
                    
                 }
        }
        }
       
    }
    public boolean pilihIsFeasibleK(int pilih, int rCourse1, int rCourse2, int rCourse3,int rCourse4, int rTS1, int rTS2, int rTS3,int rTS4, int[] timeslot, int[][] matrik){
        boolean a =true;
        if(pilih==0)
            a=isFeasibleMove1(rCourse1, rTS1, timeslot, matrik);
        else if(pilih==1)
            a=isFeasibleMove2(rCourse1, rCourse2, rTS1, rTS2, timeslot, matrik);
        else if(pilih==2)
            a=isFeasibleMove3(rCourse1, rCourse2, rCourse3, rTS1, rTS2, rTS3, timeslot, matrik);
        else if(pilih==3)
            a=isFeasibleMove4(rCourse1, rCourse2, rCourse3, rCourse4, rTS1, rTS2, rTS3, rTS4, timeslot, matrik);
        else if(pilih==4)
            a=isFeasibleSwap1(rCourse1, rCourse2, timeslot, matrik);
        else if(pilih==5)
            a=isFeasibleSwap2(rCourse1, rCourse2, rCourse3, timeslot, matrik);
        return a;
    }
    public int [] generateSolution(int pilih, int rCourse1, int rCourse2, int rCourse3,int rCourse4, int rTS1, int rTS2, int rTS3,int rTS4,int [] timeSlot){
        int []timeSlotA = timeSlot;
         
         if(pilih==0)
            timeSlotA=generateSoltionMove1(rCourse1, rTS1, timeSlot);
        else if(pilih==1)
            timeSlotA=generateSoltionMove2(rCourse1, rCourse2, rTS1, rTS2, timeSlot);
        else if(pilih==2)
            timeSlotA=generateSoltionMove3(rCourse1, rCourse2, rCourse3, rTS1, rTS2, rTS3, timeSlot);
        else if(pilih==3)
            timeSlotA=generateSoltionMove4(rCourse1, rCourse2, rCourse3, rCourse4, rTS1, rTS2, rTS3, rTS4, timeSlot);
        else if(pilih==4)
            timeSlotA=generateSoltionSwap1(rCourse1, rCourse2, timeSlot);
        else if(pilih==5)
            timeSlotA=generateSoltionSwap2(rCourse1, rCourse2, rCourse3, timeSlot);
  
        
        return timeSlotA;
    }
    
    public boolean isFeasibleMove1(int rCourse1, int rTS1, int[] timeslot, int[][] matrik){
    boolean feasible =true;
    for(int j=0; j<matrik.length; j++){
              if(matrik[rCourse1][j]!=0&&timeslot[j]==rTS1){
                     feasible =false;
                     break;
              }
           }
      return feasible;
}
    public boolean isFeasibleMove2(int rCourse1, int rCourse2, int rTS1, int rTS2, int[] timeslot, int[][] matrik){
    boolean feasible =true;
    for(int j=0; j<matrik.length; j++){
              if(matrik[rCourse1][j]!=0&&timeslot[j]==rTS1 && matrik[rCourse2][j]!=0&&timeslot[j]==rTS2){
                     feasible =false;
                     break;
              }
           }
      return feasible;
}
    public boolean isFeasibleMove3(int rCourse1, int rCourse2, int rCourse3, int rTS1, int rTS2, int rTS3, int[] timeslot, int[][] matrik){
    boolean feasible =true;
    for(int j=0; j<matrik.length; j++){
              if(matrik[rCourse1][j]!=0&&timeslot[j]==rTS1 && matrik[rCourse2][j]!=0&&timeslot[j]==rTS2 && matrik[rCourse3][j]!=0&&timeslot[j]==rTS3){
                     feasible =false;
                     break;
              }
           }
      return feasible;
}
    public boolean isFeasibleMove4(int rCourse1, int rCourse2, int rCourse3,int rCourse4, int rTS1, int rTS2, int rTS3,int rTS4, int[] timeslot, int[][] matrik){
    boolean feasible =true;
    for(int j=0; j<matrik.length; j++){
              if(matrik[rCourse1][j]!=0&&timeslot[j]==rTS1 && matrik[rCourse2][j]!=0&&timeslot[j]==rTS2 && matrik[rCourse3][j]!=0&&timeslot[j]==rTS3 && matrik[rCourse4][j]!=0&&timeslot[j]==rTS4){
                     feasible =false;
                     break;
              }
           }
      return feasible;
}
    public boolean isFeasibleSwap1(int rCourse1, int rCourse2, int[] timeslot, int[][] matrik){
    boolean feasible =true;
    for(int j=0; j<matrik.length; j++){
              if(matrik[rCourse1][j]!=0&&timeslot[j]==timeslot[rCourse2] && matrik[rCourse2][j]!=0&&timeslot[j]==timeslot[rCourse1]){
                     feasible =false;
                     break;
              }
           }
      return feasible;
}
   public boolean isFeasibleSwap2(int rCourse1, int rCourse2, int rCourse3, int[] timeslot, int[][] matrik){
    boolean feasible =true;
    for(int j=0; j<matrik.length; j++){
              if(matrik[rCourse1][j]!=0&&timeslot[j]==timeslot[rCourse2] && matrik[rCourse2][j]!=0&&timeslot[j]==timeslot[rCourse3] && matrik[rCourse3][j]!=0&&timeslot[j]==timeslot[rCourse1]){
                     feasible =false;
                     break;
              }
           }
      return feasible;
} 
   public int [] generateSoltionMove1(int rCourse1, int rTS1,int [] timeSlot){
       
      return timeSlot;
   }
   public int [] generateSoltionMove2(int rCourse1, int rCourse2, int rTS1, int rTS2,int [] timeSlot){
       
      return timeSlot;
   }
   public int [] generateSoltionMove3(int rCourse1, int rCourse2, int rCourse3, int rTS1, int rTS2, int rTS3,int [] timeSlot){
       
      return timeSlot;
   }
   public int [] generateSoltionMove4(int rCourse1, int rCourse2, int rCourse3,int rCourse4, int rTS1, int rTS2, int rTS3,int rTS4,int [] timeSlot){
       
      return timeSlot;
   }
   public int [] generateSoltionSwap1(int rCourse1, int rCourse2,int [] timeSlot){
       
      return timeSlot;
   }
   public int [] generateSoltionSwap2(int rCourse1, int rCourse2, int rCourse3,int [] timeSlot){
       
      return timeSlot;
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
