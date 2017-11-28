package org.rest.validator;

import org.rest.bean.DeviceBean;
import org.rest.exceptions.DataValidationException;
import org.rest.util.ErrorCodes;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("deviceValidator")
public class DeviceValidator {

	public boolean validateDevice(DeviceBean deviceBean) throws Exception {
		if (StringUtils.isEmpty(deviceBean.getDeviceId())) {
			throw new DataValidationException(ErrorCodes.DEVICE_ID);
		} else if (StringUtils.isEmpty(deviceBean.getNodeKey())) {
			throw new DataValidationException(ErrorCodes.NODE_KEY);
		} else if (StringUtils.isEmpty(deviceBean.getSapId())) {
			throw new DataValidationException(ErrorCodes.SAP_ID);
		}
		return true;
	}

}
