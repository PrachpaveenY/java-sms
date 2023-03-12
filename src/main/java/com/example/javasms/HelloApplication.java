package com.example.javasms;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    private TextField mTextReciever = new TextField();
    private Button mButtonContact = new Button("Nmae");
    private Button mButtonSend = new Button("Send");
    private Button mButtonAttach = new Button("Attach");
    private TextArea mTextMsg = new TextArea();
    private final int Max_LENGTH = 111;
    private Label mLabelTextLength = new Label("0/" + Max_LENGTH);

    @Override
    public void start(Stage stage) {
        mTextReciever.setPromptText("Recipient");
        mTextMsg.setPromptText("Text");
        mTextMsg.setPrefWidth(180);
        mTextMsg.setPrefHeight(150);
        mTextMsg.setOnKeyReleased(e -> onTextMsgKeyReleased());

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(5);
        gridPane.setVgap(10);
        gridPane.add(mTextReciever, 0, 0);
        gridPane.add(mButtonContact, 1, 0);
        gridPane.add(mTextMsg, 0, 1, 1, 3);
        gridPane.add(mLabelTextLength, 1, 1);
        gridPane.add(mButtonAttach, 1, 2);
        gridPane.add(mButtonSend,1, 3);
        stage.setScene(new Scene(gridPane));
        stage.show();
        mButtonContact.requestFocus();
    }

    private void onTextMsgKeyReleased() {
        int length = mTextMsg.getLength();
        if (length > Max_LENGTH) {
            mTextMsg.deletePreviousChar();
            length = mTextMsg.getLength();
        }
        String str = length + "/" + Max_LENGTH;
        mLabelTextLength.setText(str);
    }
}
