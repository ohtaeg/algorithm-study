# Stack
- 자바 스택 사용시 조심해야할 점을 알아보자.
## 1. 스택
### 기본 설명
- Stack은 Vector 클래스를 상속받아, 전형적인 스택 메모리 구조의 클래스를 제공한다.
    - `public class Stack<E> extends Vector<E> {`
    - 스택 메모리 구조는 메모리 공간에 데이터를 선형적으로 저장하면서 Last In First Out (LIFO)의 구조를 따른다.
- Stack 클래스는 스택 메모리 구조를 표현하기 위해, Vector 클래스의 메서드를 5개만 상속받아 사용한다.
    - `boolean empty()` : 해당 스택이 비어 있으면 true를, 비어 있지 않으면 false를 반환함.
    - `E peek()` : 해당 스택의 제일 상단에 있는(제일 마지막으로 저장된) 요소를 반환함.
    - `E pop()` : 해당 스택의 제일 상단에 있는(제일 마지막으로 저장된) 요소를 반환하고, 해당 요소를 스택에서 제거함.
    - `E push(E item)` : 해당 스택의 제일 상단에 전달된 요소를 삽입함.
    - `int search(Object o)` : 해당 스택에서 전달된 객체가 존재하는 **위치의 순서**를 반환함. 이때 시작점은 제일 상단에 있는 요소의 위치부터 0이 아닌 1부터 시작한다.
        - 별로 사용하는걸 많이 보질 못함.

### 무엇을 조심해야 할까?
- Vector는 초창기 자바때부터 존재하던 과거의 유산물인데, 호환을 위해 아직 살아있다.
- Vector를 상속받게 된 Stack은 Vector의 기능을 전부 사용할 수 있게된다.
- 완벽한 LIFO 구조를 가질 수도 없게되고, Vector의 모든 단점을 그대로 물려받게 되는 것
- 상속받은 Vector로 인해 스택을 잘못 사용하는 사례가 존재할 수 있기에 주의가 필요하며 알고 가는것이 좋다고 생각한다.
1. Stack을 List로 다루는 잘못된 예
    ```
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    stack.add(1); // x
    stack.remove(1); // x, index 접근
    ```
   - 위에서 제공되는 메서드외 것을 사용하거나 인덱스를 통해 스택으로 데이터를 관리한다면 스택에 본질에 맞게 사용하지 않고 있는 것.
2. Vector의 단점 - 효율적으로 Thread-safe 하지 않다.
- Vector의 모든 메서드에 synchronized 키워드가 붙어 있다. 예로 add 메소드는 synchronized 키워드를 통해 동기화가 걸려있다.
    ```
    public synchronized boolean add(E e) {
        modCount++;
        add(e, elementData, elementCount);
        return true;
    }
    ```
- 즉, Vector에 접근시 한번에 하나의 스레드만 접근이 가능하고, 쓰레드에 안전하지만 단일 쓰레드 처리에서는 성능이 떨어짐.
- 단순히 Vector에 Iterator를 붙여 순차적으로 item들을 탐색하기만 해도 원소탐색 시마다 get() 메서드의 실행을 위해 계속 lock을 걸고 닫으므로 <br>
Iterator 연산 과정 전체에 1번만 걸어주면 될 locking에 쓸데없는 오버헤드가 엄청나게 발생한다. <br>
따라서 Vector는 특정 상황에서만 최적으로 동작하게 되고, 어떤 상황에서는 그렇지 않게 되므로 효율적인 Thread-safe 컬렉션이라고 할 수 없다.
