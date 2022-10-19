package 竞赛题;

import java.util.Arrays;

public class LeeCodeLCP001 {


    public int minNumBooths(String[] demand) {

        int[] anss = new int[26];
        int ans = 0;
        Arrays.fill(anss, 0);
        for (String s : demand) {
            int[] temp = new int[26];
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                temp[aChar - 'a']++;
            }
            for (int i = 0; i < temp.length; i++) {
                anss[i] = Math.max(temp[i], anss[i]);
            }
        }
        for (int i = 0; i < anss.length; i++) {
            ans += anss[i];
        }
        return ans;
    }
}
