package 数学思维;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LCP 03. 机器人大冒险
 * LeeCode 2332
 * 难度 ： 中等
 */
public class LeeCode2332 {

    public static void main(String[] args) {

       int[] m =  new int[10];
       int [] n = {1,1,2,3,4,5,3};
        for (int i : n) {
            m[i]++;
        }
        for (int i : m) {
            System.out.print(i + " ");
        }

    }

    //超出时间限制
    public static boolean robot(String cmd, int[][] obstacles, int x, int y) {
                int n = cmd.length();
                int sx = 0, sy = 0;
                // 记录走完一轮后机器人的位置
                for (int i = 0; i < n; ++i) {
                    char c = cmd.charAt(i);
                    if (c == 'U') ++sy;
                    else ++sx;
                }
                // 先计算能否到达终点 不考虑障碍物
                // 若不能直接返回false
                boolean canFinish = canReach(cmd, x, y, sx, sy);
                if (!canFinish) return false;
                // 判断在终点前会不会遇到障碍物
                // 若遇到则返回false
                for (int[] o : obstacles) {
                    if (o[0] > x || o[1] > y)
                        continue;
                    if (canReach(cmd, o[0], o[1], sx, sy)) return false;
                }
                return true;
            }

            // 判断能否从坐标(x, y)到达(tx, ty)
            public static boolean canReach(String cmd, int tx, int ty, int x, int y) {
                // round记录走到目标点至少要走多少轮
                int round = Math.min(tx / x, ty / y);
                int nx = round * x, ny = round * y;
                if (nx == tx && ny == ty) return true;
                int n = cmd.length();
                for (int i = 0; i < n; ++i) {
                    char c = cmd.charAt(i);
                    if (c == 'U') ++ny;
                    else ++nx;
                    if (nx > tx || ny > ty) return false;
                    if (nx == tx && ny == ty) return true;
                }
                return true;
            }
        }

