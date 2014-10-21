package org.gnw.jstacker.commands;

import java.util.Map;

import org.gnw.jstacker.ParserException;
import org.gnw.jstacker.Stack;

public interface Command {

    /**
     * The name of the command. For example 'pop', 'add', etc.
     * 
     * @return A name.
     */
    public String getName();

    /**
     * Perform the commands operation.
     * 
     * @param stack
     *            The current stack
     * @param heap
     *            The current heap
     * @throws ParserException
     *             Thrown if the command can't be run for any reason.
     */
    public void run(Stack stack, Map<String, String> heap) throws ParserException;

    /**
     * All implementing classes must state what the minimum stack size they can
     * operate on. For instance the arithmetic commands such as add and sub must
     * have a minimum of 2 items on the stack.
     * 
     * @return
     */
    public int minStackSize();
}
