package test.com.semiproject.model;

import java.io.Serializable;

public class ARSVO implements Serializable {
	private String name;
	private String data;
	private String call;
	private String message;
	private int price;

	private String ser_name;
	private int ser_price;
	private String category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCall() {
		return call;
	}

	public void setCall(String call) {
		this.call = call;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSer_name() {
		return ser_name;
	}

	public void setSer_name(String ser_name) {
		this.ser_name = ser_name;
	}

	public int getSer_price() {
		return ser_price;
	}

	public void setSer_price(int ser_price) {
		this.ser_price = ser_price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((call == null) ? 0 : call.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + ((ser_name == null) ? 0 : ser_name.hashCode());
		result = prime * result + ser_price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ARSVO other = (ARSVO) obj;
		if (call == null) {
			if (other.call != null)
				return false;
		} else if (!call.equals(other.call))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (ser_name == null) {
			if (other.ser_name != null)
				return false;
		} else if (!ser_name.equals(other.ser_name))
			return false;
		if (ser_price != other.ser_price)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ARSVO [name=" + name + ", data=" + data + ", call=" + call + ", message=" + message + ", price=" + price
				+ ", ser_name=" + ser_name + ", ser_price=" + ser_price + ", category=" + category + "]";
	}

}
