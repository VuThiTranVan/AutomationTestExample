package example.noneInheritance;

public class NongDan {
	private String name;
	private String gender;
	private String address;

	public NongDan() {
	}

	public NongDan(String name, String gender, String address) {
		this.name = name;
		this.gender = gender;
		this.address = address;
	}

	// Methods
	public void displayInfo(String object_name) {
		System.out.println("\n Toi la object " + object_name);
		System.out.println("\tName: " + getName());
		System.out.println("\tGender: " + getGender());
		System.out.println("\tAddress: " + getAddress());
		System.out.println("__________DONE__________");
	}

	public void introduceMyself() {
		System.out.println("\n_____Toi la Nong Dan ______");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
