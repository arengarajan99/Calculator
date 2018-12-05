package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class StatListL2{
	
	private SimpleDoubleProperty l2;
	
	public StatListL2(double list){
		this.l2 = new SimpleDoubleProperty(list);
	}
	public DoubleProperty l2Property(){
		return l2;
	}
	
	public double getl2() {
		return l2.get();
	}
}
