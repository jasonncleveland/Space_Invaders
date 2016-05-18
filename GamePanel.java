import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel{

	private ImageIcon smallAlien_1 = new ImageIcon("images/aliens/smallInvader.png");
	private ImageIcon smallAlien_2 = new ImageIcon("images/aliens/smallInvader_2.png");
	private ImageIcon mediumAlien_1 = new ImageIcon("images/aliens/mediumInvader.png");
	private ImageIcon mediumAlien_2 = new ImageIcon("images/aliens/mediumInvader_2.png");
	private ImageIcon largeAlien_1 = new ImageIcon("images/aliens/largeInvader.png");
	private ImageIcon largeAlien_2 = new ImageIcon("images/aliens/largeInvader_2.png");
	private ImageIcon ufo = new ImageIcon("images/aliens/ufo.png");
	
	private Alien[][] aliens = new Alien[5][11];
	
	public GamePanel(){
		int x = 48, y = 60;
		for(int i = 0; i < aliens.length; i++){
			for(int j = 0; j < aliens[i].length; j++){
				if(i < 1)
					aliens[i][j] = new Alien(x, y, 10, smallAlien_1);
				else if(i < 3)
					aliens[i][j] = new Alien(x, y, 20, mediumAlien_1);
				else if(i < 5)
					aliens[i][j] = new Alien(x, y, 30, largeAlien_1);
				
				x += 64;
			}
			y += 64;
			x = 48;
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 600);
		for(int i = 0; i < aliens.length; i++){
			for(int j = 0; j < aliens[i].length; j++){
				Alien temp = aliens[i][j];
				if(temp.getVisible())
					(temp.getIcon()).paintIcon(this, g, temp.getX(), temp.getY());
			}
		}
	}
}