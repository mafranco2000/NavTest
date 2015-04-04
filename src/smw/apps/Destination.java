package smw.apps;

public class Destination {
	private String name;
	private int code;
	
	public Destination(String name, int code){
		this.name = name;
		this.code = code;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCode(){
		return code;
	}
	
	public String toString(){
		return this.name;
	}

}
