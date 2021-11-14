package org.sparta.hellgorithm.week02.homework.jw;

import org.sparta.hellgorithm.week02.homework.jw.customexception.EmptyIntStackException;
import org.sparta.hellgorithm.week02.homework.jw.customexception.OverflowStackExpception;

import java.util.Arrays;

public class IntStack {

    private int max;    //스택 용량
    private int ptr;    // 스택 포인터  : 스택에 쌓여있는 데이터 수를 나타내는 필드 즉, 배열 stk의 요솟수
    private int[] stk;  // 스택 본체 배열

    /**
     * 스택 배열에 값을 저장
     * @param element
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(n)
     */
    public void push(int element) {
        if (ptr >= max) {
            throw new OverflowStackExpception("포인터값이 용량을 벗어났습니다.");
        }

        stk[ptr] = element;
        ptr++;
    }

    /**
     * 스택 배열에 마지막 값 반환 (스택 내부 요소 및 포인터 변경 사항 있음)
     * @return int
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(n)
     */
    public int pop() {
        if (ptr <= 0) {
            throw new EmptyIntStackException("스택이 비어있습니다.");
        }

        ptr--;
        int element = stk[ptr];
        stk[ptr] = 0;

        return element;
    }

    /**
     * 스택 배열에 마지막 값 반환 (스택 내부 요소 및 포인터 변경 사항 없음)
     * @return int
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(n)
     */
    public int peek() {
        if (ptr <= 0) {
            throw new EmptyIntStackException("스택이 비어있습니다.");
        }
        return stk[ptr - 1];
    }

    /**
     * 스택 배열에 요소 위치 찾기
     * @param element
     * @return int
     * @return -1 : 찾기 실패
     * 시간 복잡도 O(n)
     * 공간 복잡도 O(n)
     */
    public int indexOf(int element) {
        int idx = 0;

        if (ptr <= 0) {
            throw new EmptyIntStackException("스택이 비어있습니다.");
        }

        for (int e : stk) {
            if (e == element) {
                return idx;
            }

            idx++;
        }

        return -1;
    }

    /**
     * 스택 배열 초기화
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(n)
     */
    public void clear() {
        stk = new int[max];
        ptr = 0;
    }

    /**
     * 스택 배열의 용량 반환
     * @return int
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(1)
     */
    public int capacity() {
        return max;
    }

    /**
     * 스택 배열의 데이터 수 반환
     * @return int
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(1)
     * 일반적으로 시간, 공간 둘다 O(n)이 맞을듯 하나 해당 코드상에서는 ptr만 반환해서 O(1)이라 생각 됨
     */
    public int size() {
        return ptr;
    }

    /**
     * 스택 배열이 비어있는지 확인
     * @return boolean
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(1)
     */
    public boolean isEmpty() {
        if (ptr <= 0) {
            return true;
        }

        return false;
    }

    /**
     * 스택 배열이 가득 차있는지 확인
     * @return boolean
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(1)
     */
    public boolean isFull() {
        if (ptr == max) {
            return true;
        }

        return false;
    }

    /**
     * 스택 배열 안에 모든 데이터 표시
     * @return String
     * 시간 복잡도 O(n)
     * 공간 복잡도 O(n)
     */
    public String dump() {
        if (ptr <= 0) {
            throw new EmptyIntStackException("스택이 비어있습니다.");
        }

        return Arrays.toString(stk);
    }

    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];
        }
        catch (OutOfMemoryError e) {
            max = 0;
        }
    }
}
