package 数学思维2;


/**
 * 1700. 无法吃午餐的学生数量
 * LeeCode 1700
 * 难度 ： 中等
 */
public class LeeCode1700 {


    public int countStudents(int[] students, int[] sandwiches) {
        int let_0 = 0 , let_1 = 0;
        for(int i : students){
            if(i == 0) let_0++;
            else let_1++;
        }
        for(int i : sandwiches){
            if(i == 0) {
                if(let_0 == 0) break;
                let_0--;
            }else{
                if(let_1 == 0) break;
                let_1--;
            }
        }
        return let_0 + let_1;
    }
}
