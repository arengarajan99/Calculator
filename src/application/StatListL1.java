package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class StatListL1 {
	
	private SimpleDoubleProperty l1;
	
	public StatListL1(double list){
		this.l1 = new SimpleDoubleProperty(list);
	}
	public DoubleProperty l1Property(){
		return l1;
	}
	
	public double getl1() {
		return l1.get();
	}
}
