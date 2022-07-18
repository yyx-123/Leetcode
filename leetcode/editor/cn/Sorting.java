package editor.cn;

import java.util.Arrays;

public class Sorting {

    static class SelectSort{
        public int[] sort(int[] nums){
            for (int i = 0; i < nums.length - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < nums.length; j++) {
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
            for (int i = 1; i < nums.length; i++) {
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

            if (left >= right || left < 0 || right >= nums.length) return;

            int pivot = nums[left];
            int i = left, j = right;
            while (i < j){
                while (i < j && nums[j] >= pivot){
                    j--;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] <= pivot){
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = pivot;

            innerSort(nums, left, i - 1);
            innerSort(nums, i + 1, right);
        }
    }

    static class MergeSort{
        int[] tmp;

        public int[] sort(int[] nums){
            tmp = new int[nums.length];
            innerSort(nums, 0, nums.length - 1);

            return nums;
        }

        private void merge(int[] nums, int start1, int start2, int end){
            int i = start1, j = start2;
            for (int k = start1; k <= end; k++) {
                if (i >= start2){
                    tmp[k] = nums[j];
                    j++;
                }else if (j > end){
                    tmp[k] = nums[i];
                    i++;
                }else{
                    if (nums[i] <= nums[j]){
                        tmp[k] = nums[i];
                        i++;
                    }else{
                        tmp[k] = nums[j];
                        j++;
                    }
                }
            }
            for (int k = start1; k <= end; k++) {
                nums[k] = tmp[k];
            }
        }

        private void innerSort(int[] nums, int left, int right){
            if (left >= right) return;

            int mid = left + (right - left) / 2;
            innerSort(nums, left, mid);
            innerSort(nums, mid + 1, right);
            merge(nums, left, mid + 1, right);
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
