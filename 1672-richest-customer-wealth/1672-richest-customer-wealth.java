class Solution {
    public int maximumWealth(int[][] accounts) {
        int maximumWealth = 0;
        
        for(int i = 0; i< accounts.length; i++) {
            int sumOfWealth = 0;
            for(int j = 0; j< accounts[i].length; j++) {
                sumOfWealth += accounts[i][j];
            }
            maximumWealth = sumOfWealth > maximumWealth ? sumOfWealth : maximumWealth;
        }
        return maximumWealth;
        
    }
}