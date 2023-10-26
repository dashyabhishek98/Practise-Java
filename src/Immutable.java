import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class Address implements Cloneable{
    private String street;
    private String city;
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
final class Employee {
    private final String empName;
    private final int age;
    private final Address address;
    private final List<String> phoneNo;
    private final Map<String,String> metaData;

    public Employee(String empName, int age, Address address, List<String> phoneNo, Map<String, String> metaData) {
        this.empName = empName;
        this.age = age;
        this.address = address;
        this.phoneNo = phoneNo;
        this.metaData = metaData;
    }
    public String getEmpName() {
        return empName;
    }
    public int getAge() {
        return age;
    }
    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }
    public List<String> getPhoneNo() {
        return new ArrayList<>(phoneNo);
    }
    public Map<String, String> getMetaData() {
        return new HashMap<>(metaData);
    }
    public String toString() {
        return this.empName+" "+this.age+" "+this.address.getCity()+" "+this.address.getStreet()+" "+this.phoneNo+" "+this.metaData;
    }
}

public class Immutable {

    public static void main(String[] args) throws CloneNotSupportedException {
        Address a1 = new Address("Moti Mohal", "Kanpur");
        List<String> ph1 = new ArrayList<>();
        ph1.add("26272282");
        Map<String,String> map1 = new HashMap<>();
        map1.put("A","A");
        Employee e1 = new Employee("Abhishek",24,a1,ph1,map1);
        //a1.setStreet("8-Biswa");
        e1.getAddress().setStreet("Gurgaon");
        e1.getPhoneNo().add("46749387");
        e1.getMetaData().put("A","B");
        System.out.println(e1);



    }
}
