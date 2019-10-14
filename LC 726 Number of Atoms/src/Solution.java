import java.util.Stack;
import java.util.TreeMap;

class Solution {
    public String countOfAtoms(String formula) {
        if (formula == null || formula.length() == 0) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        TreeMap<String, Integer> map = new TreeMap<>();
        Stack<TreeMap> stack = new Stack<>();
        char[] fChar = formula.toCharArray();
        int fLen = fChar.length, i = 0;
        while (i < fLen) {
            if (fChar[i] == '(') {
                stack.push(map);
                map = new TreeMap<>();
                i++;
            }else if (fChar[i] == ')') {
                int count = 0;
                i++;
                while (i < fLen && Character.isDigit(fChar[i])) {
                    count = count * 10 + fChar[i] - '0';
                    i++;
                }
                if (count == 0) {
                    count = 1;
                }
                if (!stack.isEmpty()) {
                    TreeMap<String, Integer> preMap = stack.pop();
                    for (String key : map.keySet()) {
                        preMap.put(key, preMap.getOrDefault(key, 0) + map.get(key) * count);
                    }
                    map = preMap;
                }
            }else {
                int end = i + 1;
                if (end < fLen && Character.isLowerCase(fChar[end])) {
                    end++;
                }
                String atom = formula.substring(i, end);
                i = end;
                int count = 0;
                while (i < fLen && Character.isDigit(fChar[i])) {
                    count = count * 10 + fChar[i] - '0';
                    i++;
                }
                if (count == 0) {
                    count  = 1;
                }
                map.put(atom, map.getOrDefault(atom, 0) + count);
            }
        }
        for (String atom: map.keySet()) {
            ans.append(atom);
            if (map.get(atom) > 1) {
                ans.append(map.get(atom));
            }
        }
        return ans.toString();
    }
}