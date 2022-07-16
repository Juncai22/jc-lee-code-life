package 双指针;


import java.util.Arrays;

/**
 * 826. 安排工作以达到最大收益
 * LeeCode 826
 * 难度 ： 中等
 */
public class LeeCode826 {

    public static void main(String[] args) {
        int[] difficulty = {68,35,52,47,86};
        int[] profit = {67,17,1,81,3};
        int[] worker = {92,10,85,84,82};
        int i = maxProfitAssignment(difficulty, profit, worker);
        System.out.println(i);
    }


    //个人方法
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int m = 0;
        int n = 0;
        int price = 0;
        sortV2(difficulty,profit);
        Arrays.sort(worker);
        while (n != worker.length) {
            if (worker[n] >= difficulty[m] && worker[n] < difficulty[m + 1] && m < difficulty.length - 1) {
                price += profit[m];
                n++;
            } else if (worker[n] < difficulty[m]) {
                if (m == 0) {
                    n++;
                } else {
                    m--;
                }
            } else if (worker[n] >= difficulty[difficulty.length - 1]) {
                price += profit[difficulty.length - 1];
                n++;
            } else {
                m++;
            }
        }
        return price;
    }

    public static void sortV2(int[] diffcutes,int[] profits){
        int[] clone = diffcutes.clone();
        Arrays.sort(diffcutes);
        for (int i = 0; i < diffcutes.length; i++) {
            for (int j = 0; j < clone.length; j++) {
                if (diffcutes[i] == clone[j] && i > j){

                    int temp = profits[i];
                    profits[i] = profits[j];
                    profits[j] = temp;
                    break;
                }
            }
        }
    }
    //方法2
    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length, m = worker.length;
        // 构建工作数组
        Job[] jobs = new Job[n];
        for(int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        // 将工作根据工作难度进行升序
        Arrays.sort(jobs, (a, b) -> a.di - b.di);
        // 工人也根据能力进行升序
        Arrays.sort(worker);
        // top用来保存某一工作难度下得最大收益
        int top = 0, res = 0;
        // 从低到高遍历所有工作，j用于指向可以承受该难度得最低工人序号
        for(int i = 0, j = 0; i < n; i ++) {
            // 剔除掉无法承受该工作强度的工人，j后面的工人能力都是大于工作i的
            while(j < m && worker[j] < jobs[i].di) j ++;
            // 如果j已经指向最后了，那么就没有工人能干剩下得活了，直接退出
            if(j == m) break;
            // 我们需要给后面的工人更换价值更高的活，所以，先剔除这部分工人之前工作收益
            res -= (m - j) * top;
            // 取最大收益
            top = Math.max(top, jobs[i].pro);
            // 给后面的工人安排新的工作
            res += (m - j) * top;
        }

        return res;
    }
}
// 定义一个工作的数据类
class Job {
    public int di, pro;
    public Job(int d, int p) {
        di = d;
        pro = p;
    }

}
