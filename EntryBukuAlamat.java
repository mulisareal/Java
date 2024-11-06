import java.util.ArrayList;
import java.util.Scanner;

public class EntryBukuAlamat {
    private ArrayList<EntryBukuAlamat> entries;
    private String name;
    private String address;
    private String numphone; 
    private String email;

    private static int BukuAlamat;

    // Constructor default
    public EntryBukuAlamat() {
        entries = new ArrayList<>(100);
    }
    //Method untuk memasukkan data
    public void addEntry(EntryBukuAlamat entry){
        if (entries.size()< 100){
            entries.add(entry);
            System.out.println("Memasukkan data berhasil!");
        }else{
            System.out.println("Buku alamat sudah penuh");
        }
    }

    //Method untuk menghapus data berdasarkan nama
    public void deleteEntry(String name){
        boolean found = false;
        for (EntryBukuAlamat entry : entries){
            if (entry.getName().equalsIgnoreCase(name)){
                entries.remove(entry);
                System.out.println("Menghapus data sukses!");
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Data tidak ditemukan");
        }
    }

    //Method unutk menampilkan data
    public void displayAllEntries(){
        if (entries.isEmpty()){
            System.out.println("Buku alamat kosong ");
        }else{
            System.out.println("== Semua buku alamat ditampilkan ==");
            for (EntryBukuAlamat entry : entries){
                System.out.println("Name: " + entry.getName());
                System.out.println("Address: " + entry.getAddress());
                System.out.println("Email: " + entry.getEmail());
                System.out.println("No.Telepone: " + entry.getNumphone());
                System.out.println("-----------------");
            }
        }
    }
    // 4. Method to update an entry by name
    public void updateEntry(String name, String newAddress, String newEmail, String newNumphone) {
        boolean found = false;
        for (EntryBukuAlamat entry : entries) {
            if (entry.getName().equalsIgnoreCase(name)) {
                entry.setAddress(newAddress);
                entry.setEmail(newEmail);
                entry.setNumphone(newNumphone);
                System.out.println("Entry updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Entry not found!");
        }
    }
    // Constructor dengan parameter
    public EntryBukuAlamat(String name, String address, String email, String numphone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.numphone = numphone;
    }

    // Accessor Methods
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getNumphone() { 
        return numphone;
    }
    public String getEmail() {
        return email;
    }

    // Mutator methods
    public void setName(String temp) {
        name = temp;
    }
    public void setAddress(String temp) {
        address = temp;
    }
    public void setEmail(String temp) {
        email = temp;
    }
    public void setNumphone(String temp) {
        numphone = temp; 
    }
    public static int getBukuAlamat() {
        return BukuAlamat;
    }

    public static void main(String[] args) {
        EntryBukuAlamat studentRecord = new EntryBukuAlamat();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Entry");
            System.out.println("2. Delete Entry");
            System.out.println("3. Display All Entries");
            System.out.println("4. Update Entry");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add Entry
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String numphone = scanner.nextLine();
                    studentRecord.addEntry(new EntryBukuAlamat(name, address, email, numphone));
                    break;
                case 2:
                    // Delete Entry
                    System.out.print("Enter Name to delete: ");
                    String nameToDelete = scanner.nextLine();
                    studentRecord.deleteEntry(nameToDelete);
                    break;
                case 3:
                    // Display All Entries
                    studentRecord.displayAllEntries();
                    break;
                case 4:
                    // Update Entry
                    System.out.print("Enter Name to update: ");
                    String nameToUpdate = scanner.nextLine();
                    System.out.print("Enter New Address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter New Phone Number: ");
                    String newNumphone = scanner.nextLine();
                    studentRecord.updateEntry(nameToUpdate, newAddress, newEmail, newNumphone);
                    break;
                case 5:
                    // Exit
                    System.out.println("Exiting Address Book...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }
    }
}

