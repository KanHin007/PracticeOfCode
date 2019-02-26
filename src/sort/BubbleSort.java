package sort;

import java.util.Arrays;

/**
 * @author lawrence
 * 2019.02.27
 * 冒泡排序
 */
public class BubbleSort {


    /**
     * 冒泡排序
     * n的平方
     * @param arr
     */
    public static void bubbleSort(int[] arr){

        int length = arr.length;

        for(int i = 0 ; i < length ; i++){
            for(int j = i + 1 ; j < length ; j ++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }


    public static void main(String[] args) {

        int[] arr = {10,9,88,7,6,5,4,3,2,1};

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));

    }



}
