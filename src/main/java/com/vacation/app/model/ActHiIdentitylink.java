package com.vacation.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the act_hi_identitylink database table.
 * 
 */
@Entity
@Table(name="act_hi_identitylink")
@NamedQuery(name="ActHiIdentitylink.findAll", query="SELECT a FROM ActHiIdentitylink a")
public class ActHiIdentitylink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_")
	private String id;

	@Column(name="GROUP_ID_")
	private String groupId;

	@Column(name="PROC_INST_ID_")
	private String procInstId;

	@Column(name="TASK_ID_")
	private String taskId;

	@Column(name="TYPE_")
	private String type;

	@Column(name="USER_ID_")
	private String userId;

	public ActHiIdentitylink() {
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

	public String getProcInstId() {
		return this.procInstId;
	}

	public void setProcInstId(String procInstId) {
		this.procInstId = procInstId;
	}

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
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

}