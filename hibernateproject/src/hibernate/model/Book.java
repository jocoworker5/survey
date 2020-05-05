package hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="book")
public class Book {
    private Integer id;
    private String bookname;
    private String author;
    private BookDetail bookdetail;
	private int price;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="bookname")
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	@Column(name="author")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(name="price")
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL)
    public BookDetail getBookdetail() {
		return bookdetail;
	}
	public void setBookdetail(BookDetail bookdetail) {
		this.bookdetail = bookdetail;
	}

}
