/* failed case with hashSet impl:
 [1]
 [1,1]
*/

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        for(int i:nums1) list.add(i);
        for(int i:nums2){
            if(list.contains(i)){
                ret.add(i);
                list.remove(list.indexOf(i));
            }
        }
       int[] re = new int[ret.size()];
        for(int i=0;i<ret.size();i++){
            re[i]=ret.get(i);
        }
       return re;
    }
}
