package javafinal_alexislajoie_v0.pkg1;

import java.util.Scanner;

@SuppressWarnings({"unused", "ForLoopReplaceableByForEach"})
public class Utilities {

    public static int getUserChoice(String prompt) {
        int choice;
        System.out.print(prompt);
        Scanner myScanner = new Scanner(System.in);
        choice = myScanner.nextInt();
        return choice;
    }
    
    public static String getUserChoiceStr(String prompt) {
        String choice;
        System.out.print(prompt);
        Scanner myScanner = new Scanner(System.in);
        choice = myScanner.nextLine();
        return choice;
    }

    /**
     * Use binary search to find the key in the list
     */
    public static int sortArrayBasedOnScore(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid]) {
                high = mid - 1;
            } else if (key == list[mid]) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1 - low;
    }

    @SuppressWarnings("DuplicatedCode")
    public static void sortArrayListBasedOnScore(int[] list) {
        for (int i = 0; i < list.length; i++) {
// Find the minimum in the list[i.list.length-1]
            int currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
// Swap list[i] with list[currentMinIndex] if necessary; if (currentMinIndex != i) {
            list[currentMinIndex] = list[i];
            list[i] = currentMin;
        }
    }
   
    //swaps students places basd on an array of scores 1:1 with thir scores for a given game
    @SuppressWarnings("DuplicatedCode")
    public static void sortArrayListBasedOnScore(int[] list, Student[] students) {
        for (int i = 0; i < list.length; i++) {
// Find the minimum in the list[i..list.length-1]
            int currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
// Swap list[i] with list[currentMinIndex] if necessary;if (currentMinIndex != i) {
            list[currentMinIndex] = list[i];
            
            list[i] = currentMin;
            
            // creating a student temp object with the minimum, then assigning the new minimum i to the old minimum, then puting the temp in the old minimum
            Student temp = students[currentMinIndex];
            students[currentMinIndex] = students[i];
            
            students[i] = temp;
        }
    }

    
    public static int findMaximum(int[] array){
        int bigest = array[0];
        for (int j : array) {

            if (j > bigest) {
                bigest = j;
            }

        }
        
        
        return bigest;
    }

    public static int findMinimum(int[] array){
        int smallest = array[0];
        for (int i = 0; i < array.length; i++) {
            
            if(array[i] < smallest){
                smallest = array[i];
            }
            
        }
        
        
        return smallest;
    }
    
    public static double findAvg(int[] array){
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            
            total = total + array[1];
        }


        return total / (array.length*1.0);
    }
    
}
