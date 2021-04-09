package Num1;

import java.util.*;

class Location{
	private String city;
	private double longitude,latitude;
	
	Location(String city,double longitude, double latitude){
		this.city=city;
		this.longitude=longitude;
		this.latitude=latitude;
	}
	public void printLocation() {
		System.out.println(city+"\t"+longitude+"\t"+latitude);
	}
}

class LocationManager{
	Scanner scanner=new Scanner(System.in);
	HashMap <String,Location> h = new HashMap<String,Location>();
	
	public void read() {
		System.out.println("도시,경도,위도를 입력하세요.");
		
		for(int i=0;i<4;i++) {
			System.out.println(">>");
			
			String text=scanner.nextLine();
			StringTokenizer st=new StringTokenizer(text,",");
			
			String city=st.nextToken().trim();
			Double longitude=Double.parseDouble(st.nextToken().trim());
			Double latitude=Double.parseDouble(st.nextToken().trim());
			
			Location L=new Location(city,longitude,latitude);
			h.put(city, L);
		}
	}
	public void Print() {
		Set<String>keys=h.keySet();
		Iterator<String> iterator=keys.iterator();
		
		System.out.println("-----------------------");
		
		while(iterator.hasNext()) {
			String city=iterator.next();
			Location loc=h.get(city);
			loc.printLocation();
		}
		
		System.out.println("-----------------------");
	}
	
	public void findLocation() {
		
		while(true) {
			System.out.print("도시이름>>");
			String city=scanner.nextLine();
			
			if(city.contentEquals("그만"))
				return;
			
			Location loc=h.get(city);
			if(loc==null)
				System.out.println(city+"는 없습니다.");
			else 
				loc.printLocation();
		}
	}
}

public class JC18012628E1 {
	public static void main(String[] args) {
		LocationManager man = new LocationManager();
		
		man.read();
		man.Print();
		man.findLocation();
		
	}

}
