package book.part2.implement.gamedevelopment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 게임 개발
 */
public class GameDevelopment {
    public static void main(String[] args) throws IOException {
        // TODO : 제한시간 40분인데 초과함 다시 풀어볼것
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // map 세팅
        String[] xy = bufferedReader.readLine().split(" ");
        int mapHeight = Integer.valueOf(xy[1]);
        int mapWidth = Integer.valueOf(xy[0]);
        
        String[] currentPosition = bufferedReader.readLine().split(" ");
        int currentX = Integer.parseInt(currentPosition[0]);
        int currentY = Integer.parseInt(currentPosition[1]);
        int currentDirection = Integer.parseInt(currentPosition[2]);
        Character character = new Character(currentX, currentY, currentDirection);

        int[][] map = new int[mapHeight][mapWidth];
        for (int i = 0; i < mapHeight; i++) {
            final String[] geography = bufferedReader.readLine().split(" ");
            for (int j= 0; j < mapWidth; j++) {
                map[i][j] = Integer.parseInt(geography[j]);
            }
        }

        int result = moveCharacter(character, map);

        System.out.println(result);
        bufferedReader.close();
    }

    private static int moveCharacter(final Character character, final int[][] map) {
        while (true) {
            character.turnLeft();
            if (character.isTurnFullCircle()) {
                if (character.canMoveBack(map)) {
                    character.moveBack();
                } else {
                    break;
                }
            }

            if (character.canMoveForward(map)) {
                map[character.getX()][character.getY()] = 1;
                character.moveForward();
            } else {
                continue;
            }
        }
        return character.getMoveCount();
    }
}

