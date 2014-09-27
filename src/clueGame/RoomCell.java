package clueGame;

public class RoomCell extends BoardCell {
	public enum DoorDirection {UP, DOWN, LEFT, RIGHT};
	private DoorDirection doorDirection;
	private char roomName;
	
	@Override
	public boolean isRoom(){
		return true;
	}
	
	public DoorDirection getDir(){
		return doorDirection;
	}
	
}
