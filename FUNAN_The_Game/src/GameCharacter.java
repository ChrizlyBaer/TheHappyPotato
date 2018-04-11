public abstract class GameCharacter {

	private int x;
	private int y;
	private int height;
	private int width;
	private String[] characterImages;
	private double maxSpeed;
	private int maxJumpWidht;
	private int maxJumpHeight;
	private int maxLife;
	private int currentLife;

	public GameCharacter(int x, int y, int height, int width, String[] characterImages, double maxSpeed,
			int maxJumpWidth, int maxJumpHeight, int maxLife, int currentLife) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.characterImages = characterImages;
		this.maxSpeed = maxSpeed;
		this.maxJumpHeight = maxJumpHeight;
		this.maxJumpWidht = maxJumpWidth;
		this.maxLife = maxLife;
		this.currentLife = currentLife;

	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public String[] getCharecterImages() {
		return characterImages;
	}

	public int getMaxLife() {
		return maxLife;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getMaxJumpWidht() {
		return maxJumpWidht;
	}

	public void setMaxJumpWidht(int maxJumpWidht) {
		this.maxJumpWidht = maxJumpWidht;
	}

	public int getMaxJumpHeight() {
		return maxJumpHeight;
	}

	public void setMaxJumpHeight(int maxJumpHeight) {
		this.maxJumpHeight = maxJumpHeight;
	}

	public int getCurrentLife() {
		return currentLife;
	}

	public void setCurrentLife(int currentLife) {
		this.currentLife = currentLife;
	}

}
