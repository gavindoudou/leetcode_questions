import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        //space complexity: O(L)
        //time complexity: O(n)
        List<String> lines = new LinkedList<>();

        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index + 1; i < last; i++) {
                    builder.append(" " + words[i]);
                }
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for (int i = index + 1; i < last; i++) {
                    for(int k = 0; k < spaces; k++) {
                        builder.append(" ");
                    }
                    if (r > 0) {
                        builder.append(" ");
                        r-=1;
                    }
                    builder.append(" " + words[i]);
                }
            }
            lines.add(builder.toString());
            index = last;
        }
        return lines;
    }
}