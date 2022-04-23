import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.print("Enter the length of array: ");
        int length = Integer.parseInt(reader.readLine());

        System.out.println("Enter the arranged int array");

        for (int i = 0; i < length; i++) {
            System.out.print("=> ");
            numbers.add(Integer.parseInt(reader.readLine()));
        }

        System.out.print("Enter the number whose index we are looking for: ");
        int number = Integer.parseInt(reader.readLine());

        int position = 0;
        int left = 0;
        int right = numbers.size() - 1;

        while (left <= right){
            int middle = (left + right) / 2;
            if (numbers.get(middle) == number){
                System.out.println(number + " position is " + (middle+1));
                break;
            }
            else if (numbers.get(middle) < number){
                left = middle + 1;
            }
            else if (numbers.get(middle) > number){
                right = middle - 1;
            }
        }
    }
}
