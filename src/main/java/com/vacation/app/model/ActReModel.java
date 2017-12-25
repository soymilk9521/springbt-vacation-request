package com.vacation.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the act_re_model database table.
 * 
 */
@Entity
@Table(name="act_re_model")
@NamedQuery(name="ActReModel.findAll", query="SELECT a FROM ActReModel a")
public class ActReModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_")
	private String id;

	@Column(name="CATEGORY_")
	private String category;

	@Column(name="CREATE_TIME_")
	private Timestamp createTime;

	@Column(name="KEY_")
	private String key;

	@Column(name="LAST_UPDATE_TIME_")
	private Timestamp lastUpdateTime;

	@Column(name="META_INFO_")
	private String metaInfo;

	@Column(name="NAME_")
	private String name;

	@Column(name="REV_")
	private int rev;

	@Column(name="TENANT_ID_")
	private String tenantId;

	@Column(name="VERSION_")
	private int version;

	//bi-directional many-to-one association to ActReDeployment
	@ManyToOne
	@JoinColumn(name="DEPLOYMENT_ID_")
	private ActReDeployment actReDeployment;

	//bi-directional many-to-one association to ActGeBytearray
	@ManyToOne
	@JoinColumn(name="EDITOR_SOURCE_VALUE_ID_")
	private ActGeBytearray actGeBytearray1;

	//bi-directional many-to-one association to ActGeBytearray
	@ManyToOne
	@JoinColumn(name="EDITOR_SOURCE_EXTRA_VALUE_ID_")
	private ActGeBytearray actGeBytearray2;

	public ActReModel() {
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

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Timestamp getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getMetaInfo() {
		return this.metaInfo;
	}

	public void setMetaInfo(String metaInfo) {
		this.metaInfo = metaInfo;
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

	public ActReDeployment getActReDeployment() {
		return this.actReDeployment;
	}

	public void setActReDeployment(ActReDeployment actReDeployment) {
		this.actReDeployment = actReDeployment;
	}

	public ActGeBytearray getActGeBytearray1() {
		return this.actGeBytearray1;
	}

	public void setActGeBytearray1(ActGeBytearray actGeBytearray1) {
		this.actGeBytearray1 = actGeBytearray1;
	}

	public ActGeBytearray getActGeBytearray2() {
		return this.actGeBytearray2;
	}

	public void setActGeBytearray2(ActGeBytearray actGeBytearray2) {
		this.actGeBytearray2 = actGeBytearray2;
	}

}