package com.mjk.complaint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mjk.complaint.entity.UserIssue;
import com.mjk.complaint.service.UserIssueService;

@RestController
@RequestMapping("/public/userissue")
public class PublicController {
	@Autowired
	UserIssueService userIssueService;
	
	public PublicController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}
	@GetMapping("/users")
	public List<UserIssue> getAllUserIssues()
	{
		// write some code to extract users
		try {
			List<UserIssue>  allExtractedUsers = userIssueService.getAllUserIssue();
			
			return allExtractedUsers;
			
		} catch (Exception e) {
			// code missing for exception handling 
			System.out.println(e);
			
		}
		
		return null;
	}@GetMapping("/id/{issueid}")
	public UserIssue userIssuesByIssueId(@PathVariable int issueid)throws Exception
	{
		return userIssueService.getUserIssueByIssueid(issueid);
	}
	@GetMapping("/status/{status}")
	public List<UserIssue> userIssuesByStatus(@PathVariable boolean status)throws Exception
	{
		return userIssueService.getUserIssueByStatus(status);
	}
	@GetMapping("/category/{searchCategory}")
	public List<UserIssue> userIssuesByCategory(@PathVariable String searchCategory)throws Exception
	{
		return userIssueService.getUserIssueByCategory(searchCategory);
	}
	@GetMapping("/localDate/{searchDate}")
	public List<UserIssue> userIssuesByDate(@PathVariable String searchDate)throws Exception
	{
		return userIssueService.getUserIssueByCategory(searchDate);
	}
	@GetMapping("/title/{title}")
	public List<UserIssue> userIssuesByTitle(@PathVariable String title)throws Exception
	{
		return userIssueService.getUserIssueByTitle(title);
	}
	@GetMapping("/betweenIds")
	public List<UserIssue> userIssuesByIds(@RequestParam int id1,@RequestParam int id2)throws Exception
	{
		return userIssueService.getUserIssuesBetweenIds(id1, id2);
	}
}
