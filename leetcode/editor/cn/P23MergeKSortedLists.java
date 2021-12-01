package editor.cn;
//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 
// 👍 1621 👎 0


import java.util.ArrayList;
import java.util.Collections;

//2021-11-29 18:58:41
public class P23MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
        // TO TEST
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode[] lists = {head1, head2, head3};
        ListNode rst = solution.mergeKLists(lists);
        System.out.println(123);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        private ListNode mergeTwoLists(ListNode list1, ListNode list2){
            ListNode head1 = list1, head2 = list2;
            ListNode rst = new ListNode();
            ListNode cur = rst;

            while (head1 != null && head2 != null){
                if (head1.val < head2.val){
                    cur.next = head1;
                    head1 = head1.next;
                }else{
                    cur.next = head2;
                    head2 = head2.next;
                }
                cur = cur.next;
                cur.next = null;
            }
            if (head1 == null) cur.next = head2;
            if (head2 == null) cur.next = head1;

            return rst.next;
        }

        public ListNode mergeKLists(ListNode[] lists) {
            int listNum = lists.length;

            if (listNum > 2){
                ListNode[] subLists1 = new ListNode[listNum / 2];
                ListNode[] subLists2 = new ListNode[listNum - listNum / 2];

                for (int i = 0; i < listNum; i++) {
                    if (i < listNum / 2) subLists1[i] = lists[i];
                    else{
                        subLists2[i - listNum / 2] = lists[i];
                    }
                }

                return mergeTwoLists(mergeKLists(subLists1), mergeKLists(subLists2));
            }else if (listNum == 2){
                return mergeTwoLists(lists[0], lists[1]);
            }else if (listNum == 1){
                return lists[0];
            }else return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
