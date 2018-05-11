public class LongestPalinSubstring
{
    // This function prints the longest palindrome substring 
    // (LPS) of str[]. It also returns the length of the  
    // longest palindrome 
    // O(n^2) time complexity, O(1) extra space
    static int longestPalSubstr1(String str) {
        int maxLength = 1; // The result (length of LPS)
 
        int start = 0;
        int len = str.length();
 
        int low, high;
 
        // One by one consider every character as center
        // point of even and length palindromes
        for (int i = 1; i < len; ++i) 
        {
            // Find the longest even length palindrome with 
            // center points as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
 
            // Find the longest odd length palindrome with 
            // center point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }
 
        System.out.print("Longest palindrome substring is: ");
        printSubStr(str, start, start + maxLength - 1);
 
        return maxLength;
    }
}


class Solution {
    // modified solution for leetcode question
    public String longestPalindrome(String s) {
        int maxlen = 1;
        int len = s.length();
        int start = 0;
        int lo, hi;
        String res = s.substring(0,1);
        
        // if(len == 1){ // special case when len = 1
        //     res = s;
        //     return res;
        // }
        
        // set the center of cmp at index i, start from 1
        for(int i = 1; i < len; ++i) {
            // check for even len palindromes
            lo = i - 1;
            hi = i;
            while(lo >= 0 && hi < len && s.charAt(lo) == s.charAt(hi)){
                if(hi - lo + 1 > maxlen) {
                    start = lo;
                    maxlen = hi - lo + 1;
                    res = s.substring(lo, hi+1);
                }
                --lo;
                ++hi;
            }
            // check for odd len palindromes
            lo = i - 1;
            hi = i + 1;
            while(lo >= 0 && hi < len && s.charAt(lo) == s.charAt(hi)) {
                if(hi - lo + 1 > maxlen){
                    start = lo;
                    maxlen = hi - lo + 1;
                    res = s.substring(lo, hi+1);
                }
                --lo;
                ++hi;
            }
        }
        return res;
    }
}
