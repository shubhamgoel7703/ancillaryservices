package com.accenture.ancillary.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AncillaryDataDAL  extends JdbcDaoSupport{
	private static final Logger log = Logger.getLogger(AncillaryDataDAL.class);
	private void closeConnection(Connection jdbcConnection, PreparedStatement preparedStatement) throws SQLException {
		if(jdbcConnection!=null){
			jdbcConnection.close();
		}
		if(preparedStatement!=null){
			preparedStatement.close();
		}
	}
}
