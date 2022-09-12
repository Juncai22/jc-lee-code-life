package 二分查找法;


import java.util.PriorityQueue;

/**
 * 1642. 可以到达的最远建筑
 * LeeCode 1642
 * 难度 ： 中等
 */
public class LeeCode1642 {

    public static void main(String[] args) {
        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        furthestBuilding(heights, 5, 1);
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int ans=0;
        while(ans<heights.length-1){
            if(heights[ans]>=heights[ans+1]) ans++;
            else {
                int v=heights[ans+1]-heights[ans];
                queue.add(v);
                if(queue.size()>ladders) bricks-=queue.poll();
                if(bricks<0) return ans;
                ans++;
            }
        }
        return ans;
    }
}
