public class Teaching {
    private String material;

    /**
     * Creates a teaching object with different material depending on the concept
     * @param concept - Math concept that is meant to be taught
     */
    public Teaching(String concept) {
        if (concept.equals("addition")) {
            material = "Addition: It's helpful to learn how to do this through tallying. Take 3 + 4 for example. Start by drawing 3 tallies, as this is the first number. After that, you want to draw 4 more tallies, as 4 is the second number. Once you've drawn both sets of tallies, count the total amount of tallies you drew, and that should be the sum. For larger numbers, this will take a long time so you only want to be using tallies when first learning how to do this.";
        } else if (concept.equals("subtraction")) {
            material = "Subtraction: If you are not familiar with subtraction, you want to start off by using tallies. Take 5 - 3 for example. Start by drawing 5 tallies (bigger number) and then erasing 3 of the tallies (smaller number). Once you do this, count the number of tallies you have left, and that is your answer. If the second number is larger than the first number, the answer is negative. In this example the answer would be 2, but if the problem asked what 3 - 5 is, the answer would be -2. For larger numbers, using tallies will take a long time so you only want to be using tallies when first learning how to do this.";
        } else if (concept.equals("multiplication")) {
            material = "Multiplication: Before learning this, you should be able to add without using tallies. Multiplication can be seen as adding multiple times. Let's take 3 x 4 for example. You can rewrite 3 x 4 as 3 + 3 + 3 + 3, and this would give you the product. In this example, the answer would be 12.";
        } else if (concept.equals("division")) {
            material = "Division: Before learning this, you should be comfortable performing subtraction without using tallies. Let's take 12 / 4 for example. You want to determine how many times you can subtract 4 from 12. To do this, start by doing 12 (first number) - 4 (second number), and then subtract 4 from the number you get. Keep going until you reach zero, and then count the number of times you subtracted 4 (second number). That is your answer.";
        } else if (concept.equals("factorial")) {
            material = "Factorials: Before learning this, you should be comfortable with multiplication. Factorials are written with an exclamation point(!). Factorials are solved with repeated multiplication of numbers that are gradually getting smaller. Let's take 5! for example. You would write this as 5 x 4 x 3 x 2 x 1, starting at the original number and going down by 1 each term until you hit 1. Once you write this out, multiply all the numbers together and that would be your answer.";
        } else {
            System.out.print("Invalid Concept");
        }
    }

    /**
     * Returns the material
     * @return Material as a string
     */
    public String getMaterial() {
        return material;
    }
}
