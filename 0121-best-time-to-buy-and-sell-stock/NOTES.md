​### 처음 풀이
```js
var maxProfit = function(prices) {
    let maxVal = 0;
    for (i=0; i<prices.length; i++) {
        for (j=i+1; j<prices.length; j++) {
            if (maxVal<prices[j]-prices[i]) {
                maxVal = prices[j]-prices[i]
            }
        }
    }
    return maxVal
};
```
- 처음에 아무 생각 없이 brute force로 풀었다가 런타임 에러로 실패
