package com.cerberus.helpers;


import org.springframework.stereotype.Service;

import com.cerberus.enums.LoggerType;

@Service
public class Logger {
	
	public void Write(LoggerType logType, String msj) {
		System.out.println(logType.getLogType() + " - " + msj);
	}
}
