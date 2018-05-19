class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        List<String> resList = new ArrayList();
        if(list1.length == 1) return new String[] {list1[0]};
        else if(list2.length == 1) return new String[] {list2[0]};
        for(int i = 0; i < list1.length; ++i) {
            map1.put(list1[i], i);
        }
        
        int index1, index2;
        int min = list1.length + list2.length;
        for(int i = 0; i < list2.length; ++i) {
            String s = list2[i];
            if(map1.containsKey(s)) { 
                index1 = map1.get(s);
                index2 = i;
                if(index1 + index2 < min) {
                    min = index1 + index2;
                    if(resList.isEmpty()) resList.add(s);
                    else {
                        resList.clear();
                        resList.add(s);
                    }
                } else if(index1 + index2 == min && !resList.isEmpty()) {
                    resList.add(s);
                }
            } 
        }
        return resList.toArray(new String[0]);
    }
}
