class Solution {
    public List<String> buildArray(int[] target, int n) {
        int count = 1;
        List<String> list = new ArrayList<>();
        for (int i = 0;i < target.length;){
            if(count == target[i]){
                list.add("Push");
                i++;
            }
            else {
                list.add("Push");
                list.add("Pop");
            }
            count++;
        }
        return list;
    }
}