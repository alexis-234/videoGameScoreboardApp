/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafinal_alexislajoie_v0.pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author alexi
 */

public class Scoreboard {
    
    private int studentCount;
    private final int MAX_STUDENTS = 100;
    private final int GAMES_COUNT = 10;
    private Game[] games;
    private Student[] students;
    
    public Scoreboard(){
        
        this.studentCount =0;
        this.students = new Student[this.MAX_STUDENTS];
        
            
    }
    
    public Scoreboard(int studentCount, Game[] games, Student[] students) {
        this.studentCount = studentCount;
        for (int i = 0; i < students.length; i++) {
            this.students[i] = students[i]; 
        }
        for (int i = 0; i < GAMES_COUNT; i++) {
            this.games[i] = games[i];
        }
    }
    
    public void loadGames(String filename) throws FileNotFoundException {
        this.games = new Game[GAMES_COUNT];
        File fileObj = new File(filename);
        Scanner myScanner = new Scanner(fileObj);
         int i =0;
        while (myScanner.hasNext()){
            games[i] = new Game(myScanner.nextLine());
            System.out.println(games[i].toDataLine());
            i++;         
        }
    }
    
    
    // *** TO FIX *** 
    // throws errors maybe due to file not found, while trying to write to a new file on desktop
    // saves the game objects to dataline on the file
    public void SaveGames(String filename) throws IOException{
        FileWriter myWriter = new FileWriter("C:\\Users\\alexi\\Desktop\\New Text Document.txt", false);
         int i =0;
         // could use games.lenghth instead of the static data
        while (i >= GAMES_COUNT){
        myWriter.write(games[i].toDataLine() + "\n");
        i++;
        
        }
        myWriter.close();
        
    }
    
     
    public void loadStudents(String filename) throws FileNotFoundException {
        File fileObj = new File(filename);
        Scanner myScanner = new Scanner(fileObj);
        System.out.print(filename);
        
        int i =0;
        while (myScanner.hasNext()){
            students[i] = new Student(myScanner.nextLine());
            System.out.println(students[i].toString() + students[i].printScores());
            i++;         
        }
    }
    // *** TO FIX *** 
    // throws errors maybe due to file not found, while trying to write to a new file on desktop
    // saves the game objects to dataline on the file
    public void SaveStudents(String filename) throws IOException{
        FileWriter myWriter = new FileWriter("filename.txt", false);
         int i =0;
         // could use games.lenghth instead of the static data
        while ( students[i] != null){
        myWriter.write(students[i].toDataLine() + "\n");
        i++;
        
        }
        myWriter.close();
        
    }
    
    public void listGames(){
        
        for(Game i : this.games){
            System.out.print(i.toString() + "\n");
        }
    }
    
    public void listStudents(){
        
        for(Student i : this.students){
            System.out.print(i.toString() + "\n");
        }
        
    }
    
    public int findStudentByID(String ID){
        int foundIndex = -1;
        
        for (int i = 0; i < students.length; i++) {
            if(this.students[i].getId().equals(ID)){
                foundIndex = i;
                break;
            }
            
        }
       return foundIndex;
        
    }
    
     public int findGameByID(int ID){
        int foundIndex = -1;
        
        for (int i = 0; i < games.length; i++) {
            if(this.games[i].getId() == ID){
                foundIndex = i;
                break;
            }
            
        }
       return foundIndex;
        
    }
           
     // needed to create the class setScoreAtgame() inside of the Student to prevent the need of copying the full array and pushing it back in
    public void updatescore(String studentReq, int gameReq, int newScore){
        
        int studentInx = this.findStudentByID(studentReq);
        int gameInx = this.findGameByID(gameReq);
        
        if (studentInx == -1 && gameInx == -1){
            System.out.printf("Student with Id: %s and/or gmae with Id: %d is not found");
        }
        else{
            students[studentInx].setScoreAtgame(gameInx, newScore);
        }
       
    }
    
    // gets game data afrom the game index, thn it creates a Stats object for the 
    public void computeStatsForGames(int gameIndex){ // sould return Stats
    
    int[] scoreforgigenGame = new int[this.studentCount];
        for (int i = 0; i < this.studentCount; i++) {
            Student s = this.students[i] ;
            int[] allHiScores = s.getScores();
            scoreforgigenGame[i] =  allHiScores[gameIndex];
        }
    
    }
    
    // getters and setters

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public Game[] getGames() {
        return games;
    }

    public void setGames(Game[] games) {
        this.games = games;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
    
    
    
    class Stats{
        
        int min; 
        int max; 
        double avg;

        public Stats(int min, int max, double avg) {
            this.min = min;
            this.max = max;
            this.avg = avg;
        }
        
       
        
    }
    
    // find highest, find total, find average in a static class
            
    
}
