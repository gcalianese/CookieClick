package cookie.controller;

import cookie.model.MyButton;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Handles clicking the cookies button
 */
public class CookiesButtonHandler implements EventHandler {
    private Stage primaryStage;
    private MyButton cookie1Button = new MyButton("src/main/resources/cookie1.png");
    private MyButton cookie2Button = new MyButton("src/main/resources/cookie2.jpg");
    private MyButton cookie3Button = new MyButton("src/main/resources/cookie3.jpg");
    private MyButton cookie4Button = new MyButton("src/main/resources/cookie4.jpg");
    private MyButton cookie5Button = new MyButton("src/main/resources/cookie5.jpg");
    private MyButton cookie6Button = new MyButton("src/main/resources/cookie6.jpg");
    private MyButton cookie7Button = new MyButton("src/main/resources/cookie7.jpg");
    private MyButton cookie8Button = new MyButton("src/main/resources/cookie8.jpg");
    private MyButton cookie9Button = new MyButton("src/main/resources/cookie9.jpg");
    private String selectedCookie;
    private Popup popup;
    private Controller controller;
    public CookiesButtonHandler(Stage stage, Controller controller) {
        this.primaryStage = stage;
        setButtonStyles(cookie1Button, cookie2Button, cookie3Button, cookie4Button,
                cookie5Button, cookie6Button, cookie7Button, cookie8Button, cookie9Button);
        popup = new Popup();
        popup.sizeToScene();
        this.controller = controller;
    }

    /**
     * builds the gridpane with cookie images and shows a popup
     * @param event the event which occurred
     */
    @Override
    public void handle(Event event) {
        GridPane gp = new GridPane();
        gp.setBackground(Background.fill(Color.WHITE));
        gp.setPrefSize(375, 375);
        gp.addRow(0, cookie1Button);
        gp.addRow(1, cookie4Button);
        gp.addColumn(0, cookie7Button);
        gp.addRow(0, cookie2Button);
        gp.addRow(1, cookie5Button);
        gp.addColumn(1, cookie8Button);
        gp.addRow(0, cookie3Button);
        gp.addRow(1, cookie6Button);
        gp.addColumn(2, cookie9Button);
        popup.getContent().add(gp);
        popup.show(primaryStage);
    }

    /**
     * sets the sizes, background color, and actions of each cookie button,
     * @param buttons the buttons to be set
     */
    private void setButtonStyles(MyButton... buttons) {
        for (MyButton b : buttons) {
            b.setPrefSize(125, 125);
            b.setStyle("-fx-background-color: #FFFFFF");
            b.setOnAction(e ->
            {
                popup.hide();
                this.selectedCookie = b.getImg();
                controller.setCurrentCookie(this.selectedCookie);
                writeCookie();
            });
        }
    }

    /**
     * writes the file path to the selected cookie's image in the currentCookie.txt file,
     *
     */
    private void writeCookie() {
        try {
            FileWriter fw = new FileWriter("src/main/resources/currentCookie.txt");
            fw.write(this.selectedCookie);
            fw.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
