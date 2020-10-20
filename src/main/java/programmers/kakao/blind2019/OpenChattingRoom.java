package programmers.kakao.blind2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 오픈 채팅방
 */
public class OpenChattingRoom {
    static Map<String, String> commands = new HashMap<>();

    static {
        commands.put("Enter", "님이 들어왔습니다.");
        commands.put("Leave", "님이 나갔습니다.");
    }

    public static void main(String[] args) {
        OpenChattingRoom openChattingRoom = new OpenChattingRoom();
        String[] record = {
                "Enter uid1234 Muzi"
                , "Enter uid4567 Prodo"
                , "Leave uid1234"
                , "Enter uid1234 Prodo"
                , "Change uid4567 Ryan"
        };
        openChattingRoom.solution(record);
    }

    public String[] solution(String[] records) {
        Map<String, String> nickNames = new HashMap<>();
        List<String> ids = new ArrayList<>();
        List<String> messages = new ArrayList<>();

        for (String record : records) {
            final String[] words = record.split(" ");
            final String command = words[0];
            final String id = words[1];

            if ("Enter".equals(command) || "Change".equals(command)) {
                nickNames.put(id, words[2]);
            }

            if (commands.containsKey(command)) {
                ids.add(id);
                messages.add(commands.get(command));
            }
        }

        String[] answer = new String[ids.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = nickNames.get(ids.get(i)) + messages.get(i);
        }
        return answer;
    }
}

