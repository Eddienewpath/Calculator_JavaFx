import java.util.ArrayDeque;

class Calculator {
    private static ArrayDeque<Float> numberStack = new ArrayDeque<>();
    private static ArrayDeque<Character> operatorStack = new ArrayDeque<>();

    static String calculateExpression(String expression) {

        int idx = lookAhead(expression, 0);
        numberStack.push(Float.parseFloat(expression.substring(0,idx)));
        operatorStack.push(expression.charAt(idx));
        idx++;

        while (!operatorStack.isEmpty()) {

            while(idx < expression.length()) {
                char cur = expression.charAt(idx);
                if ('0' <= cur && cur <= '9') {
                    int endIdx = lookAhead(expression, idx);
                    numberStack.push(Float.parseFloat(expression.substring(idx,endIdx)));
                    idx = endIdx;
                }

                else if (operatorStack.peek() != null && precedence(cur) <= precedence(operatorStack.peek())) {
                    numberStack.push(calculator());
                }

                else {
                    operatorStack.push(cur);
                    idx++;
                }
            }
            numberStack.push(calculator());
        }

        return String.valueOf(numberStack.pop());
    }

    private static int precedence(char curOperator){
        if(curOperator == '*' || curOperator == '/')
            return 1;
        else
            return 0;
    }

    private static float calculator(){

        char oper = operatorStack.pop();
        float o1  = numberStack.pop();
        float o2  = numberStack.pop();

        switch (oper){
            case '+':
                return o1 + o2;
            case '-':
                return o2 - o1;
            case '*':
                return o1 * o2;
            case '/':
                return o2 / o1;
        }
        return 0;
    }

    private static int lookAhead(String expr, int start){
        while(expr.charAt(start) <= '9' && expr.charAt(start) >= '0' || expr.charAt(start) == '.'){
            start++;

            if(start > expr.length()-1)
                break;
        }
        return start;
    }


    static float squareRoot(float operand){
        return (float) Math.sqrt(operand);
    }

    static float percent(float operand){
        return operand / 100;
    }

}
