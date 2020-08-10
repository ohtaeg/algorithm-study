package boj.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Prime
 * 약수가 1과 자기자신밖에 없는 수
 * 소수 구하는 알고리즘은 두가지가 있다.
 * 1. 어떤수 N이 소수인지 아닌지 판별하는 방법. 이걸 알아본다.
 * N이 소수가 되려면 2보다 크거나 같고 N-1보다 작거나 같은 수로 나뉘어지면 안된다.
 * 방법 1. N = a * b (a<b) 일 때 a의 최소값은 2고 b의 최대값은 N/2가 된다. (N = 2 * N/2)
 * 그래서 N/2 ~ N-1 사이에는 약수가 절대 존재할 수 없다. 2 ~ N/2 까지 약수가 있는지만 검사하면 된다. O(N)
 *
 * 방법 2. 방법1을 응용해서 a < sqrt(N), b > sqrt(N) 가 성립한다.
 * 즉 숫자 80이 있을때, 해당 숫자의 절반까지만 확인한다. 절반이상의 숫자들은 확인할 필요가 없다는 것.
 * 80이란 숫자에서 자기 자신을 제외하고 절반을 초과하는 수중에서 나누면 0이 나올 수 없다.
 * 왜냐하면 a,b 둘다 sqrt(N)보다 작으면 a*b "<" N 이 되기 떄문에 성립이 안되고
 * a,b 둘다 sqrt(N)보다 크다고 해도 a*b ">" N이 되기 때문에 성립이 안된다.
 * a < sqrt(N), b > sqrt(N) 둘중에 한곳만 약수가 있는지 검사하면 된다.
 * 왜냐하면 한쌍을 이루기 때문 - 24의 약수는 1, 2, 3, 4, 6, 8, 12, 24 // (1,24), (2,12)....
 * a b 둘중 한곳을 N의 절반까지 검사해도 무방하지만 숫자가 작은 a에서 검사하는게 베스트.
 * 근사값 때문에 루트로 직접 계산보단 양변 제곱을 취해 정수로 계산하자. O(sqrt(n))
 * 80 - 1, 2, 4, 5, 8, 10, 16, 20, 40, 80
 * 80을 루트씌운다면 대략 8.xx 근사값이 나오는데, 약수들의 곱을 봤을때 루트를 씌워 나온값이 중간값이 된다.
 * 그러므로 2 ~ 루트80까지만 검색을 한다면 그 이후는 확인할 필요가 없다.
 */
public class Q1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        br.close();

        int primeCount = 0;
        while (stringTokenizer.hasMoreTokens()) {
            if (isPrime(Integer.parseInt(stringTokenizer.nextToken()))) {
                primeCount++;
            }
        }
        System.out.println(primeCount);
    }

    private static boolean isPrime(final int number) {
        if (number < 2) {
            return false;
        } else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i ==0) {
                    return false;
                }
            }
            return true;
        }
    }
}
