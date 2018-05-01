import java.io.IOException;
import java.util.Scanner;


public class Admin {

     public void login() throws IOException{
        System.out.println("Please Enter one option \n-1 create a movie file"
                         + "\t-2 diplay movies"
                         + "\n-3 add a new movie"
                         + "\t-4 delet a movie"
                         + "\n-5 display history"
                         + "\t-6 logout");
        MovieApp system = new MovieApp();
        boolean run = true;
        while (run) {
            System.out.println("\nEnter the command:");
            Scanner scanner = new Scanner(System.in);
            String _command = scanner.nextLine();
            String action="";
            switch (_command) {
                case "1":
                    system.createMovieList();
                    action="Admin Create a movie file";
                    break;
                case "2":
                    system.displayMoviesList();
                    action="admin display the movies";
                    break;
                case "3":
                    system.updateMoviesList();
                    action= "Admin add a movie";
                    break;
                case "4":
                    system.deleteMovie();
                    action= "Admin Delete a movie";
                    break;
                case "5":
                    system.displayHistory();
                    action="Admin display history";
                    break;
                case "6":
                    run = false;
                    action="Admin log out";
                    System.out.println("*****you are now logged out*****");
                    System.out.println("Enter your new command!");
                    break;
                default:
                    System.out.println("Please enter a valid command.");
                    action="Admin entered an invalid command";
                    break;
            }
            system.saveToHistory(action);
        }
    }   
}
