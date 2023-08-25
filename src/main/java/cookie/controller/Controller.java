package cookie.controller;

import cookie.view.CookieGuiView;
import cookie.view.GuiView;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Controller extends Application {
    private GuiView view;
    @FXML
    private VBox masterVBox;
    @FXML
    private GridPane topGrid;
    @FXML
    private Button resetButton;
    @FXML
    private Button cookiesButton;
    @FXML
    private VBox topCenterBox;
    @FXML
    private Label cookieClickLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private VBox cookieVBox;
    @FXML
    private Button cookieButton;
    @FXML
    private Label clickTheCookieLabel;
    private int score;


    public Controller() {
        this.view = new CookieGuiView(this);
    }

    private void loadScore() {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/score.txt"));
            score = Integer.valueOf(scanner.nextLine());
            System.out.println(score);
            scoreLabel.setText(String.valueOf(score));
        } catch (FileNotFoundException e) {
            System.err.println("File was not found");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            primaryStage.setHeight(500);
            primaryStage.setWidth(500);
            primaryStage.setScene(this.view.load());
            masterVBox.setBackground(Background.fill(Color.WHITE));
            loadScore();
            setAllButtons();
            setCookieGraphic();
            primaryStage.show();
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    private void setAllButtons() {
        cookieButton.setOnAction( e -> increaseScore());
        cookiesButton.setBackground(Background.fill(Color.PALETURQUOISE));
        resetButton.setOnAction(e -> resetScore());
        resetButton.setBackground(Background.fill(Color.LIGHTBLUE));
    }

    private void increaseScore() {
        score++;
        scoreLabel.setText(String.valueOf(score));
        System.out.println(score);
        try {
            String s = String.valueOf(score);
            FileWriter fw = new FileWriter("src/main/resources/score.txt");
            fw.write(s);
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void setCookieGraphic() {
        File f = new File("src/main/resources/cookie1.png");
        cookieButton.setBackground(Background.fill(Color.WHITE));
        ImageView cookie = new ImageView(f.toURI().toString());
        cookie.setFitHeight(200);
        cookie.setPreserveRatio(true);
        cookieButton.setGraphic(cookie);
    }


    private void resetScore() {
        score = 0;
        scoreLabel.setText("0");
        try {
            FileWriter fw = new FileWriter("src/main/resources/score.txt");
            fw.write("0");
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
