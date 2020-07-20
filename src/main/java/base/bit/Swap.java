package base.bit;

/**
 * XOR 비트 연산을 이용하여 SWAP 함수를 구현
 * 보통 Temp 변수를 사용하지만, XOR 비트연산을 이용하면 임시변수가 필요 없다.
 * A라는 변수에 3이라는 값이 존재할때, 동일한 임의의값을 두번 XOR하게되면, 본래 A가 갖고있던 3을 가지게 되는 원리를 이용.
 * 총 3번의 XOR연산을 수행한다.
 * XOR // 비트가 서로 같으면 0, 서로 다르면 1
 */
public class Swap {
    public static void main(String[] args) {
        int a = 3;
        int b = 7;

        a = a ^ b; // a = 011 ^ 111 = 100 = 4

        b = a ^ b; // b = 100 ^ 111 = 011 = 3

        a = a ^ b; // a = 100 ^ 011 = 111 = 7

        System.out.println(a);
        System.out.println(b);
    }
}
