package org.rest.dao;

public class DeleteNodesThreads implements Runnable {

	private String id;

	public DeleteNodesThreads() {
		super();
	}

	public DeleteNodesThreads(String id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("deleted record with id = " + this.id);
	}
}
