package programmers.WeeklyChallenge;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        ArrayList<Integer> list = new ArrayList<Integer>();
        int idx = 0;
        for(int i=0; i<enter.length; i++){
            // 새 인원이 입실할 것이기 때문에 기존 인원 +1
            for(int j=0; j<list.size(); j++) answer[list.get(j)-1]++;
            // 새 인원 입실하고 원래 있던 인원 수만큼 만난 인원증가
            list.add(enter[i]);
            answer[enter[i]-1] += (list.size()-1);
            // 순서대로 있는만큼 퇴실
            while(idx<leave.length && list.contains(leave[idx])) list.remove((Integer)leave[idx++]);
        }
        return answer;
    }
}