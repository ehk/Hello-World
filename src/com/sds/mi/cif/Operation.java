package com.sds.mi.cif;

/**
 * 
 * @author Lisa
 *
 */
public class Operation{

	// type of operation
	
	public final static int WALKING = 0;
	public final static int JOGGING = 1;
	public final static int UP = 2;
	public final static int DOWN = 3;
	public final static int UNDIFINED = 4;
	
	// probability to be determined to the operation
	double likelihoodWalking;
	double likelihoodJogging;
	double likelihoodUp;
	double likelihoodDown;
	
		
	public double getLikelihoodWalking() {
		return likelihoodWalking;
	}
	public void setLikelihoodWalking(double likelihoodWalking) {
		this.likelihoodWalking = likelihoodWalking;
	}
	public double getLikelihoodJogging() {
		return likelihoodJogging;
	}
	public void setLikelihoodJogging(double likelihoodJogging) {
		this.likelihoodJogging = likelihoodJogging;
	}
	public double getLikelihoodUp() {
		return likelihoodUp;
	}
	public void setLikelihoodUp(double likelihoodUp) {
		this.likelihoodUp = likelihoodUp;
	}
	public double getLikelihoodDown() {
		return likelihoodDown;
	}
	public void setLikelihoodDown(double likelihoodDown) {
		this.likelihoodDown = likelihoodDown;
	}
	public static int getWalking() {
		return WALKING;
	}
	public static int getJogging() {
		return JOGGING;
	}
	public static int getUp() {
		return UP;
	}
	public static int getDown() {
		return DOWN;
	}
	
}
