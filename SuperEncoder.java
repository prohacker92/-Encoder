package com.company;


import java.io.IOException;

public interface SuperEncoder {

    byte[] serialize(Object anyBean) throws IOException, InstantiationException;
    Object deserialize(byte[] data) throws InstantiationException, IOException;

}

