
package javafinal_alexislajoie_v0.pkg1;


@SuppressWarnings("unused")
public class Student {

    private final int NUMBER_OF_SCORES = 10;

    // id is stored as a String "S000" because it was asked for in the lab instructions.
    private String id;
    private String name;
    private int[] scores;

    public Student(String id, String name, int[] scores) {

        this.id = id;
        this.name = name;
        this.scores = new int[NUMBER_OF_SCORES];
        System.arraycopy(scores, 0, this.scores, 0, scores.length);

    }

    public Student() {
        this.id = "";
        this.name = "";
        this.scores = new int[NUMBER_OF_SCORES];
    }
    
    // constructing the Student object based on the data-line
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
        for (int score : this.scores) {
            total += score;
        }
        return total;
        
    }
    
    // computes the average of all the scores
    public double getAverage(){
        double avg;
        return  getTotal() / (this.scores.length * 1.0);
    }   
    

    // creates a data-line to store the Student object in a text format that can be reconstructed
    public String toDataLine(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_SCORES; i++) {
            result.append(",").append(this.scores[i]);
            
        }
        return String.format("%s,%s%s",this.getId(),this.getName(), result);
       
    }
    
    
    // initializes a Student object from the data-line
    // I chose to make a constructor for this because it makes it cleaner and simpler to understand.
    //the original idea was to make this method create a student then return it to then assign it to available name
    public Student fromDataLine(String line){
         String[] lines = line.split(",");
         int[] newid = new int[NUMBER_OF_SCORES];
         for (int i = 0; i < NUMBER_OF_SCORES; i++) {
            newid[i] = Integer.parseInt(lines[i+2].trim());
             
            
        }

        return new Student(lines[0],lines[1],newid);
        
    }
    
    
    // creats a string to visualize the object
    public String toString(){
        
        return String.format("%s - %s",this.getId(),this.getName());
    }

    // prints the score of the student
    public String printScores(){
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_SCORES; i++) {
            result.append(" ").append(this.scores[i]);
            
        }
        
        return result.toString();
    }
    

    // returns boolean expresssion(true) when both object contain same data
    public boolean equals(Student test){
        boolean array = false;
        int[] testScores;
        testScores = test.getScores();
        
        
        for (int i = 0; i < NUMBER_OF_SCORES; i++) {
            array = array || (testScores[i] == this.scores[i]);

        }
                
                
        
        return array && this.id.equals(test.id) && this.name.equals(test.name);
    }




    // geters and setters

    // sets the score of a game by its game index
    public void setScoreAtgame(int gameInx, int newScore){
        
        scores[gameInx] = newScore;
        
    }

    // gets the score of a game by its game index
    public int getScoreAt(int gameInx){
        return this.scores[gameInx];
    }

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
