package com.vacation.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * The persistent class for the act_id_user database table.
 * 
 */
@Entity
@Table(name="act_id_user")
@NamedQuery(name="ActIdUser.findAll", query="SELECT a FROM ActIdUser a")
public class ActIdUser extends BaseEntity implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_")
	private String id;

	@Column(name="EMAIL_")
	private String email;

	@Column(name="FIRST_")
	private String first;

	@Column(name="LAST_")
	private String last;

	@Column(name="PICTURE_ID_")
	private String pictureId;

	@Column(name="PWD_")
	private String pwd;

	@Column(name="REV_")
	private int rev;

	//bi-directional many-to-many association to ActIdGroup
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="act_id_membership"
		, joinColumns={
			@JoinColumn(name="USER_ID_")
			}
		, inverseJoinColumns={
			@JoinColumn(name="GROUP_ID_")
			}
		)
	private List<ActIdGroup> actIdGroups;

	public ActIdUser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst() {
		return this.first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return this.last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getPictureId() {
		return this.pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getRev() {
		return this.rev;
	}

	public void setRev(int rev) {
		this.rev = rev;
	}

	public List<ActIdGroup> getActIdGroups() {
		return this.actIdGroups;
	}

	public void setActIdGroups(List<ActIdGroup> actIdGroups) {
		this.actIdGroups = actIdGroups;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        List<ActIdGroup> roles = this.getActIdGroups();
        for (ActIdGroup role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
	}

	@Override
	public String getPassword() {
		return this.getPwd();
	}

	@Override
	public String getUsername() {
		return this.getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}