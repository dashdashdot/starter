package org.gnw.jstacker.commands;

import java.util.Map;

import org.gnw.jstacker.ParserException;
import org.gnw.jstacker.Stack;

public class Dup implements Command {

    public String getName() {
        return "dup";
    }

    public void run(Stack stack, Map<String, String> heap) throws ParserException {
        String x = stack.peek();
        stack.push(x);
    }

    public int minStackSize() {
        return 1;
    }

}
