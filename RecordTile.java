package final_TT;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RecordTile extends Tile {

	
	private static BackgroundFill bf_8 = new BackgroundFill(Color.rgb(79, 153, 134), null, null); 
	private static Background bg_8 = new Background(bf_8); 
	
	public RecordTile() {
		
		this("");
	}//end no-argument constructor
	
	public RecordTile(String s) {
		
		super(s);
		//defining the default style for RecordTile
		setTextFill(Color.WHITE);
		setFont(Font.font("Helvetica", 26));
		setBackground(bg_8);
		
	}//end with argument constructor
}//end class RecordTile
