import java.util.Scanner;
public class Battleship {
	public static void battleship(){
	//INTRODUCTION
		String option;//Variable to choose the option of play, basic or advance
        System.out.println("Welcome to BATTLESHIP");//This is print to the screen to great the player(s) when they start playing 
        Scanner input=new Scanner (System.in);//Scanner to introduce the option of play, basic or advance
        System.out.println("Which mode do you want to play?\n> Basic  \n> Advance"); //The mode of play is asked
        option=input.nextLine();
        while(!option.equalsIgnoreCase("basic") && !option.equalsIgnoreCase("advance")){
        	System.out.println("Please introduce \"Yes\" or \"No\"");option = input.nextLine();}
        if(option.equalsIgnoreCase("basic")) {basic();} //If the user types "basic"(the case being ignored), the basic part of the code will be executed
        if(option.equalsIgnoreCase("advance")) {advance();} //If the user types "advance"(the case being ignored), the advanced part of the code will be executed
	}
	public static void basic(){
        int game = 0; String gamerep = "";//Variable to count the number of games played (game). And to keep repeating the code until the player doesn't want to play anymore(gamerep)
       //Ships
        do{ String [][] ships = new String [5][5];//Array to store the ships and them compare it with the board array to check if the position contain a ship.
        int h3r=(int)((Math.random()*ships.length));   int h3c=(int)((Math.random()*(ships.length-3)));//Generating a random coordinate for the horizontal ship of length three.  The 'y' part of the coordinate cannot include the last two columns because it will be out of bounds
        int h2r = 0,h2c=0, v3r = 0, v3c = 0, v2r = 0,v2c=0;//Initialization of the variables for the rest of coordinates
        boolean proof = true, proof2 = true, proof3 = true;//Initialization of the boolean variables to check the repetition of coordinates
             
        //For to match all the ship array to empty(so I can use the .isEmpty method later):
        for(int rows = 0; rows<5;rows++){
        	for(int cols = 0; cols<5; cols++){		
        		ships[rows][cols]= "";}}
             
        //Creating a ship in the ships array with the positions matching to the coordinate of the horizontal ship of length three already created and the next two columns in the same row
        ships[h3r][h3c]="S";
        ships[h3r][(h3c+1)]="S";
        ships[h3r][(h3c+2)]="S";
             
        while(proof){//While loop to check if the positions of the second ship (the horizontal of length two) are already occupied for the positions of the previous boat 
        	h2r=(int)(Math.random()*ships.length); h2c=(int)((Math.random()*(ships.length-2))); //Generating a random coordinate for the horizontal ship of length two.  The 'y' part of the coordinate cannot include the last column because it will be out of bounds
        	if (ships[h2r][h2c].isEmpty() && ships[h2r][(h2c+1)].isEmpty()){//Checking the coordinate that the ship will occupy are empty
        		proof = false;}
        	else{proof = true;}}
        //Creating a ship in the ships array with the positions matching to the coordinate of the horizontal ship of length two already created and the next column in the same row:
        ships[h2r][h2c]="S";
        ships[h2r][(h2c+1)]="S";
        
        while(proof2){//While loop to check if the positions of the third ship (the vertical of length three) are already occupied for the positions of the previous boats 
        	v3r=(int)((Math.random()*(ships.length-3))); v3c=(int)((Math.random()*(ships.length)));//Generating a random coordinate for the vertical ship of length three.  The 'x' part of the coordinate cannot include the last two rows because it will be out of bounds
        	if (ships[v3r][v3c].isEmpty() && ships[(v3r +1)][v3c].isEmpty() && ships[(v3r+2)][v3c].isEmpty()){//Checking the coordinate that the ship will occupy are empty
        		proof2 = false;}
        	else{proof2 = true;}}
        //Creating a ship in the ships array with the positions matching to the coordinate of the vertical ship of length three already created and the next two rows in the same column:
        ships[v3r][v3c]="S";
        ships[(v3r + 1)][v3c]="S";
        ships[(v3r + 2)][v3c]="S";
                     
        while(proof3){//While loop to check if the positions of the fourth(and last) ship (the vertical of length two) are already occupied for the positions of the previous boats 
        	v2r=(int)((Math.random()*(ships.length-2))); v2c=(int)((Math.random()*(ships.length)));//Generating a random coordinate for the vertical ship of length two.  The 'x' part of the coordinate cannot include the last row because it will be out of bounds
        	if (ships[v2r][v2c].isEmpty() && ships[(v2r+1)][v2c].isEmpty()){//Checking the coordinate that the ship will occupy are empty
        		proof3 = false;}
        	else{proof3 = true;}}
         //Creating a ship in the ships array with the positions matching to the coordinate of the vertical ship of length two already created and the next row in the same column:
        ships[v2r][v2c]="S";
        ships[(v2r + 1)][v2c]="S";
       
        //Game:  
        String [][] board = new String [5][5];//Array of the board. That will be printed to the screen and will change with each shot
        int sunk = 0,fired = 0;//Initialization of the variables to count the numbers of shots fires(fired) and ships sunk (sunk)
        //Scanner to ask for the row the player wants to shot(input1), the column(input2) and, once they have win, if they want to play again(input3):
        Scanner input1=new Scanner (System.in); Scanner input2=new Scanner (System.in); Scanner input3=new Scanner (System.in);
        //For to match all the board array to empty(so an space is printed instead of 'null' in the positions that have not yet been shot):
        for(int rows = 0; rows<5;rows++){
        	for(int cols = 0; cols<5; cols++){ 
        		board[rows][cols]= "";}}
            	
        do{ String col = ""; int colnum = 0, row = 0;//Initialization of the variables to ask for the row(row) and the column(col). Initialization of the variable that will be used to match the letter of the column introduced to a numer
        
        System.out.println("\tA \tB \tC \tD \tE"); //Print of the letter of the board
        //For to print the board:
        for(int rows = 0; rows<5;rows++){
        	System.out.println();//A new line for each row
        	System.out.print(rows);//Printing of the numbers of the board
        	for(int cols = 0; cols<5; cols++){ 
                 System.out.print("\t"+board[rows][cols]);}}
             
        //Printing of the shots fired and the ships sunk
        System.out.println("\nShots fired: "+fired+"\nShips sunk: "+sunk+"\nInsert the coordinates: ");	
        System.out.print("Row- ");//Asking the row that the played wants to shot
        row=input1.nextInt();
        if(row>4){//Exception if the row is more than for, since there are only four rows
        	System.out.println("Please introduce a number between 0 and 4");row=input1.nextInt();}
        System.out.print("Column- ");//Asking the column that the played wants to shot
        col=input2.nextLine();
        if(!col.equalsIgnoreCase("A") && !col.equalsIgnoreCase("B") && !col.equalsIgnoreCase("C") && !col.equalsIgnoreCase("D") && !col.equalsIgnoreCase("E")){
        	System.out.println("Please introduce a letter between A and E");col=input2.nextLine();}//Exception if the column is a letter "greater" than E(=4), since there are only four columns
        String let = col.toUpperCase();//An intermediate string to match the letters(ignoring the case) with numbers
                 //If conditions to match the letters with a number of column:
        if (let.equals("A")) {colnum = 0;}
        if (let.equals("B")) {colnum += 1;}
        if (let.equals("C")) {colnum += 2;}
        if (let.equals("D")) {colnum += 3;}
        if (let.equals("E")) {colnum += 4;}
        System.out.println(">("+row+","+let+")");//Printing of the coordinate the player have introduced
        fired = fired + 1;//Incrementing of the shots fired
                 
        if(ships[row][colnum]== "S"){board[row][colnum] = "*";}//If the position matching to the coordinate the player have introduce contains part of a ship a "*" is printed
        if(ships[row][colnum].isEmpty()){board[row][colnum] = "~";}//If the position matching to the coordinate the player have introduce does not contain any part of a ship a "~" is printed
        
        //If all of the positions of a ship are already a "*" in the board array they all turn into a "#", meaning they are sunk. The sunk variable increments one every time this happens:
        if(board[h3r][h3c]=="*" && board[h3r][(h3c+1)]=="*" && board[h3r][(h3c+2)]=="*"){
        	board[h3r][h3c]="#"; board[h3r][(h3c+1)]="#"; board[h3r][(h3c+2)]="#";sunk +=1;}
        if(board[h2r][h2c]=="*" && board[h2r][(h2c+1)]=="*"){
        	board[h2r][h2c]="#"; board[h2r][(h2c+1)]="#";sunk +=1;}
        if(board[v3r][v3c]=="*" && board[(v3r+1)][v3c]=="*" && board[(v3r+2)][v3c]=="*"){
        	board[v3r][v3c]="#"; board[(v3r+1)][v3c]="#"; board[(v3r+2)][v3c]="#";sunk +=1;}
        if(board[v2r][v2c]=="*" && board[(v2r+1)][v2c]=="*"){
        	board[v2r][v2c]="#"; board[(v2r+1)][v2c]="#"; sunk +=1;}
                 
        //If the four ships are sunk the table is printed one more time to the screen along with the fires and sunk variables
        if (sunk == 4){ game = game + 1;
        System.out.println("\tA \tB \tC \tD \tE"); 
        for(int rows = 0; rows<5;rows++){
        	System.out.println();
        	System.out.print(rows);
        	for(int cols = 0; cols<5; cols++){ 
        		System.out.print("\t"+board[rows][cols]);}}
        System.out.println("\nShots fired: "+fired+"\nShips sunk: "+sunk);
        String conf;
        System.out.println("\nThe game is over!\n"+game+" Game played \nDo you want to play again? \nYes \nNo");//The player if asked if they want to play again
        conf = input3.nextLine();
        if(conf.equalsIgnoreCase("yes")){//If the answer is yes(ignoring the case) then the gamerep variable, that is to repeat the game, is equal to yes too
        	gamerep = "yes";}
                 	
        else if(conf.equalsIgnoreCase("no")){gamerep = "no";
        System.out.println("It was nice playing with you. Hope we can do it again soon!");}//If the answer is no(ignoring the case) this message is printed and the game ends
        
        else{System.out.println("Please introduce \"Yes\" or \"No\"");conf = input3.nextLine();//If the user introduce something different from yes or no(ignoring the case in both) they will be asked again one more time and the same conditions to the answer will be applied:
        if(conf.equalsIgnoreCase("yes")){
        	gamerep = "yes";}
        else if(conf.equalsIgnoreCase("no")){gamerep = "no";
        System.out.println("It was nice playing with you. Hope we can do it again soon!");}
        }
        }
        }while(sunk<4);//The game code will be repeating until all the boats are sunk, meaning the board and all the other things will be printed too
        }while(gamerep.equalsIgnoreCase("yes"));//If the player wants to play again all of the basic code (except the initialization of the game and gamerep variables) will be ran again 
        
               
    }    
	public static void advance(){
		int game = 0; String gamerep = "";
		do{
			Scanner input=new Scanner (System.in);
			int size, boxes, shipsmax, shipsnum3, shipsnum2, shipsnum;
			boolean rep = true, sizec = true;
			
	        System.out.print("Which size do you want the board to be?The minimum being 5x5 and the maximum 10x10.");
	        size=input.nextInt();
	        while(sizec){
	        	if(size>=5 && size<=10){sizec = false;}
	        	if(size<5 || size>10){
	        		System.out.print("\nPlease introduce a number between 5 and 10"); size=input.nextInt(); sizec = true;}}
	        
	        String water, touched, sunks;
	        Scanner symbols = new Scanner (System.in);
	        System.out.print("\nWhich symbol do you want to use for water?"); 
	        water = symbols.nextLine();
	        System.out.print("\nWhich symbol do you want to use for a touched ship?"); 
	        touched = symbols.nextLine();
	        System.out.print("\nWhich symbol do you want to use for a sunk ship?"); 
	        sunks = symbols.nextLine();
	        
	        boxes = size*size;
	        double fortyper = boxes*0.4;
	        shipsmax= (int) fortyper;
	        
	        do{ System.out.print("\nHow many ships of three boxes do you want?"); 
	        	shipsnum3 = input.nextInt();
	        	System.out.print("\nHow many ships of two boxes do you want?"); 
	        	shipsnum2 = input.nextInt();
	        	shipsnum = 3*shipsnum3 + 2*shipsnum2;
	        	if(shipsnum>shipsmax){
	        		System.out.print("\nIt's not possible to create the number of ships you want. Please introduce smaller values.");}
	        }while(shipsnum>shipsmax);
	        
	        Scanner players = new Scanner (System.in); String numplay = ""; int multiplay = 0;
	        System.out.println("\nHow many players are going to play?\nOne \nTwo"); 
	        numplay = players.nextLine();
	        while(!numplay.equalsIgnoreCase("one") && !numplay.equalsIgnoreCase("two")){
	        	System.out.println("Please introduce \"One\" or \"Two\""); numplay = players.nextLine();}
	        if(numplay.equalsIgnoreCase("One")){
	        	System.out.println("You've choosen to be one player. Have fun!");}
	        if(numplay.equalsIgnoreCase("Two")){
	        	multiplay = 2; System.out.println("You've choosen to be two players. Have fun!");}
	        
			String [][] ships = new String [size][size];
	        for(int rows = 0; rows<ships.length;rows++){
	            for(int cols = 0; cols<ships[0].length; cols++){		
	           	 	ships[rows][cols]= "";}}
			
	        int times = 0, times2 = 0; String direction = "";
			while(times<shipsnum3){
				while(rep){int xh3 = 0, yh3 = 0, xv3 = 0, yv3 =0, d = 0;
					d = (int)((Math.random()*2)+1);
					if(d==1){direction = "horizontal";
						xh3 = (int)( Math.random()*ships.length);
						yh3 = (int)( Math.random()*(ships.length-3));}
					if(d == 2){direction = "vertical";
						xv3 = (int)( Math.random()*(ships.length-3));
						yv3 = (int)( Math.random()*ships.length);}
					
					if(direction.equals("horizontal")){
						if(ships[xh3][yh3].isEmpty() && ships[xh3][yh3+1].isEmpty() && ships[xh3][yh3+2].isEmpty()){
							ships[xh3][yh3] = "Sh3"; ships[xh3][yh3+1] = "sh3"; ships[xh3][yh3+2] = "sh3"; 
							rep = false;times += 1;}
						else{rep = true;}}
					if(direction.contentEquals("vertical")){
						if(ships[xv3][yv3].isEmpty() && ships[xv3+1][yv3].isEmpty() && ships[xv3+2][yv3].isEmpty()){
							ships[xv3][yv3] = "Sv3"; ships[xv3+1][yv3] = "sv3"; ships[xv3+2][yv3] = "sv3";
							rep = false;times += 1;}
						else{rep = true;}}
				} rep = true;
			}
			
			while(times2<shipsnum2){
				while(rep){int xh2 = 0, yh2 = 0, xv2 = 0, yv2 =0, d = 0;
					d = (int)((Math.random()*2)+1);
					if(d==1){direction = "horizontal";
						xh2 = (int)( Math.random()*ships.length);
						yh2 = (int)( Math.random()*(ships.length-2));}
					if(d == 2){direction = "vertical";
						xv2 = (int)( Math.random()*(ships.length-2));
						yv2 = (int)( Math.random()*ships.length);}
					
					if(direction.equals("horizontal")){
						if(ships[xh2][yh2].isEmpty() && ships[xh2][yh2+1].isEmpty() && ships[xh2][yh2+2].isEmpty()){
							ships[xh2][yh2] = "Sh2"; ships[xh2][yh2+1] = "sh2";
							rep = false;times2 += 1;}
						else{rep = true;}}
					if(direction.contentEquals("vertical")){
						if(ships[xv2][yv2].isEmpty() && ships[xv2+1][yv2].isEmpty() && ships[xv2+2][yv2].isEmpty()){
							ships[xv2][yv2] = "Sv2"; ships[xv2+1][yv2] = "sv2";
							rep = false;times2 += 1;}
						else{rep = true;}}
				} rep = true;
			}
			
				String [][] shipsp1 = new String [size][size];
		        for(int rows = 0; rows<shipsp1.length;rows++){
		            for(int cols = 0; cols<shipsp1[0].length; cols++){		
		           	 	shipsp1[rows][cols]= "";}}
				
		        int timesp1 = 0, times2p1 = 0; String directionp1 = "";
				while(timesp1<shipsnum3){
					while(rep){int xh3 = 0, yh3 = 0, xv3 = 0, yv3 =0, d = 0;
						d = (int)((Math.random()*2)+1);
						if(d==1){directionp1 = "horizontal";
							xh3 = (int)( Math.random()*shipsp1.length);
							yh3 = (int)( Math.random()*(shipsp1.length-3));}
						if(d == 2){directionp1 = "vertical";
							xv3 = (int)( Math.random()*(shipsp1.length-3));
							yv3 = (int)( Math.random()*shipsp1.length);}
						
						if(directionp1.equals("horizontal")){
							if(shipsp1[xh3][yh3].isEmpty() && shipsp1[xh3][yh3+1].isEmpty() && shipsp1[xh3][yh3+2].isEmpty()){
								shipsp1[xh3][yh3] = "Sh3"; shipsp1[xh3][yh3+1] = "sh3"; shipsp1[xh3][yh3+2] = "sh3"; 
								rep = false;timesp1 += 1;}
							else{rep = true;}}
						if(directionp1.contentEquals("vertical")){
							if(shipsp1[xv3][yv3].isEmpty() && shipsp1[xv3+1][yv3].isEmpty() && shipsp1[xv3+2][yv3].isEmpty()){
								shipsp1[xv3][yv3] = "Sv3"; shipsp1[xv3+1][yv3] = "sv3"; shipsp1[xv3+2][yv3] = "sv3"; 
								rep = false;timesp1 += 1;}
							else{rep = true;}}
					} rep = true;
				}
				
				while(times2p1<shipsnum2){
					while(rep){int xh2 = 0, yh2 = 0, xv2 = 0, yv2 =0, d = 0;
						d = (int)((Math.random()*2)+1);
						if(d==1){directionp1 = "horizontal";
							xh2 = (int)( Math.random()*shipsp1.length);
							yh2 = (int)( Math.random()*(shipsp1.length-2));}
						if(d == 2){directionp1 = "vertical";
							xv2 = (int)( Math.random()*(shipsp1.length-2));
							yv2 = (int)( Math.random()*shipsp1.length);}
						
						if(directionp1.equals("horizontal")){
							if(shipsp1[xh2][yh2].isEmpty() && shipsp1[xh2][yh2+1].isEmpty() && shipsp1[xh2][yh2+2].isEmpty()){
								shipsp1[xh2][yh2] = "Sh2"; shipsp1[xh2][yh2+1] = "sh2"; 
								rep = false;times2p1 += 1;}
							else{rep = true;}}
						if(directionp1.contentEquals("vertical")){
							if(shipsp1[xv2][yv2].isEmpty() && shipsp1[xv2+1][yv2].isEmpty() && shipsp1[xv2+2][yv2].isEmpty()){
								shipsp1[xv2][yv2] = "Sv2"; shipsp1[xv2+1][yv2] = "sv2";
								rep = false;times2p1 += 1;}
							else{rep = true;}}
					} rep = true;
				}
	                
	        String [][] board = new String [size][size];
	        int sunk = 0,fired = 0, numships = shipsnum3 + shipsnum2;
	        Scanner input1=new Scanner (System.in); Scanner input2=new Scanner (System.in); Scanner input3=new Scanner (System.in);
	        for(int rows = 0; rows<board.length;rows++){
	            for(int cols = 0; cols<board[0].length; cols++){ 
	           	 	board[rows][cols]= "";}}
	       
	        String [][] boardp1 = new String [size][size];
	        int sunkp1 = 0,firedp1 = 0;
            for(int rows = 0; rows<boardp1.length;rows++){
            	for(int cols = 0; cols<boardp1[0].length; cols++){ 
            		boardp1[rows][cols]= "";}
	        }
	        
	       	do{ if (multiplay == 2){
	       			System.out.println("\nIs Player 1 turn\n ");}
	       		String col = ""; int colnum = 0, row = 0;
		        if(size == 5){System.out.println("\tA \tB \tC \tD \tE");}
		        if(size == 6){System.out.println("\tA \tB \tC \tD \tE \tF");}
		        if(size == 7){System.out.println("\tA \tB \tC \tD \tE \tF \tG ");}
		        if(size == 8){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH ");}
		        if(size == 9){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI");}
		        if(size == 10){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI \tJ");}
		        for(int rows = 0; rows<board.length;rows++){
		            System.out.println();
		            System.out.print(rows);
		            for(int cols = 0; cols<board[0].length; cols++){ 
		            	System.out.print("\t"+board[rows][cols]);}}
		        
		        System.out.println("\nShots fired: "+fired+"\nShips sunk: "+sunk+"\nInsert the coordinates: ");	
		           
		        System.out.print("Row- ");
		        row=input1.nextInt();
		        int rownumc = size - 1;
		        while(row>rownumc || row<0){
		           	System.out.println("Please introduce a number between 0 and " +rownumc);row=input1.nextInt();}
		        
		        System.out.print("Column- ");
		        col=input2.nextLine();
		        if(size == 5){
		        	while(!col.equalsIgnoreCase("A") && !col.equalsIgnoreCase("B") && !col.equalsIgnoreCase("C") && !col.equalsIgnoreCase("D") && !col.equalsIgnoreCase("E")){
		        		System.out.println("Please introduce a letter between A and E");col=input2.nextLine();}}
		        if (size == 6){
		        	while(!col.equalsIgnoreCase("A") && !col.equalsIgnoreCase("B") && !col.equalsIgnoreCase("C") && !col.equalsIgnoreCase("D") && !col.equalsIgnoreCase("E") && !col.equalsIgnoreCase("F")){
		        		System.out.println("Please introduce a letter between A and F");col=input2.nextLine();}}
		        if(size == 7){
		        	while(!col.equalsIgnoreCase("A") && !col.equalsIgnoreCase("B") && !col.equalsIgnoreCase("C") && !col.equalsIgnoreCase("D") && !col.equalsIgnoreCase("E") && !col.equalsIgnoreCase("F") && !col.equalsIgnoreCase("G")){
		        		System.out.println("Please introduce a letter between A and G");col=input2.nextLine();}}
		        if(size == 8){
		        	while(!col.equalsIgnoreCase("A") && !col.equalsIgnoreCase("B") && !col.equalsIgnoreCase("C") && !col.equalsIgnoreCase("D") && !col.equalsIgnoreCase("E") && !col.equalsIgnoreCase("F") && !col.equalsIgnoreCase("G")&& !col.equalsIgnoreCase("H")){
		        		System.out.println("Please introduce a letter between A and H");col=input2.nextLine();}}
		        if(size == 9){
		        	while(!col.equalsIgnoreCase("A") && !col.equalsIgnoreCase("B") && !col.equalsIgnoreCase("C") && !col.equalsIgnoreCase("D") && !col.equalsIgnoreCase("E") && !col.equalsIgnoreCase("F")&& !col.equalsIgnoreCase("G") && !col.equalsIgnoreCase("H") && !col.equalsIgnoreCase("I")){
		        		System.out.println("Please introduce a letter between A and I");col=input2.nextLine();}}
		        if(size == 9){
		        	while(!col.equalsIgnoreCase("A") && !col.equalsIgnoreCase("B") && !col.equalsIgnoreCase("C") && !col.equalsIgnoreCase("D") && !col.equalsIgnoreCase("E") && !col.equalsIgnoreCase("F")&& !col.equalsIgnoreCase("G") && !col.equalsIgnoreCase("H") && !col.equalsIgnoreCase("I") && !col.equalsIgnoreCase("J")){
		        		System.out.println("Please introduce a letter between A and J");col=input2.nextLine();}}
		            
		        String let = col.toUpperCase();
		        System.out.println(">("+row+","+let+")");
		        fired = fired + 1;
		            
		        if (let.equals("A")) {colnum = 0;}
		        if (let.equals("B")) {colnum += 1;}
		        if (let.equals("C")) {colnum += 2;}
		        if (let.equals("D")) {colnum += 3;}
		        if (let.equals("E")) {colnum += 4;}
		        if (let.equals("F")) {colnum += 5;}
		        if (let.equals("G")) {colnum += 6;}
		        if (let.equals("H")) {colnum += 7;}
		        if (let.equals("I")) {colnum += 8;}
		        if (let.equals("J")) {colnum += 9;}
		            
		        if((ships[row][colnum].equalsIgnoreCase("sh3") && !"#".equals(board[row][colnum]))||(ships[row][colnum].equalsIgnoreCase("sv3") && !"#".equals(board[row][colnum]))){
		        	board[row][colnum] = touched;}
		        if((ships[row][colnum].equalsIgnoreCase("sh2") && !"#".equals(board[row][colnum]))||(ships[row][colnum].equalsIgnoreCase("sv2") && !"#".equals(board[row][colnum]))){
		        	board[row][colnum] = touched;}
		        if(ships[row][colnum].isEmpty()){board[row][colnum] = water;}
		        
		        if(colnum<(size-2) && board[row][colnum]==touched && board[row][(colnum+1)]==touched && board[row][(colnum+2)]==touched && ships[row][colnum]=="Sh3"){
		        	board[row][colnum]=sunks; board[row][(colnum+1)]=sunks; board[row][(colnum+2)]=sunks;sunk +=1;}
		        if(colnum>0 && colnum<rownumc && board[row][colnum]==touched && board[row][(colnum-1)]==touched && board[row][(colnum+1)]==touched && ships[row][colnum-1] == "Sh3" && ships[row][colnum] == "sh3"){
		        	board[row][colnum]=sunks; board[row][(colnum-1)]=sunks; board[row][(colnum+1)]=sunks;sunk +=1;}
		        if(colnum>1 && board[row][colnum]==touched && board[row][(colnum-1)]==touched && board[row][(colnum-2)]==touched && ships[row][colnum-2] == "Sh3" && ships[row][colnum] == "sh3"){
		        	board[row][colnum]=sunks; board[row][(colnum-1)]=sunks; board[row][(colnum-2)]=sunks;sunk +=1;}
		            
		        if(row<(size-2) && board[row][colnum]==touched && board[row+1][(colnum)]==touched && board[row+2][(colnum)]==touched && ships[row][colnum]=="Sv3"){
		        	board[row][colnum]=sunks; board[row+1][(colnum)]=sunks; board[row+2][(colnum)]=sunks;sunk +=1;}
		        if(row>0 && row<rownumc && board[row][colnum]==touched && board[row-1][(colnum)]==touched && board[row+1][(colnum)]==touched && ships[row -1][colnum] == "Sv3" && ships[row][colnum] == "sv3"){
		        	board[row][colnum]=sunks; board[row-1][(colnum)]=sunks; board[row+1][(colnum)]=sunks;sunk +=1;}
		        if(row>1 && board[row][colnum]==touched && board[row-1][(colnum)]==touched && board[row-2][(colnum)]==touched && ships[row-2][colnum] == "Sv3" && ships[row][colnum] == "sv3"){
		        	board[row][colnum]=sunks; board[row-1][(colnum)]=sunks; board[row-2][(colnum)]=sunks;sunk +=1;}
		            
		        if(colnum<rownumc && board[row][colnum]==touched && board[row][(colnum+1)]==touched && ships[row][colnum]=="Sh2"){
		        	board[row][colnum]=sunks; board[row][(colnum+1)]=sunks;sunk +=1;}
		        if(colnum>0 && board[row][colnum]==touched && board[row][(colnum-1)]==touched && ships[row][colnum-1] == "Sh2"){
		        	board[row][colnum]=sunks; board[row][(colnum-1)]=sunks; sunk +=1;}
		            
		        if(row<rownumc && board[row][colnum]==touched && board[row+1][(colnum)]==touched&& ships[row][colnum]=="Sv2"){
		        	board[row][colnum]=sunks; board[row+1][(colnum)]=sunks;sunk +=1;}
		        if(row>0 && board[row][colnum]==touched && board[row-1][(colnum)]==touched && ships[row-1][colnum] == "Sv2"){
		        	board[row][colnum]=sunks; board[row-1][(colnum)]=sunks; sunk +=1;}
		        
		        if(multiplay == 2 && sunk<numships){
		        	if(size == 5){System.out.println("\tA \tB \tC \tD \tE");}
		        	if(size == 6){System.out.println("\tA \tB \tC \tD \tE \tF");}
		        	if(size == 7){System.out.println("\tA \tB \tC \tD \tE \tF \tG ");}
		        	if(size == 8){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH ");}
		        	if(size == 9){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI");}
		        	if(size == 10){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI \tJ");}
		        	for(int rows = 0; rows<board.length;rows++){
		        		System.out.println();
		        		System.out.print(rows);
		        		for(int cols = 0; cols<board[0].length; cols++){ 
		        			System.out.print("\t"+board[rows][cols]);}}
		        }
		            
		        if (sunk == numships){ game = game + 1;
		        	if(size == 5){System.out.println("\tA \tB \tC \tD \tE");}
		        	if(size == 6){System.out.println("\tA \tB \tC \tD \tE \tF");}
		        	if(size == 7){System.out.println("\tA \tB \tC \tD \tE \tF \tG ");}
		        	if(size == 8){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH ");}
		        	if(size == 9){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI");}
		        	if(size == 10){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI \tJ");}
		        	for(int rows = 0; rows<board.length;rows++){
		        		System.out.println();
		        		System.out.print(rows);
		        		for(int cols = 0; cols<board[0].length; cols++){ 
		        			System.out.print("\t"+board[rows][cols]);}}
		        	
			        System.out.println("\nShots fired: "+fired+"\nShips sunk: "+sunk);
			        String conf;
			        System.out.println("\nThe game is over!");
			        if (multiplay == 2){
			        	System.out.print("Player 1 has won, congratulations!");}
			        System.out.println("\n"+game+" Game played \nDo you want to play again? \nYes \nNo"); 
			        conf = input3.nextLine();
			        while(!conf.equalsIgnoreCase("yes") && !conf.equalsIgnoreCase("no")){
			        	System.out.println("Please introduce \"Yes\" or \"No\"");conf = input3.nextLine();}
			        if(conf.equalsIgnoreCase("yes")){
			        	gamerep = "yes";}
			        if(conf.equalsIgnoreCase("no")){
			        	gamerep = "no"; System.out.println("It was nice playing with you. Hope we can do it again soon!");}}
		        
		        if (multiplay == 2 && sunk!=numships){
		        	System.out.println("\nIs Player 2 turn\n ");
		        	String colp1 = ""; int colnump1 = 0, rowp1 = 0;
			        if(size == 5){System.out.println("\tA \tB \tC \tD \tE");}
			        if(size == 6){System.out.println("\tA \tB \tC \tD \tE \tF");}
			        if(size == 7){System.out.println("\tA \tB \tC \tD \tE \tF \tG ");}
			        if(size == 8){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH ");}
			        if(size == 9){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI");}
			        if(size == 10){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI \tJ");}
			        for(int rows = 0; rows<boardp1.length;rows++){
			            System.out.println();
			            System.out.print(rows);
			            for(int cols = 0; cols<boardp1[0].length; cols++){ 
			            	System.out.print("\t"+boardp1[rows][cols]);}}
			        
			        System.out.println("\nShots fired: "+firedp1+"\nShips sunk: "+sunkp1+"\nInsert the coordinates: ");	
			           
			        System.out.print("row- ");
			        rowp1=input1.nextInt();
			        while(rowp1>rownumc || rowp1<0){
			           	System.out.println("Please introduce a number between 0 and " +rownumc);rowp1=input1.nextInt();}
			        
			        System.out.print("Column- ");
			        colp1=input2.nextLine();
			        if(size == 5){
			        	while(!colp1.equalsIgnoreCase("A") && !colp1.equalsIgnoreCase("B") && !colp1.equalsIgnoreCase("C") && !colp1.equalsIgnoreCase("D") && !colp1.equalsIgnoreCase("E")){
			        		System.out.println("Please introduce a letter between A and E");colp1=input2.nextLine();}}
			        if (size == 6){
			        	while(!colp1.equalsIgnoreCase("A") && !colp1.equalsIgnoreCase("B") && !colp1.equalsIgnoreCase("C") && !colp1.equalsIgnoreCase("D") && !colp1.equalsIgnoreCase("E") && !colp1.equalsIgnoreCase("F")){
			        		System.out.println("Please introduce a letter between A and F");colp1=input2.nextLine();}}
			        if(size == 7){
			        	while(!colp1.equalsIgnoreCase("A") && !colp1.equalsIgnoreCase("B") && !colp1.equalsIgnoreCase("C") && !colp1.equalsIgnoreCase("D") && !colp1.equalsIgnoreCase("E") && !colp1.equalsIgnoreCase("F") && !colp1.equalsIgnoreCase("G")){
			        		System.out.println("Please introduce a letter between A and G");colp1=input2.nextLine();}}
			        if(size == 8){
			        	while(!colp1.equalsIgnoreCase("A") && !colp1.equalsIgnoreCase("B") && !colp1.equalsIgnoreCase("C") && !colp1.equalsIgnoreCase("D") && !colp1.equalsIgnoreCase("E") && !colp1.equalsIgnoreCase("F") && !colp1.equalsIgnoreCase("G")&& !colp1.equalsIgnoreCase("H")){
			        		System.out.println("Please introduce a letter between A and H");colp1=input2.nextLine();}}
			        if(size == 9){
			        	while(!colp1.equalsIgnoreCase("A") && !colp1.equalsIgnoreCase("B") && !colp1.equalsIgnoreCase("C") && !colp1.equalsIgnoreCase("D") && !colp1.equalsIgnoreCase("E") && !colp1.equalsIgnoreCase("F")&& !colp1.equalsIgnoreCase("G") && !colp1.equalsIgnoreCase("H") && !colp1.equalsIgnoreCase("I")){
			        		System.out.println("Please introduce a letter between A and I");colp1=input2.nextLine();}}
			        if(size == 9){
			        	while(!colp1.equalsIgnoreCase("A") && !colp1.equalsIgnoreCase("B") && !colp1.equalsIgnoreCase("C") && !colp1.equalsIgnoreCase("D") && !colp1.equalsIgnoreCase("E") && !colp1.equalsIgnoreCase("F")&& !colp1.equalsIgnoreCase("G") && !colp1.equalsIgnoreCase("H") && !colp1.equalsIgnoreCase("I") && !colp1.equalsIgnoreCase("J")){
			        		System.out.println("Please introduce a letter between A and J");colp1=input2.nextLine();}}
			            
			        String letp1 = colp1.toUpperCase();
			        System.out.println(">("+rowp1+","+letp1+")");
			        firedp1 = firedp1 + 1;
			            
			        if (letp1.equals("A")) {colnump1 = 0;}
			        if (letp1.equals("B")) {colnump1 += 1;}
			        if (letp1.equals("C")) {colnump1 += 2;}
			        if (letp1.equals("D")) {colnump1 += 3;}
			        if (letp1.equals("E")) {colnump1 += 4;}
			        if (letp1.equals("F")) {colnump1 += 5;}
			        if (letp1.equals("G")) {colnump1 += 6;}
			        if (letp1.equals("H")) {colnump1 += 7;}
			        if (letp1.equals("I")) {colnump1 += 8;}
			        if (letp1.equals("J")) {colnump1 += 9;}
			            
			        if((shipsp1[rowp1][colnump1].equalsIgnoreCase("sh3") && !"#".equals(boardp1[rowp1][colnump1]))||(shipsp1[rowp1][colnump1].equalsIgnoreCase("sv3") && !"#".equals(boardp1[rowp1][colnump1]))){
			        	boardp1[rowp1][colnump1] = touched;}
			        if((shipsp1[rowp1][colnump1].equalsIgnoreCase("sh2") && !"#".equals(boardp1[rowp1][colnump1]))||(shipsp1[rowp1][colnump1].equalsIgnoreCase("sv2") && !"#".equals(boardp1[rowp1][colnump1]))){
			        	boardp1[rowp1][colnump1] = touched;}
			        if(shipsp1[rowp1][colnump1].isEmpty()){boardp1[rowp1][colnump1] = water;}
			        
			        if(colnump1<(size-2) && boardp1[rowp1][colnump1]==touched && boardp1[rowp1][(colnump1+1)]==touched && boardp1[rowp1][(colnump1+2)]==touched && shipsp1[rowp1][colnump1]=="Sh3"){
			        	boardp1[rowp1][colnump1]=sunks; boardp1[rowp1][(colnump1+1)]=sunks; boardp1[rowp1][(colnump1+2)]=sunks;sunkp1 +=1;}
			        if(colnump1>0 && colnump1<rownumc && boardp1[rowp1][colnump1]==touched && boardp1[rowp1][(colnump1-1)]==touched && boardp1[rowp1][(colnump1+1)]==touched && shipsp1[rowp1][colnump1-1] == "Sh3" && shipsp1[rowp1][colnump1] == "sh3"){
			        	boardp1[rowp1][colnump1]=sunks; boardp1[rowp1][(colnump1-1)]=sunks; boardp1[rowp1][(colnump1+1)]=sunks;sunkp1 +=1;}
			        if(colnump1>1 && boardp1[rowp1][colnump1]==touched && boardp1[rowp1][(colnump1-1)]==touched && boardp1[rowp1][(colnump1-2)]==touched && shipsp1[rowp1][colnump1-2] == "Sh3" && shipsp1[rowp1][colnump1] == "sh3"){
			        	boardp1[rowp1][colnump1]=sunks; boardp1[rowp1][(colnump1-1)]=sunks; boardp1[rowp1][(colnump1-2)]=sunks;sunkp1 +=1;}
			            
			        if(rowp1<(size-2) && boardp1[rowp1][colnump1]==touched && boardp1[rowp1+1][(colnump1)]==touched && boardp1[rowp1+2][(colnump1)]==touched && shipsp1[rowp1][colnump1]=="Sv3"){
			        	boardp1[rowp1][colnump1]=sunks; boardp1[rowp1+1][(colnump1)]=sunks; boardp1[rowp1+2][(colnump1)]=sunks;sunkp1 +=1;}
			        if(rowp1>0 && rowp1<rownumc && boardp1[rowp1][colnump1]==touched && boardp1[rowp1-1][(colnump1)]==touched && boardp1[rowp1+1][(colnump1)]==touched && shipsp1[rowp1 -1][colnump1] == "Sv3" && shipsp1[rowp1][colnump1] == "sv3"){
			        	boardp1[rowp1][colnump1]=sunks; boardp1[rowp1-1][(colnump1)]=sunks; boardp1[rowp1+1][(colnump1)]=sunks;sunkp1 +=1;}
			        if(rowp1>1 && boardp1[rowp1][colnump1]==touched && boardp1[rowp1-1][(colnump1)]==touched && boardp1[rowp1-2][(colnump1)]==touched && shipsp1[rowp1-2][colnump1] == "Sv3" && shipsp1[rowp1][colnump1] == "sv3"){
			        	boardp1[rowp1][colnump1]=sunks; boardp1[rowp1-1][(colnump1)]=sunks; boardp1[rowp1-2][(colnump1)]=sunks;sunkp1 +=1;}
			            
			        if(colnump1<rownumc && boardp1[rowp1][colnump1]==touched && boardp1[rowp1][(colnump1+1)]==touched && shipsp1[rowp1][colnump1]=="Sh2"){
			        	boardp1[rowp1][colnump1]=sunks; boardp1[rowp1][(colnump1+1)]=sunks;sunkp1 +=1;}
			        if(colnump1>0 && boardp1[rowp1][colnump1]==touched && boardp1[rowp1][(colnump1-1)]==touched && shipsp1[rowp1][colnump1-1] == "Sh2"){
			        	boardp1[rowp1][colnump1]=sunks; boardp1[rowp1][(colnump1-1)]=sunks; sunkp1 +=1;}
			            
			        if(rowp1<rownumc && boardp1[rowp1][colnump1]==touched && boardp1[rowp1+1][(colnump1)]==touched&& shipsp1[rowp1][colnump1]=="Sv2"){
			        	boardp1[rowp1][colnump1]=sunks; boardp1[rowp1+1][(colnump1)]=sunks;sunkp1 +=1;}
			        if(rowp1>0 && boardp1[rowp1][colnump1]==touched && boardp1[rowp1-1][(colnump1)]==touched && shipsp1[rowp1-1][colnump1] == "Sv2"){
			        	boardp1[rowp1][colnump1]=sunks; boardp1[rowp1-1][(colnump1)]=sunks; sunkp1 +=1;}
			        
			        if(sunkp1 <numships){
			        	if(size == 5){System.out.println("\tA \tB \tC \tD \tE");}
				        if(size == 6){System.out.println("\tA \tB \tC \tD \tE \tF");}
				        if(size == 7){System.out.println("\tA \tB \tC \tD \tE \tF \tG ");}
				        if(size == 8){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH ");}
				        if(size == 9){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI");}
				        if(size == 10){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI \tJ");}
				        for(int rows = 0; rows<boardp1.length;rows++){
				            System.out.println();
				            System.out.print(rows);
				            for(int cols = 0; cols<boardp1[0].length; cols++){ 
				            	System.out.print("\t"+boardp1[rows][cols]);}}
			        }
			            
			        if (sunkp1 == numships){ game = game + 1;
			        	if(size == 5){System.out.println("\tA \tB \tC \tD \tE");}
			        	if(size == 6){System.out.println("\tA \tB \tC \tD \tE \tF");}
			        	if(size == 7){System.out.println("\tA \tB \tC \tD \tE \tF \tG ");}
			        	if(size == 8){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH ");}
			        	if(size == 9){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI");}
			        	if(size == 10){System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI \tJ");}
			        	for(int rows = 0; rows<boardp1.length;rows++){
			        		System.out.println();
			        		System.out.print(rows);
			        		for(int cols = 0; cols<boardp1[0].length; cols++){ 
			        			System.out.print("\t"+boardp1[rows][cols]);}}
			        	
				        System.out.println("\nShots fired: "+firedp1+"\nShips sunk: "+sunkp1);
				        String conf;
				        System.out.println("\nThe game is over!Player 2 has won, congratulations!\n"+game+" Game played \nDo you want to play again? \nYes \nNo"); 
				        conf = input3.nextLine();
				        while(!conf.equalsIgnoreCase("yes") && !conf.equalsIgnoreCase("no")){
				        	System.out.println("Please introduce \"Yes\" or \"No\"");conf = input3.nextLine();}
				        if(conf.equalsIgnoreCase("yes")){
				        	gamerep = "yes";}
				        if(conf.equalsIgnoreCase("no")){
				        	gamerep = "no"; System.out.println("It was nice playing with you. Hope we can do it again soon!");}}
		        }
		        
		    }while(sunk<numships && sunkp1<numships);
		}while(gamerep.equalsIgnoreCase("yes"));
	}
	public static void main(String[] args) {
		battleship();
	}
}
