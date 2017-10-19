package chapter_three;

/**
 * Created by Administrator on 2017/10/17.
 */
public class Collection {
    //Collection接口的子集
    public interface Collection<AnyType> extends Iterable<AnyType>
    {
        int size();
        boolean isEmpty();
        void clear();
        boolean contains(AnyType x);
        boolean add(AnyType x);
        boolean remove(AnyType x);
        java.util.Iterator<AnyType> iterator();
    }

    public static <AnyType> void print(Collection<AnyType> coll){
        for (AnyType item:coll ) {
            System.out.println(item);
        }
    }
}
