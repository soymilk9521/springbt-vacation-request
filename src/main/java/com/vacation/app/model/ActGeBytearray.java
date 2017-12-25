package com.vacation.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the act_ge_bytearray database table.
 * 
 */
@Entity
@Table(name="act_ge_bytearray")
@NamedQuery(name="ActGeBytearray.findAll", query="SELECT a FROM ActGeBytearray a")
public class ActGeBytearray implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_")
	private String id;

	@Lob
	@Column(name="BYTES_")
	private byte[] bytes;

	@Column(name="GENERATED_")
	private byte generated;

	@Column(name="NAME_")
	private String name;

	@Column(name="REV_")
	private int rev;

	//bi-directional many-to-one association to ActReDeployment
	@ManyToOne
	@JoinColumn(name="DEPLOYMENT_ID_")
	private ActReDeployment actReDeployment;

	//bi-directional many-to-one association to ActProcdefInfo
	@OneToMany(mappedBy="actGeBytearray")
	private List<ActProcdefInfo> actProcdefInfos;

	//bi-directional many-to-one association to ActReModel
	@OneToMany(mappedBy="actGeBytearray1")
	private List<ActReModel> actReModels1;

	//bi-directional many-to-one association to ActReModel
	@OneToMany(mappedBy="actGeBytearray2")
	private List<ActReModel> actReModels2;

	//bi-directional many-to-one association to ActRuJob
	@OneToMany(mappedBy="actGeBytearray")
	private List<ActRuJob> actRuJobs;

	//bi-directional many-to-one association to ActRuVariable
	@OneToMany(mappedBy="actGeBytearray")
	private List<ActRuVariable> actRuVariables;

	public ActGeBytearray() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getBytes() {
		return this.bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public byte getGenerated() {
		return this.generated;
	}

	public void setGenerated(byte generated) {
		this.generated = generated;
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

	public ActReDeployment getActReDeployment() {
		return this.actReDeployment;
	}

	public void setActReDeployment(ActReDeployment actReDeployment) {
		this.actReDeployment = actReDeployment;
	}

	public List<ActProcdefInfo> getActProcdefInfos() {
		return this.actProcdefInfos;
	}

	public void setActProcdefInfos(List<ActProcdefInfo> actProcdefInfos) {
		this.actProcdefInfos = actProcdefInfos;
	}

	public ActProcdefInfo addActProcdefInfo(ActProcdefInfo actProcdefInfo) {
		getActProcdefInfos().add(actProcdefInfo);
		actProcdefInfo.setActGeBytearray(this);

		return actProcdefInfo;
	}

	public ActProcdefInfo removeActProcdefInfo(ActProcdefInfo actProcdefInfo) {
		getActProcdefInfos().remove(actProcdefInfo);
		actProcdefInfo.setActGeBytearray(null);

		return actProcdefInfo;
	}

	public List<ActReModel> getActReModels1() {
		return this.actReModels1;
	}

	public void setActReModels1(List<ActReModel> actReModels1) {
		this.actReModels1 = actReModels1;
	}

	public ActReModel addActReModels1(ActReModel actReModels1) {
		getActReModels1().add(actReModels1);
		actReModels1.setActGeBytearray1(this);

		return actReModels1;
	}

	public ActReModel removeActReModels1(ActReModel actReModels1) {
		getActReModels1().remove(actReModels1);
		actReModels1.setActGeBytearray1(null);

		return actReModels1;
	}

	public List<ActReModel> getActReModels2() {
		return this.actReModels2;
	}

	public void setActReModels2(List<ActReModel> actReModels2) {
		this.actReModels2 = actReModels2;
	}

	public ActReModel addActReModels2(ActReModel actReModels2) {
		getActReModels2().add(actReModels2);
		actReModels2.setActGeBytearray2(this);

		return actReModels2;
	}

	public ActReModel removeActReModels2(ActReModel actReModels2) {
		getActReModels2().remove(actReModels2);
		actReModels2.setActGeBytearray2(null);

		return actReModels2;
	}

	public List<ActRuJob> getActRuJobs() {
		return this.actRuJobs;
	}

	public void setActRuJobs(List<ActRuJob> actRuJobs) {
		this.actRuJobs = actRuJobs;
	}

	public ActRuJob addActRuJob(ActRuJob actRuJob) {
		getActRuJobs().add(actRuJob);
		actRuJob.setActGeBytearray(this);

		return actRuJob;
	}

	public ActRuJob removeActRuJob(ActRuJob actRuJob) {
		getActRuJobs().remove(actRuJob);
		actRuJob.setActGeBytearray(null);

		return actRuJob;
	}

	public List<ActRuVariable> getActRuVariables() {
		return this.actRuVariables;
	}

	public void setActRuVariables(List<ActRuVariable> actRuVariables) {
		this.actRuVariables = actRuVariables;
	}

	public ActRuVariable addActRuVariable(ActRuVariable actRuVariable) {
		getActRuVariables().add(actRuVariable);
		actRuVariable.setActGeBytearray(this);

		return actRuVariable;
	}

	public ActRuVariable removeActRuVariable(ActRuVariable actRuVariable) {
		getActRuVariables().remove(actRuVariable);
		actRuVariable.setActGeBytearray(null);

		return actRuVariable;
	}

}