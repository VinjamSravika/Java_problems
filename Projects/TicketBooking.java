package practice;
abstract class Movie{
	int movieId;
	String title;
	double ticketPrice;
	int nooftickets;
	Movie(int movieId,String title,double ticketPrice,int nooftickets){
		this.movieId=movieId;
		this.title=title;
		this.ticketPrice=ticketPrice;
		this.nooftickets=nooftickets;
		
	}
	abstract void caluculatePrice();
	public void displayDetails() {
		System.out.println("ID"+" "+movieId);
		System.out.println("titale"+" "+title);
		System.out.println("ticketprice"+" "+ticketPrice);
		System.out.println("nooftickets"+" "+nooftickets);
	}
	
}
class TeluguMovie extends Movie{
	double totalcost;
	double discount;
	 TeluguMovie(int movieId,String title,double ticketPrice,int nooftickets){
		 super( movieId, title,ticketPrice,nooftickets);
	 }
	 public void caluculatePrice(){
		 double basecost=ticketPrice*nooftickets;
		 discount=basecost*0.10;
		 double GST = (basecost - discount) * 0.05; 
		 totalcost = basecost - discount + GST;
	 }
	public void  displayDetails(){
		super.displayDetails();
		System.out.println("total price "+" "+totalcost);
		 
	 } 
}
class HindiMovie extends Movie{
	double discount;
	double totalcost;

	HindiMovie(int movieId,String title,double ticketPrice,int nooftickets){
		super(movieId, title,ticketPrice,nooftickets);
	}
	public void caluculatePrice() {
		double basecost=(ticketPrice*nooftickets);
		discount=basecost*0.10;
		double GST=(basecost-discount)*0.05;
		totalcost=basecost-discount+GST;
	}
	public void  displayDetails(){
		super.displayDetails();
		System.out.println("total price "+" "+totalcost);
		 
	 } 	
}
class EnglishMovie extends Movie{
	double discount;
	double totalcost;
	double Dcharge;
	boolean isPossible=true;
	EnglishMovie(int movieId,String title,double ticketPrice,int nooftickets){
		super(movieId, title,ticketPrice,nooftickets);
		Dcharge=50;
	}
	public void caluculatePrice() {
		if(nooftickets>6) {
			System.out.println("cannot book more than 6 tickets");
	    	isPossible=false;
	    	return ;
		}
		double basecost=(ticketPrice*nooftickets);
		discount=basecost*0.10;
		double GST=(basecost-discount)*0.05;
		totalcost=basecost-discount+GST;
	}
	public void  displayDetails(){
		if(!isPossible) return ;
		super.displayDetails();
		System.out.println("no.of tickets "+" "+nooftickets);
		System.out.println("total cost "+" "+totalcost);
		 
	 } 	
}
public class TicketBooking {

	public static void main(String[] args) {
		TeluguMovie obj=new TeluguMovie(101,"RRR",150,3);
		obj.caluculatePrice();
		obj.displayDetails();
		HindiMovie obj2=new HindiMovie(103,"pathaan",200,2);
		obj2.caluculatePrice();
		obj2.displayDetails();
		EnglishMovie obj3=new EnglishMovie(102,"avatat",250,7);
		obj3.caluculatePrice();
		obj3.displayDetails();

	}

}


