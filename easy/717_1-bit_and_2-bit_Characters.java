class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        boolean lastBit = false;
        for(int i = 0; i < bits.length; ){
            if(bits[i] == 1){
                lastBit = false;
                i += 2;
            } else{
                lastBit = true;
                i += 1;
            }
        }
        return lastBit;
    }
}
