package final_TT;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;	
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font; 
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import java.lang.reflect.*;

public class Gui extends Application{
		
    private Rectangle2D screenSize = Screen.getPrimary().getVisualBounds(); 
		
	private BackgroundFill bf = new BackgroundFill(Color.rgb(255,140,67),null,null); //dark pink
	private Background bg = new Background(bf); 
	
	private BackgroundFill bf_4 = new BackgroundFill(Color.rgb(0,0,77),null,null); 
	private Background bg_4 = new Background(bf_4);

	private Color c3 = Color.rgb(0,0,77);		
	private Font font0 = Font.font("Helvetica", 32);
	
	private String[] problems = {"","","","","", "","","","", "",""};
	private String[] answers = {"999","999","999","999","999", "999","999","999","999", "999","999"};
	private int i = -1;

	private String S = "";
	private String scoreString = "SCORE: ";
	private static int score = 0;
	private int interval = 2700;
		
	private boolean gameoverFlag = false;
	private boolean startFlag = false;
		
	private Level l;	
	private ProblemTile[] problem_tile;	
	private WarningTile warning_tile;
	private ScoreTile score_tile;
	private AnswerField answer_field;
	private RecordTile[] recordT;
	
	private Stage args ;
	private Scene Menu;
	private ArrayList<Integer> array = new ArrayList<Integer>(10);
	private Records record = new Records();
	
	private BarChart<String,Number> bc;
	private XYChart.Series<String, Number> series1;
	private XYChart.Data<String, Number> data;
	
	//main method
	public static void main(String[] args) {
			
		launch(args);		
	}
		    
