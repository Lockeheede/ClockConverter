import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockConverterGUI extends JFrame implements ActionListener {
    private JTextField hoursInput = new JTextField(10);
    private JTextField minutesInput = new JTextField(10);
    private JTextField secondsInput = new JTextField(10);
    private JButton convertButton = new JButton("Convert");
    private JButton resetButton = new JButton("Reset");
    private JLabel resultLabel = new JLabel("Total time will be displayed here");

    // Variables to hold the running total of time
    private int totalHours = 0;
    private int totalMinutes = 0;
    private int totalSeconds = 0;

    public ClockConverterGUI() {
        super("Clock Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Set up the main panel with BoxLayout for vertical arrangement
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        // Create panels for each row
        JPanel hoursPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel minutesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel secondsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        hoursPanel.add(new JLabel("Enter number of hours:"));
        hoursPanel.add(hoursInput);

        minutesPanel.add(new JLabel("Enter number of minutes:"));
        minutesPanel.add(minutesInput);

        secondsPanel.add(new JLabel("Enter number of seconds:"));
        secondsPanel.add(secondsInput);

        buttonPanel.add(convertButton);
        buttonPanel.add(resetButton);

        // Add all panels to main panel
        mainPanel.add(hoursPanel);
        mainPanel.add(minutesPanel);
        mainPanel.add(secondsPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultLabel);

        // Adding padding around the main panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Add the main panel to the frame
        getContentPane().add(mainPanel);
        
        // Adjust size to accommodate new layout
        pack();

        // Register listeners for the buttons
        convertButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            try {
                int numHours = Integer.parseInt(hoursInput.getText());
                int numMinutes = Integer.parseInt(minutesInput.getText());
                int numSeconds = Integer.parseInt(secondsInput.getText());

                totalSeconds += numSeconds;
                totalMinutes += numMinutes + secondsToMinutes(totalSeconds);
                totalHours += numHours + minutesToHours(totalMinutes);

                totalSeconds = secondsLeftOver(totalSeconds);
                totalMinutes = minutesLeftOver(totalMinutes);

                resultLabel.setText(String.format("Total time : %d:%02d:%02d", totalHours, totalMinutes, totalSeconds));

                // Clear input fields after conversion
                hoursInput.setText("");
                minutesInput.setText("");
                secondsInput.setText("");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        } else if (e.getSource() == resetButton) {
            totalHours = 0;
            totalMinutes = 0;
            totalSeconds = 0;
            resultLabel.setText("Total time will be displayed here");
            
            // Clear input fields on reset
            hoursInput.setText("");
            minutesInput.setText("");
            secondsInput.setText("");
        }
    }

    private int minutesToHours(int minutes) {
        return minutes / 60;
    }

    private int minutesLeftOver(int minutes) {
        return minutes % 60;
    }

    private int secondsToMinutes(int seconds) {
        return seconds / 60;
    }

    private int secondsLeftOver(int seconds) {
        return seconds % 60;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClockConverterGUI().setVisible(true));
    }
}
