
import java.awt.*;

public class room  implements Drawable{
	//private variables
	public static final int size = 50;
	private Point pos;
	private room exitNorth, exitSouth, exitWest, exitEast;
	
	public Point getPosition(){
		return pos;
	}
	
	//default
	public room(int x, int y){
		pos = new Point(x,y);
		exitNorth = null;
		exitSouth = null;
		exitEast = null;
		exitWest = null;
		
	}
	
	//they link S-N/W-E and vice-versa
	public void setEastExit(room r){
		exitEast = r;
		r.exitWest = this;		
	}
	
	public void setNorthExit(room r){
		exitNorth = r;
		r.exitSouth = this;
	}
	
	public void setWestExit(room r){
		exitWest = r;
		r.exitEast = this;
	}
	
	public void setSouthExit(room r){
		exitSouth = r;
		r.exitNorth = this;
	}
	public void unsetEastExit(room r){
		exitEast = null;
		r.exitWest = null;		
	}
	
	public void unsetNorthExit(room r){
		exitNorth = null;
		r.exitSouth = null;
	}
	
	public void unsetWestExit(room r){
		exitWest = null;
		r.exitEast = null;
	}
	
	public void unsetSouthExit(room r){
		exitSouth = null;
		r.exitNorth = null;
	}
	//Checks if it has exists or not
	public boolean hasNorthExit(){
		if(exitNorth == null){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean hasSouthExit(){
		if(exitSouth == null){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean hasEastExit(){
		if(exitEast == null){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean hasWestExit(){
		if(exitWest == null){
			return false;
		}else{
			return true;
		}
	}
	//returning the exits
	public room getNorthExit(){
		return exitNorth;
	}
	
	public room getSouthExit(){
		return exitSouth;
		}
	
	public room getEastExit(){
		return exitEast;
	}
	
	public room getWestExit(){
		return exitWest;
	}

	//draw the boxes 
	public void draw(Graphics g){
		//g.setColor(Color.RED);
		g.fillRect(pos.x, pos.y, 50, 50);
		//Color
		g.setColor(Color.WHITE);
		
		//draw the connections between ports N/S/W/E
		if (exitNorth == null){
			g.drawLine(pos.x, pos.y, pos.x+50, pos.y);
		}
		
		if (exitSouth == null){
			g.drawLine(pos.x, pos.y+50, pos.x+50, pos.y+50);
		}
		
		if (exitWest == null){
			g.drawLine(pos.x, pos.y, pos.x, pos.y+50);
		}
		
		if (exitEast == null){
			g.drawLine(pos.x+50, pos.y, pos.x+50, pos.y+50);
		}
		
	}
}