	@Override
	public void start(Stage arg0) throws Exception {
			
		args = new Stage(StageStyle.UNDECORATED);
		
	        BackgroundFill bf_0 = new BackgroundFill(Color.rgb(60, 105, 132),null,null); 
	        Background bg0 = new Background(bf_0); 
	   
		BackgroundFill bf_1 = new BackgroundFill(Color.rgb(153, 255, 102),null,null); 
		Background bg1 = new Background(bf_1);
		
		BackgroundFill bf_2 = new BackgroundFill(Color.rgb(255, 153, 153),null,null);
		Background bg2 = new Background(bf_2); 
		
		BackgroundFill bf_3 = new BackgroundFill(Color.rgb(79, 153, 134), null, null); 
		Background bg3 = new Background(bf_3);
	
		Font font1 = Font.font("Comic Sans MS", 72);
		
		
		//PLAY PANE
		VBox play = new VBox(0.5);
		play.setBackground(new Background(new BackgroundFill(Color.rgb(164, 244, 66),null,null)));
			
		//creating the problem tiles
		problem_tile = new ProblemTile[11];		
		for(int j = 0 ; j < problem_tile.length ; j++){    	
			
				problem_tile[j] = new ProblemTile("");
		}
		play.getChildren().addAll(problem_tile);
			
			
		//creating the warning tile
		warning_tile = new WarningTile("Don't let the orange area reach here!");    
		//creating answer field
		answer_field = new AnswerField("");
		//creating score tile
		score_tile = new ScoreTile("SCORE: "); 	
			    
		//adding children to the VBox
		play.getChildren().addAll(warning_tile, answer_field, score_tile);
			
			
		//REVISION PANE
		VBox Rpane = new VBox(1);	
			
		//creating button for each table
		Button[] tableB = new Button[14];

		for(int j = 0 ; j < tableB.length ; j++) {
			
			tableB[j] = new Button("" + (j+2));
			tableB[j].setAlignment(Pos.CENTER);
			tableB[j].setTextFill(Color.rgb(13, 14, 15));
			tableB[j].setFont(Font.font("Helvetica", 16));
			tableB[j].setBackground(bg0);
				
			//setting the height and width of the buttons
			tableB[j].setMaxSize(screenSize.getWidth(),screenSize.getHeight()/15);
			tableB[j].setMinSize(screenSize.getWidth(),screenSize.getHeight()/15);
			
		}
						
		//back To menu Button		
		Button[] backToMenu = new Button[16];
			
		for(int j = 0 ; j < backToMenu.length ; j++) {
			backToMenu[j] = getBackToMenu();
		}
	
		
		//creating title label for Table: setting background and binding width
		TitleLabel TableTitle[] = new TitleLabel[14];
		for(int j = 0 ; j < TableTitle.length ; j++) {
			
			TableTitle[j] = new TitleLabel("Table of " + (j + 2));
			TableTitle[j].setBackground(bg3); TableTitle[j].setFont(font1);
			
			//binding width to the width of MenuBox
			TableTitle[j].prefWidthProperty().bind(Rpane.widthProperty());
		}//end for

		
		//adding nodes to their respective table pane
		VBox twoTable = new VBox(0.5);
		twoTable.getChildren().addAll(TableTitle[0],getTable(2),backToMenu[0]);	
			
		VBox threeTable = new VBox(0.5);
		threeTable.getChildren().addAll(TableTitle[1],getTable(3),backToMenu[1]);
		
		VBox fourTable = new VBox(0.5);
		fourTable.getChildren().addAll(TableTitle[2],getTable(4),backToMenu[2]);
			
		VBox fiveTable = new VBox(0.5);
		fiveTable.getChildren().addAll(TableTitle[3],getTable(5),backToMenu[3]);
			
		VBox sixTable = new VBox(0.5);
		sixTable.getChildren().addAll(TableTitle[4],getTable(6),backToMenu[4]);
			
		VBox sevenTable = new VBox(0.5);
		sevenTable.getChildren().addAll(TableTitle[5],getTable(7),backToMenu[5]);
			
		VBox eightTable = new VBox(0.5);
		eightTable.getChildren().addAll(TableTitle[6],getTable(8),backToMenu[6]);
			
		VBox nineTable = new VBox(0.5);
		nineTable.getChildren().addAll(TableTitle[7],getTable(9),backToMenu[7]);
			
		VBox tenTable = new VBox(0.5);
		tenTable.getChildren().addAll(TableTitle[8],getTable(10),backToMenu[8]);
			
		VBox elevenTable = new VBox(0.5);
		elevenTable.getChildren().addAll(TableTitle[9],getTable(11),backToMenu[9]);
			
		VBox twelveTable = new VBox(0.5);
		twelveTable.getChildren().addAll(TableTitle[10],getTable(12),backToMenu[10]);
		
		VBox thirteenTable = new VBox(0.5);
		thirteenTable.getChildren().addAll(TableTitle[11],getTable(13),backToMenu[11]);
		
		VBox fourteenTable = new VBox(0.5);
		fourteenTable.getChildren().addAll(TableTitle[12],getTable(14),backToMenu[12]);
		
		VBox fifteenTable = new VBox(0.5);
		fifteenTable.getChildren().addAll(TableTitle[13],getTable(15),backToMenu[13]);
		
		//creating table scenes
		Scene twoTableScene = new Scene(twoTable);
		Scene threeTableScene = new Scene(threeTable);
		Scene fourTableScene = new Scene(fourTable);
		Scene fiveTableScene = new Scene(fiveTable);
		Scene sixTableScene = new Scene(sixTable);
		Scene sevenTableScene = new Scene(sevenTable);
		Scene eightTableScene = new Scene(eightTable);
		Scene nineTableScene = new Scene(nineTable);
		Scene tenTableScene = new Scene(tenTable);
		Scene elevenTableScene = new Scene(elevenTable);
		Scene twelveTableScene = new Scene(twelveTable);
		Scene thirteenTableScene = new Scene(thirteenTable);
		Scene fourteenTableScene = new Scene(fourteenTable);
		Scene fifteenTableScene = new Scene(fifteenTable);
		
		//adding nodes to revision pane
		Rpane.getChildren().addAll(tableB);
		Rpane.getChildren().add(backToMenu[14]);
		
		//setting buttons on Action
		tableB[0].setOnAction(e -> args.setScene(twoTableScene));
		tableB[1].setOnAction(e -> args.setScene(threeTableScene));
		tableB[2].setOnAction(e -> args.setScene(fourTableScene));
		tableB[3].setOnAction(e -> args.setScene(fiveTableScene));
		tableB[4].setOnAction(e -> args.setScene(sixTableScene));
		tableB[5].setOnAction(e -> args.setScene(sevenTableScene));
		tableB[6].setOnAction(e -> args.setScene(eightTableScene));
		tableB[7].setOnAction(e -> args.setScene(nineTableScene));
		tableB[8].setOnAction(e -> args.setScene(tenTableScene));
		tableB[9].setOnAction(e -> args.setScene(elevenTableScene));
		tableB[10].setOnAction(e -> args.setScene(twelveTableScene));
		tableB[11].setOnAction(e -> args.setScene(thirteenTableScene));
		tableB[12].setOnAction(e -> args.setScene(fourteenTableScene));
		tableB[13].setOnAction(e -> args.setScene(fifteenTableScene));

			
		//MENU PANE
		VBox MenuBox = new VBox(1);
			
		//creating title label for menu: setting background
		TitleLabel gameTitle = new TitleLabel("TABEL TANTRUM");
		gameTitle.setBackground(bg1);
		//binding width to the width of MenuBox
		gameTitle.prefWidthProperty().bind(MenuBox.widthProperty());

			
		//LEVEL PANE		
		VBox levelBox=new VBox(1);
			
		//creating title label for levels: setting background and binding width
		TitleLabel levelTitle = new TitleLabel("Levels");
		levelTitle.setBackground(bg1);
		//binding width to the width of levelBox
		levelTitle.prefWidthProperty().bind(levelBox.widthProperty());

		//level Buttons
		Button[]  levelB= {new  Button("Easy"),
				new Button("Medium"),new  Button("Difficult")};
			
		for(int j = 0 ; j < levelB.length ; j++) {
				
			levelB[j].setBackground(bg2);
			levelB[j].setFont(font0);
			levelB[j].setAlignment(Pos.CENTER);		
			levelB[j].setTextFill(c3);
				
			//setting the height and width of the buttons
			levelB[j].setMaxSize(screenSize.getWidth(),screenSize.getHeight()/3.75);
			levelB[j].setMinSize(screenSize.getWidth(),screenSize.getHeight()/3.75);
		}
		
		//adding nodes to levelBox
		levelBox.getChildren().add(levelTitle);
		levelBox.getChildren().addAll(levelB);
			
			
		//Menu Buttons
		Button[] menuB = {new Button("Play"),new Button("Revise"),
		new Button("Scores"),new Button("Exit")};

		for(int j = 0 ; j < menuB.length ; j++)
		{
			menuB[j].setBackground(bg2);
			menuB[j].setFont(font0);
			menuB[j].setAlignment(Pos.CENTER);
			menuB[j].setTextFill(c3);

			//setting the height and width of the buttons
			menuB[j].setMaxSize(screenSize.getWidth(),screenSize.getHeight()/4.75);
			menuB[j].setMinSize(screenSize.getWidth(),screenSize.getHeight()/4.75);
				
		}	
			
		//adding nodes to the pane, MenuBox
	    MenuBox.getChildren().add(gameTitle);
	    MenuBox.getChildren().addAll(menuB);
	
	    //GRAPH pane 
	    StackPane graph = new StackPane();		
	    
		
	    //GRAPHICAL RESULT PANE
		VBox GraphicalResults =new VBox();
		
	   //setting the height and width of the graph node
		graph.setMaxSize(screenSize.getWidth(),screenSize.getHeight()/1.07);
		graph.setMinSize(screenSize.getWidth(),screenSize.getHeight()/1.07);
		//adding nodes to VBox GraphicalResults	
		GraphicalResults.getChildren().addAll(graph,backToMenu[15]);
		
		
		//GRAPH PANE
		Scene Graph = new Scene(GraphicalResults);
		
		// A button for showing graph
		Button showGraph=new Button("show Graph");
		showGraph.setBackground(bg_4);
		showGraph.setTextFill(Color.WHITE);
		//setting the height and width of the button
		showGraph.setMaxSize(screenSize.getWidth(),screenSize.getHeight()/14);
		showGraph.setMinSize(screenSize.getWidth(),screenSize.getHeight()/14);
		

		//setting the button to action
		showGraph.setOnAction(e->{ 
			try {
				//adding the BarChart to StackPane graph and setting the scene
				graph.getChildren().addAll(createGraph());
				args.setScene(Graph); 
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException e1) {

				e1.printStackTrace(); 
			}                  
		});
		
		//RECORDS PANE
		VBox Records=new VBox(0.5);
		
		//creating title label for tables : setting background and binding width
		TitleLabel recordLabel = new TitleLabel("YOUR 10 RECENT SCORES!");
		recordLabel.setBackground(bg3); recordLabel.setFont(font1);
		//binding width to the width of levelBox
		recordLabel.prefWidthProperty().bind(Records.widthProperty());
		
		
		//adding nodes Records Pane
		Records.getChildren().addAll(recordLabel,getRecords(),showGraph,backToMenu[13]);
			
			
		//creating scenes
		Menu = new Scene(MenuBox);
		Scene Play = new Scene(play);
		Scene Levels = new Scene(levelBox);
		Scene review = new Scene(Rpane);
		Scene scores = new Scene(Records);
	    
		//setting on Action
		levelB[0].setOnAction(e-> {args.setScene(Play); startFlag = true; playGame(1);});
		levelB[1].setOnAction(e-> {args.setScene(Play); startFlag = true; playGame(2);});
		levelB[2].setOnAction(e-> {args.setScene(Play); startFlag = true; playGame(3);});		
			
		//setting on Action
		menuB[0].setOnAction(e -> args.setScene(Levels));
		menuB[1].setOnAction(e -> args.setScene(review));
	    menuB[2].setOnAction(e ->{ refreshRecordTiles(); args.setScene(scores);} );
		   
		menuB[3].setOnAction(e -> System.exit(0));		
				
		//setting on Action
		for(int j = 0 ; j < backToMenu.length ; j++) {
			backToMenu[j].setOnAction(e -> args.setScene(Menu)); 
		}
	
		//read previous records from file and store in Array List
		record.readingFile();
		
		args.setScene(Menu);
		args.setFullScreen(true);
		args.show();

	}//end overriden method start
			
