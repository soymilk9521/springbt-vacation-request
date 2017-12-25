package com.vacation.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the act_ru_task database table.
 * 
 */
@Entity
@Table(name="act_ru_task")
@NamedQuery(name="ActRuTask.findAll", query="SELECT a FROM ActRuTask a")
public class ActRuTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_")
	private String id;

	@Column(name="ASSIGNEE_")
	private String assignee;

	@Column(name="CATEGORY_")
	private String category;

	@Column(name="CREATE_TIME_")
	private Timestamp createTime;

	@Column(name="DELEGATION_")
	private String delegation;

	@Column(name="DESCRIPTION_")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DUE_DATE_")
	private Date dueDate;

	@Column(name="FORM_KEY_")
	private String formKey;

	@Column(name="NAME_")
	private String name;

	@Column(name="OWNER_")
	private String owner;

	@Column(name="PARENT_TASK_ID_")
	private String parentTaskId;

	@Column(name="PRIORITY_")
	private int priority;

	@Column(name="REV_")
	private int rev;

	@Column(name="SUSPENSION_STATE_")
	private int suspensionState;

	@Column(name="TASK_DEF_KEY_")
	private String taskDefKey;

	@Column(name="TENANT_ID_")
	private String tenantId;

	//bi-directional many-to-one association to ActRuIdentitylink
	@OneToMany(mappedBy="actRuTask")
	private List<ActRuIdentitylink> actRuIdentitylinks;

	//bi-directional many-to-one association to ActRuExecution
	@ManyToOne
	@JoinColumn(name="EXECUTION_ID_")
	private ActRuExecution actRuExecution1;

	//bi-directional many-to-one association to ActReProcdef
	@ManyToOne
	@JoinColumn(name="PROC_DEF_ID_")
	private ActReProcdef actReProcdef;

	//bi-directional many-to-one association to ActRuExecution
	@ManyToOne
	@JoinColumn(name="PROC_INST_ID_")
	private ActRuExecution actRuExecution2;

	public ActRuTask() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAssignee() {
		return this.assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getDelegation() {
		return this.delegation;
	}

	public void setDelegation(String delegation) {
		this.delegation = delegation;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getFormKey() {
		return this.formKey;
	}

	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getParentTaskId() {
		return this.parentTaskId;
	}

	public void setParentTaskId(String parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getRev() {
		return this.rev;
	}

	public void setRev(int rev) {
		this.rev = rev;
	}

	public int getSuspensionState() {
		return this.suspensionState;
	}

	public void setSuspensionState(int suspensionState) {
		this.suspensionState = suspensionState;
	}

	public String getTaskDefKey() {
		return this.taskDefKey;
	}

	public void setTaskDefKey(String taskDefKey) {
		this.taskDefKey = taskDefKey;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public List<ActRuIdentitylink> getActRuIdentitylinks() {
		return this.actRuIdentitylinks;
	}

	public void setActRuIdentitylinks(List<ActRuIdentitylink> actRuIdentitylinks) {
		this.actRuIdentitylinks = actRuIdentitylinks;
	}

	public ActRuIdentitylink addActRuIdentitylink(ActRuIdentitylink actRuIdentitylink) {
		getActRuIdentitylinks().add(actRuIdentitylink);
		actRuIdentitylink.setActRuTask(this);

		return actRuIdentitylink;
	}

	public ActRuIdentitylink removeActRuIdentitylink(ActRuIdentitylink actRuIdentitylink) {
		getActRuIdentitylinks().remove(actRuIdentitylink);
		actRuIdentitylink.setActRuTask(null);

		return actRuIdentitylink;
	}

	public ActRuExecution getActRuExecution1() {
		return this.actRuExecution1;
	}

	public void setActRuExecution1(ActRuExecution actRuExecution1) {
		this.actRuExecution1 = actRuExecution1;
	}

	public ActReProcdef getActReProcdef() {
		return this.actReProcdef;
	}

	public void setActReProcdef(ActReProcdef actReProcdef) {
		this.actReProcdef = actReProcdef;
	}

	public ActRuExecution getActRuExecution2() {
		return this.actRuExecution2;
	}

	public void setActRuExecution2(ActRuExecution actRuExecution2) {
		this.actRuExecution2 = actRuExecution2;
	}

}