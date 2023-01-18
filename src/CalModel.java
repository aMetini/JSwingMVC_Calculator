import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalModel {
    private final static int MAX_ROUNDING_DECIMALS = 3;

    private String outputDisplay;
    private char operator;
    private Double inputNo;
    private Double outputDisplayValue;
    private Double answer;
    private boolean firstDigitInput;
    private boolean errorModeOn;

    public CalModel() {
        inputNo = 0.0;
        answer = 0.0;
        resetCalculator();
    }

    public String getOuputDisplay() {
        return outputDisplay;
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
        if (firstDigitInput) {
            outputDisplay = String.valueOf(no);
            firstDigitInput = false;
            return;
        }

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
            if (outputDisplay.endsWith(".0")) {
                outputDisplay.replace(".0", "");
            } else {
                return;
            }
            // The next numperical input will be the first new digit input
            firstDigitInput = true;
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
            if (outputDisplay.endsWith(".0")) {
                outputDisplay.replace(".0", "");
            } else {
                return;
            }
        }
    }

    public void calculateSquareRt() {
        if (errorModeOn) {
            return;
        } else {
            Double squareRt = Math.sqrt(inputNo);
            outputDisplay = squareRt.toString();
            if (outputDisplay.endsWith(".0")) {
                outputDisplay.replace(".0", "");
            } else {
                return;
            }
        }
    }

    public void calculateReciprocal() {
        // Error handling for getting the reciprocal of an empty field
        if (errorModeOn) {
            return;
        } else {
            Double reciprocal = 1 / inputNo;
            outputDisplay = Double.toString(reciprocal);
            if (outputDisplay.endsWith(".0")) {
                outputDisplay.replace(".0", "");
            } else {
                return;
            }
        }
    } 

    public void resetDisplay() {
        if (errorModeOn) {
            return;
        }
        outputDisplay = "0";
        firstDigitInput = true;
    }

    public void deleteInput() {
        int length = outputDisplay.length();
        int val = length - 1;

        if (length > 0) {
            StringBuilder delBack = new StringBuilder(outputDisplay);
            delBack.deleteCharAt(val);
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

    private static double calculateOperation(char operator, double num1, double num2) throws ArithmeticException {
        double answer = 0.0;

        switch (operator) {
            case '+':
                answer = num1 + num2;
                break;
            case '-':
                answer = num1 - num2;
                break;
            case '×':
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
        if (maxRoundingDecimals < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bigDecimal = new BigDecimal(Double.toString(answer));
        bigDecimal = bigDecimal.setScale(maxRoundingDecimals, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
    
}
