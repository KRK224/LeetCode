class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 배열 복사
        for(int i =0; i< n; i++) {
            nums1[m+i] = nums2[i];
        }
        merge(nums1, 0, m+n -1);
        
    }

    
    public void merge(int[] nums, int start, int end) {
        // 원소가 하나인 경우
        if(start == end)
            return;

        int mid = (start + end) /2;

        merge(nums, start, mid); // 왼쪽
        merge(nums, mid+1, end); // 오른쪽
        
        // 이제 원소가 각각 1 있는 경우부터 머지 시작
        merge(nums, start, mid, end);
    }


    public void merge(int[] nums, int left, int mid, int right) {
        int[] sorted = new int[nums.length];
        int l = left;
        int r = mid + 1;
        int idx = left; // 채울 idx

        while (l <= mid && r <= right) {
            if (nums[l] > nums[r]) {
                sorted[idx++] = nums[r++];
            } else {
                sorted[idx++] = nums[l++];
            }
        }
        // 왼쪽이 먼저 채워진 경우
        if (l > mid) {
            while (r <= right)
                sorted[idx++] = nums[r++];
        } else {
            while (l <= mid)
                sorted[idx++] = nums[l++];
        }

        // 배열 복사
        for (int i = left; i < right + 1; i++) {
            nums[i] = sorted[i];
        }
    }

    public void printArray(int[] arr) {
        System.out.print("[");
        for(int a : arr) {
            System.out.print(a + ", ");
        }
        System.out.print("]");
    }
}