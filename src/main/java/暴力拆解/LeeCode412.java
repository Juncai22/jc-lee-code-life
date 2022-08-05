package 暴力拆解;


import java.util.ArrayList;
import java.util.List;

/**
 * 412. 直接提
 * LeeCode 412
 * 难度 ： 简单
 */
public class LeeCode412 {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList();
        list.add("1");
        for(int i = 2 ; i <= n ; i++){
            if(i % 3 == 0){
                if(i % 5 == 0){
                    list.add("FizzBuzz");
                }else{
                    list.add("Fizz");
                }
            } else if(i % 5 == 0){
                list.add("Buzz");
            } else {
                list.add(i+"");
            }
        }
        return list;
    }
}
