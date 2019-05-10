import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

public class GUI extends JFrame {
	Puzzle puzzle = new Puzzle();
	Figure[][] figures = new Figure[4][4];
	Rect rect = new Rect(dh, dw, dw, dh, puz);

	CanvasPanel canvasPanel = new CanvasPanel();
	JPanel controlPanel = new JPanel();

	JButton restart = new JButton("Restart");
	JTextField moves = new JTextField(String.valueOf(c), 5);
	JButton shuffle = new JButton("Shuffle");

	static int c = 0;
	private static int w = 600;
	private static int h = 665;
	private static int puz = 0;
	private static int dw = w / 4;
	private static int dh = w / 4;

	GUI() {
		add(canvasPanel);
		canvasPanel.setBackground(Color.BLACK);
		canvasPanel.setFocusable(true);
		canvasPanel.addKeyListener(new PanelKeyListener());
		canvasPanel.addMouseListener(new PanelMouseListener());

		controlPanel.setBackground(Color.GRAY);
		controlPanel.add(restart);
		controlPanel.add(moves);
		controlPanel.add(shuffle);
		add(controlPanel, BorderLayout.SOUTH);
		restart.setFocusable(false);
		restart.addActionListener(new RestartButtonListener());
		shuffle.setFocusable(false);
		shuffle.addActionListener(new ShuffleButtonListener());
	}

	public static void main(String[] args) {
		GUI frame = new GUI();
		frame.setTitle("Puzzle 15");
		frame.setSize(w, h);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	class CanvasPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2 = (Graphics2D) g;
			for (int i = 0; i < 4; ++i) {
				for (int j = 0; j < 4; ++j) {
					g2.setStroke(new BasicStroke(3));
					g2.setColor(Color.RED);
					g2.drawRoundRect(dw * j, dh * i, dw, dh, w / 30, h / 30);
				}
			}

			for (int i = 0; i < 4; ++i) {
				for (int j = 0; j < 4; ++j) {
					figures[i][j] = new Rect(dw * j, dh * i, dw, dh, puzzle.puzzle[i][j]);
					figures[i][j].draw(g2);
				}
			}
		}
	}

	class PanelKeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
				puzzle.move("W");
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
				puzzle.move("S");
			}

			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				puzzle.move("D");
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
				puzzle.move("A");
			}
			puzzle.coorEmp();
			++c;
			moves.setText("  " + c + "  ");
			repaint();
			if (puzzle.solved() == 16 && c > 1) {
				JOptionPane.showMessageDialog(null, "You are winner!!!");
			}
		}
	}

	class PanelMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			// for (int i = 0; i < 4; ++i) {
			// for (int j = 0; j < 4; ++j) {
			// if (puzzle.puzzle[][])
			// }
			// }
		}
	}

	class RestartButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			puzzle.start();
			c = 0;
			repaint();
		}
	}

	class ShuffleButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			puzzle.start();
			int shfl = Integer.parseInt(JOptionPane.showInputDialog(null, "Number of moves to shuffle:"));
			puzzle.shuffle(shfl);
			repaint();
		}
	}
}
