class Solution {
    public int firstUniqChar(String s) {
        int res = -1;
        if(s.length() == 0) {
            return res;
        } else if(s.length() == 1){
            res = 0;
            return res;  
        } else {
            for(int i = 0; i < s.length(); ++i){
                if(s.indexOf(Character.toString(s.charAt(i)))==s.lastIndexOf(Character.toString(s.charAt(i)))){
                    res = i;
                    break;
                }
            }
        }
            return res;
    }
}

// use a map to store freq
// 2 passes
