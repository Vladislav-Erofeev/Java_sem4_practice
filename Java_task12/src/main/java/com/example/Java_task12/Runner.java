package com.example.Java_task12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {
    private String fileName1;
    private String fileName2;
    private String string;
    @Override
    public void run(String... args) throws Exception {
        if(string == null)
            string = "null";
        else
            string = ((Integer)(string.hashCode())).toString();

    }

    @PostConstruct
    public void init() {
        System.out.println("Введите название файла: ");
        Scanner scanner = new Scanner(System.in);
        String file_name = scanner.next();
        fileName1 = file_name;
        fileName2 = scanner.next();
        try {
            FileReader fileReader = new FileReader(file_name);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            string = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            string = null;
        }
        catch (Exception e) {
            string = null;
        }
    }

    @PreDestroy
    public void destroy() {
        try {
            FileWriter fileWriter = new FileWriter(fileName2);
            fileWriter.write(string);
            fileWriter.close();
            Files.delete(Path.of(fileName1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// C:/Users/Forex/IdeaProjects/Java_mires_spring/Java_task12/src/main/resources/file1
