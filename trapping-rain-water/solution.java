/**
 *  https://leetcode.com/problems/trapping-rain-water/submissions/1265354127/
 *  submitted at May 22, 2024 19:14
**/

class Solution {
    public int trap(int[] height) {
        int water = 0;
        //Get the max height at each point:
        //Left:
        int[] lMax = new int[height.length];
        for(int i=0;i<height.length;i++) {
            if(i==0) {
                lMax[i] = height[i];
                continue;
            }
            lMax[i] = Math.max(height[i],lMax[i-1]);
        }
        //Right:
        int[] rMax = new int[height.length];
        for(int i=height.length-1;i>=0;i--) {
            if(i==height.length-1) {
                rMax[i] = height[i];
            }
            else {
                rMax[i] = Math.max(height[i],rMax[i+1]);
            }
            //Calculate and sum the water depth at this point:
            water += Math.min(lMax[i],rMax[i]) - height[i];
        }
        return water;
    }
}
