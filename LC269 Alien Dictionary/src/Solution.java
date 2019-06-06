import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution {
    int[] InDegree;
    int[][] Edges;
    int[] Order;
    public String alienOrder(String[] words) {
        InDegree = new int[26];
        Arrays.fill(InDegree, -1);
        Edges = new int[26][26];
        Order = new int[26];
        int count = 1;
        for (String word: words) {
            //if one character appears, we mark it as 0.
            for (Character c: word.toCharArray()) {
                if (InDegree[c - 'a'] == -1) {
                    InDegree[c - 'a'] = 0;
                }
                if (Order[c - 'a'] == 0) {
                    Order[c - 'a'] = count;
                    count++;
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            findDifferent(words[i], words[i + 1]);
        }
        //topological sort
        StringBuilder sb = new StringBuilder();
        topologicalSort(sb);

        //if not all degree is -1, return ""
        for (int i = 0; i < 26; i++) {
            if (InDegree[i] != -1) {
                return "";
            }
        }
        return sb.toString();
    }
    private void findDifferent (String s1,String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len = Math.min(c1.length,c2.length);
        for (int i = 0; i < len; i++) {
            if (c1[i] != c2[i]) {
                InDegree[c2[i] - 'a']++;
                Edges[c1[i] - 'a'][c2[i] - 'a']++;
                break;
            }
        }
    }

    private void topologicalSort(StringBuilder sb) {
        boolean find = true;
        LinkedList<Integer> listFind = new LinkedList<>();

        while (find) {
            find = false;
            for (int i = 0; i < 26; i++) {
                if (InDegree[i] == 0) {
                    find = true;
                    listFind.add(i);
                    InDegree[i] = -1;
                }
            }
            if (find) {
                Collections.sort(listFind, (a, b) -> (Order[a] - Order[b]));
                for (Integer zeroInDegree : listFind) {
                    char c = (char) ('a' + zeroInDegree);
                    sb.append(c);
                    for (int i = 0; i < 26; i++) {
                        if (Edges[zeroInDegree][i] > 0) {
                            InDegree[i] = InDegree[i] - Edges[zeroInDegree][i];
                            Edges[zeroInDegree][i] = 0;
                        }
                    }
                }
                listFind.clear();
            }
        }
    }
}
