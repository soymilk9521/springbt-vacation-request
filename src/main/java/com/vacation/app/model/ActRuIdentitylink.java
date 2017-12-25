package com.vacation.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the act_ru_identitylink database table.
 * 
 */
@Entity
@Table(name="act_ru_identitylink")
@NamedQuery(name="ActRuIdentitylink.findAll", query="SELECT a FROM ActRuIdentitylink a")
public class ActRuIdentitylink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_")
	private String id;

	@Column(name="GROUP_ID_")
	private String groupId;

	@Column(name="REV_")
	private int rev;

	@Column(name="TYPE_")
	private String type;

	@Column(name="USER_ID_")
	private String userId;

	//bi-directional many-to-one association to ActReProcdef
	@ManyToOne
	@JoinColumn(name="PROC_DEF_ID_")
	private ActReProcdef actReProcdef;

	//bi-directional many-to-one association to ActRuExecution
	@ManyToOne
	@JoinColumn(name="PROC_INST_ID_")
	private ActRuExecution actRuExecution;

	//bi-directional many-to-one association to ActRuTask
	@ManyToOne
	@JoinColumn(name="TASK_ID_")
	private ActRuTask actRuTask;

	public ActRuIdentitylink() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
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

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public ActReProcdef getActReProcdef() {
		return this.actReProcdef;
	}

	public void setActReProcdef(ActReProcdef actReProcdef) {
		this.actReProcdef = actReProcdef;
	}

	public ActRuExecution getActRuExecution() {
		return this.actRuExecution;
	}

	public void setActRuExecution(ActRuExecution actRuExecution) {
		this.actRuExecution = actRuExecution;
	}

	public ActRuTask getActRuTask() {
		return this.actRuTask;
	}

	public void setActRuTask(ActRuTask actRuTask) {
		this.actRuTask = actRuTask;
	}

}