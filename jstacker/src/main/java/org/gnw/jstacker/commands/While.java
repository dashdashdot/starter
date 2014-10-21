package org.gnw.jstacker.commands;

import java.util.Map;

import org.gnw.jstacker.Parser;
import org.gnw.jstacker.ParserException;
import org.gnw.jstacker.Stack;

public class While implements Command {

    private final Parser     parser;
    private static final int MAX_LOOPS = 1000;

    public While(Parser parser) {
        super();
        this.parser = parser;
    }

    public String getName() {
        return "while";
    }

    public void run(Stack stack, Map<String, String> heap) throws ParserException {
        try {
            double i = Double.valueOf(stack.pop());
            String command = stack.pop();
            int n = 0;
            while (i > 0) {
                parser.parse(command);
                i = Double.valueOf(stack.pop());
                n++;
                if (n > MAX_LOOPS) {
                    throw new ParserException("The 'while' command looped more times than its maximum of " + MAX_LOOPS);
                }
            }
        } catch (NumberFormatException e) {
            throw new ParserException("The while command can only accept numbers for a condition");
        }
    }

    public int minStackSize() {
        return 2;
    }

}
