class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalFuel = 0,tank = 0,start = 0;
        for(int i = 0; i < gas.length;i++){
            totalFuel += gas[i] - cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0){
                tank = 0;
                start = i + 1;
            }
        }
        if(totalFuel >= 0){
            return start;
        }
        return -1;
    }
}