package cookie.view;

import cookie.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * A GUI view for the game
 */
public class CookieGuiView {
    private FXMLLoader loader;

    /**
     * instantiates the FXMLLoader and sets its controller to the given controller,
     * sets the loader's location
     * @param controller the controller for the FXMLLoader
     */
    public CookieGuiView(Controller controller) {
        this.loader = new FXMLLoader();
        this.loader.setController(controller);
        this.loader.setLocation(getClass().getResource("/CookieClick.fxml"));
    }

    /**
     * loads the Scene from the FXMLLoader's location
     * @return the loader's scene
     * @throws IllegalStateException if an IOException occurs
     */
    public Scene load() throws IllegalStateException {
        try {
            return new Scene(this.loader.load());
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load layout");
        }
    }
}
