​- 처음에 재귀를 사용했는데, `mid`값을 찾는 과정에서 Runtime error가 났다
- 반복문으로 바꿔 푸니 풀리긴 했지만 discuss를 보니 `Math.floor`가 높은 듯? 찾아봐야지

```js
let mid = Math.floor((lo + hi) / 2) // worst, very easy to overflow

let mid = lo + Math.floor((hi - lo) / 2) // much better, but still possible

let mid = (lo + hi) >>> 1 // the best, but hard to understand
```
