/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafinal_alexislajoie_v0.pkg1;
import java.io.IOException;

/**
 *
 * @author alexi
 */
public class JavaFinal_AlexisLajoie_V01 {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("UnusedAssignment")
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        // TODO code application logic here
        //Create Scoreboard 
        //Scoreboard myScoreboard = new Scoreboard();

        Scoreboard all = new Scoreboard();



        all.loadGames("games.txt");

        all.loadStudents("scores.txt");


        // need to fix the  saves canot find the files

//  Load data files on start, we will call two methods here to read data from files
// Show menu loop and collect user’s choice with Scanner 
        while (true) {
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
                    handleTopNforAgame(all);
                    break;
                case 5:
                    handleUpdateStudentScore(all);
                    break;
                case 6:
                    handleGameStats(all);
                    break;
                case 7:
                    handleAddNewStudent(all);
                    break;
                case 8:
                    handeSaveData(all);
                    break;
            }
        }

// Validate inputs (IDs exist, scores >= 0) 
// Save on command or exit
    }

    @SuppressWarnings("TextBlockMigration")
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

    public static void handleListGames(Scoreboard score) {
        System.out.println("handle List Games");
        score.listGames();
        Utilities.getUserChoiceStr("Press Enter to continue");
    }

    public static void handleListStudents(Scoreboard score) {
        System.out.println("handle List Students");
        score.listStudents();
        Utilities.getUserChoiceStr("Press Enter to continue");
    }

    public static void handleStudentReport(Scoreboard score) {
        System.out.println("handle Student Report");

        score.listStudents();

        String choice = Utilities.getUserChoiceStr("Enter Student ID:");

        int StudnentIdx = score.findStudentByID(choice);

        score.studentReport(StudnentIdx);
        Utilities.getUserChoiceStr("Press Enter to continue");
    }

    public static void handleTopNforAgame(Scoreboard score) {
        System.out.println("handle TopN for Agame");
        score.listGames();

        int gameInx = score.findGameByID(Utilities.getUserChoice("Enter the Number of the game"));

        int N = score.findGameByID(Utilities.getUserChoice("Enter the top N you want to see"));
        score.TopNForGame(gameInx, N);
        Utilities.getUserChoiceStr("Press Enter to continue");
    }

    public static void handleUpdateStudentScore(Scoreboard score) {
        System.out.println("handleUpdateStudentScore");

        score.listStudents();

        String choice = Utilities.getUserChoiceStr("Enter Student ID:");

        int StudnentIdx = score.findStudentByID(choice);

        score.listGames();

        int gameInx = score.findGameByID(Utilities.getUserChoice("Enter the Number of the game"));

        int newScore = Utilities.getUserChoice("Enter the new Score");

        score.updatescore(StudnentIdx, gameInx, newScore);
        Utilities.getUserChoiceStr("Press Enter to continue");
    }

    public static void handleGameStats(Scoreboard score) {
        System.out.println("handleGameStats");

        score.listGames();
        int gameInx = score.findGameByID(Utilities.getUserChoice("Enter the Number of the game"));

        System.out.print(score.computeStatsForGame(gameInx).toString());
        Utilities.getUserChoiceStr("Press Enter to continue");
    }

    public static void handleAddNewStudent(Scoreboard score) {
        System.out.println("handleAddNewStudent");

        String id,name;

        id = Utilities.getUserChoiceStr("Enter Student ID:");
        name = Utilities.getUserChoiceStr("Enter Student Name:");

        score.handleNewStudent(id,name);
        Utilities.getUserChoiceStr("Press Enter to continue");

    }

    public static void handeSaveData(Scoreboard score) throws IOException {
        System.out.println("handeSaveData");

        score.saveGames("games.txt");
        score.saveStudents("scores.txt");
        System.out.println("Save Succesfull");

        Utilities.getUserChoiceStr("Press Enter to continue");

    }

}
