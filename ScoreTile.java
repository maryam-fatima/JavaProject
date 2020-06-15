package final_TT;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

class ScoreTile extends Tile {
		
	private static BackgroundFill bf_5 = new BackgroundFill(Color.rgb(164, 244, 66),null,null); 
	private static Background bg_5 = new Background(bf_5);
		
	public ScoreTile(){
			
		this("");
	}//end no-argument constructor
	
	public ScoreTile(String txt){
			
		//defining the default style for ProblemTile
		super(txt);
		setTextFill(Color.PURPLE);
		setFont(Font.font("Roboto", 42));
		setBackground(bg_5);
	}//end with argument constructor

}//end class ScoreTile




