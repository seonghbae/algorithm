import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i=0; i<scoville.length; i++) heap.add(scoville[i]);
        while(heap.peek()<K){
            if(heap.size()==1) break;
            heap.add(heap.poll()+heap.poll()*2);
            answer++;
        }
        if(heap.peek()<K) return -1;
        return answer;
    }
}