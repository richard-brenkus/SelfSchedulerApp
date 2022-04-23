package com.richardbrenkus.AnotherWebApp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=2, max=45)
    private String name;
	@NotNull
	@Size(min=2, max=45)
	private String username;
//	@NotNull(message = "Email cannot be empty")
	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@Column(unique=true )
	private String email;
    @NotNull
	@Size(min=8, max=256)
	private String password;
 // @NotNull
    @NotEmpty//(message = "select Male or Female")
    private String gender;

    private String note;
    private boolean married;
    @Column(name = "creationDate")
    private LocalDateTime creationDate;
    @NotNull
    @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", message = "enter date in format dd/mm/yyyy, dd-mm-yyyy or dd.mm.yyyy")
    private String birthday;
    private String profession;
    
    private boolean enabled;
    
    @ManyToMany    
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            )        
    private Collection<Role> roles = new LinkedHashSet<>();
    
    
    public void setRoles(Set<Role> roles) {
    	this.roles = roles;
    }
    
    public Collection<Role> getRoles() {
    	return roles;
    }
   
    
    public User (String name, String password) {
    	this.name = name;
    	this.password = password;
    }
    
    public User() {
    	
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    
            
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	 public String getUsername() {
		 	return username;
		}
	 
	public void setUsername(String username) {
			this.username = username;
		}
		
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	
	public void setCreationDate(LocalDateTime creationDate) {
    	this.creationDate = creationDate;
    	
    }

  /*  
    @Override
    @ResponseBody
    public String toString() {
  	   	
    	String result ="";
    	
    	result = name.toString() + ", " + email.toString() + ", " + password.toString() + ", " + gender.toString() + ", " + note.toString() 
    				+ ", " + (married? "yes" : "no") + ", " + profession.toString();
    	    	
    	return result;
    	
    }
 */   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user) && 
                Objects.equals(email, user.email);
    }

   
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
    
    public boolean isEnabled() {
    	return enabled;
    }
    
    public void setEnabled(boolean enabled) {
    	this.enabled = enabled;
    }
    
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="request_id")
    private Request request_user;


	public Request getRequest_user() {
		return request_user;
	}

	public void setRequest_user(Request request_user) {
		this.request_user = request_user;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
    
    
 
}