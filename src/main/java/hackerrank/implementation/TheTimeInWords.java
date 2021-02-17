package hackerrank.implementation;

import java.util.Arrays;

public class TheTimeInWords {
    private static String[] MINUTE_TEXTS = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty one",
            "twenty two", "twenty three", "twenty four",
            "twenty five", "twenty six", "twenty seven",
            "twenty eight", "twenty nine",
    };

    static String timeInWords(int h, int m) {
        String result;
        if (m == 0) {
            result = TimeMapper.find(h) + " o' clock";
            return result;
        }

        if (m > 30) {
            h++;
        }

        return minute(m) + TimeMapper.find(h);
    }

    private static String minute(final int m) {
        String minute = "";
        if (m == 30) {
            return "half past ";
        }

        if (m % 15 == 0) {
            minute = "quarter ";
            if (m > 30) {
                return minute + "to ";
            } else {
                return minute + "past ";
            }
        }


        if (m > 30) {
            int index = 60 - m;
            minute = MINUTE_TEXTS[index]
                    + (index == 1 ? " minute" : " minutes")
                    + " to ";
        } else {
            minute = MINUTE_TEXTS[m]
                    + (m == 1 ? " minute" : " minutes")
                    + " past ";
        }

        return minute;
    }

    private enum TimeMapper {
        ONE(1, "one"),
        TWO(2, "two"),
        THREE(3, "three"),
        FOUR(4, "four"),
        FIVE(5, "five"),
        SIX(6, "six"),
        SEVEN(7, "seven"),
        EIGHT(8, "eight"),
        NINE(9, "nine"),
        TEN(10, "ten"),
        ELEVEN(11, "eleven"),
        TWELVE(12, "twelve");

        private final int time;
        private final String timeText;

        TimeMapper(final int time, final String timeText) {
            this.time = time;
            this.timeText = timeText;
        }

        public static String find(int value) {
            return Arrays.stream(TimeMapper.values())
                         .filter(timeMapper -> timeMapper.time == value)
                         .map(timeMapper -> timeMapper.timeText)
                         .findFirst()
                         .orElseThrow(RuntimeException::new);
        }
    }
}
