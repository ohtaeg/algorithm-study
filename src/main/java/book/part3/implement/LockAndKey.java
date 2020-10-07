package book.part3.implement;

/**
 * 자물쇠와 열쇠
 *
 * 해당 문제의 제한사항이 크지 않기 때문에최대 20 * 20개의 key, lock 배열을 각자 최대로 반복한다해도
 * 4000 * 4000 = 16_000_000 천 육백만 연산 횟수가 될 것 같아 브루트 포스로 접근함.
 *
 * 알고리즘
 * 1. key와 lock을 맞추기 위해선 주어진 rock 배열을 확장 (padding)
 *  - 왜냐하면 회전하고 위아래로 움직여야 되는 경우가 많기 때문에 배열을 확장해서 맨 상단 좌측 모서리 lock 부터 비교해나기 위함
 * 2. key 배열을 회전
 * 3. 회전한 key 배열을 확장한 lock 배열의 좌측 상단부터 순서대로 이동시키면서 겹치는 부분만 확인.
 *  3.1 열쇠로 자물쇠가 풀리는 조건은 자물쇠와 열쇠를 합쳤는데 각 인덱스의 합들이 1인 경우만 아다리 맞는 경우로 판단.
 *
 * 이 문제의 포인트는 배열의 90도 회전을 어떻게 할지이며
 * 열쇠와 자물쇠를 합쳐보기 위해서 어떻게 해야할지, 그리고 열쇠로 자물쇠를 풀었다는 조건이 무엇인지 판단하는것.
 */
public class LockAndKey {
    public static void main(String[] args) {
        LockAndKey lockAndKey = new LockAndKey();
        int[][] key = {
                {0, 0, 0}
                , {1, 0, 0}
                , {0, 1, 1}
        };

        int[][] lock = {
                {1, 1, 1}
                , {1, 1, 0}
                , {1, 0, 1}
        };

        int[][] key2 = {
                {1, 1, 0}
                , {0, 0, 1}
                , {0, 0, 0}
        };

        int[][] lock2 = {
                {1, 1, 1, 1}
                , {1, 0, 0, 1}
                , {1, 1, 1, 0}
                , {1, 1, 1, 1}
        };

        System.out.println(lockAndKey.solution(key, lock));
        System.out.println(lockAndKey.solution(key2, lock2));
    }

    public boolean solution(int[][] key, int[][] lock) {
        // key에 비례해서 lock 확장
        final int[][] paddingLock = paddingLock(lock, key.length);
        // search의 최대 인덱스값
        final int max = paddingLock.length - key.length + 1;

        // 90도씩 네번 360도 회전
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotate(key);
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < max; j++) {
                    if (canOpenLock(paddingLock, key, i, j, lock.length)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int[][] rotate(final int[][] key) {
        int row = key.length;
        int columns = key[0].length;
        int[][] rotate = new int[row][columns];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                rotate[i][j] = key[row - j - 1][i];
            }
        }

        return rotate;
    }

    private int[][] paddingLock(final int[][] lock, final int keyLength) {
        int length = lock.length + 2 * (keyLength - 1);
        int[][] paddingLock = new int[length][length];

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[i].length; j++) {
                paddingLock[i + keyLength - 1][j + keyLength - 1] = lock[i][j];
            }
        }

        return paddingLock;
    }

    private boolean canOpenLock(final int[][] paddingLock, final int[][] key, final int startRow, final int startColumns, final int lockLength) {
        final int keyLength = key.length;
        for (int i = 0; i < keyLength; i++) {
            for (int j = 0; j < keyLength; j++) {
                paddingLock[i + startRow][j + startColumns] += key[i][j];
            }
        }

        if (isAllOne(paddingLock, keyLength, lockLength)) {
            return true;
        }

        for (int i = 0; i < keyLength; i++) {
            for (int j = 0; j < keyLength; j++) {
                paddingLock[i + startRow][j + startColumns] -= key[i][j];
            }
        }

        return false;
    }

    private boolean isAllOne(final int[][] paddingLock, final int keyLength, final int lockLength) {
        for (int i = 0; i < lockLength; i++) {
            for (int j = 0; j < lockLength; j++) {
                if (paddingLock[i + keyLength - 1][j + keyLength - 1] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
