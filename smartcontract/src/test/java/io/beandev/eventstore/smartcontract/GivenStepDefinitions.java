package io.beandev.eventstore.smartcontract;

import io.cucumber.java.en.Given;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class GivenStepDefinitions {
    public enum JarType {
        GENERIC
    }

    @Given("an InputStream of a {} JAR file")
    public void anInputStreamOfAJARFile(JarType jarType) throws IOException {
        System.out.println("JarType is " + jarType);
        printClasspath();
        var is = getFileInputStream();
        inspect(is);
    }

    private static FileInputStream getFileInputStream() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource("smartcontract-0.1.0-SNAPSHOT-testdata.jar");
        if (url == null) {
            throw new FileNotFoundException("File " + "smartcontract-1.0-SNAPSHOT-testdata.jar" + " was not found in classpath");
        }
        File file = new File(url.getFile());
        return new FileInputStream(file);
    }

    private static void inspect(InputStream jarInputStream) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(jarInputStream);
        ZipEntry entry;

        while ((entry = zipInputStream.getNextEntry()) != null) {
            String fileName = entry.getName();
            if (fileName.endsWith(".java") && fileName.equals("testapp/testcontext/person/Person.java")) {
                String s = String.format("Entry: %s len %d added %TD",
                        entry.getName(), entry.getSize(),
                        new Date(entry.getTime()));
                System.out.println(s);


                System.out.println("Found source file: " + fileName);
                // Read and process source code from the entry's input stream
                // (available from zipInputStream)
                // Use BufferedReader for better performance
                BufferedReader reader = new BufferedReader(new InputStreamReader(zipInputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("----------------------------------------");
            }
        }
        zipInputStream.close();
    }


    public static void printClasspath() {
        String classpath = System.getProperty("java.class.path");
        String[] paths = classpath.split(File.pathSeparator);

        for (String path : paths) {
            System.out.println(path);
        }

        System.out.println("========");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            Enumeration<URL> resources = classLoader.getResources("");
            while (resources.hasMoreElements()) {
                System.out.println(resources.nextElement());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
