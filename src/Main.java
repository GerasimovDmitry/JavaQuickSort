import java.util.Random;

public class Main {
    public static final Random RND = new Random();
    public static void main(String[] args) {
        int [] arr = {1,6,4,0,1,2,4,6,7,8,9,3,1};
        int [] arrSecond = {2,7,5,1,2,3,5,7,8,8,4,3,2};
        outputArray(arr);
        quickSort2(arr);
        outputArray(arr);
        outputArray(arrSecond);
        quickSort1(arrSecond);
        outputArray(arrSecond);
    }

    public static void outputArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //swap elements
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //sort by pivot element
    private static int partition(int[] array, int begin, int end) {
        int index = begin + RND.nextInt(end - begin + 1); // generate random index of array
        int pivot = array[index];
        swap(array, index, end);
        for (int i = index = begin; i < end; i++) {
            if (array[i] <= pivot) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return (index);
    }

    private static void quickSortFor(int[] array, int begin, int end) {
        if (end >= begin) {
            int index = partition(array, begin, end);
            quickSortFor(array, begin, index - 1); //sort left part
            quickSortFor(array, index + 1,  end); //sort right part
        }
    }

    public static void quickSort1(int[] array) {
        quickSortWhile(array, 0, array.length - 1); //mainCall
    }
    private static void quickSortWhile(int[] nums, int first, int last) {
        if (first >= last) {
            return;
        }
        int i = first, j = last;
        int pivot = nums[first + RND.nextInt(last - first + 1)]; //random element from array

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
        quickSortWhile(nums, first, j); //sort left part
        quickSortWhile(nums, i, last); //sort right part
    }

    public static void quickSort2(int[] array) {
        quickSortFor(array, 0, array.length - 1);//
    }

}
