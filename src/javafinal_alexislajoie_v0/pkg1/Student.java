/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafinal_alexislajoie_v0.pkg1;

/**
 *
 * @author alexi
 */
public class Student {

    private final int NUMBER_OF_SCORES = 10;

    private String id;
    private String name;
    private int[] scores;

    public Student(String id, String name, int[] scoresInt) {

        this.id = id;
        this.name = name;
        this.scores = new int[NUMBER_OF_SCORES];
        for (int i = 0; i < scores.length; i++) {
            this.scores[i] = scores[i];

        }

    }

    public Student() {
        this.id = "";
        this.name = "";
        this.scores = new int[NUMBER_OF_SCORES];
    }
    
    // constructiong the Student object based on the dataline
    public Student(String line){
        String[] lines = line.split(",");
         this.scores = new int[NUMBER_OF_SCORES];
         for (int i = 0; i < NUMBER_OF_SCORES; i++) {
            this.scores[i] = Integer.parseInt(lines[i+2].trim());
        }
         this.id = lines[0];
        this.name = lines[1];
        
    }
    
    // computes the total of the scores the student has
    public int getTotal(){
        int total = 0;
        for (int i = 0; i < this.scores.length; i++) {
            total += this.scores[i];
          }
        return total;
        
    }
    
    // computes the average of all the scores
    public int getAverage(){
        int avg;
        avg = getTotal() / this.scores.length;
        return avg;
    }   
    
    // will not work!! need to print out the individual scores 
    // ^^^ FIXED ^^^
    // creates a dataline to store the Student object in a text format that can be reconstructed
    public String toDataLine(){
        String result = "";
        for (int i = 0; i < NUMBER_OF_SCORES; i++) {
            result = result + "," + this.scores[i];
            
        }
        return String.format("%s,%s%s",this.getId(),this.getName(),result);
       
    }
    
    
    /// initializes a Student object from the dataline
    public Student fromDataLine(String line){
         String[] lines = line.split(",");
         int[] newid = new int[NUMBER_OF_SCORES];
         for (int i = 0; i < NUMBER_OF_SCORES; i++) {
            newid[i] = Integer.parseInt(lines[i+2].trim());
             
            
        }
         
         Student p = new Student(lines[0],lines[1],newid);
         return p;
        
    }
    
    
    // creats a string to visualize yhe object 
    public String toString(){
        
        return String.format("%s - %s",this.getId(),this.getName());
    }
    
    public String printScores(){
        
        String result = "";
        for (int i = 0; i < NUMBER_OF_SCORES; i++) {
            result = result + " "+ this.scores[i];
            
        }
        
        return result;
    }
    
    // NEED TO CODE THE CLASS
    // returns boolean expresssion(true) when both object contain same data
    public boolean equals(Student test){
        boolean array = false;
        int[] testScores;
        testScores = test.getScores();
        
        
        for (int i = 0; i < NUMBER_OF_SCORES; i++) {
            array = array && testScores[i] == this.scores[i];
            
        }
                
                
        
        return array && this.id.equals(test.id) && this.name.equals(test.name);
    }
    
    public void setScoreAtgame(int gameInx, int newScore){
        
        scores[gameInx] = newScore;
        
    }
            
    
    
    // geters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }
    
    
    
    
}
