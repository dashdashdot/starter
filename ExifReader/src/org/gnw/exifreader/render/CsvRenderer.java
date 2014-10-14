package org.gnw.exifreader.render;

import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

/**
 * A text renderer called CSV producing three comma delimited columns: directory, tag, value.
 * 
 * @author Gerard Whitehead
 *
 */
public class CsvRenderer extends ExifRenderer {

    public final void render(final Metadata meta) {
        System.out.println("directory,tag,value");
        for (Directory dir : meta.getDirectories()) {
            for (Tag tag : dir.getTags()) {
                System.out.print(escape(dir.getName()));
                System.out.print(",");
                System.out.print(escape(tag.getTagName()));
                System.out.print(",");
                System.out.println(escape(tag.getDescription()));
            }
        }
    }

    private String escape(final String input) {
        if (input.indexOf(",") != -1) {
            StringBuilder builder = new StringBuilder();
            builder.append("\"");
            builder.append(replaceQuotes(input));
            builder.append("\"");
            return builder.toString();
        } else {
            return replaceQuotes(input);
        }
    }

    private String replaceQuotes(final String input) {
        return replace(input, "\"", "\\\"");
    }

    @Override
    public final String getName() {
        return "CSV";
    }
}
