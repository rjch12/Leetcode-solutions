package com.leetcode.problems;

import java.util.Stack;

public class rpn_150 {
    public static void main(String[] args) {
        rpn_150 rpn = new rpn_150();
        System.out.println(rpn.evalRPN(new String[] { "2", "1", "+", "3", "*" }));
        // System.out.println(rpn.evalRPN(new String[] { "4", "13", "5", "/", "+" }));
        // System.out.println(rpn.evalRPN(new String[] {
        // "10","6","9","3","+","-11","*","/","*","17","+","5","+" }));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int op1, op2;

        for (String rpn : tokens) {
            switch (rpn) {
                case "+":
                    op1 = st.pop();
                    op2 = st.pop();

                    st.push(op2 + op1);
                    break;
                case "-":
                    op1 = st.pop();
                    op2 = st.pop();
                    st.push(op2 - op1);
                    break;
                case "*":
                    op1 = st.pop();
                    op2 = st.pop();
                    st.push(op2 * op1);
                    break;
                case "/":
                    op1 = st.pop();
                    op2 = st.pop();
                    st.push(op2 / op1);
                    break;
                default:
                    int s = Integer.parseInt(rpn);
                    st.push(s);
            }
        }
        return st.pop();
    }
}
