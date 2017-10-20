package chapter3;

import java.util.Collection;
import java.util.ListIterator;

/**
 * Created by Administrator on 2017/10/17.
 */
public class ListArrayListLinkedList {
    public interface List<AnyType> extends Collection<AnyType> {
        AnyType get(int idx);

        AnyType set(int idx, AnyType newVal);

        void add(int idx, AnyType x);

        void remove(int idx);

        ListIterator<AnyType> listIterator(int pos);
    }

    //ArrayList,LinkedList 运行时间O(N)
    public static void makeList1(List<Integer> lst, int N) {
        lst.clear();
        for (int i = 0; i < N; i++) {
            lst.add(i);
        }
    }

    //ArrayList 运行时间O(N^2) LinkedList 运行时间O(N)
    public static void makeList2(List<Integer> lst, int N) {
        lst.clear();
        for (int i = 0; i < N; i++) {
            lst.add(0, i);
        }
    }

    //ArrayList 运行时间O(N) LinkedList 运行时间O(N^2)
    public static int sum(List<Integer> lst, int N) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += lst.get(i);
        }
        return total;
    }

}
