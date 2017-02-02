package moe.tristan.jsh.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import lombok.extern.slf4j.Slf4j;
import moe.tristan.jsh.lang.FileUtils;

import java.io.IOException;
import java.nio.file.Path;

/**
 * FXML reading and managing is a nightmare of
 * counter-intuitive engineering.
 * Coupled with the extreme lack of care in the
 * design of SceneBuilder, we use these convenient
 * methods to load typical FXML files located in
 * {@link moe.tristan.jsh.view.views}.
 */
@Slf4j
public class DecentFXML {
    private static final FXMLLoader FXML_LOADER = new FXMLLoader();
    private static final String VIEWS_ROOT = "/moe/tristan/jsh/view/views/";

    /**
     * Loads a view using the shared {@link FXMLLoader} instance.
     *
     * @param viewFileName
     *         The name of the view file (i.e. RootViewController.fxml)
     * @param rootTypeClass
     *         The expected type's class. See parameter T
     * @param <T>
     *         The type to load. {@link Pane} should be the to-go type.
     * @return The view in the requested type. Compatible with JavaFX's APIs.
     * <p>
     * Stops after throwing an {@link IOException} if something wrong happened.
     */
    @SuppressWarnings("unchecked")
    public static <T> T loadView(final String viewFileName, final Class<T> rootTypeClass) {
        try {
            final Path viewPath = FileUtils.getPathOf(VIEWS_ROOT + viewFileName)
                    .orElseThrow(IOException::new);
            FXML_LOADER.setLocation(viewPath.toUri()
                                            .toURL());
            return FXML_LOADER.load();
        } catch (final IOException e) {
            log.error("There was an error processing the FXML file at {} !", e);
        }
        System.exit(2);
        return (T) new Pane();
    }
}
