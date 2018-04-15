import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class MapReader {

	public  void importXlsxMap(String filePath) {
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
					short color = cell.getCellStyle().getFillBackgroundColor();
					System.out.println(color + " " + String.valueOf(cell.getColumnIndex()) + " " + String.valueOf(cell.getRowIndex()));
				}
			}
			
		book.close();

		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}

	}

}
