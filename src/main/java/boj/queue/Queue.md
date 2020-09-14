# Queue 
- 자바 큐 사용시 조심해야할 점을 알아보자.

### 기본 설명
- 선형 자료구조의 일종으로 First In First Out (FIFO)를 기반으로 한다.
- 큐는 다음과 같은 기본 연산이 정의되어 있다.
    - add(E e) : 끝부분에 원소를 추가한다.
    - offer(E e) : 끝부분에 원소를 추가한다.
    - remove() : 맨 첫 부분의 원소를 삭제한다.
    - poll() : 맨 첫 부분의 원소를 삭제한다.
    - peek() : 큐의 맨 앞부분의 원소를 반환한다.
    - element() : 큐의 맨 앞부분의 원소를 반환한다.
- 기본적으로 LinkedList를 구현체를 사용한다.

### 무엇을 조심해야 할까?
1. 메서드의 차이
- add와 offer, remove와 poll은 같은 작업을 실행한다. 어느것을 써야할까?
    - 차이를 알고 사용하면 좋다.
    - [Queue 공식 문서](https://docs.oracle.com/javase/8/docs/api/)
- 용량 제한이 있는 큐를 구현하여 사용시 데이터를 추가, 삭제, 검색할때 제공되는 메서드들의 차이는 예외를 던지는지 아니면 (null 또는 false) 값을 반환하는지의 차이가 있다. <br>

    |-|Throws exception|Returns special value|
    |-----------|-----------|-----------|
    |Insert|add()|offer()|
    |Remove|remove()|poll()|
    |Examine|element()|peek()|
- 용량 제한이 없으면 같은 동작을 한다. 
2. LinkedList를 사용하는 이유 (ArrayList는 왜 안될까?)
    - 효율적인 삽입, 삭제를 위해
    - http://www.nextree.co.kr/p6506/
