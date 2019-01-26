import java.util.*;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        char deliminator = '*';
        if(strs.size() == 0) return sb.toString();
        
        for(String s : strs) {
            int len = s.length();
            
            sb.append(len);
            sb.append(deliminator);
            sb.append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList();
        
        if(s == "" || s == null) return result;
        
        int i = 0;
        while(i < s.length()) {
            int index = s.indexOf('*', i);
            System.out.println("index="+index);
            int str_len = Integer.parseInt(s.substring(i, index));
            System.out.println("len="+str_len);
            int end = index + 1 + str_len;
            
            if(str_len == 0) {
               result.add(""); 
            } else {
                result.add(s.substring(index+1, end));
            }
            
            i = end;    
        }
        return result;
    }
}

