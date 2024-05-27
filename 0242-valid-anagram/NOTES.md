### 오답노트
- s와 t의 길이가 다를 때, s의 문자열이 t에 모두 포함되면 true로 잘못 판단되는 경우
  -> 길이 비교로 false 리턴
- 객채의 비교는 직접 비교가 아닌 각 키 값이 같은지 비교


### 다른 풀이
```js
function isAnagram(str1, str2) {
  // Removes spaces and convert into the lowercase letter

  str1 = str1.replace(/\s/g, '').toLowerCase()
  str2 = str2.replace(/\s/g, '').toLowerCase()
  // console.log(str1, str2)

  if (str1.length !== str2.length) {
    return false
  }

  // Sort the characters in the given string
  str1 = str1.split('').sort().join('')
  str2 = str2.split('').sort().join('')

  // Compare the sorted String

  return str1 === str2
}
```
- `sort().join('')` 이런 간단한 방법이 있었다니​
