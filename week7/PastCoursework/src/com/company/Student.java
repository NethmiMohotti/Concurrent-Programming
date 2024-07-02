package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Student implements Runnable{

public static final int NUMBER_OF_DOCUMENTS = 5;
    private final Printer printer;
    private final int MAX_DOC_COUNT;
    private final String name;
    private final String threadGroup;
    private final Random random = new Random();
    private Queue<Document> documents;
    private int printedPageCount;

    public Student(String name, String threadGroup, Printer printer) {
        this.name = name;
        this.threadGroup = threadGroup;
        this.printer = printer;
        MAX_DOC_COUNT = NUMBER_OF_DOCUMENTS;
        initDocumentList();
    }

    private void initDocumentList() {
        documents = new LinkedList<>();

        for (int i = 0; i < MAX_DOC_COUNT; i++) {
            Document document = new Document(name, getRandomDocumentNames(), random.nextInt(10) + 1);
            documents.offer(document);
        }
    }

    private String getRandomDocumentNames() {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < (random.nextInt(20) + 5)) {
            int index = (int) (random.nextFloat() * LETTERS.length());
            stringBuilder.append(LETTERS.charAt(index));
        }
        return stringBuilder.toString();
    }

    @Override
    public void run() {
        while (!documents.isEmpty()) {
            Document document = documents.poll();

            System.out.println("Student " + name + " is printing document " + document.toString());

            try {
                printer.printDocument(document);
                printedPageCount += document.getNumberOfPages();

                Thread.sleep(random.nextInt(1000) + 1000);

            } catch (Exception e) {
                System.out.println("Printer out of resources");
            }
        }
        System.out.println("Student " + name + " printed " + printedPageCount + " pages");
    }

    private void printDocument(Document document) {
        printer.printDocument(document);
    }

}
