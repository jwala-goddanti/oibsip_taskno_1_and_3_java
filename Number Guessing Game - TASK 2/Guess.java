import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Guess extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private int randomNumber;
    private int remainingAttempts = 10;
    private JLabel prompt;
    private JLabel attemptsLabel;
    private JTextField guessTextField;
    private JButton guessButton;
    private JButton playAgainButton;
    private JButton giveUpButton;
    private JButton hintButton;
    private JLabel hintLabel;
    private JLabel resultLabel;
    private JLabel image2;
    private ImageIcon think, sad,happy;
    public Guess() {
      super("Guess The Number");
      setLayout(new BorderLayout());
      setContentPane(new JLabel(new ImageIcon("guess.jpg")));
      setLayout(null);
      setSize(1200, 900);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      
      JLabel heading = new JLabel("Guess The Number");
      heading.setFont(new Font("Arial", Font.BOLD, 50));
      //heading.setForeground(Color.RED);
      heading.setHorizontalAlignment(JLabel.CENTER);
      heading.setVerticalAlignment(JLabel.CENTER);
      heading.setBounds(0, 0, 1200, 100);
      add(heading);

      

      resultLabel = new JLabel("");
      resultLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
      resultLabel.setBounds(400, 150, 400, 35);
      resultLabel.setHorizontalAlignment(JLabel.CENTER);
      add(resultLabel);

      attemptsLabel = new JLabel("Attempts remaining: " + remainingAttempts);
      attemptsLabel.setBounds(500, 200, 200, 30);
      attemptsLabel.setHorizontalAlignment(JLabel.CENTER);
      add(attemptsLabel);

      prompt = new JLabel("Enter a number b/w 1-100");
      prompt.setFont(new Font("Arial", Font.PLAIN, 15));
      prompt.setBounds(400, 230, 400, 25);
      prompt.setHorizontalAlignment(JLabel.CENTER);
      add(prompt);

      guessTextField = new JTextField(20);
      guessTextField.setBounds(500, 250, 200, 25);
      guessTextField.setHorizontalAlignment(JTextField.CENTER);
      add(guessTextField);

      guessButton = new JButton("Guess");
      guessButton.setBounds(500, 300, 200, 25);
      guessButton.addActionListener(this);
      guessButton.setHorizontalAlignment(JButton.CENTER);
      add(guessButton);

      playAgainButton = new JButton("Play Again");
      playAgainButton.setBounds(500, 350, 200, 25);
      playAgainButton.addActionListener(this);
      playAgainButton.setHorizontalAlignment(JButton.CENTER);
      add(playAgainButton);

      giveUpButton = new JButton("Give Up");
      giveUpButton.setBounds(500, 400, 200, 25);
      giveUpButton.addActionListener(this);
      giveUpButton.setHorizontalAlignment(JButton.CENTER);
      add(giveUpButton);

      hintButton = new JButton("Hint");
      hintButton.setBounds(500, 450, 200, 25);
      hintButton.addActionListener(this);
      hintButton.setHorizontalAlignment(JButton.CENTER);
      add(hintButton);

      hintLabel = new JLabel("");
      hintLabel.setBounds(500, 500, 200, 25);
      hintLabel.setHorizontalAlignment(JLabel.CENTER);
      add(hintLabel);

      think = new ImageIcon("think.jpg");
      Image img = think.getImage();
      Image resizedImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
      think.setImage(resizedImg);
      sad = new ImageIcon("sad.jpg");
      Image img1 = sad.getImage();
      Image resizedImg1 = img1.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
      sad.setImage(resizedImg1);
      happy = new ImageIcon("winner.jpg");
      Image img2 = happy.getImage();
      Image resizedImg2 = img2.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
      happy.setImage(resizedImg2);

      JLabel image = new JLabel(new ImageIcon(new ImageIcon("boycnt.jpg").getImage().getScaledInstance(500 ,600 , Image.SCALE_DEFAULT)));
	image.setBounds(950 ,0 ,500 ,600 );
	add(image);
   
   image2 = new JLabel();
   image2.setIcon(think);
	image2.setBounds(70 ,100 ,300 ,300 );
	add(image2);

      

      randomNumber = (int) (Math.random() * (100 - 1)) + 1;
  }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            int guess = Integer.parseInt(guessTextField.getText());
            if (guess == randomNumber) {
                resultLabel.setText("You win!");
                guessTextField.setEnabled(false);
                guessButton.setEnabled(false);
                image2.setIcon(happy);
                image2.setBounds(70 ,100 ,400 ,400 );
            } else if (guess > randomNumber) {
                resultLabel.setText(" Too high!");
            } else {
                resultLabel.setText(" Too low!");
            }
            remainingAttempts--;
            attemptsLabel.setText("Attempts remaining: " + remainingAttempts);
            if (remainingAttempts == 0) {
                resultLabel.setText("You lose! The number was " + randomNumber + ".");
                guessTextField.setEnabled(false);
                guessButton.setEnabled(false);
                image2.setIcon(sad);
            }
            guessTextField.setText("");
            hintLabel.setText("");
            return;
        }

        if (e.getSource() == playAgainButton) {
            randomNumber = (int) (Math.random() * (100 - 1)) + 1;
            remainingAttempts = 10;
            attemptsLabel.setText("Attempts remaining: " + remainingAttempts);
            guessTextField.setEnabled(true);
            guessTextField.setText("");
            guessButton.setEnabled(true);
            resultLabel.setText("");
            hintLabel.setText("");
            image2.setIcon(think);
            return;
        }

        if (e.getSource() == giveUpButton) {
            resultLabel.setText("You lose! The number was " + randomNumber + ".");
            guessTextField.setEnabled(false);
            guessButton.setEnabled(false);
           image2.setIcon(sad);
            return;
        }

        if (e.getSource() == hintButton) {
            int first = randomNumber-(randomNumber%10);
            int last = first+10;
            resultLabel.setText("The number is between "+first+" and " + last+ ".");
            return;
        }
      }
        public static void main(String[] args) {
         Guess game = new Guess();
         game.setVisible(true);
     }
 }