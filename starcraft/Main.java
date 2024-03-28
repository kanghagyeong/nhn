import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> tribeList = new ArrayList<>();
        Random r = new Random();

        Scanner sc = new Scanner(System.in);

        System.out.println("종족을 선택하세요 : ");
        String tribe = sc.nextLine();
        User user = new User();
        User computer = new User();

        if (tribe.equals("Terran")) {
            Terran terran = new Terran();

            for (int i = 0; i < 5; i++) {
                Unit unit = terran.add(r.nextInt(3));
                user.unitList.add(unit);
            }
        } else if (tribe.equals("Protos")) {
            Protos protos = new Protos();

            for (int i = 0; i < 4; i++) {
                Unit unit = protos.add(r.nextInt(3));
                user.unitList.add(unit);
            }
        } else if (tribe.equals("Zerg")) {
            Zerg zerg = new Zerg();

            for (int i = 0; i < 8; i++) {
                Unit unit = zerg.add(r.nextInt(3));
                ;
                user.unitList.add(unit);
            }
        }

        tribeList.add("Terran");
        tribeList.add("Protos");
        tribeList.add("Zerg");

        System.out.println(tribeList.get(r.nextInt(3)));

        if (tribe.equals("Terran")) {
            Terran terran = new Terran();

            for (int i = 0; i < 5; i++) {
                Unit unit = terran.add(r.nextInt(3));
                computer.unitList.add(unit);
            }
        } else if (tribe.equals("Protos")) {
            Protos protos = new Protos();

            for (int i = 0; i < 4; i++) {
                Unit unit = protos.add(r.nextInt(3));
                computer.unitList.add(unit);
            }
        } else if (tribe.equals("Zerg")) {
            Zerg zerg = new Zerg();

            for (int i = 0; i < 8; i++) {
                Unit unit = zerg.add(r.nextInt(3));
                computer.unitList.add(unit);
            }
        }

        System.out.println(user);
        System.out.println(computer);

        // 공격~!
        while (!(user.unitList.size() <= 0) || !(computer.unitList.size() <= 0)) {

            int ally = sc.nextInt();
            int enemy = sc.nextInt();

            Unit u = user.unitList.get(ally);
            Unit c = computer.unitList.get(enemy);

            if (u instanceof Flyable) {
                u.attack(c);
            } else if (u instanceof Attackable ) {
                u.attack(c);
            } else if (u instanceof NonFlyable && c instanceof Flyable) {
                System.out.println("공격 실패 !");
            } 

            // user의 유닛 중 방어력이 0 이하인 유닛을 모두 제거
            for (int i = 0; i < user.unitList.size(); i++) {
                Unit unit = user.unitList.get(i);
                if (unit.defensePower <= 0) {
                    user.unitList.remove(i);
                    i--; // 요소가 삭제되었으므로 인덱스를 하나 감소시킴
                }
            }

          

            Unit uu = user.unitList.get(r.nextInt(user.unitList.size()));
            Unit cc = computer.unitList.get(r.nextInt(computer.unitList.size()));

        

            if (cc instanceof Flyable) {
                cc.attack(uu);
            } else if (cc instanceof Attackable ) {
                cc.attack(uu);
            } else if (cc instanceof NonFlyable && uu instanceof Flyable) {
                System.out.println("컴퓨터 공격 실패 !");
            } 

             // computer의 유닛 중 방어력이 0 이하인 유닛을 모두 제거
             for (int i = 0; i < computer.unitList.size(); i++) {
                Unit unit = computer.unitList.get(i);
                if (unit.defensePower <= 0) {
                    computer.unitList.remove(i);
                    i--; // 요소가 삭제되었으므로 인덱스를 하나 감소시킴
                }
            }

            System.out.println("아군 : \n" + user);
            System.out.println("적군 : \n" + computer);

        }

    }
}