	private Button getBackToMenu() {
			
		Button bTm = new Button("Back To Menu");
		bTm.setBackground(bg_4);
		bTm.setTextFill(Color.WHITE);
			
		//setting the height and width of the button
		bTm.setMaxSize(screenSize.getWidth(),screenSize.getHeight()/12);
		bTm.setMinSize(screenSize.getWidth(),screenSize.getHeight()/12);
			
		return bTm;
	}//end method getBackToMenu

			 
	private static VBox getTable(int tableOf) {
			
		VBox Tpane = new VBox(0.5);	
		
		//creating Tiles to show table
		TableLabel[] tableT = new TableLabel[10];
		String LText;
		
		for(int j = 0 ; j < tableT.length ; j++) {
			
			LText = tableOf + " x " + (j + 1) + " = " + (j + 1)*tableOf;
			tableT[j] = new TableLabel(LText);
		}//end for loop
		
		Tpane.getChildren().addAll(tableT);
		return Tpane;
	}//end method getTable
	
	private VBox getRecords() throws Exception{   
			 
		VBox records = new VBox(0.5);
		
	    array = record.getScores();  
	   
	    //creating Tiles to show records
	    recordT = new RecordTile[11];   
	    
	    for(int j = 0 ; j < recordT.length ; j++){
	    	
	    	if(j <array.size()){
	    		recordT[j] = new RecordTile("" + array.get(j));
	    	}else{
	    		recordT[j] = new RecordTile("");  		
	    	}//end if-else
	    	
	    }//end for
	    
	    if(array.size() <= 0) recordT[10].setText("No Previous Records");
	    records.getChildren().addAll(recordT);
	    return records;
		
	}//end method getRecords
	
