import java.util.Random;

public class Main {
    public static final Random RND = new Random();
    public static void main(String[] args) {
        int [] arr = {1,6,4,0,1,2,4,6,7,8,9,3,1};
        int [] arrSecond = {2,7,5,1,2,3,5,7,8,8,4,3,2};
        outputArray(arr);
        sortRecursion(arr);
        outputArray(arr);
        outputArray(arrSecond);
        sortRecursionWhile(arrSecond);
        outputArray(arrSecond);
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static int partition(int[] array, int begin, int end) {
        int index = begin + RND.nextInt(end - begin + 1);
        int pivot = array[index];
        swap(array, index, end);
        for (int i = index = begin; i < end; ++ i) {
            if (array[i] <= pivot) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return (index);
    }

    private static void qsort(int[] array, int begin, int end) {
        if (end > begin) {
            int index = partition(array, begin, end);
            qsort(array, begin, index - 1);
            qsort(array, index + 1,  end);
        }
    }

    private static void quickSort(int[] nums,  int first, int last) {
        if (first >= last) {
            return;
        }
        int i = first, j = last;
        int pivot = nums[first + RND.nextInt(last - first + 1)];

        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        quickSort(nums, first, j);
        quickSort(nums, i, last);
    }
    public static void sortRecursionWhile(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void sortRecursion(int[] array) {
        qsort(array, 0, array.length - 1);
    }

    public static void outputArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
