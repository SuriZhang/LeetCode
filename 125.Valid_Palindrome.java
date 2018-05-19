class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
        if(s.length() == 0 || s == null || s.length() == 1) return true;
        System.out.println(s);
        int i = 0; 
        int j = s.length() -1;
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }
}
