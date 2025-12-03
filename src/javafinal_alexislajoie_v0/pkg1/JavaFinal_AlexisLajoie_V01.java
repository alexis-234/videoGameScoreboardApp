/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafinal_alexislajoie_v0.pkg1;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author alexi
 */
public class JavaFinal_AlexisLajoie_V01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        // TODO code application logic here
        //Create Scoreboard 
        //Scoreboard myScoreboard = new Scoreboard();
        
        
        Scoreboard all = new Scoreboard();
        
        all.loadGames("C:\\Users\\alexi\\OneDrive - Champlain Regional College\\Documents\\Classes\\Java 1\\JavaFinal_AlexisLajoie_V0.1\\games.txt");
                
        all.loadStudents("C:\\Users\\alexi\\OneDrive - Champlain Regional College\\Documents\\Classes\\Java 1\\JavaFinal_AlexisLajoie_V0.1\\scores.txt");
        
        ///all.SaveGames("hh");
            // need to fix the  saves canot find the files

//  Load data files on start, we will call two methods here to read data from files
// Show menu loop and collect user’s choice with Scanner 
        int choice = -1;
        do {
            printMenu();
            
            choice = Utilities.getUserChoice("Please, enter choice: ");
        } while ((choice < 0) || (choice > 8));
        switch (choice) {
            case 0:
                System.exit(0);
                break;
            case 1:
                handleListGames(all);
                break;
            case 2:
                handleListStudents(all);
                break;
            case 3:
                handleStudentReport(all);
                break;
            case 4:
                handleTopNforAgame();
                break;
            case 5:
                handleUpdateStudentScore();
                break;
            case 6:
                handleGameStats();
                break;
            case 7:
                handleAddNewStudent();
                break;
            case 8:
                handeSaveData();
                break;
        }

// Validate inputs (IDs exist, scores >= 0) 
// Save on command or exit
    }

    private static void printMenu() {
        System.out.print(
                "==== Video Game Scoreboard ====\n"
                + "1) List games\n"
                + "2) List students\n"
                + "3) Show a student's report\n"
                + "4) Show top N for a game\n"
                + "5) Update a student's score\n"
                + "6) Game stats (min/max/avg)\n"
                + "7) Add a new student\n"
                + "8) Save data\n"
                + "0) Exit\n");

    }

    private static int getUserChoice(String prompt) {
        return 1;

    }

    public static void handleListGames(Scoreboard score) {
        System.out.println("handle List Games");
        score.listGames();
        
    }

    public static void handleListStudents(Scoreboard score) {
        System.out.println("handle List Students");
        score.listStudents();
    }

    public static void handleStudentReport(Scoreboard score) {
        System.out.println("handle Student Report");
        
        
         score.listStudents();
         
         String choice = Utilities.getUserChoiceStr("Enter Student ID:");
         
         int StudnentIdx = score.findStudentByID(choice);
         
         score.studentReport(StudnentIdx);
         
         
        
        
    }

    public static void handleTopNforAgame() {
        System.out.println("handle TopN for Agame");
    }

    public static void handleUpdateStudentScore() {
        System.out.println("handleUpdateStudentScore");
    }

    public static void handleGameStats() {
        System.out.println("handleGameStats");
    }

    public static void handleAddNewStudent() {
        System.out.println("handleAddNewStudent");
    }

    public static void handeSaveData() {
        System.out.println("handeSaveData");
    }

}


/*things broken to fix
Students . equals

the file writer.

as homework we need to do the find highest and lowes
, find total, find average in the scoreboard class





*/
