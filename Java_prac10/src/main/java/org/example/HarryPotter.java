package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HarryPotter implements Magican{
    private String magic;

    @Autowired
    public HarryPotter(@Value("${harryPotter.magic}")String magic) {
        this.magic = magic;
    }

    public String doMagic() {
        return magic;
    }
}
