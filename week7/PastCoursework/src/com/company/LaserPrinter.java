package com.company;

public class LaserPrinter implements ServicePrinter {

    private String printerName;
    private int Id;
    private int document_count;
    private int Current_Toner_Level;
    private int Current_Paper_Level;

    public LaserPrinter(String printerName, int id, int document_count, int current_Toner_Level, int current_Paper_Level) {
        this.printerName = printerName;
        Id = id;
        this.document_count = document_count;
        Current_Toner_Level = current_Toner_Level;
        Current_Paper_Level = current_Paper_Level;
    }



    @Override
    public void printDocument(Document document) {
        /*if(Current_Paper_Level < Minimum_Toner_Level && document.getNumberOfPages()>Current_Paper_Level)
        {
            System.out.println("Not enough paper");
        }
        else if(Current_Toner_Level < Minimum_Toner_Level && document.getNumberOfPages()>Current_Toner_Level)
        {
            System.out.println("Not enough toner");
        }
        else
        {
            System.out.println("Printing document");
            Current_Paper_Level -= document.getNumberOfPages();
            Current_Toner_Level -= document.getNumberOfPages();
        }*/

        while(Current_Paper_Level < Minimum_Toner_Level && document.getNumberOfPages()>Current_Paper_Level)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Not enough paper");
        }
    }

    @Override
    public void replaceTonerCartridge() {

    }

    @Override
    public void refillPaper() {

    }
}
