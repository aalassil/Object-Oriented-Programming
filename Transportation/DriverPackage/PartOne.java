package DriverPackage;
import Package1.WheeledTransportation;
import Package2.Train;
import Package2.Tram;
import Package3.Metro;
import Package4.MonoWheel;
import Package5.Aircraft;
import Package5.WorldWarTwoAirplane;
import Package6.Ferry;

//--------------------------------------------------------------------
// Assignment (2)
// Part (1)
// Written by: Haithm Masood (40189851) AND Adam Al-Assil (40172296)
//--------------------------------------------------------------------

/**
 * Name And ID: Haithm Masood (40189851) AND Adam Al-Assil (40172296)
 * COMP-249
 * Assignment #2
 * Due Date: March 4, 2023
 */

/**
 * The driver class that contains the main method (Part I).
 */
public class PartOne {
    public static void main(String[] args) {

        Transportation[] array = new Transportation[18];
        Transportation[] array2 = new Transportation[14];

        Transportation wheeledTransportation1 = new WheeledTransportation(2, 180);
        Transportation wheeledTransportation2 = new WheeledTransportation(5, 170);
        Transportation wheeledTransportation3 = new WheeledTransportation(4, 200); // same values, different objects
        Transportation wheeledTransportation4 = new WheeledTransportation(4, 200);
        array[0] = wheeledTransportation1;
        array[1] = wheeledTransportation2;
        array[2] = wheeledTransportation3;
        array[3] = wheeledTransportation4;
        array2[0] = wheeledTransportation1;
        array2[1] = wheeledTransportation2;
        array2[2] = wheeledTransportation3;
        array2[3] = wheeledTransportation4;

        Transportation train1 = new Train(20, 120, 10, "Jeddah", "Mecca");
        Transportation train2 = new Train(20, 120, 10, "Riadh", "Jeddah");
        array[4] = train1;
        array[5] = train2;
        array2[4] = train1;
        array2[5] = train2;

        Transportation metro1 = new Metro(0, 150, 2, "Saudi", "Yemen", 2);
        Transportation metro2 = new Metro(0, 150, 6, "Saudi", "Qatar", 3);
        array[6] = metro1;
        array[7] = metro2;
        array2[6] = metro1;
        array2[7] = metro2;


        Transportation tram1 = new Tram(16, 60, 2, "Montreal-East", "Montreal-West", 1, 2000);
        Transportation tram2 = new Tram(16, 60, 2, "Montreal", "Laval",2 ,1989);
        array[8] = tram1;
        array[9] = tram2;
        array2[8] = tram1;
        array2[9] = tram2;

        Transportation monoWheel1 = new MonoWheel(1, 25, 120);
        Transportation monoWheel2 = new MonoWheel(1, 50, 150);
        array[10] = monoWheel1;
        array[11] = monoWheel2;
        array2[10] = monoWheel1;
        array2[11] = monoWheel2;


        Transportation ferry1 = new Ferry(20, 500);
        Transportation ferry2 = new Ferry(40, 800);
        array[12] = ferry1;
        array[13] = ferry2;
        array2[12] = ferry1;
        array2[13] = ferry2;

        Transportation aircraft1 = new Aircraft(1500000, 20000);
        Transportation aircraft2 = new Aircraft(2000000, 20000);
        array[14] = aircraft1;
        array[15] = aircraft2;

        Transportation worldWar2Airplane1 = new WorldWarTwoAirplane(300000, 10000, true);
        Transportation worldWar2Airplane2 = new WorldWarTwoAirplane(350000, 10500, false);
        array[16] = worldWar2Airplane1;
        array[17] = worldWar2Airplane2;


        for (int i = 0; i < array.length; i++){
            System.out.println(array[i].toString());
        }

        findLeastAndMostExpensiveAircraft(array);
        findLeastAndMostExpensiveAircraft(array2);



        //////////////// Test Equals Method ///////////////

        if (!train1.equals(tram1))
        {
            System.out.println("\nObjects Are Not Equal, They Are From Different Classes (test 1)");
        }
        if (!wheeledTransportation1.equals(wheeledTransportation2))
        {
            System.out.println("\nObjects Are From The Same Class But The Are Not Equal For Having The Following Values(Test 2): ");
            System.out.print("Object 1: " + wheeledTransportation1.toString());
            System.out.print("Object 2: " + wheeledTransportation2.toString());
        }
        if (wheeledTransportation3.equals(wheeledTransportation4))
        {
            System.out.println("\nObjects Are From The Same Class And They Are Equal For Having The Following Values (Test 3): " + wheeledTransportation1.toString());
        }

    }


    /**
     * FindLeastAndMostExpensiveAircraft method is to help you find from an array of mixed objects The Most
     * and lest Expensive aircraft.
     * @param objectArray of type transportation
     * @return will return an array of transportation.
     */
    public static Transportation[] findLeastAndMostExpensiveAircraft(Transportation[] objectArray){
        int aircraftCounter = 0;

        for (int i = 0; i < objectArray.length; i++) {  // for loop to count how many aircraft objects we have.
            if (objectArray[i] instanceof Aircraft) {
                aircraftCounter++;
            }
        }

        double[] indexElement = new double[aircraftCounter]; // creating a double array that will take the prices of
        int j = 0;                                           // each aircraft and  store them into it.

        for (int i = 0; i < objectArray.length; i++)
        {
            if (objectArray[i] instanceof Aircraft)
            {

                indexElement[j] =  ((Aircraft) objectArray[i]).getPrice();  // to use the getPrice method of aircraft we
                j++;                                                        // have to cast the objects.
            }
        }
        if ( aircraftCounter  == 1)  // if there's only one aircraft do the following.
        {
            System.out.println("\nThere's Only One Aircraft; Therefore, It's the lest and most Expensive With Price Of" +
                    " " + indexElement.toString());

        } else if ( aircraftCounter  > 1)  // if there are more than one aircraft, sort them and print the first element
        {                                  // and the last element of the new array that takes their prices.

            for (int i = 0; i < indexElement.length; i++)           //bubbles sorting
            {
                for (int k = 0; k < indexElement.length-i-1; k++)
                {
                    if (indexElement[k] > indexElement[k+1])
                    {
                        double temp = indexElement[k];
                        indexElement[k] = indexElement[k+1];
                        indexElement[k+1] = temp;
                    }
                }
            }
            System.out.println("\nThe Most Expensive Aircraft is: " + indexElement[indexElement.length-1]);
            System.out.println("The Least Expensive Aircraft is: " + indexElement[0]);


        } else if (aircraftCounter == 0) // if there is no Aircraft object, do the following.
        {
            System.out.println("\nArray2 Has No Aircraft In Order To Find Its Price!");
        }

        return objectArray;

    }
}