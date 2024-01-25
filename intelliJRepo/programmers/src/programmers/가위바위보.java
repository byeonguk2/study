package programmers;

public class 가위바위보 {

    public static void main(String[] args) {

        가위바위보 solution = new 가위바위보();

        String rsp = "205";

        System.out.println(solution.solution(rsp));

    }

    public String solution(String rsp) {

        String[] arr = rsp.split("");

        String answer = "";
        for (String s : arr) {
            if (s.equals("2")){
                answer += "0";
            } else if (s.equals("5")) {
                answer += "2";
            }else {
                answer += "5";
            }
        }

        return answer;
    }

}
