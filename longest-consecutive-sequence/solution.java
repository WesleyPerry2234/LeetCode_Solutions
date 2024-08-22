/**
 *  https://leetcode.com/problems/longest-consecutive-sequence/submissions/
 *  submitted at May 22, 2024 18:07
**/

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        //[0,0,1,2,3,4,5,6,7,8]

        int longest = 1;
        int count = 1;

        for(int i=1;i<nums.length;i++) {
            if(nums[i] != nums[i-1]) {
                if(nums[i] == nums[i-1] + 1) {
                    count ++;
                }
                else {
                    longest = Math.max(longest,count);
                    count = 1;
                }
            }
        }
        return Math.max(longest,count);
    }
}
