package GUI;

import Organizer.Organizer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author Aidan Stewart
 * @Year 2019
 * Copyright (c)
 * All rights reserved.
 */
public class GUIController implements Initializable {
    @FXML
    private TextField rootDirectory;
    @FXML
    private ToggleGroup organizationMethodRadioButtons;
    @FXML
    private TextArea loggingArea;
    private boolean isChooserOpen;

    @FXML
    private void openDirectoryFinder(){
        if (!isChooserOpen) {
            isChooserOpen = true;
            DirectoryChooser chooser = new DirectoryChooser();
            File dir = chooser.showDialog(new Stage());
            if (dir != null)
               rootDirectory.setText(String.valueOf(dir));
            isChooserOpen = false;
        }
    }

    @FXML
    private void organize() {
        new Organizer(rootDirectory.getText(), organizationMethodRadioButtons, loggingArea).Organize();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootDirectory.setText(System.getProperty("user.home") + File.separator + "Desktop");
    }
}
