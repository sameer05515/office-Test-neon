package org.p.test;

public class P {

	public static void main(String[] args) {
		String str1="abc";
		String str2=new String("abc");
		swap(str1, str2);
		
		System.out.println("str1 == "+str1);
		System.out.println("str2 == "+str2);
		
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		
		Employee e1=new Employee(1, "Premendra", "Bangalore");
		Employee e2=new Employee(2, "Narendra", "Rajasthan");
		
		swap(e1, e2);
		
		System.out.println(e1);
		System.out.println(e2);
		
		
	}
	
	private static  void swap(String str1,String str2){
		str1=str1+str2;
	}
	
	private static  void swap(Employee e1,Employee e2){
		String n=e1.name;
		String a=e1.address;
		
		e1.name=e2.name;
		e1.address=e2.address;
		
		e2.name=n;
		e2.address=a;
	}

}


class Employee{
	int id;
	String name;
	String address;
	/**
	 * @param id
	 * @param name
	 * @param address
	 */
	public Employee(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=").append(id).append(", ");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		if (address != null)
			builder.append("address=").append(address);
		builder.append("]");
		return builder.toString();
	}
	
	
}
