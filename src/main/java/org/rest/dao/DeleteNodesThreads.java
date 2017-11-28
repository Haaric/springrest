package org.rest.dao;

public class DeleteNodesThreads implements Runnable{
	
	//private final String deleteQuery = "DELETE FROM NODE WHERE NODE_KEY=?"; 
	
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/
	
	private String id;

	public DeleteNodesThreads() {
		super();
	}

	public DeleteNodesThreads(String id) {
		super();
		this.id = id;
	}

	/*public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
*/
	@Override
	public void run() {
		System.out.println("deleted record with id = "+this.id);
	}
}
