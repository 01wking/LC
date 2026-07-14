package src;

public class MinimumWindowSubstring {
    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";
        int n = s.length();
        int m = t.length();
        int [] ss = new int [128];
        int [] tt = new int [128];

        for(int i = 0; i < m;i++){
            tt[t.charAt(i) - 'A']++;
        }

        int start = 0;
        int len = Integer.MAX_VALUE;
        int left = 0;
        for(int right = 0; right < n;right++){
            ss[s.charAt(right) - 'A']++;
            while(left <= right && check(ss,tt)){
                if(right - left + 1 < len){
                    start = left;
                    len = right - left + 1;
                }
                ss[s.charAt(left) - 'A']--;
                left++;
            }
        }

        System.out.println(s.substring(start, start + len));
    }
    public static boolean check(int [] a,int [] b){
        int n = a.length;
        for(int i = 0; i < n;i++){
            if(a[i] < b[i]){
                return false;
            }
        }
        return true;
    }
}
