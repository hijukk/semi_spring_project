package test.com.semiproject.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class ReviewVO {
	private int rn;
	private int rnum;
	private String rtitle;
	private String rcontent;
	private String rwriter;
	private Date rdate;
	private String rsave_file_name;
	private MultipartFile multipartFile;

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getRtitle() {
		return rtitle;
	}

	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRwriter() {
		return rwriter;
	}

	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public String getRsave_file_name() {
		return rsave_file_name;
	}

	public void setRsave_file_name(String rsave_file_name) {
		this.rsave_file_name = rsave_file_name;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((multipartFile == null) ? 0 : multipartFile.hashCode());
		result = prime * result + ((rcontent == null) ? 0 : rcontent.hashCode());
		result = prime * result + ((rdate == null) ? 0 : rdate.hashCode());
		result = prime * result + rn;
		result = prime * result + rnum;
		result = prime * result + ((rsave_file_name == null) ? 0 : rsave_file_name.hashCode());
		result = prime * result + ((rtitle == null) ? 0 : rtitle.hashCode());
		result = prime * result + ((rwriter == null) ? 0 : rwriter.hashCode());
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
		ReviewVO other = (ReviewVO) obj;
		if (multipartFile == null) {
			if (other.multipartFile != null)
				return false;
		} else if (!multipartFile.equals(other.multipartFile))
			return false;
		if (rcontent == null) {
			if (other.rcontent != null)
				return false;
		} else if (!rcontent.equals(other.rcontent))
			return false;
		if (rdate == null) {
			if (other.rdate != null)
				return false;
		} else if (!rdate.equals(other.rdate))
			return false;
		if (rn != other.rn)
			return false;
		if (rnum != other.rnum)
			return false;
		if (rsave_file_name == null) {
			if (other.rsave_file_name != null)
				return false;
		} else if (!rsave_file_name.equals(other.rsave_file_name))
			return false;
		if (rtitle == null) {
			if (other.rtitle != null)
				return false;
		} else if (!rtitle.equals(other.rtitle))
			return false;
		if (rwriter == null) {
			if (other.rwriter != null)
				return false;
		} else if (!rwriter.equals(other.rwriter))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReviewVO [rn=" + rn + ", rnum=" + rnum + ", rtitle=" + rtitle + ", rcontent=" + rcontent + ", rwriter="
				+ rwriter + ", rdate=" + rdate + ", rsave_file_name=" + rsave_file_name + ", multipartFile="
				+ multipartFile + "]";
	}

}
