public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){ // loop over the given digits
			int x = Character.getNumericValue(digits.charAt(i)); // get current digit e.g. 2
			while(ans.peek().length()==i){ // as you are adding and popping values to/from ans list at the same time, you need the check to prevent you from falling into dead loop.
				String t = ans.remove(); 
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
// Solution from discussion, using BFS

// my solution 
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> comb = new ArrayList<>();
        if(digits == null || digits.isEmpty()) {
                return comb;
            }
        else {
            comb.add("");
            for(int i = 0; i < digits.length(); ++i){

                for(int k = 0; k < comb.size(); ){
                    String temp = comb.get(k);

                    comb.remove(temp);

                    int index = Integer.valueOf(digits.charAt(i) - '0');
                    for(int j = 0; j < mapping[index].length(); ++j){

                        comb.add(k, temp + mapping[index].charAt(j));
                        ++k;
                    }
                }
            }
            return comb;
        }
    }
}
