import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        int ans  = 0;
        if (emails.length == 0) {
            return ans;
        }
        Set<String> set = new HashSet<>();
        for (String email: emails) {
            String []local_and_domain = email.split("@",2);
            String localorin = local_and_domain[0];
            String local = "";
            for (int i = 0; i < localorin.length(); i++) {
                if (localorin.charAt(i) == '+') {
                    break;
                }
                else if (localorin.charAt(i) == '.') {
                }
                else {
                    local += localorin.charAt(i);
                }
            }
            String domain = local_and_domain[1];
            String total = local + "@" + domain;
            if (!set.contains(total)) {
                set.add(total);
            }
        }
        return set.size();
    }
}