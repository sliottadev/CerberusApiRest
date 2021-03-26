package com.cerberus.enums;

public enum LoggerType {
	
	LOG_START ("Inicio", 1),
	LOG_END ("End", 2),
	LOG_AUDIT ("Audicion", 3),
	LOG_ERROR ("Error", 4);
	
	private String logType;
	private Integer index;
	
	private LoggerType( String lt, Integer i) {
		this.logType = lt;
		this.index = i;
	}
	
	public String getLogType() {
		return logType;
	}
	
	public Integer getIndex() {
		return index;
	}
}
