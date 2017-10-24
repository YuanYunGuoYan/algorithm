package chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/10/24.
 */
public class Word {
    public static void printHighChangeables(Map<String, List<String>> adjWords, int minWords) {
        for (Map.Entry<String, List<String>> entry : adjWords.entrySet()) {
            List<String> words = entry.getValue();

            if (words.size() >= minWords) {
                System.out.println(entry.getKey() + "(");
                System.out.println(words.size() + "):");
                for (String w : words)
                    System.out.println(" " + w);
                System.out.println();
            }
        }
    }

    private static boolean oneCharOff(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        int diffs = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                if (++diffs > 1)
                    return false;
        }

        return diffs == 1;
    }

    private static <KeyType> void update(Map<KeyType, List<String>> m, KeyType key, String value) {
        List<String> lst = m.get(key);
        if (lst == null) {
            lst = new ArrayList<>();
            m.put(key, lst);
        }

        lst.add(value);
    }

    //方法1：运行75秒
    public static Map<String, List<String>> computeAdjacentWords1(List<String> theWords) {
        Map<String, List<String>> adjWords = new TreeMap<>();

        String[] words = new String[theWords.size()];

        theWords.toArray(words);
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (oneCharOff(words[i], words[j])) {
                    update(adjWords, words[i], words[j]);
                    update(adjWords, words[j], words[i]);
                }
            }
        }
        return adjWords;
    }

    //方法2：运行16秒
    public static Map<String, List<String>> computeAdjacentWords2(List<String> theWords) {
        Map<String, List<String>> adjWords = new TreeMap<>();
        Map<Integer, List<String>> wordsByLength = new TreeMap<>();

        for (String w : theWords)
            update(wordsByLength, w.length(), w);

        for (List<String> groupsWords : wordsByLength.values()) {
            String[] words = new String[groupsWords.size()];

            groupsWords.toArray(words);
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (oneCharOff(words[i], words[j])) {
                        update(adjWords, words[i], words[j]);
                        update(adjWords, words[j], words[i]);
                    }
                }
            }
        }
        return adjWords;
    }

    //方法3：运行1秒
    public static Map<String, List<String>> computeAdjacentWords3(List<String> theWords) {
        Map<String, List<String>> adjWords = new TreeMap<>();
        Map<Integer, List<String>> wordsByLength = new TreeMap<>();

        for (String w : theWords)
            update(wordsByLength, w.length(), w);

        for (Map.Entry<Integer, List<String>> entry : wordsByLength.entrySet()) {
            List<String> groupsWords = entry.getValue();
            int groupNum = entry.getKey();

            for (int i = 0; i < groupNum; i++) {
                Map<String, List<String>> repToWord = new TreeMap<>();

                for (String str : groupsWords) {
                    String rep = str.substring(0, i) + str.substring(i + 1);
                    update(repToWord, rep, str);
                }

                for (List<String> wordClique : repToWord.values())
                    if (wordClique.size() >= 2)
                        for (String s1 : wordClique)
                            for (String s2 : wordClique)
                                if (s1 != s2)
                                    update(adjWords, s1, s2);
            }
        }
        return adjWords;
    }
}
