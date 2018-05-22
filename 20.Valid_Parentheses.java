class Solution {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : array) {
            if(c == '{') stack.push('}');
            else if(c == '(') stack.push(')');
            else if(c == '[') stack.push(']');
            else if(stack.isEmpty() || stack.pop() != c) return false;
        }
            return stack.isEmpty();
    }
}
