

class Movie {
	 public static final int CHILDRENS = 2;
	 public static final int REGULAR = 0;
	 public static final int NEW_RELEASE = 1;
	 
	 private String _title;
	 private int _priceCode;
	 
	 public Movie(String title, int priceCode) {
	 _title = title;
	 _priceCode = priceCode;
	 }

	 public int getPriceCode() {
	 return _priceCode;
	 }
	 public void setPrice(int arg) {
	 _priceCode = arg;
	 }
	 public String getTitle() {
	 return _title;
	 }
}
public class Retnal {
	 private Movie _movie;
	 private int _daysRented;
	 
	 public Rental(Movie movie, int daysRented) {
	 _movie = movie;
	 _daysRented = daysRented;
	 }
	 
	 public int getDaysRented() {
	 return _daysRented;
	 }
	 
	 public Movie getMovie() {
	 return _movie;
	 }
}

public class Customer {
	 private String _name;
	 private Vector _rentals = new Vector();
	 
	 public Customer(String name) {
		 _name = name;
	 }
	 
	 public void addRental(Rental arg) {
		 _rentals.addElement(arg);
	 }
	 
	 public String getName() {
		 return _name;
	 }
	 
	 public String statement() {
		 
		 RenterPoints frequentRenterPoints = new RenterPoints();
		 Amount totalAmount=new Amount();
		 
	
		Enumeration rentals = _rentals.elements();
		 String result = getName() + " 고객님의 대여 기록\n";
		 
		 while(rentals.hasMoreElements()) {
			 double thisAmount = 0;
			 Rental each = (Rental) rentals.nextElement();
			 
			 
			 // 비디오 종류별 대여료 계산
			 switch (each.getMovie().getPriceCode()) {
				 case Movie.REGULAR:
					 thisAmount += 2;
					 if (each.getDaysRented() > 2)
					 thisAmount += (each.getDaysRented() -= 2) * 1.5;
					 break;
				 case Movie.NEW_RELEASE:
					 thisAmount += each.getDaysRented() * 3;
					 break;
				 case Movie.CHILDRENS:
					 thisAmount += 1.5;
					 if (each.getDaysRented() > 3)
					 thisAmount += (each.getDaysRented() - 3) * 1.5;
					 break;
		 }
			 
		 // 적립 포인트를 1 포인트 증가
		 //frequentRenterPoints++;
			 frequentRenterPoints.addfrequentRenterPoints();
		 
		 // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
//		 if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
//		 each.getDaysRented() > 1) frequentRenterPoints++;
			 frequentRenterPoints.vonusRentalPoints(each);
		 
		 
		 // 이번에 대여하는 비디오 정보와 대여료를 출력
		 result += " \t" + each.getMovie().getTitle() + " \t" +
		 String.valueOf(thisAmount) + " \n";
		 
		 
		 // 현재까지 누적된 총 대여료
		 totalAmount.setAmount(totalAmount.getAmount()+ thisAmount); 
		 }
		 
		 // 푸터 행 추가
		 result += "누적 대여료: " + String.valueOf(totalAmount.getAmount()) + " \n";
		 result += "적립 포인트: " + String.valueOf(frequentRenterPoints.getRenterPoints ());
		 
		 return result;
		} 
}

class RenterPoints {
	
	private int _frequentRenterPoints;
	
	RenterPoints (){
		_frequentRenterPoints=0;
	}
	
	int getRenterPoints () {
		return _frequentRenterPoints;
	}
	void addfrequentRenterPoints() {
		_frequentRenterPoints+=1;
	}
	int vonusRentalPoints(Rental each) {
		
		 if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
				 each.getDaysRented() > 1) _frequentRenterPoints++;
	}
	
}
class Amount{
	private double _totalAmount;
	
	Amount(){
		_totalAmount = 0;
	}
	double getAmount() {
		return _totalAmount;
	}
	void setAmount(double amount) {
		 _totalAmount=amount;
	}
}
