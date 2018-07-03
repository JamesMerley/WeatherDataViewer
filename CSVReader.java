import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class CSVReader
{
	public static List<List<String>> CSVReader(String csvFileName) throws IOException
	{
		String line = null;
		BufferedReader stream = null;
		List<List<String>> csvData = new ArrayList<List<String>>();

		try
		{
			stream = new BufferedReader(new FileReader(csvFileName));
			while ((line = stream.readLine()) != null)
			{
				String[] splitted = line.split(",");
				List<String> dataLine = new ArrayList<String>(splitted.length);
				for (String data : splitted )
				{
					dataLine.add(data);
				}
				csvData.add(dataLine);
			}
		}
	
		finally
		{
			if(stream != null)
			{
				stream.close();
			}
		}
		return csvData;
	}

}
