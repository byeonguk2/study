package programmers;

public class 개미군단 {

    public static void main(String[] args) {

        개미군단 solution = new 개미군단();

        int hp = 23;

        System.out.println(solution.solution(hp));

    }

    public int solution(int hp) {

        int answer = 0;

        int ant = 5;

        answer = hp/ant;
        hp %= ant;

        int ant2 = 3;

        answer += hp/ant2;
        hp%=ant2;

        int ant3 = 1;

        answer += hp/ant3;

        return answer;
    }

}
