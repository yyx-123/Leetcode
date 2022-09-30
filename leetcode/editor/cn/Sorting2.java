package editor.cn;

import java.util.Arrays;

public class Sorting2 {

    protected void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    protected void sort(int[] nums){}

    public static void main(String[] args) {
        int[] nums1 = {1,5,6,2,3,7,9,4};
        int[] nums2 = {1,4,5,4,3,6,7,2};
        int[] nums3 = {1,1,2,2,3,3,3,4};
        int[] nums4 = {4,4,3,3,2,2,1,1};

        Sorting2 sort = new QuickSort();
        sort.sort(nums1);
        sort.sort(nums2);
        sort.sort(nums3);
        sort.sort(nums4);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(nums4));
    }
}

class SelectionSort extends Sorting2{
    @Override
    public void sort(int[] nums){
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIdx]){
                    minIdx = j;
                }
            }
            swap(nums, minIdx, i);
        }
    }
}

class BubbleSort extends Sorting2{
    @Override
    public void sort(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swaped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                    swaped = true;
                }
            }
            if (!swaped) break;
        }
    }
}

class InsertSort extends Sorting2{
    @Override
    protected void sort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]){
                    swap(nums, j, j - 1);
                }
            }
        }
    }
}

class MergeSort extends Sorting2{
    int[] tmp;

    @Override
    protected void sort(int[] nums) {
        tmp = new int[nums.length];
        innerSort(nums, 0, nums.length - 1);
    }

    private void innerSort(int[] nums, int l, int r){
        if (l >= r) return;

        int m = (l + r) / 2;
        innerSort(nums, l, m);
        innerSort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r){
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m){
                tmp[k] = nums[j++];
            }else if (j > r){
                tmp[k] = nums[i++];
            }else{
                if (nums[i] < nums[j]){
                    tmp[k] = nums[i++];
                }else{
                    tmp[k] = nums[j++];
                }
            }
        }
        for (int k = l; k <= r; k++) {
            nums[k] = tmp[k];
        }
    }
}

class QuickSort extends Sorting2{
    @Override
    protected void sort(int[] nums) {
        innerSort(nums, 0, nums.length - 1);
    }

    private void innerSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int pivot = nums[l];
        int i = l, j = r;
        while (i < j){
            while (i < j && nums[j] >= pivot) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) i++;
            nums[j] = nums[i];
        }
        nums[i] = pivot;

        innerSort(nums, l, i - 1);
        innerSort(nums, i + 1, r);
    }
}
