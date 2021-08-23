package sort;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class MergeSort {
	
	public static void merge(int[] array, int start, int end) throws IOException {
		int middle = (end+start)/2;
		int left = start, right = middle, pointer = 0;
		int[] arraySorted = new int[end-start];

		do {
			if (array[left] <= array[right]) {
				arraySorted[pointer] = array[left];
				++left;
			} else {
				arraySorted[pointer] = array[right];
				++right;
			}
			pointer = left + right - start - middle ;
		} while (left < middle && right < end);
		
	
		if (left < middle) {
			for (int i = pointer; i < end-start; i++) {
				arraySorted[i] = array[left];
				left++;
			}
		} else if (right < end) {
			for (int i = pointer; i < end-start; i++) {
				arraySorted[i] = array[right];
				right++;
			}
		}
		
		pointer = start;
		for (int i = 0; i<arraySorted.length; i++) {
			array[pointer] = arraySorted[i]; 
			pointer++;
		}
		BufferedImage[][] imageStore = image.ImagePopTest2.imageStore;
		int[] imageArray = image.ImagePopTest2.imageArray;
		BufferedImage mergedImage = image.ImagePopTest2.drawAsArray(imageStore,imageArray);
		image.ImagePopTest2.saveImage(mergedImage);
	}
	
	public static void mergeSort(int[] array, int start, int end) throws IOException {
		
		int middle;
		if (start < end-1) {
			middle = (start + end) /2;
			mergeSort(array, start, middle);
			mergeSort(array, middle, end);
			merge(array,start,end);			
		}

	}

}

