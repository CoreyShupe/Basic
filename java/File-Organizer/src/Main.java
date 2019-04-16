import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @Author Aidan Stewart
 * @Year 2019
 * Copyright (c)
 * All rights reserved.
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("GUI/OrganizerGUI.fxml")));
            stage.setScene(new Scene(root));
            stage.setTitle("Organizer");
            stage.setResizable(false);
            stage.show();
            stage.setOnCloseRequest(t -> Platform.exit());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
