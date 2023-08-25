package cookie.controller;

import cookie.view.CookieGuiView;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

/**
 * A controller for the game
 */
public class Controller extends Application {
    private CookieGuiView view;
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
    private Stage primaryStage;
    private CookiesButtonHandler cbh;
    private String currentCookie;

    public Controller() {
        this.view = new CookieGuiView(this);
        this.primaryStage = new Stage();
        this.cbh = new CookiesButtonHandler(primaryStage, this);
    }

    /**
     * loads an existing score from the score.txt file and sets the score field
     * and text of the scoreLabel
     */
    private void loadScore() {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/score.txt"));
            score = Integer.valueOf(scanner.nextLine());
            System.out.println(score);
            scoreLabel.setText(String.valueOf(score));
            scoreLabel.setFont(Font.font("Bradley Hand", 30));
        } catch (FileNotFoundException e) {
            System.err.println("File was not found");
        }
    }

    /**
     * reads and determines the current cookie to be displayed
     */
    private void loadCookie() {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/currentCookie.txt"));
            this.currentCookie = scanner.nextLine();
            System.out.println(this.currentCookie);
            setCookieGraphic(this.currentCookie);
        } catch (FileNotFoundException e) {
            System.err.println("File was not found");
        }
    }

    /**
     *
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    @Override
    public void start(Stage stage) {
        try {
            primaryStage.setHeight(500);
            primaryStage.setWidth(500);
            primaryStage.setScene(this.view.load());
            masterVBox.setBackground(Background.fill(Color.WHITE));
            loadScore();
            setAllButtons();
            loadCookie();
            primaryStage.show();
        } catch (RuntimeException e) {
            System.err.println(e);
        }
    }

    /**
     * sets the buttons to their actions, styles their backgrounds and texts
     */
    private void setAllButtons() {
        cookieButton.setOnAction( e -> increaseScore());
        cookiesButton.setOnAction(this.cbh);
        cookiesButton.setBackground(Background.fill(Color.PALETURQUOISE));
        cookiesButton.setFont(Font.font("Bradley Hand", 20));
        resetButton.setOnAction(e -> resetScore());
        resetButton.setBackground(Background.fill(Color.LIGHTBLUE));
        resetButton.setFont(Font.font("Bradley Hand", 24));
        cookieClickLabel.setFont(Font.font("Bradley Hand", 24));
        clickTheCookieLabel.setFont(Font.font("Bradley Hand", 24));
    }

    /**
     * increases the score field by 1, updates the scoreLabel's text,
     * and writes the new score to the score.txt file
     */
    private void increaseScore() {
        score++;
        scoreLabel.setText(String.valueOf(score));
        try {
            String s = String.valueOf(score);
            FileWriter fw = new FileWriter("src/main/resources/score.txt");
            fw.write(s);
            fw.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    /**
     * sets the cookie being displayed to the graphic with the passed in file path
     * @param c the file path of the cookie to be displayed
     */
    private void setCookieGraphic(String c) {
        File f = new File(c);
        cookieButton.setBackground(Background.fill(Color.WHITE));
        ImageView cookie = new ImageView(f.toURI().toString());
        cookie.setFitHeight(200);
        cookie.setPreserveRatio(true);
        cookieButton.setGraphic(cookie);
    }

    /**
     * resets the score to 0, updates the scoreLabel's text,
     * and writes 0 to the score.txt file
     */
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

    /**
     * updates the currentCookie field to the file path given,
     * updates the graphic for the cookie being displayed
     * @param cookie the file path for the current cookie
     */
    public void setCurrentCookie(String cookie) {
        this.currentCookie = cookie;
        setCookieGraphic(cookie);
    }
}
