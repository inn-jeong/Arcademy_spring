package com.lgy.spring_ex8_4;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class JdbcDriver implements EnvironmentAware, InitializingBean{
	private Environment env;
	private String oracleJdbcDriver;
	private String mysqlJdbcDriver;
	
	@Override
	public void setEnvironment(Environment environment) {
		setEnv(environment);
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		setOracleJdbcDriver(env.getProperty("oracle"));
		setMysqlJdbcDriver(env.getProperty("mysql"));
	}
	
	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public String getOracleJdbcDriver() {
		return oracleJdbcDriver;
	}

	public void setOracleJdbcDriver(String oracleJdbcDriver) {
		this.oracleJdbcDriver = oracleJdbcDriver;
	}

	public String getMysqlJdbcDriver() {
		return mysqlJdbcDriver;
	}

	public void setMysqlJdbcDriver(String mysqlJdbcDriver) {
		this.mysqlJdbcDriver = mysqlJdbcDriver;
	}
}
