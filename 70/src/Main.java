public class Main {

    public int getValue(int[] gifts, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (gifts[i] == j) {
                    arr[j] ++;
                }
            }
        }
        int ret = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > (n / 2)) {
                ret = j;
            } else {
                return 0;
            }
        }
        return arr[ret];
    }

    /*
        public int getValue(int[] gifts, int n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1 - i; j--) {
                    if (gifts[j] > gifts[j + 1]) {
                        int tmp = gifts[j];
                        gifts[j] = gifts[j + 1];
                        gifts[j + 1] = tmp;
                    }
                }
            }
            int len = n / 2;
            int mid;
            if (n / 2 == 0) {
                mid = n / 2;
            } else {
                mid = n / 2 + 1;
            }
            if (gifts[mid] > len) {
                return gifts[mid];
            } else {
                return 0;
            }
        }
        */
}
