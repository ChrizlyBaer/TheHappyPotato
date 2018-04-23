import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class MapReader {

	public List<Square> importXlsxMap(String filePath) {
		
		List<Square> returnSquares = new ArrayList<Square>();
		int squareSize = (int)WindowService.getWindowHeight() / 12;
	
		
		try {
			File excel = new File(filePath);
			FileInputStream fis = new FileInputStream(excel);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheetAt(0);

			Iterator<Row> itr = sheet.iterator();
			// Iterating over Excel file in Java
			while (itr.hasNext()) {
				Row row = itr.next();
				// Iterating over each column of Excel file
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					//short color = cell.getCellStyle().getFillBackgroundColor();
					//System.out.println(String.valueOf(cell.getColumnIndex()) + " " + String.valueOf(cell.getRowIndex()));
					returnSquares.add(new Square("Images\\ground_01.png", new Position(cell.getRowIndex(), cell.getColumnIndex()), squareSize));
				}
			}
			
			
			book.close();
			fis.close();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return returnSquares;
	}

}
