package boj.bruteforce;

import java.util.Scanner;

/*
n answer
3 3
YCC
CCY
YPP

5 4
YCPZY
CYZZP
CCPPP
YCYZC
CPPZZ

3 2
ZCY
ZCP
PYZ

4 4
CYYY
ACAA
CKKK
CQQQ

40 37
YYYYYYYYYCYYYYYYYYYYYYYYYCZZZZZZZYYYYYZC
PYPCYZCPYCZZCCPZYYPZYYYYPPZZPYCCCZYZZZPY
ZPPCYCCPYYZYPPZCZPYCCCZZYYPZZPYPPPPZPCZC
ZCYYZZYCPPPCCYPYYPZZZZCCCCZZCZCYCYZCZZYC
PYZYZZCCZZCCPPYCZPYPPZYZYYYZZPPCCZYYYZCZ
PPPCZZPCCCCCCCCCCCCCCCCCCYCZYYYZCYYCPCPZ
PZYPZYPPYYYZZZPPPZPYZPYZCZZPYZCZZPPCYCCZ
YPPYYYYCCPYPZPCPPPCZCZZYZZZZYYZPZZCCCZYY
YPZCZCPZYYZCCPPPYPPCCPCYZYYYCPPPYCYYCPYC
ZPYZCCZCYZYYCPCCPPYYZPYCCPPCPZCCZCCZYYPY
CPPPCPZZZCYCPYCZYZZPYPZCYYCCZCZZPZYCPZCZ
YZYCYPCPPYPPPPYYYPYPCPCPZZPPCYZCZPZZZZYP
ZCZPYZPPYYYPYPCZYZZYZZPZCZPPPZYCZYPCPYYC
YPZPZYCCYPZZCCPYYCYZYYYYYCZYZZYZZPPYCZCZ
YCZPZCCCCCYCCCCCCCCCCCZYPYZPCZPZZPZZYPYY
YYYYYYYYYYPYYYYYYYYYYYYYYYYYYYYYYYYYYZZP
ZYZCZZCCZPZCZYCPYPCCPYZYCCPPZZCZYCZCYPYP
YYZYPZZYCPCYCZPZYCZPZCCZYCCCZZZYYYZYYPCP
YZZPZYPYCZCPPCZPYCCPYCYZPCCYYZYPCPPPYYPZ
YYZPPZYCZZZYYPYCYZCCYYZPYCCYPZCCZCCCYYZC
CYZZPPCZYZYCCPCYYCPZPPZZPCZZYZZYZZCZYYPC
PPZYZYZPZZZZYPZYYPZPPZPPZCYCPZYZPPYYYYYZ
CZZZYPZYCCYYYPPZYCYPZPCCPCYYYZZYCPYCYCYY
YCZZCZCCYPPYYZYYYPPPZZYYCCCYYZZZYZZZYYCC
YCZPZPPPZPCYYYZZYCPPZYPZYCZZZZZPYYPYCYPC
PCZZZYYZCPCPCZYYYCPYZCCPZCZPYZZPYPZPYZYY
ZZZZPPPPPYZCZCPYYCCCCCCCCCCCYCCCCCCPCCCP
CPYCYZCZCZCYCPCYYCYZCZYYZCCPZZYZPZCPYCCP
YZZYYZZZZPZZCZCYYCZZPYZYCCPCPZYCYCZPYZPZ
YZZZZZZZZZZZZZZZZZZZZZZZCZZZZZZZZZZZZZZZ
YZZPPPPPPPPPPPPPPCPPPPPYYCYCZZZCCPCCYPYZ
YYZCPYPPYZPPYCZPYCZPCPCZZZCYCZYZCPCPZPZZ
CYZPCYYYYYYYYYYYYCYYYYYYYYYYYZYYCYZYPYZC
CPZCCZZZZZZZZZZZZCZZZZZZZZZZYZCCZCPZZCCY
YYZPCPZZCYYYYYCPYCZPYYYPPZZCCZZCPPPPCCPP
YYZZPCCYZCCCYPCYYPZCZZZZZPPYZCCCCCZCPPCY
PYYYYYYYYYYYYYYYYYYYYYYPYCZZPPYZYPPPPYCC
YPZCZPZYPZPPCYCZYCYPCCCZCZZCCZYZYYCYYZCZ
CPPZZPCYYCCCYCCPZPYYZYCYZYZYPYCPPZPCPCYC
ZPCYPYZPPCYYPYZZZPPZZZCCPYCYPCYYCYPPYCZY

5 3
CPZCC
ZYCPZ
CYYPZ
ZPZCC
CCPYY
 */

/**
 * 사탕 게임
 * x축 y축 가지고 노는게 어려운 문제
 */
public class Q3085 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] candies = new String[n][n];

        for (int i = 0; i < n; i++) {
            candies[i] = scanner.nextLine().split("");
        }

        int eatingCandyCount = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n - 1; x++) {
                swapX(candies, y, x);
                eatingCandyCount = Integer.max(eatingCandyCount, eatCandy(candies, y, x, n));
                swapX(candies, y, x);

                swapY(candies, x, y);
                eatingCandyCount = Integer.max(eatingCandyCount, eatCandy(candies, x, y, n));
                swapY(candies, x, y);
            }
        }
        System.out.println(eatingCandyCount);
    }

    private static int eatCandy(final String[][] candies, final int y, final int x, final int n) {
        int eatingCandyCount = 0;

        // 가로
        for (int i = y; i <= y + 1 && i < n; i++) {
            int eatingCountY = 1;
            for (int j = 0; j < n - 1; j++) {
                if (candies[i][j].equals(candies[i][j + 1])) {
                    eatingCountY++;
                } else {
                    eatingCandyCount = Integer.max(eatingCandyCount, eatingCountY);
                    eatingCountY = 1;
                }
            }
            eatingCandyCount = Integer.max(eatingCandyCount, eatingCountY);
        }
        
        // 세로
        for (int i = x; i <= x + 1 && i < n; i++) {
            int eatingCountX = 1;
            for (int j = 0; j < n - 1; j++) {
                if (candies[j][i].equals(candies[j + 1][i])) {
                    eatingCountX++;
                } else {
                    eatingCandyCount = Integer.max(eatingCandyCount, eatingCountX);
                    eatingCountX = 1;
                }
            }
            eatingCandyCount = Integer.max(eatingCandyCount, eatingCountX);
        }

        return eatingCandyCount;
    }

    private static void swapX(final String[][] candies, final int y, final int x) {
        String temp = candies[y][x];
        candies[y][x] = candies[y][x + 1];
        candies[y][x + 1] = temp;
    }

    private static void swapY(final String[][] candies, final int y, final int x) {
        String temp = candies[y][x];
        candies[y][x] = candies[y + 1][x];
        candies[y + 1][x] = temp;
    }
}
