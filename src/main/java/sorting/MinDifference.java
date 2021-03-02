package sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class MinDifference{

    @Test
    public void findMinDifference(){
        int arr[]=new  int[]{3, 4, 1, 9, 56, 7, 9, 12};
        assertEquals(6,findMinDifferenceArray(arr,5) );
    }
    private static int findMinDifferenceArray(int[] arr,int m){
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        int n=arr.length;
        int minIndex=0;
        for(int i=0;i<n-m-1;i++){
            int difference =arr[i+m-1] - arr[i];
            if(difference < min){
                minIndex=i;
                min=difference;
            }
        }
        return min;
    }


}

