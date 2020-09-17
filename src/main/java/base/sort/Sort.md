# 정렬
### 안정 정렬 vs 불안정 정렬
- 안정 정렬 : 동일한 값에 대해서, 기존의 순서가 유지되는 정렬 방식
    - `버블 정렬`, `삽입 정렬`, `합병 정렬`
    
- 불안정 정렬 : 동일한 값에 대해서, 기존의 순서가 뒤바뀔 수 있는 정렬 방식
    - `선택 정렬`, `퀵 정렬`, `힙 정렬`
    - [Reason](https://stackoverflow.com/questions/4601057/why-is-selection-sort-not-stable)

### Example
- Array = { B, b, A, C } 와 같은 배열이 존재할때, (A < B == b < c)
- 안정 정렬은 { A, B, b, C } 로 동일값의 순서가 유지되지만,
- 불안정 정렬은 { A, b, B, C } 로 동일값의 순서가 바뀔 수 있다.
- 안정 정렬인 `버블정렬`을 예로 해보자.

```
Bubble 1회전
B b a c
B b a c
B a b c
1회전 결과 : B a b c



Bubble 2회전
B a b c
a B b c
a B b c
2회전 결과 : a B b c
```

- 이 이상 정렬해도 2회전 결과와 동일, 순서가 유지됨을 확인했다.
- 불안정 정렬인 `선택정렬`을 예로 해보자.

```
Selection 1회전
[0] [1] [2] [3]
 B   b   a   c  (i = 0, j = 0), min = B(0)
 B   b   a   c  (i = 0, j = 1), min = B(0)
 B   b   a   c  (i = 0, j = 2), min = a(2)
 B   b   a   c  (i = 0, j = 3), min = a(2)
swap(0, 2);
1회전 결과 : a b B c
```

- 동일 값의 순서가 바뀜을 확인할 수 있다.
 
### 자바에서의 정렬은 어떤 정렬을 사용할까?
- 내부를 들여다보면 Collections.sort 사용시 Object array를 정렬하는 경우 기본으로 Tim Sort를 사용한다.
    - Tim Sort = merge + insertion   
    - 별도의 프로퍼티 값을 설정하지 않으면 Tim sort, 별도의 프로퍼티 값을 설정하면 merge sort를 실행한다.
- Collection.sort 내부를 보면 Arrays.sort를 사용한다.
    - Arrays.sort는 기본 타입을 정렬하게 되면 Double Pivot Quick Sort를 한다.
    - 무조건 Double Pivot Quick Sort를 하는게 아니라 내부 조건에 따라 Quick 대신 Insertion을 수행한다.
    - 만약 기본 타입이 아닌 Object array를 정렬해야 된다면 Collection.sort 처럼 세팅값이 있으면 legacy merge, 아니면 Tim sort를 사용한다.