	private void refreshRecordTiles() {
		
	    //get scores array list of record
		array = record.getScores(); 
		
	    for(int j = 0 ; j < 11 ; j++){
	    	
	    	if(j <array.size()){
	    		recordT[j].setText("" + array.get(j));
	    	}else{
	    		recordT[j].setText("");  		
	    	}//end if-else
	    	
	    }//end for
	    if(array.size() <= 0) recordT[10].setText("No Previous Records");
	}
	
	private void playGame(int Level) {
			
		Thread t1 = new Thread(() ->{
			try{ while(startFlag) {reduceInterval(); Thread.sleep(30000);} }catch(Exception e) {}  });
				
		Thread t2 = new Thread(() ->{ 
			try{
				while(startFlag){
					generateProblem(Level);
					Thread.sleep(interval); }
				 	closePlay();
			}
			catch (InterruptedException | IOException | IllegalAccessException | IllegalArgumentException
			       | InvocationTargetException e) 
			{e.printStackTrace(); } 
			
		});
		
		Thread t3 = new Thread(() ->{
			try{ while(startFlag) { answerStatement(); Thread.sleep(50);} }catch(Exception e) {}}  );
		
		//setting threads to Daemon, to keep them from preventing program to exit
		t1.setDaemon(true);		t1.start(); 
		t2.setDaemon(true);		t2.start(); 	
		t3.setDaemon(true);		t3.start();  	
		
	}//end method PlayGame
		
