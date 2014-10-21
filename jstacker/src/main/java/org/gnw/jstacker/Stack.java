package org.gnw.jstacker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Stack {

    private final Deque<String> stack;

    public Stack() {
        super();
        this.stack = new ArrayDeque<String>();
    }

    public void push(String token) {
        this.stack.addFirst(token);
    }

    public String pop() {
        return this.stack.removeFirst();
    }

    public String peek() {
        return this.stack.peekFirst();
    }

    public int size() {
        return this.stack.size();
    }

    public void clear() {
        this.stack.clear();
    }

    public String[] toArray() {
        String[] output = new String[this.size()];
        this.stack.toArray(output);
        return output;
    }

    public String toString() {
        Iterator<String> i = stack.descendingIterator();
        StringBuilder output = new StringBuilder();
        boolean isFirst = true;
        while (i.hasNext()) {
            if (!isFirst) {
                output.append(" ");
            }
            output.append(clean(i.next()));
            isFirst = false;
        }
        return output.toString();
    }

    private String clean(String input) {
        if (input.indexOf(" ") != -1) {
            // There's a space - enclose it in quotes
            StringBuilder output = new StringBuilder();
            output.append("\"");
            output.append(input);
            output.append("\"");
            return output.toString();
        } else {
            return input;
        }
    }
}
