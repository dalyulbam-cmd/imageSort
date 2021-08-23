package sort;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;


public class Quicksort {
	
	// �� Ƚ���� ��ȯ Ƚ���� Ȯ���մϴ�. 
	static int compare = 0, change =0; 
	
	// �ڵ��� ����ȭ�� ���� Swap�� static �Լ��� ����ϴ�. 
	public static void swap(int[] array,int x, int y) throws IOException {
		++change; 
		int preliminary = array[x];
		array[x] = array[y];
		array[y] = preliminary;
		
		BufferedImage[][] imageStore = image.ImagePopTest2.imageStore;
		int[] imageArray = image.ImagePopTest2.imageArray;
		BufferedImage mergedImage = image.ImagePopTest2.drawAsArray(imageStore,imageArray);
		image.ImagePopTest2.saveImage(mergedImage);
	}
	
	// subArray���� QuickSort�� �����մϴ�. 
	public static int part(int[] array, int start, int end) throws IOException {
		
		//end���� ���Ŀ� �������� �ʵ��� ����Ǿ����ϴ�. 
		//pivot�� �׻� start point���� �����մϴ�. 
		int pivot = start, low = start+1, high = end-1; 
		
		do {
			
			boolean lowTrue = (array[low] <= array[pivot]);
			boolean highTrue = (array[high] >= array[pivot]);
			
			//1. pivot �ڸ��� ������ low �ڸ��� ���� ������ low�� ���� �ø��ϴ�. 
			//2. pivot �ڸ��� ������ high �ڸ��� ���� ũ�� high�� ���� �����ϴ�. 
			//3. low �ڸ��� ���� pivot���� ���� high �ڸ��� ���� pivot���� ������ ���� swap�մϴ�. 
			//4. low pointer�� high pointer�� �����Ͽ� �쿭�� �ٲ�� �ݺ����� ���������ϴ�. 
			if (lowTrue) ++low; ++compare;
			if (highTrue) --high; ++compare;
			if (!lowTrue && !highTrue) swap(array,low,high); ++change; compare += 2;
			if (low > high) {
				swap(array,pivot,high);
				pivot = high;
				break;
			}
				
		} while(true);
		
		return pivot;
	}
	
	
	public static void QuickSort02(int[] array, int start, int end) throws IOException{
		
		//array�� �Լ� �ܺο��� ����Ǿ����Ƿ�, ���ϰ��� ��� �����մϴ�. 
		//subArray�� ���̰� 2 ������ ��� (1 �Ǵ� 0) Sorting�� ������ ������ �����ϴ�. 
		System.out.println(Arrays.toString(array));
		if (end > start +1) { 
			
			// ��� ȣ���� �̿��մϴ�. 
			int pivot = part(array,start,end);
			QuickSort02(array,start,pivot);
			QuickSort02(array,pivot+1,end);
			

		
		} 
			
	}
}
