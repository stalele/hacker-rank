package com.stalele;

import java.util.Scanner;

public class MergeSort {
	static int arr[];

	
	public static int merge(int[] arr, int left1, int right1, int left2, int right2) {
        int[] temp = new int[right2 - left1 + 1];
        int index1 = left1;
        int index2 = left2;
        int temp_index = 0;
        int inversion_count = 0;
        while(index1 <= right1 && index2 <= right2) {
            if(arr[index1] <= arr[index2]) {
                temp[temp_index] = arr[index1];
                index1++;
                temp_index++;
            }
            else {
                //In this case we add to our inversion count:
                inversion_count += right1 - index1 + 1;
                temp[temp_index] = arr[index2];
                index2++;
                temp_index++;
            }
        }

        while(index1 <= right1) {
            temp[temp_index] = arr[index1];
            index1++;
            temp_index++;
        }

        while(index2 <= right2) {
            temp[temp_index] = arr[index2];
            index2++;
            temp_index++;
        }

        for(int i = 0; i < temp.length; i++) {
            arr[left1 + i] = temp[i];
        }

        return inversion_count;
    }

    public static int findNegativeSubarrays(int[] arr, int left, int right) {
        if(right < left) {
            return 0;
        }
        if(right == left) {
            if(arr[left] < 0) {
                return 1;
            }
            else{
                return 0;    
            }
        }

        int mid = (left + right)/2;
        int num1 = findNegativeSubarrays(arr, left, mid);
        int num2 = findNegativeSubarrays(arr, mid+1, right); 
        int num3 = merge(arr, left, mid, mid+1, right);

        return num1 + num2 + num3;
    }

    public static void main(String[] args) {
        int n=5;
        /*Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        scan.nextLine();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }*/
        
        arr = new int[]{1,-2,4,-5,1};

        int accumulator[] = new int[n];
        accumulator[0] = arr[0];
        for(int i = 1; i < n; i++) {
            accumulator[i] = accumulator[i-1] + arr[i];
        }

        System.out.println(findNegativeSubarrays(accumulator, 0, n-1));
    }

}
