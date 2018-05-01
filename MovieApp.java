import java.io.*;
import java.text.*;
import java.util.*;

public class MovieApp {

   private final String path = "C:\\Users\\Hasan\\Desktop\\Hasan";
   private final String moviePathFile = "C:\\Users\\Hasan\\Desktop\\Hasan\\moviesList.txt";
   private final String historyPathFile = "C:\\Users\\Hasan\\Desktop\\Hasan\\historyList.txt";
   private File dir, file, tempFile;
   private FileWriter fw;
   private String movieName, actorsName;
   private Scanner sc;
   
   public void createMovieList()throws IOException{   
      dir = new File(path);
      dir.mkdir();
   
      file = new File(dir, "moviesList.txt");
      fw = new FileWriter(file);
      fw.write(String.format("%2s %20s\r\n", "MovieNames", "ActorNames"));
      fw.flush();
      fw.close();
   
      System.out.println("MoviesList is created.");
      file = new File(dir, "favoritesList.txt");
      fw = new FileWriter(file);
      fw.write(String.format("%2s %20s\r\n", "MovieNames", "ActorNames"));
      System.out.println("Favourite List is created.");
   
      fw.flush();
      fw.close();
   
   }
   public void displayMoviesList()throws IOException {
      file = new File(moviePathFile);
   
      sc = new Scanner(file);
      while (sc.hasNextLine()) {
         System.out.println(sc.nextLine());
      }
            
   }
      public void updateMoviesList() throws IOException {
      file = new File(moviePathFile);
        
      System.out.println("Please enter the movies Name:");
      sc = new Scanner(System.in);
      movieName = sc.nextLine();
      
      if (!movieName.isEmpty()) {
         System.out.println("Please enter the actors name:");
         actorsName = sc.nextLine();
         fw = new FileWriter(file, true);
         fw.write(String.format("%2s %20s\n", movieName, actorsName));
         fw.flush();
         fw.close();
      } else {
         System.out.println("Please enter the movies name");
      } 
   }

   public void deleteMovie() {
      System.out.println("file is deleted");
   }

   public void saveToHistory(String action) throws IOException {
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Date date= new Date();
      String stamp= dateFormat.format(date);
   
      file = new File(historyPathFile);
   
      
   
      FileWriter fw = new FileWriter(file, true);
      fw.write(String.format("%2s %20s\n", stamp, action));
      fw.flush();
      fw.close();
   }

   public void displayHistory() throws IOException {

      file = new File(historyPathFile);
      sc = new Scanner(file);        
      while (sc.hasNextLine()) {
         System.out.println(sc.nextLine());
      }
   }

   public static void main(String[] args) throws IOException {

      System.out.println("************** Welcome to the Movie Appplication system*************");
      boolean run = true;
      Admin admin = new Admin();
      User user = new User();
      MovieApp ma = new MovieApp();
      while (run) {
         System.out.println("\n-1 Admin \t -2 User \t -3 shutdown");
         System.out.println("\n-Enter the command:");
         Scanner sc = new Scanner(System.in);
         String _command = sc.nextLine();
         String action = "";
         switch (_command) {
            case "1":
               admin.login();
               action = "Admin logged in";
               break;
            case "2":
               user.login();
               action = "User logged in";
               break;
            case "3":
               run = false;
               action = "system is shutdown";
               break;
            default:
               System.out.println("Please enter a valid command");
               break;
         }
         ma.saveToHistory(action);
      }
   }
}
