package com.example.Java_spring_task14.dao;

import com.example.Java_spring_task14.models.Manufacture;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManufactureDAO {
    private ArrayList<Manufacture> manufactures;

    public ManufactureDAO() {
        manufactures = new ArrayList<>();
        manufactures.add(new Manufacture(0, "Test1", "Address1"));
        manufactures.add(new Manufacture(1, "Test2", "Address2"));
        manufactures.add(new Manufacture(2, "Test3", "Address3"));
        manufactures.add(new Manufacture(3, "Test4", "Address4"));
        manufactures.add(new Manufacture(4, "Test5", "Address5"));
    }

    public List<Manufacture> findAll() {
        return manufactures;
    }

    public void save(Manufacture manufacture) {
        manufacture.setId(manufactures.size());
        manufactures.add(manufacture);
    }

    public void delete(int id) {
        manufactures.remove(id);
    }
}
