package com.test.info;

// 定义一个接口，该接口制定一种两个数的比较规则
interface CompareInterface {
	int cmp(int a, int b);
}

// 在Cmp1类中制定升序规则
class Cmp1 implements CompareInterface {
	public int cmp(int a, int b) {
		if (a > b) {
			return 1;
		} else if (a == b) {
			return 0;
		} else
			return -1;
	}
}

class Cmp2 implements CompareInterface {
	public int cmp(int a, int b) {
		if (a < b) {
			return 1;
		} else if (a == b) {
			return 0;
		} else
			return -1;
	}
}

public class Test {
	// 排序方法sortedMed
	// 插入法排序
	public void sortedMed(int[] arr, CompareInterface cmp) {
		// 传入空数组，不起作用，if的筛选作用
		if (arr != null) {
			for (int i = 1; i < arr.length; i++) {
				// 临时存储变量temp,存储j--执行后的值
				int temp = arr[i];
				int j = i;
				if (cmp.cmp(arr[j - 1], temp) == 1) {
					while (j >= 1 && cmp.cmp(arr[j - 1], temp) == 1) {
						arr[j] = arr[j - 1];
						j--;
					}

				}
				// 重新置位j下标值减少后的元素值
				// 该语句置于for循环以内,if(cmp.cmp……){}之外
				arr[j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		// 实例化Test的一个实例，目的是调用插入排序方法
		Test ts = new Test();
		// 数组arr升序排列
		int[] arr = {12, 3, 74, 6, 7, 19, 67};
		ts.sortedMed(arr, new Cmp1());
		//	for循环输出升序排列后的数组
		System.out.print("升序输出数组arr:\n");
		//	jdk 1.5开始引入了for each循环，或者称之为“加强型循环”
		for (int element : arr) {
			System.out.print(element + "\t");
		}
		// 以下是降序输出
		System.out.print("\n降序输出数组arr1:\n");
		//	数组arr1降序排列
		int[] arr1 = {12, 3, 74, 6, 7, 19, 67};
		ts.sortedMed(arr1, new Cmp2());
		// forEach循环降序输出
		for (int element : arr1) {
			System.out.print(element + "\t");
		}
	}
}
