package com.zip.normalize.service;

import java.util.List;
import com.zip.normalize.model.ZipCodeRange;

/**
 * Abstraction to implement with different algorithms
 * @author shussain
 *
 */
public interface IZipCodeRangeNormalizer {

	public List<ZipCodeRange> normalize(List<ZipCodeRange> inputZipRanges);
}
