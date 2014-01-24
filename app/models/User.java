package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class User extends Model{

	@Id
	private Long id;
	
	@Required
	private String fullName;
	@Required
	private String company;
	@Email
	private String email;
	@Required
	private String password;

	private static Finder<Long,User> find = new Finder(Long.class, User.class);
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public static List<User> all() {
		return find.all();
	}
	
	public static User get(Long id) {
		User user = User.find.byId(id);
		return user;
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
	
	public static void save(User user) {
		user.save();
	}

	public static void update(User user) {
		user.update();
	}

	
}
