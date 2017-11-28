package org.rest.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceBean {

	private String deviceId;
	private String deviceType;
	private String sapId;
	private String nodeKey;
	private String deviceStatus;
	private String firmWareVersionNo;
	private String centralStationAccntNo;
	private String installedUserId;
	private String parentDeviceId;

	private List<DeviceServicesBean> listOfDeviceServices;
	private List<DeviceAdditionalAttrBean> listOfAddnAttributes;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getSapId() {
		return sapId;
	}

	public void setSapId(String sapId) {
		this.sapId = sapId;
	}

	public String getNodeKey() {
		return nodeKey;
	}

	public void setNodeKey(String nodeKey) {
		this.nodeKey = nodeKey;
	}

	public String getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public String getFirmWareVersionNo() {
		return firmWareVersionNo;
	}

	public void setFirmWareVersionNo(String firmWareVersionNo) {
		this.firmWareVersionNo = firmWareVersionNo;
	}

	public String getCentralStationAccntNo() {
		return centralStationAccntNo;
	}

	public void setCentralStationAccntNo(String centralStationAccntNo) {
		this.centralStationAccntNo = centralStationAccntNo;
	}

	public String getInstalledUserId() {
		return installedUserId;
	}

	public void setInstalledUserId(String installedUserId) {
		this.installedUserId = installedUserId;
	}

	public String getParentDeviceId() {
		return parentDeviceId;
	}

	public void setParentDeviceId(String parentDeviceId) {
		this.parentDeviceId = parentDeviceId;
	}

	public List<DeviceServicesBean> getListOfDeviceServices() {
		return listOfDeviceServices;
	}

	public void setListOfDeviceServices(List<DeviceServicesBean> listOfDeviceServices) {
		this.listOfDeviceServices = listOfDeviceServices;
	}

	public List<DeviceAdditionalAttrBean> getListOfAddnAttributes() {
		return listOfAddnAttributes;
	}

	public void setListOfAddnAttributes(List<DeviceAdditionalAttrBean> listOfAddnAttributes) {
		this.listOfAddnAttributes = listOfAddnAttributes;
	}

}
