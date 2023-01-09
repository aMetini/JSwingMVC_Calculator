import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalModel {
    private final static int MAX_ROUNDING_DECIMALS = 9;

    private final static int MAX_ALLOWABLE_NUM_INPUT = 3;

    private String outputDisplay;
    private String operationDisplay;
    private double currentValue;
    private boolean firstDigit;

    public CalModel() {
        resetCal();
    }

    private void resetCal() {
        currentValue = 0.0;
        firstDigit = true;
        outputDisplay = "0";
    }

    private static double calculate(char operator) {
        return 0.0;
    }
    
}
