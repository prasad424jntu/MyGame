package mygame;

import java.util.Arrays;
import java.util.Scanner;

import commons.Action;
import commons.Position;
import commons.Utils;

public class Player extends Role{

	
	public void act() {
		while(true) {
				if(!isActed()) {
					
					System.out.println("Enter your action");
					Scanner scanner = new Scanner(System.in);
					String strAction = scanner.nextLine();

					if(!Arrays.asList(new String[]{"J","K","L","R","U","D","F","B","E"}).contains(strAction) ) {
						continue;
					}else {
						Action action = Utils.convertInputActionToEnum(strAction);
						if(isFruitfulAction(action, field.getPlayer())) {
							System.out.println("Player Moved");
							///field.setPlayer(this);
							this.setAction(action);
							this.setActed(true);
							field.printLayOut();
							//If Action is explore only Player will be moving.
							if(action.equals(Action.E)) {
								this.setActed(false);
								continue;
							}
							break;
						}else {
							continue;
						}
					}
				}
		}
		
	}
	
	public String printImage() {
		return "@";
	}
	
	public Position getPlayerPosition(Action action){
		return null;
	}
	
}
