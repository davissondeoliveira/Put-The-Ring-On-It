import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


@SuppressWarnings("serial")
public class maze extends Applet implements KeyListener, ActionListener{


	ArrayList <path> pathArray = new ArrayList <path> ();
	
	//Array in order to save the rooms
	public static int size = 101;
	public static room [] roomList = new room [size];
	ArrayList <Drawable> drawableList = new ArrayList <Drawable> ();
	Boy1 boy1Personage;
	Boy2 boy2Personage;
	Girl1 girl1Personage;
	Girl2 girl2Personage;
	Rings1 rings1Power;
	Rings2 rings2Power;
	Random rn = new Random();
	Timer timer;
	int smallest=0;
	

	
	@Override
	public void init(){
		
		//Converting the Applet to a full-fledged windowed application
		JFrame frame = new JFrame("Find your Love - MAZE");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this, BorderLayout.CENTER);
		frame.pack();
		frame.setSize(680, 550);
		frame.setVisible(true);
		
		//it makes some of the personages to move every second
		timer = new Timer (1000, this);
		timer.start();
		//to play the song
		addKeyListener(this);
		play (getDocumentBase(),"Meghan_Trainor_-_Dear_Future_Husband_[trendingmp3.aiff");
		
		//rooms
		roomList[0] = new room(10,10);
		roomList[1] = new room(60,10);
		roomList[2] = new room(110,10);
		roomList[3] = new room(160,10);
		roomList[4] = new room(210,10);
		roomList[5] = new room(310,10);
		roomList[6] = new room(360,10);
		roomList[7] = new room(460,10);
		roomList[8] = new room(510,10);
		roomList[9] = new room(610,10);
		
		roomList[10] = new room(10,60);
		roomList[11] = new room(160,60);
		roomList[12] = new room(210,60);
		roomList[13] = new room(310,60);
		roomList[14] = new room(360,60);
		roomList[15] = new room(460,60);
		roomList[16] = new room(510,60);
		roomList[17] = new room(610,60);
		
		roomList[18] = new room(10,110);
		roomList[19] = new room(110,110);
		roomList[20] = new room(160,110);
		roomList[21] = new room(210,110);
		roomList[22] = new room(260,110);
		roomList[23] = new room(310,110);
		roomList[24] = new room(360,110);
		roomList[25] = new room(460,110);
		roomList[26] = new room(510,110);
		roomList[27] = new room(610,110);
		
		roomList[28] = new room(10,160);
		roomList[29] = new room(60,160);
		roomList[30] = new room(110,160);
		roomList[31] = new room(260,160);
		roomList[32] = new room(360,160);
		roomList[33] = new room(460,160);
		roomList[34] = new room(510,160);
		roomList[35] = new room(560,160);
		roomList[36] = new room(610,160);
		
		roomList[37] = new room(10,210);
		roomList[38] = new room(110,210);
		roomList[39] = new room(160,210);
		roomList[40] = new room(260,210);
		roomList[41] = new room(360,210);
		roomList[42] = new room(460,210);
		roomList[43] = new room(510,210);
		roomList[44] = new room(610,210);
		
		roomList[45] = new room(10,260);
		roomList[46] = new room(160,260);
		roomList[47] = new room(260,260);
		roomList[48] = new room(360,260);
		roomList[49] = new room(460,260);
		roomList[50] = new room(510,260);
		roomList[51] = new room(610,260);
		
		roomList[52] = new room(10,310);
		roomList[53] = new room(60,310);
		roomList[54] = new room(110,310);
		roomList[55] = new room(160,310);
		roomList[56] = new room(260,310);
		roomList[57] = new room(360,310);
		roomList[58] = new room(410,310);
		roomList[59] = new room(460,310);
		roomList[60] = new room(510,310);
		roomList[61] = new room(610,310);
		
		roomList[62] = new room(10,360);
		roomList[63] = new room(60,360);
		roomList[64] = new room(110,360);
		roomList[65] = new room(160,360);
		roomList[66] = new room(210,360);
		roomList[67] = new room(260,360);
		roomList[68] = new room(310,360);
		roomList[69] = new room(360,360);
		roomList[70] = new room(410,360);
		roomList[71] = new room(460,360);
		roomList[72] = new room(510,360);
		roomList[73] = new room(560,360);
		roomList[74] = new room(610,360);
		
