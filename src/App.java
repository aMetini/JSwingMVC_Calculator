public class App {
    public static void main(String[] args) throws Exception {
        CalculatorModel calModel = new CalculatorModel();
        CalculatorView calView = new CalculatorView();

        new CalculatorController(calModel, calView);
    }
}
