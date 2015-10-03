package Zoffer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Man implements Externalizable{
	String name;
	int age;
	transient int v;
	static int w;
	
	public Man(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void writeExternal(ObjectOutput out) throws IOException{
		out.writeObject(name);
		out.writeInt(age);
	}
	public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException{
		name=(String)in.readObject();
		age=in.readInt();
	}
}
