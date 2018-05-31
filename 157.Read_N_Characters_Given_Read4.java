/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        char[] temp = new char[4];
        int total = 0;
        while(true) {
            count = read4(temp);
            for(int i = 0; i < count; ++i) {
                if(total == n) return total;
                buf[total++] = temp[i];
            }
            if(count < 4) return total;
        }
    }
}
