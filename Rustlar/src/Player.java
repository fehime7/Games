import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;


/**
 * This is the Player Class
 * It provides the functionality of keeping track of all the users
 * Objects of this class is updated and written in the Game's Data Files after every Game
 *
 */
public class Player implements Serializable{
	
	private static final long serialVersionUID = 1L;
	int playerOrder;
	boolean isHuman;
	
	
	//Constructor
	public Player(int playerOrder, boolean isHuman)
	{
		this.playerOrder=playerOrder;
		this.isHuman=isHuman;
		
	}
	
	//Name Getter
	public int getPlayerOrder()
	{
		return playerOrder;
	}

	public boolean isHuman() {
		return isHuman;
	}

	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}

	public void setPlayerOrder(int playerOrder) {
		this.playerOrder = playerOrder;
	}
	
	
	
}
