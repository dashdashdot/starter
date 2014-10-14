package org.gnw.exifreader.render;

import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

/**
 * A very simple XML renderer.
 * 
 * @author Gerard Whitehead
 *
 */
public class XmlRenderer extends ExifRenderer {

    public final void render(final Metadata meta) {

        System.out.println("<metadata>");

        for (Directory dir : meta.getDirectories()) {

            System.out.println("    <directory>");
            System.out.print("        <name>");
            System.out.print(escape(dir.getName()));
            System.out.println("</name>");

            for (Tag tag : dir.getTags()) {
                System.out.println("        <tag>");
                System.out.print("            <name>");
                System.out.print(escape(tag.getTagName()));
                System.out.println("</name>");
                System.out.print("            <description>");
                System.out.print(escape(tag.getDescription()));
                System.out.println("</description>");
                System.out.println("        </tag>");
            }

            System.out.println("    </directory>");
        }

        System.out.println("</metadata>");
    }

    private String escape(final String input) {
        String output = replace(input, "<", "&lt;");
        return replace(output, ">", "&gt;");
    }

    @Override
    public final String getName() {
        return "XML";
    }

}
