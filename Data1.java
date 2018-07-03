public class Data1
{
  private String year;
  private String month;
  private String tMax;
  private String tMin;
  private String airFrostDays;
  private String rain;

  public Data1(String year, String month, String tMax, String tMin, String airFrostDays, String rain)
  {
    this.year = year;
    this.month = month;
    this.tMax = tMax;
    this.tMin = tMin;
    this.airFrostDays = airFrostDays;
    this.rain = rain;
  }

  public void setYear(String year)
  {
    this.year = year;
  }

  public void setMonth(String month)
  {
    this.month = month;
  }

  public void setTMax(String tMax)
  {
    this.tMax = tMax;
  }

  public void setTMin(String tMin)
  {
    this.tMin = tMin;
  }

  public void setAirFrostDays(String airFrostDays)
  {
    this.airFrostDays = airFrostDays;
  }

  public void setRain(String rain)
  {
    this.rain = rain;
  }

  public String getYear()
  {
    return year;
  }

  public String getMonth()
  {
    return month;
  }

  public String getTMax()
  {
    return tMax;
  }

  public String getTMin()
  {
    return tMin;
  }

  public String getAirFrostDays()
  {
    return airFrostDays;
  }

  public String getRain()
  {
    return rain;
  }
}
