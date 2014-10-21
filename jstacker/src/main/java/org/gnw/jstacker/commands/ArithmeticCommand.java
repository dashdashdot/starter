package org.gnw.jstacker.commands;

import org.gnw.jstacker.ParserException;
import org.gnw.jstacker.Stack;

public abstract class ArithmeticCommand implements Command {

    protected double popDouble(Stack stack) throws ParserException {
        if (stack.size() == 0) {
            throw new ParserException("Cannot perform command, the stack is empty");
        }
        String s = stack.pop();
        try {
            return Double.valueOf(s);
        } catch (Exception e) {
            throw new ParserException("Could not convert stack entry into a number.  Found: " + s);
        }
    }
}
