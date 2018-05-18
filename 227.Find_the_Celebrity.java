/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n == 0) return -1;
        int cbty = 0;
        // if knows(a, b) => a is not the celebrity
        for(int i = 1; i < n; ++i) { // n calls
            if(knows(cbty, i)) cbty = i; 
        }
        // the celebrity cannot be in range 0 ~ cbty-1 --> they all know at least one of the people in 0 ~ cbty-1
        // the celebrity cannot be greater than cbty --> otherwise cbty will be updated
        // cbty does not know poeple in range cbty+1 ~ n-1
        
        for(int i = 0; i < cbty; ++i) {
            // check if cbty knows anyone in range 0 ~ cbty-1
            // cbty knows anyone of them, return -1
            if(knows(cbty, i)) return -1;
        }
        
        for(int i = cbty+1; i < n; ++i) {
            // check that people in range cbty+1 ~ n-1 all knows cbty
            if(!knows(i, cbty)) return -1;
        }
        
        return cbty; // no such celebrity
    }
}


