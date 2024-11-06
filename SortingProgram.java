import java.io.*;
import java.util.*;

public class SortingProgram {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Masukkan jumlah bilangan bulat yang ingin anda urutkan: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Masukkan bilangan bulat ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Pilih algoritma pengurutan: ");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        System.out.println("3. Merge Sort");
        int choice = scanner.nextInt();

        long startTime, endTime;
        switch (choice) {
            case 1:
                startTime = System.nanoTime();
                bubbleSort(arr);
                endTime = System.nanoTime();
                System.out.println("Bubble Sort Completed.");
                break;
            case 2:
                startTime = System.nanoTime();
                quickSort(arr, 0, n - 1);
                endTime = System.nanoTime();
                System.out.println("Quick Sort Completed.");
                break;
            case 3:
                startTime = System.nanoTime();
                mergeSort(arr, 0, n - 1);
                endTime = System.nanoTime();
                System.out.println("Merge Sort Completed.");
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        
        long duration = endTime - startTime;
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Execution Time: " + duration + " nanoseconds");

        saveToFile(arr, duration, choice);
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void saveToFile(int[] sortedArr, long execTime, int algoChoice) throws IOException {
        String algo = (algoChoice == 1) ? "Bubble Sort" :
                      (algoChoice == 2) ? "Quick Sort" : "Merge Sort";
        BufferedWriter writer = new BufferedWriter(new FileWriter("sorted_output.txt"));
        writer.write("Algoritma: " + algo + "\n");
        writer.write("Sorted Array: " + Arrays.toString(sortedArr) + "\n");
        writer.write("Execution Time: " + execTime + " nanoseconds\n");
        writer.close();
    }
}
