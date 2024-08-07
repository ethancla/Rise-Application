import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lesson extends JFrame implements ActionListener {
    private Menu menu;
    private JPanel lesson;
    private JLabel background;
    private JTextArea text;
    private JScrollPane scroll;
    private JButton back;
/**
 * Creates a lesson object with a new JPanel
 * @param window - The menu that the lesson will be displayed on
 */
    public Lesson(Menu window) {
        menu = window;
        lesson = new JPanel();

    }
/**
 * The main interface of the Lesson. Includes a text area and scroll wheel.
 */
    public void runLessonGUI() {
        // Background Label Config
        ImageIcon gradient = new ImageIcon("Pure-CSS3-Gradient-Background-Animation.gif");

        // Scaled BG
        Image bgGradient = gradient.getImage();
        Image bgMod = bgGradient.getScaledInstance(Menu.width, Menu.height, Image.SCALE_DEFAULT);
        gradient = new ImageIcon(bgMod);

        background = new JLabel(gradient);
        background.setBounds(0, 0, Menu.width, Menu.height);

        // Panel
        lesson.setBounds(0, 0, Menu.width, Menu.width);
        lesson.setLayout(new BorderLayout());

        // Text Area configuration
        String material = "";

        Teaching[] lessons = { new Teaching("addition"), new Teaching("subtraction"), new Teaching("multiplication"),
                new Teaching("division"), new Teaching("factorial") };

        for (Teaching obj : lessons) {
            Teaching teacher = obj;
            material += teacher.getMaterial();
            material += "\n\n";
        }

        // Back Buttons
        back = new JButton("Back");
        back.setForeground(Color.GRAY);
        back.setBackground(Color.WHITE);
        back.setFocusPainted(false);
        back.setFont(new Font("Dialog", Font.BOLD, 12));
        back.setBounds(0, 0, 100, 20);
        back.setActionCommand("back");
        back.addActionListener(this);

        text = new JTextArea(material, 100, 50);
        text.setBounds(150, 150, 500, 300);
        text.setEditable(false);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        // Scroll Bar
        scroll = new JScrollPane(text);
        scroll.setBounds(150, 150, 500, 300);

        // Adding GUI

        lesson.add(scroll);
        lesson.add(back);
        lesson.add(background);

        menu.getJFrame().add(lesson);

        lesson.setVisible(true);

    }
/**
 * Manages all the events for the buttons in this class
 */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("back")) {
            lesson.setVisible(false);
            menu.runMathMenuGUI();
        }
    }

}