import SyntaxExceptions.UnknownGenreException;
import SyntaxExceptions.MissingFieldException;
import SyntaxExceptions.TooFewFieldException;
import SyntaxExceptions.TooManyFieldException;
import java.io.*;
import java.util.Scanner;

/**
 * Part one class
 * Read book records from a number of CSV-formatted.
 * Checks for syntax in those files.
 * Part 1 will output nine files, eight CSV-formatted text files and a regular text file, whose names are listed in the above box at right.
 */
public class PartOne {
    public static void main(String[] args) {


        Scanner filesLines = null;
        int year = 1995;
        String[] splitArray = null;
        String[] splitSplitedArray = null;
        String line = null;
        FileOutputStream writeInto = null;
        FileOutputStream syntaxErrorFiles = null;

        try {
            writeInto = new FileOutputStream("CorrectSyntax");
            syntaxErrorFiles = new FileOutputStream("syntax_Error_Files");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        PrintWriter pr = new PrintWriter(writeInto,true);
        PrintWriter prr = new PrintWriter(syntaxErrorFiles, true);
        try {
            for (int i = 0; i < 16; i++) {
                String stringYear = Integer.toString(year);
                filesLines = new Scanner(new FileInputStream("C:\\Users\\masoo\\Assignment 3 - COMP249\\" +
                        "NeededFiles\\books\\books" + stringYear + ".csv.txt"));
                if (filesLines.hasNext())
                {
                    while (filesLines.hasNextLine())
                    {
                        line = filesLines.nextLine();
                        splitArray = line.split("\",");

                        try {
                            if (splitArray.length == 2) {
                                splitSplitedArray = splitArray[1].split(",");
                                if (splitSplitedArray.length > 5) {
                                    throw new TooManyFieldException();
                                } else if (splitSplitedArray.length < 5) {
                                    throw new TooFewFieldException();
                                } else {
                                    for (int j = 0; j < splitSplitedArray.length; j++) {
                                        if (splitArray[0].isEmpty() || splitSplitedArray[j].isEmpty()) {
                                            throw new MissingFieldException();
                                        } else if (j == 4) {
                                            getGenre(line, pr, prr);
                                        }
                                    }
                                }

                            } else if (splitArray.length == 1) {
                                splitSplitedArray = splitArray[0].split(",");

                                try {
                                    if (splitSplitedArray.length > 6) {
                                        throw new TooManyFieldException();
                                    } else if (splitSplitedArray.length < 6) {
                                        throw new TooFewFieldException();
                                    } else {
                                        for (int d = 0; d < splitSplitedArray.length; d++) {
                                            if (splitSplitedArray[d].isEmpty()) {
                                                throw new MissingFieldException(); // I have a problem here.
                                            }
                                        }
                                        if (!splitSplitedArray[splitSplitedArray.length - 2].isEmpty()) {
                                            getGenre(line, pr, prr);
                                        }
                                    }
                                } catch (TooManyFieldException e) {
                                    prr.println("Syntax Error in file: books" + year + ".cvs");
                                    prr.println("==================================");
                                    prr.println("Error: Too Many Fields");
                                    prr.println("Record: " + line);
                                    prr.println("");
                                    prr.flush();
                                } catch (TooFewFieldException e) {
                                    prr.println("Syntax Error in file: books" + year + ".cvs");
                                    prr.println("==================================");
                                    prr.println("Error: Too Few Fields");
                                    prr.println("Record: " + line);
                                    prr.println("");
                                    prr.flush();
                                }

                            }
                        } catch (MissingFieldException e) {
                            if (splitArray.length == 2) {
                                if (splitArray[0].isEmpty()) {
                                    prr.println("Syntax Error in file: books" + year + ".cvs");
                                    prr.println("==================================");
                                    prr.println("Error: Missing title ");
                                    prr.println("Record: " + line);
                                    prr.println("");
                                    prr.flush();
                                } else if (splitSplitedArray[0].isEmpty()) {
                                    prr.println("Syntax Error in file: books" + year + ".cvs");
                                    prr.println("==================================");
                                    prr.println("Error: Missing Authors");
                                    prr.println("Record: " + line);
                                    prr.println("");
                                    prr.flush();
                                } else if (splitSplitedArray[1].isEmpty()) {
                                    prr.println("Syntax Error in file: books" + year + ".cvs");
                                    prr.println("==================================");
                                    prr.println("Error: Missing Price");
                                    prr.println("Record: " + line);
                                    prr.println("");
                                    prr.flush();
                                } else if (splitSplitedArray[2].isEmpty()) {
                                    prr.println("Syntax Error in file: books" + year + ".cvs");
                                    prr.println("==================================");
                                    prr.println("Error: Missing ISBN ");
                                    prr.println("Record: " + line);
                                    prr.println("");
                                    prr.flush();
                                } else if (splitSplitedArray[3].isEmpty()) {
                                    prr.println("Syntax Error in file: books" + year + ".cvs");
                                    prr.println("==================================");
                                    prr.println("Error: Missing Genre ");
                                    prr.println("Record: " + line);
                                    prr.println("");
                                    prr.flush();
                                } else if (splitSplitedArray[4].isEmpty()) {
                                    prr.println("Syntax Error in file: books" + year + ".cvs");
                                    prr.println("==================================");
                                    prr.println("Error: Missing Year ");
                                    prr.println("Record: " + line);
                                    prr.println("");
                                    prr.flush();
                                }

                            } else if (splitArray.length == 1) {
                                if (splitSplitedArray[0].isEmpty()) {
                                    prr.println("Syntax Error in file: books" + year + ".cvs");
                                    prr.println("==================================");
                                    prr.println("Error: Missing title ");
                                    prr.println("Record: " + line);
                                    prr.println("");
                                    prr.flush();
                                } else if (splitSplitedArray[1].isEmpty()) {
                                    prr.println("Syntax Error in file: books" + year + ".cvs");
                                    prr.println("==================================");
                                    prr.println("Error: Missing Authors");
                                    prr.println("Record: " + line);
                                    prr.println("");
                                    prr.flush();
                                } else if (splitSplitedArray[2].isEmpty()) {
                                    prr.println("Syntax Error in file: books" + year + ".cvs");
                                    prr.println("==================================");
                                    prr.println("Error: Missing Price");
                                    prr.println("Record: " + line);
                                    prr.println("");
                                    prr.flush();
                                } else if (splitSplitedArray[3].isEmpty()) {
                                    prr.println("Syntax Error in file: books" + year + ".cvs");
                                    prr.println("==================================");
                                    prr.println("Error: Missing ISBN ");
                                    prr.println("Record: " + line);
                                    prr.println("");
                                    prr.flush();
                                } else if (splitSplitedArray[4].isEmpty()) {
                                    prr.println("Syntax Error in file: books" + year + ".cvs");
                                    prr.println("==================================");
                                    prr.println("Error: Missing Genre ");
                                    prr.println("Record: " + line);
                                    prr.println("");
                                    prr.flush();
                                } else if (splitSplitedArray[5].isEmpty()) {
                                    prr.println("Syntax Error in file: books" + year + ".cvs");
                                    prr.println("==================================");
                                    prr.println("Error: Missing Year ");
                                    prr.println("Record: " + line);
                                    prr.println("");
                                    prr.flush();
                                }
                            }
                        } catch (TooFewFieldException e) {
                            prr.println("Syntax Error in file: books" + year + ".cvs");
                            prr.println("==================================");
                            prr.println("Error: Too Few Fields");
                            prr.println("Record: " + line);
                            prr.println("");
                            prr.flush();
                        } catch (TooManyFieldException e) {
                            prr.println("Syntax Error in file: books" + year + ".cvs");
                            prr.println("==================================");
                            prr.println("Error: Too Many Fields");
                            prr.println("Record: " + line);
                            prr.println("");
                            prr.flush();
                        }

                    }
            }else {
                    System.out.println("\nThis file is empty: books"+stringYear+".csv");
                }
                year++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Determines the genre of a book record represented by a comma-separated line and writes the line to a file if the genre is valid.
     * If the genre is invalid, an UnknownGenreException is thrown and a syntax error message is written to a syntax error file.
     * @param line the comma-separated line representing a book record
     * @param file the PrintWriter object for the output file
     * @param syntaxErrorFile the PrintWriter object for the syntax error file
     */
    public static void getGenre(String line, PrintWriter file, PrintWriter syntaxErrorFile) {
        String[] str = line.split(",");
        String year = str[str.length - 1];
        switch (str[str.length - 2]) {
            case "CCB":
            case "HCB":
            case "MTV":
            case "MRB":
            case "NEB":
            case "OTR":
            case "SSM":
            case "TPA":
              file.println(line);
              file.flush();
                break;
            default:
                try {
                    throw new UnknownGenreException();
                } catch (UnknownGenreException e) {
                    syntaxErrorFile.println("Syntax Error in file: books" + year + ".cvs");
                    syntaxErrorFile.println("==================================");
                    syntaxErrorFile.println("Error: Unknown Genre");
                    syntaxErrorFile.println("Record: " + line);
                    syntaxErrorFile.println("");
                    syntaxErrorFile.flush();
                }
        }
    }
}