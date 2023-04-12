public class quicksort {
    public static void quicksort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            quicksort(array, left, pivot - 1);
            quicksort(array, pivot + 1, right);
        }
    }
    
    public static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        
        swap(array, i + 1, right);
        return i + 1;
    }
    
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 3, 7, 1, 8, 6, 4};
        quicksort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}