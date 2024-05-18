### 다른 풀이
```JS
var isValid = function(s) {
    let obj={'(':')','{':'}','[':']'}
    let stack=[]
    for(let char of s){
        if(obj[char]) stack.push(char)
        else if(obj[stack.pop()]!==char) return false
    }
    return stack.length==0
};
```

- `s[i]`로 슬라이싱 하지 말고 for ~ of문 사용했으면 코드가 훨씬 간결했을 것 같다
- 객체 key 검사할 때 `obj[key]`의 boolean값으로 바로 확인할 수 있다
 