		roomList[75] = new room(10,410);
		roomList[76] = new room(60,410);
		roomList[77] = new room(110,410);
		roomList[78] = new room(160,410);
		roomList[79] = new room(210,410);
		roomList[80] = new room(260,410);
		roomList[81] = new room(310,410);
		roomList[82] = new room(360,410);
		roomList[83] = new room(410,410);
		roomList[84] = new room(460,410);
		roomList[85] = new room(510,410);
		roomList[86] = new room(560,410);
		roomList[87] = new room(610,410);
		
		roomList[88] = new room(10,460);
		roomList[89] = new room(60,460);
		roomList[90] = new room(110,460);
		roomList[91] = new room(160,460);
		roomList[92] = new room(210,460);
		roomList[93] = new room(260,460);
		roomList[94] = new room(310,460);
		roomList[95] = new room(360,460);
		roomList[96] = new room(410,460);
		roomList[97] = new room(460,460);
		roomList[98] = new room(510,460);
		roomList[99] = new room(560,460);
		roomList[100] = new room(610,460);
		
		//linking the rooms
		//linking S->N
		roomList[0].setSouthExit(roomList[10]); 
		roomList[10].setSouthExit(roomList[18]); 
		roomList[18].setSouthExit(roomList[28]); 
		roomList[28].setSouthExit(roomList[37]); 
		roomList[37].setSouthExit(roomList[45]); 
		roomList[45].setSouthExit(roomList[52]); 
		roomList[3].setSouthExit(roomList[11]); 
		roomList[11].setSouthExit(roomList[20]); 
		roomList[39].setSouthExit(roomList[46]); 
		roomList[46].setSouthExit(roomList[55]); 
		roomList[4].setSouthExit(roomList[12]); 
		roomList[12].setSouthExit(roomList[21]); 
		roomList[22].setSouthExit(roomList[31]); 
		roomList[31].setSouthExit(roomList[40]);
		roomList[40].setSouthExit(roomList[47]);
		roomList[47].setSouthExit(roomList[56]);
		roomList[5].setSouthExit(roomList[13]);
		roomList[13].setSouthExit(roomList[23]);
		roomList[6].setSouthExit(roomList[14]);
		roomList[14].setSouthExit(roomList[24]);
		roomList[24].setSouthExit(roomList[32]);
		roomList[32].setSouthExit(roomList[41]);
		roomList[41].setSouthExit(roomList[48]);
		roomList[48].setSouthExit(roomList[57]);
		roomList[19].setSouthExit(roomList[30]);
		roomList[30].setSouthExit(roomList[38]);
		roomList[52].setSouthExit(roomList[74]);
		roomList[57].setSouthExit(roomList[69]);
		roomList[59].setSouthExit(roomList[71]);
		roomList[61].setSouthExit(roomList[62]);


		//linking S<-N
		roomList[59].setNorthExit(roomList[49]);
		roomList[49].setNorthExit(roomList[42]); 
		roomList[42].setNorthExit(roomList[33]); 
		roomList[33].setNorthExit(roomList[25]); 
		roomList[25].setNorthExit(roomList[15]); 
		roomList[15].setNorthExit(roomList[7]); 
		roomList[60].setNorthExit(roomList[50]); 
		roomList[50].setNorthExit(roomList[43]); 
		roomList[43].setNorthExit(roomList[34]); 
		roomList[34].setNorthExit(roomList[26]); 
		roomList[26].setNorthExit(roomList[16]);
		roomList[16].setNorthExit(roomList[8]);
		roomList[61].setNorthExit(roomList[51]); 
		roomList[51].setNorthExit(roomList[44]); 
		roomList[44].setNorthExit(roomList[36]); 
		roomList[36].setNorthExit(roomList[27]); 
		roomList[27].setNorthExit(roomList[17]);
		roomList[17].setNorthExit(roomList[9]);
		
