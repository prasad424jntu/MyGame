package commons;

public enum Action {
	L("l","Left"),
	R("r","Right"),
	U("u","Up"),
	D("d","Down"),
	F("f","Front"),
	B("b","Back"),
	J("j","Jump"),
	K("k","Kick"),
	E("e","Explore");
	
	Action(String action, String description){
		this.action = action;
		this.description = description;
	}
	
	private String action;
	private String description;
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
