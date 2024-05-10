import java.io.*;
import java.util.Scanner;

/**
 * Part three class
 */
public class PartThree {

    /**
     * Implements and displays the main menu method.
     * @param args
     */
    public static void main(String[] args) {

        mainManu("0");

    }


    /**
     * Opens each of the eight binary files produced in Part 2.
     * Deserializes the object in each binary file into an array of Book objects.
     * Takes input from the user and displaays the Main Menu.
     * Option s prompts the user to select a file through the following menu.
     * Option v allows the user to navigate the currently selected file, initially, any one of the arrays.
     * @param str the input String given
     */
    public static void mainManu(String str){

        String CCB = "Carton_Comics_Books.csv.Ser";
        String HCB = "Hobbies_Collectibles_Books.csv.Ser";
        String MTV = "Movies_TV_Books.csv.Ser";
        String MRB = "Music_Radio_Books.csv.Ser";
        String NEB = "Nostalgia_Eclectic_Books.csv.Ser";
        String OTR = "Old_Time_Radio_Books.csv.Ser";
        String SSM = "Sports_Sports_Memorabilia_Books.csv.Ser";
        String TPA = "TrainsPlanesAutomobiles_Book.csv.Ser";

        ObjectInputStream cartonDeSer = null;
        ObjectInputStream hobbiesDeSer = null;
        ObjectInputStream moviesDeSer = null;
        ObjectInputStream musicDeSer = null;
        ObjectInputStream nostalgiaDeSer = null;
        ObjectInputStream oldRadioDeSer = null;
        ObjectInputStream sportsDeSer = null;
        ObjectInputStream trainsDeSer = null;

        try {
            cartonDeSer = new ObjectInputStream(new FileInputStream("Carton_Comics.csv.Ser"));
            hobbiesDeSer = new ObjectInputStream(new FileInputStream("Hobbies_Collectibles.csv.Ser"));
            moviesDeSer = new ObjectInputStream(new FileInputStream("Movies_TV_Books.csv.Ser"));
            musicDeSer = new ObjectInputStream(new FileInputStream("Music_Radio_Books.csv.Ser"));
            nostalgiaDeSer = new ObjectInputStream(new FileInputStream("Nostalgia_Eclectic_Books.csv.Ser"));
            oldRadioDeSer = new ObjectInputStream(new FileInputStream("Old_Time_Radio_Books.csv.Ser"));
            sportsDeSer = new ObjectInputStream(new FileInputStream("Sports_Sports_Memorabilia.csv.Ser"));
            trainsDeSer = new ObjectInputStream(new FileInputStream("TrainsPlanesAutomobiles.csv.Ser"));
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        }

        Book[] cartonArray = new Book[21];
        Book[] hobbiesArray = new Book[33];
        Book[] moviesArray = new Book[698];
        Book[] musicArray = new Book[464];
        Book[] nostalgiaArray = new Book[49];
        Book[] oldRadioArray = new Book[7];
        Book[] sportsArray = new Book[179];
        Book[] trainsArray = new Book[34];

        try {
            for (int i = 0; i < cartonArray.length; i++){
                cartonArray[i] = (Book) cartonDeSer.readObject();
            }

            for (int i = 0; i < hobbiesArray.length; i++){
                hobbiesArray[i] = (Book) hobbiesDeSer.readObject();
            }

            for (int i = 0; i < moviesArray.length; i++){
                moviesArray[i] = (Book) moviesDeSer.readObject();
            }

            for (int i = 0; i < musicArray.length; i++){
                musicArray[i] = (Book) musicDeSer.readObject();
            }

            for (int i = 0; i < nostalgiaArray.length; i++){
                nostalgiaArray[i] = (Book) nostalgiaDeSer.readObject();
            }

            for (int i = 0; i < oldRadioArray.length; i++){
                oldRadioArray[i] = (Book) oldRadioDeSer.readObject();
            }

            for (int i = 0; i < sportsArray.length; i++){
                sportsArray[i] = (Book) sportsDeSer.readObject();
            }

            for (int i = 0; i < trainsArray.length; i++){
                trainsArray[i] = (Book) trainsDeSer.readObject();
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }




    while (true) {
       if (str.equalsIgnoreCase("1")) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                                   Main Manu                                      ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("  v   View the Selected File: " + CCB + " (21 Records)");
        System.out.println("  s   Selected a file to View ");
        System.out.println("  x   Exit ");
        System.out.print("\nEnter Your Choice: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean breaker1 = true;
        int counter = 0;
        switch (input.toLowerCase()) {
            case "v":
                while (breaker1) {
                    // Prompt the user to enter the number of records to display
                    System.out.print("The Current position is at index " + counter + ": Please Enter which Record You Would Like to Be: ");
                    int n = sc.nextInt();

                    if (n == 0) {
                        mainManu("1");
                    } else if (n > 0) {
                        int steps = Math.min(n - 1, cartonArray.length - 1 - counter);

                        // Display records for positive n
                        for (int i = 0; i <= steps; i++) {
                            System.out.println(cartonArray[counter].toString());
                            counter++;
                        }

                        // Check if the counter reaches the end of the array
                        if (counter == cartonArray.length) {
                            System.out.println("EOF has been reached.");
                            counter--; // Move back to the last valid index in the array
                        }
                    } else if (n < 0) {
                        int steps = Math.min(Math.abs(n) - 1, counter);

                        // Display records for negative n
                        for (int i = 0; i <= steps; i++) {
                            System.out.println(cartonArray[counter].toString());
                            counter--;
                        }

                        // Check if the counter goes below the beginning of the array
                        if (counter < 0) {
                            System.out.println("BOF has been reached.");
                            counter = 0; // Move to the first record if we went beyond the beginning
                        }
                    }
                }

                break;
            case "s":
                subMenu();
                break;
            case "x":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
        }


    } else if (str.equalsIgnoreCase("2")) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                                   Main Manu                                      ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("  v   View the Selected File: " + HCB + "  (33 Records)");
        System.out.println("  s   Selected a file to View ");
        System.out.println("  x   Exit ");
        System.out.print("\nEnter Your Choice: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int counter = 0;
        boolean breaker1 = true;
        switch (input.toLowerCase()) {
            case "v":
                while (breaker1) {
                    System.out.print("The Current position is at index " + counter + ": Please Enter which Record You Would Like to Be: ");
                    int n = sc.nextInt();

                    if (n == 0) {
                        mainManu("2");
                    } else if (n > 0) {
                        int steps = Math.min(n - 1, hobbiesArray.length - 1 - counter);

                        for (int i = 0; i <= steps; i++) {
                            System.out.println(hobbiesArray[counter].toString());
                            counter++;
                        }

                        if (counter == hobbiesArray.length) {
                            System.out.println("EOF has been reached.");
                            counter--;
                        }
                    } else if (n < 0) {
                        int steps = Math.min(Math.abs(n) - 1, counter);

                        for (int i = 0; i <= steps; i++) {
                            System.out.println(hobbiesArray[counter].toString());
                            counter--;
                        }

                        if (counter < 0) {
                            System.out.println("BOF has been reached.");
                            counter = 0;
                        }
                    }
                }
                break;
            case "s":
                subMenu();
                break;
            case "x":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
        }
    } else if (str.equalsIgnoreCase("3")) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                                   Main Manu                                      ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("  v   View the Selected File: " + MTV + "  (698 Records) ");
        System.out.println("  s   Selected a file to View ");
        System.out.println("  x   Exit ");
        System.out.print("\nEnter Your Choice: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int counter = 0;
        boolean breaker1 = true;
        switch (input.toLowerCase()) {
            case "v":
                while (breaker1) {
                    System.out.print("The Current position is at index " + counter + ": Please Enter which Record You Would Like to Be: ");
                    int n = sc.nextInt();

                    if (n == 0) {                   //int counter = 0;
                                                    // boolean breaker1 = true;
                        mainManu("3");
                    } else if (n > 0) {
                        int steps = Math.min(n - 1, moviesArray.length - 1 - counter);

                        for (int i = 0; i <= steps; i++) {
                            System.out.println(moviesArray[counter].toString());
                            counter++;
                        }

                        if (counter == moviesArray.length) {
                            System.out.println("EOF has been reached.");
                            counter--;
                        }
                    } else if (n < 0) {
                        int steps = Math.min(Math.abs(n) - 1, counter);

                        for (int i = 0; i <= steps; i++) {
                            System.out.println(moviesArray[counter].toString());
                            counter--;
                        }

                        if (counter < 0) {
                            System.out.println("BOF has been reached.");
                            counter = 0;
                        }
                    }
                }
                break;
            case "s":
                subMenu();
                break;
            case "x":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
        }
    } else if (str.equalsIgnoreCase("4")) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                                   Main Manu                                      ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("  v   View the Selected File: " + MRB + "  (464 Records) ");
        System.out.println("  s   Selected a file to View ");
        System.out.println("  x   Exit ");
        System.out.print("\nEnter Your Choice: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int counter = 0;
        boolean breaker1 = true;
        switch (input.toLowerCase()) {
            case "v":
                while (breaker1) {
                    System.out.print("The Current position is at index " + counter + ": Please Enter which Record You Would Like to Be: ");
                    int n = sc.nextInt();

                    if (n == 0) {
                        mainManu("4");
                    } else if (n > 0) {
                        int steps = Math.min(n - 1, musicArray.length - 1 - counter);

                        for (int i = 0; i <= steps; i++) {
                            System.out.println(musicArray[counter].toString());
                            counter++;
                        }

                        if (counter == musicArray.length) {
                            System.out.println("EOF has been reached.");
                            counter--;
                        }
                    } else if (n < 0) {
                        int steps = Math.min(Math.abs(n) - 1, counter);

                        for (int i = 0; i <= steps; i++) {
                            System.out.println(musicArray[counter].toString());
                            counter--;
                        }

                        if (counter < 0) {
                            System.out.println("BOF has been reached.");
                            counter = 0;
                        }
                    }
                }
                break;
            case "s":
                subMenu();
                break;
            case "x":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
        }
    } else if (str.equalsIgnoreCase("5")) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                                   Main Manu                                      ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("  v   View the Selected File: " + NEB + "  (49 Records)");
        System.out.println("  s   Selected a file to View ");
        System.out.println("  x   Exit ");
        System.out.print("\nEnter Your Choice: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int counter = 0;
        boolean breaker1 = true;
        switch (input.toLowerCase()) {
            case "v":
                while (breaker1) {
                    System.out.print("The Current position is at index " + counter + ": Please Enter which Record You Would Like to Be: ");
                    int n = sc.nextInt();

                    if (n == 0) {
                        mainManu("5");
                    } else if (n > 0) {
                        int steps = Math.min(n - 1, nostalgiaArray.length - 1 - counter);

                        for (int i = 0; i <= steps; i++) {
                            System.out.println(nostalgiaArray[counter].toString());
                            counter++;
                        }

                        if (counter == nostalgiaArray.length) {
                            System.out.println("EOF has been reached.");
                            counter--;
                        }
                    } else if (n < 0) {
                        int steps = Math.min(Math.abs(n) - 1, counter);

                        for (int i = 0; i <= steps; i++) {
                            System.out.println(nostalgiaArray[counter].toString());
                            counter--;
                        }
                        if (counter < 0) {
                            System.out.println("BOF has been reached.");
                            counter = 0;
                        }
                    }
                }
                break;
            case "s":
                subMenu();
                break;
            case "x":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
        }
    } else if (str.equalsIgnoreCase("6")) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                                   Main Manu                                      ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("  v   View the Selected File: " + OTR + "  (7 Records)");
        System.out.println("  s   Selected a file to View ");
        System.out.println("  x   Exit ");
        System.out.print("\nEnter Your Choice: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int counter = 0;
        boolean breaker1 = true;
        switch (input.toLowerCase()) {
            case "v":
                while (breaker1) {
                    System.out.print("The Current position is at index " + counter + ": Please Enter which Record You Would Like to Be: ");
                    int n = sc.nextInt();

                    if (n == 0) {
                        mainManu("6");
                    } else if (n > 0) {
                        int steps = Math.min(n - 1, oldRadioArray.length - 1 - counter);

                        for (int i = 0; i <= steps; i++) {
                            System.out.println(oldRadioArray[counter].toString());
                            counter++;
                        }

                        if (counter == oldRadioArray.length) {
                            System.out.println("EOF has been reached.");
                            counter--;
                        }
                    } else if (n < 0) {
                        int steps = Math.min(Math.abs(n) - 1, counter);

                        for (int i = 0; i <= steps; i++) {
                            System.out.println(oldRadioArray[counter].toString());
                            counter--;
                        }
                        if (counter < 0) {
                            System.out.println("BOF has been reached.");
                            counter = 0;
                        }
                    }
                }
                break;
            case "s":
                subMenu();
                break;
            case "x":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
        }
    } else if (str.equalsIgnoreCase("7")) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                                   Main Manu                                      ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("  v   View the Selected File: " + SSM + "  (179 Records)");
        System.out.println("  s   Selected a file to View ");
        System.out.println("  x   Exit ");
        System.out.print("\nEnter Your Choice: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int counter = 0;
        boolean breaker1 = true;
        switch (input.toLowerCase()) {
            case "v":
                while (breaker1) {
                    System.out.print("The Current position is at index " + counter + ": Please Enter which Record You Would Like to Be: ");
                    int n = sc.nextInt();

                    if (n == 0) {
                        mainManu("7");
                    } else if (n > 0) {
                        int steps = Math.min(n - 1, sportsArray.length - 1 - counter);

                        for (int i = 0; i <= steps; i++) {
                            System.out.println(sportsArray[counter].toString());
                            counter++;
                        }

                        if (counter == sportsArray.length) {
                            System.out.println("EOF has been reached.");
                            counter--;
                        }
                    } else if (n < 0) {
                        int steps = Math.min(Math.abs(n) - 1, counter);

                        for (int i = 0; i <= steps; i++) {
                            System.out.println(sportsArray[counter].toString());
                            counter--;
                        }
                        if (counter < 0) {
                            System.out.println("BOF has been reached.");
                            counter = 0;
                        }
                    }
                }
                break;
            case "s":
                subMenu();
                break;
            case "x":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
        }
    } else if (str.equalsIgnoreCase("8")) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                                   Main Manu                                      ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("  v   View the Selected File: " + TPA + "  (34 Records)");
        System.out.println("  s   Selected a file to View ");
        System.out.println("  x   Exit ");
        System.out.print("\nEnter Your Choice: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int counter = 0;
        boolean breaker1 = true;
        switch (input.toLowerCase()) {
            case "v":
                while (breaker1) {
                    System.out.print("The Current position is at index " + counter + ": Please Enter which Record You Would Like to Be: ");
                    int n = sc.nextInt();
                    if (n == 0) {
                        mainManu("8");
                    } else if (n > 0) {
                        int steps = Math.min(n - 1, trainsArray.length - 1 - counter);

                        for (int i = 0; i <= steps; i++) {
                            System.out.println(trainsArray[counter].toString());
                            counter++;
                        }

                        if (counter == trainsArray.length) {
                            System.out.println("EOF has been reached.");
                            counter--;
                        }
                    } else if (n < 0) {
                        int steps = Math.min(Math.abs(n) - 1, counter);

                        for (int i = 0; i <= steps; i++) {
                            System.out.println(trainsArray[counter].toString());
                            counter--;
                        }
                        if (counter < 0) {
                            System.out.println("BOF has been reached.");
                            counter = 0;
                        }
                    }
                }
                break;
            case "s":
                subMenu();
                break;
            case "x":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
        }
    } else if (str.equalsIgnoreCase("9")) {
        System.exit(0);
    } else if (str.equalsIgnoreCase("0")) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                                   Main Manu                                      ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("  v   View the Selected File: None!");
        System.out.println("  s   Selected a file to View ");
        System.out.println("  x   Exit ");
        System.out.print("\nEnter Your Choice: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        switch (input.toLowerCase()) {
            case "v":
                break;
            case "s":
                subMenu();
                break;
            case "x":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
        }
    }
}
    }

    /**
     * Displays the sub-menu for file options and takes user input to call the appropriate method.
     * Allows the user to select a file to work with from a list of available options.
     */
    public static void subMenu(){

        System.out.println("-------------------------------------------------------------------");
        System.out.println("                           File Sub-Menu                           ");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("  1  Carton_Comics_Books.csv.Ser              (21 Records)         ");
        System.out.println("  2  Hobbies_Collectibles_Books.csv.Ser       (33 Records)         ");
        System.out.println("  3  Movies_TV_Books.csv.Ser                  (698 Records)        ");
        System.out.println("  4  Music_Radio_Books.csv.Ser                (464 Records)        ");
        System.out.println("  5  Nostalgia_Eclectic_Books.csv.Ser         (49 Records)         ");
        System.out.println("  6  Old_Time_Radio_Books.csv.Ser             (7 Records)          ");
        System.out.println("  7  Sports_Sports_Memorabilia_Books.csv.Ser  (179 Records)        ");
        System.out.println("  8  TrainsPlanesAutomobiles_Books.csv.Ser    (34 Records)         ");
        System.out.println("  9  Exit ");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("\nEnter Your Choice: ");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        mainManu(input);
    }

}
