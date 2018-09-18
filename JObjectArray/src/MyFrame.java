import javax.swing.*;
import java.awt.*;

/**
 * Created by stef on 2017/03/07.
 */
public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("Arrays of JObjects");
        Container cont = this.getContentPane();

        MyPanel panel = new MyPanel();
        //panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        cont.add(panel);
        this.pack();
    }
}
