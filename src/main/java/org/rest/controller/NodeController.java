package org.rest.controller;

import java.util.List;

import org.rest.bean.ListOfIds;
import org.rest.bean.NodeBean;
import org.rest.bean.NodeTreeBean;
import org.rest.bean.Success;
import org.rest.exceptions.DataValidationException;
import org.rest.service.NodeService;
import org.rest.validator.NodeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NodeController {

	@Autowired
	private NodeService nodeService;
	@Autowired
	private NodeValidator nodeValidator;

	@RequestMapping(value = "/createNode", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody NodeBean createNode(@RequestBody NodeBean nodeBean) {
				try {
					if (nodeValidator.validateNode(nodeBean)) {
						return nodeService.createNode(nodeBean);
					}
				} catch (DataValidationException e) {
					e.printStackTrace();
					return new NodeBean(e.getErrorCode());
				}
		return new NodeBean();
	}

	@RequestMapping(value = "/getNodes/{sapNumber}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody NodeTreeBean getNodes(@PathVariable String sapNumber) {
		try {
			return nodeService.getNodes(sapNumber);
		} catch (Exception e) {
			e.printStackTrace();
			return new NodeTreeBean();
		}
	}
	
	@RequestMapping(value = "/deleteNode/{id}", method = RequestMethod.DELETE,  headers = "Accept=application/json")
	public Success getNodeService(@PathVariable String id) {
		return nodeService.deleteNode(id);
	}
	
	@RequestMapping(value="/deleteList", method= {RequestMethod.DELETE, RequestMethod.POST}, headers="Accept=application/json")
	public Success deleteList(@RequestBody ListOfIds listOfIds) {
		if(!StringUtils.isEmpty(listOfIds.getListOfIds())) {
			return nodeService.deleteList(listOfIds.getListOfIds());
		}
		return null;
	}

	public void setNodeService(NodeService nodeService) {
		this.nodeService = nodeService;
	}

	public NodeValidator getNodeValidator() {
		return nodeValidator;
	}

	public void setNodeValidator(NodeValidator nodeValidator) {
		this.nodeValidator = nodeValidator;
	}

}
