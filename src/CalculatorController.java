import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel calModel;
    private CalculatorView calView;

    CalculatorController(CalculatorModel model, CalculatorView view) {
        calModel = model;
        calView = view;

        // initiateView();
        // initiateController();


        view.onButton.addActionListener(new Actions());
        view.offButton.addActionListener(new Actions());
        view.addButton.addActionListener(new Actions());
        view.subButton.addActionListener(new Actions());
        view.multButton.addActionListener(new Actions());
        view.divButton.addActionListener(new Actions());
        view.sqRtButton.addActionListener(new Actions());
        view.sqButton.addActionListener(new Actions());
        view.reciprocalButton.addActionListener(new Actions());
        view.equButton.addActionListener(new Actions());
        view.clrButton.addActionListener(new Actions());
        view.delButton.addActionListener(new Actions());
        view.oneButton.addActionListener(new Actions());
        view.twoButton.addActionListener(new Actions());
        view.threeButton.addActionListener(new Actions());
        view.fourButton.addActionListener(new Actions());
        view.fiveButton.addActionListener(new Actions());
        view.sixButton.addActionListener(new Actions());
        view.sevenButton.addActionListener(new Actions());
        view.eightButton.addActionListener(new Actions());
        view.nineButton.addActionListener(new Actions());
        view.zeroButton.addActionListener(new Actions());
        view.decButton.addActionListener(new Actions());
    }

    class Actions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object cmdSource = e.getSource();

                if (calView.outputField.getText().equals("NaN") || calView.outputField.getText().equals("Infinity")) {
                    calModel.resetDisplay();
                }

                for (int i = 0; i < 10; i++) {
                    if (cmdSource == calView.numBtnsArry[i]) {
                        calView.outputField.setText(calView.outputField.getText().concat(String.valueOf(i)));
                    }
                }

                if (cmdSource == calView.onButton) {
                    enable();
                } else if (cmdSource == calView.offButton) {
                    disable();
                } else if (cmdSource == calView.clrButton) {
                    clearOutput();
                } else if (cmdSource == calView.delButton) {
                    deleteInput();
         
                } else if (cmdSource == calView.decButton) {
                    if (calView.outputField.getText().contains(".")) {
                        return;
                    } else {
                        calView.outputField.setText(calView.outputField.getText() + ".");
                    }
                } else if (cmdSource == calView.addButton) {
                    calModel.inputNo = Double.parseDouble(calView.outputField.getText());
                    calView.outputField.setText("");
                    calModel.operator = '+';
                } else if (cmdSource == calView.subButton) {
                    calModel.inputNo = Double.parseDouble(calView.outputField.getText());
                    calView.outputField.setText("");
                    calModel.operator = '-';
                } else if (cmdSource == calView.multButton) {
                    calModel.inputNo = Double.parseDouble(calView.outputField.getText());
                    calView.outputField.setText("");
                    calModel.operator = '*';
                } else if (cmdSource == calView.divButton) {
                    calModel.inputNo = Double.parseDouble(calView.outputField.getText());
                    calView.outputField.setText("");
                    calModel.operator = '/';
                } else if (cmdSource == calView.sqButton) {
                    calculateSquare();
                } else if (cmdSource == calView.sqRtButton) {
                    calculateSquareRt();
                } else if (cmdSource == calView.reciprocalButton) {
                    calculateReciprocal();
                } else if (cmdSource == calView.equButton) {
                    calculate();
                }


            } catch (Exception exception) {
                exception.getMessage();
                System.out.println(exception);
            } 
        }

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

        private void clearOutput() {
            calView.outputField.setText(Integer.toString(calModel.resetVal));
        }

        private void deleteInput() {
            // Variable length takes length of getText (i.e. calculator entry in outputField)
            // We will use StringBuilder to create a mutable string of chars like an array from the outputField entry.
            int length = calView.outputField.getText().length();
            // Val removes one number from the length of getText entry so that it starts deleting from the last element of our string of chars
            int val = length - 1;
    
            // If outputField length is NOT empty or begins at the 0 index start deleting
            if (length > 0) {
                StringBuilder delBack = new StringBuilder(calView.outputField.getText());
                delBack.deleteCharAt(val);
                calView.outputField.setText(delBack.toString());
            } else {
                calView.outputField.setText("0"); // Problem: If you press another # afterward, it appears like (ex. 02)
            }
        }

        private void calculateSquare() {
            // Error handling for squaring an empty field
            if (calView.outputField.getText().equals("")) {
                calView.outputField.setText("NaN");
            } else {
                calModel.inputNo = Double.parseDouble(calView.outputField.getText());
                double square = Math.pow(calModel.inputNo, 2);
                String squareStr = Double.toString(square);
                if (squareStr.endsWith(".0")) {
                    calView.outputField.setText(squareStr.replace(".0", ""));
                } else {
                    calView.outputField.setText(squareStr);
                }
            }
        }

        private void calculateSquareRt() {
            // Error handling for square rooting an empty field
            if (calView.outputField.getText().equals("")) {
                calView.outputField.setText("NaN");
            } else {
                calModel.inputNo = Double.parseDouble(calView.outputField.getText());
                Double squareRt = Math.sqrt(calModel.inputNo);
                String sqRtStr = Double.toString(squareRt);
                if (sqRtStr.endsWith(".0")) {
                    calView.outputField.setText(sqRtStr.replace(".0", ""));
                } else {
                    calView.outputField.setText(sqRtStr);
                }
            }
        }
    
        private void calculateReciprocal() {
            // Error handling for getting the reciprocal of an empty field
            if (calView.outputField.getText().equals("")) {
                calView.outputField.setText("NaN");
            } else {
                calModel.inputNo = Double.parseDouble(calView.outputField.getText());
                Double reciprocal = 1 / calModel.inputNo;
                String reciprocalStr = Double.toString(reciprocal);
                if (reciprocalStr.endsWith(".0")) {
                    calView.outputField.setText(reciprocalStr.replace(".0", ""));
                } else {
                    calView.outputField.setText(reciprocalStr);
                }
            }
        }
    
        private void calculate() {
            // We will replace the .0 for all of our double calculations that are not a decimal (i.e. Double)
            switch (calModel.operator) {
                case '+':
                calModel.answer = calModel.inputNo + Double.parseDouble(calView.outputField.getText());
                    if (Double.toString(calModel.answer).endsWith(".0")) {
                        calView.outputField.setText(Double.toString(calModel.answer).replace(".0", ""));
                    } else {
                        calView.outputField.setText(Double.toString(calModel.answer));
                    }
                    break;
                case '-':
                calModel.answer = calModel.inputNo - Double.parseDouble(calView.outputField.getText());
                    if (Double.toString(calModel.answer).endsWith(".0")) {
                        calView.outputField.setText(Double.toString(calModel.answer).replace(".0", ""));
                    } else {
                        calView.outputField.setText(Double.toString(calModel.answer));
                    }
                    break;
                case '*':
                calModel.answer = calModel.inputNo * Double.parseDouble(calView.outputField.getText());
                    if (Double.toString(calModel.answer).endsWith(".0")) {
                        calView.outputField.setText(Double.toString(calModel.answer).replace(".0", ""));
                    } else {
                        calView.outputField.setText(Double.toString(calModel.answer));
                    }
                    break;
                case '/':
                calModel.answer = calModel.inputNo / Double.parseDouble(calView.outputField.getText());
                    if (Double.toString(calModel.answer).endsWith(".0")) {
                        calView.outputField.setText(Double.toString(calModel.answer).replace(".0", ""));
                    } else {
                        calView.outputField.setText(Double.toString(calModel.answer));
                    }
                    break;
            }
        }
    }

    // private void initiateView() {
    //     updateView();
    // }

    // private void updateView() {
    //     calView.getOutputField().
    // }
}

