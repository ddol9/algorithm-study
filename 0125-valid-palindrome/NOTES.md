- `str.replace(제거 할 문자, 대체 할 문자);` 를 사용해서 특수문자 제거
- 대소문자 통일
- **js에서는 `string[-1]`로 인덱싱 불가능**


### 다른 풀이
```js
var isPalindrome = function(s) {
    const alphanumerics = s.toLowerCase().replace(/[^a-z0-9]/g, "");
    return alphanumerics === alphanumerics.split("").reverse().join("");
};
```
- 조금 더 축약해서 쓸 수있다
