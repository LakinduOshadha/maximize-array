import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author Lakindu Oshadha (lakinduoshadha98@gmail.com)
 */
public class MaximumArray {

    public int sum = 0;

    /**
     * Modify the given array and prints the modified array.
     *
     * @param arr array
     * @param k The number of times that array can be modified
     */
    public void printMaximumArray(int[] arr, int k) {
        // Adding elements to the priority queue
        PriorityQueue<Data> elements = new PriorityQueue<Data>();
        for (int i:arr) {
            elements.add(new Data(i));
        }
        System.out.print("The modified Array : ");
        // Creating a object of iterator class to iterate through elements
        Iterator<Data> iter = elements.iterator();

        // Creating local variables
        int temp;
        int count = 0;

        // Converting of maximum negative values to positive values.
        while(iter.hasNext()){
            temp = elements.poll().value;
            // Moidifying the maximum negative values to positive values
            // by multiplying -1.
            if(count < k){
                temp = -1 * temp;
            }

            this.sum += temp;   // Adding the value to the sum
            System.out.print(" " + temp);
            count ++;   // Increasing the count.
        }
    }

    /**
     * Prints the sum of the modified array.
     */
    public void printSumMax() {
        System.out.println("\nMaximum Sum After Modifying the array: " + this.sum);
    }

    /**
     * Gives a brief introduction to user
     * Takes the array and the size of the array which is to be modified, from the user.
     *
     * @return inputArray
     * @throws IOException
     */
    static int[] getInputArray() throws IOException{
        // Giving a brief Introduction to the user
        System.out.print("This program modifies an given array to make " +
                "the sum of the array maximum using priority Queue.\n" + "n - " +
                "No. of integers in input Array.\n" + "\nEnter input arr size(n): ");

        // Getting input size from user
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        // Getting the unsorted arr from the user
        int[] arr = new int[n];
        int inputSize = 0;
        String input;
        do {
            System.out.print("Enter " + n + " integers, separated using space (n1 n2 n3 ...): ");
            input = reader.readLine();
            inputSize = input.split(" ").length;
        } while (inputSize != n);

        String[] numbers = input.split(" ");
        for (int j = 0; j < n; j++) {
            arr[j] = Integer.parseInt(numbers[j]);
        }

        return arr;
    }

    /**
     * Gets the number of times that array can be modified from the user.
     * @return The number of times that array can be modified (k)
     * @throws IOException
     */
    public static int getK() throws IOException {
        System.out.print("Enter the Number of times that array can be modified (k) : ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        return n;
    }

    /**
     * main
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Getting user input
        int[] arr = getInputArray();
        int k = getK();

        // Modifying the array using priority queue and printing it.
        MaximumArray newArr = new MaximumArray();
        newArr.printMaximumArray(arr,k);
        // Prints the sum of the arr after modifying
        newArr.printSumMax();

    }
}

/**
 * Holds the data structure in the priority queue to sort them in ascending order
 *
 */
class Data implements Comparable<Data>{
    int value;

    /**
     * Constructs Data
     * @param v value
     */
    public Data(int v){
        this.value = v;
    }

    /**
     * Sorts and adds numbers into the priority list
     * @param x
     * @return
     */
    @Override
    public int compareTo(Data x) {
        if(value <= x.value)
            return -1;
        else
            return 1;
    }
}
