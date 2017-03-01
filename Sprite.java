import java.awt.*;

import javax.swing.ImageIcon;

public abstract class Sprite implements Drawable{
	//fields 
	protected room currentRoom;
	protected ImageIcon image;

	
	//default the fields
	public Sprite(){
		currentRoom = null;
		image = null;
	}
	//set the icon on the room
	public void setCurrentRoom(room r){
		currentRoom = r;
	}
	//get the position the icon will be
	public room getCurrentRoom(){
		return currentRoom;
		
	}
	//set the room, moving it to the other side of the exist
	public void moveSouth(){
		if(currentRoom.hasSouthExit() == true){
			currentRoom =currentRoom.getSouthExit();
		}
	}

	public void moveNorth(){
		if(currentRoom.hasNorthExit() == true){
			currentRoom =currentRoom.getNorthExit();
		}
	}

	public void moveEast(){
		if(currentRoom.hasEastExit() == true){
			currentRoom =currentRoom.getEastExit();
		}
	}

	public void moveWest(){
		if(currentRoom.hasWestExit() == true){
			currentRoom =currentRoom.getWestExit();
		}
	}
	
	//equals method
	 @Override
	public boolean equals(Object obj) {
		if ( obj instanceof Sprite) {
			Sprite temp = (Sprite)obj;
			return (temp.getCurrentRoom() == this.getCurrentRoom());
		}
		return false;
	}
	
	public void draw(Graphics g){
		
		if(currentRoom != null && image != null){
			// get the position
			Point position = currentRoom.getPosition();
			//centralize the icon on the box
			int positionX = (int) ((50 - image.getIconWidth())/2);
			int positionY = (int) ((50 - image.getIconHeight())/2);
			//draw it on the box
			image.paintIcon(null, g, position.x+positionX, position.y+positionY);
		}	
	}
	
}
