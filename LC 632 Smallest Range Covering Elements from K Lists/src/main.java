import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class main {
    public static void main(String [] args) {
        Solution m = new Solution();
        List<List<Integer>> test1 = new LinkedList<>();
        List<Integer>testsub1 = new LinkedList<>(Arrays.asList(1,2,3));
        List<Integer>testsub2 = new LinkedList<>(Arrays.asList(1,2,3));
        List<Integer>testsub3 = new LinkedList<>(Arrays.asList(1,2,3));
        test1.add(testsub1);
        test1.add(testsub2);
        test1.add(testsub3);
        m.smallestRange(test1);
    }
}