package editor.cn;
//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。 
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 ke
//y-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 105 
// 最多调用 2 * 105 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 1902 👎 0
	

//2022-02-11 13:21:09
public class P146LruCache{
    public static void main(String[] args) {
        // TO TEST
        LRUCache cache = new P146LruCache().new LRUCache(2);

        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        System.out.println(cache.get(2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        class Node{
            int key;

            int val;

            Node prev;

            Node next;

            Node(int key, int val){
                this.key = key;
                this.val = val;
            }
        }

        int size = 0;

        int capacity;

        Node dummy = new Node(-1, -1);

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node cur = dummy.next;

            while (cur != null && cur.key != key){
                cur = cur.next;
            }

            if (cur == null) return -1;

            Node prev = cur.prev;
            Node next = cur.next;
            if (prev == dummy) {
                return cur.val;
            } else {
                moveToHead(cur);

                return cur.val;
            }
        }

        private void moveToHead(Node cur) {
            Node prev = cur.prev;
            Node next = cur.next;
            Node head = dummy.next;

            dummy.next = cur;
            cur.prev = dummy;
            cur.next = head;
            head.prev = cur;
            prev.next = next;
            if (next != null) next.prev = prev;
        }

        public void put(int key, int value) {
            Node cur = dummy.next;
            Node tail = dummy;
            while (cur != null && cur.key != key){
                cur = cur.next;
                tail = tail.next;
            }

            if (cur != null){
                cur.val = value;
                if (cur.prev != dummy){
                    moveToHead(cur);
                }

                return;
            }

            if (size < capacity){
                addNode(key, value);
                size++;
            }else{
                // 淘汰掉最后一个
                tail.prev.next = null;
                tail.prev = null;
                // 在最前面加一个
                addNode(key, value);
            }
        }

        private void addNode(int key, int value) {
            Node node = new Node(key, value);

            Node head = dummy.next;
            if (head == null) {
                dummy.next = node;
                node.prev = dummy;
            } else {
                dummy.next = node;
                head.prev = node;
                node.next = head;
                node.prev = dummy;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
