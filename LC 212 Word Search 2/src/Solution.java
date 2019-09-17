import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new LinkedList<>();
        TrieNode root = createTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ans);
            }
        }
        return ans;
    }
    private void dfs (char[][] board, int i, int j, TrieNode p, List<String> ans) {
        char curr = board[i][j];
        if (curr == '.' || p.next[curr - 'a'] == null) {
            return;
        }
        p = p.next[curr - 'a'];
        if (p.word != null) {
            ans.add(p.word);
            p.word = null;
        }
        board[i][j] = '.';
        if (i > 0) dfs(board, i - 1, j, p, ans);
        if (j > 0) dfs(board, i, j - 1, p, ans);
        if (i < board.length - 1) dfs(board, i + 1, j, p, ans);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, ans);
        board[i][j] = curr;
    }
    private TrieNode createTrie (String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode curr = root;
            for (Character eachChar: word.toCharArray()) {
                int i  = eachChar - 'a';
                if (curr.next[i] == null) {
                    curr.next[i] = new TrieNode();
                }
                curr = curr.next[i];
            }
            curr.word = word;
        }
        return root;
    }
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}