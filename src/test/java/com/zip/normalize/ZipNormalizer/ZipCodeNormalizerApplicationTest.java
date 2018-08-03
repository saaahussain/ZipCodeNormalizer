package com.zip.normalize.ZipNormalizer;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zip.normalize.model.ZipCodeRange;
import com.zip.normalize.service.ZipCodeRangeNormalizer;

/**
 * 
 * @author shussain
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZipCodeNormalizerApplicationTest {

	@Autowired
	private ZipCodeRangeNormalizer zipCodeRangeNormalizer;
	
	@Test
	public void assetZipCodeNormalize1() {
		
		List<ZipCodeRange> zipCodeTestRangeInputList = Arrays.asList(
                new ZipCodeRange(99878,99999), 
                new ZipCodeRange(20000,99878));
		List<ZipCodeRange>  zipCodeTestRangeOutputList = zipCodeRangeNormalizer.normalize(zipCodeTestRangeInputList);
        
		assertThat(zipCodeTestRangeOutputList, hasItems(
				new ZipCodeRange(20000, 99999)             
        ));
	}

	
	@Test
	public void assetZipCodeNormalize2() {
		
		List<ZipCodeRange> zipCodeTestRangeInputList1 = Arrays.asList(
                new ZipCodeRange(99878,99999), 
                new ZipCodeRange(11234,65789),
                new ZipCodeRange(11234,65789),
                new ZipCodeRange(99878,99999),
                new ZipCodeRange(95678,99878));
		List<ZipCodeRange>  zipCodeTestRangeOutputList1 = zipCodeRangeNormalizer.normalize(zipCodeTestRangeInputList1);
		System.out.println(zipCodeTestRangeOutputList1.toString());
		assertThat(zipCodeTestRangeOutputList1, hasItems(
				new ZipCodeRange(95678,99999),             
				new ZipCodeRange(11234,65789)));
		
		assertThat(zipCodeTestRangeOutputList1.size(), is(2));
	}
	
	
	@Test
	public void assetZipCodeNormalize3() {
		
		List<ZipCodeRange> zipCodeTestRangeInputList3 = Arrays.asList(
                new ZipCodeRange(94133,94133), 
                new ZipCodeRange(94200,94299),
                new ZipCodeRange(94600,94699)
                );
		List<ZipCodeRange>  zipCodeTestRangeOutputList3 = zipCodeRangeNormalizer.normalize(zipCodeTestRangeInputList3);
		System.out.println(zipCodeTestRangeOutputList3.toString());
		assertThat(zipCodeTestRangeOutputList3, hasItems(
				new ZipCodeRange(94133,94133), 
                new ZipCodeRange(94200,94299),
                new ZipCodeRange(94600,94699)));
		
		assertThat(zipCodeTestRangeOutputList3.size(), is(3));
	}
	
	
	@Test
	public void assetZipCodeNormalize4() {
		
		List<ZipCodeRange> zipCodeTestRangeInputList4 = Arrays.asList(
                new ZipCodeRange(94133,94133), 
                new ZipCodeRange(94200,94299),
                new ZipCodeRange(94226,94399)
                );
		List<ZipCodeRange>  zipCodeTestRangeOutputList4 = zipCodeRangeNormalizer.normalize(zipCodeTestRangeInputList4);
		System.out.println(zipCodeTestRangeOutputList4.toString());
		assertThat(zipCodeTestRangeOutputList4, hasItems(
				new ZipCodeRange(94133,94133), 
                new ZipCodeRange(94200,94399)));
		
		assertThat(zipCodeTestRangeOutputList4.size(), is(2));
	}
	
	
	
}
