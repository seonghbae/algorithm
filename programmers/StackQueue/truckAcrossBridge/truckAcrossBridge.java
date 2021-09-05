package programmers.StackQueue.truckAcrossBridge;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, sum = 0, cnt = 0, idx = 0;
        Queue<Integer> Q = new LinkedList<Integer>();
        for(int i=0; i<bridge_length; i++) Q.add(0);
        while(cnt<truck_weights.length){
            if(Q.peek()!=0) cnt++;
            sum -= Q.poll();
            if(idx<truck_weights.length && sum+truck_weights[idx]<=weight){
                sum += truck_weights[idx];
                Q.add(truck_weights[idx++]);
            }
            else Q.add(0);
            answer++;
        }
        return answer;
    }
}