### 내 풀이
- 재귀 사용
- 다른 풀이에서는 좌, 우 자식노드 바꿀 때 각각 left, right 변수에 저장해뒀다가 다시 할당했는데, 내가 쓴 방법이 더 가독성이 좋아보임!
- 대신 `root.left, root.right = root.right, root.left` 이렇게만 쓰면 안됨
    - `[root.left, root.right] = [root.right, root.left]` : 배열 형태로 할당해야 한다

### 다른 풀이
```js
 var invertTree = function (root) {
    if (!root) {
        return root;
    }
    [root.left, root.right] = [invertTree(root.right), invertTree(root.left)]
    return root
```

- 이렇게 축약해서도 쓸 수 있다


