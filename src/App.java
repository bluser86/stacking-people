import javax.swing.*;

public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ignored) {
            // ...
        }

        MainForm form = new MainForm(new Stack<>());
        form.setVisible(true);
    }
}