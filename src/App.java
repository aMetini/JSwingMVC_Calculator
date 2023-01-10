public class App {
    public static void main(String[] args) throws Exception {
        CalModel calModel = new CalModel();
        CalculatorView calView = new CalculatorView();

        new CalController(calModel, calView);
    }
}
