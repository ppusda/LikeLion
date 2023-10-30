package org.study.operation;

public class Calc {

    static int run(String word) {
        String[] tmp = word.split(" ");
        int prefix =  Integer.parseInt(tmp[0]);
        int postfix = Integer.parseInt(tmp[2]);

        switch (tmp[1]){
            case "+":
                return prefix + postfix;
            case "*":
                return prefix * postfix;
            case "-":
                return prefix - postfix;
            case "/":
                return prefix /  postfix;
        }
        return -1;
    }
}
// word.substring(word.lastIndexOf("(")+1, word.indexOf(")")).split(" ");
