class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return computeExpression(0, expression.length(), expression);

    }

    public List<Integer> computeExpression(int start, int end, String expression) {
        List<Integer> result = new ArrayList<>();
        
        if (end - start == 1) {
            result.add(Integer.parseInt(expression.substring(start, end)));
            return result;
        } else if (end - start == 2) {
            if (Character.isDigit(expression.charAt(start))) {
                result.add(Integer.parseInt(expression.substring(start, end)));
                return result;
            }
        } else if (end - start == 0) {
            return result;
        }

        for(int i = start; i<end; i++) {
            if(Character.isDigit(expression.charAt(i)))
                continue;
            
            List<Integer> lefts = computeExpression(start, i, expression);
            List<Integer> rights = computeExpression(i+1, end, expression);

            char op = expression.charAt(i);
            switch(op) {
                case '+': {
                    for(Integer l : lefts) {
                        for(Integer r : rights) {
                            result.add(l + r);
                        }
                    }
                    break;
                }
                case '-': {
                    for(Integer l : lefts) {
                        for(Integer r: rights) {
                            result.add(l - r);
                        }
                    }
                    break;
                }
                case '*': {
                    for(Integer l : lefts) {
                        for(Integer r: rights) {
                            result.add(l * r);
                        }
                    }
                    break;
                }
            }
        }
        return result;
    }

}