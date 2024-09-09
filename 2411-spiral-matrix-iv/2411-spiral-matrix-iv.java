/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int currentDir = 0;
    int[] currentIdx = { 0, 0 };
    int tempX = 0, tempY =0;

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] answer = new int[m][n];
        // init Array
        for (int[] rows : answer) {
            Arrays.fill(rows, -1);
        }
        

        while (head != null) {
            // put into currentVal
            answer[currentIdx[0]][currentIdx[1]] = head.val;
            head = head.next;
            if (currentDir == 0) { // right                
                tempX = directions[currentDir][1] + currentIdx[1];
                if(tempX == n || answer[currentIdx[0]][tempX] != -1) {
                    // turn clockWise
                    currentDir = (currentDir +1) % 4;
                }
            } else if (currentDir == 1) { // down
                tempY = directions[currentDir][0] + currentIdx[0];
                if(tempY == m || answer[tempY][currentIdx[1]] != -1) {
                    currentDir = (currentDir +1) %4;
                }
            } else if (currentDir == 2) { // left
                tempX = directions[currentDir][1] + currentIdx[1];
                if(tempX <0 || answer[currentIdx[0]][tempX] != -1) {
                    currentDir = (currentDir + 1) %4;
                }

            } else if (currentDir == 3) { // up
                tempY = directions[currentDir][0] + currentIdx[0];
                if(tempY < 0 || answer[tempY][currentIdx[1]] != -1) {
                    currentDir = (currentDir + 1) %4;
                }
            }
            calcNextIndex();
        }
        return answer;
    }

    public void calcNextIndex() {
        currentIdx[0] = currentIdx[0] + directions[currentDir][0];
        currentIdx[1] = currentIdx[1] + directions[currentDir][1];
    }

}