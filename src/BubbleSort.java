import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Sort by max (true/false): ");
        boolean searchMax = Boolean.parseBoolean(reader.readLine());

        System.out.print("Fill array by random numbers (true/false): ");
        boolean isRandom = Boolean.parseBoolean(reader.readLine());

        System.out.print("Length of array: ");
        int length = Integer.parseInt(reader.readLine());

        sortArray(searchMax, isRandom, length);
    }

    static void sortArray(boolean searchMax, boolean isRandom, int length) throws IOException {
        if (isRandom == true) {
            ArrayList<Integer> array = fillArray(length, isRandom);
            searchMaxMin(searchMax, array);
        } else {
            ArrayList<Integer> array = fillArray(length, isRandom);
            searchMaxMin(searchMax, array);
        }
    }
    static ArrayList fillArray(int length, boolean isRandom) throws IOException {
        ArrayList<Integer> array = new ArrayList<>();
        if (isRandom == true) {
            for (int i = 0; i < length; i++) {
                int rand = (int) ((Math.random() * (100 - 1)) + 1);
                array.add(rand);
            }
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < length; i++) {
                System.out.print("Enter number: ");
                array.add(Integer.parseInt(reader.readLine()));
            }
        }
        System.out.println("Original array: " + array);
        return array;
    }
    static void searchMaxMin(boolean isMax, ArrayList<Integer> array) {
        int aim = array.get(0);

        if (isMax == true) {
            for (int i = 0; i < array.size(); i++) {
                for (int j = 0; j < array.size(); j++) {
                    int buffer = 0;
                    if (array.get(i) > array.get(j)) {
                        buffer = array.get(i);
                        array.set(i, array.get(j));
                        array.set(j, buffer);
                    }
                }
            }
            System.out.println("Sorted array (max): " + array);
        } else if (isMax == false) {
            for (int i = 0; i < array.size(); i++) {
                for (int j = 0; j < array.size(); j++) {
                    int buffer = 0;
                    if (array.get(i) < array.get(j)) {
                        buffer = array.get(i);
                        array.set(i, array.get(j));
                        array.set(j, buffer);
                    }
                }
            }
            System.out.println("Sorted array (min): " + array);
        }
    }
}