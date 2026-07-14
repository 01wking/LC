package src.hot100;

import java.util.*;

import java.util.*;

public class StringConcatenator {

    // 内部类：连续相同字母块
    private static class Run {
        char c;
        int count;
        Run(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    /**
     * 拼接全大写字符串数组，使相同字母连续出现。
     * 若无法做到，返回 null。
     *
     * @param strs 全大写字符串数组（不会被修改）
     * @return 拼接后的字符串 或 null
     */
    public static String concatenate(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Map<Character, Integer> totalCount = new HashMap<>();
        Map<Character, Character> next = new HashMap<>();   // 后继
        Map<Character, Character> prev = new HashMap<>();   // 前驱
        Set<Character> allLetters = new HashSet<>();

        // 1. 解析所有字符串的 run，统计数量和邻接关系
        for (String s : strs) {
            if (s.isEmpty()) continue;
            List<Run> runs = getRuns(s);  // 只读操作

            for (Run run : runs) {
                totalCount.put(run.c, totalCount.getOrDefault(run.c, 0) + run.count);
                allLetters.add(run.c);
            }

            for (int i = 0; i < runs.size() - 1; i++) {
                char u = runs.get(i).c;
                char v = runs.get(i + 1).c;

                if (next.containsKey(u) && next.get(u) != v) return null;
                if (prev.containsKey(v) && prev.get(v) != u) return null;
                next.put(u, v);
                prev.put(v, u);
            }
        }

        // 2. 环检测（每个节点出入度≤1，只需检测有没有闭环）
        Set<Character> visited = new HashSet<>();
        for (char c : allLetters) {
            if (visited.contains(c)) continue;
            Set<Character> path = new HashSet<>();
            char cur = c;
            while (cur != 0) {
                if (path.contains(cur)) return null; // 发现环
                path.add(cur);
                visited.add(cur);
                cur = next.getOrDefault(cur, '\0');
            }
        }

        // 3. 按前驱关系生成字母最终顺序
        List<Character> order = new ArrayList<>();
        Set<Character> used = new HashSet<>();
        for (char c : allLetters) {
            if (prev.containsKey(c)) continue; // 不是链起点
            char cur = c;
            while (cur != 0 && !used.contains(cur)) {
                order.add(cur);
                used.add(cur);
                cur = next.getOrDefault(cur, '\0');
            }
        }
        // 加入没有任何邻接关系的孤立字母
        for (char c : allLetters) {
            if (!used.contains(c)) {
                order.add(c);
            }
        }

        // 4. 拼接最终字符串
        StringBuilder sb = new StringBuilder();
        for (char c : order) {
            int cnt = totalCount.get(c);
            sb.append(String.valueOf(c).repeat(cnt));
        }
        return sb.toString();
    }

    // 提取字符串的 run 序列（纯读取）
    private static List<Run> getRuns(String s) {
        List<Run> runs = new ArrayList<>();
        char prev = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prev) {
                count++;
            } else {
                runs.add(new Run(prev, count));
                prev = c;
                count = 1;
            }
        }
        runs.add(new Run(prev, count));
        return runs;
    }

    public static void main(String[] args) {
        System.out.println(concatenate(new String[]{"PDD",  "DEV","DDD"})); // PDDDDDDEV
        System.out.println(concatenate(new String[]{"EU", "UE"}));         // null
        System.out.println(concatenate(new String[]{"HAH", "B", "C"}));       // ABC
        System.out.println(concatenate(new String[]{"A", "AB"}));           // AAB
    }
}