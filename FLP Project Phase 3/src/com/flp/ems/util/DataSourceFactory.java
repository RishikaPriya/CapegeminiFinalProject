package com.flp.ems.util;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DataSourceFactory {
	public static DataSource getDataSource(String dataSourceJndiName) throws ServiceLocatorException {
		DataSource dataSource = null;

		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");

			dataSource = (DataSource) envContext.lookup(dataSourceJndiName);

		} catch (ClassCastException cce) {

			throw new ServiceLocatorException(cce);

		} catch (NamingException ne) {

			throw new ServiceLocatorException(ne);
		}

		return dataSource;

}
}
