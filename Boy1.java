import javax.swing.*;


public class Boy1 extends Sprite {
	private boolean hasRings;
	
	
	//set the Boy1 icon
	public Boy1() {
		super();
		image = new ImageIcon ("Boy1.png");
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
}
