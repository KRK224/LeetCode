class Solution {
    public double averageWaitingTime(int[][] customers) {
        int customerNum = customers.length;
        double totalWaitingTime = 0;
        double currentTime = 0;
        for (int i = 0; i< customerNum; i++) {
            if(currentTime < customers[i][0]) {
                currentTime = customers[i][0];
            }
            currentTime += customers[i][1];
            totalWaitingTime += currentTime - customers[i][0];
        }
        return totalWaitingTime/customerNum;
    }
}