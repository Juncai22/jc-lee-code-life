package 暴力拆解;


import java.util.List;

/**
 * 面试题 08.06. 汉诺塔问题
 * LeeCode 2672
 * 难度 ： 简单
 */
public class LeeCode2672 {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        for(int i=0;i<A.size();i++)
            C.add(A.get(i));
    }

}
