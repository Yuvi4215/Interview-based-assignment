package in.ineuron.DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "new_products")
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serialNo;
	private String pName;
	private int pRate;
	private int pQty;

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpRate() {
		return pRate;
	}

	public void setpRate(int pRate) {
		this.pRate = pRate;
	}

	public int getpQty() {
		return pQty;
	}

	public void setpQty(int pQty) {
		this.pQty = pQty;
	}

	@Override
	public String toString() {
		return "Product [serial Number=" + serialNo + ", Product Name=" + pName + ", Product Rate=" + pRate
				+ ", Product Qty=" + pQty + "]";
	}
}
