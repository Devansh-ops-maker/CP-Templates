import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.*;
import java.io.*;

class FastReader {
    BufferedReader gt;
    StringTokenizer st;

    public FastReader() {
        gt = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(gt.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    String nextLine() {
        String str = "";
        try {
            str = gt.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    int[] readIntArray(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = nextInt();
        return res;
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    long[] readLongArray(int n) {
        long[] res = new long[n];
        for (int i = 0; i < n; i++)
            res[i] = nextLong();
        return res;
    }

    String[] readStringArray(int n) {
        String[] str = new String[n];
        for (int i = 0; i < n; i++)
            str[i] = nextLine();

        return str;
    }
    int getGCD(int a,int b)
    {
        if(b==0)
            return a;
        else
            return getGCD(b,a%b);
    }
    long getGCD(long a,long b)
    {
        if(b==0)
            return a;
        else
            return getGCD(b,a%b);
    }
    long factorial(int MAXN,int a,long MOD)
    {
        long []factorial=new long[MAXN+1];
        factorial[0]=1;
        for(int i=1;i<=MAXN;i++)
        {
            factorial[i]=((factorial[i-1]%MOD)*(i%MOD))%MOD;
        }
        return factorial[a];
    }
    long inverse_factorial(long MOD,int MAXN,int a)
    {
        long []factorial=new long[MAXN+1];
        factorial[0]=1;
        for(int i=1;i<=MAXN;i++)
        {
            factorial[i]=((factorial[i-1]%MOD)*(i%MOD))%MOD;
        }
        long []inv_fact=new long[MAXN+1];
        for(int i=0;i<=MAXN;i++)
        {
            inv_fact[i]=inverse(factorial[i],MOD);
        }
        return inv_fact[a];
    }
    long ncr(long MOD,int n,int r,int MAXN)
    {
        long ans=(factorial(MAXN,n,MOD)*(inverse_factorial(MOD,MAXN,r)%MOD)*(inverse_factorial(MOD,MAXN,n-r)%MOD))%MOD;
        return ans;
    }
    long inverse(long a,long MOD)
    {
        return power(a,MOD-2,MOD);
    }
    long power(long a,long pow,long MOD)
    {
        if(pow==0)
            return 1;
        long val=power(a,pow/2,MOD);
        long ans1=((val%MOD)*(val%MOD))%MOD;
        long ans2=((ans1%MOD)*(a%MOD))%MOD;
       return pow%2==0?ans1:ans2;
    }
}