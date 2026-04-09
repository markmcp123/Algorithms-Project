public class TestingAlgorithms {
    public static void selectionSort(int[] arr){
        int temp;
        int min_index;

        for(int i = 0; i < arr.length - 1; i++){
            min_index = i;
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }
                temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
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

    //quickSort, heapSort and bucketSort still to be done//
}

