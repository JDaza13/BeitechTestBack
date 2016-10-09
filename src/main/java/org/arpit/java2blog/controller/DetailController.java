package org.arpit.java2blog.controller;

import java.util.Iterator;
import java.util.List;
import org.arpit.java2blog.model.Detail;
import org.arpit.java2blog.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailController {
	
	@Autowired
	DetailService detailService;
	
	@RequestMapping(value = "/getAllDetails", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Detail> getDetails() {
		
		List<Detail> listOfDetails = detailService.getAllDetails();
		return listOfDetails;
	}

	@RequestMapping(value = "/getDetail/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Detail getDetailById(@PathVariable int id) {
		return detailService.getDetail(id);
	}

	@RequestMapping(value = "/addDetail", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addDetail(@RequestBody Detail detail) {	
		detailService.addDetail(detail);		
	}

	@RequestMapping(value = "/addMultipleDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addDetail(@RequestBody List<Detail> listDetail) {
		Iterator <Detail> itr = listDetail.iterator();
		  while(itr.hasNext()) {
			  Detail element = itr.next();
		      detailService.addDetail(element);
		   }		
	}
	
	@RequestMapping(value = "/updateDetail", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateDetail(@RequestBody Detail detail) {
		detailService.updateDetail(detail);
	}

	@RequestMapping(value = "/deleteDetail/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteDetail(@PathVariable("id") int id) {
		detailService.deleteDetail(id);		
	}	
}
