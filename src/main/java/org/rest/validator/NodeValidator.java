package org.rest.validator;

import org.rest.bean.NodeBean;
import org.rest.exceptions.DataValidationException;
import org.rest.util.ErrorCodes;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("nodeValidator")
public class NodeValidator {

	public boolean validateNode(NodeBean nodeBean) throws DataValidationException {

		if (StringUtils.isEmpty(nodeBean.getSapId())) {
			throw new DataValidationException(ErrorCodes.SAP_ID);

		} else if (StringUtils.isEmpty(nodeBean.getId())) {
			throw new DataValidationException(ErrorCodes.NODE_KEY);
		}
		return true;
	}

}