	private void generateProblem(int Level) {
		    	     
	    if( i == 10) {
		    	 
	    	    RandomProblem(Level);//generate random problem
		    problems[i] = (l.getPrblm()).toString();
		    answers[i] = Integer.toString((l.getPrblm()).getValue());			  

		    printPrblmAndSln();//print to check
			     
		    Platform.runLater(() -> {
				problem_tile[10].setText(problems[10]); 
				problem_tile[10].setBackground(bg); 
			    warning_tile.setText("GAME OVER.");			    
		    });
				
			gameoverFlag = true;
			startFlag = false;
			return;
			     
	    }else {
		    	 
	    	i++;
	    	while(true) {
			    	 
			 //generate random problem 
			  RandomProblem(Level);  	 
			  boolean contains = false;		         
			  for (String s: answers) {
			  	if (s.equals("" + (l.getPrblm()).getValue()))
			    		 contains = true;
				 }//end for
			
			  if(!contains) {
			    	
			    	problems[i] = (l.getPrblm()).toString();
			    	answers[i] = Integer.toString((l.getPrblm()).getValue());
			    	break;
			   }//end if
			    
	    	}//end while
			     
			printPrblmAndSln();
				 
			Platform.runLater(() -> {
				
				if (i == 0) {
					 problem_tile[0].setText("Answer: " + problems[0]); problem_tile[0].setBackground(bg); 
				}
				else if (i == 1) {
					 problem_tile[1].setText(problems[1]); problem_tile[1].setBackground(bg); 
				}
				else if (i == 2) {
					 problem_tile[2].setText(problems[2]); problem_tile[2].setBackground(bg); 
				}
				else if (i == 3) {
					 problem_tile[3].setText(problems[3]); problem_tile[3].setBackground(bg); 
				}
				else if  (i == 4) {
					 problem_tile[4].setText(problems[4]); problem_tile[4].setBackground(bg); 
				}
				else if (i == 5) {
					 problem_tile[5].setText(problems[5]); problem_tile[5].setBackground(bg);
				}
				else if (i == 6) {
					 problem_tile[6].setText(problems[6]); problem_tile[6].setBackground(bg); 
				}
				else if (i == 7) {
					 problem_tile[7].setText(problems[7]); problem_tile[7].setBackground(bg);     
				}
				else if (i == 8) {
					problem_tile[8].setText(problems[8]); problem_tile[8].setBackground(bg);  
				}
				else if (i == 9) {
					problem_tile[9].setText(problems[9]); problem_tile[9].setBackground(bg);  
				}
			}); 
	    }//end else
	}//end method generateProblem

	private void RandomProblem(int level) {
			
		//dynamic binding
		switch(level) {
			case 1:
				Bind(l = new Easy());
				break;
			case 2:		
				Bind(l = new Medium());
				break;
			case 3:
				Bind(l = new Difficult());
				break;
		}//end switch
	        
	}//end method RandomProblem
	
	private void Bind(Level l) {
			l.generateRandom();
	}
	
	private void printPrblmAndSln() {

		System.out.print("LIST: [" );
	    for(String s: problems)  System.out.print(s + " ");  System.out.println("]");
			     
		System.out.print("ANSWERS: [");
		for(String s: problems)  System.out.print(s + " ");  System.out.println("]");
			   
		System.out.println("New answer:" + answers[0]);
		System.out.println("i:" + i);
	}//end method printPrblmAndSln

		
	private void answerStatement() {

		//getting the text
		S = answer_field.getText();	

		//if gameoverFlag is true return to method playGame();
		if(gameoverFlag)
		{	
			return;
		}
		else if((S).equals(answers[0])) {
				
			//if answer field text is equal to answer[0],add answer[0] to score
			//and update score tile
		    System.out.println("Correct answer!");
		        
		    score += Integer.parseInt(answers[0]);
		    S = "";
		        	        
		    //update UI
		    Platform.runLater(() -> {
		     		
		     	answer_field.setText(S); //re setting the answer field
		     	score_tile.setText("Score: " + score);
		     });
		     	
		     //shift problems and answers array elements to left by one place
		     for(int x = 0 ; x < i + 1 ; x++) {        	 
		         if (i < 10) {
		       		  problems[x] = problems[x+1];
			          answers[x] = answers[x+1];			  	          
		         } //end if
		     }//end for
		         					
		     i = i - 1; 		 // reduce the value of i, now the tiles showing problem 
		     RefreshTiles();   //are reduced by 1, as 1 problem is solved   
		         
		}//end if			    
		else {
			
			return;
		}//end else		
	}//end method answerStatement
		
