package question5;

import java.util.Arrays;

public class FindMedian {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] add = new int[nums1.length + nums2.length];
		for (int i = 0, j = 0; (i + j) < add.length; ) {
			
            if (i == nums1.length) {
                add[i + j] = nums2[j++];
                continue;
            }
            
            if (j == nums2.length) {
                add[i + j] = nums1[i++];
                continue;
            }
            
            if (nums1[i] < nums2[j]) {
                add[i + j] = nums1[i];
                i++;
            } 
            
            else {
                add[i + j] = nums2[j];
                j++;
            }
        }
		return findMedianSortedArrays(add);
	}
	
	public static double findMedianSortedArrays(int[] nums) {
		if(nums == null) return 0;
		Arrays.sort(nums);
		return (nums[(nums.length - 1) / 2] + nums[nums.length / 2]) / 2.0;
	}

}
