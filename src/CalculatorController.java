import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel calModel;
    private CalculatorView calView;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        calModel = model;
        calView = view;

        initiateView();
        initiateController();
    }

    private void initiateView() {
        updateView();
    }

    private void updateView() {
        calView.getOutputField().setText(calModel.getOuputDisplay());
        if (calModel.getOuputDisplay().endsWith(".0")) {
            calModel.setOutputDisplay(calModel.getOuputDisplay().replace(".0", ""));
            calView.getOutputField().setText(calModel.getOuputDisplay());
        } else {
            return;
        }
    }

    private void initiateController() {
        calView.onButton.addActionListener(new Actions());
        calView.offButton.addActionListener(new Actions());
        calView.addButton.addActionListener(new Actions());
        calView.subButton.addActionListener(new Actions());
        calView.multButton.addActionListener(new Actions());
        calView.divButton.addActionListener(new Actions());
        calView.sqRtButton.addActionListener(new Actions());
        calView.sqButton.addActionListener(new Actions());
        calView.reciprocalButton.addActionListener(new Actions());
        calView.equButton.addActionListener(new Actions());
        calView.clrButton.addActionListener(new Actions());
        calView.delButton.addActionListener(new Actions());
        calView.oneButton.addActionListener(new Actions());
        calView.twoButton.addActionListener(new Actions());
        calView.threeButton.addActionListener(new Actions());
        calView.fourButton.addActionListener(new Actions());
        calView.fiveButton.addActionListener(new Actions());
        calView.sixButton.addActionListener(new Actions());
        calView.sevenButton.addActionListener(new Actions());
        calView.eightButton.addActionListener(new Actions());
        calView.nineButton.addActionListener(new Actions());
        calView.zeroButton.addActionListener(new Actions());
        calView.decButton.addActionListener(new Actions());
    }

    public class Actions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object cmdSource = e.getSource();

                if (calView.outputField.getText().equals("NaN") || calView.outputField.getText().equals("Infinity")) {
                    calModel.resetCalculator();
                }

                for (int i = 0; i < 10; i++) {
                    if (cmdSource == calView.numBtnsArry[i]) {
                        calModel.enterNumber(i);
                        calView.outputField.setText(calView.outputField.getText().concat(String.valueOf(i)));
                        updateView();
                    }
                }

                if (cmdSource == calView.onButton) {
                    enable();
                } else if (cmdSource == calView.offButton) {
                    disable();
                } else if (cmdSource == calView.clrButton) {
                    calModel.resetCalculator();
                    updateView();
                } else if (cmdSource == calView.delButton) {
                    calModel.deleteInput();
                    updateView();
                } else if (cmdSource == calView.decButton) {
                    calModel.enterDec();
                    updateView();
                } else if (cmdSource == calView.addButton) {
                    calModel.setInputNo(Double.valueOf(calView.outputField.getText()));
                    calView.outputField.setText("");
                    calModel.setOperator('+');
                } else if (cmdSource == calView.subButton) {
                    calModel.setInputNo(Double.valueOf(calView.outputField.getText()));
                    calView.outputField.setText("");
                    calModel.setOperator('-');
                } else if (cmdSource == calView.multButton) {
                    calModel.setInputNo(Double.valueOf(calView.outputField.getText()));
                    calView.outputField.setText("");
                    calModel.setOperator('*');
                } else if (cmdSource == calView.divButton) {
                    calModel.setInputNo(Double.valueOf(calView.outputField.getText()));
                    calView.outputField.setText("");
                    calModel.setOperator('/');
                } else if (cmdSource == calView.sqButton) {
                    calModel.setInputNo(Double.parseDouble(calView.outputField.getText()));
                    calModel.calculateSquare();
                    updateView();
                } else if (cmdSource == calView.sqRtButton) {
                    calModel.setInputNo(Double.parseDouble(calView.outputField.getText()));
                    calModel.calculateSquareRt();
                    updateView();
                } else if (cmdSource == calView.reciprocalButton) {
                    calModel.setInputNo(Double.parseDouble(calView.outputField.getText()));
                    calModel.calculateReciprocal();
                    updateView();
                } else if (cmdSource == calView.equButton) {
                    calModel.calculate();
                    updateView();
                }

            } catch (Exception exception) {
                exception.getMessage();
                System.out.println(exception);
            }
        }

        /**
         * Set all calculator components to true except onButton so that we can allow the calculator to be turned off.
         * The offButton is enabled as well as the other buttons in order for the user to click the button
         */
        private void enable() {
            calView.onButton.setEnabled(false);
            calView.offButton.setEnabled(true);
            calView.nineButton.setEnabled(true);
            calView.eightButton.setEnabled(true);
            calView.sevenButton.setEnabled(true);
            calView.sixButton.setEnabled(true);
            calView.fiveButton.setEnabled(true);
            calView.fourButton.setEnabled(true);
            calView.threeButton.setEnabled(true);
            calView.twoButton.setEnabled(true);
            calView.oneButton.setEnabled(true);
            calView.zeroButton.setEnabled(true);
            calView.decButton.setEnabled(true);
            calView.sqRtButton.setEnabled(true);
            calView.reciprocalButton.setEnabled(true);
            calView.sqButton.setEnabled(true);
            calView.divButton.setEnabled(true);
            calView.multButton.setEnabled(true);
            calView.subButton.setEnabled(true);
            calView.addButton.setEnabled(true);
            calView.equButton.setEnabled(true);
            calView.delButton.setEnabled(true);
            calView.clrButton.setEnabled(true);
        }

        /**
         * Set all calculator components to false except onButton so that we can allow the calcualtor to be turned on
         * The onButton is enabled so that the user can click on the button to turn the calculator back on.
         */
        private void disable() {
            calView.onButton.setEnabled(true);
            calView.offButton.setEnabled(false);
            calView.nineButton.setEnabled(false);
            calView.eightButton.setEnabled(false);
            calView.sevenButton.setEnabled(false);
            calView.sixButton.setEnabled(false);
            calView.fiveButton.setEnabled(false);
            calView.fourButton.setEnabled(false);
            calView.threeButton.setEnabled(false);
            calView.twoButton.setEnabled(false);
            calView.oneButton.setEnabled(false);
            calView.zeroButton.setEnabled(false);
            calView.decButton.setEnabled(false);
            calView.sqRtButton.setEnabled(false);
            calView.reciprocalButton.setEnabled(false);
            calView.sqButton.setEnabled(false);
            calView.divButton.setEnabled(false);
            calView.multButton.setEnabled(false);
            calView.subButton.setEnabled(false);
            calView.addButton.setEnabled(false);
            calView.equButton.setEnabled(false);
            calView.delButton.setEnabled(false);
            calView.clrButton.setEnabled(false);
        }
    }
}
