package cookie;

import cookie.controller.Controller;
import javafx.application.Application;

/**
 * The Driver of this project
 */
public class Driver {

    /**
     * Launches the application
     * @param args no CLI args necessary
     */
    public static void main(String[] args) {
        Application.launch(Controller.class, args);
    }

}
