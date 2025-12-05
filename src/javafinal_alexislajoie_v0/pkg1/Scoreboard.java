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
import javafinal_alexislajoie_v0.pkg1.Game;
import javafinal_alexislajoie_v0.pkg1.Student;

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

    public Scoreboard() {

        this.studentCount = 0;
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
        int i = 0;
        while (myScanner.hasNext()) {
            games[i] = new Game(myScanner.nextLine());
            System.out.println(games[i].toDataLine());
            i++;
        }
    }

    // *** TO FIX *** 
    // throws errors maybe due to file not found, while trying to write to a new file on desktop
    // saves the game objects to dataline on the file
    public void saveGames(String filename) throws IOException {
        FileWriter myWriter = new FileWriter(filename, false );
        int i = 0;
        // could use games.lenghth instead of the static data
        while (i <= GAMES_COUNT-1) {
            myWriter.write(games[i].toDataLine() + "\n");
            i++;

        }
        myWriter.close();

    }

    public void loadStudents(String filename) throws FileNotFoundException {
        File fileObj = new File(filename);
        Scanner myScanner = new Scanner(fileObj);
        System.out.print(filename);

        int i = 0;
        while (myScanner.hasNext()) {
            students[i] = new Student(myScanner.nextLine());
            System.out.println(students[i].toString() + students[i].printScores());
            i++;
        }

        this.studentCount = i;
    }

    // *** TO FIX *** 
    // throws errors maybe due to file not found, while trying to write to a new file on desktop
    // saves the game objects to dataline on the file
    public void saveStudents(String filename) throws IOException {
        FileWriter myWriter = new FileWriter(filename, false);
        int i = 0;
        // could use games.lenghth instead of the static data
        while (students[i] != null) {
            myWriter.write(students[i].toDataLine() + "\n");
            i++;

        }
        myWriter.close();

    }

    public void listGames() {
        System.out.println("Games:");
        for (int i = 0; i < this.games.length; i++) {
            int num = i + 1;
            System.out.print(num + ") " + this.games[i].toString() + "\n");
        }
    }

    public void listStudents() {
        System.out.println("Students:");
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null) {
                int num = i + 1;
                System.out.print(num + ") " + this.students[i].toString() + "\n");
            }
        }

    }
    
    public void listStudents(int N, int gameInx) {
        System.out.println("Students:" + this.studentCount);
        int num = 1;
        for (int i = this.studentCount -1; i > this.studentCount - N -2; i--) {
            if (this.students[i] != null) {
                
                //System.out.print(num + ") " + this.students[i].toString() + "\n");
                System.out.printf("%d) %s - %d \n",num,this.students[i],this.students[i].getScoreAt(gameInx));
                num ++;
            }
        }

    }


    // decision made to return index instead of student objec to it an be used in differne situations saving memeory
    public int findStudentByID(String ID) {
        int foundIndex = -1;

        for (int i = 0; i < students.length; i++) {
            if (this.students[i].getId().equals(ID)) {
                foundIndex = i;
                break;
            }

        }
        return foundIndex;

    }

    public int findGameByID(int ID) {
        int foundIndex = -1;

        for (int i = 0; i < games.length; i++) {
            if (this.games[i].getId() == ID) {
                foundIndex = i;
                break;
            }

        }
        return foundIndex;

    }

    // needed to create the class setScoreAtgame() inside of the Student to prevent the need of copying the full array and pushing it back in
    public void updatescore(int studentInx, int gameInx, int newScore) {

        if (studentInx == -1 && gameInx == -1) {
            System.out.printf("Student with Id: %s and/or gmae with Id: %d is not found");
        } else {
            students[studentInx].setScoreAtgame(gameInx, newScore);
        }

    }

    // needs to be in Scoreboard to have acces to the Game names
    public void studentReport(int stuInx) {
        System.out.printf("Report for %s\n", this.students[stuInx].getName());
        for (int i = 0; i < this.students[stuInx].getScores().length; i++) {
            System.out.printf("\t%s : %d \n", this.games[i].getTitle(), this.students[stuInx].getScores()[i]);

        }
        System.out.printf("Total: %d\n", this.students[stuInx].getTotal());
        System.out.printf("Average: %.2f\n", this.students[stuInx].getAverage());

    }

    // canot make the array of scores
    public void TopNForGame(int gameInx, int topN) {
        int[] scoreforgigenGame = new int[this.studentCount];
       

        for (int i = 0; i < this.studentCount; i++) {
            Student s = this.students[i];
            int[] allHiScores = s.getScores();
            scoreforgigenGame[i] = allHiScores[gameInx];}

        Utilities.sortArrayListBasedOnScore(scoreforgigenGame, this.students);
        // printing the top N
        System.out.println("Students:" + this.studentCount);
        int num = 1;
        for (int i = this.studentCount -1; i > this.studentCount - topN -2; i--) {
            if (this.students[i] != null) {
                
                //System.out.print(num + ") " + this.students[i].toString() + "\n");
                System.out.printf("%d. %-15s (%s) - %d \n",num,this.students[i].getName(),this.students[i].getId(),this.students[i].getScoreAt(gameInx));
                num ++;
            }
        }
       
        }

    // gets game data from the game index, then it creates a Stats object for the object 
    public Stats computeStatsForGame(int gameIndex) { // sould return Stats
        // create a new array to save the scores
        int[] scoreforgigenGame = new int[this.studentCount];
        // go through  all the students and copy the score of a certain game into the scores array
        for (int i = 0; i < this.studentCount; i++) {
            Student s = this.students[i];
            int[] allHiScores = s.getScores();
            scoreforgigenGame[i] = allHiScores[gameIndex];
        }

        // finding maximum, minimum and average in utilities
        int max = Utilities.findMaximum(scoreforgigenGame);
        int min = Utilities.findMinimum(scoreforgigenGame);
        double avg = Utilities.findAvg(scoreforgigenGame);

       return new Stats(min, max, avg);

    }

    public void handleNewStudent(String id, String name) {


        boolean temp = true;

        for (int i = 0; i < this.studentCount -1 ; i++) {
            if (this.students[i].getId().equals(id)) {
                temp = false;
            }
        }

        if(temp){
        int[] scores = new int[GAMES_COUNT];

        for (int i = 0; i < GAMES_COUNT; i++) {

            scores[i] = Utilities.getUserChoice("Enter the score for " + this.games[i].getTitle());
        }

        students[studentCount-1] = new Student(id,name,scores);

        // add one student to total count
        this.studentCount = this.studentCount +1;

        }

        else {
            System.out.printf("Student ID %s is already in use\n", id);
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

    class Stats {

        int min;
        int max;
        double avg;

        public Stats(int min, int max, double avg) {
            this.min = min;
            this.max = max;
            this.avg = avg;
        }
        
        public String toString(){
            
            return String.format("Min: %d, Max: %d, Avg: %.2f \n", this.min,this.max,this.avg);
        }
                

    }

    // find highest, find total, find average in a static class
}
