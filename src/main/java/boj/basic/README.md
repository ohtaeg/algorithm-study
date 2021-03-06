# 수학1 정리
## 최대공약수, 최대 공배수
- 약수란 ?
    - 어떤 수를 나누어 떨어지게 하는 수
    - 어떤 수를 나머지 없이 나눌 수 있는 자연
- 배수란 ?
    - 어떤 정수와 다른 정수를 곱했을때 나오는 수
    - ex) 3의 배수는 3 6 9 12
- 공약수란 ?
    - 두 개 이상의 자연수의 공통된 약수
- 공배수란 ?
    - 두 개 이상의 자연수의 공통인 배수
- 최대공약수란 ?
    - 공약수 중에서 가장 큰 수
    - 나눈 값들을 곱하면 공약수를 구할 수 있다.
- 최소공배수란 ? : 
    - 공배수 중에서 가장 작은 수
    - 공배수는 최소공배수의 배수라는 성질을 이용하여 두 자연수를 곱하고 최대 공약수를 나눠주면 된다.
        - 두 자연수의 곱 / 최대공약수

### 유클리드 호제법
- 2개의 자연수를 받아 최대공약수를 받기 위해 2부터 두 자연수 중 작은 자연수까지 모두 나누어보면서 가장 큰 공약수를 구할 수 있다.
- 위와 같은 방법으로 문제를 풀면 시간복잡도는 O(N)이 된다. 나쁜 방법은 아니지만 효율을 높이기 위해 `유클리드 호제법`이란 알고리즘을 사용하면 시간복잡도를 O(logN)으로 줄일 수 있다.
- `유클리드 호제법`
    - 2개의 자연수 A, B에 대해서 A를 B로 나눈 나머지를 R이라 하면
    - A와 B의 최대공약수는 B와 R의 최대공약수와 같다.
    - 이 성질에 따라, B를 R로 나눈 나머지 R-0를 구하고, 다시 R을 R-0로 나눈 나머지를 구하는 과정을 반복하여
    - 나머지가 0이 되었을 때 A가 A와 B의 최대공약수이다.
    - GCD(A, B) = GCD(B, A % B) <br>
      IF (A % B) == 0 THEN GCD == B <br>
      ELSE GCD(B, A % B)
     
|SEQ|GCD(A, B)|A|B|A % B|
|-----------|-----------|-----------|-----------|-----------|
|1|GCD(72, 30) |72|30|12|
|2|GCD(30, 12) |30|12|6|
|3|GCD(12, 6)  |12|6|0|
|4|GCD(6, 0)   |**6**|0||
- 6이 최대 공약수가 된다
- 참고 블로그 : https://myjamong.tistory.com/138

<br>
<br>
<br>

## 소수
- 약수가 1과 자기자신밖에 없는 수
- 소수 구하는 알고리즘은 두가지가 있다.
1. 어떤수 N이 소수인지 아닌지 판별하는 방법
    - N이 소수가 되려면 2보다 크거나 같고 N - 1보다 작거나 같은 수로 나뉘어지면 안된다. <br>
    N = a * b (a < b) 일 때 a의 최소값은 2고 b의 최대값은 N / 2가 된다. (N = 2 * N / 2) <br>
    그래서 N / 2 ~ N - 1 사이에는 약수가 절대 존재할 수 없다. 2 ~ N / 2 까지 약수가 있는지만 검사하면 된다. O(N)
    - 위의 방법을 응용해서 a < sqrt(N), b > sqrt(N) 가 성립한다. <br>
    즉 숫자 80이 있을때, 해당 숫자의 절반까지만 확인한다. 절반이상의 숫자들은 확인할 필요가 없다는 것. <br>
    80이란 숫자에서 자기 자신을 제외하고 절반을 초과하는 수중에서 나누면 0이 나올 수 없다. <br>
    왜냐하면 a,b 둘다 sqrt(N)보다 작으면 a * b < N 이 되기 떄문에 성립이 안되고 <br>
    a,b 둘다 sqrt(N)보다 크다고 해도 a * b > N이 되기 때문에 성립이 안된다. <br>
    a < sqrt(N), b > sqrt(N) 둘중에 한곳만 약수가 있는지 검사하면 된다. <br>
    왜냐하면 한쌍을 이루기 때문 - 24의 약수는 1, 2, 3, 4, 6, 8, 12, 24 // (1,24), (2,12).... <br>
    a b 둘중 한곳을 N의 절반까지 검사해도 무방하지만 숫자가 작은 a에서 검사하는게 베스트. <br>
    근사값 때문에 루트로 직접 계산보단 양변 제곱을 취해 정수로 계산하자. O(sqrt(n)) <br>
    80 - 1, 2, 4, 5, 8, 10, 16, 20, 40, 80 <br>
    80을 루트씌운다면 대략 8.xx 근사값이 나오는데, 약수들의 곱을 봤을때 루트를 씌워 나온값이 중간값이 된다. <br>
    그러므로 2 ~ 루트80까지만 검색을 한다면 그 이후는 확인할 필요가 없다.
2. 에라토스테네스의 체 (N이하 모든 소수 구하기)
    - https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4
    - 기존 소수구하던 O(sqrt(N)) 방법을 이용하면 N번 만큼 O(sqrt(N))를 반복하기때문에 시간복잡도는 O(N * sqrt(N))이 걸려 느리다.
    - 느리다의 기준은 N이 백만일경우 루트 N은 1000, N이 1억일경우 루트 N은 1만이다. 느리다고 볼 수 있다.
    - 더 빠른 방법은 에라토스테네스의 체를 이용하는 것이다.
    - 모든 배수를 다지우는 방법이다.
    - 지워지지 않은 수 중에서 가장 작은수는 2이다.
    - 2는 소수이고 2의 배수를 모두 지우고 그 다음 남은 수의 배수들을 지운다.
    - 2,3 같은 약수들은 다음 큰수들이 지울수 없기때문에 소수가 된다.
