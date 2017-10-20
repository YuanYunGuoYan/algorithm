package chapter2;

/**
 * Created by Administrator on 2017/10/17.
 */
//折半查找
public class Binary_search {
    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType[] a, AnyType x) {
        int low = 0, high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid].compareTo(x) < 0)
                low = mid + 1;
            else if (a[mid].compareTo(x) > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
