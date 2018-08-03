package com.zip.normalize.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * RestAPI Input Object
 * @author shussain
 *
 */
public class ZipCodeRangeInput implements Serializable{
	
	
	private List<ZipCodeRange> zipCodeRanges;

	public List<ZipCodeRange> getZipCodeRanges() {
		return zipCodeRanges;
	}

	public void setZipCodeRanges(List<ZipCodeRange> zipCodeRanges) {
		this.zipCodeRanges = zipCodeRanges;
	}

	/**
	 * Overloaded constructor with list of zipCoderanges as input
	 * @param zipCodeRanges
	 */
	public ZipCodeRangeInput(List<ZipCodeRange> zipCodeRanges) {
		super();
		this.zipCodeRanges = zipCodeRanges;
	}

	/**
	 * Default Constructor
	 */
	public ZipCodeRangeInput() {
		super();
		this.zipCodeRanges = new ArrayList<ZipCodeRange>();
	}

	@Override
	public String toString() {
		return "ZipCodeRangeInput [zipCodeRanges=" + zipCodeRanges + "]";
	}
	
	

}
