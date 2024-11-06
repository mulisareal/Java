public class StudentRecord {

    private String name;
    private String address;
    private int age;
    private double mathGrade;
    private double englishGrade;
    private double scienceGrade;
    private double average;

    // Menampung nilai dari seluruh kelas
    private static int studentCount;


    public StudentRecord(String name, String address, int age, double mathGrade,
                         double englishGrade, double scienceGrade, double average) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.mathGrade = mathGrade;
        this.englishGrade = englishGrade;
        this.scienceGrade = scienceGrade;
        this.average = average;
        studentCount++;
    }

    public String getName() { // Accessor Method
        return name;
    }

    public void setName(String name) { // Mutator Method
        this.name = name;
    }

    public String getAddress() { // Accessor Method
        return address;
    }

    public void setAddress(String address) { // Mutator Method
        this.address = address;
    }

    public int getAge() { // Accessor Method
        return age;
    }

    public void setAge(int age) { // Mutator Method
        this.age = age;
    }

    public double getMathGrade() { // Accessor Method
        return mathGrade;
    }

    public void setMathGrade(double mathGrade) { // Mutator Method
        this.mathGrade = mathGrade;
    }
    public double getEnglishGrade() { // Accessor Method
        return englishGrade;
    }

    public void setEnglishGrade(double englishGrade) { // Mutator Method
        this.englishGrade = englishGrade;
    }
    public double getScienceGrade() { // Accessor Method
        return scienceGrade;
    }

    public void setScienceGrade(double scienceGrade) { // Mutator Method
        this.scienceGrade = scienceGrade;
    }

//Menghitung nilai rata-rata dari MathGrade, EnglishGrade, dan ScienceGrade
public double getAverage(){
    double result = 0;
    result = ( mathGrade + englishGrade + scienceGrade)/3;
    return result;
}

//Menghasilkan jumlah instance StudentRecord
public static int getStudentCount(){
    return studentCount;
}

public static void main (String[] args){
//Membuat tiga objek StudentRecord
StudentRecord annaRecord = new StudentRecord("Anna ", "Jl.Jeruk ", 16, 82, 87, 91, 87);
StudentRecord beahRecord = new StudentRecord("Beah ", "Jl.Mangga ", 17, 93, 85, 96, 81);
StudentRecord crisRecord = new StudentRecord("Cris ", "Jl.Apel ", 16, 79, 88, 91, 88);

//Menampilkan nama siswa Anna
System.out.println("Nama: " + annaRecord.getName());
System.out.println("Alamat: " + annaRecord.getAddress());
System.out.println("Usia: " + annaRecord.getAge());
System.out.println("Rata-rata: " + annaRecord.getAverage());
System.out.println("Jumlah Siswa: " + annaRecord.getStudentCount() + "\n");

//Menampilkan nama siswa Beah
System.out.println("Nama: " + beahRecord.getName());
System.out.println("Alamat: " + beahRecord.getAddress());
System.out.println("Usia: " + beahRecord.getAge());
System.out.println("Rata-rata: " + beahRecord.getAverage());
System.out.println("Jumlah Siswa: " + beahRecord.getStudentCount() + "\n");

//Menampilkan nama siswa Cris
System.out.println("Nama: " + crisRecord.getName());
System.out.println("Alamat: " + crisRecord.getAddress());
System.out.println("Usia: " + crisRecord.getAge());
System.out.println("Rata-rata: " + crisRecord.getAverage());
System.out.println("Jumlah Siswa: " + crisRecord.getStudentCount() + "\n");
    }
}
