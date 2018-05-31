/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int tempPtr = 0;
    private int tempCnt = 0;
    private char[] temp = new char[4];
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (tempPtr == 0) {
                tempCnt = read4(temp);
            }
            if (tempCnt == 0) break;
            while (ptr < n && tempPtr < tempCnt) {
                buf[ptr++] = temp[tempPtr++];
            }
            if (tempPtr >= tempCnt) tempPtr = 0;
        }
        return ptr;
    }
}
