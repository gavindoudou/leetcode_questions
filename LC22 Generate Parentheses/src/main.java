import java.util.List;

public class main {
    public static void main(String [] args) {
        Solution m = new Solution();
        List<String> ans = m.generateParenthesis(4);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
