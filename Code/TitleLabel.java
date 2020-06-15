package final_TT;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TitleLabel extends Label {
	
	private static Font font3 = Font.font("Comic Sans MS", 110);
	private static Color c3 = Color.rgb(0,0,77);
	
	public TitleLabel() {
		
	}//end no-argument constructor
	
	public TitleLabel(String s) {

		super(s);
		setAlignment(Pos.CENTER);
		setFont(font3);
		setTextFill(c3);
	}//end with argument constructor
}//end class Tile

