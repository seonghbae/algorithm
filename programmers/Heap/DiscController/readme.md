# 1차 설계
작업 시간이 적은 순서대로 처리합니다.

# 1차 코드

```java
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, begin = 0;
        PriorityQueue<int[]> maxheap = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });
        for(int i=0; i<jobs.length; i++) maxheap.add(jobs[i]);
        for(int i=0; i<jobs.length; i++){
            int[] cur = maxheap.poll();
            answer += (answer+cur[1]-cur[0]);
            begin = cur[1];
        }
        return answer/jobs.length;
    }
}
```

# 1차 결과


# 2차 설계
- 작업시간이 적은 순서대로 처리하되, 한 작업이 끝난 경우 가장 빠른 작업을 우선합니다.
1. 작업을 시간순으로 정렬합니다.
2. 시간을 순차적으로 증가시킵니다.
3. 작업 요청 시간이 되면 우선 순위 큐에 작업을 넣고 현재 작업 시간이 끝난 경우 현재 작업을 갱신합니다.
4. 작업을 전부 수행한 경우 종료합니다.

# 2차 코드

```java
```

# 2차 결과


# 문제 출처
