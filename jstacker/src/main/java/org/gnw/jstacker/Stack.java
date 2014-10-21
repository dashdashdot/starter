package org.gnw.jstacker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * This is essentially the standard double-ended queue with some convenience
 * methods to limit it to being a LIFO stack.
 * 
 * @author Gerard Whitehead
 *
 */
public class Stack {

    private final Deque<String> stack;

    /**
     * Default constructor.
     */
    public Stack() {
        super();
        this.stack = new ArrayDeque<String>();
    }

    /**
     * Add an item onto the stack.
     * 
     * @param item
     *            A new item
     */
    public void push(String item) {
        this.stack.addFirst(item);
    }

    /**
     * Take the uppermost item off the stack.
     * 
     * @return The most recently added item.
     */
    public String pop() {
        return this.stack.removeFirst();
    }

    /**
     * Take the uppermost item off the stack and convert it to a double.
     * 
     * @return The most recently added item.
     * @throws ParserException
     *             Thrown if the item cannot be converted into a double.
     */
    public double popDouble() throws ParserException {
        if (stack.size() == 0) {
            throw new ParserException("Cannot perform command, the stack is empty");
        }
        String s = this.stack.removeFirst();
        try {
            return Double.valueOf(s);
        } catch (Exception e) {
            throw new ParserException("Could not convert stack entry into a number.  Found: " + s);
        }
    }

    /**
     * Take a look at the top-most item without removing it.
     * 
     * @return The top-most item.
     */
    public String peek() {
        return this.stack.peekFirst();
    }

    /**
     * Returns the size of the stack.
     * 
     * @return Number of objects in the stack.
     */
    public int size() {
        return this.stack.size();
    }

    /**
     * Clear down the stack.
     */
    public void clear() {
        this.stack.clear();
    }

    /**
     * Returns an array containing all the elements in the stack without
     * altering the stack.
     * 
     * @return An array.
     */
    public String[] toArray() {
        String[] output = new String[this.size()];
        this.stack.toArray(output);
        return output;
    }

    /**
     * String representation of the stack.
     */
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
