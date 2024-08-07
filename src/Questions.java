import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Questions extends JFrame implements ActionListener {
  private JPanel mathQuestion;
  private Problem problem;
  private String questionType;
  private Menu menu;
  private int indexOfActual;
  private JButton next;
  JLabel questionLabel = new JLabel("");
  JRadioButton choice1;
  JRadioButton choice2;
  JRadioButton choice3;
  JRadioButton choice4;
  JPanel questionButtons;
  JPanel questionPanel;
  JLabel background;

  /**
   * Creates a questions object
   * @param question - the type of question that is being asked
   * @param frame - Frame to display the question on
   */
  public Questions(String question, Menu frame) {
    //Math Menu
    mathQuestion = new JPanel();
    menu = frame;
    questionType = question;
    indexOfActual = 0;
  }

  /**
   * The main interface of the game. Contains problems and multiple choice responses.
   */
  public void runMathGUI() {
    problem = new Problem();
    
    String actual;
    
    //Background Label Config
    ImageIcon gradient = new ImageIcon("Pure-CSS3-Gradient-Background-Animation.gif");

    //Scaled BG
    Image bgGradient = gradient.getImage();
    Image bgMod = bgGradient.getScaledInstance(Menu.width, Menu.height, Image.SCALE_DEFAULT);
    gradient = new ImageIcon(bgMod);
    
    background = new JLabel(gradient);
    background.setBounds(0, 0, Menu.width, Menu.height);
    
    //Panel
    mathQuestion.setBounds(0, 0, Menu.width, Menu.width);
    mathQuestion.setLayout(null);
    
    if (questionType.equals("addition")) {
      problem.addition();
       questionLabel = new JLabel(problem.additionProblem() + " = ");
    } else if (questionType.equals("subtraction")) {
      problem.subtraction();
       questionLabel = new JLabel(problem.subtractionProblem() + " = ");
    } else if (questionType.equals("division")) {
      problem.division();
       questionLabel = new JLabel(problem.divisionProblem() + " = ");
    } else if (questionType.equals("multiplication")) {
      problem.multiplication();
       questionLabel = new JLabel(problem.multiplicationProblem() + " = ");
    } else if (questionType.equals("factorial")) {
      problem.factorial(problem.getVar1());
       questionLabel = new JLabel(problem.factorialProblem(problem.getVar1()) + " = ");
    }

    //Choice Button
    //Next Button
    next = new JButton("Next");
    next.setForeground(Color.GRAY);
    next.setBackground(Color.WHITE);
    next.setFocusPainted(false);
    next.setFont(new Font("Dialog", Font.BOLD, 12));
    next.setBounds(600, 400, 100, 20);
    next.setActionCommand("next");
    next.addActionListener(this);
    next.setVisible(false);

    String[] answers = problem.choices();
    choice1 = new JRadioButton(answers[0], false);
    choice2 = new JRadioButton(answers[1], false);
    choice3 = new JRadioButton(answers[2], false);
    choice4 = new JRadioButton(answers[3], false);
    
    ButtonGroup answer = new ButtonGroup();
    answer.add(choice1);
    answer.add(choice2);
    answer.add(choice3);
    answer.add(choice4);

    choice1.setActionCommand("0");
    choice2.setActionCommand("1");
    choice3.setActionCommand("2");
    choice4.setActionCommand("3");

    actual = "" + problem.getAnswer();

    for (int i = 0; i < answers.length; i++) {
      if (answers[i].equals(actual)) {
        indexOfActual = i;
      }
    }

    choice1.addActionListener(this);
    choice2.addActionListener(this);
    choice3.addActionListener(this);
    choice4.addActionListener(this);

    //Panel Button    
    questionButtons = new JPanel();
    int buttonWidth = Menu.width/2 + 50;
    int buttonHeight = Menu.height/8;
    questionButtons.setBounds(Menu.width/2 - buttonWidth/2, Menu.height/2 - buttonHeight/2, buttonWidth, buttonHeight); questionButtons.setBorder(BorderFactory.createLineBorder(Color.black));
    
    //Panel Question
    questionPanel = new JPanel();
    int questionWidth = Menu.width/2 + 50;
    int questionHeight = Menu.height/10;
    questionPanel.setBounds(Menu.width/2 - questionWidth/2, Menu.height/4, questionWidth, questionHeight);
    questionPanel.setLayout(new FlowLayout()); questionPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    //Back Buttons
    JButton back = new JButton("Back");
    back.setForeground(Color.GRAY);
    back.setBackground(Color.WHITE);
    back.setFocusPainted(false);
    back.setFont(new Font("Dialog", Font.BOLD, 12));
    back.setBounds(0, 0, 100, 20);
    back.setActionCommand("back");
    back.addActionListener(this);

    //Adding GUI
    questionPanel.add(questionLabel);
    questionButtons.add(choice1);
    questionButtons.add(choice2);
    questionButtons.add(choice3);
    questionButtons.add(choice4);
    mathQuestion.add(back);
    mathQuestion.add(next);
    mathQuestion.add(questionButtons);
    mathQuestion.add(questionPanel);

    mathQuestion.add(background);

    menu.getJFrame().add(mathQuestion);
    
    mathQuestion.setVisible(true);
  }
  /**
   * removes all elements of the GUI
   */
  public void clear(){
    mathQuestion.remove(questionButtons);
    mathQuestion.remove(questionPanel);
    questionPanel.remove(questionLabel);
    questionButtons.remove(choice1);
    questionButtons.remove(choice2);
    questionButtons.remove(choice3);
    questionButtons.remove(choice4);
    mathQuestion.remove(background);
  }
  
  /**
   * Manages all of the events for the buttons on the screen
   */
  public void actionPerformed(ActionEvent evt) {
    if(evt.getActionCommand().equals("back")) {
      mathQuestion.setVisible(false);
      menu.runMathMenuGUI();
    } else if(evt.getActionCommand().equals("next")) {
      clear();
      next.setVisible(false);
      runMathGUI();
      
    } else if (evt.getActionCommand().equals("" + indexOfActual)) {
      questionLabel.setText("Right");
      questionPanel.setBackground(Color.green);
      choice1.setEnabled(false);
      choice2.setEnabled(false);
      choice3.setEnabled(false);
      choice4.setEnabled(false);
      next.setVisible(true);
      
    } else {
      questionLabel.setText("Wrong");
      questionPanel.setBackground(Color.red);
      next.setVisible(true);
      choice1.setEnabled(false);
      choice2.setEnabled(false);
      choice3.setEnabled(false);
      choice4.setEnabled(false);
    }
  }
}
