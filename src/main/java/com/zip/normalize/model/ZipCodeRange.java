package com.zip.normalize.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ZipRange Model represents each ZipRange in the given list of ZipRanges
 * @author shussain
 *
 */
public class ZipCodeRange implements Serializable{

	/**
	 * upperBoundRange
	 */
	private int lowerBound;
	private int upperBound;
	public int getLowerBound() {
		return lowerBound;
	}
	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}
	public int getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	
	@Override
	public String toString() {
		return "ZipCodeRange [lowerBound=" + lowerBound + ", upperBound=" + upperBound + "]";
	}
	/**
	 * Constructor to take initiate ZipRange.
	 * To create ZipCodeRange, it should have both lowerBound and upperBound
	 * @param lowerBound
	 * @param upperBound
	 */
	public ZipCodeRange(int lowerBound, int upperBound) {
		super();
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	/**
	 * Default Constructor
	 */
	public ZipCodeRange() {
		super();
	}
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCodeRange zipCodeRange = (ZipCodeRange) o;
        return this.lowerBound == zipCodeRange.lowerBound && this.upperBound == zipCodeRange.upperBound;
                
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(lowerBound, upperBound);
    }
	
	/**
	 * Self validation
	 * @return
	 */
	@JsonIgnore
	public boolean isValid()
	{
		if(lowerBound>upperBound)return false;
		if(lowerBound<0 && lowerBound>99999)return false;
		if(upperBound<0 && upperBound>99999)return false;
		return true;
	}
	
	
	
}
