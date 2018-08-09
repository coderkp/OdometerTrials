// Java program to print all combination of size r in an array of size n

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {

    static FileWriter fw;
    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r) {
        // Current combination is ready to be printed, print it
        String s = "";
        if (index == r) {
            for (int j = 0; j < r; j++)
                s = s + Integer.toString(data[j]);
            s = s + "\n";
            try {
                fw.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }
    static void printCombination(int arr[], int n, int r)
    {
        int data[]=new int[r];
        combinationUtil(arr, data, 0, n-1, 0, r);
    }
    public static void fileGenerator() {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length;
        for(int i=2; i<=8; i++) {
            String fileName = "Odo" + Integer.toString(i) + ".txt";
            try {
                fw = new FileWriter(fileName);
                printCombination(arr, n, i);
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}