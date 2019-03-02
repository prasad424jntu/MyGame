package mygame;

import java.util.ArrayList;
import java.util.List;

import commons.Action;
import commons.Field;
import commons.Level;
import commons.Position;
import commons.Utils;
import commons.Weapon;
import skills.Skill;

public class Role{
	
	String name;
	String gender;
	Level difficulty;
	List<Skill> skills = new ArrayList<Skill>();
	List<Weapon> weapons = new ArrayList<Weapon>();
	boolean acted= false;
	Action action = Action.J;
	Position position;
	Field field;
	
	public Role() {
		position = new Position();
	}
	
	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public Level getDifficult() {
		return difficulty;
	}




	public void setDifficult(Level difficult) {
		this.difficulty = difficult;
	}




	public List<Skill> getSkills() {
		return skills;
	}




	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}




	public List<Weapon> getWeapons() {
		return weapons;
	}




	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}




	public Level getDifficulty() {
		return difficulty;
	}




	public void setDifficulty(Level difficulty) {
		this.difficulty = difficulty;
	}




	public boolean isActed() {
		return acted;
	}




	public void setActed(boolean acted) {
		this.acted = acted;
	}




	public Action getAction() {
		return action;
	}




	public void setAction(Action action) {
		this.action = action;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}


	public Role build(){
		Role character = new Role();
		character.name = this.name;
		character.gender = this.gender;
		character.difficulty = this.difficulty;
		character.skills = this.skills;
		character.weapons = this.weapons;
		return character;
		
	}
	
	public void setPosition(Action action) {
		
	switch (action) {
		case L:
			
			break;
		case R:
			
			break;
		case U:
			
			break;
		case D:
			
			break;
		case F:
			
			break;
		case B:
			
			break;
		case J:
			
			break;
		case K:
			
			break;
		default:
			break;
		}
		
	}


	public Field getField() {
		return field;
	}


	public void setField(Field field) {
		this.field = field;
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
