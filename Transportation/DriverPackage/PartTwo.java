package DriverPackage;
import Package1.WheeledTransportation;
import Package2.Train;
import Package2.Tram;
import Package3.Metro;
import Package4.MonoWheel;
import Package5.Aircraft;
import Package5.WorldWarTwoAirplane;
import Package6.Ferry;

//----------------------------------------------------------------------
// Assignment (2)
// Part (2)
// Written by: Haithm Masood (40189851) AND Adam Al-Assil (40172296)
//----------------------------------------------------------------------

/**
 * The driver class that contains the main method (Part I).
 */
public class PartTwo {
    public static Transportation[] copyTheObjects(Transportation[] objectArray){

        Transportation[] newObjectArray = new Transportation[objectArray.length];

        for (int i = 0; i < newObjectArray.length; i++){
            newObjectArray[i] = new Transportation(objectArray[i]);
        }

//        for (int i = 0; i < objectArray.length; i++)         // if I can explicitly validate the objects, this is
//                                                             // would be the way to deep copy it.
//        {
//            if (objectArray[i] instanceof Land)
//            {
//                    if (objectArray[i] instanceof MonoWheel)
//                    {
//                        newObjectArray[i] = new MonoWheel((MonoWheel) objectArray[i]);
//
//                    } else if (objectArray[i] instanceof  Metro)
//                    {
//                        newObjectArray[i] = new Metro((Metro) objectArray[i]);
//
//                    } else if (objectArray[i] instanceof  Tram)
//                    {
//                        newObjectArray[i] = new Tram((Tram) objectArray[i]);
//
//                    } else if (objectArray[i] instanceof  Train)
//                    {
//                        newObjectArray[i] = new Train((Train) objectArray[i]);
//
//                    } else if (objectArray[i] instanceof  WheeledTransportation)
//                    {
//                        newObjectArray[i] = new WheeledTransportation((WheeledTransportation) objectArray[i]);
//                    }
//            } else if (objectArray[i] instanceof Air)
//            {
//                    if (objectArray[i] instanceof WorldWarTwoAirplane)
//                    {
//                        newObjectArray[i] = new WorldWarTwoAirplane((WorldWarTwoAirplane) objectArray[i], true);
//
//                    } else if (objectArray[i] instanceof Aircraft)
//                    {
//                        newObjectArray[i] = new Aircraft((Aircraft) objectArray[i]);
//
//                    }
//            } else if (objectArray[i] instanceof Sea)
//            {
//                    if (objectArray[i] instanceof Ferry)
//                    {
//                        newObjectArray[i] = new Ferry((Ferry) objectArray[i]);
//
//                    }
//            }
//        }
//
//        for (int i = 0; i < newObjectArray.length; i++){
//            System.out.print("\033[33m");
//            System.out.println(newObjectArray[i].toString());
//        }

        return newObjectArray;
    }
    public static void main(String[] args) {

        Transportation[] array = new Transportation[18];

        Transportation wheeledTransportation1 = new WheeledTransportation(2, 180);
        Transportation wheeledTransportation2 = new WheeledTransportation(5, 170);
        Transportation wheeledTransportation3 = new WheeledTransportation(4, 200); // same values, different objects
        Transportation wheeledTransportation4 = new WheeledTransportation(4, 200);
        array[0] = wheeledTransportation1;
        array[1] = wheeledTransportation2;
        array[2] = wheeledTransportation3;
        array[3] = wheeledTransportation4;

        Transportation train1 = new Train(20, 120, 10, "Jeddah", "Mecca");
        Transportation train2 = new Train(20, 120, 10, "Riadh", "Jeddah");
        array[4] = train1;
        array[5] = train2;

        Transportation metro1 = new Metro(0, 150, 2, "Saudi", "Yemen", 2);
        Transportation metro2 = new Metro(0, 150, 6, "Saudi", "Qatar", 3);
        array[6] = metro1;
        array[7] = metro2;


        Transportation tram1 = new Tram(16, 60, 2, "Montreal-East", "Montreal-West", 1, 2000);
        Transportation tram2 = new Tram(16, 60, 2, "Montreal", "Laval",2 ,1989);
        array[8] = tram1;
        array[9] = tram2;

        Transportation monoWheel1 = new MonoWheel(1, 25, 120);
        Transportation monoWheel2 = new MonoWheel(1, 50, 150);
        array[10] = monoWheel1;
        array[11] = monoWheel2;

        Transportation ferry1 = new Ferry(20, 500);
        Transportation ferry2 = new Ferry(40, 800);
        array[12] = ferry1;
        array[13] = ferry2;

        Transportation aircraft1 = new Aircraft(1500000, 20000);
        Transportation aircraft2 = new Aircraft(2000000, 20000);
        array[14] = aircraft1;
        array[15] = aircraft2;

        Transportation worldWar2Airplane1 = new WorldWarTwoAirplane(300000, 10000, true);
        Transportation worldWar2Airplane2 = new WorldWarTwoAirplane(350000, 10500, false);
        array[16] = worldWar2Airplane1;
        array[17] = worldWar2Airplane2;

        System.out.println("");
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i].toString());
        }
        copyTheObjects(array);

    }
}
