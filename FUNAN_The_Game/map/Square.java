
public class Square {
	
	private String imgPath;
	private Position position;
	private int size;
	
	public Square(String imgPath, Position position, int size)
	{
		this.imgPath = imgPath;
		this.position = position;
		this.size = size;
	}

	public String getImgPath() {
		return imgPath;
	}

	public Position getPosition() {
		return position;
	}

	public int getSize() {
		return size;
	}
	
	

}
