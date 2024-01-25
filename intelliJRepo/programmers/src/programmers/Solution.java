package programmers;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int n = 10;

        System.out.println(solution.solution(n));

    }

    public int solution(int n) {

        int answer = 0;
        int idx = 1;

        while (true){
            if((6*idx)%n == 0) {
                answer = idx;
                break;
            }
            idx++;
        }

        return answer;

//        피자는 6조각 10명 = 6*5 = 30/10  = 3;
//
//        (피자조각*idx)%n === 0;

    }


}
