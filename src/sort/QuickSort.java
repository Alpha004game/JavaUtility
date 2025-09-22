package sort;

public class QuickSort<T extends Comparable<T>>
{
    //Instanzia per metodi con compareTo

    private int partition(T array[], int low, int high) {

        // choose the rightmost element as pivot
        T pivot = array[high];

        // pointer for greater element
        int i = (low - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // swapping element at i with element at j
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }
        // find pivot element such that
        // elements smaller than pivot are on the left
        // elements greater than pivot are on the right
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // return the position from where partition is done
        return (i + 1);
    }

    public void quickSort(T[] array)
    {
        quickSort(array, 0, array.length-1);
    }
    private void quickSort(T array[], int minimum, int maximum) {
        //maximum--;
        if (minimum < maximum) {

            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pi = partition(array, minimum, maximum);

            // recursive call on the left of pivot
            quickSort(array, minimum, pi - 1);

            // recursive call on the right of pivot
            quickSort(array, pi + 1, maximum);
        }
    }
}
