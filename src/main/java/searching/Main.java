package searching;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        System.out.println("Linear Search: " + LinearSearch.linearSearch(arr, 10));
        System.out.println("Binary Search: " + BinarySearch.binarySearch(arr, 10));
        System.out.println("Jump Search: " + JumpSearch.jumpSearch(arr, 10));
        System.out.println("Interpolation Search: " + InterpolationSearch.interpolationSearch(arr, 10));
        System.out.println("Exponential Search: " + ExponentialSearch.exponentialSearch(arr, 10));
    }
}