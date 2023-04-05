package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class MagicanList {
    private List<Magican> magicans;

    @Autowired
    public MagicanList(List<Magican> magicans) {
        this.magicans = magicans;
    }

    public void magic() {
        Random random = new Random();
        System.out.println(magicans.get(random.nextInt(magicans.size())).doMagic());
    }
}
