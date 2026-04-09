public class TestingAlgorithms {

    public static final int QS_LIMIT = 10;
    public static void selectionSort(int[] arr){
        int temp;
        int min_index;

        for(int i = 0; i < arr.length - 1; i++){
            min_index = i;
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
                temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
        }
    }


    public static void bubbleSort(int[] arr){
        int n = arr.length;
        int tmp;
        for(int i = 0; i < n - 1; i++){
            for(int j = 1; j < n - i; j++){
                if(arr[j] < arr[j - 1]){
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr){
        int temp;
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j - 1]){
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                else{
                    break;
                }
            }
        }
    }

    //beginning of merge sort//
    public static void mergeSort(int[] a, int n){
        if(n < 2){
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for(int i = 0; i < mid; i++){
            left[i] = a[i];
        }
        for(int i = mid; i < n; i++){
            right[i - mid] = a[i];
        }
        mergeSort(left, mid);
        mergeSort(right, n - mid);
        merge(a, left, right, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right){
        int i = 0, j = 0, k = 0;
        while(i < left && j < right){
            if(l[i] <= r[j]){
                a[k++] = l[i++];
            }else{
                a[k++] = r[j++];
            }
        }

        while(i < left){
            a[k++] = l[i++];
        }
        while(j < right){
            a[k++] = r[j++];
        }
    }
    //end of merge sort//

    // If array contains less than 10 elements, will use insertionSort as more practical
    public static void quickSort(int[] a, int lo, int hi){
        if(hi <= lo + QS_LIMIT - 1){
            insertionSort(a);
            return;
        }

        int median = medianOf3(a, lo, lo + (hi - lo) / 2, hi);
        swap(a, lo, median);

        int j = partition(a, lo, hi);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }

    //Partition array into two smaller subarrays to make sorting easier
    private static int partition(int[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        while(true){
            while(a[++i] < a[i]){
                if(i == hi) break;
            }
            while(a[lo] < a[--j]){
                if(j == lo) break;
            }
            if(i >= j) break;
            swap(a, i, j);
        }

        swap(a, i, j);
        return j;
    }

    //Function to swap two values within the array
    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //Practical improvement to QuickSort as best choice of pivot item is the median
    private static int medianOf3(int[] a, int lo, int mid, int hi){
        if((a[lo] >=  a[mid] && a[lo] <=  a[hi]) || (a[lo] <= a[mid] && a[lo] >= a[hi])){
            return a[lo];
        }
        else if((a[mid] >= a[lo] && a[mid] <= a[hi]) || (a[mid] <= a[lo] && a[mid] >= a[hi])){
            return a[mid];
        }
        else{
            return a[hi];
        }
    }
    //End of QuickSort and helper functions with it


    public static void heapSort(int[] arr){
        int n = arr.length;

        for(int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i);
        }

        for(int i = n - 1; i > 0; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    //Helper function to heapify a subtree rooted with a node i
    private static void heapify(int[] arr, int n, int i){
        int largest = i;
        int left =  2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }
        if(largest != i){
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    //End of heapSort


    public static void bucketSort(int[] arr){
        int n = arr.length;
        int[] counts = new int[n];

        int[][] buckets = new int[n][n];
        for(int i = 0; i < n; i++){
            buckets[i] = new int[n];
        }

        for(int i = 0; i < n; i++){
            int bi = n * arr[i];
            buckets[i][bi] = i;
        }

        for(int i = 0; i < n; i++){
            insertionSort(buckets[i]);
        }

        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < buckets[i][j]; j++){
                arr[index++] = buckets[i][j];
            }
        }
    }
    //End of bucketSort
}


