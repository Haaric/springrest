package org.rest.bean;

import java.util.List;

import org.rest.util.ErrorCodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NodeBean {

	public NodeBean(ErrorCodes errorDetails) {
		super();
		this.errorDetails = errorDetails;
	}

	public NodeBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String name;
	private String sapId;
	private String id;
	private String parentId;
	private String siteAddress1;
	private String siteAddress2;
	private String country;
	private String zip;
	private String phone;
	private String notes;

	private ErrorCodes errorDetails;

	private List<DeviceBean> listOfDeviceBeans;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getSiteAddress1() {
		return siteAddress1;
	}

	public void setSiteAddress1(String siteAddress1) {
		this.siteAddress1 = siteAddress1;
	}

	public String getSiteAddress2() {
		return siteAddress2;
	}

	public void setSiteAddress2(String siteAddress2) {
		this.siteAddress2 = siteAddress2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getSapId() {
		return sapId;
	}

	public void setSapId(String sapId) {
		this.sapId = sapId;
	}

	public List<DeviceBean> getListOfDeviceBeans() {
		return listOfDeviceBeans;
	}

	public void setListOfDeviceBeans(List<DeviceBean> listOfDeviceBeans) {
		this.listOfDeviceBeans = listOfDeviceBeans;
	}

	public ErrorCodes getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(ErrorCodes errorDetails) {
		this.errorDetails = errorDetails;
	}

}
