package com.string;

/**
 * Created by swapn on 12/31/2016.
 */
public class LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++ ){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        int end = 0;
        int max = 0;
        String t = new StringBuilder(s).reverse().toString();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > max){
                        end = j;
                        max = dp[i][j];
                    }
                }
            }
        }

        System.out.println(end);
        System.out.println(max);
        String ret = s.substring(end - max, end);
        return ret;
    }

    public static void main(String[] args){
        LongestPalindromicSubString s = new LongestPalindromicSubString();
        String ret = s.longestPalindrome("esbtzjaaijqkgmtaajpsdfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq");
        System.out.println(ret);
    }
}
