package com.cerberus.helpers;


import com.cerberus.enums.LoggerType;

public class Logger {
	
	public void Write(LoggerType logType, String msj) {
		System.out.println(logType.getLogType() + " - " + msj);
	}
}
