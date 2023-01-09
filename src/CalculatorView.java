import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    public JFrame frame;
    public JTextField outputField;
    public JRadioButton onButton;
    public JRadioButton offButton;
    public JButton zeroButton;
    public JButton oneButton;
    public JButton twoButton;
    public JButton threeButton;
    public JButton fourButton;
    public JButton fiveButton;
    public JButton sixButton;
    public JButton sevenButton;
    public JButton eightButton;
    public JButton nineButton;
    public JButton addButton;
    public JButton subButton;
    public JButton multButton;
    public JButton divButton;
    public JButton decButton;
    public JButton equButton;
    public JButton delButton;
    public JButton clrButton;
    public JButton sqButton;
    public JButton reciprocalButton;
    public JButton sqRtButton;
    public JButton[] numBtnsArry;

    private final Font FONT = new Font("Sans Serif", Font.BOLD, 20);
    private final Font FONT17 = new Font("Sans Serif", Font.BOLD, 18);

    public CalculatorView() {
        createCalculatorFrame();
        addCalComponents();
    }

    private void createCalculatorFrame() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 490); // 420, 550
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(new Color(44, 203, 188));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addCalComponents() {
        outputField = new JTextField();
        outputField.setBounds(10, 40, 270, 40); // 50, 25, 300, 50
        outputField.setFont(FONT);
        outputField.setEditable(false);
        outputField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(outputField);
        //outputField.setText(Integer.toString(resetVal)); //I want to be able to set the calculator to 0 but replace it with another # if another # is pressed
        // Problem: If you start at 0 and then press (ex) 2, the display will look like "02".
        
        onButton = new JRadioButton("On");
        onButton.setBounds(10, 95, 60, 40);
        onButton.setSelected(true);
        onButton.setFont(new Font("Sans Serif", Font.BOLD, 14));
        onButton.setBackground(Color.black);
        onButton.setForeground(Color.white);
        onButton.setFocusable(false);
        frame.add(onButton);

        offButton = new JRadioButton("Off");
        offButton.setBounds(10, 120, 60, 40);
        offButton.setSelected(false);
        offButton.setFont(new Font("Sans Serif", Font.BOLD, 14));
        offButton.setBackground(Color.black);
        offButton.setForeground(Color.white);
        offButton.setFocusable(false);
        frame.add(offButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(onButton);
        buttonGroup.add(offButton);

        sevenButton = new JButton("7");
        sevenButton.setBounds(10, 230, 60, 40);
        sevenButton.setFont(FONT);
        frame.add(sevenButton);

        eightButton = new JButton("8");
        eightButton.setBounds(80, 230, 60, 40);
        eightButton.setFont(FONT);
        frame.add(eightButton);

        nineButton = new JButton("9");
        nineButton.setBounds(150, 230, 60, 40);
        nineButton.setFont(FONT);
        frame.add(nineButton);

        fourButton = new JButton("4");
        fourButton.setBounds(10, 290, 60, 40);
        fourButton.setFont(FONT);
        frame.add(fourButton);

        fiveButton = new JButton("5");
        fiveButton.setBounds(80, 290, 60, 40);
        fiveButton.setFont(FONT);
        frame.add(fiveButton);

        sixButton = new JButton("6");
        sixButton.setBounds(150, 290, 60, 40);
        sixButton.setFont(FONT);
        frame.add(sixButton);

        oneButton = new JButton("1");
        oneButton.setBounds(10, 350, 60, 40);
        oneButton.setFont(FONT);
        frame.add(oneButton);

        twoButton = new JButton("2");
        twoButton.setBounds(80, 350, 60, 40);
        twoButton.setFont(FONT);
        frame.add(twoButton);

        threeButton = new JButton("3");
        threeButton.setBounds(150, 350, 60, 40);
        threeButton.setFont(FONT);
        frame.add(threeButton);

        decButton = new JButton(".");
        decButton.setBounds(150, 410, 60, 40);
        decButton.setFont(FONT);
        frame.add(decButton);

        zeroButton = new JButton("0");
        zeroButton.setBounds(10, 410, 130, 40);
        zeroButton.setFont(FONT);
        frame.add(zeroButton);

        equButton = new JButton("=");
        equButton.setBounds(220, 350, 60, 100);
        equButton.setFont(FONT);
        equButton.setBackground(new Color(88, 214, 141));
        frame.add(equButton);

        divButton = new JButton("/");
        divButton.setBounds(220, 110, 60, 40);
        divButton.setFont(FONT);
        divButton.setBackground(new Color(247, 220, 111));
        frame.add(divButton);

        sqRtButton = new JButton("\u221A");
        sqRtButton.setBounds(10, 170, 60, 40);
        sqRtButton.setFont(FONT);
        sqRtButton.setBackground(new Color(247, 220, 111));
        frame.add(sqRtButton);

        sqButton = new JButton("x\u00B2");
        sqButton.setBounds(80, 170, 60, 40);
        sqButton.setFont(FONT);
        sqButton.setBackground(new Color(247, 220, 111));
        frame.add(sqButton);

        reciprocalButton = new JButton("1/x");
        reciprocalButton.setBounds(150, 170, 60, 40);
        reciprocalButton.setFont(FONT17);
        reciprocalButton.setBackground(new Color(247, 220, 111));
        frame.add(reciprocalButton);

        multButton = new JButton("*");
        multButton.setBounds(220, 170, 60, 40);
        multButton.setFont(FONT);
        multButton.setBackground(new Color(247, 220, 111));
        frame.add(multButton);

        subButton = new JButton("-");
        subButton.setBounds(220, 230, 60, 40);
        subButton.setFont(FONT);
        subButton.setBackground(new Color(247, 220, 111));
        frame.add(subButton);

        addButton = new JButton("+");
        addButton.setBounds(220, 290, 60, 40);
        addButton.setFont(FONT);
        addButton.setBackground(new Color(247, 220, 111));
        frame.add(addButton);

        delButton = new JButton("Del");
        delButton.setBounds(150, 110, 60, 40);
        delButton.setFont(FONT17);
        delButton.setBackground(new Color(216, 87, 51));
        frame.add(delButton);

        clrButton = new JButton("AC");
        clrButton.setBounds(80, 110, 60, 40);
        clrButton.setFont(FONT17);
        clrButton.setBackground(new Color(216, 87, 51));
        frame.add(clrButton);
        
        numBtnsArry = new JButton[10];
        numBtnsArry[0] = zeroButton;
        numBtnsArry[1] = oneButton;
        numBtnsArry[2] = twoButton;
        numBtnsArry[3] = threeButton;
        numBtnsArry[4] = fourButton;
        numBtnsArry[5] = fiveButton;
        numBtnsArry[6] = sixButton;
        numBtnsArry[7] = sevenButton;
        numBtnsArry[8] = eightButton;
        numBtnsArry[9] = nineButton;
    }

    public JTextField getOutputField() {
        return outputField;
    }
    
}
