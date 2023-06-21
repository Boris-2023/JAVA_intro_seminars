package CheckBrackets;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Test {
    public static boolean validation(HashMap<String, Integer> open, HashMap<String, Integer> close, String line) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {
            char bufChar = line.charAt(i);
            String symbol = Character.toString(bufChar);
            if (open.containsKey(symbol)) {
                stack.push(symbol);
            } else if (close.containsKey(symbol)) {
                if (!stack.isEmpty()) {
                    Integer val1 = close.get(symbol);
                    String last = stack.pop();
                    Integer val2 = open.get(last);
                    if (val1 != val2)
                        return false;
                } else
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
