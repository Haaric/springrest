package org.rest.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NodeTreeBean {

	private NodeBean nodeBean;
	private List<NodeTreeBean> children;

	public NodeTreeBean(NodeBean nodeBean, List<NodeTreeBean> children) {
		this.nodeBean = nodeBean;
		this.children = children;
	}

	public NodeTreeBean() {
	}

	/*
	 * public void add(NodeTreeBean node) { if (children == null) children = new
	 * ArrayList<NodeTreeBean>(); children.add(node); }
	 */
	public NodeBean getNodeBean() {
		return nodeBean;
	}

	public void setNodeBean(NodeBean nodeBean) {
		this.nodeBean = nodeBean;
	}

	public List<NodeTreeBean> getChildren() {
		return children;
	}

	public void setChildren(List<NodeTreeBean> children) {
		this.children = children;
	}

}
