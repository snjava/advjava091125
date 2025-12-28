package org.demo;

public class Institute {
    final String name;
    public Institute(String name) {
        this.name = name;
        System.out.println("Institute Object Created..");
    }
    public void printInstituteName() {
        System.out.println("Institute : " + name);
    }
}
