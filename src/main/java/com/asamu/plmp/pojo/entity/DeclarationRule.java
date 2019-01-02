package com.asamu.plmp.pojo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_declaration_rule")
public class DeclarationRule extends BaseEntity{
	@Column(name="rule_content",length=1000)
	private String ruleContent;
	
	@Column(name="deadline")
	private String deadline;
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getRuleContent() {
		return ruleContent;
	}

	public void setRuleContent(String ruleContent) {
		this.ruleContent = ruleContent;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	@Override
	public String toString() {
		return "DeclarationRule [ruleContent=" + ruleContent + ", deadline=" + deadline + ", type=" + type + "]";
	}
	
	
	
}
