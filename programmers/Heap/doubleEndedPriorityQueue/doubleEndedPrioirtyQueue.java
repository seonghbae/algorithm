package programmers.Heap.doubleEndedPriorityQueue;
import java.util.TreeMap;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> dpq = new TreeMap<Integer, Integer>();
        for(int i=0; i<operations.length; i++){
            if(operations[i].charAt(0)=='I') dpq.put(Integer.parseInt(operations[i].split(" ")[1]), 0);
            else if(operations[i].charAt(2)=='1') dpq.pollLastEntry();
            else dpq.pollFirstEntry();
        }
        if(dpq.isEmpty()) return new int[] {0, 0};
        return new int[] {dpq.lastKey(), dpq.firstKey()};
    }
}