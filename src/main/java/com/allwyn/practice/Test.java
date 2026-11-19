package com.allwyn.practice;
import java.util.*;
import java.lang.*;
import java.io.*;


public class Test {
    public static void main (String[] args) throws java.lang.Exception
	{
		int[] nums = {2, 5, 8, 1, 11, 21, 31};
		int[] left  = {2, 5, 8};
        int[] right = {1, 11, 21, 31};
		nums = mergeSort(nums);
		Arrays.stream(nums).forEach(System.out::println);
	}
	
	public static int[] mergeSort(int[] nums) {

        // Step 1: Write the base condition
        if(nums.length==1) {
            return nums;
        }

        // Step 2: Find the midpoint
        
        int midpoint = nums.length/2;
        
        // Step 3: Divide into left and right arrays

        int[] left = Arrays.copyOfRange(nums, 0, midpoint);
        int[] right = Arrays.copyOfRange(nums, midpoint, nums.length);

        // Step 4: Recursively call mergeSort()
        // on both halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Step 5: Call your existing merge()
        // method and return the result
        
        nums = merge(left, right);

        return nums;
    }
	
	public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;
    
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
    
        // Copy remaining left elements
        while (i < left.length) {
            result[k++] = left[i++];
        }
    
        // Copy remaining right elements
        while (j < right.length) {
            result[k++] = right[j++];
        }
    
        return result;
    }
    
    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
    
        // Iterate from low to high - 1.
        // If nums[j] <= pivot:
        //   Increment i
        //   Swap nums[i] and nums[j]
    
        // Finally swap nums[i + 1] with nums[high].
        // Return the pivot's final index.
    
        return -1;
    }
}

class Solution {
    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
    public int[] selectionSort(int[] nums) {
        int min = 0;
        int temp = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            min = nums[i];
            index = i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<min) {
                    min = nums[j];
                    index = j;
                }
            }
            temp = nums[i];
            nums[i] = min;
            nums[index] = temp;
        }
        return nums;
    }
    // [5, 3, 4, 1] 
    public int[] insertionSort(int[] nums) {
        int temp = 0;
        for (int j=0;j<nums.length;j++ ) {
            for (int i=1;i<nums.length;i++ ){
                int key = nums[i];
                if(nums[i-1]>key) {
                    temp = nums[i-1];
                    nums[i-1] = key;
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }
}