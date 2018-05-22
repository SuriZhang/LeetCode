class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int temp = carry;
            int digit = 0;
            if (j >= 0) temp += b.charAt(j--) - '0';
            if (i >= 0) temp += a.charAt(i--) - '0';
            carry = temp / 2;
            sum.append(temp % 2);
        }
        if(carry != 0) sum.append(carry);
        return sum.reverse().toString();
    }
}
