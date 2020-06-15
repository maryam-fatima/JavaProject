package final_TT;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class TableLabel extends Label{
	
	private static BackgroundFill bf_8 = new BackgroundFill(Color.rgb(79, 153, 134), null, null); 
	private static Background bg_8 = new Background(bf_8); 
	
	private static Rectangle2D screenSize = Screen.getPrimary().getVisualBounds(); 
	
	public TableLabel() {
		this("");
	}//end no-argument constructor
	
	public TableLabel(String s) {
		
		super(s);
		//defining the default style for TableTile
		setAlignment(Pos.CENTER);
		setTextFill(Color.WHITE);
		setFont(Font.font("Helvetica", 24));
		setBackground(bg_8);
		
		setMaxSize(screenSize.getWidth(),screenSize.getHeight()/12);
		setMinSize(screenSize.getWidth(),screenSize.getHeight()/12);
	}//end with argument constructor
}//end class TableTile
