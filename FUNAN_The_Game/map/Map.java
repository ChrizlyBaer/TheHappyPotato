import java.util.List;

public class Map {

	int height;
	int width;
	private String [] backgroundImagePaths;
	private String [] foregroundImagePaths;
	private List<Square> squares;
	
	public Map (int height, int width, String[] backgroundImagePaths, String[] foregroundImagePaths, List<Square> square){
		
		this.height = height;
		this.width = width;
		this.backgroundImagePaths = backgroundImagePaths;
		this.foregroundImagePaths = foregroundImagePaths;
		this.squares = square;

	}

	public List<Square> getSquares() {
		return squares;
	}
	
}
