import java.io.*;
import java.util.Scanner;

public class User {

   private final String favoritePathFile;
   private final String moviePathFile;
   private File file;
   private FileWriter fw;
   private Scanner sc;
    
   public User(){
      favoritePathFile = "C:\\Users\\Hasan\\Desktop\\Hasan\\favoritesList.txt";
      moviePathFile = "C:\\Users\\Hasan\\Desktop\\Hasan\\moviesList.txt";
   }
   
    
   public void login() throws IOException{
   
      System.out.println("Please Enter a command: \n-1 diplay movies"
                         + "\n-2 display my favorite list"
                         + "\n-3 add to my foavourite list"
                         + "\n-4 delete from my favoritelist"
                         + "\n-5 logout");
      MovieApp system = new MovieApp();
      boolean run = true;
      while (run) {
         
         System.out.println("\nEnter the command:");
         Scanner scanner = new Scanner(System.in);
         String _command = scanner.nextLine();
         String action="";
         switch (_command) {
            case "1":
               system.displayMoviesList();
               action= "user display movies";
               break;
            case "2":
               displayFavouritesList();
               action= "user siplay the favorites list.";
               break;
            case "3":
               updateFavoritesList();
               action= "user add a movie to his favorits lis";
               break;
            case "4":
               deleteMovie();
               action= "user delete a movie from the favourites list";
               break;
            case "5":
               run = false;
               action= "user logged out";
               System.out.println("*****you are logged out*****"); 
               System.out.println("tak for idag");                       
               break;
            default:
               System.out.println("Please enter a valid command.");
               action= "user enters an invaild command";
               break;
         }
         system.saveToHistory(action);
      }
   }

   private void displayFavouritesList()throws IOException {

      file = new File(favoritePathFile);     
      sc = new Scanner(file);
      while (sc.hasNextLine()) {
         System.out.println(sc.nextLine());
      }
   }
    
   private boolean isExisted(String movieName)throws IOException {
      boolean result= false;
      
      file = new File(favoritePathFile);
      sc = new Scanner(file);
      while (sc.hasNextLine()) 
      {
         String str = sc.nextLine();
         if (str.contains(movieName))
         {
            System.out.println("EXISTS");
            result= true;
         }
      }
      return result;
   }

   private void updateFavoritesList()throws IOException {
      file = new File(favoritePathFile);
      System.out.println("Please enter the movies Name:");
      sc = new Scanner(System.in);
      String movieName = sc.nextLine();
            
      if(isExisted(movieName) == true)
      { 
         System.out.println("Please enter the actors name:");
         String actorsName = sc.nextLine();
      
         fw = new FileWriter(file, true);
         fw.write(String.format("%2s %20s\n", movieName, actorsName));
         fw.flush();
         fw.close();
      }
      else
      {
         System.out.println("movie is not existed in the movie list");
      }            
   }
    
   private void deleteMovie(){
      System.out.println("the movie is deleted from the list");}
    
}
