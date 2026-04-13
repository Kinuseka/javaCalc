import javax.swing.*;
import java.awt.*;

public class GUICalculator extends JFrame {

    private JTextField txtDisplay;
    private final CalculatorController controller;

    public GUICalculator() {
        setTitle("Calculator");
        setSize(350, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        controller = new CalculatorController();

        JPanel wrapper = new JPanel(new BorderLayout(10, 10));
        wrapper.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(wrapper);

        txtDisplay = new JTextField("0");
        txtDisplay.setFont(new Font("Arial", Font.PLAIN, 28));
        txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
        txtDisplay.setPreferredSize(new Dimension(0, 70));
        txtDisplay.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        wrapper.add(txtDisplay, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridBagLayout());
        grid.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        wrapper.add(grid, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        JButton btnClear = createButton("Clear");
        JButton btnDivide = createButton("/");
        JButton btnMultiply = createButton("*");
        JButton btnMinus = createButton("-");

        JButton btn7 = createButton("7");
        JButton btn8 = createButton("8");
        JButton btn9 = createButton("9");

        JButton btnPlus = createButton("+");

        JButton btn4 = createButton("4");
        JButton btn5 = createButton("5");
        JButton btn6 = createButton("6");

        JButton btn1 = createButton("1");
        JButton btn2 = createButton("2");
        JButton btn3 = createButton("3");

        JButton btnEquals = createButton("=");

        JButton btn0 = createButton("0");
        JButton btnDot = createButton(".");

        addButton(grid, btnClear, gbc, 0, 0, 1, 1);
        addButton(grid, btnDivide, gbc, 1, 0, 1, 1);
        addButton(grid, btnMultiply, gbc, 2, 0, 1, 1);
        addButton(grid, btnMinus, gbc, 3, 0, 1, 1);

        addButton(grid, btn7, gbc, 0, 1, 1, 1);
        addButton(grid, btn8, gbc, 1, 1, 1, 1);
        addButton(grid, btn9, gbc, 2, 1, 1, 1);
        addButton(grid, btnPlus, gbc, 3, 1, 1, 2);

        addButton(grid, btn4, gbc, 0, 2, 1, 1);
        addButton(grid, btn5, gbc, 1, 2, 1, 1);
        addButton(grid, btn6, gbc, 2, 2, 1, 1);

        addButton(grid, btn1, gbc, 0, 3, 1, 1);
        addButton(grid, btn2, gbc, 1, 3, 1, 1);
        addButton(grid, btn3, gbc, 2, 3, 1, 1);
        addButton(grid, btnEquals, gbc, 3, 3, 1, 2);

        addButton(grid, btn0, gbc, 0, 4, 2, 1);
        addButton(grid, btnDot, gbc, 2, 4, 1, 1);

        btn0.addActionListener(e -> append("0"));
        btn1.addActionListener(e -> append("1"));
        btn2.addActionListener(e -> append("2"));
        btn3.addActionListener(e -> append("3"));
        btn4.addActionListener(e -> append("4"));
        btn5.addActionListener(e -> append("5"));
        btn6.addActionListener(e -> append("6"));
        btn7.addActionListener(e -> append("7"));
        btn8.addActionListener(e -> append("8"));
        btn9.addActionListener(e -> append("9"));
        btnDot.addActionListener(e -> append("."));

        btnPlus.addActionListener(e -> setOp("+"));
        btnMinus.addActionListener(e -> setOp("-"));
        btnMultiply.addActionListener(e -> setOp("*"));
        btnDivide.addActionListener(e -> setOp("/"));

        btnEquals.addActionListener(e -> {
            String result = controller.calculate(txtDisplay.getText());
            txtDisplay.setText(result);
        });

        btnClear.addActionListener(e -> {
            txtDisplay.setText("0");
            controller.clear();
        });

    }


    private void setOp(String op) {
        controller.setOperator(op, txtDisplay.getText());
        txtDisplay.setText("0");
    }

    private void append(String value) {
        if (txtDisplay.getText().equals("0")) {
            txtDisplay.setText(value);
        } else {
            txtDisplay.setText(txtDisplay.getText() + value);
        }
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.PLAIN, 16));
        btn.setFocusPainted(false);
        return btn;
    }

    private void addButton(JPanel panel, JButton btn, GridBagConstraints gbc,
                           int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        panel.add(btn, gbc);
    }

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        SwingUtilities.invokeLater(() -> {
            GUICalculator frame = new GUICalculator();
            frame.setVisible(true);
        });
    }
}
