public class CalculatorModel {
    public double inputNo;
    public char operator;
    public double answer;
    public int resetVal;

    public CalculatorModel() {
        inputNo = 0;
        answer = 0;
        resetVal = 0;
    }

    public void resetDisplay() {
        resetVal = 0;
    }
    
}
