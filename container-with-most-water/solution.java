/**
 *  https://leetcode.com/problems/container-with-most-water/submissions/1265452279/
 *  submitted at May 22, 2024 22:04
**/

class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int water=0;

        while(i<j){
            water = Math.max(water,Math.min(height[i],height[j])*(j-i));
            if(height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return water;
    }
}
