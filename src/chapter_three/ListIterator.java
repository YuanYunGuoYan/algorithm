package chapter_three;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/10/18.
 */
public class ListIterator {
    public interface ListIterator<AnyType> extends Iterator<AnyType>
    {
        boolean hasPrevious();
        AnyType previous();

        void add(AnyType x);
        void set(AnyType newVal);
    }
}
