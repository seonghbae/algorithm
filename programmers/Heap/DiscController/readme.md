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
![1차 결과](https://user-images.githubusercontent.com/59535609/132103522-ea9ca059-1908-40b1-8413-e3ad3c707785.jpg)

# 2차 설계
- 작업시간이 적은 순서대로 처리하되, 한 작업이 끝난 경우 가장 빠른 작업을 우선합니다.
1. 작업을 시간순으로 정렬합니다.
2. 시간을 순차적으로 증가시킵니다.
3. 작업 요청 시간이 되면 우선 순위 큐에 작업을 넣고 현재 작업 시간이 끝난 경우 현재 작업을 갱신합니다.
4. 작업을 전부 수행한 경우 종료합니다.

# 2차 코드

```java
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, idx = 0, time = 0;
        int[] cur = {0, 0};
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<int[]> minheap = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });
        while(idx<jobs.length || !minheap.isEmpty()){
            // 현재 시간이 요청 시간이 되면 큐에 삽입
            while(idx<jobs.length && jobs[idx][0]<=time){
                minheap.add(jobs[idx++]);
            }
            // 큐가 비면 가장 요청 시간 빠른 걸 큐에 삽입
            if(minheap.isEmpty() && idx<jobs.length){
                minheap.add(jobs[idx++]);
            }
            // 큐에서 가장 앞에 것 꺼내서 걸린 시간, 현재 시간 갱신
            if(!minheap.isEmpty()){
                cur = minheap.poll();
                if(time+cur[1]>cur[0]){
                    time += cur[1];
                    answer += (time-cur[0]);
                }
                else{
                    time = cur[0]+cur[1];
                    answer += cur[1];
                }
            }
        }
        return answer/jobs.length;
    }
}
```

# 2차 결과
![2차 결과](https://user-images.githubusercontent.com/59535609/132103523-42e13150-e862-460a-93b7-efd03c6a2924.jpg)

# 최종 설계
- 큐가 비어있을 경우 다음작업 시간으로 갱신하는 부분을 참고했습니다.
- 출처 : https://mungto.tistory.com/15

# 최종 코드

```java
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, idx = 0, time = 0;
        int[] cur = {0, 0};
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<int[]> minheap = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });
        while(idx<jobs.length || !minheap.isEmpty()){
            // 현재 시간이 요청 시간이 되면 큐에 삽입
            if(idx<jobs.length && jobs[idx][0]<=time){
                minheap.add(jobs[idx++]);
                continue;
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
```

# 최종 결과
![최종 결과](https://user-images.githubusercontent.com/59535609/132103661-3da17523-cb1d-42a8-831a-b90f6eb8bb3f.jpg)


# 1차 수정 설계
- 람다식을 활용하여 Comparotor를 대체했습니다.
- 출처 : https://codevang.tistory.com/316

# 1차 수정 결과
![1차 수정 결과](https://user-images.githubusercontent.com/59535609/132103884-ad57cbad-f962-44f4-bfbf-47f5ea1ed688.jpg)

# 문제 출처
https://programmers.co.kr/learn/courses/30/lessons/42627