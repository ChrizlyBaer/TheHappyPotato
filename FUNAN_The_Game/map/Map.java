public class Map {

	int height;
	int width;
	private String [] backgroundImagePaths;
	private String [] foregroundImagePaths;
	private Square [][] square;
	
	public Map (int height, int width, String[] backgroundImagePaths, String[] foregroundImagePaths, Square[][] square){
		
		this.height = height;
		this.width = width;
		this.backgroundImagePaths = backgroundImagePaths;
		this.foregroundImagePaths = foregroundImagePaths;
		this.square = square;
		
		 
		
	}
	
}