	private void RefreshTiles() {
			
		// Update UI 
		Platform.runLater(() -> {
					    
			//update score Tile
			scoreString = "SCORE: " + score;
			score_tile.setText(scoreString);
			 
			for(ProblemTile t: problem_tile)
			   	t.setDefault();
			    
			//update ProblemTiles
			switch(i) {
				case 9:
					problem_tile[9].setText(problems[9]);
			       	problem_tile[9].setBackground(bg); 
				case 8:
					problem_tile[8].setText(problems[8]);
				    problem_tile[8].setBackground(bg); 
				case 7:
					problem_tile[7].setText(problems[7]);
				    problem_tile[7].setBackground(bg);
				case 6:
					problem_tile[6].setText(problems[6]);
				    problem_tile[6].setBackground(bg);
				case 5:
					problem_tile[5].setText(problems[5]); 
				    problem_tile[5].setBackground(bg);
				case 4:
					problem_tile[4].setText(problems[4]); 
				    problem_tile[4].setBackground(bg);
				case 3:
					problem_tile[3].setText(problems[3]);
				    problem_tile[3].setBackground(bg);
				case 2:
					problem_tile[2].setText(problems[2]);
				    problem_tile[2].setBackground(bg);
				case 1:
					problem_tile[1].setText(problems[1]);
				    problem_tile[1].setBackground(bg);
				case 0:
					problem_tile[0].setText("Answer: "+ problems[0]);
				    problem_tile[0].setBackground(bg);
				default:
					break;
			}//end switch
			
			
		});
	}//end method refreshLabel

	private void resetValues(){
			
	    startFlag = false;
	    gameoverFlag = false;
		    
	    for(int j = 0 ;j < problems.length ; j++) 
	    	problems[j] = "";
	    for(int j = 0 ;j < answers.length ; j++) 
	    	answers[j] = "999";
		    
	    S = "";
	    i = -1;
	    scoreString = "SCORE: ";
	    (l.getPrblm()).setFirstNum(0);
	    (l.getPrblm()).setSecondNum(0);
	    score = 0;
	    interval = 2700;
	    RefreshTiles();
		
	    Platform.runLater(() ->{
			
		//update warning tile
		warning_tile.setText("Don't let the orange area reach here!");
		//go back to menu
		args.setScene(Menu);
	    });
		    
	}//end method resetValues
		
	private void closePlay() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if(gameoverFlag){
				
			System.out.println("This function is executing");
			record.writingFile();
			resetValues();		        
		        return;
		}//end if
	}//end method closePlay

	private void reduceInterval(){
		
		if( interval > 1500)
			interval -= 300;    
	}//end method reduceInterval
		
	
	private BarChart<String, Number> createGraph() throws IOException, IllegalAccessException, IllegalArgumentException, 
	InvocationTargetException{ 	

		final CategoryAxis xAxis = new CategoryAxis();
	    	final NumberAxis yAxis = new NumberAxis();
	   	bc = new BarChart<String,Number>(xAxis,yAxis); 
		series1 = new XYChart.Series<String, Number>();
		
		
		//setting the label for x and y axis and Title for BarChart
		bc.setTitle("Score Card");
		xAxis.setLabel("Games Played");       
		yAxis.setLabel("Scores");
		series1.setName("Records of previous games");
	
		
		//get the score array List read from file
		array = record.getScores();
		
		for(int j = 0 ; j < 10 ; j++){	
			
			if(j < array.size()) 
				data = new XYChart.Data<String, Number>("Game"+(j+1), array.get(j));	
			else 
				data = new XYChart.Data<String, Number>("Game"+(j+1), 0);	
			
			series1.getData().add(data);
	
     	}//end for
		 		 
		bc.getData().addAll(series1);	       
		return bc;
	}//end method createGraph	  
	
	public static int getScore() {
		return score;
	}//end method getScore
	
}//end Class GUI		
