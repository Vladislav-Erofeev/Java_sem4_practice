package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Volandemort implements Magican{
    private String magic;

    @Autowired
    public Volandemort(@Value("${volandemort.magic}") String magic) {
        this.magic = magic;
    }

    public String doMagic() {
        return magic;
    }
}
