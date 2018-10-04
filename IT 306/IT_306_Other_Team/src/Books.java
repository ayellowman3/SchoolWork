public class Books extends Item{
	String title;
	String author;
	String genre;

	public Books(){

	}

	public Books(double cost, int quantity, int sold, String title, String author, String genre){
		super(cost, quantity, sold);
		this.title = title;
		this.author = author;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Books [title=" + title + ", author=" + author + ", genre=" + genre + super.toString() + "]";
	}
	
	
}