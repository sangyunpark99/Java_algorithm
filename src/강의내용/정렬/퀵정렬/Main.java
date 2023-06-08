package 강의내용.정렬.퀵정렬;

import java.util.Arrays;

public class Main {

    public static void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }

        int pivot = partition(arr, left, right);

        // 재귀 호출
        quickSort(arr, left, pivot - 1); // 좌측
        quickSort(arr, pivot + 1, right); // 우측
    }

    public static int partition(int[] arr, int left, int right){

        int pivot = arr[left];
        int i = left;
        int j = right;

        while(i < j){ // 서로 겹치지 않는 경우
            while(arr[i] > pivot && i < j){
                j--;
            }

            while(arr[i] <= pivot && i < j){
                i++;
            }

            swap(arr,i,j);
        }

        swap(arr, left, i);

        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6,2,7,9,4,5,8};
        quickSort(arr,0,arr.length-1);
        System.out.println("퀵 정렬 : " + Arrays.toString(arr));
    }
}
