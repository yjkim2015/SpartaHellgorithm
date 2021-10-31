package org.sparta.hellgorithm.week01.lesson;

import java.util.Scanner;

public class BinarySearch {
    static int binSearch(int[] a, int n , int key) {
        int pl = 0;
        int pr = n -1;

        do {
            int pc = (pl + pr) / 2;
            if ( a[pc] == key ) {
                return pc;
            }
            else if ( a[pc] < key ) {
                pl = pc + 1;
            }
            else if ( a[pc] > key ) {
                pr = pc - 1;
            }
        } while ( pl <= pr );

        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("요솟 수");
        int num = stdIn.nextInt();

        int[] x = new int[num];
        System.out.println("오름차순으로 입력하세요.");
        x[0] = stdIn.nextInt();
        for ( int i = 1; i < num; i++ ) {
            do {
                System.out.println("x[ " + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i-1]);
        }

        System.out.println("검색할 값 : ");
        int ky = stdIn.nextInt();

        int idx = binSearch(x, num, ky);

        if ( idx == -1 ) {
            System.out.println("그 값의 요소가 없습니다.");
        }
        else if ( idx != -1 ){
            System.out.println(ky + "은[는] x[" + idx + " ]에 있습니다.");
        }
    }
}