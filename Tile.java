package final_TT;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.stage.Screen;

abstract class Tile extends Label {

	private static Rectangle2D screenSize = Screen.getPrimary().getVisualBounds(); 
	
	protected Tile(){
		this("");
		
	}//end no-argument constructor
	protected Tile(String txt){
		
		super(txt);
		setAlignment(Pos.CENTER);
		setMaxSize(screenSize.getWidth(),screenSize.getHeight()/14);
		setMinSize(screenSize.getWidth(),screenSize.getHeight()/14);
			
	}//end with argument constructor
}//end class Tile





