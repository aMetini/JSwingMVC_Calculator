import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorModel {
    private final int MAX_ROUNDING_DECIMALS = 3;

    private String outputDisplay;
    private char operator;
    private Double inputNo;
    private Double outputDisplayValue;
    private Double answer;
    private boolean firstDigitInput;
    private boolean errorModeOn;

    public CalculatorModel() {
        inputNo = 0.0;
        answer = 0.0;
        resetCalculator();
    }

    public String getOuputDisplay() {
        return outputDisplay;
    }

    public void setOutputDisplay(String outputField) {
        outputDisplay = outputField;
    }

    public Double getInputNo() {
        return inputNo;
    }

    public void setInputNo(Double noVal) {
        inputNo = noVal;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char op) {
        if (errorModeOn) {
            return;
        }
        try {
            // Stores the current numerical output for future computation
            inputNo = Double.valueOf(outputDisplay);
            operator = op;
            // After we set the operator, the next numberical input will be the first new digit input
            firstDigitInput = true;
        } catch (Exception e) {
            enterErrorMode();
        }
    } 

    public void enterNumber(int no) {
        if (errorModeOn) {
            return;
        }
        // If the first operand number is entered, this line will replace the default display value of the calculator (i.e.0)
        if (firstDigitInput) {
            outputDisplay = String.valueOf(no);
            firstDigitInput = false;
            return;
        }
        // If the number is 0, this line ensures that we do not have numbers displayed with any 0s to the left of that number.
        if (outputDisplay.equals("0")) {
            outputDisplay = String.valueOf(no);
            return;
        }
        outputDisplay += no;
    }

    public void enterDec() {
        if (errorModeOn) {
            return;
        }
        if (firstDigitInput) {
            outputDisplay = "0.";
            firstDigitInput = false;
            return;
        }
        if (outputDisplay.contains(".")) {
            return;
        }
        outputDisplay += ".";
    }
 
    public void calculate() {
        if (errorModeOn) {
            return;
        }
        
        if (operator == ' ') {
            return;
        } 
        try {
            outputDisplayValue = Double.valueOf(outputDisplay);

            answer = calculateOperation(operator, inputNo, outputDisplayValue);

            outputDisplay = answer.toString();

            // The next numperical input will be the first new digit input
            firstDigitInput = true;
            // Single pipe or statement checks to see if either conditions apply (by checking for both) rather than checking one 
            // condition is true and then ignoring the other condition.
        } catch (NumberFormatException | ArithmeticException e) {
            enterErrorMode();
        }
    }

    public void calculateSquare() {
        // Error handling for squaring an empty field
        if (outputDisplay.equals("")) {
            outputDisplay.equals("NaN");
        } else {
            Double square = Math.pow(inputNo, 2);
            outputDisplay = Double.toString(square);
        }
    }

    public void calculateSquareRt() {
        if (errorModeOn) {
            return;
        } else {
            Double squareRt = Math.sqrt(inputNo);
            outputDisplay = squareRt.toString();
        }
    }

    public void calculateReciprocal() {
        // Error handling for getting the reciprocal of an empty field
        if (errorModeOn) {
            return;
        } else {
            Double reciprocal = 1 / inputNo;
            outputDisplay = Double.toString(reciprocal);
        }
    } 

    public void deleteInput() {
        // Variable length takes length of getText (i.e. calculator entry in outputField)
        // We will use StringBuilder to create a mutable string of chars like an array from the outputField entry.
        int length = outputDisplay.length();
        // Val removes one number from the length of getText entry so that it starts deleting from the last element of our string of chars
        int val = length - 1;

        // If outputField length is NOT empty or begins at the 0 index start deleting
        if (length > 0) {
            StringBuilder delBack = new StringBuilder(outputDisplay);
            delBack.deleteCharAt(val);
            // Sets value of newly deleted into the outputDisplay.
            outputDisplay = delBack.toString();
        } else {
            outputDisplay = "0";
            firstDigitInput = true;
        }
    }

    public void resetCalculator() {
        inputNo = 0.0;
        outputDisplay = "0";
        firstDigitInput = true;
        errorModeOn = false;
    }

    private void enterErrorMode() {
        errorModeOn = true;
        outputDisplay = "Error";
    }

    private double calculateOperation(char operator, double num1, double num2) throws ArithmeticException {
        double answer = 0.0;

        switch (operator) {
            case '+':
                answer = num1 + num2;
                break;
            case '-':
                answer = num1 - num2;
                break;
            case '*':
                answer = num1 * num2;
                break;
            case '/':
                if (num2 == 0.0) {
                    throw new ArithmeticException("Error - Division by 0");
                }
                answer = num1 / num2;
                break;
        }

        return round(answer, MAX_ROUNDING_DECIMALS);
    }

    private static double round(double answer, int maxRoundingDecimals) {
        try {
            BigDecimal bigDecimal = new BigDecimal(Double.toString(answer));
            bigDecimal = bigDecimal.setScale(maxRoundingDecimals, RoundingMode.HALF_UP);
            return bigDecimal.doubleValue();  
        } catch (Exception e) {
                throw new IllegalArgumentException("Error - unable to format as number");
            }
        }
    }
