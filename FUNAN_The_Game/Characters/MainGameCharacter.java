import gameCharacterEnums.GameCharacterStatus;

public class MainGameCharacter extends GameCharacter {

	private GameCharacterStatus status;

	public MainGameCharacter(int x, int y, int height, int width, String[] characterImages, double maxSpeed,
			int maxJumpWidth, int maxJumpHeight, int maxLife, int currentLife, GameCharacterStatus status) {

		super(x, y, height, width, characterImages, maxSpeed, maxJumpWidth, maxJumpHeight, maxLife, currentLife);
		this.status = status;
	}
	
	
	public GameCharacterStatus getStatus() {
		return status;
	}

	public void setStatus(GameCharacterStatus status) {
		this.status = status;
	}
}
