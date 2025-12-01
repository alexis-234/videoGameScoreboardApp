/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafinal_alexislajoie_v0.pkg1;

/**
 *
 * @author alexi
 */
public class Game {
    private int id;
    private String title;
    private String genre;
    private String publisher;
    
    public Game() {
        this.id = 0;
        this.title = "";
        this.genre = "";
        this.publisher = "";
    }
    
    public Game(int id, String title, String genre, String publisher) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
    }
    
    // // constructiong the Game object based on the dataline
    public Game(String line){
        String[] lines = line.split(",");
        this.id = Integer.parseInt(lines[0]);
        this.title = lines[1];
        this.genre = lines[2];
        this.publisher = lines[3];
        
        
    }
    
    // creating a line of text that is used by fromDataLine(String) and Game(String) 
    public String toDataLine() {
        
        return String.format("%d,%s,%s,%s", id, title, genre, publisher);
    }
    
    // creates a dataline to store the Game object in a text format that can be reconstructed
    public static Game fromDataLine(String line) {
        String[] lines = line.split(",");
        Game hello = new Game(Integer.parseInt(lines[0]), lines[1], lines[2],lines[3]);
        
        return hello;
        
        
    }
    
     // returns boolean expresssion(true) when both object contain same data
    public String toString() {
        
        return String.format("%d - %s (%s, %s)", id, title, genre, publisher);
    }
    
    // creats a string to visualize yhe object 
    public boolean equals(Game other) {
        
        return (this.id == other.id && this.genre.equals(other.genre) && this.title.equals(other.title) && this.publisher.equals(other.publisher));
        
    }

    
    //getters and setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    
}
