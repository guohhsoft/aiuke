package czxy.aiuke.entity;

public class pinglun {
	private String id;
	private String username;
	private String time;
	private String message;
	private String addr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "pinglun [id=" + id + ", username=" + username + ", time="
				+ time + ", message=" + message + ", addr=" + addr + "]";
	}
	
}
