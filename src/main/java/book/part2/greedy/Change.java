package book.part2.greedy;

/**
 * 거스름돈 문제
 * 당신은 음식점의 계산을 도와주는 점원이다. 카운터에는 거스름돈을 사용할 500원, 100원, 50원, 10원짜리 동전이 존재한다.
 * 손님에게 거슬러 줘야 할 돈이 N원일때 거슬러줘야할 동전의 최소 갯수를 구하라.
 * 1260원을 거슬려 줘야 한다면, 500원 2개, 100원 2개, 50원 1개, 10원 1개 총 6개이다.
 */
public class Change {
    private static final int[] coins = {500, 100, 50, 10};
    public static void main(String[] args) {
        System.out.println(change(1260));
    }

    private static int change(int money) {
        int changeCount = 0;
        for (int coin : coins) {
            changeCount += money / coin;
            money %= coin;
        }
        return changeCount;
    }
}
