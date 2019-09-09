import entity.DBEntity;
import repository.DBRepository;

import java.util.List;

public class Launch {

    public static void main(String[] args) {
        DBRepository dbRepository = new DBRepository();
        List<DBEntity> list = dbRepository.getAllData();
        System.out.println(list.size());
        for(int i = 1; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
