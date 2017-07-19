package czxy.aiuke.entity;

public class aiuke {
	private String id;
	private String singname;
	private String singer;
	private String addr;
	private String beizhu;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSingname() {
		return singname;
	}
	public void setSingname(String singname) {
		this.singname = singname;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	@Override
	public String toString() {
		return "aiuke [id=" + id + ", singname=" + singname + ", singer="
				+ singer + ", addr=" + addr + ", beizhu=" + beizhu + "]";
	}
	
}
