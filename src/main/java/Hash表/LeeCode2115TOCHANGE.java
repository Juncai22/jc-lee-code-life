package Hash表;


import java.util.*;

/**
 * 2115. 从给定原材料中找到所有可以做出的菜
 * LeeCode 2115
 * 难度 ： 中等
 */
public class LeeCode2115TOCHANGE {

    public static void main(String[] args) {
        String[] strings = {"cake", "sandwich", "bread"};
        List<List<String>> ing = new ArrayList<>();
        String[] supplies = {"yeast", "flour", "meat"};
        List<String> stringLisd = new ArrayList<>();
        stringLisd.add("yeast");
        stringLisd.add("flour");
        List<String> stringLisd1 = new ArrayList<>();
        stringLisd1.add("bread");
        stringLisd1.add("meat");
        List<String> stringLis1 = new ArrayList<>();
        stringLis1.add("sandwich");
        stringLis1.add("bread");

        ing.add(stringLis1);
        ing.add(stringLisd1);
        ing.add(stringLisd);
        List<String> allRecipes = findAllRecipes(strings, ing, supplies);
        for (String allRecipe : allRecipes) {
            System.out.println(allRecipe);
        }
    }

    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < supplies.length; i++) {
            q.offer(supplies[i]);
        }

        while (!q.isEmpty()) {
            String supplie = q.poll();
            for (int i = 0; i < ingredients.size(); i++) {
                List<String> list = ingredients.get(i);
                if (list.size() == 0) {
                    continue;
                }
                list.remove(supplie);
                if (list.size() == 0) {
                    res.add(recipes[i]);
                    q.offer(recipes[i]);
                }
            }
        }

        return res;
    }
}
