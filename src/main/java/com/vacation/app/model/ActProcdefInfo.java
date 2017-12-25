package com.vacation.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the act_procdef_info database table.
 * 
 */
@Entity
@Table(name="act_procdef_info")
@NamedQuery(name="ActProcdefInfo.findAll", query="SELECT a FROM ActProcdefInfo a")
public class ActProcdefInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_")
	private String id;

	@Column(name="REV_")
	private int rev;

	//bi-directional many-to-one association to ActGeBytearray
	@ManyToOne
	@JoinColumn(name="INFO_JSON_ID_")
	private ActGeBytearray actGeBytearray;

	//bi-directional many-to-one association to ActReProcdef
	@ManyToOne
	@JoinColumn(name="PROC_DEF_ID_")
	private ActReProcdef actReProcdef;

	public ActProcdefInfo() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRev() {
		return this.rev;
	}

	public void setRev(int rev) {
		this.rev = rev;
	}

	public ActGeBytearray getActGeBytearray() {
		return this.actGeBytearray;
	}

	public void setActGeBytearray(ActGeBytearray actGeBytearray) {
		this.actGeBytearray = actGeBytearray;
	}

	public ActReProcdef getActReProcdef() {
		return this.actReProcdef;
	}

	public void setActReProcdef(ActReProcdef actReProcdef) {
		this.actReProcdef = actReProcdef;
	}

}