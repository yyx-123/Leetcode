package editor.cn;
//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// -5 * 104 <= nums[i] <= 5 * 104 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 
// 👍 480 👎 0


import java.util.Arrays;

//2022-02-24 12:51:37
public class P912SortAnArray{
    public static void main(String[] args) {
        Solution solution = new P912SortAnArray().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5,1,1,2,0,0})));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int[] sortArray(int[] nums) {

            new QuickSort().sort(nums);

            return nums;
        }

        class QuickSort{
            public void sort(int[] nums){
                qsort(nums, 0, nums.length - 1);
            }

            private void qsort(int[] nums, int left, int right) {
                if (left >= right) return;

                int pivot = nums[left];

                int i = left, j = right;
                while (i < j){
                    while (i < j && nums[j] >= pivot) j--;
                    if (j > i) nums[i] = nums[j];
                    while (i < j && nums[i] <= pivot) i++;
                    if (j > i) nums[j] = nums[i];
                }
                nums[i] = pivot;

                qsort(nums, left, i - 1);
                qsort(nums, i + 1, right);
            }
        }


        class MergeSort{
            int[] temp;

            public void sort(int[] nums){
                temp = new int[nums.length];
                int low = 0, high = nums.length - 1;

                ms(nums, low, high);
            }

            private void ms(int[] nums, int low, int high) {
                if (low >= high){
                    return;
                }

                int mid = (low + high) / 2;
                ms(nums, low, mid);
                ms(nums, mid + 1, high);
                merge(nums, low, mid, high);
            }

            private void merge(int[] nums, int low, int mid, int high) {
                for (int k = low; k <= high; k++) {
                    temp[k] = nums[k];
                }

                int i = low, j = mid + 1;
                for (int k = low; k <= high; k++) {
                    if (i == mid + 1){
                        nums[k] = temp[j++];
                    }else if (j == high + 1){
                        nums[k] = temp[i++];
                    }else{
                        if (temp[i] < temp[j]){
                            nums[k] = temp[i];
                            i++;
                        }else{
                            nums[k] = temp[j];
                            j++;
                        }
                    }
                }
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
