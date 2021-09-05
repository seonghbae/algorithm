package programmers.Heap.discController;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, idx = 0, time = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0]-o2[0]);
        PriorityQueue<int[]> minheap = new PriorityQueue<int[]>((o1, o2) -> o1[1]-o2[1]);
        while(idx<jobs.length || !minheap.isEmpty()){
            // 현재 시간이 요청 시간이 되면 큐에 삽입
            while(idx<jobs.length && jobs[idx][0]<=time){
                minheap.add(jobs[idx++]);
            }
            // 큐에서 가장 앞에 것 꺼내서 걸린 시간, 현재 시간 갱신
            if(!minheap.isEmpty()){
                time += minheap.peek()[1];
                answer += (time-minheap.poll()[0]);
            }
            else time = jobs[idx][0];
        }
        return answer/jobs.length;
    }
}