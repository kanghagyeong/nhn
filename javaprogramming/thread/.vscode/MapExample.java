import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // HashMap 생성
        Map<String, Integer> studentScores = new HashMap<>();

        // 맵에 요소 추가
        studentScores.put("Alice", 95);
        studentScores.put("Bob", 87);
        studentScores.put("Charlie", 90);

        // 맵에서 값 가져오기
        int aliceScore = studentScores.get("Alice");
        System.out.println("Alice's score: " + aliceScore);

        // 맵의 크기 확인
        int numberOfStudents = studentScores.size();
        System.out.println("Number of students: " + numberOfStudents);

        // 맵 순회 (keySet 사용)
        System.out.println("Student scores:");
        for (String name : studentScores.keySet()) {
            int score = studentScores.get(name);
            System.out.println(name + ": " + score);
        }

        // 맵 순회 (entrySet 사용)
        System.out.println("Student scores:");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            String name = entry.getKey();
            int score = entry.getValue();
            System.out.println(name + ": " + score);
        }

        // 맵에서 요소 제거
        studentScores.remove("Bob");
        System.out.println("After removing Bob:");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            String name = entry.getKey();
            int score = entry.getValue();
            System.out.println(name + ": " + score);
        }
    }
}
