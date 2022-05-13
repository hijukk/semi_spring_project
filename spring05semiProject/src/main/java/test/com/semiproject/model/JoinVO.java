package test.com.semiproject.model;

import java.io.Serializable;
import java.util.Objects;

public class JoinVO implements Serializable{
	private String id;
	private String pw;
	private String name;
	private String jdate;
	private String gender;
	private String tel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJdate() {
		return jdate;
	}

	public void setJdate(String jdate) {
		this.jdate = jdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gender, id, jdate, name, pw, tel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JoinVO other = (JoinVO) obj;
		return Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(jdate, other.jdate) && Objects.equals(name, other.name)
				&& Objects.equals(pw, other.pw) && Objects.equals(tel, other.tel);
	}

	@Override
	public String toString() {
		return "JoinVO [id=" + id + ", pw=" + pw + ", name=" + name + ", jdate=" + jdate + ", gender=" + gender
				+ ", tel=" + tel + "]";
	}

}
