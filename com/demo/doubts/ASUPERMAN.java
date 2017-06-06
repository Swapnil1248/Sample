package com.demo.doubts;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ASUPERMAN {
	static int MAX_VALUE = 10;
    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);
        int T = reader.readInt();
        for (int t=0; t<T; t++) {
            int N = reader.readInt();
            int M = reader.readInt();
            int[][] P = new int[N][M];
            for (int n=0; n<N; n++) {
                for (int m=0; m<M; m++) {
                    P[n][m] = reader.readInt();
                }
            }
            int[][] B = new int[N][M];
            for (int n=0; n<N; n++) {
                for (int m=0; m<M; m++) {
                    B[n][m] = reader.readInt();
                }
            }
            int[] minPrevious = new int[MAX_VALUE];
            for (int n=N-1; n>=0; n--) {
                int[] min = new int[MAX_VALUE];
                Arrays.fill(min,Integer.MAX_VALUE);
                System.out.println("minPrevious :"+Arrays.toString(minPrevious));
                for (int m=0; m<M; m++) {
                    int toKill = P[n][m];
                    int previous = minPrevious[B[n][m]];
                    for (int i=0; i<MAX_VALUE; i++) {
                        min[i] = Math.min(min[i], Math.max(0, toKill-i)+previous);
                    }
                    System.out.println("min :"+Arrays.toString(min));
                }
                minPrevious = min;
            }
            System.out.println(minPrevious[0]);
        }
    }

    static final class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() throws IOException {
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buf);
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public final int readInt() throws IOException {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
    
}
