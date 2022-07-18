package editor.cn;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 2063 👎 0
	

//2021-11-29 19:17:50
public class P21MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}
