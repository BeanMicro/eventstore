package io.beandev.eventstore.smartcontract;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Validator {
    public static boolean validate(String value) {
        return value != null && !value.isEmpty();
    }

    public static void inspect(InputStream jarInputStream) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(jarInputStream);
        ZipEntry entry;

        while ((entry = zipInputStream.getNextEntry()) != null) {
            String fileName = entry.getName();
            if (fileName.endsWith(".java")) {
                System.out.println("Found source file: " + fileName);
                // Read and process source code from the entry's input stream
                // (available from zipInputStream)
            }
        }
        zipInputStream.close();
    }


}
