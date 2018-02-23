import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
public static void main(String[] args)
{
	Employee employee = new Employee();
	employee.setId(20);
	employee.setName("john");
	Employee employee2 = null;
	try {
		FileOutputStream file = new FileOutputStream("output.ser");
		ObjectOutputStream outputStream = new ObjectOutputStream(file);
		outputStream.writeObject(employee);
		outputStream.close();
		file.close();
		System.out.println("Object saved");
		FileInputStream fileInputStream = new FileInputStream("output.ser");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		employee2 = (Employee)objectInputStream.readObject();
		objectInputStream.close();
		fileInputStream.close();
		System.out.println("id is "+employee2.getId());
		System.out.println("name is "+employee2.getName());
	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println("Not saved");
	}
}
}
