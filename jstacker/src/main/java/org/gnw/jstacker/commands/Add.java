package org.gnw.jstacker.commands;

import java.util.Map;

import org.gnw.jstacker.ParserException;
import org.gnw.jstacker.Stack;

public class Add extends ArithmeticCommand {

    public String getName() {
        return "add";
    }

    public void run(Stack stack, Map<String, String> heap) throws ParserException {
        double a = popDouble(stack);
        double b = popDouble(stack);
        stack.push(Double.toString(a + b));
    }

    public int minStackSize() {
        return 2;
    }
}
