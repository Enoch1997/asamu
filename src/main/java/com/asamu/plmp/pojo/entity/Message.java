package com.asamu.plmp.pojo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="t_message")
public class Message extends BaseEntity{
	@Column(length=50)
	private String title;
	
	@Column(name="receiver_user_id",length=5)
	private Integer receiverUserId;
	
	@Column(length=255)
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;
	
	@Column(name="is_read")
	private Integer isRead;
	@Transient
	private String remark;
	
	@Transient
	public String getRemark() {
		return remark;
	}

	public void setRemark() {
		if(this.isRead==0)
		{
			this.remark = "未读";
		}
		else {
			this.remark = "已读";
		}

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getReceiverUserId() {
		return receiverUserId;
	}

	public void setReceiverUserId(Integer receiverUserId) {
		this.receiverUserId = receiverUserId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime.toString();
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	@Override
	public String toString() {
		return "Message [title=" + title + ", receiverUserId=" + receiverUserId + ", content=" + content
				+ ", createTime=" + createTime + ", isRead=" + isRead + "]";
	}

	

}
