class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canFinish(piles, mid, h)) {
                high = mid;  // try smaller speed
            } else {
                low = mid + 1; // need more speed
            }
        }

        return low; // or high (both same)
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        int hours = 0;

        for (int pile : piles) {
            // Using ceil(pile / speed)
            hours += (pile + speed - 1) / speed;
        }

        return hours <= h;
    }
}
