package moe.tristan.jsh.view;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import moe.tristan.jsh.model.Session;

/**
 * This class manages JavaFX GUI
 */
public class GUIManager extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    private static void setPrimaryStageProperties(final Stage primaryStage) {
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.initModality(Modality.NONE);
        primaryStage.setTitle(Session.getSession()
                                      .getCurrentTitle());
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        setPrimaryStageProperties(primaryStage);

        primaryStage.show();
    }
}
