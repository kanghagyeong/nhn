import java.util.ArrayList;
import java.util.List;

public class User {

    List<Unit> unitList = new ArrayList<>();
    
    public User() {
        
    }
    
    @Override
    public String toString() {  //클래스의 정보를 문자열로 출력
        for (Unit unit : unitList) {
            System.out.println(unit);
        }
        return "";
    }
      
}