		//Liking W->E
		roomList[0].setEastExit(roomList[1]); 
		roomList[1].setEastExit(roomList[2]); 
		roomList[2].setEastExit(roomList[3]); 
		roomList[20].setEastExit(roomList[21]);
		roomList[5].setEastExit(roomList[6]); 
		roomList[7].setEastExit(roomList[8]); 
		roomList[19].setEastExit(roomList[20]);
	
		//Liking W<-E
		roomList[21].setEastExit(roomList[22]);
		roomList[22].setEastExit(roomList[23]); 
		
		//roomList[28].setEastExit(roomList[29]); 
		roomList[29].setEastExit(roomList[30]); 
		roomList[34].setEastExit(roomList[35]);
		roomList[35].setEastExit(roomList[36]); 
		roomList[38].setEastExit(roomList[39]); 
		roomList[52].setEastExit(roomList[53]); 
		roomList[53].setEastExit(roomList[54]);
		roomList[54].setEastExit(roomList[55]); 
		roomList[57].setEastExit(roomList[58]); 
		roomList[58].setEastExit(roomList[59]); 
		roomList[59].setEastExit(roomList[60]);

		//calling a method to randomize some rooms in the maze
		RandomizingMaze();
		
		roomList[70].setEastExit(roomList[71]); 
		roomList[71].setEastExit(roomList[72]);
		roomList[72].setEastExit(roomList[73]); 
		roomList[77].setEastExit(roomList[78]); 
		roomList[79].setEastExit(roomList[80]);
		roomList[82].setEastExit(roomList[83]); 
		roomList[84].setEastExit(roomList[85]); 
		roomList[89].setEastExit(roomList[90]); 
		roomList[90].setEastExit(roomList[91]); 
		roomList[91].setEastExit(roomList[92]); 
		roomList[93].setEastExit(roomList[94]); 
		roomList[95].setEastExit(roomList[96]); 
		roomList[96].setEastExit(roomList[97]); 
		roomList[97].setEastExit(roomList[98]); 
		roomList[98].setEastExit(roomList[99]);
		roomList[99].setEastExit(roomList[100]); 
		
		//initiating the icons
		boy1Personage = new Boy1 ();
		boy2Personage = new Boy2 ();
		girl1Personage = new Girl1 ();
		girl2Personage = new Girl2 ();
		rings1Power = new Rings1 ();
		rings2Power = new Rings2 ();

		//getting it to the drawableList
		for(int i=0; i<roomList.length; i++ ){
			drawableList.add(roomList[i]);
		}
		drawableList.add(boy1Personage);
		drawableList.add(boy2Personage);
		drawableList.add(girl1Personage);
		drawableList.add(girl2Personage);
		drawableList.add(rings1Power);
		drawableList.add(rings2Power);
		
		//randomizing the the position
		Random randomNumber = new Random();
		
