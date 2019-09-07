import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ast: asteroids) {
            collision: {
                while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                    if (ast + stack.peek() == 0) {
                        stack.pop();
                    } else if (ast + stack.peek() < 0) {
                        stack.pop();
                        continue;
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }
        // stack to int array
        int[] ans = new int[stack.size()];
        int j = stack.size() - 1;
        while (!stack.isEmpty()) {
            ans[j] = stack.pop();
            j--;
        }
        return ans;
    }
}