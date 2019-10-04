public class main {
    public static void main(String [] args) {
        Solution m = new Solution();
        char[] input1 = {'a', 'b', 'c', 'd', 'e'};
        char[] input2 = {'a', 'c', 'd', 'e', 's'};
        System.out.println(m.longestCommonSubstring(input1,input2));
    }
}