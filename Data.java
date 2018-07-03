public class Data
{
  private String station;
  private double tMax;
  private double tMin;
  private int airFrostDays;
  private double rain;

  public Data(String station, double tMax, double tMin, int airFrostDays, double rain)
  {
    this.station = station;
    this.tMax = tMax;
    this.tMin = tMin;
    this.airFrostDays = airFrostDays;
    this.rain = rain;
  }

  public void setStation(String station)
  {
    this.station = station;
  }

  public void setTMax(double tMax)
  {
    this.tMax = tMax;
  }

  public void setTMin(double tMin)
  {
    this.tMin = tMin;
  }

  public void setAirFrostDays(int airFrostDays)
  {
    this.airFrostDays = airFrostDays;
  }

  public void setRain(double rain)
  {
    this.rain = rain;
  }

  public String getStation()
  {
    return station;
  }

  public double getTMax()
  {
    return tMax;
  }

  public double getTMin()
  {
    return tMin;
  }

  public int getAirFrostDays()
  {
    return airFrostDays;
  }

  public double getRain()
  {
    return rain;
  }
}
