import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mergeSort {
    
    /***** Main function *****/
    public static void main (String[] args) {

        String[] stringList = readArray("datafile.txt");
        
        //call the MERGESORT FUNCTION
        mergeSort(stringList);
        
        for (String ClassThree: stringList) {
            System.out.println(ClassThree);
        }
    }

    /***** readArray function *****/
    public static String[] readArray(String file) {

        int ctr = 0;
        try{
            Scanner s1 = new Scanner (new File(file));
            while (s1.hasNextLine()) {
                ctr = ctr + 1;
                s1.next();
            }

            String[] words = new String[ctr];

            Scanner s2 = new Scanner(new File(file));
            for (int i = 0; i <ctr; i = i + 1) {
                words[i] = s2.next();
            }
            return words;
        }
        catch (FileNotFoundException e) {
            System.out.println("datafile.txt not found");
        }
    return null;
    }

    /***** mergeSort function *****/
    public static void mergeSort(String[] stringList) {
        if (stringList.length > 1) {
            //leftSide take the first part of the string list while rightSide take the rest of the string
            String[] leftSide = new String[stringList.length / 2]; 
            String[] rightSide = new String[stringList.length - stringList.length / 2];  
        
            for (int x = 0; x < leftSide.length; x++) {
                leftSide[x] = stringList[x];
                }
        
            for (int y = 0; y < rightSide.length; y++) {
                rightSide[y] = stringList[y + stringList.length / 2];
                }
    
            mergeSort(leftSide);
            mergeSort(rightSide);
            merge(stringList, leftSide, rightSide);
        }
    }

    /***** merge function *****/
    public static void merge(String[] listOfString, String[] firstPart, String[] secondPart) {
        int as = 0;
        int bs = 0;
    
        for (int i = 0; i < listOfString.length; i++) {
            if (bs >= secondPart.length || (as < firstPart.length && firstPart[as].compareToIgnoreCase(secondPart[bs]) < 0)) {
                listOfString[i] = firstPart[as];
                as++;
            } else {
                listOfString[i] = secondPart[bs];
                bs++;
            }
        }
    }
}
