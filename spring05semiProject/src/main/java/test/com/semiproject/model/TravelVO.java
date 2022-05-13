package test.com.semiproject.model;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class TravelVO implements Serializable {
	private String attraction;
	private String location;
	private String content;
	private String tdate;
	private MultipartFile multipartFile;
	private String save_file_name;
	private String id;
	private String pw;
	private Date save_date;

	public String getAttraction() {
		return attraction;
	}

	public void setAttraction(String attraction) {
		this.attraction = attraction;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTdate() {
		return tdate;
	}

	public void setTdate(String tdate) {
		this.tdate = tdate;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public String getSave_file_name() {
		return save_file_name;
	}

	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}

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

	public Date getSave_date() {
		return save_date;
	}

	public void setSave_date(Date save_date) {
		this.save_date = save_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attraction == null) ? 0 : attraction.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((multipartFile == null) ? 0 : multipartFile.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((save_date == null) ? 0 : save_date.hashCode());
		result = prime * result + ((save_file_name == null) ? 0 : save_file_name.hashCode());
		result = prime * result + ((tdate == null) ? 0 : tdate.hashCode());
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
		TravelVO other = (TravelVO) obj;
		if (attraction == null) {
			if (other.attraction != null)
				return false;
		} else if (!attraction.equals(other.attraction))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (multipartFile == null) {
			if (other.multipartFile != null)
				return false;
		} else if (!multipartFile.equals(other.multipartFile))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		if (save_date == null) {
			if (other.save_date != null)
				return false;
		} else if (!save_date.equals(other.save_date))
			return false;
		if (save_file_name == null) {
			if (other.save_file_name != null)
				return false;
		} else if (!save_file_name.equals(other.save_file_name))
			return false;
		if (tdate == null) {
			if (other.tdate != null)
				return false;
		} else if (!tdate.equals(other.tdate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TravelVO [attraction=" + attraction + ", location=" + location + ", content=" + content + ", tdate="
				+ tdate + ", multipartFile=" + multipartFile + ", save_file_name=" + save_file_name + ", id=" + id
				+ ", pw=" + pw + ", save_date=" + save_date + "]";
	}

}
