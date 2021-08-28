# 1차 설계
1. `truck_weights`에서 순서대로 넣으며 진행합니다.
2. `sum>=weight`
    - while을 통해 반복문으로 큐에 0 삽입, 큐가 다 차있으면 pop 합니다.  
    - 반복문 돌 때마다 answer++  
    - 반복문 종료 이후 answer -= 1
3. 큐에 삽입합니다.
4. `len==bridge_length`
    - while을 통해 큐의 맨 앞이 0이면 계속 빼면서 큐에 0 삽입합니다.
    - 반복문 돌 때마다 answer++

# 1차 코드

```java
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, sum = 0, cnt = 0;
        Queue<Integer> Q = new LinkedList<Integer>();
        for(int i=0; i<truck_weights.length; i++){
            boolean isFirst = true;
            int b = 0;
            while(sum+truck_weights[i]>weight){
                if(Q.size()==bridge_length){
                    if(Q.peek()!=0) cnt--;
                    sum -= Q.poll();
                }
                Q.add(0);
                answer++;
                if(isFirst){
                    answer -= 1;
                    isFirst = false;
                }
                b++;
                if(b>=100) break;
            }
            sum += truck_weights[i];
            cnt++;
            answer++;
            if(Q.size()==bridge_length) sum -= Q.poll();
            Q.add(truck_weights[i]);
            if(cnt==bridge_length){
                while(Q.peek()==0){
                    sum -= Q.poll();
                    Q.add(0);
                    answer++;
                }
                cnt--;
            }
        }
        if(Q.size()<bridge_length){
            answer += (bridge_length-Q.size());
        }
        while(sum>0){
            answer++;
            sum -= Q.poll();
        }
        return answer;
    }
}
```

# 1차 결과
계속 실패하는 경우가 많아 https://medium.com/urechanger/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8B%A4%EB%A6%AC%EB%A5%BC-%EC%A7%80%EB%82%98%EB%8A%94-%ED%8A%B8%EB%9F%AD-2d3cae5ba157 에서 아이디어를 참고하였습니다.  
![1차결과](https://user-images.githubusercontent.com/59535609/131224814-73a43edb-874b-4622-a246-cec280950181.jpg)

# 최종 설계
1. while문을 돌면서 answer++
2. 시작 시 큐에 bridge_length만큼 0을 삽입합니다.
3. 큐 앞에 0이 아니면 cnt++
4. 큐에서 pop하면서 sum에서 pop 합니다.
5. `idx<truck_weights.length && sum+truck_weights[idx]<=weight`
    - sum에 truck_weights[idx]을 더합니다.
    - 큐에 truck_weights[idx]을 삽입합니다.
6. 5가 아닌 경우 큐에 0을 삽입합니다.

# 최종 결과
![최종결과](https://user-images.githubusercontent.com/59535609/131224823-76d63e83-9f74-4c49-920d-1bae01e2bbc6.jpg)
