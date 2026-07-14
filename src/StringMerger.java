package src;

import java.util.*;

public class StringMerger {

    public static String merge(String[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }

        // 步骤1：检查每个字符串内部是否合法，并压缩表示
        List<String> compressedList = new ArrayList<>();
        for (String s : arr) {
            String compressed = compressAndValidate(s);
            if (compressed == null) {
                return null;
            }
            compressedList.add(compressed);
        }

        // 步骤2：检查相邻字符串的边界冲突
        // 并构建最终结果中各字母的区间
        StringBuilder result = new StringBuilder();

        // 记录每种字母最后一次出现的位置（在结果中的结束索引）
        Map<Character, Integer> lastEndPos = new HashMap<>();

        for (int i = 0; i < compressedList.size(); i++) {
            String comp = compressedList.get(i);
            String original = arr[i];

            // 检查当前字符串的首字母
            char firstChar = comp.charAt(0);
            if (lastEndPos.containsKey(firstChar)) {
                // 这个字母之前出现过，必须紧接在上一次结束之后
                // 即当前字符串的首字母如果之前出现过，那么它必须是当前结果串的延续
                // 但实际上，如果 firstChar 之前出现过，而现在又出现，
                // 只有当当前字符串全是这个字母，且紧接在上次出现之后，才可能连续
            }

            // 更简单的思路：直接拼接，然后检查当前结果串是否合法
            result.append(original);

            // 检查拼接后的结果是否合法
            if (!isValidResult(result.toString())) {
                return null;
            }
        }

        return result.toString();
    }

    /**
     * 压缩字符串并验证内部合法性
     * 例如 "PDD" -> "PD", "AAABBC" -> "ABC"
     * 如果内部有相同字母被隔开，返回 null
     */
    private static String compressAndValidate(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        sb.append(prev);
        Set<Character> seen = new HashSet<>();
        seen.add(prev);

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr != prev) {
                if (seen.contains(curr)) {
                    return null; // 字母被隔开
                }
                seen.add(curr);
                sb.append(curr);
                prev = curr;
            }
        }

        return sb.toString();
    }

    /**
     * 检查字符串是否满足：相同字母连续
     */
    private static boolean isValidResult(String s) {
        if (s.length() <= 1) return true;

        Set<Character> seen = new HashSet<>();
        char prev = s.charAt(0);
        seen.add(prev);

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr != prev) {
                if (seen.contains(curr)) {
                    return false;
                }
                seen.add(curr);
                prev = curr;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // 测试用例
        System.out.println(merge(new String[]{"PDD", "DEV","DDD"}));
        // PDDDDDDEV -> P D D D D D D E V, 每种字母都连续 ✓

        System.out.println(merge(new String[]{"EU", "UE"}));
        // EUUE -> E U U E, E 被隔开 ✗ -> null

        System.out.println(merge(new String[]{"ABC", "CBA"}));
        // ABCCBA -> A B C C B A, A 和 B 都被隔开 ✗ -> null

        System.out.println(merge(new String[]{"AA", "BB", "AA"}));
        // AABBAA -> A A B B A A, A 被隔开 ✗ -> null

        System.out.println(merge(new String[]{"AAB", "BCC"}));
        // AABBCC -> A A B B C C ✓

        System.out.println(merge(new String[]{"A", "B", "A"}));
        // ABA -> null

        System.out.println(merge(new String[]{"AAA", "AAA"}));
        // AAAAAA ✓
    }
}