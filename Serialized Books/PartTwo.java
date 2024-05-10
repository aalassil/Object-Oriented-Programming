import java.io.*;
import java.util.Scanner;

/**
 * Part two class
 * Checks each of the syntactically valid book records for semantic errors.
 * Serializes both syntactically and semantically valid book records into binary files.
 * Reads the genre-based CVS-formatted input text files produced in Part 1, creating an array of valid Book objects out of all the semantically valid book records in each input file.
 */
public class PartTwo {
    public static void main(String[] args) {

        Scanner readCartonRecords = null;
        Scanner readHobbiesRecords = null;
        Scanner readMoviesRecords = null;
        Scanner readMusicRecords = null;
        Scanner readNostalgiaRecords = null;
        Scanner readOldRadioRecords = null;
        Scanner readSportsRecords = null;
        Scanner readTrainsRecords = null;


        try {
            readCartonRecords = new Scanner(new FileInputStream("Carton_Comics.csv"));
            readHobbiesRecords = new Scanner(new FileInputStream("Hobbies_Collectibles.csv"));
            readMoviesRecords = new Scanner(new FileInputStream("Movies_TV_Books.csv"));
            readMusicRecords = new Scanner(new FileInputStream("Music_Radio_Books.csv"));
            readNostalgiaRecords = new Scanner(new FileInputStream("Nostalgia_Eclectic_Books.csv"));
            readOldRadioRecords = new Scanner(new FileInputStream("Old_Time_Radio_Books.csv"));
            readSportsRecords = new Scanner(new FileInputStream("Sports_Sports_Memorabilia.csv"));
            readTrainsRecords = new Scanner(new FileInputStream("TrainsPlanesAutomobiles.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String[] splitArray = null;
        String[] splitSplitedArray = null;
        String line = null;


        Book[] cartonArray = new Book[21];
        Book[] hobbiesArray = new Book[33];
        Book[] moviesArray = new Book[698];
        Book[] musicArray = new Book[464];
        Book[] nostalgiaArray = new Book[49];
        Book[] oldRadioArray = new Book[7];
        Book[] sportsArray = new Book[179];
        Book[] trainsArray = new Book[34];


        int counter = 0;
        while(readCartonRecords.hasNextLine()){ //1
            line = readCartonRecords.nextLine();
            splitArray = line.split("\",");
            if (splitArray.length == 2){
                splitSplitedArray = splitArray[1].split(",");
                cartonArray[counter] = new Book(splitArray[0],splitSplitedArray[0],Double.parseDouble(splitSplitedArray[1]),splitSplitedArray[2],splitSplitedArray[3],Integer.parseInt(splitSplitedArray[4]));
            } else if (splitArray.length == 1) {
                splitSplitedArray = splitArray[0].split(",");
                cartonArray[counter] = new Book(splitSplitedArray[0], splitSplitedArray[1],Double.parseDouble(splitSplitedArray[2]),splitSplitedArray[3],splitSplitedArray[4],Integer.parseInt(splitSplitedArray[5]));
            }
            counter++;
        }

        counter = 0;
        while(readHobbiesRecords.hasNextLine()){ //2
            line = readHobbiesRecords.nextLine();
            splitArray = line.split("\",");
            if (splitArray.length == 2){
                splitSplitedArray = splitArray[1].split(",");
                hobbiesArray[counter] = new Book(splitArray[0],splitSplitedArray[0],Double.parseDouble(splitSplitedArray[1]),splitSplitedArray[2],splitSplitedArray[3],Integer.parseInt(splitSplitedArray[4]));
            } else if (splitArray.length == 1) {
                splitSplitedArray = splitArray[0].split(",");
                hobbiesArray[counter] = new Book(splitSplitedArray[0], splitSplitedArray[1],Double.parseDouble(splitSplitedArray[2]),splitSplitedArray[3],splitSplitedArray[4],Integer.parseInt(splitSplitedArray[5]));
            }
            counter++;
        }

        counter = 0;
        while(readMoviesRecords.hasNextLine()){ //3
            line = readMoviesRecords.nextLine();
            splitArray = line.split("\",");
            if (splitArray.length == 2){
                splitSplitedArray = splitArray[1].split(",");
                moviesArray[counter] = new Book(splitArray[0],splitSplitedArray[0],Double.parseDouble(splitSplitedArray[1]),splitSplitedArray[2],splitSplitedArray[3],Integer.parseInt(splitSplitedArray[4]));
            } else if (splitArray.length == 1) {
                splitSplitedArray = splitArray[0].split(",");
                moviesArray[counter] = new Book(splitSplitedArray[0], splitSplitedArray[1],Double.parseDouble(splitSplitedArray[2]),splitSplitedArray[3],splitSplitedArray[4],Integer.parseInt(splitSplitedArray[5]));
            }
            counter++;
        }

        counter = 0;
        while(readMusicRecords.hasNextLine()){ //4
            line = readMusicRecords.nextLine();
            splitArray = line.split("\",");
            if (splitArray.length == 2){
                splitSplitedArray = splitArray[1].split(",");
                musicArray[counter] = new Book(splitArray[0],splitSplitedArray[0],Double.parseDouble(splitSplitedArray[1]),splitSplitedArray[2],splitSplitedArray[3],Integer.parseInt(splitSplitedArray[4]));
            } else if (splitArray.length == 1) {
                splitSplitedArray = splitArray[0].split(",");
                musicArray[counter] = new Book(splitSplitedArray[0], splitSplitedArray[1],Double.parseDouble(splitSplitedArray[2]),splitSplitedArray[3],splitSplitedArray[4],Integer.parseInt(splitSplitedArray[5]));
            }
            counter++;
        }

        counter = 0;
        while(readNostalgiaRecords.hasNextLine()){ //5
            line = readNostalgiaRecords.nextLine();
            splitArray = line.split("\",");
            if (splitArray.length == 2){
                splitSplitedArray = splitArray[1].split(",");
                nostalgiaArray[counter] = new Book(splitArray[0],splitSplitedArray[0],Double.parseDouble(splitSplitedArray[1]),splitSplitedArray[2],splitSplitedArray[3],Integer.parseInt(splitSplitedArray[4]));
            } else if (splitArray.length == 1) {
                splitSplitedArray = splitArray[0].split(",");
                nostalgiaArray[counter] = new Book(splitSplitedArray[0], splitSplitedArray[1],Double.parseDouble(splitSplitedArray[2]),splitSplitedArray[3],splitSplitedArray[4],Integer.parseInt(splitSplitedArray[5]));
            }
            counter++;
        }

        counter = 0;
        while(readOldRadioRecords.hasNextLine()){ //6
            line = readOldRadioRecords.nextLine();
            splitArray = line.split("\",");
            if (splitArray.length == 2){
                splitSplitedArray = splitArray[1].split(",");
                oldRadioArray[counter] = new Book(splitArray[0],splitSplitedArray[0],Double.parseDouble(splitSplitedArray[1]),splitSplitedArray[2],splitSplitedArray[3],Integer.parseInt(splitSplitedArray[4]));
            } else if (splitArray.length == 1) {
                splitSplitedArray = splitArray[0].split(",");
                oldRadioArray[counter] = new Book(splitSplitedArray[0], splitSplitedArray[1],Double.parseDouble(splitSplitedArray[2]),splitSplitedArray[3],splitSplitedArray[4],Integer.parseInt(splitSplitedArray[5]));
            }
            counter++;
        }

        counter = 0;
        while(readSportsRecords.hasNextLine()){ //7
           line = readSportsRecords.nextLine();
            splitArray = line.split("\",");
            if (splitArray.length == 2){
                splitSplitedArray = splitArray[1].split(",");
                sportsArray[counter] = new Book(splitArray[0],splitSplitedArray[0],Double.parseDouble(splitSplitedArray[1]),splitSplitedArray[2],splitSplitedArray[3],Integer.parseInt(splitSplitedArray[4]));
            } else if (splitArray.length == 1) {
                splitSplitedArray = splitArray[0].split(",");
                sportsArray[counter] = new Book(splitSplitedArray[0], splitSplitedArray[1],Double.parseDouble(splitSplitedArray[2]),splitSplitedArray[3],splitSplitedArray[4],Integer.parseInt(splitSplitedArray[5]));
            }
            counter++;
        }

        counter = 0;
        while(readTrainsRecords.hasNextLine()){
           line = readTrainsRecords.nextLine();
            splitArray = line.split("\",");
            if (splitArray.length == 2){
                splitSplitedArray = splitArray[1].split(",");
                trainsArray[counter] = new Book(splitArray[0],splitSplitedArray[0],Double.parseDouble(splitSplitedArray[1]),splitSplitedArray[2],splitSplitedArray[3],Integer.parseInt(splitSplitedArray[4]));
            } else if (splitArray.length == 1) {
                splitSplitedArray = splitArray[0].split(",");
                trainsArray[counter] = new Book(splitSplitedArray[0], splitSplitedArray[1],Double.parseDouble(splitSplitedArray[2]),splitSplitedArray[3],splitSplitedArray[4],Integer.parseInt(splitSplitedArray[5]));
            }
            counter++;
        }


        ObjectOutputStream cartonSer = null;
        ObjectOutputStream hobbiesSer = null;
        ObjectOutputStream moviesSer = null;
        ObjectOutputStream musicSer = null;
        ObjectOutputStream nostalgiaSer = null;
        ObjectOutputStream oldRadioSer = null;
        ObjectOutputStream sportsSer = null;
        ObjectOutputStream trainsSer = null;

        try{
            cartonSer = new ObjectOutputStream(new FileOutputStream("Carton_Comics.csv.ser"));
            for (int i = 0; i < cartonArray.length; i++){
                cartonSer.writeObject(cartonArray[i]);
            }

            hobbiesSer = new ObjectOutputStream(new FileOutputStream("Hobbies_Collectibles.csv.ser"));
            for (int i = 0; i < hobbiesArray.length; i++){
                hobbiesSer.writeObject(hobbiesArray[i]);
            }

            moviesSer = new ObjectOutputStream(new FileOutputStream("Movies_TV_Books.csv.ser"));
            for (int i = 0; i < moviesArray.length; i++){
                moviesSer.writeObject(moviesArray[i]);
            }

            musicSer = new ObjectOutputStream(new FileOutputStream("Music_Radio_Books.csv.ser"));
            for (int i = 0; i < musicArray.length; i++){
                musicSer.writeObject(musicArray[i]);
            }

            nostalgiaSer = new ObjectOutputStream(new FileOutputStream("Nostalgia_Eclectic_Books.csv.ser"));
            for (int i = 0; i < nostalgiaArray.length; i++){
                nostalgiaSer.writeObject(nostalgiaArray[i]);
            }

            oldRadioSer = new ObjectOutputStream(new FileOutputStream("Old_Time_Radio_Books.csv.ser"));
            for (int i = 0; i < oldRadioArray.length; i++){
                oldRadioSer.writeObject(oldRadioArray[i]);
            }

            sportsSer = new ObjectOutputStream(new FileOutputStream("Sports_Sports_Memorabilia.csv.ser"));
            for (int i = 0; i < sportsArray.length; i++){
                sportsSer.writeObject(sportsArray[i]);
            }

            trainsSer = new ObjectOutputStream(new FileOutputStream("TrainsPlanesAutomobiles.csv.ser"));
            for(int i = 0; i < trainsArray.length; i++){
                trainsSer.writeObject(trainsArray[i]);
            }


        }catch (FileNotFoundException e ){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        }

    }
}
