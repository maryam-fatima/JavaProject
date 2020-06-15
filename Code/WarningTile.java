package final_TT;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

final class WarningTile extends Tile {
		
	private static BackgroundFill bf_5 = new BackgroundFill(Color.rgb(164, 244, 66),null,null); 
	private static Background bg_5 = new Background(bf_5);
		
	public WarningTile() {
			
		this("");	
	}//end no-argument constructor
		
	public WarningTile(String txt) {
		
		//defining the default style for WarningTile
		super(txt);
		setBackground(bg_5);
		setTextFill(Color.BLACK);
		setFont( Font.font("Helvetica", 30));
	}//end with argument constructor
	
}//end class WarningTile


