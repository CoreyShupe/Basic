package Organizer;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;

/**
 * @Author Aidan Stewart
 * @Year 2019
 * Copyright (c)
 * All rights reserved.
 */
public class Organizer {
    private String rootDirectory;
    private File[] files;
    private ToggleGroup organizationMethod;
    private TextArea loggingArea;

    public Organizer(String root, ToggleGroup organizationMethod, TextArea loggingArea) {
        this.rootDirectory = root + File.separator + "Organizer" + File.separator;
        this.organizationMethod = organizationMethod;
        this.loggingArea = loggingArea;
        files = new File(root).listFiles();
    }

    public void Organize() {
        loggingArea.setText("");
        for (File file : files) {
            if (!file.isDirectory()) {
                tryToCreateDirectory(file);
                tryToMoveFile(file);
            }
        }
        loggingArea.setText(loggingArea.getText() + "end.");
    }

    private void tryToMoveFile(File file) {
        try {
            moveFile(file);
        } catch (IOException e) {
            loggingArea.setText(loggingArea.getText() + file.getName() + " has not been moved due to " + e + "\n");
            e.printStackTrace();
        }
    }

    private void moveFile(File file) throws IOException {
        Files.move(Paths.get(String.valueOf(file)),
                Paths.get(tryToGetDirectory(file) + File.separator + file.getName()),
                StandardCopyOption.REPLACE_EXISTING);
        loggingArea.setText(loggingArea.getText() + file.getName() + " has been moved!" + "\n");
    }

    private void tryToCreateDirectory(File file) {
        try {
            createDirectory(file);
        } catch (IOException e) {
            loggingArea.setText(loggingArea.getText() + "A directory could not be created due to " + e + "\n");
            e.printStackTrace();
        }
    }

    private void createDirectory(File file) throws IOException {
        Path directory = getDirectory(file).toPath();
        if (!directory.toFile().exists()) {
            Files.createDirectories(getDirectory(file).toPath());
            loggingArea.setText(loggingArea.getText() + directory.getFileName() + " directory has been created!" + "\n");
        }
    }

    private File tryToGetDirectory(File file){
        try {
            return getDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private File getDirectory(File file) throws IOException {
        RadioButton selectedRadioButton = (RadioButton) organizationMethod.getSelectedToggle();
        BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        SimpleDateFormat dtf = new SimpleDateFormat("MM-dd-yyyy");
        String toggleGroupValue = selectedRadioButton.getText();
        String fileDir = null;
        switch (toggleGroupValue) {
            case "Type":
                fileDir = FilenameUtils.getExtension(String.valueOf(file));
                break;
            case "Size":
                fileDir = fileSize(file.length());
                break;
            case "Date Created":
                fileDir = dtf.format(attr.creationTime().toMillis());
                break;
            case "Date Modified":
                fileDir = dtf.format(attr.lastModifiedTime().toMillis());
                break;
            case "First Letter":
                fileDir = file.getName().substring(0, 1).toUpperCase();
                break;
        }
        return new File(rootDirectory + fileDir);
    }


    private String fileSize(final long value) {
        final long K = 1024;
        final long M = K * K;
        final long G = M * K;
        final long T = G * K;
        final long[] dividers = new long[]{T, G, M, K, 1};
        final String[] units = new String[]{"TB", "GB", "MB", "KB", "B"};
        if (value < 1)
            return "Less then 1 KB";
        String result = null;
        for (int i = 0; i < dividers.length; i++) {
            final long divider = dividers[i];
            if (value >= divider) {
                result = format(value, divider, units[i]);
                break;
            }
        }
        return result;
    }

    private String format(long value, long divider, String unit){
        final double result =
                divider > 1 ? (double) value / (double) divider : (double) value;
        return String.format("%.1f %s", result, unit);
    }
}
