import javax.swing.ImageIcon;


public class Girl2 extends Sprite {
	//set the Girl2 icon
	public Girl2() {
		super();
		image = new ImageIcon ("Girl2.png");
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
