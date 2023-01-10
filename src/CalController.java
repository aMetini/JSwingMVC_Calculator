import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalController {
    private CalModel calModel;
    private CalculatorView calView;

    CalController(CalModel model, CalculatorView view) {
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
                    calModel.resetCalculator();
                    updateView();
                } else if (cmdSource == calView.delButton) {
                    calModel.deleteInput();
                    updateView();
                } else if (cmdSource == calView.decButton) {
                    calModel.inputDec();
                    updateView();
                } else if (cmdSource == calView.addButton) {
                    calModel.setOperation('+');
                    updateView();
                } else if (cmdSource == calView.subButton) {
                    calModel.setOperation('-');
                    updateView();
                } else if (cmdSource == calView.multButton) {
                    calModel.setOperation('*');
                    updateView();
                } else if (cmdSource == calView.divButton) {
                    calModel.setOperation('/');
                    updateView();
                } else if (cmdSource == calView.sqButton) {
                    //calculateSquare();
                } else if (cmdSource == calView.sqRtButton) {
                    calModel.calculateSquareRt();
                } else if (cmdSource == calView.reciprocalButton) {
                    //calculateReciprocal();
                } else if (cmdSource == calView.equButton) {
                    calModel.calculate();
                    updateView();
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
        /* 
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
            } */
        }
    }

    // private void initiateView() {
    //     updateView();
    // }

    // private void updateView() {
    //     calView.getOutputField().
    // }
//}

