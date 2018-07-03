import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.lang.Double;

public class TableInfo
{
  public static ArrayList<Double> getInfo(String fileName) throws IOException
  {
    double totalRain = 0;
    double maxTemp = 0;
    double minTemp = 100;
    double airFrost = 0;
    ArrayList<Double> info = new ArrayList();
    List<List<String>> data;
    try
    {
      data = CSVReader.CSVReader(fileName);
      for (List<String> list : data )
      {
        if (Double.parseDouble(list.get(0)) == 2017)
        {
          totalRain += Double.parseDouble(list.get(5));
          airFrost += Double.parseDouble(list.get(4));

          if (Double.parseDouble(list.get(2)) > maxTemp)
          {
            maxTemp = Double.parseDouble(list.get(2));
          }

          if (Double.parseDouble(list.get(3)) < minTemp)
          {
            minTemp = Double.parseDouble(list.get(3));
          }
        }
      }
      info.add(maxTemp);
      info.add(minTemp);
      info.add(airFrost);
      info.add(totalRain);

    }
    catch (IOException e)
    {
      System.out.println("File not found");
    }

    return info;

  }

  public static ArrayList<String> getReportInfo(String fileName) throws IOException
  {
    String highest = "";
    String lowest = "";
    double highestNum = 0;
    double lowestNum = 100;
    double averageAF = 0;
    double averageRainfall = 0;
    double counter = 0;
    double rainfall = 0;
    double frost = 0;

    ArrayList<String> info = new ArrayList();
    List<List<String>> data;

    try
    {
      data = CSVReader.CSVReader(fileName);

      for (List<String> list : data)
      {
        rainfall += Double.parseDouble(list.get(5));
        frost += Double.parseDouble(list.get(4));
        counter += 1;
        if (Double.parseDouble(list.get(2)) > highestNum)
        {
          highestNum = Double.parseDouble(list.get(2));
          highest = list.get(1) + "/" + list.get(0);
        }
        if (Double.parseDouble(list.get(3)) < lowestNum)
        {
          lowestNum = Double.parseDouble(list.get(3));
          lowest = list.get(1) + "/" + list.get(0);
        }

      }
      averageRainfall = rainfall / (counter/12);
      averageAF = frost / (counter/12);

      info.add(highest);
      info.add(lowest);
      info.add(Double.toString(averageAF));
      info.add(Double.toString(averageRainfall));


    }
    catch (IOException e)
    {
      System.out.println("File not found");
    }
    return info;
  }
}
