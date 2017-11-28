package org.rest.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//DEVIEC_ADDDL_ATTR
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceAdditionalAttrBean {

	private String deviceId;
	private String deviceAttrName;
	private String deviceAttrValue;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceAttrName() {
		return deviceAttrName;
	}

	public void setDeviceAttrName(String deviceAttrName) {
		this.deviceAttrName = deviceAttrName;
	}

	public String getDeviceAttrValue() {
		return deviceAttrValue;
	}

	public void setDeviceAttrValue(String deviceAttrValue) {
		this.deviceAttrValue = deviceAttrValue;
	}

}
