package com.vacation.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the act_ru_execution database table.
 * 
 */
@Entity
@Table(name="act_ru_execution")
@NamedQuery(name="ActRuExecution.findAll", query="SELECT a FROM ActRuExecution a")
public class ActRuExecution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_")
	private String id;

	@Column(name="ACT_ID_")
	private String actId;

	@Column(name="BUSINESS_KEY_")
	private String businessKey;

	@Column(name="CACHED_ENT_STATE_")
	private int cachedEntState;

	@Column(name="IS_ACTIVE_")
	private byte isActive;

	@Column(name="IS_CONCURRENT_")
	private byte isConcurrent;

	@Column(name="IS_EVENT_SCOPE_")
	private byte isEventScope;

	@Column(name="IS_SCOPE_")
	private byte isScope;

	@Column(name="LOCK_TIME_")
	private Timestamp lockTime;

	@Column(name="NAME_")
	private String name;

	@Column(name="REV_")
	private int rev;

	@Column(name="SUSPENSION_STATE_")
	private int suspensionState;

	@Column(name="TENANT_ID_")
	private String tenantId;

	//bi-directional many-to-one association to ActRuEventSubscr
	@OneToMany(mappedBy="actRuExecution")
	private List<ActRuEventSubscr> actRuEventSubscrs;

	//bi-directional many-to-one association to ActRuExecution
	@ManyToOne
	@JoinColumn(name="PARENT_ID_")
	private ActRuExecution actRuExecution1;

	//bi-directional many-to-one association to ActRuExecution
	@OneToMany(mappedBy="actRuExecution1")
	private List<ActRuExecution> actRuExecutions1;

	//bi-directional many-to-one association to ActReProcdef
	@ManyToOne
	@JoinColumn(name="PROC_DEF_ID_")
	private ActReProcdef actReProcdef;

	//bi-directional many-to-one association to ActRuExecution
	@ManyToOne
	@JoinColumn(name="PROC_INST_ID_")
	private ActRuExecution actRuExecution2;

	//bi-directional many-to-one association to ActRuExecution
	@OneToMany(mappedBy="actRuExecution2")
	private List<ActRuExecution> actRuExecutions2;

	//bi-directional many-to-one association to ActRuExecution
	@ManyToOne
	@JoinColumn(name="SUPER_EXEC_")
	private ActRuExecution actRuExecution3;

	//bi-directional many-to-one association to ActRuExecution
	@OneToMany(mappedBy="actRuExecution3")
	private List<ActRuExecution> actRuExecutions3;

	//bi-directional many-to-one association to ActRuIdentitylink
	@OneToMany(mappedBy="actRuExecution")
	private List<ActRuIdentitylink> actRuIdentitylinks;

	//bi-directional many-to-one association to ActRuTask
	@OneToMany(mappedBy="actRuExecution1")
	private List<ActRuTask> actRuTasks1;

	//bi-directional many-to-one association to ActRuTask
	@OneToMany(mappedBy="actRuExecution2")
	private List<ActRuTask> actRuTasks2;

	//bi-directional many-to-one association to ActRuVariable
	@OneToMany(mappedBy="actRuExecution1")
	private List<ActRuVariable> actRuVariables1;

	//bi-directional many-to-one association to ActRuVariable
	@OneToMany(mappedBy="actRuExecution2")
	private List<ActRuVariable> actRuVariables2;

	public ActRuExecution() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActId() {
		return this.actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	public String getBusinessKey() {
		return this.businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	public int getCachedEntState() {
		return this.cachedEntState;
	}

	public void setCachedEntState(int cachedEntState) {
		this.cachedEntState = cachedEntState;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public byte getIsConcurrent() {
		return this.isConcurrent;
	}

	public void setIsConcurrent(byte isConcurrent) {
		this.isConcurrent = isConcurrent;
	}

	public byte getIsEventScope() {
		return this.isEventScope;
	}

	public void setIsEventScope(byte isEventScope) {
		this.isEventScope = isEventScope;
	}

	public byte getIsScope() {
		return this.isScope;
	}

	public void setIsScope(byte isScope) {
		this.isScope = isScope;
	}

	public Timestamp getLockTime() {
		return this.lockTime;
	}

	public void setLockTime(Timestamp lockTime) {
		this.lockTime = lockTime;
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

	public int getSuspensionState() {
		return this.suspensionState;
	}

	public void setSuspensionState(int suspensionState) {
		this.suspensionState = suspensionState;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public List<ActRuEventSubscr> getActRuEventSubscrs() {
		return this.actRuEventSubscrs;
	}

	public void setActRuEventSubscrs(List<ActRuEventSubscr> actRuEventSubscrs) {
		this.actRuEventSubscrs = actRuEventSubscrs;
	}

	public ActRuEventSubscr addActRuEventSubscr(ActRuEventSubscr actRuEventSubscr) {
		getActRuEventSubscrs().add(actRuEventSubscr);
		actRuEventSubscr.setActRuExecution(this);

		return actRuEventSubscr;
	}

	public ActRuEventSubscr removeActRuEventSubscr(ActRuEventSubscr actRuEventSubscr) {
		getActRuEventSubscrs().remove(actRuEventSubscr);
		actRuEventSubscr.setActRuExecution(null);

		return actRuEventSubscr;
	}

	public ActRuExecution getActRuExecution1() {
		return this.actRuExecution1;
	}

	public void setActRuExecution1(ActRuExecution actRuExecution1) {
		this.actRuExecution1 = actRuExecution1;
	}

	public List<ActRuExecution> getActRuExecutions1() {
		return this.actRuExecutions1;
	}

	public void setActRuExecutions1(List<ActRuExecution> actRuExecutions1) {
		this.actRuExecutions1 = actRuExecutions1;
	}

	public ActRuExecution addActRuExecutions1(ActRuExecution actRuExecutions1) {
		getActRuExecutions1().add(actRuExecutions1);
		actRuExecutions1.setActRuExecution1(this);

		return actRuExecutions1;
	}

	public ActRuExecution removeActRuExecutions1(ActRuExecution actRuExecutions1) {
		getActRuExecutions1().remove(actRuExecutions1);
		actRuExecutions1.setActRuExecution1(null);

		return actRuExecutions1;
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

	public List<ActRuExecution> getActRuExecutions2() {
		return this.actRuExecutions2;
	}

	public void setActRuExecutions2(List<ActRuExecution> actRuExecutions2) {
		this.actRuExecutions2 = actRuExecutions2;
	}

	public ActRuExecution addActRuExecutions2(ActRuExecution actRuExecutions2) {
		getActRuExecutions2().add(actRuExecutions2);
		actRuExecutions2.setActRuExecution2(this);

		return actRuExecutions2;
	}

	public ActRuExecution removeActRuExecutions2(ActRuExecution actRuExecutions2) {
		getActRuExecutions2().remove(actRuExecutions2);
		actRuExecutions2.setActRuExecution2(null);

		return actRuExecutions2;
	}

	public ActRuExecution getActRuExecution3() {
		return this.actRuExecution3;
	}

	public void setActRuExecution3(ActRuExecution actRuExecution3) {
		this.actRuExecution3 = actRuExecution3;
	}

	public List<ActRuExecution> getActRuExecutions3() {
		return this.actRuExecutions3;
	}

	public void setActRuExecutions3(List<ActRuExecution> actRuExecutions3) {
		this.actRuExecutions3 = actRuExecutions3;
	}

	public ActRuExecution addActRuExecutions3(ActRuExecution actRuExecutions3) {
		getActRuExecutions3().add(actRuExecutions3);
		actRuExecutions3.setActRuExecution3(this);

		return actRuExecutions3;
	}

	public ActRuExecution removeActRuExecutions3(ActRuExecution actRuExecutions3) {
		getActRuExecutions3().remove(actRuExecutions3);
		actRuExecutions3.setActRuExecution3(null);

		return actRuExecutions3;
	}

	public List<ActRuIdentitylink> getActRuIdentitylinks() {
		return this.actRuIdentitylinks;
	}

	public void setActRuIdentitylinks(List<ActRuIdentitylink> actRuIdentitylinks) {
		this.actRuIdentitylinks = actRuIdentitylinks;
	}

	public ActRuIdentitylink addActRuIdentitylink(ActRuIdentitylink actRuIdentitylink) {
		getActRuIdentitylinks().add(actRuIdentitylink);
		actRuIdentitylink.setActRuExecution(this);

		return actRuIdentitylink;
	}

	public ActRuIdentitylink removeActRuIdentitylink(ActRuIdentitylink actRuIdentitylink) {
		getActRuIdentitylinks().remove(actRuIdentitylink);
		actRuIdentitylink.setActRuExecution(null);

		return actRuIdentitylink;
	}

	public List<ActRuTask> getActRuTasks1() {
		return this.actRuTasks1;
	}

	public void setActRuTasks1(List<ActRuTask> actRuTasks1) {
		this.actRuTasks1 = actRuTasks1;
	}

	public ActRuTask addActRuTasks1(ActRuTask actRuTasks1) {
		getActRuTasks1().add(actRuTasks1);
		actRuTasks1.setActRuExecution1(this);

		return actRuTasks1;
	}

	public ActRuTask removeActRuTasks1(ActRuTask actRuTasks1) {
		getActRuTasks1().remove(actRuTasks1);
		actRuTasks1.setActRuExecution1(null);

		return actRuTasks1;
	}

	public List<ActRuTask> getActRuTasks2() {
		return this.actRuTasks2;
	}

	public void setActRuTasks2(List<ActRuTask> actRuTasks2) {
		this.actRuTasks2 = actRuTasks2;
	}

	public ActRuTask addActRuTasks2(ActRuTask actRuTasks2) {
		getActRuTasks2().add(actRuTasks2);
		actRuTasks2.setActRuExecution2(this);

		return actRuTasks2;
	}

	public ActRuTask removeActRuTasks2(ActRuTask actRuTasks2) {
		getActRuTasks2().remove(actRuTasks2);
		actRuTasks2.setActRuExecution2(null);

		return actRuTasks2;
	}

	public List<ActRuVariable> getActRuVariables1() {
		return this.actRuVariables1;
	}

	public void setActRuVariables1(List<ActRuVariable> actRuVariables1) {
		this.actRuVariables1 = actRuVariables1;
	}

	public ActRuVariable addActRuVariables1(ActRuVariable actRuVariables1) {
		getActRuVariables1().add(actRuVariables1);
		actRuVariables1.setActRuExecution1(this);

		return actRuVariables1;
	}

	public ActRuVariable removeActRuVariables1(ActRuVariable actRuVariables1) {
		getActRuVariables1().remove(actRuVariables1);
		actRuVariables1.setActRuExecution1(null);

		return actRuVariables1;
	}

	public List<ActRuVariable> getActRuVariables2() {
		return this.actRuVariables2;
	}

	public void setActRuVariables2(List<ActRuVariable> actRuVariables2) {
		this.actRuVariables2 = actRuVariables2;
	}

	public ActRuVariable addActRuVariables2(ActRuVariable actRuVariables2) {
		getActRuVariables2().add(actRuVariables2);
		actRuVariables2.setActRuExecution2(this);

		return actRuVariables2;
	}

	public ActRuVariable removeActRuVariables2(ActRuVariable actRuVariables2) {
		getActRuVariables2().remove(actRuVariables2);
		actRuVariables2.setActRuExecution2(null);

		return actRuVariables2;
	}

}