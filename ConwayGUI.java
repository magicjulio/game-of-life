package conway.gui;

import conway.game.GameOfLife;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConwayGUI {
    
    private JFrame frame;

    private JPanel frameHolder;

    private JPanel[][] grid;

    /** The screen width of the window */
	private int screenWidth;
	
	/** the screen height of the window */
	private int screenHeight;
	
    private GameOfLife game;

    public ConwayGUI(GameOfLife game) {
        this.game = game;
		this.grid = new JPanel[game.getGeneration().length][game.getGeneration()[0].length];
		initialize();
		this.frame.setVisible(true);
    }

    private void initialize() {
        // Get Dimension of the screen
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.screenWidth = (int) (screen.getWidth() * 0.5);
		this.screenHeight = (int) (screen.getHeight() * 0.5);

        this.frame = new JFrame();
		this.frame.setBounds(0,0,screenHeight + 25, screenHeight + 45);

		this.frame = new JFrame();
		this.frame.setBounds(0,0,screenHeight + 25,screenHeight + 45);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		this.frame.setLocation(this.screenWidth - this.frame.getHeight() / 2,this.screenHeight - this.frame.getWidth() / 2);
		this.frame.setResizable(false);
		this.frame.setTitle("Conway's Game of Life");



        this.paintGrid();


		this.frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_SPACE) {
					game.calculateNextGeneration();
					repaint();
					
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

    }


    private void paintGrid() {
        if (this.frameHolder != null) this.frame.remove(this.frameHolder);
		this.frameHolder = new JPanel(new GridBagLayout());
		this.frameHolder.setBounds(0,0,screenHeight + 10,screenHeight + 10);
		this.frameHolder.setBackground(Color.white);

        GridBagConstraints c = new GridBagConstraints();
		for (int i = 0;i < game.getGeneration().length;i++) {
			for (int j = 0;j<game.getGeneration()[i].length;j++) {
					JPanel panel = new JPanel();
					panel.setSize(screenHeight / game.getGeneration().length, screenHeight / game.getGeneration()[0].length);
					panel.setPreferredSize(new Dimension(screenHeight / game.getGeneration().length,screenHeight / game.getGeneration()[0].length));
					c.gridx = i;
					c.gridy = j;
					panel.setBackground(game.getGeneration()[i][j] == 0 ? Color.WHITE : Color.BLACK);
					this.grid[i][j] = panel;
					this.frameHolder.add(panel,c);
			}
		}
		this.frame.add(this.frameHolder);

    }


	public void repaint() {
		// Change name
		this.frame.setTitle("Conway's Game of Life iteration: " + game.getIteration());
		for (int i = 0;i < game.getGeneration().length;i++) {
			for (int j = 0;j<game.getGeneration()[i].length;j++) {
				this.grid[i][j].setBackground(game.getGeneration()[i][j] == 0 ? Color.WHITE : Color.BLACK);
			}
		}
	}
	
}
