import java.util.Arrays;

public class SortingAlgorithim {
    public void algorithim1(int n, int[] input) {
        //find absolute max value to ensure no arrayIndexOutOfBounds Exceptions//
        int maxVal = Math.abs(input[0]);
        for (int i = 0; i < n; i++) {
            if (Math.abs(input[i]) > maxVal) {
                maxVal = Math.abs(input[i]);
            }
        }

        // System.out.println("Max Val: " + maxVal);

        //used array names from Algorithim2 for clarity//
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
                    //cannot have a negative indice//
                    //ensures individual mapping of values//
                    countn[Math.abs(input[x]) - 1] += 1;
                }
            }
        }
        //use arrays to print out the values in ascending order//
        algorithim2(sortneg, sortpos, countn, countp, maxVal);
        return;
    }

    public void algorithim2(int[] sortedneg, int[] sortedpos, int[] countn, int[] countp, int maxVal) {
        //used to print negatives from lowest to highest//
        int i = maxVal;
        int j;
        //print negatives first//
        while (i > 0) {
            if (countn[i] != 0) {
                j = 0;
                //print every occurence of the current value//
                while (j < countn[i]) {
                    //i + 1 as arrays index from 0//
                    System.out.print("-" + (i + 1) + " ");
                    j++;
                }
            }
            i--;
        }

        //print 0's//
        for (int f = 0; f < countp[0]; f++) {
            System.out.print("0 ");
        }

        //print positives//
        //start from 1 as countpos[0] is for 0 count//
        i = 1;
        while (i < countp.length) {
            if (countp[i] != 0) {
                j = 0;
                //print all occurences of the current val//
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
        SortingAlgorithim sa = new SortingAlgorithim();
        //test//
        int[] test1 = {-10, 5, 4, 10, 18, -22, 14, 14, -19, 43, 34, 45, 0, 82, 24};
        int[] test2 = {42, 42, 42, -20, -20, -20, 1234, 4321, 0, 0, 0, 100};
        int[] test3 = {-10, -20, -15, 0, 0, -45, -10, -10, -4};
        System.out.println("Test 1 Array: " + Arrays.toString(test1));
        System.out.println("Sorted Array for Test 1");
        sa.algorithim1(test1.length, test1);
        System.out.println("\nTest 2 Array: " + Arrays.toString(test2));
        System.out.println("Sorted Array for Test 2");
        sa.algorithim1(test2.length, test2);
        System.out.println("\nTest 3 Array: " + Arrays.toString(test3));
        System.out.println("Sorted Array for Test 3");
        sa.algorithim1(test3.length, test3);

        //tests need to be done with num of elements ranging from 10 to 100,000//
        //tests to be compared with the following: Quick Sort, Bubble Sort//
        //Bucket Sort, Heap Sort, Insertion Sort, Merge Sort, Selection Sort//
        //and javas .sort (which is Tim Sort)//


        //the following is used to test//
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        //tests will take place here//

        // ************************//

        //end of tests//
        try {
            Thread.sleep(1700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime);
        long totalTime = endTime - startTime;
        System.out.println("hours:" + totalTime / 3600000);
        System.out.println("minutes:" + totalTime / 60000);
        System.out.println("seconds:" + totalTime / 1000);
        System.out.println("milliseconds:" + totalTime);

    }
}
