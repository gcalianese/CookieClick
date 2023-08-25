package cookie.model;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

import java.io.File;

/**
 * A custom MyButton class to represent the coookie option buttons
 */
public class MyButton extends Button {
    private String img;

    /**
     * instantiates a MyButton with its graphic set to the image
     * at the given file path
     * @param img the file path to the image to be its graphic
     */
    public MyButton(String img) {
        this.img = img;
        setMyGraphic();
    }

    /**
     * sets the MyButton's graphic to the image at its file path
     */
    private void setMyGraphic() {
        File f = new File(img);
        this.setBackground(Background.fill(Color.WHITE));
        ImageView cookie = new ImageView(f.toURI().toString());
        cookie.setFitHeight(100);
        cookie.setPreserveRatio(true);
        this.setGraphic(cookie);
    }

    /**
     * getter for the MyButton's img
     * @return the file path to the image used to set this MyButton's graphic
     */
    public String getImg() {
        return img;
    }
}
