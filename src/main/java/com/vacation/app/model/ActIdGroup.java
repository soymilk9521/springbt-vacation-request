package com.vacation.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the act_id_group database table.
 * 
 */
@Entity
@Table(name="act_id_group")
@NamedQuery(name="ActIdGroup.findAll", query="SELECT a FROM ActIdGroup a")
public class ActIdGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_")
	private String id;

	@Column(name="NAME_")
	private String name;

	@Column(name="REV_")
	private int rev;

	@Column(name="TYPE_")
	private String type;

	public ActIdGroup() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRev() {
		return this.rev;
	}

	public void setRev(int rev) {
		this.rev = rev;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}