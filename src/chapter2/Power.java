package chapter2;

/**
 * Created by Administrator on 2017/10/17.
 */
public class Power {
    public static long pow(long x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n % 2 == 0)
            return pow(x * x, n / 2);
        else
            return pow(x * x, n / 2) * x;   //或者 return pow(x,n-1)*x;
    }
}
