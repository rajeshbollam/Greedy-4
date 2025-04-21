//In this approach, we take a pair from both top and bottom and check if either of those appear at all the indexes in both tops and bottoms arrays. If they do, we check the minimum rotations and return the result
//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {     
        int a = tops[0];
        int result = check(tops, bottoms, a);
        if(result != -1){
            return result;
        }
        int b = bottoms[0];
        return check(tops, bottoms, b);

    }

    private int check(int[] tops, int[] bottoms, int target){
        int tRot = 0;
        int bRot = 0;
        for(int i = 0; i< tops.length; i++){
            int top = tops[i];
            int bottom = bottoms[i];
            if(target != top && target != bottom) return -1;
            if(target != top) tRot++;
            if(target != bottom) bRot++;
        }

        return Math.min(tRot, bRot);
    }
}