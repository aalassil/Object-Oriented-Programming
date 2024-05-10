import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner readBookObjects = null;
        try {
            readBookObjects = new Scanner(new FileInputStream("C:\\Users\\masoo\\Java Projects 2022-23\\" +
                    "Assignement 4 - COMP249\\src\\Simple_File_For_Assignment4"));
        } catch (FileNotFoundException e) {
            System.out.println("An exception Has Occurred");
        }

        ArrayList<Book> arrayOfBooks = new ArrayList<>();
        ArrayList<Book> arrayOfBooksTwo = new ArrayList<>();
        ArrayList<String> validatedArrayOfBooks = new ArrayList<>();
        String[] splitArray = null;
        String[] splitSplittedArray = null;
        String line = null;

        while(readBookObjects.hasNextLine()){      // here we have created all Books objects and store them in an array list.
            line = readBookObjects.nextLine();
            splitArray = line.split("\",");
            splitSplittedArray = splitArray[1].split(",");
            arrayOfBooks.add(new Book(splitArray[0],splitSplittedArray[0],Double.parseDouble(splitSplittedArray[1]), splitSplittedArray[2], splitSplittedArray[3],Integer.parseInt(splitSplittedArray[4])));
            validatedArrayOfBooks.add(line);
        }

        PrintWriter correctRecords = null;
        PrintWriter badRecords = null;

        try{
            correctRecords = new PrintWriter(new FileOutputStream("Validated_File.txt"));
            badRecords = new PrintWriter(new FileOutputStream("YearErr.txt"));
        }catch (FileNotFoundException e){
            System.out.println(e);
        }


        for (int i = 0; i < arrayOfBooks.size(); i++){
            if (arrayOfBooks.get(i).getYear() >= 2024){
                badRecords.println(arrayOfBooks.get(i));
                badRecords.flush();
            }else {
                correctRecords.println(validatedArrayOfBooks.get(i));
                correctRecords.flush();
                arrayOfBooksTwo.add(arrayOfBooks.get(i));
            }
        }


        Scanner readValidateBooks = null;
        try{
            readBookObjects = new Scanner(new FileInputStream("C:\\Users\\masoo\\Java Projects 2022-23\\Assignement 4 - COMP249\\Validated_File.txt"));
        }catch (FileNotFoundException e){
            System.out.println(e);
        }


        BookList listOfRecords = new BookList();          // we have created our validated LinkedList !
        listOfRecords.createCircularLinkedList(arrayOfBooksTwo);


        System.out.println("Here's all the Valid Records you will be manipulating!\n");
        for (int i = 0; i < validatedArrayOfBooks.size(); i++){
            System.out.println(validatedArrayOfBooks.get(i));
        }
        System.out.println(" ");


        boolean t = true;
        do {
            System.out.println("\n-------------------------------------------------------------");
            System.out.println("                           MAIN MANU                         ");
            System.out.println("-------------------------------------------------------------");
            System.out.println("CHOSE one of the following options !\n");
            System.out.println("1 - Give me a valid \"year\" and I will extract all " +
                    "records of that year and store them in a file named by the year you have chosen");
            System.out.println("2 - ask me to delete any repeated records");
            System.out.println("3 - Give me an author name and i will create a new list with the records of" +
                    " this author and display them");
            System.out.println("4 - Give me an ISBN number and a Book Object, and I will insert " +
                    "a Node of Book object before the records with ISBN");
            System.out.println("5 - Give me two ISBN numbers and a Book Object, and I will insert a Node between them," +
                    "if I find them!");
            System.out.println("6 - Give me two ISBN numbers and I will swap them in list for rearrangement of records," +
                    "if I find them!");
            System.out.println("7 - Tell me COMMIT! Your command is my Wish!. I will commit you list to a file called" +
                    " Updated_Books");
            System.out.println("8 - Tell me STOP TALKING. Remember, if you do not commit, I will Not!!");

            Scanner sc = new Scanner(System.in);
            int choice = 0;
            boolean invalidInput = false;

            while(!invalidInput){
                try {
                    System.out.print("\nEnter Your Choice: ");
                    choice = sc.nextInt();
                    invalidInput = true;
                } catch (Exception e) {
                    System.out.println("Please enter a valid choice Integer!");
                    sc.nextLine();
                }
            }

            if (choice == 1){ // works perfectly!
                int year = 0;
                invalidInput = false;

                while(!invalidInput){
                    try{
                        System.out.print("Please Give a Valid Year! ");
                        year = sc.nextInt();
                        invalidInput = true;
                    }catch(Exception e){
                        System.out.println("Invalid Input!\n");
                        sc.nextLine(); // consume the invalid input
                    }
                }
                listOfRecords.takeYearToFile(year);



            } else if (choice == 2) { // works perfectly!
                listOfRecords.deleteRepeatedNodes();
                System.out.println("We have Deleted Repeated Nodes Successfully! \n");
                listOfRecords.displayBooks();



            } else if (choice == 3) { // works perfectly!
                String authorName = null;
                invalidInput = false;

                while (!invalidInput){
                    try{
                        System.out.print("Please Enter an Author Name! ");
                        sc.nextLine();
                        authorName = sc.nextLine();
                        invalidInput = true;
                    }catch(Exception e){
                        System.out.print("Invalid Input!\n");
                        authorName = sc.nextLine();
                    }
                }
                System.out.println("");
                listOfRecords.extractAuthList(authorName);


            } else if (choice == 4) {
                listOfRecords.insertBefore("1879103272", new Book("A Legendary Story Has Been Made", "Haithm Masood", 100, "00000000000", "MTV", 2023));
                System.out.println("A Node Of Book Object Has Been Added Successfully! \n");
                listOfRecords.displayBooks();


            } else if (choice == 5){
                String isbnOne = null;
                String isbnTwo = null;
                invalidInput = false;
                Scanner scanner = new Scanner(System.in);
                while(!invalidInput) {
                    try {
                        System.out.println("Please Enter a Valid ISBN! ");
                        System.out.print("isbnOne: ");
                        isbnOne = scanner.nextLine();
                        System.out.println(" ");
                        System.out.print("isbnTwo: ");
                        isbnTwo = scanner.nextLine();
                        invalidInput = true;
                    } catch (Exception e) {
                        System.out.println("Invalid Input!\n");
                    }
                }
                listOfRecords.insertIbBetween(isbnOne, isbnTwo, new Book("COMP-249 Almost Done!", "Haithm Masood", 10000, "00000000000", "MTV", 2023));
                listOfRecords.displayBooks();



            } else if (choice == 6) {
                String isbnOne = null;
                String isbnTwo = null;
                invalidInput = false;
                Scanner scan = new Scanner(System.in);
                while(!invalidInput) {
                    try {
                        System.out.println("Please Enter a Valid ISBN! ");
                        System.out.print("isbnOne: ");
                        isbnOne = scan.nextLine();
                        System.out.println(" ");
                        System.out.print("isbnTwo: ");
                        isbnTwo = scan.nextLine();
                        invalidInput = true;
                    } catch (Exception e) {
                        System.out.println("Invalid Input!\n");
                    }
                    listOfRecords.swapTwoNodeBasedOnISBN(isbnOne, isbnTwo);
                }
                
                
            } else if (choice == 7) {
                String command = null;
                boolean invalid = false;
                Scanner ss = new Scanner(System.in);
                PrintWriter pr = null;

                while(!invalid){
                    try{
                        System.out.println("Please Enter Word Commit if you wanted the list to be filed in Updated_Books file!");
                        command = ss.nextLine();
                        invalid = true;
                    }catch (Exception e){
                        System.out.println("Invalid Input!");
                    }
                }

                if (command.equalsIgnoreCase("commit")){
                    try{
                        pr = new PrintWriter(new FileOutputStream("Updated_File"), true);
                    }catch (FileNotFoundException e){
                        System.out.println(e);
                    }
                    pr.println(listOfRecords.toStringBookList()); // I have a problem here !!
                    pr.println("");
                    pr.flush();
                }
            } else if (choice == 8) {
                String command = null;
                boolean invalid = false;
                Scanner sss = new Scanner(System.in);

                while(!invalid){
                        try{
                            System.out.println("Please Enter Word stop talking if you want me to terminate the Program!");
                            command = sss.nextLine();
                            invalid = true;
                        }catch (Exception e){
                            System.out.println("Invalid Input!");
                        }
                }
                if (command.equalsIgnoreCase("stop talking")){
                    System.out.println("End Of The Program, Thank you!");
                    t = false;
                }else {
                    System.out.println("The code is continued");
                }
            }


        }while(t);


    }
}