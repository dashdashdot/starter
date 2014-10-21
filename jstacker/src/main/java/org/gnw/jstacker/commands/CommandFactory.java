package org.gnw.jstacker.commands;

import java.util.HashMap;
import java.util.Map;

import org.gnw.jstacker.Parser;

public class CommandFactory {

    private final Map<String, Command> commands = new HashMap<String, Command>();

    public CommandFactory(final Parser parser) {
        add(new Pop());
        add(new Sub());
        add(new Add());
        add(new Div());
        add(new Mult());
        add(new Swap());
        add(new Rev());
        add(new Def());
        add(new Dup());
        add(new While(parser));
        add(new Clear());
    }

    public Map<String, Command> getCommands(final Parser parser) {
        return commands;
    }

    private void add(final Command command) {
        commands.put(command.getName(), command);
    }

    /**
     * Check to see if a command exists.
     * 
     * @param name
     *            The name of the command.
     * @return True if it exists.
     */
    public boolean has(final String name) {
        return this.commands.containsKey(name);
    }

    public Command get(final String name) {
        return this.commands.get(name);
    }
}
