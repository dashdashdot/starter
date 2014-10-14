package org.gnw.exifreader.render;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides renderers.
 * 
 * @author Gerard Whitehead
 *
 */
public class RendererFactory {

    private final Map<String, ExifRenderer> renderers;

    /**
     * Default constructor.
     */
    public RendererFactory() {
        super();
        this.renderers = new HashMap<String, ExifRenderer>();
        addRenderer(new CsvRenderer());
        addRenderer(new TextRenderer());
        addRenderer(new XmlRenderer());
    }

    private void addRenderer(final ExifRenderer renderer) {
        this.renderers.put(renderer.getName().toUpperCase(), renderer);
    }

    /**
     * Provide a renderer, typically CSV, TEXT or XML.
     * 
     * @param name
     *            The name of the renderer.
     * @return A renderer.
     */
    public final ExifRenderer getRenderer(final String name) {
        return this.renderers.get(name);
    }

    /**
     * Checks to see if a renderer exists.
     * 
     * @param name
     *            The name of the renderer
     * @return True if it does
     */
    public final boolean hasRenderer(final String name) {
        return this.renderers.containsKey(name.toUpperCase());
    }

    /**
     * Returns a comma-delim string of the available renderers.
     */
    public final String toString() {
        StringBuilder b = new StringBuilder();
        String[] keys = new String[this.renderers.size()];
        this.renderers.keySet().toArray(keys);
        b.append(keys[0]);
        for (int i = 1; i < keys.length; i++) {
            b.append(", ");
            b.append(keys[i]);
        }
        return b.toString();
    }
}
