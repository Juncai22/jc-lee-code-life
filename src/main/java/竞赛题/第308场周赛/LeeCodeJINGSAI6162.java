package 竞赛题.第308场周赛;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 6162. 收集垃圾的最少总时间
 * LeeCode 6162
 * 难度 ： 中等
 */
public class LeeCodeJINGSAI6162 {

    public static void main(String[] args) {
        String[] garbage = {"GGMMP","MPMGPM","GPMP"};
        int[] travel = {1,4};
        garbageCollection(garbage,travel);
//        Character m = 'a';
//        String s = m.toString();
//        System.out.println(s);
    }


    public static int garbageCollection(String[] garbage, int[] travel) {
        HashSet<Character> car = new HashSet<>();
        for (int i = garbage.length - 1; i >= 0; i--) {
            char[] chars = garbage[i].toCharArray();
            car.add('P');
            car.add('G');
            car.add('M');
            for (char aChar : chars) {
                if (car.contains(aChar)) {
                    car.remove(aChar);
                }
            }
            if (!car.isEmpty()) {
                break;
            }else if (car.isEmpty() && i == 0){
                car.add('P');
                car.add('G');
                car.add('M');
            }
        }
        Character first = 'x';
        if (car.size() >= 1) {
            for (Character character : car) {
                first = character;
            }
        }
        for (int i = garbage.length - 1; i >= 0; i--) {
            char[] chars = garbage[i].toCharArray();
            car.add('P');
            car.add('G');
            car.add('M');
            car.remove(first);
            for (char aChar : chars) {
                if (car.contains(aChar)) {
                    car.remove(aChar);
                }
            }
            if (!car.isEmpty()) {
                break;
            }else if (car.isEmpty() && i == 0){
                car.add('P');
                car.add('G');
                car.add('M');
                car.remove(first);
            }
        }
        Character second = 'x';
        if (car.size() >= 1) {
            for (Character character : car) {
                second = character;
            }
        }
        car.add('P');
        car.add('G');
        car.add('M');
        car.remove(first);
        car.remove(second);
        Character thaird = 'x';
        int firstend = -1;
        int secondend = -1;
        int thirdend = -1;
        int ans = 0;
        if (car.size() >= 1) {
            for (Character character : car) {
                thaird = character;
            }
        }
        for (int i = garbage.length - 1; i >= 0; i--) {
            if (garbage[i].contains(thaird.toString()) && thirdend == -1) {
                thirdend = i;
            }
            if (garbage[i].contains(second.toString()) && secondend == -1) {
                secondend = i;
            }
            if (garbage[i].contains(first.toString()) && firstend == -1) {
                firstend = i;
            }
            if (thirdend != -1 && secondend != -1 && firstend != -1) break;
        }

        for (int i = 0; i <= firstend; i++) {
            char[] chars = garbage[i].toCharArray();
            for (char aChar : chars) {
                if (aChar == first) {
                    ans++;
                }
            }
            if (i < firstend) {
                ans += travel[i];
            }
        }
        for (int i = 0; i <= secondend; i++) {
            char[] chars = garbage[i].toCharArray();
            for (char aChar : chars) {
                if (aChar == second) {
                    ans++;
                }
            }
            if (i < secondend) {
                ans += travel[i];
            }
        }
        for (int i = 0; i <= thirdend; i++) {
            char[] chars = garbage[i].toCharArray();
            for (char aChar : chars) {
                if (aChar == thaird) {
                    ans++;
                }
            }
            if (i < thirdend) {
                ans += travel[i];
            }
        }
        return ans;
    }

//    public static boolean check(String temp,Character s){
//        String s1 = s.toString();
//
//
//        return temp.contains(s1);
//    }
}
