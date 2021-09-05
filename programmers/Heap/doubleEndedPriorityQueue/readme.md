# 최종 설계
- 이중우선순위큐를 구현해야 하므로 `TreeMap`의 메서드를 사용합니다.
    - 기본적으로 정렬
    - 시작과 끝에 접근 가능한 메서드 존재

# 최종 코드

```java
import java.util.TreeMap;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> dpq = new TreeMap<Integer, Integer>();
        for(int i=0; i<operations.length; i++){
            if(operations[i].charAt(0)=='I') dpq.put(Integer.parseInt(operations[i].split(" ")[1]), 0);
            else if(operations[i].charAt(2)=='1') dpq.pollLastEntry();
            else dpq.pollFirstEntry();
        }
        if(dpq.isEmpty()) return new int[] {0, 0};
        return new int[] {dpq.lastKey(), dpq.firstKey()};
    }
}
```

# 최종 결과
![최종 결과](https://user-images.githubusercontent.com/59535609/132139085-e4e67b7c-a87c-4cc4-a0c8-162ec4b11180.jpg)

# 1차 수정 설계
- `TreeMap`을 사용할 경우 중복을 받아들일 수 없습니다.
- `PriorityQueue`를 두 개 사용해 minpq, maxpq로 이중우선순위큐를 구현합니다.

# 1차 수정 결과
![1차 수정 결과](https://user-images.githubusercontent.com/59535609/132139966-2139e5a6-321d-47c0-841e-d3d5003768d8.jpg)

# 문제 출처
https://programmers.co.kr/learn/courses/30/lessons/42628