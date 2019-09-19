import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String eachDomain: cpdomains) {
            String[] info  = eachDomain.split(" ");
            int num = Integer.parseInt(info[0]);
            String domain = info[1];
            map.put(domain,map.getOrDefault(domain,0) + num);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    map.put(domain.substring(i + 1),map.getOrDefault(domain.substring(i + 1),0) + num);
                }
            }
        }
        for (String key: map.keySet()) {
            ans.add(map.get(key) + " " + key);
        }
        return ans;
    }
}