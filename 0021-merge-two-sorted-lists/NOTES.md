```js
//ListNode definition
function ListNode(val, next) {
  this.val = (val===undefined ? 0 : val)
  this.next = (next===undefined ? null : next)
}
```
- JS에서 linkedList를 사용해 본 적이 없어 array로 반환했다가 막혔다
- python이랑 똑같이 head, val, next로 구성됨

### 다른 풀이
```js
var mergeTwoLists = function(list1, list2) {
    if(!list1 || !list2) return list1 || list2
    if(list1.val<list2.val){
        return new ListNode(list1.val,mergeTwoLists(list1.next,list2))
    }
    return new ListNode(list2.val,mergeTwoLists(list1,list2.next))
};
```
- 이렇게 재귀로 푸는 방식도 있다
- Time complexity: O(n+m)
