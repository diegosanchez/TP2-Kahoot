package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.SystemInfo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AboutViewController {

    @FXML
    public Label title;
    @FXML
    public Label course;
    @FXML
    public Label list;
    @FXML
    public Label software;

    public void initialize() {
        title.setText(SystemInfo.title());
        course.setText(SystemInfo.course());
        list.setText(SystemInfo.lista());
        software.setText(SystemInfo.software());
    }
}
