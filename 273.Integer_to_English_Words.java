class Solution {
    private final String[] TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
   
    private String helper(int num){
        if(num == 0) return "";
        else if(num < 20) return TWENTY[num] + " ";
        else if(num < 100) return TENS[num / 10] + " " + helper(num % 10);
        else if(num < 1000) return helper(num / 100) + "Hundred " + helper(num % 100);
        else if(num < 1000000) return helper(num / 1000) + "Thousand " + helper(num % 1000);
        else if(num < 1000000000) return helper(num / 1000000) + "Million " + helper(num % 1000000);
        else return helper(num / 1000000000) + "Billion " + helper(num % 1000000000);
    }
    
    public String numberToWords(int num) {
        String res = "";
        if(num == 0) {
            res = "Zero";
        } else res = helper(num);
        return res.trim();
    } 
}

// be careful with spaces, set it to be after each word, and trim the trailing spaces in the end before return.
