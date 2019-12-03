import java.util.*;

public class Test {
    public static void main1(String[] args) {
        int[] arr = new int[] {1,2,3,2,3};
         int ret = singleNumber(arr);
        System.out.println(ret);
    }

    //只出现一次的数字
    //使用集合的方式
    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    //使用异或的方式
    public static int single(int[] num) {
        int tmp = 0;
        for (int i = 0; i < num.length; i++) {
            tmp ^= num[i];
        }
        return tmp;
    }

    //复制带随机指针的链表
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {

        }
        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }
    public static Node copyLinked(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val, null, null);
            map.put(cur,node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    //leetcode771宝石与石头
    public int JewelAndStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char j: J.toCharArray()) {
            set.add(j);
        }
        for (char s: S.toCharArray()) {
            if (set.contains(s)) {
                count++;
            }
        }
        return count;
    }

//    public int JS(String J, String S){
//        Set<Character> set = new HashSet<>();
//        int count = 0;
//        for (int i = 0; i < J.length(); i++) {
//            char ch = J.charAt(i);
//            set.add(ch);
//            for (int j = 0; j < S.length(); j++) {
//                char c = S.charAt(i);
//                if (set.contains(c)) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    //旧键盘
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();//期望的
        String str2 = scanner.nextLine();//实际的
        Set<Character> set = new HashSet<>();
        for (char ch:str1.toUpperCase().toCharArray()
             ) {
            set.add(ch);
        }
        Set<Character> setbroken = new HashSet<>();
        for (char c:str2.toUpperCase().toCharArray()
             ) {
            if (!set.contains(c) && !setbroken.contains(c)) {
                setbroken.add(c);
                System.out.print(c);
            }
        }
    }


    //找到一组数据当中前k个最大的元素
    public static void main(String[] args) {
        int[] arr = new int[] {1,3,4,5,6,7,8,};
        topk(arr,3);
    }
    public static void topk(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;//建小堆
                //return o2 - o1 ;建大堆（找前k个最小元素）
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(arr[i]);
            } else {
                Integer top = priorityQueue.peek();
                if (top != null && top < arr[i]) {
                    priorityQueue.poll();
                    priorityQueue.add(arr[i]);
                }
            }
        }
        System.out.println(priorityQueue);
    }

    //前k个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ret = new ArrayList<>();

        Map<String,Integer> map = new HashMap<>();

        for ( String s : words ) {
            if(map.get(s) == null) {
                map.put(s,1);
            }else {
                map.put(s,map.get(s)+1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {

                    @Override
                    public int compare(Map.Entry<String, Integer> o1,
                                       Map.Entry<String, Integer> o2) {

                        if(o1.getValue().equals(o2.getValue())) {
                            //o1.getKey()  o2.getKey()
                            //单词的频率相同 按照字母顺序排序
                            return  o2.getKey().compareTo(o1.getKey());
                        }
                        return o1.getValue()- o2.getValue();
                    }
                });

        //遍历的是Map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(minHeap.size() < k) {
                minHeap.add(entry);
            }else {
                Map.Entry<String, Integer> top = minHeap.peek();
                if(top!=null && top.getValue().equals(entry.getValue())) {
                    //频率相同的单词-》字母小的放进来
                    if(top.getKey().compareTo(entry.getKey()) > 0) {
                        minHeap.poll();
                        minHeap.add(entry);
                    }
                }else {
                    if(top != null && top.getValue() < entry.getValue()) {
                        minHeap.poll();
                        minHeap.add(entry);
                    }
                }
            }
        }

        for (int i = 0; i < k; i++) {
            String tmp = minHeap.poll().getKey();
            ret.add(0,tmp);
        }
        return ret;
    }
}
