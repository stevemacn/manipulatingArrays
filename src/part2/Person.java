package part2;

public class Person {

	private String firstName;
	private String middleInitial;
	private String lastName;
	private int age;
	private String city;
	private String state;
	
	public Person(String firstName, String middleInitial, String lastName,
			int age, String city, String state) {
		super();
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.age = age;
		this.city = city;
		this.state = state;
	}
	@Override
	public boolean equals (Object person) {
		if (this.toString() == person.toString()) {
			return false;
		}
		return true;
		
	}
	  
    public int hashCode()  
        {    
        return this.toString().hashCode();    
    }   
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", middleInitial="
				+ middleInitial + ", lastName=" + lastName + ", age=" + age
				+ ", city=" + city + ", state=" + state + "]";
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
