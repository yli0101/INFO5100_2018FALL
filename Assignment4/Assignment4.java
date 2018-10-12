package assignment;

public class Assignment4 {
	
	/**
	 * The deadline of assignment4 is 10/12/2018 23:59 PST.
	 * Please feel free to contact Zane and Amanda for any questions.
	 */
	
	/*
	 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
	 * s = "leetcode" return 0. 
	 * s = "loveleetcode" return 2.
	 */
    public int firstUniqChar(String s) {
    	if(s == null || s.length() == 0)
    		return -1;
    	
    	for(int i = 0; i < s.length(); i++) {
    		
    		for(int j = 1; j < s.length(); j++) {		
    			int n = 0;
    			while (n < 1) {
    				if(s.charAt(j) == s.charAt(i)) 
    					n ++;
    			return i;
    			}
    		}
    	}
    	return -1;
     }
    
    /*
     *Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * Input: 38 Output: 2
     * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public int addDigits(int n) {
    	if(n < 10)
    		return n;
    	else {
    		while(n > 9) {
    			int total = 0;
    			String s = String.valueOf(n);
    			for(int i = 0; i < s.length(); i++) {
    				total += s.charAt(i);
    			}
    			n = total;
    		}
    		return addDigits(n);
    	}
    }
    
    /*
     *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *  Input: [0,1,0,3,12] Output: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
    	if(nums.length < 1)
    		return;
    	int i = 0;
    	while(i < nums.length && nums[i] != 0)
    		i++;
    	if(i == nums.length)
    		return;
    	for(int j = i+1; j < nums.length; j++) {
    		while(nums[j] == 0)
    			j++;
    		swap(nums,i,j);
    	}	
     }
    
    public void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[j] = nums[i];
    	nums[i] = temp;
    }
	
    /*
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
     */
	public String longestPalindrome(String s) {
		if(s.length() == 0 || s.length() == 1)
			return s;
		
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		int length = 0;
		int start = 0;
		int end = 0;
		for(int i=0; i < s.length();i++) {
			for(int j=i; j >= 0; j--) {
				if( s.charAt(i) == s.charAt(j) && ((i - j < 2) || isPalindrome[j+1][i-1] == true)) {
					isPalindrome[j][i] = true;
					if(length < (i - j)) {
						length = i - j + 1;
						start = j;
						end = i;
					}
				}
				
			}
		}
		return s.substring(start, end + 1);
		
    }
	
    /*
     * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
     * Given input matrix = [ [1,2,3],
  			      [4,5,6],
  			      [7,8,9] ],
     * rotate the input matrix in-place such that it becomes: [  [7,4,1],
  								 [8,5,2],
  								  [9,6,3] ],
     */
    public int[][] rotate(int[][] matrix) {
    	int l = matrix.length;
    	if(l == 0 || l == 1)
    		return matrix;
    	for(int i=0; i < l/2; i++) {
    		for(int j=i; j< l-i-1; j++) {
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[l-j-1][i];
    			matrix[l-j-1][i] = matrix[l-i-1][l-j-1];
    			matrix[l-i-1][l-j-1] = matrix[j][l-i-1];
    			matrix[j][l-i-1] = temp;
    		}
    	}
    	return matrix;
   }

}

