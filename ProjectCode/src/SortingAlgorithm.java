import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithm {
    public void algorithm1(int n, int[] input) {
        //find absolute max value to ensure no arrayIndexOutOfBounds Exceptions//
        int maxVal = Math.abs(input[0]);
        for (int i = 0; i < n; i++) {
            if (Math.abs(input[i]) > maxVal) {
                maxVal = Math.abs(input[i]);
            }
        }

        // System.out.println("Max Val: " + maxVal);

        //used array names from Algorithm2 for clarity//
        int[] sortpos = new int[maxVal + 1]; //b
        int[] countp = new int[maxVal + 1]; //t
        int[] sortneg = new int[maxVal]; //k
        int[] countn = new int[maxVal + 1]; //f

        //storing + counting values//
        for (int x = 0; x < n; x++) {
            //store 0 count in pos array//
            if (input[x] == 0) {
                countp[0] = countp[0] + 1;
            }
            //now dealing with pos values//
            else if (input[x] > 0) {
                //store//
                sortpos[input[x]] = input[x];
                if (sortpos[input[x]] == input[x]) {
                    //count//
                    countp[input[x]] += 1;
                }
                //now dealing with neg values//
            } else {
                //store//
                //using maxValue to ensure non negative index//
                sortneg[input[x] + maxVal] = input[x];
                if (sortneg[input[x] + maxVal] == input[x] && sortneg[input[x] + maxVal] != 0) {
                    //cannot have a negative indices//
                    //ensures individual mapping of values//
                    countn[Math.abs(input[x]) - 1] += 1;
                }
            }
        }
        //use arrays to print out the values in ascending order//
        algorithm2(sortneg, sortpos, countn, countp, maxVal);
        return;
    }

    public void algorithm2(int[] sortedneg, int[] sortedpos, int[] countn, int[] countp, int maxVal) {
        //used to print negatives from lowest to highest//
        int i = maxVal;
        int j;
        //print negatives first//
        while (i > 0) {
            if (countn[i] != 0) {
                j = 0;
                //print every occurrence of the current value//
                while (j < countn[i]) {
                    //i + 1 as arrays index from 0//
                    System.out.print("-" + (i + 1) + " ");
                    j++;
                }
            }
            i--;
        }



        //print positives//
        //start from 1 as countpos[0] is for 0 count//
        i = 0;
        while (i < countp.length) {
            if (countp[i] != 0) {
                j = 0;
                //print all occurernces of the current val//
                while (j < countp[i]) {
                    System.out.print((i + " "));
                    j++;
                }
            }
            i++;
        }
        return;
    }

    public static void main(String[] args) {
        SortingAlgorithm sa = new SortingAlgorithm();
        TestingAlgorithms ta =  new TestingAlgorithms();

        int n = 100;
        int[] arr = new int[n];
        for(int i = 0; i < n / 2; i++){
            arr[i] = -i;
        }
        for(int i = n / 2; i < n; i++){
            arr[i] = i - n / 2;
        }
        System.out.println(arr.length);
        shuffleArray(arr);

        //the following is used to test//
        long startTime = System.currentTimeMillis();
        sa.algorithm1(arr.length, arr);

        //tests will take place here//
        System.out.println(Arrays.toString(arr));
       // ta.selectionSort(arr);

        //end of tests//
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        long hours = totalTime / 3600000;
        long minutes = (totalTime % 3600000) / 60000;
        long seconds = (totalTime % 60000) / 1000;
        long milliseconds = totalTime;

        System.out.println("Time taken to sort " + n + " elements: " +
                hours + "h " + minutes + "m " + seconds + "s " + milliseconds + "ms");

        // Optional: verify the array is sorted

     //  System.out.println("Is Array sorted correctly? " + isSorted(arr));
    }

    public static void shuffleArray(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }
}
