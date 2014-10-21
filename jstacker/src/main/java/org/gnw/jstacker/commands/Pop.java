package org.gnw.jstacker.commands;

import java.util.Map;

import org.gnw.jstacker.ParserException;
import org.gnw.jstacker.Stack;

public class Pop implements Command {

    public String getName() {
        return "pop";
    }

    public void run(Stack stack, Map<String, String> heap) throws ParserException {
        if (stack.size() > 0) {
            stack.pop();
        }
    }

    public int minStackSize() {
        return 0;
    }
}
