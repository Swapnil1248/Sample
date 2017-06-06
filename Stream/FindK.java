package Stream;

/**
 * Created by swapnil on 5/14/2017.
 */
public class FindK {
    public static void main(String[] args){
        int[] a = new int[]{10,20,40,60,109};
        int[] b = new int[]{30,50,100,110,120,130,140};
        int k = 8;
//        int res = FindKth(a,0,a.length-1,b,0,b.length-1,k);
        int res = getkth(a, 0, b, 0, k);
        System.out.println(res);
    }

    public static int getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart >= A.length) return B[bStart + k - 1];
        if (bStart >= B.length) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft
        else
            return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }

    private static int FindKth(int A[], int aL, int aR, int B[], int bL, int bR, int k) {
        if (aL > aR) return B[bL + k - 1];
        if (bL > bR) return A[aL + k - 1];

        int aMid = (aL + aR) / 2;
        int bMid = (bL + bR) / 2;

        if (A[aMid] <= B[bMid]) {
            if (k <= (aMid - aL) + (bMid - bL) + 1)
                return FindKth(A, aL, aR, B, bL, bMid - 1, k);
            else
                return FindKth(A, aMid + 1, aR, B, bL, bR, k - (aMid - aL) - 1);
        }
        else { // A[aMid] > B[bMid]
            if (k <= (aMid - aL) + (bMid - bL) + 1)
                return FindKth(A, aL, aMid - 1, B, bL, bR, k);
            else
                return FindKth(A, aL, aR, B, bMid + 1, bR, k - (bMid - bL) - 1);
        }
    }

    private static int findKLargest(int[] a, int[] b, int as, int ae, int bs, int be, int k){
        int size_a = ae-as+1;
        int size_b = be-bs+1;
        System.out.printf("%d,%d, %d\n", size_a, size_b, k);
        if(size_a > size_b)
            return findKLargest(b,a,bs,be,as,ae,k);
        if(size_a == 0 && size_b > 0 )
            return b[bs+k-1];

        if(k == 1)
            return Math.min(a[as], b[bs]);

        int i =  Math.min(size_a, as + k/2);
        int j =  Math.min(size_b, bs + k/2);
        System.out.printf("%d,%d\n", a[i-1], b[j-1]);
        if(a[i-1] > b[j-1])
            return findKLargest(a, b, as, i, j+1, be, k-j+bs-1);
        else
            return findKLargest(a, b, i+1, ae, bs, j,  k-i+as-1);
    }
}
