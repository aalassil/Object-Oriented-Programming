import SemanticExceptions.*;

import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class StillPartOne {
    public static void main(String[] args) {

        PrintWriter cartonComics = null;
        PrintWriter hobbiesCollectibles = null;
        PrintWriter moviesTVBooks = null;
        PrintWriter musicRadioBooks = null;
        PrintWriter nostalgiaEclecticBooks = null;
        PrintWriter oldTimeRadioBooks = null;
        PrintWriter sportsSportsMemorabilia = null;
        PrintWriter trainsPlanesAutomobiles = null;
        PrintWriter semanticErrorFiles = null;
        PrintWriter semanticallyCorrectFiles = null;

        try
        {
            cartonComics = new PrintWriter(new FileOutputStream("Carton_Comics.csv"),true);
            hobbiesCollectibles = new PrintWriter(new FileOutputStream("Hobbies_Collectibles.csv"), true) ;
            moviesTVBooks = new PrintWriter(new FileOutputStream("Movies_TV_Books.csv"),true) ;
            musicRadioBooks = new PrintWriter(new FileOutputStream("Music_Radio_Books.csv"), true);
            nostalgiaEclecticBooks = new PrintWriter(new FileOutputStream("Nostalgia_Eclectic_Books.csv"), true);
            oldTimeRadioBooks = new PrintWriter(new FileOutputStream("Old_Time_Radio_Books.csv"),true);
            sportsSportsMemorabilia = new PrintWriter(new FileOutputStream("Sports_Sports_Memorabilia.csv"),true);
            trainsPlanesAutomobiles = new PrintWriter(new FileOutputStream("TrainsPlanesAutomobiles.csv"),true);
            semanticErrorFiles = new PrintWriter(new FileOutputStream("semantic_Error_Files"), true);
            semanticallyCorrectFiles = new PrintWriter(new FileOutputStream("semantically_Correct_Files"),true);

        }catch(FileNotFoundException e){
            System.out.println(e);
        }


        Random rand = new Random();
        int fileYear = rand.nextInt(1995,2010);
        String str = Integer.toString(fileYear);


        Scanner validateSemanticErrors = null;
        try{
            validateSemanticErrors = new Scanner(new FileInputStream("C:\\Users\\masoo\\Assignment 3 - Last Version\\CorrectSyntax"));
        }catch (FileNotFoundException e) {
            System.out.println(e);
        }

        Scanner separator = null;
        try {
            separator = new Scanner(new FileInputStream("C:\\Users\\masoo\\Assignment 3 - Last Version\\semantically_Correct_Files"));
        }catch (FileNotFoundException e){
            System.out.println(e);
        }

            String line = null;
            String[] lineArray = null;

            while (validateSemanticErrors.hasNextLine())
            {
                line = validateSemanticErrors.nextLine();
                validatePrice(line, semanticErrorFiles, semanticallyCorrectFiles, str);
            }

            while(separator.hasNextLine()){
                line = separator.nextLine();
                lineArray = line.split(",");
                switch (lineArray[lineArray.length-2]){
                    case "CCB": cartonComics.println(line);
                        break;
                    case "HCB": hobbiesCollectibles.println(line);
                        break;
                    case "MTV": moviesTVBooks.println(line);
                        break;
                    case "MRB": musicRadioBooks.println(line);
                        break;
                    case "NEB": nostalgiaEclecticBooks.println(line);
                        break;
                    case "OTR": oldTimeRadioBooks.println(line);
                        break;
                    case "SSM": sportsSportsMemorabilia.println(line);
                        break;
                    case "TPA": trainsPlanesAutomobiles.println(line);
                        break;
                }
            }

    }

    /**
     * This method validates the price of a book record in the CSV file.
     * If the price is less than 0, it throws a BadPriceException and writes a semantic error to semanticallyError PrintWriter.
     * If the price is greater than or equal to 0, it calls validateISBN method to validate the ISBN of the book record.
     * @param line a String representing a record in the CSV file
     * @param semanticallyError a PrintWriter to write semantic error messages
     * @param semanticallyCorrect a PrintWriter to write correct records
     * @param str a String representing the file number
     */
    public static void validatePrice(String line, PrintWriter semanticallyError, PrintWriter semanticallyCorrect, String str){
        String[] splitArray = null;
        splitArray = line.split(",");
        double price = Double.parseDouble(splitArray[splitArray.length-4]);
        if (price >= 0){
            validateISBN(line, semanticallyError, semanticallyCorrect, str);
        }else {
            try {
                throw new BadPriceException();
            } catch (BadPriceException e) {
                semanticallyError.println("semantic error in file: books" + str +".csv"); /// missing file number
                semanticallyError.println("=================================");
                semanticallyError.println("Error: Invalid Price");
                semanticallyError.println("Record: " + line);
                semanticallyError.println("");
                semanticallyError.flush();
            }
        }
    }

    /**
     * This method validates the ISBN of a book record in the CSV file.
     * If the ISBN is invalid, it throws an exception (BadIsbn10Exception, BadIsbn13Exception, or Exception) and writes a semantic error to semanticallyError PrintWriter.
     * If the ISBN is valid, it calls validateYear method to validate the year of publication of the book record.
     * @param line  a String representing a record in the CSV file
     * @param semanticallyError a PrintWriter to write semantic error messages
     * @param semanticallyCorrect  a PrintWriter to write correct records
     * @param str a String representing the file number
     */
    public static void validateISBN(String line, PrintWriter semanticallyError, PrintWriter semanticallyCorrect, String str) {
        String[] splitArray = null;
        splitArray = line.split(",");
        String isbn = splitArray[splitArray.length - 3];

        try {
            if (isbn.length() == 10) {
                int sum10 = 0;
                for (int i = 0; i < 10; i++) {
                    sum10 += (10 - i) * Character.getNumericValue(isbn.charAt(i));
                }
                if (sum10 % 11 == 0) {
                    validateYear(line, semanticallyError, semanticallyCorrect, str);
                } else {
                    throw new BadIsbn10Exception();
                }
            } else if (isbn.length() == 13) {
                int sum13 = 0;
                for (int i = 0; i < 13; i++) {
                    sum13 += ((i % 2 == 0) ? 1 : 3) * Character.getNumericValue(isbn.charAt(i));
                }
                if (sum13 % 10 == 0) {
                    validateYear(line, semanticallyError, semanticallyCorrect, str);
                } else {
                    throw new BadIsbn13Exception();
                }
            } else {
                throw new Exception("Invalid ISBN length");
            }
        } catch (BadIsbn10Exception e) {
            semanticallyError.println("semantic error in file: books" + str + ".csv"); /// missing file number
            semanticallyError.println("=================================");
            semanticallyError.println("Error: Invalid 10-ISBN");
            semanticallyError.println("Record: " + line);
            semanticallyError.println("");
            semanticallyError.flush();
        } catch (BadIsbn13Exception e) {
            semanticallyError.println("semantic error in file: books" + str + ".csv"); /// missing file number
            semanticallyError.println("=================================");
            semanticallyError.println("Error: Invalid 13-ISBN");
            semanticallyError.println("Record: " + line);
            semanticallyError.println("");
            semanticallyError.flush();
        } catch (Exception e) {
            semanticallyError.println("semantic error in file: books" + str + ".csv"); /// missing file number
            semanticallyError.println("=================================");
            semanticallyError.println("Error: Invalid ISBN Format");
            semanticallyError.println("Record: " + line);
            semanticallyError.println("");
            semanticallyError.flush();
        }
    }

    /**
     * Validates the year of publication of a book record.
     * If the year is between 1995 and 2010 (inclusive), the record is written to the semanticallyCorrect file.
     * Otherwise, a BadYearException is thrown and the record is written to the semanticallyError file.
     * @param line  The book record in CSV format.
     * @param semanticallyError The PrintWriter object for the semanticallyError file.
     * @param semanticallyCorrect The PrintWriter object for the semanticallyCorrect file.
     * @param str The file number of the CSV file being validated.
     */
    public static void validateYear(String line, PrintWriter semanticallyError, PrintWriter semanticallyCorrect, String str){
        String[] splitArray = null;
        splitArray = line.split(",");
        int year = Integer.parseInt(splitArray[splitArray.length-1]);

        if (year >= 1995 && year <= 2010){
            semanticallyCorrect.println(line);
        }else {
            try{
                throw new BadYearException();
            }catch(BadYearException e){
                semanticallyError.println("semantic error in file: books"+ str +".csv"); /// missing file number
                semanticallyError.println("=================================");
                semanticallyError.println("Error: Invalid Year");
                semanticallyError.println("Record: " + line);
                semanticallyError.println("");
                semanticallyError.flush();
            }
        }
    }
}
