//The approach here is to store indexes in a hashmap of all the character in the source string to avoid traversing through it all the time 
//Here, we traverse through the target string and we find the next index of character in source string by doing binary search in hashmap and whenever we run out of list with binary search, we increase the count
//In the end we return the count
//Time Complexity: O(mlogn) where m is the length of the target string and n is the length of the source string
//Space Complexity: O(n)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution{
    public int shortestWay(String source, String target){
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int sl = source.length(); int tl = target.length();
        for(int i = 0; i < sl; i++){
            int ch = source.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(i);
        }
        int count = 1;
        int sp = 0; int tp = 0;
        while(tp < target.length()){
            char tChar = target.charAt(tp);
            if(!map.containsKey(tChar)){
                return -1;
            }
            if(sp == sl){
                count++;
                sp = 0;
            }
            char sChar = source.charAt(sp);
            if(sChar != tChar){
                List<Integer> li = map.get(tChar);
                int bsIdx = binarySearch(li, sp);
                if(bsIdx == li.size()){
                    //reset the things
                    sp = li.get(0);
                    count++;                
                } else {
                    sp = li.get(bsIdx);
                    if(tp == tl) return count;
                }
            }            
            sp++;
            tp++;
        }
        return count;
    }

    private int binarySearch(List<Integer> li, int target){
        int low = 0; int high = li.size()-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(li.get(mid) < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}