		int randomB1 = randomNumber.nextInt(101);
		int randomB2 = randomNumber.nextInt(101);
		while(randomB1 == randomB2){
			randomB2 = randomNumber.nextInt(101);
		}
		int randomG1 = randomNumber.nextInt(101);
		while(randomG1 == randomB2 ||randomG1 == randomB1){
			randomG1 = randomNumber.nextInt(101);
		}
		int randomG2 = randomNumber.nextInt(101);
		while(randomG2 == randomB2 ||randomG2 == randomB1 ||randomG2 == randomG1){
			randomG2 = randomNumber.nextInt(101);
		}
		int randomR1 = randomNumber.nextInt(101);
		while(randomR1 == randomB2 ||randomR1 == randomB1 ||randomR1 == randomG1 ||randomR1 == randomG2){
			randomR1 = randomNumber.nextInt(101);
		}
		int randomR2 = randomNumber.nextInt(101);
		while(randomR2 == randomB2 ||randomR2 == randomB1 ||randomR2 == randomG1
				||randomR2 == randomG2 ||randomR2 == randomG2){
			randomR2 = randomNumber.nextInt(101);
		}
		boy1Personage.setCurrentRoom(roomList[randomB1]);
		boy2Personage.setCurrentRoom(roomList[randomB2]);
		girl1Personage.setCurrentRoom(roomList[randomG1]);
		girl2Personage.setCurrentRoom(roomList[randomG2]);
		rings1Power.setCurrentRoom(roomList[randomR1]);
		rings2Power.setCurrentRoom(roomList[randomR2]);
		boy1Personage.reset();
		boy2Personage.reset();
	}
	
	public void RandomizingMaze(){
		//Randomizing the rooms
		
		if(smallest == 0){
			roomList[63].setSouthExit(roomList[76]);
			roomList[63].setWestExit(roomList[62]);
			roomList[63].setEastExit(roomList[64]);
			roomList[75].setSouthExit(roomList[88]);
			roomList[76].setSouthExit(roomList[89]);
			roomList[77].setSouthExit(roomList[90]);
			roomList[65].setSouthExit(roomList[78]);
			roomList[66].setEastExit(roomList[67]);
			roomList[79].setSouthExit(roomList[92]);
			roomList[55].setSouthExit(roomList[65]);
			roomList[56].setSouthExit(roomList[67]);
			roomList[67].setSouthExit(roomList[80]);
			roomList[68].setSouthExit(roomList[81]);
			roomList[81].setSouthExit(roomList[94]);
			roomList[69].setSouthExit(roomList[82]);
			roomList[70].setSouthExit(roomList[83]);
			roomList[85].setSouthExit(roomList[98]);
			roomList[73].setSouthExit(roomList[86]);
			roomList[74].setSouthExit(roomList[87]);
			roomList[87].setSouthExit(roomList[100]);
			roomList[86].setEastExit(roomList[87]);
			roomList[88].setEastExit(roomList[89]);
			roomList[65].setEastExit(roomList[66]); 
			roomList[81].setEastExit(roomList[82]); 
			
	
		}
		if(smallest == 1){
			//unset them and then set it again
			roomList[63].unsetSouthExit(roomList[76]);
			roomList[63].unsetWestExit(roomList[62]);
			roomList[63].unsetEastExit(roomList[64]);
			roomList[75].unsetSouthExit(roomList[88]);
			roomList[76].unsetSouthExit(roomList[89]);
			roomList[77].unsetSouthExit(roomList[90]);
			roomList[65].unsetSouthExit(roomList[78]);
			roomList[66].unsetEastExit(roomList[67]);
			roomList[79].unsetSouthExit(roomList[92]);
			roomList[55].unsetSouthExit(roomList[65]);
			roomList[56].unsetSouthExit(roomList[67]);
			roomList[67].unsetSouthExit(roomList[80]);
			roomList[68].unsetSouthExit(roomList[81]);
			roomList[81].unsetSouthExit(roomList[94]);
			roomList[69].unsetSouthExit(roomList[82]);
			roomList[70].unsetSouthExit(roomList[83]);
			roomList[85].unsetSouthExit(roomList[98]);
			roomList[73].unsetSouthExit(roomList[86]);
			roomList[74].unsetSouthExit(roomList[87]);
			roomList[87].unsetSouthExit(roomList[100]);
			roomList[86].unsetEastExit(roomList[87]);
			roomList[88].unsetEastExit(roomList[89]);
			roomList[65].unsetEastExit(roomList[66]); 
			roomList[81].unsetEastExit(roomList[82]); 
			
			roomList[62].setSouthExit(roomList[75]);
			roomList[63].setEastExit(roomList[64]);
			roomList[75].setSouthExit(roomList[88]);
			roomList[76].setSouthExit(roomList[89]);
			roomList[64].setSouthExit(roomList[77]);
			roomList[65].setSouthExit(roomList[78]);
			roomList[66].setSouthExit(roomList[79]);
			roomList[79].setSouthExit(roomList[92]);
			roomList[55].setSouthExit(roomList[65]);
			roomList[56].setSouthExit(roomList[67]);
			roomList[67].setSouthExit(roomList[80]);
			roomList[80].setSouthExit(roomList[93]);	
			roomList[68].setSouthExit(roomList[81]);
			roomList[81].setSouthExit(roomList[94]);
			roomList[69].setSouthExit(roomList[82]);
			roomList[70].setSouthExit(roomList[83]);
			roomList[85].setSouthExit(roomList[98]);
			roomList[73].setSouthExit(roomList[86]);
			roomList[74].setSouthExit(roomList[87]);
			roomList[87].setSouthExit(roomList[100]);
			roomList[88].setEastExit(roomList[89]);
			roomList[65].setEastExit(roomList[66]);
			roomList[81].setEastExit(roomList[82]);  

		}
		if(smallest == 2){
			//unset them and then set it again
			roomList[63].unsetSouthExit(roomList[76]);
			roomList[63].unsetWestExit(roomList[62]);
			roomList[63].unsetEastExit(roomList[64]);
			roomList[75].unsetSouthExit(roomList[88]);
			roomList[76].unsetSouthExit(roomList[89]);
			roomList[77].unsetSouthExit(roomList[90]);
			roomList[65].unsetSouthExit(roomList[78]);
			roomList[66].unsetEastExit(roomList[67]);
			roomList[79].unsetSouthExit(roomList[92]);
			roomList[55].unsetSouthExit(roomList[65]);
			roomList[56].unsetSouthExit(roomList[67]);
			roomList[67].unsetSouthExit(roomList[80]);
			roomList[68].unsetSouthExit(roomList[81]);
			roomList[81].unsetSouthExit(roomList[94]);
			roomList[69].unsetSouthExit(roomList[82]);
			roomList[70].unsetSouthExit(roomList[83]);
			roomList[85].unsetSouthExit(roomList[98]);
			roomList[73].unsetSouthExit(roomList[86]);
			roomList[74].unsetSouthExit(roomList[87]);
			roomList[87].unsetSouthExit(roomList[100]);
			roomList[86].unsetEastExit(roomList[87]);
			roomList[88].unsetEastExit(roomList[89]);
			roomList[65].unsetEastExit(roomList[66]); 
			roomList[81].unsetEastExit(roomList[82]); 
			
			roomList[62].unsetSouthExit(roomList[75]);
			roomList[63].unsetEastExit(roomList[64]);
			roomList[75].unsetSouthExit(roomList[88]);
			roomList[76].unsetSouthExit(roomList[89]);
			roomList[64].unsetSouthExit(roomList[77]);
			roomList[65].unsetSouthExit(roomList[78]);
			roomList[66].unsetSouthExit(roomList[79]);
			roomList[79].unsetSouthExit(roomList[92]);
			roomList[55].unsetSouthExit(roomList[65]);
			roomList[56].unsetSouthExit(roomList[67]);
			roomList[67].unsetSouthExit(roomList[80]);
			roomList[80].unsetSouthExit(roomList[93]);	
			roomList[68].unsetSouthExit(roomList[81]);
			roomList[81].unsetSouthExit(roomList[94]);
			roomList[69].unsetSouthExit(roomList[82]);
			roomList[70].unsetSouthExit(roomList[83]);
			roomList[85].unsetSouthExit(roomList[98]);
			roomList[73].unsetSouthExit(roomList[86]);
			roomList[74].unsetSouthExit(roomList[87]);
			roomList[87].unsetSouthExit(roomList[100]);
			roomList[88].unsetEastExit(roomList[89]);
			roomList[65].unsetEastExit(roomList[66]);
			roomList[81].unsetEastExit(roomList[82]);  

			roomList[62].setSouthExit(roomList[75]);
			roomList[63].setWestExit(roomList[62]);
			roomList[84].setWestExit(roomList[83]);
			roomList[63].setEastExit(roomList[64]);
			roomList[75].setSouthExit(roomList[88]);
			roomList[76].setSouthExit(roomList[89]);
			roomList[64].setSouthExit(roomList[77]);
			roomList[65].setSouthExit(roomList[78]);
			roomList[66].setSouthExit(roomList[79]);
			roomList[79].setSouthExit(roomList[92]);
			roomList[55].setSouthExit(roomList[65]);
			roomList[56].setSouthExit(roomList[67]);
			roomList[67].setSouthExit(roomList[80]);
			roomList[80].setSouthExit(roomList[93]);	
			roomList[68].setSouthExit(roomList[81]);
			roomList[81].setSouthExit(roomList[94]);
			roomList[69].setSouthExit(roomList[82]);
			roomList[70].setSouthExit(roomList[83]);
			roomList[85].setSouthExit(roomList[98]);
			roomList[73].setSouthExit(roomList[86]);
			roomList[74].setSouthExit(roomList[87]);
			roomList[87].setSouthExit(roomList[100]);
			
		}

		//System.out.println(roomList[62].hasSouthExit());
		
		repaint();
	}
	//I wrote all of them because it is part of the package, without one piece of the whole package it wont work
	@Override
	public void keyTyped(KeyEvent e){

	}

	@Override
	public void keyReleased(KeyEvent e){
	
	}
	
	
	//setting the keyboard to move the icons around the maze
	@Override
	public void keyPressed(KeyEvent e){
		
		
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_NUMPAD8 ){
			boy1Personage.moveNorth();
		}
		if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_NUMPAD2){
			boy1Personage.moveSouth();
		}
		if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_NUMPAD6){
			boy1Personage.moveEast();
		}
		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_NUMPAD4){
			boy1Personage.moveWest();
		}
		if(key == KeyEvent.VK_L ){
			reset();
		}
		
		if(key == KeyEvent.VK_W ){
			boy2Personage.moveNorth();
		}
		if(key == KeyEvent.VK_S ){
			boy2Personage.moveSouth();
		}
		if(key == KeyEvent.VK_D ){
			boy2Personage.moveEast();
		}
		if(key == KeyEvent.VK_A ){
			boy2Personage.moveWest();
		}
		if(boy1Personage.equals(rings1Power)){
			boy1Personage.pickUpRings();
			rings1Power.setCurrentRoom(null);
		}
		//check if the player wins the game or not
		if(boy2Personage.equals(rings2Power)){
			boy2Personage.pickUpRings();
			rings2Power.setCurrentRoom(null);
		}
		if(boy1Personage.equals(girl1Personage)){
			if(boy1Personage.isRinged() == true){
				int play = JOptionPane.showConfirmDialog(null, "You are going to live "
						+ "Happily Everafter. Do want to play again?","You marriage is set up! "
								+ "Congrats BOY&GIRL1!", JOptionPane.YES_NO_OPTION);
				if(play == JOptionPane.NO_OPTION){
					System.exit(0);
				}
				if(play == JOptionPane.YES_OPTION){
					reset();
				}
			} 
		}
		
		if(boy2Personage.equals(girl2Personage)){
			if(boy2Personage.isRinged() == true){
				int play = JOptionPane.showConfirmDialog(null, "You are going to live"
						+ " Happily Everafter. Do want to play again?","You marriage is set up! "
								+ "Congrats BOY&GIRL2!", JOptionPane.YES_NO_OPTION);
				if(play == JOptionPane.NO_OPTION){
					System.exit(0);
				}
				if(play == JOptionPane.YES_OPTION){
					reset();
				}
			}
		}
		if(boy1Personage.equals(girl2Personage)){
			int play = JOptionPane.showConfirmDialog(null, "Sorry, your girlfriend saw you with another gil. Do want to play again?","You marriage is set up! "
							+ "SORRY!", JOptionPane.YES_NO_OPTION);
			if(play == JOptionPane.NO_OPTION){
				System.exit(0);
			}
			if(play == JOptionPane.YES_OPTION){
				reset();
			}
		}
		if(boy1Personage.equals(boy2Personage)){
			int play = JOptionPane.showConfirmDialog(null, "Sorry, your girlfriend's ex. beat you up. Do want to play again?","You marriage is set up! "
							+ "SORRY!", JOptionPane.YES_NO_OPTION);
			if(play == JOptionPane.NO_OPTION){
				System.exit(0);
			}
			if(play == JOptionPane.YES_OPTION){
				reset();
			}
		}
		
		repaint();
	}
	
