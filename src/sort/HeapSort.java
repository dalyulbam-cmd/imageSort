package sort;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class HeapSort {
	
	// 비교 횟수와 교환 횟수를 측정합니다. 
	static int compare = 0, change = 0;
	
	// swap 함수를 미리 정의합니다. 
	static void swap(int[] array, int x, int y) throws IOException {
		
		++ change;
		int preliminary = array[x];
		array[x] = array[y];
		array[y] = preliminary;
		
		BufferedImage[][] imageStore = image.ImagePopTest2.imageStore;
		int[] imageArray = image.ImagePopTest2.imageArray;
		BufferedImage mergedImage = image.ImagePopTest2.drawAsArray(imageStore,imageArray);
		image.ImagePopTest2.saveImage(mergedImage);
		
	}
	
	// HeapSort의 강점은 새로운 메모리를 필요로 하지 않는다는 것입니다. 
	// maxHeap은 각 서브트리에서 최대값을 상위 노드로 올려보낸 결과물입니다. 
	// end 값은 연산에 포함하지 않습니다. 
	static void maxHeap(int[] array, int start, int end) throws IOException {
		
		// noSwap은 서브트리 내에서 교환이 없었던 횟수를 의미하며, 임계치에 도달하면 연산을 끝냅니다. 
		int noSwap =0;
		do {
			
			noSwap = 0; 
			for (int i = end-1 ; i> start; i-=2) {
				 
				//System.out.println(Arrays.toString(array));
				//MaxHeap은 subArray의 길이가 짝수인지 홀수인지를 구분합니다. 
				if ((end-start) % 2 == 0) {
					int j = i-1 >> 1;
					
					//subArray의 길이가 짝수이면 마지막 서브트리에는 꼭 한 자리가 모자랍니다.
					if (i == (end-start) -1) {
						++compare;
						if(array[i] > array[j]) swap(array,i,j);
						else ++ noSwap;
					}
					else {
						compare += 2;
						if((array[i] >= array[i+1])&&(array[i] > array[j])) {
							swap(array,i,j);
						}
						else if ((array[i+1] > array[i])&&(array[i+1] > array[j])) {
							swap(array,i+1,j);
						}
						else ++noSwap;
					}
					
				} else {
					int j = i-1 >> 1;
					compare += 2;
					if ((array[i-1] >= array[i])&&(array[i-1] > array[j])) {
						swap(array,i-1,j);
					} else if ((array[i] > array[i-1])&&(array[i] > array[j])) {
						swap(array,i,j);
					}
					else ++noSwap;
				}	
			} 
		
		} while (noSwap < (end-start)/2);
		
	}
	
	//MaxHeap 연산을 끝내면 최상위 노드의 값은 array의 가장 마지막 값과 교환합니다. 
	//그리고 다음 MaxHeap 연산에는 뒤로 보낸 값을 포함하지 않습니다. (오름차순)
	public static void arrange(int[] array) throws IOException {
	
		for (int i=0; i<array.length; i++) {
			maxHeap(array,0,array.length-i);
			swap(array,0,array.length-1-i);
		}
		
	}
	
}
