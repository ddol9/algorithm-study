### 사용한 방법 : Brute Force
```JS
var twoSum = function (nums, target) {
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[j] === target - nums[i]) {
                return [i, j];
            }
        }
    }
    // In case there is no solution, return null
    return null;
};
```

- Time complexity: O(n^2)

### 다른 방법 1. 2-pass HashTable
```JS
var twoSum = function (nums, target) {
    const map = new Map();
    for (let i = 0; i < nums.length; i++) {
        map.set(nums[i], i);
    }
    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        if (map.has(complement) && map.get(complement) !== i) {
            return [i, map.get(complement)];
        }
    }
    return null;
};
```
    
- Time complexity: O(n)
#### 단계별 설명
1.	맵 초기화
  - const map = new Map();: 빈 Map 객체를 생성합니다. 이 맵은 배열의 각 숫자를 키로, 그 숫자의 인덱스를 값으로 저장할 것입니다.
2.	첫 번째 반복문
  - for (let i = 0; i < nums.length; i++) { map.set(nums[i], i); }
  - 이 반복문은 배열 nums를 순회하면서 각 숫자와 해당 숫자의 인덱스를 맵에 저장합니다. 이렇게 하면 나중에 어떤 숫자가 배열 내에 존재하는지, 그리고 그 위치가 어디인지 빠르게 찾을 수 있습니다.
3.	두 번째 반복문
  -	for (let i = 0; i < nums.length; i++) {...}
  -	이 반복문은 다시 배열 nums를 순회하면서 각 숫자에 대해 다음을 수행합니다:
  -	const complement = target - nums[i];: 타겟 숫자에서 현재 숫자를 빼서, 배열 내에서 찾아야 할 “보완적인” 숫자(complement)를 계산합니다.
  -	if (map.has(complement) && map.get(complement) !== i) {...}: 맵에서 해당 보완적인 숫자가 존재하는지 확인하고, 그 인덱스가 현재 인덱스와 다른지 확인합니다(같은 요소를 두 번 사용하지 않도록 합니다).
  -	return [i, map.get(complement)];: 조건이 만족되면, 현재 인덱스와 보완적인 숫자의 인덱스를 배열로 반환합니다.
4.	반환 값
  - 만약 매치되는 숫자 쌍을 찾지 못하면 함수는 null을 반환합니다.
