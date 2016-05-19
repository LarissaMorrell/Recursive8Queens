
public class SpaceNode {
	
	private boolean space;
	
	public SpaceNode(){
		
		// Spaces are instantiated to false for
		// not yet containing a queen
		space = false;
	}
	
	public void setSpace(boolean space){
		this.space = space;
	}
	
	public boolean getSpace(){
		return space;
	}
	
	public String toString(){
		String str = "";
		
		if(space == false){
			str = " o ";
		} else {
			str = "*Q*";
		}
		
		return str;
	}

}
