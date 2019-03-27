package com.coder.kkb;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinTest {
	
	/**----   求1到1000的和    ----**/
	
	static long[] numbers = LongStream.rangeClosed(1, 1000).toArray();
	
	/**
	 * 原始方法
	 */
	public static void sumOld(){
		long total = 0;
        for (long i : numbers) {
            total += i;
        }
        System.out.println(total);
	}
	
	
	/**
	 * forkjoin
	 * 创建一个包含parallelism个并行线程的ForkJoinPool
	 */
	private static ForkJoinPool pool = new ForkJoinPool(1);

    private static class SumTask extends RecursiveTask<Long> {
        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            // 当需要计算的数字小于6时，直接计算结果
            if (to - from < 6) {
                long total = 0;
                for (int i = from; i <= to; i++) {
                    total += numbers[i];
                }
                return total;
            // 否则，把任务一分为二，递归计算
            } else {
                int middle = (from + to) / 2;
                SumTask taskLeft = new SumTask(numbers, from, middle);
                SumTask taskRight = new SumTask(numbers, middle+1, to);
                taskLeft.fork();
                taskRight.fork();
                return taskLeft.join() + taskRight.join();
            }
        }
    }

    
    public static void sumForkJoin(){
    	pool.invoke(new SumTask(numbers, 0, numbers.length-1));
    }
    
	public static void main(String[] args) {
		sumForkJoin();
	}
}
