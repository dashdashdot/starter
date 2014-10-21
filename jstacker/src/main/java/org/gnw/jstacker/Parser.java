package org.gnw.jstacker;

import java.util.HashMap;
import java.util.Map;

import org.gnw.jstacker.commands.Command;
import org.gnw.jstacker.commands.CommandFactory;

public class Parser {

    private final Stack               stack;
    private final Map<String, String> heap;
    private final CommandFactory      commands;

    public Parser() {
        super();
        this.stack = new Stack();
        this.heap = new HashMap<String, String>();
        this.commands = new CommandFactory(this);
    }

    public Stack parse(final String input) throws ParserException {
        String remaining = input.trim();
        while (remaining.length() > 0) {
            if ("(".equals(remaining.substring(0, 1))) {
                remaining = getEscapedToken(remaining, ")");
            } else if ("\"".equals(remaining.substring(0, 1))) {
                remaining = getEscapedToken(remaining, "\"");
            } else {
                int i = remaining.indexOf(" ");
                String token;
                if (i == -1) {
                    token = remaining;
                    remaining = "";
                } else {
                    token = remaining.substring(0, i);
                    remaining = remaining.substring(i + 1).trim();
                }
                handle(token);
            }
        }
        return this.stack;
    }

    private String getEscapedToken(String remaining, String closing) throws ParserException {
        int i = remaining.indexOf(closing, 1);
        if (i == -1) {
            throw new ParserException("Found a starting bracket/quote with no end.");
        }
        String token = remaining.substring(1, i);
        stack.push(token);
        return remaining.substring(i + 1).trim();
    }

    /**
     * Clear down the stack and heap.
     */
    public void clear() {
        this.stack.clear();
        this.heap.clear();
    }

    public Map<String, String> getHeap() {
        return this.heap;
    }

    public Stack getStack() {
        return this.stack;
    }

    private void handle(String token) throws ParserException {
        // First check to see if it's a command
        if (commands.has(token)) {
            Command command = commands.get(token);
            if (stack.size() < command.minStackSize()) {
                throw new ParserException("Not enough items on the stack.  The '" + token + "' command needs "
                        + command.minStackSize() + " items, found " + stack.size());
            }
            commands.get(token).run(stack, heap);
        } else {
            // Now check to see if it's something defined in the heap
            if (heap.containsKey(token)) {
                stack.push(heap.get(token));
            } else {
                // Anything unrecognised just gets added to the stack
                stack.push(token);
            }
        }
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Stack: ").append(this.stack.toString()).append(System.lineSeparator());
        output.append("Heap : ").append(this.heap.toString());
        return output.toString();
    }
}
