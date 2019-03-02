import java.util.LinkedList;
import java.util.List;

public class Solution {
    // ()()()
    // (())()
    // (()())
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new LinkedList<>();
        String str = "";
        find(str, 0, 0, 0, n);
        return ans;
    }
    private void find (String str, int open, int close, int pos,int n) {
        if (pos == 2 * n) {
            ans.add(str);
            return;
        }
        if (open == close) {
            find(str + '(', open + 1, close, pos+ 1, n);
        }
        else {
            if (open < n) {
                find(str + '(', open + 1, close, pos + 1, n);
            }
            if (close < n) {
                find(str + ')', open, close + 1, pos + 1, n);
            }

        }
    }


}
