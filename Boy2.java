import javax.swing.ImageIcon;


public class Boy2 extends Sprite {
	private boolean hasRings;
	
	//set the Boy2 icon
	public Boy2() {
		super();
		image = new ImageIcon ("Boy2.png");
	}
	
	public void pickUpRings() {
		hasRings = true; 
	}

	public boolean isRinged(){
		if(hasRings == true){
			return true;
		}else{
			return false;
		}
	}
	public void reset(){
		hasRings = false;
		
	}
	//move it randomly
	public void move(){
		int d = (int) (Math.random()*4);
		
		if(d==0){
			if(!currentRoom.hasNorthExit()){
				move();
			}else{
				moveNorth();
			}
		}
		
		if(d==1){
			if(!currentRoom.hasSouthExit()){
				move();
			}else{
				moveSouth();
			}
		}
		
		if(d==2){
			if(!currentRoom.hasEastExit()){
				move();
			}else{
				moveEast();
			}
		}
		
		if(d==3){
			if(!currentRoom.hasWestExit()){
				move();
			}else{
				moveWest();
			}
		}

	}

}