package com.sds.mi.cif;

import java.util.HashMap;

public class Sample {

	public String id;
	public int WindowSize = 30;
	String sampleStartId;
	String sampleEndId;
	
	public HashMap<String, Double> featureMap = new HashMap<String, Double>();

	public int operationType = Operation.UNDIFINED;
	public int detectedType = 0;

	public void setOperationType(String contents) {
		String opStr = contents.toUpperCase();
		if (opStr.equals("WALKING")) operationType = Operation.WALKING;
		else if (opStr.equals("JOGGING")) operationType = Operation.JOGGING;
		else if (opStr.equals("UP")) operationType = Operation.UP;
		else if (opStr.equals("DOWN")) operationType = Operation.DOWN;
		else operationType = Operation.UNDIFINED;
	}
	
	public String getOperationType() {
		switch (operationType)
		{
		case Operation.WALKING:
			return "walking";
		case Operation.JOGGING:
			return "jogging";
		case Operation.UP:
			return "up";
		case Operation.DOWN:
			return "down";
		default:
			return "undefined";
		}
	}
}
