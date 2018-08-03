package com.zip.normalize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zip.normalize.model.ZipCodeRangeInput;
import com.zip.normalize.model.ZipCodeRange;
import com.zip.normalize.service.ZipCodeRangeNormalizer;

/**
 * Rest Api which takes a range of Zipcodes with lower and upper bound and normalizes it
 * JSON Request example:
 * {"zipCodeRanges":[{"lowerBound":6,"upperBound":7},{"lowerBound":6,"upperBound":9}]}, it provides output as 
 * {"zipCodeRanges": [{"lowerBound": 6,"upperBound": 9}]}
 * @author shussain
 *
 */

@RestController
@RequestMapping("/zipcoderange")
public class ZipCodeRangeNormalizerController {

	@Autowired
	private ZipCodeRangeNormalizer zipCodeRangeNormalizer;
	
	/**
	 * Rest method to do the zip code normalizing process
	 * @param zipCodeRangeInput
	 * @return
	 */
	@PostMapping("/normalize")
	public ResponseEntity<ZipCodeRangeInput> registerStudentForCourse(
			 @RequestBody ZipCodeRangeInput zipRangeInput) {

		if(zipRangeInput==null)
			return ResponseEntity.badRequest().build();
		
		List<ZipCodeRange> normalizedZipRanges = zipCodeRangeNormalizer.normalize(zipRangeInput.getZipCodeRanges());
		
		if(CollectionUtils.isEmpty(normalizedZipRanges))
		{
			return ResponseEntity.badRequest().build();
			
		}
		
		return new ResponseEntity<ZipCodeRangeInput>(new ZipCodeRangeInput(normalizedZipRanges),HttpStatus.OK);
	}
	
	
}
