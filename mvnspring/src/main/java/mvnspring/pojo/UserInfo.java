package mvnspring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity	
@Table(name="emp_login")
@NamedQueries({
	@NamedQuery(name="authenticateUser",query="select objUser from UserInfo objUser where objUser.userName=?1 and objUser.password=?2")
})
public class UserInfo {

@Id
@Column(name="userName")
String userName;
@Column(name="password")
String password;

public String getUserName() {
	return userName;
}
public void setUserName(String username) {
	this.userName = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
