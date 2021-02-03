package codility.lesson3;

public class PermMissingElem {
    /**
     * 주어진 숫자 내에 없는 숫자를 찾는 것이기 때문에
     * 합을 구해놓고 남은 숫자들을 빼면 없는 숫자를 찾을 수 있다.
     * 1 ~ 4의 합은 10이고 3이 없다고 가정할때
     * 10에서 10 - 1 = 9
     * 9 - 2 = 7
     * 7 - 4 = 3 과 같은 방식으로 찾음
     */
    public int solution(int[] A) {
        long bigNumber = A.length + 1;
        long sum = bigNumber * (bigNumber + 1) / 2;

        for (int number : A) {
            sum -= number;
        }

        return (int) sum;
    }
}
