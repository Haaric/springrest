package org.rest.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.rest.bean.DeviceAdditionalAttrBean;
import org.rest.bean.DeviceBean;
import org.rest.bean.DeviceServicesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("DeviceDaoImpl")
public class DeviceDaoImpl {

	static final String createDevice = "INSERT INTO DEVICE_INFO VALUES(?,?,?, ?,?,?, ?,?,?)";
	static final String createDeviceAttr = "INSERT INTO DEVICE_ADDL_ATTR VALUES(?,?,?)";
	static final String createDeviceServs = "INSERT INTO DEVICE_SERVICES VALUES(?,?,?, ?,?,?)";
	static final String deleteDevice = "DELETE FROM DEVICE_INFO WHERE DEVICE_ID = ?";
	static final String deleteAttrs = "DELETE FROM DEVICE_ADDL_ATTR WHERE DEVICE_ID= ?";
	static final String deleteDevServs = "DELETE FROM DEVICE_SERVICES WHERE DEVICE_ID= ?";
	static final String updateDevice = "UPDATE DEVICE_INFO SET DEVICE_TYPE=?, INSTALLER_COMP_ID=?, NODE_KEY=?, DEVICE_STATUS=?, FIRMWARE_VERSION_NO=?, CENTAL_STTN_ACCT_NO=?, INSTALLER_USER_ID=?, PARENT_DEVICE_ID=? where DEVICE_ID= ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public DeviceBean createDevice(DeviceBean deviceBean) {
		try {
			if(jdbcTemplate.update(createDevice,
					new Object[] { deviceBean.getDeviceId(), deviceBean.getDeviceType(), deviceBean.getSapId(),
							deviceBean.getNodeKey(), deviceBean.getDeviceStatus(), deviceBean.getFirmWareVersionNo(),
							deviceBean.getCentralStationAccntNo(), deviceBean.getInstalledUserId(),
							deviceBean.getParentDeviceId() })==1) {
			return deviceBean;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void createDeviceAttr(DeviceBean deviceBean) {
		final List<DeviceAdditionalAttrBean> devAddnAttr = deviceBean.getListOfAddnAttributes();

		jdbcTemplate.batchUpdate(createDeviceAttr, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				DeviceAdditionalAttrBean deviceAdditionalAttrBean = devAddnAttr.get(i);
				ps.setString(1, deviceAdditionalAttrBean.getDeviceId());
				ps.setString(2, deviceAdditionalAttrBean.getDeviceAttrName());
				ps.setString(3, deviceAdditionalAttrBean.getDeviceAttrValue());

			}

			@Override
			public int getBatchSize() {
				return devAddnAttr.size();
			}
		});
	}

	public void createDeviceServices(DeviceBean deviceBean) {
		final List<DeviceServicesBean> devSers = deviceBean.getListOfDeviceServices();

		jdbcTemplate.batchUpdate(createDeviceServs, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				DeviceServicesBean deviceServicesBean = devSers.get(i);
				ps.setString(1, deviceServicesBean.getDeviceId());
				ps.setString(2, deviceServicesBean.getServiceCtn());
				ps.setString(3, deviceServicesBean.getServiceEndDate());
				ps.setString(4, deviceServicesBean.getServiceStartDate());
				ps.setString(5, deviceServicesBean.getServiceStatus());
				ps.setString(6, deviceServicesBean.getServiceName());
			}

			@Override
			public int getBatchSize() {
				return devSers.size();
			}
		});
	}

	public int deleteDevice(String deviceId) {
		jdbcTemplate.update(deleteAttrs, deviceId);
		jdbcTemplate.update(deleteDevServs, deviceId);
		return jdbcTemplate.update(deleteDevice, deviceId);
	}

	public DeviceBean updateDevice(DeviceBean deviceBean) {
		if(jdbcTemplate.update(updateDevice,
				new Object[] { deviceBean.getDeviceType(), deviceBean.getSapId(), deviceBean.getNodeKey(),
						deviceBean.getDeviceStatus(), deviceBean.getFirmWareVersionNo(),
						deviceBean.getCentralStationAccntNo(), deviceBean.getInstalledUserId(),
						deviceBean.getParentDeviceId(), deviceBean.getDeviceId() })==1) {
			return deviceBean;
		}
		return null;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

}
