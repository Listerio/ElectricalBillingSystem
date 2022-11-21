package com.persistence.entities.impl;

import com.persistence.entities.Token;

import java.util.Random;

public class DefaultToken implements Token {

    StringBuilder token;
    Random random;
    {
        token=new StringBuilder();
    }

    @Override
    public String getToken() {
        if (checkIfTokenIsNull()) {
            random = new Random();
            for (int i = 0; i < 16; i++) {
                token.append(random.nextInt(10));
            }
        }
         return token.toString();
        }

    private boolean checkIfTokenIsNull(){
        return token.toString().isBlank();
    }

}
