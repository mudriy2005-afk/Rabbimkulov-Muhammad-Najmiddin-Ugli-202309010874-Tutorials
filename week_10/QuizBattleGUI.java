import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class QuizBattleGUI extends JFrame implements ActionListener {
    private Questions currentQuestion;
    private JLabel lblQuestion;
    private JLabel lblResult;
    private JButton btnOption1;
    private JButton btnOption2;

    public QuizBattleGUI() {
        setTitle("Programming Quiz Battle");
        setSize(450, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        currentQuestion = new Questions(
                "Which keyword creates an object?",
                "new",
                "class",
                "new"
        );

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        lblQuestion = new JLabel(currentQuestion.getQuestion(), SwingConstants.CENTER);
        mainPanel.add(lblQuestion, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        btnOption1 = new JButton(currentQuestion.getOption1());
        btnOption2 = new JButton(currentQuestion.getOption2());

        btnOption1.addActionListener(this);
        btnOption2.addActionListener(this);

        buttonPanel.add(btnOption1);
        buttonPanel.add(btnOption2);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        lblResult = new JLabel("Answer the question!", SwingConstants.CENTER);
        mainPanel.add(lblResult, BorderLayout.SOUTH);

        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String selectedAnswer = clickedButton.getText();

        if (currentQuestion.isCorrect(selectedAnswer)) {
            lblResult.setText("Correct! You defeated the Code Boss!");
        } else {
            lblResult.setText("Wrong! Try Again!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuizBattleGUI gui = new QuizBattleGUI();
            gui.setVisible(true);
        });
    }
}