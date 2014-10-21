package org.gnw.jstacker.commands;

import java.util.Map;

import org.gnw.jstacker.ParserException;
import org.gnw.jstacker.Stack;

/**
 * Reverses the contents of the stack.
 * 
 * @author Gerard Whitehead
 *
 */
public class Rev implements Command {

    public String getName() {
        return "rev";
    }

    public void run(Stack stack, Map<String, String> heap) throws ParserException {
        if (stack.size() > 0) {
            String[] tokens = stack.toArray();
            stack.clear();
            for (String token : tokens) {
                stack.push(token);
            }
        }
    }

    public int minStackSize() {
        return 0;
    }

}
