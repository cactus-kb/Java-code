import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        int[] g = {1, 3, 3, 5, 3, 9, 0};
        int n = 7;
        System.out.println(getValue(g, n));
    }

    public static int getValue(int[] gifts, int n) {
        quickSort(gifts, 0, n - 1);
        int s = gifts[n / 2];
        int num = 0;
        for (int i = 0; i < gifts.length; i++) {
            if (gifts[i] == s) {
                num++;
            }
        }
        if (num > n / 2) {
            return s;
        } else {
            return 0;
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int stard = arr[start];
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && stard <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= stard) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stard;
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }

    public int getValues(int gifts[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(gifts[i])) {
                map.put(gifts[i], map.get(gifts[i] + 1));
            } else {
                map.put(gifts[i], 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.get(gifts[i]) > n / 2) {
                return gifts[i];
            }
        }
        return 0;
    }

    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) {
            return pHead;
        }
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode smallHead = small;
        ListNode bigHead = big;
        ListNode curNode = pHead;

        while (curNode != null) {
            if (curNode.val < x) {
                small.next = curNode;
                small = small.next;
            } else {
                big.next = curNode;
                big = big.next;
            }
            curNode = curNode.next;
        }
        small.next = bigHead.next;
        big.next = null;
        return smallHead.next;


        /*
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode cur = pHead;
        ListNode afterHead = new ListNode(-1);
        ListNode beforeHead = new ListNode(-1);
        ListNode after = afterHead;
        ListNode before = beforeHead;
        while (cur != null) {
            if (cur.val < x) {
                after.next = new ListNode(cur.val);
                after = after.next;
            } else {
                before.next = new ListNode(cur.val);
                before = before.next;
            }
            cur = cur.next;
        }
        cur = after;
        while (cur.next != null && cur.next.val != -1) {
            cur = cur.next;
        }
        cur.next = before.next;
        return after.next;
    }
    */
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
