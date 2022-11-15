package me.nerminsehic;

import me.nerminsehic.item29.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for(String arg: args)
            stack.push(arg);

        while(!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());

    }
}