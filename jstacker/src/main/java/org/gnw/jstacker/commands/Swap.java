package org.gnw.jstacker.commands;

import java.util.Map;

import org.gnw.jstacker.ParserException;
import org.gnw.jstacker.Stack;

/**
 * Swaps the two top entries of the stack
 * 
 * @author Gerard Whitehead
 *
 */
public class Swap implements Command {

    public String getName() {
        return "swap";
    }

    public void run(Stack stack, Map<String, String> heap) throws ParserException {
        String item1 = stack.pop();
        String item2 = stack.pop();
        stack.push(item1);
        stack.push(item2);
    }

    public int minStackSize() {
        return 2;
    }

}
