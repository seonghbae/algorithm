# 1차 설계
자바의 `PriorityQueue`가 기본적으로 Min Heap인 것을 이용하여 가장 작은 것이 K이상이 될 때까지 섞는 것을 반복합니다.

# 1차 코드
    
```java
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i=0; i<scoville.length; i++) heap.add(scoville[i]);
        while(heap.peek()<K){
            heap.add(heap.poll()+heap.poll()*2);
            answer++;
        }
        return answer;
    }
}
```

# 1차 결과
![1차 결과](https://user-images.githubusercontent.com/59535609/131809339-c3f9ab24-96e5-4f5c-bdb6-c119d772363d.jpg)

# 최종 설계
예외 처리를 빼먹어 힙 내부에 한 개만 남았는데 K 미만인 경우 -1을 반환하도록 합니다.

# 최종 결과
![최종 결과](https://user-images.githubusercontent.com/59535609/131809343-083aedba-2001-4483-b6ee-ad22e2ebd36e.jpg)

# 문제 출처
https://programmers.co.kr/learn/courses/30/lessons/42626