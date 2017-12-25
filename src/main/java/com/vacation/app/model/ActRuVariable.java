package com.vacation.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the act_ru_variable database table.
 * 
 */
@Entity
@Table(name="act_ru_variable")
@NamedQuery(name="ActRuVariable.findAll", query="SELECT a FROM ActRuVariable a")
public class ActRuVariable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_")
	private String id;

	private double double_;

	private BigInteger long_;

	@Column(name="NAME_")
	private String name;

	@Column(name="REV_")
	private int rev;

	@Column(name="TASK_ID_")
	private String taskId;

	@Column(name="TEXT_")
	private String text;

	@Column(name="TEXT2_")
	private String text2;

	@Column(name="TYPE_")
	private String type;

	//bi-directional many-to-one association to ActGeBytearray
	@ManyToOne
	@JoinColumn(name="BYTEARRAY_ID_")
	private ActGeBytearray actGeBytearray;

	//bi-directional many-to-one association to ActRuExecution
	@ManyToOne
	@JoinColumn(name="EXECUTION_ID_")
	private ActRuExecution actRuExecution1;

	//bi-directional many-to-one association to ActRuExecution
	@ManyToOne
	@JoinColumn(name="PROC_INST_ID_")
	private ActRuExecution actRuExecution2;

	public ActRuVariable() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getDouble_() {
		return this.double_;
	}

	public void setDouble_(double double_) {
		this.double_ = double_;
	}

	public BigInteger getLong_() {
		return this.long_;
	}

	public void setLong_(BigInteger long_) {
		this.long_ = long_;
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

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText2() {
		return this.text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ActGeBytearray getActGeBytearray() {
		return this.actGeBytearray;
	}

	public void setActGeBytearray(ActGeBytearray actGeBytearray) {
		this.actGeBytearray = actGeBytearray;
	}

	public ActRuExecution getActRuExecution1() {
		return this.actRuExecution1;
	}

	public void setActRuExecution1(ActRuExecution actRuExecution1) {
		this.actRuExecution1 = actRuExecution1;
	}

	public ActRuExecution getActRuExecution2() {
		return this.actRuExecution2;
	}

	public void setActRuExecution2(ActRuExecution actRuExecution2) {
		this.actRuExecution2 = actRuExecution2;
	}

}