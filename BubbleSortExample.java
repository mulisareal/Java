import java.util.Scanner;

public class BubbleSortExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[10];  // Array untuk 10 angka

        // Meminta input dari pengguna
        System.out.println("Masukkan 10 angka:");
        for (int i = 0; i < data.length; i++) {
            System.out.print("Angka ke-" + (i + 1) + ": ");
            data[i] = scanner.nextInt();
        }

        // Menampilkan array sebelum sorting
        System.out.println("Data sebelum diurutkan:");
        printArray(data);

        // Memanggil metode bubbleSort untuk mengurutkan array
        bubbleSort(data);

        // Menampilkan array setelah sorting
        System.out.println("Data setelah diurutkan:");
        printArray(data);

        scanner.close();
    }

    // Metode untuk melakukan bubble sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Tukar array[j] dan array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Metode untuk menampilkan isi array
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}