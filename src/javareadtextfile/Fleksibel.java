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
public class Fleksibel {
    public String fileInputName(int i){
        String fileName="";
        String [] name = new String[]{"D:\\Toronto\\car-f-92.stu",
                                        "D:\\Toronto\\car-s-91.stu",
                                        "D:\\Toronto\\uta-s-92.stu",
                                        "D:\\Toronto\\rye-s-93.stu",
                                        "D:\\Toronto\\pur-s-93.stu",
                                        "D:\\Toronto\\ute-s-92.stu",
                                        "D:\\Toronto\\tre-s-92.stu",
                                        "D:\\Toronto\\lse-f-91.stu",
                                        "D:\\Toronto\\kfu-s-93.stu",
                                        "D:\\Toronto\\yor-f-83.stu",
                                        "D:\\Toronto\\hec-s-92.stu",
                                        "D:\\Toronto\\ear-f-83.stu",
                                        "D:\\Toronto\\sta-f-83.stu"};
        for(int j=0; j<name.length; j++){
            if(j==i)
                fileName=name[j];
        }
        return fileName;
    }
    public String fileMatrikName(int i){
        String fileName="";
     
         String [] name = new String[]{"D:/matkul ITS/semester 7/OKH/Matrik/car-f-92.txt",
                                        "D:/matkul ITS/semester 7/OKH/Matrik/car-s-91.txt",
                                         "D:/matkul ITS/semester 7/OKH/Matrik/uta-s-92.txt",
                                        "D:/matkul ITS/semester 7/OKH/Matrik/rye-s-93.txt",
                                        "D:/matkul ITS/semester 7/OKH/Matrik/pur-s-93.txt",
                                        "D:/matkul ITS/semester 7/OKH/Matrik/ute-s-92.txt",
                                        "D:/matkul ITS/semester 7/OKH/Matrik/tre-s-92.txt",
                                        "D:/matkul ITS/semester 7/OKH/Matrik/lse-f-91.txt",
                                        "D:/matkul ITS/semester 7/OKH/Matrik/kfu-s-93.txt",
                                        "D:/matkul ITS/semester 7/OKH/Matrik/yor-f-83.txt",
                                        "D:/matkul ITS/semester 7/OKH/Matrik/hec-s-92.txt",
                                        "D:/matkul ITS/semester 7/OKH/Matrik/ear-f-83.txt",
                                        "D:/matkul ITS/semester 7/OKH/Matrik/sta-f-83.txt"};
         for(int j=0; j<name.length; j++){
            if(j==i)
                fileName=name[j];
        }
        return fileName;
    }
    public String fileTimeslotName(int i){
        String fileName="";
             String [] name = new String[]{"D:/matkul ITS/semester 7/OKH/ExamTimeTableEvaluation/Carleton92.sol",
                                            "D:/matkul ITS/semester 7/OKH/ExamTimeTableEvaluation/Carleton91.sol",
                                            "D:/matkul ITS/semester 7/OKH/ExamTimeTableEvaluation/TorontoAS92.sol",
                                            "D:/matkul ITS/semester 7/OKH/ExamTimeTableEvaluation/rye-s-93.sol",
                                            "D:/matkul ITS/semester 7/OKH/ExamTimeTableEvaluation/pur-s-93.sol",
                                            "D:/matkul ITS/semester 7/OKH/ExamTimeTableEvaluation/TorontoE92.sol",
                                            "D:/matkul ITS/semester 7/OKH/ExamTimeTableEvaluation/Trent92.sol",
                                            "D:/matkul ITS/semester 7/OKH/ExamTimeTableEvaluation/LSE91.sol",
                                            "D:/matkul ITS/semester 7/OKH/ExamTimeTableEvaluation/KingFahd93.sol",
                                            "D:/matkul ITS/semester 7/OKH/ExamTimeTableEvaluation/YorkMills83.sol",
                                            "D:/matkul ITS/semester 7/OKH/ExamTimeTableEvaluation/EdHEC92.sol",
                                            "D:/matkul ITS/semester 7/OKH/ExamTimeTableEvaluation/EarlHaig83.sol",
                                           "D:/matkul ITS/semester 7/OKH/ExamTimeTableEvaluation/St.Andrews83.sol"
                                            };
         for(int j=0; j<name.length; j++){
            if(j==i)
                fileName=name[j];
        }
        return fileName;
    }
     public int totalCourse (int i){
        int total_course=0;
        int temp[]=new int []{543,682,622,486,2419,184,261,381,461,181,81,190,139};
        for(int j=0; j<temp.length; j++){
            if(j==i)
                total_course=temp[j];
        }
        return total_course;
    }
     public int maxTimesSlot(int pilih){
         int jmhTS=0;
         int a[]={32,35,35,23,42,10,23,18,20,21, 18,24,35};
         for (int i = 0; i < a.length; i++) {
             if(pilih==i)
                 jmhTS=a[i];
                 
         }
         
         return jmhTS;
     }
}
