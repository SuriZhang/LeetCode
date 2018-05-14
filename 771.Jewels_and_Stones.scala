object Solution {
    def numJewelsInStones(J: String, S: String): Int = {
        var sum = 0
        for(s <- S){
            if(J.contains(s)){
                sum += 1
            }
        }
            return sum
    }

}
