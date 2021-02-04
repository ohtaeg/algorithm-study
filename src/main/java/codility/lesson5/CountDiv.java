package codility.lesson5;

public class CountDiv {
    public static void main(String[] args) {
        CountDiv countDiv = new CountDiv();
        System.out.println(countDiv.solution(0, 1, 11));
    }

    /**
     * 기존 풀이는 반복문 돌리다보니 타임아웃 발생
     * 이번 풀이는 몫을 이용함.
     * 보통 1 ~ N까지 N을 K로 나누어 나오는 몫은 K로 나눌때 맞아 떨어지는 갯수와 같다.
     * 11 / 2 = 5 ===> 1 ~ 11 ===> 2, 4, 6, 8, 10 ===> 5개
     * 몫을 이용해 1 ~ B까지 나눈 몫에 1 ~ (A - 1) 까지 나눈 못을 빼준다.
     * A에 -1을 하는 이유는 A ~ B 사이의 몫을 구할 때 A도 포함되어 몫이 구해지기 때문에 A를 배제하기 위함.
     */
    public int solution(int a, int b, int k) {
        int count = 0;
        if (a % k == 0) {
            count++;
        }
        return (b / k) - (a / k) + count;
    }
}
