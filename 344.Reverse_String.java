class Solution {
    public String reverseString(String s) {
        StringBuilder str = new StringBuilder();
        str.append(s);
        str = str.reverse();
        return str.toString();
    }
}

// Alt. Soln:
// using 2 ptrs, swap start & end, can be in-place
