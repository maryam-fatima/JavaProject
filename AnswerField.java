package final_TT;

	import javafx.geometry.Pos;
	import javafx.geometry.Rectangle2D;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.Background;
	import javafx.scene.layout.BackgroundFill;
	import javafx.scene.paint.Color;
	import javafx.scene.text.Font;
	import javafx.stage.Screen;

	class AnswerField extends TextField {
		
	private	static Rectangle2D screenSize = Screen.getPrimary().getVisualBounds(); 
		
	private	static BackgroundFill bf_4 = new BackgroundFill(Color.rgb(0,0,77),null,null); 
	private	static Background bg_4 = new Background(bf_4);
		

		public AnswerField(String string) {
			// TODO Auto-generated constructor stub
			
			setText(string);
			setBackground(bg_4);
			setStyle("-fx-text-fill: white;");
			setAlignment(Pos.CENTER);
			setFont(Font.font("Helvetica", 32));
					
			setMaxSize(screenSize.getWidth(),screenSize.getHeight()/13.75);
			setMinSize(screenSize.getWidth(),screenSize.getHeight()/13.75);
		}
	}




