import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Stack<Character> ans = new Stack<>();
        int[] dic = new int[26];
        boolean[] visited = new boolean[26];
        for (char ch: s.toCharArray()) {
            dic[ch - 'a']++;
        }
        for (char ch: s.toCharArray()) {
            dic[ch - 'a']--;
            if (visited[ch - 'a']) {
                continue;
            }
            while (!ans.isEmpty() && dic[ans.peek() - 'a'] > 0 && ch < ans.peek()) {
                visited[ans.peek() - 'a'] = false;
                ans.pop();
            }

            visited[ch - 'a'] = true;
            ans.push(ch);
        }
        String result = "";
        for (char ch: ans) {
            result += ch;
        }
        return result;
    }
}
