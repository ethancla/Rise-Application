public class Problem {
  private int var1;
  private int var2;
  private static int answer;
  private String type;

  /**
   * Default problem constructor, generates random values for var1 and var2.
   */
  public Problem() {
    var1 = (int) (Math.random() * 25 + 1);
    var2 = (int) (Math.random() * 25 + 1);

    while (!(var1 > var2)) {
      var2 = (int) (Math.random() * 25 + 1);
    }
  }

  /**
   * Constructs a problem object with 2 predetermined values.
   * @param v1 - First chosen number
   * @param v2 - Second chosen number
   */
  public Problem(int v1, int v2) {
    var1 = v1;
    var2 = v2;
  }

  /**
   * Returns var1
   * @return first number in the problem
   */
  public int getVar1() {
    return var1;
  }

  /**
   * Returns var2
   * @return second number in the problem
   */
  public int getVar2() {
    return var2;
  }

  /**
   * Returns the solution to the problem
   * @return the current problem's answer
   */
  public int getAnswer() {
    return answer;
  }

  /**
   * Performs addition with the 2 numbers in the class
   * @return the sum of var1 and var2
   */
  public int addition() {
    answer = var1 + var2;
    type = "addition";

    return answer;
  }

  /**
   * Performs subtraction with the 2 numbers in the class
   * @return the difference of var1 and var2
   */
  public int subtraction() {
    answer = var1 - var2;
    type = "subtraction";

    return answer;
  }

  /**
   * Performs multiplication with the 2 numbers in the class
   * @return the product of var1 and var2
   */
  public int multiplication() {
    answer = var1 * var2;
    type = "multiplication";

    return answer;
  }

  /**
   * Performs division with the 2 numbers in the class
   * @return the quotient of var1 and var2
   */
  public int division() {
    while (0 == var2 && !(var1 % var2 == 0)) {
      var2 = (int) (Math.random() * 25 + 1);
    }

    type = "division";

    while (!(var1 % var2 == 0)) {
      var1 = (int) (Math.random() * 25 + 1);
    }

    answer = var1 / var2;
    return answer;
  }

  /**
   * Solves the factorial of a number that is passed into the method
   * @param num1 - the number to solve the factorial of
   * @return the factorial of num1
   */
  public int factorial(int num1) {
    type = "factorial";

    if (num1 <= 0) {
      return 1;
    }

    return factorial(num1 - 1) * num1;
  }


  /**
   * Creates an addition problem
   * @return String with the question
   */
  public String additionProblem() {
    answer = addition();

    return var1 + " + " + var2;
  }

  /**
   * Creates a subtraction problem
   * @return String with the question
   */
  public String subtractionProblem() {
    answer = subtraction();

    return var1 + " - " + var2;
  }

  /**
   * Creates a multiplication problem
   * @return String with the question
   */
  public String multiplicationProblem() {
    answer = multiplication();

    return var1 + " * " + var2;
  }

  /**
   * Creates a division problem
   * @return String with the question
   */
  public String divisionProblem() {
    answer = division();

    return var1 + " / " + var2;
  }

  /**
   * Creates a factorial problem
   * @param num1 - number to find the factorial of
   * @return String with the question
   */
  public String factorialProblem(int num1) {
    while (num1 > 6) {
      num1 = (int) (Math.random() * 6 + 1);
    }
    
    answer = factorial(num1);
    return num1 + "!";
  }

  /**
   * Generates the answer choices
   * @return array of answer choices
   */
  public String[] choices() {
    int inc = 10;
    String[] choices = new String[4];
    int randIndex = (int) (Math.random() * 4);
    int rand = (int) (Math.random() * 100);

    if (getAnswer() > 100) {
      for (int i = 0; i < choices.length; i++) {
        rand = (int) (Math.random() * 10000);

        while (rand == getAnswer()) {
          rand = (int) (Math.random() * 10000);
        }

        choices[i] = "" + rand;
      }
    } else {
      for (int i = 0; i < choices.length; i++) {
        if (getAnswer() < inc) {
          rand = getAnswer()/3 + (int) (Math.random() * (inc));
        } else if (getAnswer() < 2*inc) {
          rand = getAnswer()/3 + (int) (Math.random() * (3*inc));
        } else if (getAnswer() < 4*inc) {
          rand = getAnswer()/3 + (int) (Math.random() * (5*inc));
        } else if (getAnswer() < 6*inc) {
          rand = getAnswer()/3 + (int) (Math.random() * (7*inc));
        } else if (getAnswer() < 8*inc) {
          rand = getAnswer()/3 + (int) (Math.random() * (9*inc));
        } else {
          rand = getAnswer()/3 + (int) (Math.random() * (11*inc));
        }

        while (rand == getAnswer()) {
          rand = (int) (Math.random() * 100);
        }

        choices[i] = "" + rand;
      }
    }

    choices[randIndex] = "" + getAnswer();

    // Insertion sort to get in order of least to greatest
    int n = choices.length;
    for (int i = 1; i < n; i++) {
        String temp = choices[i];
        int j = i - 1;

        while (j >= 0 && Integer.parseInt(choices[j]) > Integer.parseInt(temp)) {
            choices[j + 1] = choices[j];
            j = j - 1;
        }

        choices[j + 1] = temp;
    }

    return choices;
  }
}
