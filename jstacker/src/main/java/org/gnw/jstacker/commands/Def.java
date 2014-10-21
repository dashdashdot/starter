package org.gnw.jstacker.commands;

import java.util.Map;

import org.gnw.jstacker.ParserException;
import org.gnw.jstacker.Stack;

public class Def implements Command {

    public String getName() {
        return "def";
    }

    public void run(Stack stack, Map<String, String> heap) throws ParserException {
        String name = stack.pop();
        String value = stack.pop();
        heap.put(name, value);
    }

    public int minStackSize() {
        return 2;
    }

}
