package src;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString_438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));

    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if (m > n) {
            return ans;
        }
        int[] ss = new int[26];
        int[] pp = new int[26];

        for (int i = 0; i < m; i++) {
            char c = p.charAt(i);
            pp[c - 'a']++;
        }
        int l = 0;
        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            if (r - l + 1 < m) {
                ss[c - 'a']++;
                continue;
            }
            ss[c - 'a']++;
            if (check(ss, pp)) {
                ans.add(l);
            }
            ss[s.charAt(l) - 'a']--;
            l++;
        }
        return ans;

    }

    private static boolean check(int[] ss, int[] pp) {
        for (int i = 0; i < 26; i++) {
            if (pp[i] > ss[i]) {
                return false;
            }
        }
        return true;
    }

}
