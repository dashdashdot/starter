package org.gnw.jstacker.commands;

import java.util.Map;

import org.gnw.jstacker.ParserException;
import org.gnw.jstacker.Stack;

public class Clear implements Command {

    public String getName() {
        return "clear";
    }

    public void run(Stack stack, Map<String, String> heap) throws ParserException {
        stack.clear();
    }

    public int minStackSize() {
        return 0;
    }

}
