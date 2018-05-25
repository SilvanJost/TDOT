package server.net;

public class InputHandler {

	private boolean upKeyPressed = false;
	private boolean leftKeyPressed = false;
	private boolean rightKeyPressed = false;
	
	private boolean punchKeyPressed = false;
	private boolean throwKeyPressed = false;
	private boolean specialKeyPressed = false;
	
	//set key pressed status
	public void pressKeyUp(boolean isPressed){
		this.upKeyPressed = isPressed;
	}
	public void pressKeyLeft(boolean isPressed){
		this.leftKeyPressed = isPressed;
	}
	public void pressKeyRight(boolean isPressed){
		this.rightKeyPressed = isPressed;
	}
	
	public void pressKeyPunch(boolean isPressed){
		this.punchKeyPressed = isPressed;
	}
	public void pressKeyThrow(boolean isPressed){
		this.throwKeyPressed = isPressed;
	}
	public void pressKeySpecial(boolean isPressed){
		this.specialKeyPressed = isPressed;
	}
	
	//get key pressed status
	public boolean isUpPressed() {
		return upKeyPressed;
	}
	
	public boolean isLeftPressed() {
		return leftKeyPressed;
	}
	
	public boolean isRightPressed() {
		return rightKeyPressed;
	}
	
	public boolean isPunchPressed() {
		return punchKeyPressed;
	}
	
	public boolean isThrowPressed() {
		return throwKeyPressed;
	}
	
	public boolean isSpecialPressed() {
		return specialKeyPressed;
	}
	
	public void setUpPressed(boolean flag){
		this.upKeyPressed = flag;
	}
	
	public void setPunchPressed(boolean flag){
		this.punchKeyPressed = flag;
	}
}
