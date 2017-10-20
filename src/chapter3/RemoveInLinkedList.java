package chapter3;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
public class RemoveInLinkedList {

    //删除表中的偶数：算法对所有类型的表都是二次的
    public static void removeEvensVer1(List<Integer> lst)
    {
        int i=0;
        while (i<lst.size()){
            if(lst.get(i)%2==0)
                lst.remove(i);
            else
                i++;
        }
    }

    //删除表中的偶数：由于ConcurrentModificationException异常而无法运行
    public static void removeEvensVer2(List<Integer> lst){
        for (Integer x: lst) {
            if(x%2==0)
                lst.remove(x);
        }
    }

    //删除表中的偶数：对ArrayList是二次的，但对LinkedList是线性的
    public static void removeEvensVer3(List<Integer> lst){
        Iterator<Integer> itr=lst.iterator();
        while (itr.hasNext())
            if(itr.next()%2==0){
            itr.remove();
            }
    }


}
