package com.company;

import sun.misc.Unsafe;
import java.io.*;
import java.lang.reflect.Field;


public class MyEncoder implements SuperEncoder {

    private long[] primOffset = new long[10];
    private long[] objOffset = new long[10];
    private Class aClass;
    int primCount = 0;
    int objCount = 0;
    private static final Unsafe unsafe;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public byte[] serialize(Object obj) throws IOException, InstantiationException {
        aClass = obj.getClass();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream os = new DataOutputStream(bos);

        Field[] objFilds = obj.getClass().getDeclaredFields();

        for (Field f : objFilds) {

            if (f.getType().isPrimitive()) {
                primOffset [primCount]= unsafe.objectFieldOffset(f);
                os.writeLong(unsafe.getLong(obj, primOffset [primCount]));
                primCount++;
            } else {
                    primOffset[objCount]= unsafe.objectFieldOffset(f);
                    byte[] array = (byte[]) unsafe.getObject(obj, primOffset[objCount]);
                    os.writeInt(array.length);
                    os.write(array);
                    objCount++;
                }
            }
            return bos.toByteArray();
        }


        public Object deserialize ( byte[] stream) throws InstantiationException, IOException {

            Object tempObj = unsafe.allocateInstance(aClass);
            DataInputStream is = new DataInputStream(new ByteArrayInputStream(stream));

            for (int i=0; i<primCount; i++ )
                unsafe.putLong(tempObj, primOffset[i], is.readLong());

            for (int i=0; i<objCount; i++ )  {
                int size = is.readInt();
                byte[] array = new byte[size];
                is.read(array, 0, size);
                unsafe.putObject(tempObj, objOffset[i], array);
            }
            return tempObj;
        }
    }

