package hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="stock")
public class Stock {
     private int stockid;
     private String stockname;
     private String stockcode;
     private Set<StockTransaction> stockTransactions= new HashSet<>();
	
     @Id @Column(name="stockid")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     public int getStockid() {
		return stockid;
	}
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}
	
	@Column(name="stockname")
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	
	@Column(name="stockcode")
	public String getStockcode() {
		return stockcode;
	}
	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock", cascade=CascadeType.ALL)
	public Set<StockTransaction> getStockTransactions() {
		return stockTransactions;
	}
	public void setStockTransactions(Set<StockTransaction> stockTransactions) {
		this.stockTransactions = stockTransactions;
	}



}
