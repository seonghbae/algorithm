package programmers.Heap.doubleEndedPriorityQueue;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minpq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<Integer>((o1, o2) -> o2-o1);
        for(int i=0; i<operations.length; i++){
            if(operations[i].charAt(0)=='I'){
                int number = Integer.parseInt(operations[i].split(" ")[1]);
                minpq.add(number);
                maxpq.add(number);
            }
            else if(operations[i].charAt(2)=='1') minpq.remove(maxpq.poll());
            else maxpq.remove(minpq.poll());
        }
        if(minpq.isEmpty()) return new int[] {0, 0};
        return new int[] {maxpq.peek(), minpq.peek()};
    }
}