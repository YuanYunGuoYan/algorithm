package chapter5;

/**
 * Created by Administrator on 2017/10/24.
 */
public class hash {
    public static int hash1(String key, int tableSize) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal += key.charAt(i);
        }
        return hashVal % tableSize;
    }

    //不好
    public static int hash2(String key, int tableSize) {
        return (key.charAt(0) + 27 * key.charAt(1) + 729 * key.charAt(2)) % tableSize;
    }

    //好的散列函数
    public static int hash3(String key, int tableSize) {
        int hashVal = 0;

        for (int i = 0; i < key.length(); i++) {
            hashVal = 37 * hashVal + key.charAt(i);
        }

        hashVal %= tableSize;
        if (hashVal < 0)
            hashVal += tableSize;

        return hashVal;
    }
}
