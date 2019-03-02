package mygame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import commons.Action;
import commons.Field;
import commons.Level;
import commons.Position;
import commons.Utils;

public class MyGame {
	
	Level level;
	Field field = new Field();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			MyGame myGame = new MyGame();
			init();
			Player character = myGame.buildCharacter(scanner);
			myGame.start(scanner);
			printGameInstructions();
			myGame.begin(scanner,character);
			
		}finally {
			scanner.close();
		}
		
	}
	
	/**
	 * Method used to prompt user with initial introduction
	 */
	public static void init() {
		System.out.println("Hello Player....Welcome to the game world");
		System.out.println("We want you to start with your character");
		System.out.println("Please enter the gender of the character M/F:");
	}
	
	/**
	 * This method is used to build the character
	 * @param scanner
	 * @return
	 */
	public Player buildCharacter(Scanner scanner) {
		 	
		 	Player character = new Player();
			
			char gender = scanner.next().charAt(0);
			while(gender != 'M' && gender != 'F' ) {
				System.out.println("Please enter right gender");
				gender = scanner.next().charAt(0);
			}
			scanner = new Scanner(System.in);
			System.out.println("Please enter the name of the character:");
			String name = scanner.nextLine();
			while(name == null || name.equals("") || name.trim().length()<4) {
				System.out.println("Name of the character cannot be empty or less than 4 characters\n");
				System.out.println("Please enter name greater than 4 characters");
				name = scanner.nextLine();
				
			}
			
			System.out.println("Welcome " + name);
			buildLevel(scanner);
			character.setName(name);
			character.setGender(gender+"");
			character.build();
			return character;
	 }
	
	public void buildLevel(Scanner scanner) {
		scanner = new Scanner(System.in);
		System.out.println("Please choose the game level B(beginner), M(Medium), H(hard):");
		String hardness = scanner.nextLine();
		while(!Arrays.asList(new String[]{"B","M","H"}).contains(hardness) ) {
			System.out.println("Please enter valid Level");
			hardness = scanner.nextLine();
		}
		Level level = Utils.convertInputLevelToEnum(hardness);
		System.out.println(level.toString());
		this.setLevel(level);
		field.setWidth(level.getFieldWidth());
		field.setHeight(level.getFieldHeight());
		field.setWalls(level.buildWalls());
		field.setRocks(level.buildRocks());
		Player player = new Player();
		player.setPosition(new Position(0,level.getFieldHeight()/2));
		field.setPlayer(player);
		
	}
	 
	/**
	 * This method is used to print game instructions
	 */
	 public static void printGameInstructions() {
		 	System.out.println("Your game Stated..Your opponent is computer...Please see below instructions");
			System.out.println("Press arrows to move in directions");
			System.out.println("Press J to Jump");
			System.out.println("Press K to Kick a punch");
			System.out.println("Press L to Move Left");
			System.out.println("Press R to Move Right");
			System.out.println("Press U to Move Up");
			System.out.println("Press D to Move down");
			System.out.println("Press F to Move forward");
			System.out.println("Press B to Move backward");
			System.out.println("Press E to Explore.Note when you are exploring opponent(s)/enemy() will be in stand still.");
	 }
	 
	 /**
	  * This method takes user prompt for the start or end of the game.
	  * @param scanner
	  */
	 public void start(Scanner scanner) {
		 	System.out.println("To start the game press Y. Press any Key to quit");
			scanner = new Scanner(System.in);
			if(scanner.next().charAt(0) != 'Y') {
				System.exit(0);
			}
	 }
	 
	 /**
	  * This method takes user prompt for the start or end of the game.
	  * @param scanner
	  */
	 public void begin(Scanner scanner,Player role) {
		 	role.setDifficulty(getLevel());
			//Thread player = new Thread(role);
			Computer computer = new Computer();
			computer.setPosition(new Position(level.getFieldWidth()-1,level.getFieldHeight()/2));
			//this list is maintained to extMend the functionality so that we can increase the computer opponents in future
			List<Computer> systemPlayers =new ArrayList<>();
			systemPlayers.add(computer);
			//Thread systemPlayer = new Thread(computer);
			role.setField(field);
			computer.setField(field);
			computer.setName("1");
			field.setSystemPlayers(systemPlayers);
			role.setField(field);
			computer.setField(field);
			while(true) {
					role.setActed(false);
					role.act();
					computer.setActed(false);
					computer.act();
			}
			/*while(true) {
				System.out.println("Enter your action");
				scanner = new Scanner(System.in);
				String strAction = scanner.nextLine();

				if(!Arrays.asList(new String[]{"J","K","L","R","U","D","F","B","E"}).contains(strAction) ) {
					continue;
				}else {
					Action action = Utils.convertInputActionToEnum(strAction);
					if(isFruitfulAction(action, role)) {
						field.setPlayer(role);
						role.setAction(action);
						role.setActed(true);
						field.printLayOut();
					}
					if(!action.equals(Action.E)) {
					Action computerAction =	computer.generateRandomAtion();
						if(isFruitfulAction(computerAction, computer)) {
							field.setSystemPlayers(systemPlayers);
							computer.setAction(computerAction);
							computer.setActed(true);
							systemPlayers.add(computer);
							field.printLayOut();
						}
					}else {
						System.out.println("System player(s) are in standstill mode as user is exploring");
					}
				}
			}*/
	 }

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	public boolean isFruitfulAction(Action action,Role role) {
		Position nextposition = Utils.nextPosition(action, role.getPosition());
		if(field.isPositionValid(nextposition)) {
			role.setPosition(nextposition);
			return true;
		}
		return false;
	}
	 
	 
}
