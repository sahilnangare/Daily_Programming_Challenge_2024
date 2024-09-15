import java.util.*;
public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        List<String> result = new ArrayList<>();
        for (int len = low.length(); len <= high.length(); len++) {
            result.addAll(findStrobogrammatic(len, len));
        }

        int count = 0;
        for (String num : result) {
            if ((num.length() == low.length() && num.compareTo(low) < 0) ||
                    (num.length() == high.length() && num.compareTo(high) > 0)) {
                continue;
            }
            count++;
        }
        return count;
    }

    private List<String> findStrobogrammatic(int curLen, int maxLen) {
        if (curLen == 0) return new ArrayList<>(Arrays.asList(""));
        if (curLen == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> subList = findStrobogrammatic(curLen - 2, maxLen);
        List<String> result = new ArrayList<>();

        for (String s : subList) {
            if (curLen != maxLen) result.add("0" + s + "0"); // Avoid leading zeroes for full-length numbers
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }

        return result;
    }
}
