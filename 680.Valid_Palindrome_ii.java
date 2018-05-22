class Solution {
    private boolean isPalindrome(String s, int i, int j) {
        if(s.length() == 0 || s == null || s.length() == 1) return true;
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        for(int i = 0; i < s.length()/2; ++i) {
            int j = s.length()-1-i; 
            if(s.charAt(i) != s.charAt(j)){
               return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }
        }
        return true;
    }
}