//	public void getShortestPath(){
//		pathArray.add( new path(roomList[5]));
//		
//		
//	}
	
	private void reset() {
		
		//randomizing the the position
		Random randomNumber = new Random();
		
		int randomB1 = randomNumber.nextInt(101);
		int randomB2 = randomNumber.nextInt(101);
		while(randomB1 == randomB2){
			randomB2 = randomNumber.nextInt(101);
		}
		int randomG1 = randomNumber.nextInt(101);
		while(randomG1 == randomB2 ||randomG1 == randomB1){
			randomG1 = randomNumber.nextInt(101);
		}
		int randomG2 = randomNumber.nextInt(101);
		while(randomG2 == randomB2 ||randomG2 == randomB1 ||randomG2 == randomG1){
			randomG2 = randomNumber.nextInt(101);
		}
		int randomR1 = randomNumber.nextInt(101);
		while(randomR1 == randomB2 ||randomR1 == randomB1 ||randomR1 == randomG1 ||randomR1 == randomG2){
			randomR1 = randomNumber.nextInt(101);
		}
		int randomR2 = randomNumber.nextInt(101);
		while(randomR2 == randomB2 ||randomR2 == randomB1 ||randomR2 == randomG1
				||randomR2 == randomG2 ||randomR2 == randomG2){
			randomR2 = randomNumber.nextInt(101);
		}

		boy1Personage.setCurrentRoom(roomList[randomB1]);
		boy2Personage.setCurrentRoom(roomList[randomB2]);
		girl1Personage.setCurrentRoom(roomList[randomG1]);
		girl2Personage.setCurrentRoom(roomList[randomG2]);
		rings1Power.setCurrentRoom(roomList[randomR1]);
		rings2Power.setCurrentRoom(roomList[randomR2]);
		boy1Personage.reset();
		boy2Personage.reset();
		//setting the maze's room randomly
		smallest=(int)(Math.random()*4);
		RandomizingMaze();
	}
	
	@Override
	//call the draw method and finally draw the maze using for loop
	public void paint (Graphics g){
		
		int w = getWidth();
		int h = getHeight();
		
		//background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, w, h);

		
		//drawing the maze using for loop
		for (int i=0; i<drawableList.size(); i++){
			if ( i >= 62 ) {
				g.setColor(new Color(51,0,0));
			}else{
				g.setColor(new Color(204,0,0));
			}
			//drawing it to the drawableList
			drawableList.get(i).draw(g);
		}
		//drawing the icons
		
		requestFocusInWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// what is about to move randomly every second
		girl2Personage.move();
		//girl1Personage.move();
		boy2Personage.move();
		//check if the player wins the game or not
		if(girl1Personage.equals(boy2Personage)){
			int play = JOptionPane.showConfirmDialog(null, "Sorry, you lost the girl to another guy. Do want to play again?","You marriage is set up! "
							+ "SORRY!", JOptionPane.YES_NO_OPTION);
			if(play == JOptionPane.NO_OPTION){
				System.exit(0);
			}
			if(play == JOptionPane.YES_OPTION){
				reset();
			}
		}
		if(girl2Personage.equals(boy1Personage)){
			int play = JOptionPane.showConfirmDialog(null, "Sorry, your girlfriend saw you with another girl. Do want to play again?","You marriage is set up! "
							+ "SORRY!", JOptionPane.YES_NO_OPTION);
			if(play == JOptionPane.NO_OPTION){
				System.exit(0);
			}
			if(play == JOptionPane.YES_OPTION){
				reset();
			}
		}
		if(girl2Personage.equals(girl1Personage)){
			int play = JOptionPane.showConfirmDialog(null, "Sorry, your girlfriend got beat up by the jelous girl. Do want to play again?","You marriage is set up! "
							+ "SORRY!", JOptionPane.YES_NO_OPTION);
			if(play == JOptionPane.NO_OPTION){
				System.exit(0);
			}
			if(play == JOptionPane.YES_OPTION){
				reset();
			}
		}
		if(boy2Personage.equals(boy1Personage)){
			int play = JOptionPane.showConfirmDialog(null, "Sorry, your girlfriend's ex. beat you up. Do want to play again?","You marriage is set up! "
							+ "SORRY!", JOptionPane.YES_NO_OPTION);
			if(play == JOptionPane.NO_OPTION){
				System.exit(0);
			}
			if(play == JOptionPane.YES_OPTION){
				reset();
			}
		}
		
		
		repaint();
	}

}
