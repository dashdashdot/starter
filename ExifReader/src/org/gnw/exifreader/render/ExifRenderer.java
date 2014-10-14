package org.gnw.exifreader.render;

import com.drew.metadata.Metadata;

/**
 * Standard interface for a EXIF directory renderer.
 * 
 * @author Gerard Whitehead
 *
 */
public abstract class ExifRenderer {

    /**
     * All children need to supply their name so it can be used in the command
     * line options. Examples are CSV and XML
     * 
     * @return The renderer name.
     */
    public abstract String getName();

    public abstract void render(Metadata meta);

    protected final String replace(final String input, final String os, final String ns) {
        if (input == null) {
            return null;
        }
        String source = input;
        int i = source.indexOf(os, 0);
        if (i >= 0) {
            char[] sourceArray = source.toCharArray();
            char[] nsArray = ns.toCharArray();
            int oLength = os.length();
            StringBuilder buf = new StringBuilder(sourceArray.length);
            buf.append(sourceArray, 0, i).append(nsArray);
            i += oLength;
            int j = i;
            // Replace all remaining instances of oldString with newString.
            while ((i = source.indexOf(os, i)) > 0) {
                buf.append(sourceArray, j, i - j).append(nsArray);
                i += oLength;
                j = i;
            }
            buf.append(sourceArray, j, sourceArray.length - j);
            source = buf.toString();
            buf.setLength(0);
        }
        return source;
    }

}
