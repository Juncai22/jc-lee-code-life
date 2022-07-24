package 数学思维2;



/**
 * 836. 矩形重叠
 * LeeCode 836
 * 难度 ： 简单
 */
public class LeeCode836 {


    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //判断是否重叠，也就是是否有相交的部分
        if(rec2[1] >= rec1[3] || rec1[1] >= rec2[3]){
            return false;
        }
        if(rec1[0] >= rec2[2] || rec1[2] <= rec2[0]){
            return false;
        }
        return true;
    }
}
