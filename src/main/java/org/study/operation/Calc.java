package org.study.operation;

public class Calc {

    static int run(String exp) {
        if(exp.isBlank()) return 0;

        exp = processBracket(exp);

        String[] expBits = exp.split(" ");

        if(expBits.length > 1) {
            String operator = expBits[1];
            int prefix =  Integer.parseInt(expBits[0]);
            int postfix = Integer.parseInt(expBits[2]);

            return switch (operator){
                case "+":
                    yield prefix + postfix;
                case "*":
                    yield prefix * postfix;
                case "-":
                    yield prefix - postfix;
                case "/":
                    yield prefix /  postfix;
                default:
                    throw new IllegalStateException("Unexpected value: " + operator);
            };
        } else {
            return 0;
        }
    }

    static String processBracket(String exp) {
        if(exp.contains("(")) {
            return exp.substring(exp.lastIndexOf("(")+1, exp.indexOf(")"));
        }

        return exp;
    }
}

