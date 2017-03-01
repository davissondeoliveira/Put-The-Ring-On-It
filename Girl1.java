import javax.swing.ImageIcon;


public class Girl1 extends Sprite {
	//set the girl1 icon
	public Girl1() {
		super();
		image = new ImageIcon ("Girl1.png");
	}
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
