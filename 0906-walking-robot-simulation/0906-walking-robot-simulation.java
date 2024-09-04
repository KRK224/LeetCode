class Solution {
    int dx = 0, dy = 1;
    int cx = 0, cy = 0, ty = 0, tx = 0;
    Map<Integer, List<Integer>> xParallelObjects = new HashMap<>();
    Map<Integer, List<Integer>> yParallelObjects = new HashMap<>();

    public int robotSim(int[] commands, int[][] obstacles) {
        int answer = 0;
        for (int[] object : obstacles) {
            // obstacles projection init
            List<Integer> yParallel = yParallelObjects.getOrDefault(object[0], new ArrayList<>());
            List<Integer> xParallel = xParallelObjects.getOrDefault(object[1], new ArrayList<>());
            yParallel.add(object[1]);
            xParallel.add(object[0]);
            yParallelObjects.put(object[0], yParallel);
            xParallelObjects.put(object[1], xParallel);
        }            

        for (int command : commands) {
            int temp = getDirectionAndMove(command);
            answer = answer > temp ? answer : temp;
        }
        return answer;
    }

    public int getDirectionAndMove(int command) {
        if (command == -1) {
            // System.out.println("Turn Right");
            // System.out.println("********");
            if (dx == 0) {
                dx = dy == 1 ? 1 : -1;
                dy = 0;
            } else {
                dy = dx == 1 ? -1 : 1;
                dx = 0;
            }

        } else if (command == -2) {
            // System.out.println("Turn Left");
            // System.out.println("********");
            if (dx == 0) {
                dx = dy == 1 ? -1 : 1;
                dy = 0;
            } else {
                dy = dx == 1 ? 1 : -1;
                dx = 0;
            }
        } else {
            move(command);
        }
        return cx * cx + cy * cy;
    }

    public void move(int steps) {
        System.out.println("before :: cx = " + cx + ", cy = " + cy);
        if (dx == 0) {
            // dy로 움직인다.
            ty = steps * dy + cy;
            System.out.println("ty = " + ty + ", steps*dy = " + steps*dy);
            List<Integer> yParallels = yParallelObjects.get(cx);
            if (yParallels == null) {
                System.out.println("yParallels is empty!");
            } else if (dy < 0) {
                yParallels.stream().forEach(py -> System.out.print(py+","));
                System.out.println();
                yParallels.stream().filter(py -> (py >= ty && py < cy)).forEach(py -> {
                    System.out.println("filter obstacle y: " + py);
                    if (py >= ty) {
                        System.out.println("Blocked!!");
                        ty = py + 1;
                    }
                        
                });
            } else {
                // yParallels.stream().forEach(py -> System.out.print(py+","));
                // System.out.println();
                yParallels.stream().filter(py -> py <= ty && py > cy).forEach(py -> {
                    // System.out.println("filter obstacle y: " + py);
                    if (py <= ty){
                        // System.out.println("Blocked!!");
                        ty = py - 1;
                    }
                        
                });
            }
        } else {
            // x축에 평행하게 움직인다.
            tx = steps * dx + cx;
            // x축과 평행한 장애물들 모음
            // System.out.println("tx = " + tx + ", steps*dx = " + steps*dx);
            List<Integer> xParallels = xParallelObjects.get(cy);
            if (xParallels == null) {
                // System.out.println("xParallels is empty!");
            } else if (dx < 0) {
                // xParallels.stream().forEach(px -> System.out.print(px));
                // System.out.println();
                // tx 보정
                xParallels.stream().filter(px -> px >= tx && px < cx).forEach(px -> {
                    // System.out.println("filter obstacle x: " + px);
                    if (px >= tx) {
                        // System.out.println("Blocked!!");
                        tx = px + 1;
                    }
                        
                });
            } else {
                // xParallels.stream().forEach(px -> System.out.print(px+","));
                // System.out.println();
                xParallels.stream().filter(px -> px <= tx && px > cx).forEach(px -> {
                    // System.out.println("filter obstacle x: " + px);
                    if (px <= tx){
                        // System.out.println("Blocked!!");
                        tx = px - 1;
                    }
                        
                });
            }

        }
        cx = tx;
        cy = ty;
        // System.out.println("after:: cx = " + cx + ", cy = " + cy);
        // System.out.println("====================");
    }
}