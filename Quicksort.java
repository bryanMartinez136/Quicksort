/*
 *  Takes and integer array and sorts it from the largest value to the smallest
 * using the quicksort algorithm
 */
public class Quicksort{
    public static void my_quicksort(int[] array){
        quicksort_helper(array, 0, array.length-1);
    }

    private static void quicksort_helper(int[] array, int low, int high){
        // no need to sort if there is only one item in the array
        if(array.length == 1){return;}

        //find a pivot for the array, in this case the pivot will just be the middle value
        int pivot = low + (high - low) / 2; 

        // Swap the pivot to the end of the array
        int temp = array[pivot];
        array[pivot] = array[high];
        array[high] = temp; 

        // the first position in the right sub array. 
        int k = partition(array, low, high-1, array[high]);

        // now put the pivot in place
        temp = array[k]; 
        array[k] = array[high]; 
        array[high] = temp; 

        // recursive call to sort the left and right subarrays. 
        if( (k-low) > 1){ quicksort_helper(array, low, k-1); }
        if( (high-k) > 1){ quicksort_helper(array, k+1, high);}
        
    }

    private static int partition(int[] array, int low, int high, int pivotVal){
        // moves indices inwards from both ends of the subarray until the two indices meet.
        while(low<=high){
            // want to traverse the array until we hit the first value that is greater than the pivot. 
            while(array[low] < pivotVal){low++;}

            // now we want to traverse from the right side until we find a value that is less than the pivot
            // and does not cross the left traversal
            while ((high >= low) && (array[high] > pivotVal)) { high--; }
            
            // high and low have crossed, so a swap is performed so that the correct vaules are in the correct subarray
            if(high > low)
            {
                int temp = array[low];
                array[low] = array[high]; 
                array[high] = temp; 
            }
        }
        return low; 
        
        
    }
}