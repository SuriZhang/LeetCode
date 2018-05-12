// My Submission
public class Solution {
    // reverse the String[] which is splited by ws
    private static String reverse(String[] strArray){
        int len = strArray.length;
        int start = 0;
        int end = len - 1;
        while(start < end){
            String tmp = strArray[start];
            strArray[start] = strArray[end];
            strArray[end] = tmp;
            start++;
            end--;
        }
        String str = "";
        for(int i = 0; i < len; ++i){
            str += strArray[i];
            if(i != len - 1){
                str += " ";
            }
        }
        return str.trim();
    }
    
    public String reverseWords(String s) {
        String[] input = s.split("\\s+");
        return reverse(input);
    }
}

// A significantly faster solution
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        String[] array = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--){
            if(array[i].length() != 0){
                if (res.length() > 0){
                    res.append(" ");
                }
                res.append(array[i]);
            }
        }
        return res.toString();
    }
}
