import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> receivers = new HashSet<>();
        for (String email : emails) {
            String[] strs = email.split("@");
            String user = strs[0].replace(".", "");
            user = user.split("\\+")[0];
            receivers.add(user + "@" + strs[1]);
        }
        return receivers.size();
    }
}
