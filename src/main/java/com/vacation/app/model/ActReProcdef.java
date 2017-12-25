package com.vacation.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the act_re_procdef database table.
 * 
 */
@Entity
@Table(name="act_re_procdef")
@NamedQuery(name="ActReProcdef.findAll", query="SELECT a FROM ActReProcdef a")
public class ActReProcdef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_")
	private String id;

	@Column(name="CATEGORY_")
	private String category;

	@Column(name="DEPLOYMENT_ID_")
	private String deploymentId;

	@Column(name="DESCRIPTION_")
	private String description;

	@Column(name="DGRM_RESOURCE_NAME_")
	private String dgrmResourceName;

	@Column(name="HAS_GRAPHICAL_NOTATION_")
	private byte hasGraphicalNotation;

	@Column(name="HAS_START_FORM_KEY_")
	private byte hasStartFormKey;

	@Column(name="KEY_")
	private String key;

	@Column(name="NAME_")
	private String name;

	@Column(name="RESOURCE_NAME_")
	private String resourceName;

	@Column(name="REV_")
	private int rev;

	@Column(name="SUSPENSION_STATE_")
	private int suspensionState;

	@Column(name="TENANT_ID_")
	private String tenantId;

	@Column(name="VERSION_")
	private int version;

	//bi-directional many-to-one association to ActProcdefInfo
	@OneToMany(mappedBy="actReProcdef")
	private List<ActProcdefInfo> actProcdefInfos;

	//bi-directional many-to-one association to ActRuExecution
	@OneToMany(mappedBy="actReProcdef")
	private List<ActRuExecution> actRuExecutions;

	//bi-directional many-to-one association to ActRuIdentitylink
	@OneToMany(mappedBy="actReProcdef")
	private List<ActRuIdentitylink> actRuIdentitylinks;

	//bi-directional many-to-one association to ActRuTask
	@OneToMany(mappedBy="actReProcdef")
	private List<ActRuTask> actRuTasks;

	public ActReProcdef() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDeploymentId() {
		return this.deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDgrmResourceName() {
		return this.dgrmResourceName;
	}

	public void setDgrmResourceName(String dgrmResourceName) {
		this.dgrmResourceName = dgrmResourceName;
	}

	public byte getHasGraphicalNotation() {
		return this.hasGraphicalNotation;
	}

	public void setHasGraphicalNotation(byte hasGraphicalNotation) {
		this.hasGraphicalNotation = hasGraphicalNotation;
	}

	public byte getHasStartFormKey() {
		return this.hasStartFormKey;
	}

	public void setHasStartFormKey(byte hasStartFormKey) {
		this.hasStartFormKey = hasStartFormKey;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
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

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<ActProcdefInfo> getActProcdefInfos() {
		return this.actProcdefInfos;
	}

	public void setActProcdefInfos(List<ActProcdefInfo> actProcdefInfos) {
		this.actProcdefInfos = actProcdefInfos;
	}

	public ActProcdefInfo addActProcdefInfo(ActProcdefInfo actProcdefInfo) {
		getActProcdefInfos().add(actProcdefInfo);
		actProcdefInfo.setActReProcdef(this);

		return actProcdefInfo;
	}

	public ActProcdefInfo removeActProcdefInfo(ActProcdefInfo actProcdefInfo) {
		getActProcdefInfos().remove(actProcdefInfo);
		actProcdefInfo.setActReProcdef(null);

		return actProcdefInfo;
	}

	public List<ActRuExecution> getActRuExecutions() {
		return this.actRuExecutions;
	}

	public void setActRuExecutions(List<ActRuExecution> actRuExecutions) {
		this.actRuExecutions = actRuExecutions;
	}

	public ActRuExecution addActRuExecution(ActRuExecution actRuExecution) {
		getActRuExecutions().add(actRuExecution);
		actRuExecution.setActReProcdef(this);

		return actRuExecution;
	}

	public ActRuExecution removeActRuExecution(ActRuExecution actRuExecution) {
		getActRuExecutions().remove(actRuExecution);
		actRuExecution.setActReProcdef(null);

		return actRuExecution;
	}

	public List<ActRuIdentitylink> getActRuIdentitylinks() {
		return this.actRuIdentitylinks;
	}

	public void setActRuIdentitylinks(List<ActRuIdentitylink> actRuIdentitylinks) {
		this.actRuIdentitylinks = actRuIdentitylinks;
	}

	public ActRuIdentitylink addActRuIdentitylink(ActRuIdentitylink actRuIdentitylink) {
		getActRuIdentitylinks().add(actRuIdentitylink);
		actRuIdentitylink.setActReProcdef(this);

		return actRuIdentitylink;
	}

	public ActRuIdentitylink removeActRuIdentitylink(ActRuIdentitylink actRuIdentitylink) {
		getActRuIdentitylinks().remove(actRuIdentitylink);
		actRuIdentitylink.setActReProcdef(null);

		return actRuIdentitylink;
	}

	public List<ActRuTask> getActRuTasks() {
		return this.actRuTasks;
	}

	public void setActRuTasks(List<ActRuTask> actRuTasks) {
		this.actRuTasks = actRuTasks;
	}

	public ActRuTask addActRuTask(ActRuTask actRuTask) {
		getActRuTasks().add(actRuTask);
		actRuTask.setActReProcdef(this);

		return actRuTask;
	}

	public ActRuTask removeActRuTask(ActRuTask actRuTask) {
		getActRuTasks().remove(actRuTask);
		actRuTask.setActReProcdef(null);

		return actRuTask;
	}

}