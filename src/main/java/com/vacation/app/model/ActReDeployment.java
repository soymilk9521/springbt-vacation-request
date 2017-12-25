package com.vacation.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the act_re_deployment database table.
 * 
 */
@Entity
@Table(name="act_re_deployment")
@NamedQuery(name="ActReDeployment.findAll", query="SELECT a FROM ActReDeployment a")
public class ActReDeployment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_")
	private String id;

	@Column(name="CATEGORY_")
	private String category;

	@Column(name="DEPLOY_TIME_")
	private Timestamp deployTime;

	@Column(name="NAME_")
	private String name;

	@Column(name="TENANT_ID_")
	private String tenantId;

	//bi-directional many-to-one association to ActGeBytearray
	@OneToMany(mappedBy="actReDeployment")
	private List<ActGeBytearray> actGeBytearrays;

	//bi-directional many-to-one association to ActReModel
	@OneToMany(mappedBy="actReDeployment")
	private List<ActReModel> actReModels;

	public ActReDeployment() {
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

	public Timestamp getDeployTime() {
		return this.deployTime;
	}

	public void setDeployTime(Timestamp deployTime) {
		this.deployTime = deployTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public List<ActGeBytearray> getActGeBytearrays() {
		return this.actGeBytearrays;
	}

	public void setActGeBytearrays(List<ActGeBytearray> actGeBytearrays) {
		this.actGeBytearrays = actGeBytearrays;
	}

	public ActGeBytearray addActGeBytearray(ActGeBytearray actGeBytearray) {
		getActGeBytearrays().add(actGeBytearray);
		actGeBytearray.setActReDeployment(this);

		return actGeBytearray;
	}

	public ActGeBytearray removeActGeBytearray(ActGeBytearray actGeBytearray) {
		getActGeBytearrays().remove(actGeBytearray);
		actGeBytearray.setActReDeployment(null);

		return actGeBytearray;
	}

	public List<ActReModel> getActReModels() {
		return this.actReModels;
	}

	public void setActReModels(List<ActReModel> actReModels) {
		this.actReModels = actReModels;
	}

	public ActReModel addActReModel(ActReModel actReModel) {
		getActReModels().add(actReModel);
		actReModel.setActReDeployment(this);

		return actReModel;
	}

	public ActReModel removeActReModel(ActReModel actReModel) {
		getActReModels().remove(actReModel);
		actReModel.setActReDeployment(null);

		return actReModel;
	}

}