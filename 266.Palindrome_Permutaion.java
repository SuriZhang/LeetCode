/* Hints:
 * Consider the palindromes of odd vs even length. What difference do you notice?
 * Count the frequency of each character.
 * If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
 */
class Solution {
    public boolean canPermutePalindrome(String s) {
        int len = s.length();
        if(len == 0 || len == 1) return true;
        boolean isOdd = len % 2 != 0 ? true : false;
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if(freq.containsKey(ch)){
                    // update freq
                    freq.put(ch, freq.get(ch)+1);
                } else {
                    freq.put(ch, 1);
                }
            }
        int count = 0;
        for(char key : freq.keySet()) {
            count += freq.get(key) % 2;
        }
        return count <= 1;
    }
}

