package sort;

import java.util.Arrays;

/**
 * @author lawrence
 * 2019.02.27
 * 选择排序
 */
public class SelectionSort {


    public static void selectionSort(int[] arr){

        int length = arr.length;

        for(int i = 0 ; i < length ; i++){
            //保存最大值
            int maxValue = arr[i];
            //保存最大值的索引
            int maxIndex = i;
            for(int j = i + 1 ; j < length ; j++){
                if(arr[j] > maxValue){
                    maxValue = arr[j];
                    maxIndex = j;
                }
            }
            //将两个位置交换
            int temp = arr[i];
            arr[i] = maxValue;
            arr[maxIndex] = temp;
        }

    }

    public static void main(String[] args) {
        int[] arrs = {10,6,8,7,4,1,2,3};

        selectionSort(arrs);

        System.out.println(Arrays.toString(arrs));
    }


}
