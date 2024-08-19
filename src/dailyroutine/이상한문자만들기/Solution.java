package dailyroutine.이상한문자만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * main, PRINT_RESULT 는 테스트 케이스 실행 및 결과 확인을 위한 함수입니다.
 * [답안지 복사] 기능을 사용하는 경우 해당 함수들을 제외하며, 답안에 필요한 코드만 복사됩니다.
 * 테스트 케이스 추가 등 함수 내부 변경은 가능하나, 함수 이름 변경시 [답안지 복사] 기능이 제대로 동작하지 않습니다.
 *
 * 또한, 기본 설정으로 [답안지 복사] 사용시 해당 주석과 작성하신 주석을 제외하여 복사됩니다.
 * [주석 복사] 여부는 설정을 통해 변경할 수 있습니다.
 *
 * [도움말 주석] 옵션은 설정을 통해 제거할 수 있습니다.
 *
 * - [답안지 복사]
 *   코드 - 답안지 복사 (기본 단축키 cmd + shift + w)
 *
 * - [도움말 주석]
 *   설정 - 도구 - 프로그래머스 헬퍼 - 도움말 주석
 *
 * - [주석 복사]
 *   설정 - 도구 - 프로그래머스 헬퍼 - 주석 복사
 *
 * GitHub: https://github.com/azqazq195/programmers_helper
 */
class Solution {
    public static void main(String[] args) {
        String s1 = "try hello world";
        String answer1 = "TrY HeLlO WoRlD";
        String result1 = new Solution().solution(s1);
        PRINT_RESULT(1, result1, answer1);
    }

    public static void PRINT_RESULT(int index, String result, String answer) {
        boolean correct = result.equals(answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public String solution(String s) {
        s = "try hello world";
        List<String> words = Arrays.stream(s.split(" ")).toList();
        List<String> finalWords = new ArrayList<>();
        for (String word : words) {
            StringBuilder chars = new StringBuilder();
            for(int i = 0; i<word.length(); i+=2) {
                chars.append(Character.toUpperCase(word.charAt(i)));
                if((i+1)<word.length()) {
                    chars.append(Character.toLowerCase(word.charAt(i+1)));
                }
            }
            finalWords.add(chars.toString());

        }
        System.out.println(finalWords.toString());
        String answer = finalWords.stream().collect(Collectors.joining(" "));

        return answer;
    }
}