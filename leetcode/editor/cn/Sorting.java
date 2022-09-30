package editor.cn;

import java.util.Arrays;

public class Sorting {

    static class SelectSort{
        public int[] sort(int[] nums){
            int n = nums.length;
            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] < nums[minIdx]){
                        minIdx = j;
                    }
                }
                int tmp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = tmp;
            }
            return nums;
        }
    }

    static class InsertSort{
        public int[] sort(int[] nums){
            int n = nums.length;

            for (int i = 1; i < n; i++) {
                for (int j = i; j > 0; j--) {
                    if (nums[j] < nums[j - 1]){
                        int tmp = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = tmp;
                    }
                }
            }
            return nums;
        }
    }

    static class BubbleSort{
        public int[] sort(int[] nums){
            for (int i = 0; i < nums.length - 1; i++) {
                boolean flag = false;
                for (int j = 0; j < nums.length - i - 1; j++) {
                    if (nums[j] > nums[j + 1]){
                        int tmp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = tmp;
                        flag = true;
                    }
                }

                if (!flag) break;
            }
            return nums;
        }
    }

    static class QuickSort{
        public int[] sort(int[] nums){
            innerSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void innerSort(int[] nums, int left, int right){
            if (left >= right) return;

            int pivot = nums[left], i = left, j = right;
            while (i < j){
                while (i < j && nums[j] >= pivot) j--;
                nums[i] = nums[j];
                while (i < j && nums[i] <= pivot) i++;
                nums[j] = nums[i];
            }
            nums[i] = pivot;

            innerSort(nums, left, i - 1);
            innerSort(nums, i + 1, right);
        }
    }

    static class MergeSort{

        private int[] tmp;

        public int[] sort(int[] nums){
            tmp = new int[nums.length];
            innerSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void innerSort(int[] nums, int left, int right){

            if (left >= right) return;

            int mid = (left + right) / 2;

            innerSort(nums, left, mid);
            innerSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }

        private void merge(int[] nums, int left, int mid, int right){
            int i = left, j = mid + 1;

            for (int k = left; k <= right; k++) {
                if (i > mid){
                    tmp[k] = nums[j++];
                }else if (j > right){
                    tmp[k] = nums[i++];
                }else{
                    if (nums[i] < nums[j]){
                        tmp[k] = nums[i++];
                    }else{
                        tmp[k] = nums[j++];
                    }
                }
            }

            for (int k = left; k <= right; k++) {
                nums[k] = tmp[k];
            }
        }
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{5,3,1,7,8,9,10,2,6,8};
        int[] nums2 = new int[]{8,8,8,7,6,5,4,3,1,2,3,4,5};
        int[] nums3 = new int[]{3,2};

        System.out.println(Arrays.toString(new MergeSort().sort(nums3)));
        System.out.println(Arrays.toString(new MergeSort().sort(nums1)));
        System.out.println(Arrays.toString(new MergeSort().sort(nums2)));
    }
}
