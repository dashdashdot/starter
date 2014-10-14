package org.gnw.exifreader;

import java.io.File;
import java.io.IOException;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.gnw.exifreader.render.ExifRenderer;
import org.gnw.exifreader.render.RendererFactory;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;

/**
 * An EXIF reader.
 * @author Gerard Whitehead
 *
 */
public class Reader {

    private RendererFactory renderers;

    public Reader() {
        super();
        this.renderers = new RendererFactory();
    }

    /**
     * Read the files off the command line and render them in the required output format.
     * @param line The command line.
     */
    public final void render(final CommandLine line) {
        // First work out which output rendering format we're going to use.
        ExifRenderer renderer = getRenderer(line);

        // Now read the files.
        for (String fileName : line.getArgs()) {
            File file = new File(fileName);
            try {
                Metadata meta = ImageMetadataReader.readMetadata(file);
                renderer.render(meta);
            } catch (ImageProcessingException e) {
                System.out.println("Couldn't extract EXIF metadata from file");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Problem reading file");
                e.printStackTrace();
            }
        }
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {

        Reader reader = new Reader();
        CommandLineParser parser = new BasicParser();
        Options options = reader.getOptions();

        try {
            CommandLine line = parser.parse(options, args);
            reader.render(line);

        } catch (ParseException e) {
            System.out.println("Couldn't understand command line arguments");
            HelpFormatter help = new HelpFormatter();
            help.printHelp("reader", options, true);
        }
    }

    private ExifRenderer getRenderer(final CommandLine line) {
        // Default behaviour is the text renderer
        ExifRenderer renderer = this.renderers.getRenderer("TEXT");
        // But check the command line options
        if (line.hasOption("format")) {
            String format = line.getOptionValue("format").toUpperCase();
            if (renderers.hasRenderer(format)) {
                renderer = renderers.getRenderer(format);
            }
        }
        return renderer;
    }

    @SuppressWarnings("static-access")
    private Options getOptions() {

        Option format = OptionBuilder
                .withArgName("format")
                .isRequired(false)
                .hasArgs(1)
                .withDescription(
                        "Optional output format: " + this.renderers.toString())
                .create("format");

        return new Options().addOption(format);
    }

}
