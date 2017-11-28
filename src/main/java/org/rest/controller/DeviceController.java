package org.rest.controller;

import org.rest.bean.DeviceBean;
import org.rest.bean.Success;
import org.rest.service.DeviceService;
import org.rest.validator.DeviceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

	@Autowired
	private DeviceService deviceService;
	@Autowired
	private DeviceValidator deviceValidator;

	@RequestMapping(value = "/createDevice", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody DeviceBean createDevice(@RequestBody DeviceBean deviceBean) {
		try {
			if (deviceValidator.validateDevice(deviceBean)) {
				return deviceService.createDevice(deviceBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new DeviceBean();
	}
	
	@RequestMapping(value="/deleteDevice/{deviceId}", method = RequestMethod.DELETE, headers="Accept=application/json")
	public @ResponseBody Success deleteDevice(@PathVariable String deviceId) {
		return deviceService.deleteDevice(deviceId);
	}
	
	@RequestMapping(value="/updateDevice", method= RequestMethod.PUT, headers="Accept=application/json")
	public @ResponseBody DeviceBean updateDevice(@RequestBody DeviceBean deviceBean) {
		try {
		if(deviceValidator.validateDevice(deviceBean)) {
			return deviceService.updateDevice(deviceBean);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public DeviceService getDeviceService() {
		return deviceService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public DeviceValidator getDeviceValidator() {
		return deviceValidator;
	}

	public void setDeviceValidator(DeviceValidator deviceValidator) {
		this.deviceValidator = deviceValidator;
	}
}
