# 이진 탐색
- 범위를 반씩 좁혀가는 탐색
- 이진 탐색의 전제조건은 내부의 데이터가 **정렬되어 있어야만** 사용할 수 있는 알고리즘
    - 데이터가 무작위일때는 사용 불가

## 이진 탐색 동작
- 위치를 나타낼 3개의 변수를 사용한다. (시작점, 중간점, 끝점)
- 찾으려는 데이터와 중간점 위치에 있는 데이터를 비교한다.
    - 중간 보다 작으면 시작점과 중간보다 작은 범위를 탐색한다.
    - 중간 보다 크면 중간 + 1과 끝점을 탐색한다.
- 찾을때까지 반복해서 탐색한다.

## 이진 탐색 시간복잡도
- 한번 확인할때마다 원소의 갯수가 절반씩 줄어들어 시간복잡도 O(logN)

## 이진 탐색 문제 유형
- 이진 탐색 문제는 입력 데이터가 많거나 탐색 범위가 매우 넓은 편
- 탐색 범위가 1000만이거나 찾으려는수가 1000만이 넘어가면 이진 탐색으로 접근해보자.
- 입력받아야하는 데이터가 많을 경우 I/O 라이브러리 선택도 고민하자.
