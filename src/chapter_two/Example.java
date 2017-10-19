package chapter_two;

/**
 * Created by Administrator on 2017/10/17.
 */
public class Example {
    public static void main(String[] args) {
        int result = sum(5);
    }

    public static int sum(int n) {
        int partialSum;

        partialSum = 0;
        for (int i = 0; i <= n; i++) {
            partialSum += i * i * i;

        }
        return partialSum;
    }
}
