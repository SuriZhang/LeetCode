// first submission: failed on overflow
class Solution {
    private Integer toInt(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            res = res * 10 + ch - '0';
        }
        return res;
    }
    
    public String multiply(String num1, String num2) {
        int n1 = toInt(num1);
        int n2 = toInt(num2);
        return String.valueOf(n1*n2);
    }
}

// from grade school multiplication
/*
intput: num1 = "123" num2 = "45"
	1 2 3 <--- i
     x	  4 5 <--- j
     ----------
  [ 0 0 6 1 5] <--- loop when j = 1
  [ 0 4 9 2 0] <--- loop when j = 0
-------------- 
    0 5 5 3 5  <--- StringBuilder then reverse and return (remove leading 0)
output:"5535" 
*/
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int level = num2.length();
        int carry = 0;
        int maxSize = num1.length()+level;
        List<List<Integer>> all = new ArrayList();
        StringBuilder product = new StringBuilder(maxSize);
        for(int j = num2.length() - 1; j >= 0; --j) {
            List<Integer> temp = new ArrayList<Integer>(Collections.nCopies(maxSize, 0));
            int n2 = num2.charAt(j) - '0';
            int i = num1.length() - 1;
            while(i >= 0){ // from right to left
                int n1 = num1.charAt(i) - '0';
                // use SET not ADD here! be careful with index!
                temp.set(i+j+1, (carry + n1 * n2) % 10);
                carry = (carry + n1 * n2) / 10;
                i--;
            }
            if(carry!= 0) temp.set(i+j+1, carry);
            all.add(temp);
            // REMEMBER TO RESET carry!
            carry = 0;
        }
            
        carry = 0;
        for(int i = maxSize-1; i >= 0; --i) {
            int sum = carry;
            for(int j = 0; j < all.size(); ++j) {
                // System.out.println("i = " + i + " " + "j = " + j);
                // System.out.println("all.get(j).get(i) = " + all.get(j).get(i));
                sum += all.get(j).get(i);
            }
            carry = sum / 10;
            sum = sum % 10;
            product.append(String.valueOf(sum));
        }
        if(carry != 0) product.append(carry);
        String ret = product.reverse().toString();
        for(int i = 0; i < ret.length(); ++i){
            if(ret.charAt(i) != '0'){
               ret = ret.substring(i);
                break;
            }
        }
        return ret; 
    }
}

