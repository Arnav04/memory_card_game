package jrJava.memoryCardGame_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Card {

	public static final int SIZE = 100;
	public static final int PADDING = 5;
	public static final int INSET = 10;
	
	private static Image[] images;
	private static String[] imageNames = {
			"apple.png", 
			"bank.png", 
			"basketball.png", 
			"bubble_blue.png",
			"bubble_green.png",
			"bubble_red.png",
			"building.png",
			"cat.png",
			"cheese.png",
			"denture.png",
			"dog.png",
			"hockey_stick.png",
			"keys.png",
			"phone.png",
			"pizza.png",
			"santa.png",
			"soccer_ball.png",
			"sock.png",
			"toilet_bowl.png",
			"toilet_paper.png",
			"xmas_tree.png"
	};
	
	
	
	private static Image backSideImage;
	
	private Image image;
	private int x, y; // top left corner.
	private boolean shouldReveal;
	private boolean matched;
	
	
	static {
		backSideImage = new ImageIcon("jrJava/memoryCardGame_1/backside.png").getImage();
		
		images = new Image[imageNames.length];
		for(int i=0; i<imageNames.length; i++){
			images[i] = new ImageIcon("jrJava/memoryCardGame_1/" + imageNames[i]).getImage();
		}
	}
	
	
	public Card(int imageIndex, int x, int y){
		image = images[imageIndex];
		this.x = x;
		this.y = y;
	}
	
	
	public void hide(){ shouldReveal = false; }
	public void show(){ shouldReveal = true; }
	public void setMatched(){ matched = true; }
	public boolean hasBeenMatched(){ return matched; }
	
	
	public boolean isMatch(Card card){
		return image==card.image;
	}
	
	
	public void swapImage(Card card){
		Image temp;
		temp = image;
		image = card.image;
		card.image = temp;
	}
	
	
	public boolean isSelected(int mx, int my){		
		return mx>x && mx<x+SIZE && my>y && my<y+SIZE;
	}
	
	
	public void draw(Graphics g){
		
		if(matched) return;// not showing at all
		
		if(shouldReveal) g.drawImage(image, x+INSET, y+INSET, SIZE-2*INSET, SIZE-2*INSET, null);
		else g.drawImage(backSideImage, x+INSET, y+INSET, SIZE-2*INSET, SIZE-2*INSET, null);
		
		g.setColor(Color.lightGray);
		g.drawRect(x,  y,  SIZE,  SIZE);
		g.setColor(Color.black);
		g.drawRect(x+PADDING, y+PADDING, SIZE-2*PADDING, SIZE-2*PADDING);
		
	}
	
}
 








