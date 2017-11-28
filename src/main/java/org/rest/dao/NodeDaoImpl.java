package org.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.rest.bean.DeviceAdditionalAttrBean;
import org.rest.bean.DeviceBean;
import org.rest.bean.DeviceServicesBean;
import org.rest.bean.NodeBean;
import org.rest.exceptions.DatabaseConnectivityException;
import org.rest.util.ErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component("nodeDaoImpl")
public class NodeDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	static final String insertQuery = "INSERT INTO NODE VALUES(?,?,?, ?,?,?, ?,?,?, ?)";
	static final String getNodesQuery = "select * from NODE where INSTALLER_COMP_ID = ?";
	static final String getDevices = "SELECT DEVICE_ID, DEVICE_TYPE, INSTALLER_COMP_ID, NODE_KEY, DEVICE_STATUS, FIRMWARE_VERSION_NO, CENTAL_STTN_ACCT_NO, INSTALLER_USER_ID, PARENT_DEVICE_ID FROM DEVICE_INFO DI where INSTALLER_COMP_ID=?";
	static final String getAttributesList = "select DEVICE_ID, ATTR_NAME, ATTR_VALUE from DEVICE_ADDL_ATTR where DEVICE_ID in (:ids)";
	static final String getServices = "select DEVICE_ID, SERVICE_CTN, SERVICE_END_DATE, SERVICE_START_DATE, SERVICE_STATUS, SERVICE_NAME from DEVICE_SERVICES where DEVICE_ID IN (:ids)";
	static final String deleteNodes = "DELETE FROM NODE WHERE NODE_KEY in (?)";
	static final String getNodeIds = "SELECT NODE_KEY, PARENT_NODE_KEY FROM NODE WHERE INSTALLER_COMP_ID = ?";
	static final String getDeviceIds = "SELECT DEVICE_ID, NODE_KEY FROM DEVICE_INFO WHERE INSTALLER_COMP_ID = ?";
	static final String makeDevicesInactivce = "UPDATE DEVICE_INFO SET DEVICE_STATUS=?, NODE_KEY=? WHERE DEVICE_ID=?";

	@SuppressWarnings("unchecked")
	public List<NodeBean> getNodes(String sapNumber) {
		String[] strArray = { sapNumber };
		return (List<NodeBean>) jdbcTemplate.query(getNodesQuery, strArray, new RowMapper<NodeBean>() {

			@Override
			public NodeBean mapRow(ResultSet rs, int rowNo) throws SQLException {
				NodeBean nodeBean = new NodeBean();
				nodeBean.setId(rs.getInt(1) + "");
				nodeBean.setSapId(rs.getInt(2) + "");
				nodeBean.setName(rs.getString(3));
				nodeBean.setParentId(rs.getInt(4) + "");
				nodeBean.setSiteAddress1(rs.getString(5));
				nodeBean.setSiteAddress2(rs.getString(6));
				nodeBean.setCountry(rs.getString(7));
				nodeBean.setZip(rs.getString(8));
				nodeBean.setPhone(rs.getString(9));
				nodeBean.setNotes(rs.getString(10));
				return nodeBean;
			}
		});

	}

	public List<DeviceBean> getDevices(String sapNumber) {
		String[] strArray = { sapNumber };
		return (List<DeviceBean>) jdbcTemplate.query(getDevices, strArray, new RowMapper<DeviceBean>() {

			@Override
			public DeviceBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				DeviceBean deviceBean = new DeviceBean();
				deviceBean.setDeviceId(rs.getString(1));
				deviceBean.setDeviceType(rs.getString(2));
				deviceBean.setSapId(rs.getInt(3) + "");
				deviceBean.setNodeKey(rs.getInt(4) + "");
				deviceBean.setDeviceStatus(rs.getString(5));
				deviceBean.setFirmWareVersionNo(rs.getString(6));
				deviceBean.setCentralStationAccntNo(rs.getString(7));
				deviceBean.setInstalledUserId(rs.getString(8));
				deviceBean.setParentDeviceId(rs.getString(9));
				return deviceBean;
			}

		});
	}

	public List<DeviceAdditionalAttrBean> getAttributesList(String[] deviceIds) {
		try {
			/*
			 * Integer[] intArray = new Integer[deviceIds.length]; for (int i = 0; i <
			 * deviceIds.length; i++) { intArray[i] = Integer.parseInt(deviceIds[i]); }
			 */
			List<String> intList = Arrays.asList(deviceIds);
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("ids", intList);
			return namedParameterJdbcTemplate.query(getAttributesList, parameters,
					new RowMapper<DeviceAdditionalAttrBean>() {

						@Override
						public DeviceAdditionalAttrBean mapRow(ResultSet rs, int rowNum) throws SQLException {
							DeviceAdditionalAttrBean deviceAdditionalAttrBean = new DeviceAdditionalAttrBean();
							deviceAdditionalAttrBean.setDeviceId(rs.getString(1));
							deviceAdditionalAttrBean.setDeviceAttrName(rs.getString(2));
							deviceAdditionalAttrBean.setDeviceAttrValue(rs.getString(3));
							return deviceAdditionalAttrBean;
						}

					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<DeviceServicesBean> getServicesList(String[] deviceIds) {
		try {
			/*
			 * Integer[] intArray = new Integer[deviceIds.length]; for (int i = 0; i <
			 * deviceIds.length; i++) { intArray[i] = Integer.parseInt(deviceIds[i]); }
			 */
			List<String> intList = Arrays.asList(deviceIds);
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("ids", intList);
			return namedParameterJdbcTemplate.query(getServices, parameters, new RowMapper<DeviceServicesBean>() {

				@Override
				public DeviceServicesBean mapRow(ResultSet rs, int rowNum) throws SQLException {
					DeviceServicesBean deviceServicesBean = new DeviceServicesBean();
					deviceServicesBean.setDeviceId(rs.getString(1));
					deviceServicesBean.setServiceCtn(rs.getString(2));
					deviceServicesBean.setServiceEndDate(rs.getDate(3) + "");
					deviceServicesBean.setServiceStartDate(rs.getDate(4) + "");
					deviceServicesBean.setServiceStatus(rs.getString(5));
					deviceServicesBean.setServiceName(rs.getString(6));
					return deviceServicesBean;
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public NodeBean creatNode(NodeBean nodeBean) {
		try {
			if (jdbcTemplate.update(insertQuery,
					new Object[] { nodeBean.getId(), nodeBean.getSapId(), nodeBean.getName(), nodeBean.getParentId(),
							nodeBean.getSiteAddress1(), nodeBean.getSiteAddress2(), nodeBean.getCountry(),
							nodeBean.getZip(), nodeBean.getPhone(), nodeBean.getNotes() }) != -1) {
				return nodeBean;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new NodeBean();
		}
		return nodeBean;
	}

	public boolean validateSapId(String sapId) {
			if (StringUtils.isEmpty(jdbcTemplate.queryForObject(
					"select INSTALLER_COMP_ID  from INSTALLER_COMPANY where INSTALLER_COMP_ID =?", String.class, sapId))) {
				return false;
			} else {
				return true;
			}
	}

	public List<String[]> getNodeIdWithParents(String sapId) {
		return jdbcTemplate.query(getNodeIds, new Object[] { sapId }, new RowMapper<String[]>() {
			@Override
			public String[] mapRow(ResultSet rs, int rowNum) throws SQLException {
				String[] temp = new String[2];
				temp[0] = rs.getInt(1) + "";
				temp[1] = rs.getInt(2) + "";
				return temp;
			}

		});
	}

	public List<String[]> getDeviceIds(String sapId) {
		return jdbcTemplate.query(getDeviceIds, new Object[] { sapId }, new RowMapper<String[]>() {
			@Override
			public String[] mapRow(ResultSet rs, int rowNum) throws SQLException {
				String[] temp = new String[2];
				temp[0] = rs.getString(1);
				temp[1] = rs.getInt(2) + "";
				return temp;
			}

		});
	}

	public void makeDevInactive(List<String> toBeInactiveDeviceIds) {
		if (toBeInactiveDeviceIds.size() > 0) {
			/*
			 * MapSqlParameterSource parameters = new MapSqlParameterSource();
			 * parameters.addValue("ids", toBeInactiveDeviceIds);
			 */
			for (String string : toBeInactiveDeviceIds) {
				jdbcTemplate.update(makeDevicesInactivce, "inactive", null, string);
			}
		}
	}

	public void deleteNodes(List<String> toBeDeletedNodesIds) {
		if (toBeDeletedNodesIds.size() > 0) {
			String parameters = "";
			for (String string : toBeDeletedNodesIds) {
				parameters = "," + parameters + string;
			}
			jdbcTemplate.update(deleteNodes, Integer.parseInt(parameters.substring(1)));
		}
	}

	public String getSapId(String id) {
		return jdbcTemplate.queryForObject("select INSTALLER_COMP_ID FROM NODE WHERE NODE_KEY = ?", new Object[] { id },
				String.class);
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
