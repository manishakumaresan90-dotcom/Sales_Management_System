package org.anudip.sms.main;

import org.anudip.sms.controler.Productcontroller;

public class Main {
    public static void main(String[] args) {
        System.out.println("Launching Sales Management System...");
        
        // Launch our new Product menu!
        Productcontroller pc = new Productcontroller();
        pc.displayMenu();
    }
}