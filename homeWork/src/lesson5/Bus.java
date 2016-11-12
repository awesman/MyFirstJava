package lesson5;


public class Bus {
	
	
	private String driverName;
	private int busNumber;
	private int routeNumber;
	private String mark;
	private int firstYear;
	private int run;

	
	
	
	public Bus(String driverName,int busNumber,int routeNumber,String mark,int firstYear,int run){
		this.driverName=driverName;
		this.busNumber=busNumber;
		this.routeNumber=routeNumber;
		this.mark=mark;
		this.firstYear=firstYear;
		this.run=run;
		
	}
	
	
	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public int getBusNumber() {
		return busNumber;
	}

   
	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}


	public int getRouteNumber() {
		return routeNumber;
	}


	public void setRouteNumber(int routeNumber) {
		this.routeNumber = routeNumber;
	}


	public String getMark() {
		return mark;
	}


	public void setMark(String mark) {
		this.mark = mark;
	}


	public int getFirstYear() {
		return firstYear;
	}


	public void setFirstYear(int firstYear) {
		this.firstYear = firstYear;
	}


	public int getRun() {
		return run;
	}


	public void setRun(int run) {
		this.run = run;
	}


	@Override
	public String toString() {
		return "Имя водителя:" + driverName + ", Номер автобуса "
				+ busNumber + ", Номер маршрута " + routeNumber
				+ ", Марка автобуса " + mark + ", Год ввода в эксплуатацию " + firstYear
				+ ", Пробег " + run+" тыс. км.";
	}
   }
