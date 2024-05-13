import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpringCalculator {
    private JFrame frame;
    private JTextField stiffnessField;
    private JTextField compressionField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public SpringCalculator() {
        frame = new JFrame("Калькулятор пружини");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 2));

        JLabel stiffnessLabel = new JLabel("Жорсткість пружини (k):");
        stiffnessField = new JTextField();
        JLabel compressionLabel = new JLabel("Стиснення пружини (x):");
        compressionField = new JTextField();
        calculateButton = new JButton("Розрахувати");
        resultLabel = new JLabel("");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateForce();
            }
        });

        frame.add(stiffnessLabel);
        frame.add(stiffnessField);
        frame.add(compressionLabel);
        frame.add(compressionField);
        frame.add(calculateButton);
        frame.add(resultLabel);
    }

    public void show() {
        frame.setVisible(true);
    }

    private void calculateForce() {
        try {
            double stiffness = Double.parseDouble(stiffnessField.getText());
            double compression = Double.parseDouble(compressionField.getText());
            double force = stiffness * compression;
            resultLabel.setText("Сила (F): " + force);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Введіть числові значення для жорсткості та стиснення.", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SpringCalculator calculator = new SpringCalculator();
                calculator.show();
            }
        });
    }
}