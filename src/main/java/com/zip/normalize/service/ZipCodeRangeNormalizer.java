package com.zip.normalize.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.zip.normalize.model.ZipCodeRange;

/**
 * Problem:
 * Give a collection of 5-digit ZIP code ranges(each range includes both their upper and lower bounds), providing an algorithm
 * that produces the minimum number of ranges required to represent the same restrictions as the input.
 * 
 * Scope:
 * 	Ranges may be provided in arbitrary order
 *  Ranges may or may not overlap
 *   	
 * @author shussain
 *
 */
@Component
public class ZipCodeRangeNormalizer implements IZipCodeRangeNormalizer {
	
	private List<ZipCodeRange> zipCodeRanges;

	/**
	 * Processing each ZipCodeRange
	 * Algorithm:
	 * Each given ZipCodeRange is validated against every other ZipRange in the given input list.
	 * It checks if it falls in a given range, then it adjust the lower and upper bounds
	 * If it doesn't fall it addes to desired zipCodeRange bucket.
	 * @param inputCodeZipRange
	 */
	private void processZipRange(ZipCodeRange inputZipCodeRange)
	{
		if(zipCodeRanges==null)
		{
			zipCodeRanges= new ArrayList<ZipCodeRange>();
			zipCodeRanges.add(inputZipCodeRange);
			return;
		}
		
		 for (ZipCodeRange zipCodeRangeFromBucket:zipCodeRanges) {
	            if (inputZipCodeRange.getLowerBound() <= zipCodeRangeFromBucket.getUpperBound() && 
	            		inputZipCodeRange.getUpperBound() >= zipCodeRangeFromBucket.getLowerBound()) {
	            	zipCodeRangeFromBucket.setLowerBound(Math.min(zipCodeRangeFromBucket.getLowerBound(),inputZipCodeRange.getLowerBound()));
	            	zipCodeRangeFromBucket.setUpperBound(Math.max(zipCodeRangeFromBucket.getUpperBound(),inputZipCodeRange.getUpperBound()));
	            	return;
	            }
	            
	     }
		 zipCodeRanges.add(inputZipCodeRange);
	}
	
	/**
	 * Normalizes input set of ZipCodeRanges
	 * @param inputZipCodeRanges
	 * @return
	 */
	public List<ZipCodeRange> normalize(List<ZipCodeRange> inputZipCodeRanges)
	{
		zipCodeRanges = null;
		
		if(CollectionUtils.isEmpty(inputZipCodeRanges)) return inputZipCodeRanges;
		if(!isInputZipRangeValid(inputZipCodeRanges)) return null;
				
		for(ZipCodeRange inputZipRange : inputZipCodeRanges)
		{
			if(inputZipRange!=null)processZipRange(inputZipRange);
		}
		return zipCodeRanges;
	}
	
	private boolean isInputZipRangeValid(List<ZipCodeRange> inputZipCodeRanges)
	{
		if(CollectionUtils.isEmpty(inputZipCodeRanges)) return false;
		
		for(ZipCodeRange inputZipRange : inputZipCodeRanges)
		{
			if(!inputZipRange.isValid())return false;
		}
		
		return true;
	}
}
