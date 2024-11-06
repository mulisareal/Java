
public class Shorting{
    public static void main (String[] args){
        int[] data = {22, 10, 15, 3, 8, 2};
        bubbleSort(data);
        System.out.println("Data setelah diurutkan: ");
        for (int i : data){
            System.out.print(i+" ");
        }
    }

    private static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for(int i = 0;i<n-1;i++){
        swapped=false;
            for (int j=0;j<n-1-i;j++){
                if (array[j] > array[j+1]){
                 int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                swapped = true;
                }
            }
        }
    }
}