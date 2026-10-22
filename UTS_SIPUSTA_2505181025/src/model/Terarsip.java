package model;

public interface Terarsip {
    String nomorRak();
    String lokasiLantai();
    
    //Default method
    default String ringkasanArsip() {
        return "Lantai: " + lokasiLantai(); 
    }
}