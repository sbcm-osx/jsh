package moe.tristan.jsh.lang;

import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * Some complementary {@link Files}-related methods
 * to get our hands on files in a cleaner way in the
 * already-loaded parts of the application that do
 * not need complexification from random quirks in
 * the I/O APIs.
 */
@Slf4j
public class FileUtils {
    /**
     * Gets the path of a resource that is on the classpath.
     *
     * @param filePath
     *         File path of the resource. Relative to the project's root folder {@link moe} in the case of this project.
     *         (i.e. "moe/tristan/.../somefile.extension")
     * @return The gracefully retrieved File.
     */
    public static Optional<Path> getPathOf(final String filePath) {
        final URL resourceUrl = FileUtils.class.getClassLoader()
                .getResource(filePath);
        if (resourceUrl == null) {
            log.warn("Could not access the resource at path : " + filePath);
            return Optional.empty();
        }

        try {
            final URI resourceUri = resourceUrl.toURI();
            return Optional.of(Paths.get(resourceUri));
        } catch (final URISyntaxException e) {
            log.error(
                    "An unexpected error was thrown while converting URL to URI for file at path {}\n Error log : ",
                    filePath,
                    e
            );
            return Optional.empty();
        }
    }
}
