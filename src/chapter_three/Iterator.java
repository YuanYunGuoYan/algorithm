package chapter_three;

import java.util.Collection;

/**
 * Created by Administrator on 2017/10/17.
 */
public class Iterator {
    public interface Iterator<AnyType>{
        boolean hasNext();
        AnyType next();
        void remove();
    }

    public static <AnyType> void print(Collection<AnyType> coll){
        Iterator<AnyType> itr=(Iterator<AnyType>)coll.iterator();
        while(itr.hasNext()){
            AnyType item=itr.next();
            System.out.println(item);
        }
    }
}
