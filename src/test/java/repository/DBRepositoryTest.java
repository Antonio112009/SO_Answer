package repository;

import entity.DBEntity;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DBRepositoryTest {

    DBRepository dbRepository = new DBRepository();

    @Test
    @Order(1)
    void getAllData() {
        dbRepository.getAllData();
    }

    @Test
    @Order(2)
    void pasteAllData(){
        for(int i = 1; i < 100000; i++) {
            DBEntity dbEntity = new DBEntity();
            dbEntity.setName("test" + i);
            dbRepository.saveData(dbEntity);
        }
    }

    @Test
    @Order(3)
    void getAllData2() {
        List<DBEntity> list = dbRepository.getAllData();
        System.out.println(list.size());
        for(int i = 1; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }



}