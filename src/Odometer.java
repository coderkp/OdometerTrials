import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
public class Odometer {

    private HashMap<Integer,Integer> readingToIndex;
    private HashMap<Integer,Integer> indexToReading;
    private int length;

    public Odometer(int numberOfDigit) {

        File file =new File( "Odo"+numberOfDigit+".txt");
        // File file = new File("Odo2.txt");
        indexToReading= new HashMap<Integer,Integer>();
        readingToIndex= new HashMap<Integer,Integer>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int index=1;
        while(scanner.hasNextInt()){
            int reading=scanner.nextInt();
            indexToReading.put(index,reading);
            readingToIndex.put(reading,index);
            index++;
        }
        length=index-1;
    }

    int findDifference(int firstReading,int secondReading){
        int difference =readingToIndex.get(firstReading)-readingToIndex.get(secondReading);
        if(difference<0){
            difference=length-difference;
        }
        return difference;
    }
    public int nextReading(int currReading,int n){
        int currIndex= readingToIndex.get(currReading);
        int next_nthIndex= (currIndex +n)%(length);
        return indexToReading.get(next_nthIndex);
    }

    public int previousReading(int currReading,int n){
        int currIndex=readingToIndex.get(currReading);
        int previous_nthIndex= (currIndex -n)%(length);
        if(previous_nthIndex<0){
            previous_nthIndex+=length;
        }
        return indexToReading.get(previous_nthIndex);
    }



    public static void main(String[] args)
    {
        Odometer odo = new Odometer(3);
        System.out.println(odo.findDifference(134,129));
        System.out.println(odo.nextReading(789,3));
        System.out.println(odo.previousReading(129,3));
        System.out.println(odo.previousReading(123,3));

    }
}