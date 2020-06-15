package final_TT;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


class ProblemTile extends Tile {

	private static Font font0 = Font.font("Helvetica", 32);	
	private static BackgroundFill bf_3 = new BackgroundFill(Color.rgb(204, 255, 153),null,null); 
	private static Background bg_3 = new Background(bf_3);

	public ProblemTile(){
			
		this("");			
	}//end no-argument constructor
		
	public ProblemTile(String txt){
			
		//defining the default style for ProblemTile
		super(txt);
    	setTextFill(Color.WHITE);
    	setFont(font0);	    	
    	setBackground(bg_3);   	
	}//end with argument constructor
		
	public void setDefault() {
			
		setText("");
	   	setFont(font0);
	   	setBackground(bg_3);
	}//set to default style
		
}//end class problemTile


