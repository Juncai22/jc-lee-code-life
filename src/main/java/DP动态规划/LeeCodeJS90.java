package DP动态规划;


import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 剑指 Offer II 090. 环形房屋偷盗
 * LeeCode 剑指 Offer II 090
 * 难度 ： 中等
 */
public class LeeCodeJS90 {

    public static void main(String[] args) {

//        AtomicInteger atomicInteger = new AtomicInteger(3);
//        System.out.println(atomicInteger.getAndIncrement());
//        System.out.println(atomicInteger);
        Book book1 = new Book("JuncaiBook", 1);
//        AtomicReference<Book> atomicReference = new AtomicReference<>(book1);
        Book book2 = new Book("JiHangBook", 2);
//        boolean b = atomicReference.compareAndSet(book1, book2);
//        System.out.println(b + " -------------- " + atomicReference.get().toString());

        AtomicStampedReference<Book> atomicStampedReference = new AtomicStampedReference<>(book1,1);
        atomicStampedReference.compareAndSet(book1,book2,1,2);
        Book reference = atomicStampedReference.getReference();
        Book book = atomicStampedReference.get(new int[]{1});
        System.out.println(reference);
        System.out.println(book);

    }

    public static class Book {
        public String name;
        public int age;

        public Book(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static int rob(int[] nums) {
        //简单的动态规划
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        int n = nums.length;
        if (n <= 3) {
            Arrays.sort(nums);
            return nums[n - 1];
        }
        //首先定义值，顺便查看值是否达到最大
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {

            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[2], nums[1]);

        //首先定义值，顺便查看值是否达到最大
        for (int i = 2; i < n; i++) {
            dp[i - 1] = Math.max(dp[i - 2], dp[i - 1]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        //返回最大的数
        return Math.max(dp[n - 2], dp2[n - 1]);
    }
}
