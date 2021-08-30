# 1차 설계
1. `citations`를 정렬합니다.
2. h-index를 최대 값에서 하나씩 줄여가며 확인합니다.
3. `citations`를 큰 것부터 확인합니다.

# 1차 코드

```java
import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int len = citations.length;
        
        for(int h = len; h > 0; h--){
            for(int i = len-1; i >= 0; i--){
                if(citations[i]<h && h == len-i-1){
                    answer = len-i-1;
                    break;
                }
            }
        }
        
        return answer;
    }
}
```

# 1차 결과
![1차 결과](https://user-images.githubusercontent.com/59535609/131377991-7b277406-c654-4436-b815-da81566509a0.jpg)

# 2차 설계
1. `citations`를 정렬합니다.
2. `citations`를 큰 것부터 확인합니다.

# 2차 코드

```java
import java.util.Arrays;

class Solution {
    public int solution(int[] citations){
        Arrays.sort(citations);
        for(int i=citations.length-1; i>=0; i--){
            if(citations[i]<=(citations.length-i) && citations[i]>=i) return citations[i];
        }
        return 0;
    }
}
```

# 2차 결과
![2차 결과](https://user-images.githubusercontent.com/59535609/131378005-20d590f5-bc6a-4387-a1dd-47b30ec532d0.jpg)

# 3차 설계
2차 설계와 동일하나 정렬시 내림차순으로 정렬합니다.

# 3차 코드

```java
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        int answer = -1;
        Integer[] h = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(h, Collections.reverseOrder());
        for(int i=0; i<h.length; i++){
            if(h[i]<i) continue;
            if(answer<i) answer = i;
        }
        return h[answer];
    }
}
```

# 3차 결과
![3차 결과](https://user-images.githubusercontent.com/59535609/131378006-ac0d0644-1c8e-4696-9329-543609b3741f.jpg)

# 최종 설계
1. `citations`를 정렬합니다.
2. `citations`를 큰 것부터 확인합니다.
    - 총 h편이 h번 이상 인용되었는지만 확인하면 됩니다.
    - h의 최대값 : 논문 개수`citations.length`
    - i번째 인용횟수 이상 인용된 논문 수(h_index)`citations.length - i`
    - `citations[i]>=h_index`일 경우 h_index를 반환합니다.
- 참고사이트 : https://en.wikipedia.org/wiki/H-index
    - h-index = max{i in {N} : f(i)>= i}

# 최종 결과
![최종 결과](https://user-images.githubusercontent.com/59535609/131378011-6312e02d-ed94-477e-8344-ce5579cfa769.jpg)

# 문제 출처
https://programmers.co.kr/learn/courses/30/lessons/42747