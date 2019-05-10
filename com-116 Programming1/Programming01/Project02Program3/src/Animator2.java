import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Animator2 extends JFrame {
	String title = "Surrounding";
	Color background = Color.BLACK;
	int delay = 10;

	Color firstBallColor = Color.RED;
	int firstBallX, firstBallY;
	int firstBallRadius = 10;
	int firstBallDiameter = firstBallRadius*2;
	
	Color secondBallColor = Color.BLUE;
	int secondBallX, secondBallY;
	int secondBallRadius = 10;
	int secondBallDiameter = secondBallRadius*2;
	
	double alpha = 0;
	double dAlpha = 0.1;
	
	void start() {
		int width = getWidth();
		int height = getHeight();
		firstBallX = getWidth() / 2;
		firstBallY = getHeight() / 2;
		
		firstBallRadius = Math.min(width, height) / 10;
		firstBallDiameter = firstBallRadius*2;
		
		secondBallRadius = Math.min(width, height) / 20;
		secondBallDiameter = secondBallRadius*2;
	}

	void update() {
		secondBallX = (int) (firstBallX + Math.cos(alpha) * firstBallDiameter);
		secondBallY = (int) (firstBallY - Math.sin(alpha) * firstBallDiameter);
		alpha += dAlpha;
	}

	void draw(Graphics g) {
        g.setColor(firstBallColor);
        int x = firstBallX - firstBallRadius;
        int y = firstBallY - firstBallRadius;
        g.fillOval(x, y, firstBallDiameter, firstBallDiameter);
        
        g.setColor(secondBallColor);
        int x2 = secondBallX - secondBallRadius;
        int y2 = secondBallY - secondBallRadius;
        g.fillOval(x2, y2, secondBallDiameter, secondBallDiameter);
	}

	public Animator2() {
		setTitle(title);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawPanel panel = new DrawPanel();

		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			}
		});

		add(panel);

		javax.swing.Timer timer = new javax.swing.Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});

		setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);

		start();
		
		timer.start();
	}

	public static void main(String[] args) {
		new Animator2();
	}

	class DrawPanel extends JPanel {
		public DrawPanel() {
			setBackground(background);
			setFocusable(true);
			requestFocusInWindow();
			setDoubleBuffered(true);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			draw(g);
		}
	}
}
