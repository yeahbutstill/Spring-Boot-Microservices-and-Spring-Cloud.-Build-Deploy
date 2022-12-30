package com.yeahbutstill.photoapp.api.users.data;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="users")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserEntity implements Serializable {
 
	@Serial
	private static final long serialVersionUID = -2731425678149216053L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false, length=50)
	private String firstName;
	
	@Column(nullable=false, length=50)
	private String lastName;
	
	@Column(nullable=false, length=120, unique=true)
	private String email;
	
	@Column(nullable=false, unique=true)
	private String userId;
	
	@Column(nullable=false, unique=true)	
	private String encryptedPassword;

}
