package Search;

public class BinarySearch <T extends Comparable<T>>{


    //Parametri arr=array da passare, l=0, r=lunghezza-1, oggetto da trovare


    public T binarySearch(T[] arr, int l, int r, T x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle
            // itself
            if (arr[mid] == x)
                return arr[mid];

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid].compareTo(x) == 1)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not
        // present in array
        return null;
    }
}
