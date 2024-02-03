package programmers;

public class 암호해독 {

    public static void main(String[] args) {

        암호해독 solution = new 암호해독();

        String cipher = "dfjardstddetckdaccccdegk";
        int code = 4;

        System.out.println(solution.solution(cipher,code));

    }

    public String solution(String cipher, int code) {
        String answer = "";

        for (int i = code; i <= cipher.length(); i = i + code) {
            answer += cipher.substring(i - 1, i);
        }

        return answer;
    }

}
