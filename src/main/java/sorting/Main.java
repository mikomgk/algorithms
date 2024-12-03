package sorting;

public class Main {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        BubbleSort.bubbleSort(arr.clone());
        SelectionSort.selectionSort(arr.clone());
        InsertionSort.insertionSort(arr.clone());
        MergeSort.mergeSort(arr.clone());
        int[] quickSortArr = arr.clone();
        QuickSort.quickSort(quickSortArr);
    }
}
