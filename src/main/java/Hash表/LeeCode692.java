package Hash表;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 692. 前K个高频单词
 * LeeCode 692
 * 难度 ： 中等
 */
public class LeeCode692 {

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> strings = topKFrequent(words, k);
    }

    //TreeMap方法
    public static List<String> topKFrequent(String[] words, int k) {
        //TreeMap的解决方案
        TreeMap<String, Integer> temp = new TreeMap<>();
        List<String> ans = new ArrayList<>();
        //先进行for循环然后的得到遍历，如果重复则加一
        for (String word : words) {
            if (temp.containsKey(word)) {
                temp.put(word, temp.get(word) + 1);
            } else {
                temp.put(word, 1);
            }
        }
        //进行List，好进行排序
        List<Map.Entry<String, Integer>> treeMapList = new ArrayList<Map.Entry<String, Integer>>(temp.entrySet());

        //使用Collection进行排序
        Collections.sort(treeMapList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });

        //将排序好的前几个放进去
        int i = 0;
        for (Map.Entry<String, Integer> stringIntegerEntry : treeMapList) {
            ans.add(stringIntegerEntry.getKey());
            i++;
            if (i == k){
                break;
            }
        }

        //返回答案
        return ans;
    }


    //HashMap方法
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        return rec.subList(0, k);
    }
}
