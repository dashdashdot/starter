package org.gnw.exifreader.render;

import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

/**
 * A text renderer called TEXT which produces a visually pleasing text output.
 * 
 * @author Gerard Whitehead
 *
 */
public class TextRenderer extends ExifRenderer {

    public final void render(final Metadata meta) {
        for (Directory dir : meta.getDirectories()) {
            System.out.println("------------------------------------------");
            System.out.println(dir.getName());
            int max = TextRenderer.getMaxTagNameLength(dir) + 1;

            for (Tag tag : dir.getTags()) {
                System.out.print("    ");
                TextRenderer.printToLength(tag.getTagName(), max);
                System.out.print(": ");
                System.out.println(tag.getDescription());
            }
        }
    }

    private static int getMaxTagNameLength(final Directory dir) {
        int max = 0;
        for (Tag tag : dir.getTags()) {
            max = Math.max(max, tag.getTagName().length());
        }
        return max;
    }

    private static void printToLength(final String printString, final int lengthNeeded) {
        System.out.print(printString);
        for (int i = lengthNeeded - printString.length(); i > 0; i--) {
            System.out.print(" ");
        }
    }

    @Override
    public final String getName() {
        return "TEXT";
    }
}
