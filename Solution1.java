/*
Problem : Two sum
Difficulty : Easy
Link : https://leetcode.com/problems/two-sum/
Time Complexity : O(n^2)
Space Complexity : O(1)
Given : 1) Array of Integer = nums
        2) Target 
In simple term,
    from array we have to find 
    TWO Integer(number) whose SUM is equal to 
            "TARGET"
    If target matched : Return Index of integers {i, j}
    else : Return {0, 0}

Here is Java Solution :
*/

import java.util.*;
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int a = 0, b = 0;
         for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    a = i;
                    b = j;
                }
            }
         }
         int arr[] = {a, b};
         return arr;
    } 
    /* Main Method Directly not written in Leetcode */
    public static void main(String[] args) {
        //For Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        sc.close();
        
        //For Result
        Solution1 obj = new Solution1();
        System.out.println(Arrays.toString(obj.twoSum(nums, target)));
        /* Arrays.toString Used here because :

        # Method ka return type class ke obj me chala jaata he
        # Jisase output Object Reference ho jaata he
        # So is output ko human readable banane ke liye use hota he

        */
    }
 }