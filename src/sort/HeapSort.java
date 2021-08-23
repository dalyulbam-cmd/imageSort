package sort;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class HeapSort {
	
	// �� Ƚ���� ��ȯ Ƚ���� �����մϴ�. 
	static int compare = 0, change = 0;
	
	// swap �Լ��� �̸� �����մϴ�. 
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
	
	// HeapSort�� ������ ���ο� �޸𸮸� �ʿ�� ���� �ʴ´ٴ� ���Դϴ�. 
	// maxHeap�� �� ����Ʈ������ �ִ밪�� ���� ���� �÷����� ������Դϴ�. 
	// end ���� ���꿡 �������� �ʽ��ϴ�. 
	static void maxHeap(int[] array, int start, int end) throws IOException {
		
		// noSwap�� ����Ʈ�� ������ ��ȯ�� ������ Ƚ���� �ǹ��ϸ�, �Ӱ�ġ�� �����ϸ� ������ �����ϴ�. 
		int noSwap =0;
		do {
			
			noSwap = 0; 
			for (int i = end-1 ; i> start; i-=2) {
				 
				//System.out.println(Arrays.toString(array));
				//MaxHeap�� subArray�� ���̰� ¦������ Ȧ�������� �����մϴ�. 
				if ((end-start) % 2 == 0) {
					int j = i-1 >> 1;
					
					//subArray�� ���̰� ¦���̸� ������ ����Ʈ������ �� �� �ڸ��� ���ڶ��ϴ�.
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
	
	//MaxHeap ������ ������ �ֻ��� ����� ���� array�� ���� ������ ���� ��ȯ�մϴ�. 
	//�׸��� ���� MaxHeap ���꿡�� �ڷ� ���� ���� �������� �ʽ��ϴ�. (��������)
	public static void arrange(int[] array) throws IOException {
	
		for (int i=0; i<array.length; i++) {
			maxHeap(array,0,array.length-i);
			swap(array,0,array.length-1-i);
		}
		
	}
	
}
