class Solution {
    private boolean check(String s) {
        int l = 0, r = s.length()-1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            r--;
            l++;
        }
        return true;
    }
    
    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; ++i) {
            map.put(words[i], i);
        }
        
        // case 1: check empty string
        if(map.containsKey("")) {
            int j = map.get("");
            for(String word : words) {
                if(check(word)){
                    int i = map.get(word);
                    if(i == j) continue;
                    res.add(Arrays.asList(i,j));
                    res.add(Arrays.asList(j,i));
                }
            }
        }
        
        // case 2: check palindrome
        for(String word: words) {
            String rev = reverse(word);
            if(map.containsKey(rev)) {
                int i = map.get(word);
                int j = map.get(rev);
                if(j == i) continue;
                res.add(Arrays.asList(i,j));
            }
        }
        
        // case 3 & 4
        for(String word : words) {
            for(int j = 1; j < word.length(); ++j) {
                String right = word.substring(j);
                String left = word.substring(0,j);
                String rrev = reverse(right);
                String lrev = reverse(left);
                if(check(left)) {
                    int i = map.get(word);
                    if(map.containsKey(rrev)) {
                        int k = map.get(rrev);
                        if(k == i) continue;
                        res.add(Arrays.asList(k,i));
                    }
                }
                if(check(right)) {
                    int i = map.get(word);
                    if(map.containsKey(lrev)) {
                        int k = map.get(lrev);
                        if(k == i) continue;
                        res.add(Arrays.asList(i,k));
                    }
                }
            }
        }
        return res;
    }
}
