package cookie.view;

import cookie.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class CookieGuiView implements GuiView {
    private FXMLLoader loader;

    public CookieGuiView(Controller controller) {
        this.loader = new FXMLLoader();
        this.loader.setController(controller);
        this.loader.setLocation(getClass().getResource("/CookieClick.fxml"));
    }
    @Override
    public Scene load() throws IllegalStateException {
        try {
            return new Scene(this.loader.load());
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load layout");
        }
    }
}
