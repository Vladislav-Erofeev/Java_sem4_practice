package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RonWeesly implements Magican{
    private String magic;

    @Autowired
    public RonWeesly(@Value("${ronWeesly.magic}") String magic) {
        this.magic = magic;
    }

    @Override
    public String doMagic() {
        return magic;
    }
}
