package com.mjk.complaint.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userissue")
public class UserIssue {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int issueid;
	private int userId;
	private String issueTitle;
	private String issueDescription;
	private String category;
	private String localDate;
	private String time;
	private boolean status;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="conversation")
	private List<Conversation> fileLogs;

	public UserIssue(int userId, String issueTitle, String issueDescription, String category, String localDate,
			String time, boolean status) {
		super();
		this.userId = userId;
		this.issueTitle = issueTitle;
		this.issueDescription = issueDescription;
		this.category = category;
		this.localDate = localDate;
		this.time = time;
		this.status = status;
	}


	public boolean getStatus() {
		return status;
		
	}
	public void setStatus(boolean status) {
		this.status=status;
	}

}

