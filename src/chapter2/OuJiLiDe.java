package chapter2;

/**
 * Created by Administrator on 2017/10/17.
 */
//计算最大公因数的欧几里得算法
public class OuJiLiDe {
    public static long gcd(long m, long n) {
        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }
}
