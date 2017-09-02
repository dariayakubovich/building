package main.java.com.roxoft.buildingcompany.main.conpool;

public class Connection {
	private static int CountConnection;
	public Connection() {
		setCountConnection(getCountConnection() + 1);
	}

	private String url;
	private String user;
	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static int getCountConnection() {
		return CountConnection;
	}

	public static void setCountConnection(int countConnection) {
		CountConnection = countConnection;
	}


}
