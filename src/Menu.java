import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {
  private JPanel mainMenu;
  private JPanel mathMenu;
  private JFrame window;
  private Questions question;
  private Lesson lesson;
  static int width;
  static int height;
  
  /**
   * Initializes the JFrame
   */
  public Menu() {
    // Window Config
    width = 800;
    height = 600;
    window = new JFrame("Rise Client | Only way of learning");
    window.setLayout(null);
    window.setSize(width, height);
    window.setResizable(false);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Main Menu
    mainMenu = new JPanel();

    // Math Menu
    mathMenu = new JPanel();

    runMainMenuGUI();
  }
  
  /**
   * Displays title screen and credits, and contains the code for the appearance.
   */
  public void runMainMenuGUI() {
    ImageIcon logo = new ImageIcon("rise_logo.png");
    Image riseIcon = logo.getImage();
    Image riseMod = riseIcon.getScaledInstance((int) logo.getIconWidth() / 5, (int) logo.getIconHeight() / 5, java.awt.Image.SCALE_SMOOTH);
    logo = new ImageIcon(riseMod);
    JLabel rise = new JLabel(logo);
    rise.setBounds(0, -((int) window.getHeight() / 8), (int) window.getWidth(), (int) window.getHeight());

    // Rise Button Config
    JButton button = new JButton("Rise Up!");
    button.setForeground(Color.GRAY);
    button.setBackground(Color.WHITE);
    button.setFocusPainted(false);
    button.setFont(new Font("Dialog", Font.BOLD, 12));
    button.setBounds((int) window.getWidth() / 2 - 100, ((int) window.getHeight() / 2), 200, 40);
    button.setActionCommand("start");
    button.addActionListener(this);

    // Background Label Config
    ImageIcon gradient = new ImageIcon("Pure-CSS3-Gradient-Background-Animation.gif");
  
    // Scaled BG
    Image bgGradient = gradient.getImage();
    Image bgMod = bgGradient.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    gradient = new ImageIcon(bgMod);
    
    JLabel background = new JLabel(gradient);
    background.setBounds(0, 0, (int) window.getWidth(), (int) window.getHeight());
    
    // JPanel 
    mainMenu.setBounds(0, 0, (int) window.getWidth(), (int) window.getHeight());
    mainMenu.setLayout(null);

    mainMenu.add(button);
    mainMenu.add(rise);
    mainMenu.add(background);
    
    // Windows Config
    window.add(mainMenu);
    window.validate();
    window.setVisible(true);

    mainMenu.setVisible(true);
  }

  /**
   * Manages all the buttons for the main game and tutorials.
   */
  public void runMathMenuGUI() {
    // Panel
    mathMenu.setBounds(0, 0, (int) window.getWidth(), (int) window.getHeight());
    mathMenu.setLayout(null);

    // Panel of Buttons
    JPanel mathButtons = new JPanel();
    mathButtons.setBounds((int) window.getWidth() / 2 - (int) window.getWidth() / 4, (int) window.getHeight() / 2 - (int) window.getHeight() / 4, (int) window.getWidth() / 2, (int) window.getHeight() / 2);
    mathButtons.setLayout(new GridLayout(3, 2, 0, 0));

    // Background Label Config
    ImageIcon gradient = new ImageIcon("bg_75.gif");

    // Scaled BG
    Image bgGradient = gradient.getImage();
    Image bgMod = bgGradient.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    gradient = new ImageIcon(bgMod);
    
    JLabel background = new JLabel(gradient);
    background.setBounds(0, 0, (int) window.getWidth(), (int) window.getHeight());

    // Back Buttons
    JButton back = new JButton("Back");
    back.setForeground(Color.GRAY);
    back.setBackground(Color.WHITE);
    back.setFocusPainted(false);
    back.setFont(new Font("Dialog", Font.BOLD, 12));
    back.setBounds(0, 0, 100, 20);
    back.setActionCommand("back");
    back.addActionListener(this);

    // Math Buttons
    JButton addition = new JButton("Addition!");
    JButton subtraction = new JButton("Subtraction!");
    JButton multiplication = new JButton("Multiplication!");
    JButton division = new JButton("Division!");
    JButton factorial = new JButton("Factorial!");
    JButton tutorial = new JButton("Tutorials!");

    // Adding GUI
    mathMenu.add(back);
    mathButtons.add(tutorial);
    mathMenu.add(mathButtons);
    mathButtons.add(addition);
    mathButtons.add(subtraction);
    mathButtons.add(multiplication);
    mathButtons.add(division);
    mathButtons.add(factorial);
    
    mathMenu.add(background);
    
    window.add(mathMenu);

    addition.setActionCommand("addition");
    addition.addActionListener(this);
    tutorial.setActionCommand("tutorial");
    tutorial.addActionListener(this);
    subtraction.setActionCommand("subtraction");
    subtraction.addActionListener(this);
    multiplication.setActionCommand("multiplication");
    multiplication.addActionListener(this);
    division.setActionCommand("division");
    division.addActionListener(this);
    factorial.setActionCommand("factorial");
    factorial.addActionListener(this);
    
    mathMenu.setVisible(true);
  }

/**
 * Returns the menu frame
 * @return the menu JFrame
 */
  public JFrame getJFrame() {
    return this.window;
  }

/**
 * Manages all the event handlers for every button in this class
 */
  public void actionPerformed(ActionEvent evt) {
    if (evt.getActionCommand().equals("start")) {
      mainMenu.setVisible(false);
      runMathMenuGUI();
    } else if (evt.getActionCommand().equals("back")) {
      mathMenu.setVisible(false);
      runMainMenuGUI();
    } else if (evt.getActionCommand().equals("tutorial")) {
      mathMenu.setVisible(false);
      lesson = new Lesson(this);
      lesson.runLessonGUI();
    } else if (evt.getActionCommand().equals("addition")) {
      mathMenu.setVisible(false);
      question = new Questions("addition", this);
      question.runMathGUI();
    } else if (evt.getActionCommand().equals("subtraction")) {
      mathMenu.setVisible(false);
      question = new Questions("subtraction", this);
      question.runMathGUI();
    } else if (evt.getActionCommand().equals("multiplication")) {
      mathMenu.setVisible(false);
      question = new Questions("multiplication", this);
      question.runMathGUI();
    } else if (evt.getActionCommand().equals("division")) {
      mathMenu.setVisible(false);
      question = new Questions("division", this);
      question.runMathGUI();
    } else if (evt.getActionCommand().equals("factorial")) {
      mathMenu.setVisible(false);
      question = new Questions("factorial", this);
      question.runMathGUI();
    }

  }
}
