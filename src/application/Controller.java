package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.regression.SimpleRegression;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable{
	@FXML
	public TextField input;
	public TextField currentGrade;
	public TextField addL1;
	public TextField addL2;
	public TextField finalWorth;
	public TextField gradeDesired;
	public TextField finalGradeAnswer;
	public TextField prop1Int_x;
	public TextField prop1Int_n;
	public TextField prop1Int_cl;
	public TextField prop2Int_x1;
	public TextField prop2Int_n1;
	public TextField prop2Int_x2;
	public TextField prop2Int_n2;
	public TextField prop2Int_cl;
	public TextField samp1Int_x;
	public TextField samp1Int_sx;
	public TextField samp1Int_n;
	public TextField samp1Int_clData;
	public TextField samp1Int_clStat;
	public TextField samp2Int_x1;
	public TextField samp2Int_sx1;
	public TextField samp2Int_n1;
	public TextField samp2Int_x2;
	public TextField samp2Int_sx2;
	public TextField samp2Int_n2;
	public TextField samp2Int_clData;
	public TextField samp2Int_clStat;
	public TextField prop1Test_Po;
	public TextField prop1Test_x;
	public TextField prop1Test_n;
	public TextField prop2Test_x1;
	public TextField prop2Test_n1;
	public TextField prop2Test_x2;
	public TextField prop2Test_n2;
	public TextField samp1Test_muStat;
	public TextField samp1Test_muData;
	public TextField samp1Test_x;
	public TextField samp1Test_sx;
	public TextField samp1Test_n;
	public TextField samp2Test_x1;
	public TextField samp2Test_sx1;
	public TextField samp2Test_n1;
	public TextField samp2Test_x2;
	public TextField samp2Test_sx2;
	public TextField samp2Test_n2;
	public TextArea prop1Test_answer;
	public TextArea prop1Int_answer;
	public TextArea prop2Int_answer;
	public TextArea prop2Test_answer;
	public TextArea samp1Test_answerStat;
	public TextArea samp1Test_answerData;
	public TextArea samp2Test_answerStat;
	public TextArea samp2Test_answerData;
	public TextArea samp1Int_answerStat;
	public TextArea samp1Int_answerData;
	public TextArea samp2Int_answerStat;
	public TextArea samp2Int_answerData;
	public TextArea linReg;
	public TextArea x2Answer;
	public TextArea xStats;
	public TextArea yStats;
	public TextArea operationArea;
	private Operation oper;
	public boolean isRadian;
	private String storedValue = "0";
	private String leftOp = "";
	private String rightOp = "";
	public ChoiceBox<String> prop1Test_Type;
	public ChoiceBox<String> prop2Test_Type;
	public ChoiceBox<String> samp1Test_TypeStat;
	public ChoiceBox<String> samp1Test_TypeData;
	public ChoiceBox<String> samp2Test_TypeStat;
	public ChoiceBox<String> samp2Test_TypeData;
	public TableView<StatListL1> list1;
	public TableColumn<StatListL1, Double> l1;
	public TableView<StatListL2> list2;
	public TableColumn<StatListL2, Double> l2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		l1.setCellValueFactory(new PropertyValueFactory<StatListL1, Double>("l1"));
		l2.setCellValueFactory(new PropertyValueFactory<StatListL2, Double>("l2"));
		prop1Test_Type.getItems().addAll("≠Po", "<Po", ">Po");
		prop1Test_Type.setValue("≠Po");
		prop2Test_Type.getItems().addAll("≠P2", "<P2", ">P2");
		prop2Test_Type.setValue("≠P2");
		samp1Test_TypeStat.getItems().addAll("≠μo", "<μo", ">μo");
		samp1Test_TypeStat.setValue("≠μo");
		samp1Test_TypeData.getItems().addAll("≠μo", "<μo", ">μo");
		samp1Test_TypeData.setValue("≠μo");
		samp2Test_TypeStat.getItems().addAll("≠μ2", "<μ2", ">μ2");
		samp2Test_TypeStat.setValue("≠μ2");
		samp2Test_TypeData.getItems().addAll("≠μ2", "<μ2", ">μ2");
		samp2Test_TypeData.setValue("≠μ2");
		oper = Operation.DEFAULT;
		isRadian = true;
		
		operationArea.appendText("Operation: DEFAULT" + "\n");
		operationArea.appendText("Radian Mode");
		
		
	}
	
	public void zero(){
		if(!input.getText().equals("0")){
			if(oper == Operation.DEFAULT) leftOp += "0";
			else rightOp += "0";
			input.appendText("0");
		}
	}
	public void one(){
		if(input.getText().equals("0")) input.clear();
		if(oper == Operation.DEFAULT) leftOp += "1";
		else rightOp += "1";
		input.appendText("1");
	}
	public void two(){
		if(input.getText().equals("0")) input.clear();
		if(oper == Operation.DEFAULT) leftOp += "2";
		else rightOp += "2";
		input.appendText("2");
	}
	public void three(){
		if(input.getText().equals("0")) input.clear();
		if(oper == Operation.DEFAULT) leftOp += "3";
		else rightOp += "3";
		input.appendText("3");
	}
	public void four(){
		if(input.getText().equals("0")) input.clear();
		if(oper == Operation.DEFAULT) leftOp += "4";
		else rightOp += "4";
		input.appendText("4");
	}
	public void five(){
		if(input.getText().equals("0")) input.clear();
		if(oper == Operation.DEFAULT) leftOp += "5";
		else rightOp += "5";
		input.appendText("5");
	}
	public void six(){
		if(input.getText().equals("0")) input.clear();
		if(oper == Operation.DEFAULT) leftOp += "6";
		else rightOp += "6";
		input.appendText("6");
	}
	public void seven(){
		if(input.getText().equals("0")) input.clear();
		if(oper == Operation.DEFAULT) leftOp += "7";
		else rightOp += "7";
		input.appendText("7");
	}
	public void eight(){
		if(input.getText().equals("0")) input.clear();
		if(oper == Operation.DEFAULT) leftOp += "8";
		else rightOp += "8";
		input.appendText("8");
	}
	
	public void nine(){
		if(input.getText().equals("0")) input.clear();
		if(oper == Operation.DEFAULT) leftOp += "9";
		else rightOp += "9";
		input.appendText("9");
	}
	public void point(){
		if(input.getText().indexOf(".") == -1){
			if(oper == Operation.DEFAULT) leftOp += ".";
			else rightOp += ".";
			input.appendText(".");
		}
	}
	
	public void value(){
		input.clear();
		input.appendText(this.storedValue);
		if(oper == Operation.DEFAULT) leftOp = this.storedValue;
		else rightOp = this.storedValue;
	}
	public void store(){
		this.storedValue = this.input.getText();
	}
	
	
	public void add(){
		oper = Operation.PLUS;
		if(this.leftOp.length() != 0){
			if(this.rightOp.length() !=0){
				double add = Double.parseDouble(leftOp) + Double.parseDouble(rightOp);
				this.input.clear();
				this.input.appendText(Double.toString(add));
				this.leftOp = Double.toString(add);
				this.rightOp = "";
			}
		}
		changeOperationText("+");
		this.input.clear();
	}
	public void changeOperationText(String oper){
		this.operationArea.clear();
		this.operationArea.appendText("Operation: " + oper + "\n" + (this.isRadian ? "Rad" : "Degree") + " Mode");
	}
	
	public void mod(){
		oper = Operation.MODULOUS;
		if(this.leftOp.length() != 0){
			if(this.rightOp.length() !=0){
				double mod = Double.parseDouble(leftOp) % Double.parseDouble(rightOp);
				this.input.clear();
				this.input.appendText(Double.toString(mod));
				this.leftOp = Double.toString(mod);
				this.rightOp = "";
			}
		}
		changeOperationText("%");
		this.input.clear();
	}
	public void perm(){
		oper = Operation.PERMUTATION;
		if(this.leftOp.length() != 0){
			if(this.rightOp.length() !=0){
				int left = Integer.parseInt(leftOp);
				int right = Integer.parseInt(rightOp);
				int perm = factorial(left)/factorial(left-right);
				this.input.clear();
				this.input.appendText(Double.toString(perm));
				this.leftOp = Double.toString(perm);
				this.rightOp = "";
			}
		}
		changeOperationText("nPr");
		this.input.clear();
	}
	private int factorial(int k){
		if(k == 1 || k == 0) return 1;
		return k * factorial(k-1);
	}
	public void comp(){
		oper = Operation.COMPUTATION;
		if(this.leftOp.length() != 0){
			if(this.rightOp.length() !=0){
				int left = Integer.parseInt(leftOp);
				int right = Integer.parseInt(rightOp);
				int comp = factorial(left)/(factorial(left-right)*factorial(right));
				this.input.clear();
				this.input.appendText(Double.toString(comp));
				this.leftOp = Double.toString(comp);
				this.rightOp = "";
			}
		}

		changeOperationText("nCr");
		this.input.clear();
	}
	
	public void subtract(){
		oper = Operation.SUBTRACT;
		if(this.leftOp.length() != 0){
			if(this.rightOp.length() !=0){
				double sub = Double.parseDouble(leftOp) - Double.parseDouble(rightOp);
				this.input.clear();
				this.input.appendText(Double.toString(sub));
				this.leftOp = Double.toString(sub);
				this.rightOp = "";
			}
		}

		changeOperationText("-");
		this.input.clear();
	}
	
	public void multiply(){
		oper = Operation.MULTIPLY;
		if(this.leftOp.length() != 0){
			if(this.rightOp.length() !=0){
				double multiply = Double.parseDouble(leftOp) * Double.parseDouble(rightOp);
				this.input.clear();
				this.input.appendText(Double.toString(multiply));
				this.leftOp = Double.toString(multiply);
				this.rightOp = "";
			}
		}

		changeOperationText("*");
		this.input.clear();
	}
	
	public void divide(){
		oper = Operation.DIVIDE;
		if(this.leftOp.length() != 0){
			if(this.rightOp.length() !=0){
				double divide = Double.parseDouble(leftOp) / Double.parseDouble(rightOp);
				this.input.clear();
				this.input.appendText(Double.toString(divide));
				this.leftOp = Double.toString(divide);
				this.rightOp = "";
			}
		}

		changeOperationText("/");
		this.input.clear();
	}
	
	public void clear(){
		this.input.clear();
		this.oper = Operation.DEFAULT;
		changeOperationText("DEFAULT");
		this.rightOp = "";
		this.leftOp = "";
	}
	
	public void sin(){
		double in = Double.parseDouble(this.input.getText());
		if(!isRadian) in *=(Math.PI/180);
		double sin = Math.sin(in);
		String sine = Double.toString(sin);
		this.input.clear();
		this.input.appendText(sine);
		if(this.oper != Operation.DEFAULT){
			this.rightOp = sine;
		}else{
			this.leftOp = sine;
		}
	}
	
	public void plusminus(){
			String in = this.input.getText();
			if(in.length() == 0) in+="0";
			double reverse = -1*Double.parseDouble(in);
			String rev = Double.toString(reverse);
			this.input.clear();
			this.input.appendText(rev);
			if(this.oper != Operation.DEFAULT){
				this.rightOp = rev;
			}else{
				this.leftOp = rev;
			}
	}
	public void raddeg(){
		this.operationArea.clear();
		this.isRadian = !this.isRadian;
		this.operationArea.appendText("Operation: " + oper + "\n" + (this.isRadian ? "Rad" : "Degree") + " Mode");
	}
	
	public void inverse(){
		double inverse = 1/Double.parseDouble(this.input.getText());
		String inv = Double.toString(inverse);
		this.input.clear();
		this.input.appendText(inv);
		if(this.oper != Operation.DEFAULT){
			this.rightOp = inv;
		}else{
			this.leftOp = inv;
		}
	}
	
	public void cos(){
		double in = Double.parseDouble(this.input.getText());
		if(!isRadian) in *=(Math.PI/180);
		double cos = Math.cos(in);
		String cosine = Double.toString(cos);
		this.input.clear();
		this.input.appendText(cosine);
		if(this.oper != Operation.DEFAULT){
			this.rightOp = cosine;
		}else{
			this.leftOp = cosine;
		}
	}
	
	public void tan(){
		double in = Double.parseDouble(this.input.getText());
		if(!isRadian) in *=(Math.PI/180);
		double tan = Math.tan(in);
		String tangent = Double.toString(tan);
		this.input.clear();
		this.input.appendText(tangent);
		if(this.oper != Operation.DEFAULT){
			this.rightOp = tangent;
		}else{
			this.leftOp = tangent;
		}
	}
	public void arcsin(){
		double arcsin = Math.asin(Double.parseDouble(this.input.getText()));
		if(!isRadian) arcsin *= (180/Math.PI);
		String arcsine = Double.toString(arcsin);
		this.input.clear();
		this.input.appendText(arcsine);
		if(this.oper != Operation.DEFAULT){
			this.rightOp = arcsine;
		}else{
			this.leftOp = arcsine;
		}
	}
	
	public void arccos(){
		double arccos = Math.acos(Double.parseDouble(this.input.getText()));
		if(!isRadian) arccos *= (180/Math.PI);
		String arccosine = Double.toString(arccos);
		this.input.clear();
		this.input.appendText(arccosine);
		if(this.oper != Operation.DEFAULT){
			this.rightOp = arccosine;
		}else{
			this.leftOp = arccosine;
		}
	}
	
	public void arctan(){
		double arctan = Math.atan(Double.parseDouble(this.input.getText()));
		if(!isRadian) arctan *= (180/Math.PI);
		String arctangent = Double.toString(arctan);
		this.input.clear();
		this.input.appendText(arctangent);
		if(this.oper != Operation.DEFAULT){
			this.rightOp = arctangent;
		}else{
			this.leftOp = arctangent;
		}
	}
	
	public void log(){
		double log = Math.log10(Double.parseDouble(this.input.getText()));
		String log10 = Double.toString(log);
		this.input.clear();
		this.input.appendText(log10);
		this.leftOp = log10;
	}
	public void abs(){
		double abs = Math.abs(Double.parseDouble(this.input.getText()));
		String absol = Double.toString(abs);
		this.input.clear();
		this.input.appendText(absol);
		if(this.oper != Operation.DEFAULT){
			this.rightOp = absol;
		}else{
			this.leftOp = absol;
		}
	}
	public void pi(){
		this.input.clear();
		this.input.appendText(Double.toString(Math.PI));
		if(this.oper != Operation.DEFAULT){
			this.rightOp = Double.toString(Math.PI);
		}else{
			this.leftOp = Double.toString(Math.PI);
		}
	}
	public void e(){
		this.input.clear();
		this.input.appendText(Double.toString(Math.E));
		if(this.oper != Operation.DEFAULT){
			this.rightOp = Double.toString(Math.E);
		}else{
			this.leftOp = Double.toString(Math.E);
		}
	}
	public void rand(){
		this.input.clear();
		double rand = Math.random();
		this.input.appendText(Double.toString(rand));
		if(this.oper != Operation.DEFAULT){
			this.rightOp = Double.toString(rand);
		}else{
			this.leftOp = Double.toString(rand);
		}
	}
	
	
	public void power(){
		oper = Operation.POW;
		if(this.leftOp.length() != 0){
			if(this.rightOp.length() !=0){
				double pow = Math.pow(Double.parseDouble(leftOp),Double.parseDouble(rightOp));
				this.input.clear();
				this.input.appendText(Double.toString(pow));
				this.leftOp = Double.toString(pow);
				this.rightOp = "";
			}
		}

		changeOperationText("^");
		this.input.clear();
	}
	
	public void root(){
		double root = Math.sqrt(Double.parseDouble(this.input.getText()));
		String rootstr = Double.toString(root);
		this.input.clear();
		this.input.appendText(rootstr);
		if(this.oper != Operation.DEFAULT){
			this.rightOp = rootstr;
		}else{
			this.leftOp = rootstr;
		}
	}
	
	public void factorial(){
		int factorial = this.factorial(Integer.parseInt(this.input.getText()));
		String factor = Integer.toString(factorial);
		this.input.clear();
		this.input.appendText(factor);
		if(this.oper != Operation.DEFAULT){
			this.rightOp = factor;
		}else{
			this.leftOp = factor;
		}
	}
	
	public void ln(){
		double naturallog = Math.log(Double.parseDouble(this.input.getText()));
		String lognat = Double.toString(naturallog);
		this.input.clear();
		this.input.appendText(lognat);
		if(this.oper != Operation.DEFAULT){
			this.rightOp = lognat;
		}else{
			this.leftOp = lognat;
		}
	}
	
	public void prop1ZInt_calc(){
		this.prop1Int_answer.clear();
		if(this.prop1Int_cl.getText().length() == 0 || this.prop1Int_n.getText().length() == 0 || this.prop1Int_x.getText().length() == 0){
			this.prop1Int_answer.appendText("Fill out all the fields");
			return;
		}
		double x = Double.parseDouble(this.prop1Int_x.getText());
		double n = Double.parseDouble(this.prop1Int_n.getText());
		double cl = Double.parseDouble(this.prop1Int_cl.getText());
		if(cl > 1) cl /=100;
		double phat = x/n;
		NormalDistribution normal = new NormalDistribution();
		double zstar = normal.inverseCumulativeProbability(cl + (1-cl)/2);
		double stdev = Math.sqrt(phat*(1-phat)/n);
		double lowerBound = phat - zstar*stdev;
		double upperBound = phat + zstar*stdev;
		this.prop1Int_answer.appendText("(" + lowerBound + "," + upperBound + ")" + "\nP: " + phat + "\nN: " + n);
	}
	
	public void prop2ZInt_calc(){
		this.prop2Int_answer.clear();
		if(this.prop2Int_cl.getText().length()==0 || this.prop2Int_x1.getText().length()==0 || this.prop2Int_x2.getText().length()==0|| this.prop2Int_n1.getText().length()==0|| this.prop2Int_n2.getText().length()==0){
			this.prop2Int_answer.appendText("Fill out all the fields");
			return;
		}
		double x1 = Double.parseDouble(this.prop2Int_x1.getText());
		double n1 = Double.parseDouble(this.prop2Int_n1.getText());
		double x2 = Double.parseDouble(this.prop2Int_x2.getText());
		double n2 = Double.parseDouble(this.prop2Int_n2.getText());
		double cl = Double.parseDouble(this.prop2Int_cl.getText());
		if(cl > 1) cl /=100;
		double p1 = x1/n1;
		double p2 = x2/n2;
		double stdev = Math.sqrt(p1*(1-p1)/n1 + p2 *(1-p2)/n2);
		NormalDistribution normal = new NormalDistribution();
		double zstar = normal.inverseCumulativeProbability(cl + (1-cl)/2);
		double diff = p1-p2;
		double lowerBound = diff - zstar*stdev;
		double upperBound = diff + zstar*stdev;
		this.prop2Int_answer.appendText("(" + lowerBound + "," + upperBound + ")" + "\nP1: "+ p1 + "\nP2: " + p2 + "\nN1: " + n1 + "\nN2: " + n2);
	}
	public void samp1Int_calcData(){
		this.samp1Int_answerData.clear();
		if(this.list1.getColumns().size() == 0 || this.samp1Int_clData.getText().length() == 0){
			this.samp1Int_answerData.appendText("Fill out all the fields");
			return;
		}
		double cl = Double.parseDouble(this.samp1Int_clData.getText());
		if(cl > 1) cl/=100;
		double total = 0;
		for(StatListL1 st: list1.getItems()){
			total += st.getl1();
		}
		double x = total/list1.getItems().size();
		double variance = 0;
		for(StatListL1 st: list1.getItems()){
			variance += Math.pow(st.getl1()-x,2);
		}
		double sx = Math.sqrt(variance/(list1.getItems().size()-1));
		TDistribution t = new TDistribution(list1.getItems().size()-1);
		double tstar = t.inverseCumulativeProbability(cl + (1-cl)/2);
		double lowerBound = x - tstar*sx/Math.sqrt(list1.getItems().size());
		double upperBound = x + tstar*sx/Math.sqrt(list1.getItems().size());
		this.samp1Int_answerData.appendText("(" + lowerBound +","+ upperBound + ")" + "\nX: " + x + "\nSx: " + sx + "\nN: " + list1.getItems().size());
		
	}
	public void samp1Int_calcStat(){
		this.samp1Int_answerStat.clear();
		if(this.samp1Int_clStat.getText().length() == 0 || this.samp1Int_x.getText().length() == 0 || this.samp1Int_sx.getText().length() == 0 || this.samp1Int_n.getText().length() == 0){
			this.samp1Int_answerStat.appendText("Please fill out all fields");
			return;
		}
		double x = Double.parseDouble(this.samp1Int_x.getText());
		double sx = Double.parseDouble(this.samp1Int_sx.getText());
		int n = Integer.parseInt(this.samp1Int_n.getText());
		double cl = Double.parseDouble(this.samp1Int_clStat.getText());
		if(cl > 1) cl/=100;
		TDistribution t = new TDistribution(n-1);
		double tstar = t.inverseCumulativeProbability(cl + (1-cl)/2);
		double lowerBound = x - tstar*sx/Math.sqrt(n);
		double upperBound = x + tstar*sx/Math.sqrt(n);
		this.samp1Int_answerStat.appendText("(" + lowerBound +","+ upperBound + ")" + "\nX: " + x + "\nSx: " + sx + "\nN: " + n);
		
	}
	public void samp2Int_calcStat(){
		this.samp2Int_answerStat.clear();
		if(this.samp2Int_clStat.getText().length() == 0 || this.samp2Int_n1.getText().length() == 0 || this.samp2Int_sx1.getText().length() == 0 ||this.samp2Int_x1.getText().length() == 0 ||this.samp2Int_sx2.getText().length() == 0 ||this.samp2Int_x2.getText().length() == 0 ||this.samp2Int_n2.getText().length() == 0){
			this.samp2Int_answerStat.appendText("Please fill out all fields");
			return;
		}
		double x1 = Double.parseDouble(this.samp2Int_x1.getText());
		double sx1 = Double.parseDouble(this.samp2Int_sx1.getText());
		double n1 = Double.parseDouble(this.samp2Int_n1.getText());
		double x2 = Double.parseDouble(this.samp2Int_x2.getText());
		double sx2 = Double.parseDouble(this.samp2Int_sx2.getText());
		double n2 = Double.parseDouble(this.samp2Int_n2.getText());
		double cl = Double.parseDouble(this.samp2Int_clStat.getText());
		if(cl > 1) cl/=100;
		double mean = x1-x2;
		double serror = Math.sqrt(Math.pow(sx1, 2)/n1 + Math.pow(sx2, 2)/n2);
		double upper = Math.pow((Math.pow(sx1, 2)/n1 + Math.pow(sx2, 2)/n2),2);
		double lowerLeft = Math.pow(sx1, 4)/((n1-1)*n1*n1);
		double lowerRight = Math.pow(sx2, 4)/((n2-1)*n2*n2);
		double df = upper/(lowerLeft + lowerRight);
		TDistribution t = new TDistribution(df);
		double tstar = t.inverseCumulativeProbability(cl + (1-cl)/2);
		double lowerBound = mean - tstar*serror;
		double upperBound = mean + tstar*serror;
		this.samp2Int_answerStat.appendText("(" + lowerBound + "," + upperBound + ")" + "\nDF: " + df);
	}
	
	public void samp2Int_calcData(){
		this.samp2Int_answerData.clear();
		if(this.list1.getItems().size() == 0 || this.list2.getItems().size() == 0 || this.samp2Int_clData.getText().length() == 0){
			this.samp2Int_answerData.appendText("Please fill in the lists and confidence level");
			return;
		}
		double total1 = 0;
		double n1 = list1.getItems().size();
		for(StatListL1 st: list1.getItems()){
			total1 += st.getl1();
		}
		double x1 = total1/n1;
		double variance = 0;
		for(StatListL1 st: list1.getItems()){
			variance += Math.pow(st.getl1()-x1,2);
		}
		double sx1 = Math.sqrt(variance/(n1-1));
		double total2 = 0;
		double n2 = list2.getItems().size();
		for(StatListL2 st: list2.getItems()){
			total2 += st.getl2();
		}
		double x2 = total2/n2;
		double variance2 = 0;
		for(StatListL2 st: list2.getItems()){
			variance2 += Math.pow(st.getl2()-x2,2);
		}
		double sx2 = Math.sqrt(variance2/(n2-1));
		double mean = x1-x2;
		double serror = Math.sqrt(Math.pow(sx1, 2)/n1 + Math.pow(sx2, 2)/n2);
		double cl = Double.parseDouble(this.samp2Int_clData.getText());
		double upper = Math.pow((Math.pow(sx1, 2)/n1 + Math.pow(sx2, 2)/n2),2);
		double lowerLeft = Math.pow(sx1, 4)/((n1-1)*n1*n1);
		double lowerRight = Math.pow(sx2, 4)/((n2-1)*n2*n2);
		double df = upper/(lowerLeft + lowerRight);
		TDistribution t = new TDistribution(df);
		double tstar = t.inverseCumulativeProbability(cl + (1-cl)/2);
		double lowerBound = mean - tstar*serror;
		double upperBound = mean + tstar*serror;
		this.samp2Int_answerData.appendText("(" + lowerBound + "," + upperBound + ")" + "\nDF: " + df + "\nX1: " + x1+ "\nX2: " + x2+ "\nSx1: " + sx1+ "\nSx2: " + sx2+ "\nN1: " + n1+ "\nN2: " + n1);
	}
	
	public void prop1Test_calc(){
		this.prop1Test_answer.clear();
		if(this.prop1Test_n.getText().length() == 0 || this.prop1Test_x.getText().length() == 0 || this.prop1Test_Po.getText().length() == 0){
			this.prop1Test_answer.appendText("Please fill out all fields");
			return;
		}
		double sDev = Math.sqrt(Double.parseDouble(this.prop1Test_Po.getText()) * (1-Double.parseDouble(this.prop1Test_Po.getText())) / Double.parseDouble(this.prop1Test_n.getText()));
		double zValue = ((Double.parseDouble(this.prop1Test_x.getText())/Double.parseDouble(this.prop1Test_n.getText())) - Double.parseDouble(this.prop1Test_Po.getText()))/sDev;
		NormalDistribution n = new NormalDistribution();
		double pValue = n.probability(Math.abs(zValue), 10000000);
		if(this.prop1Test_Type.getValue().equals("≠Po")) pValue *= 2;
		this.prop1Test_answer.appendText("Z: " + zValue +  "\nP: " + pValue);
	
	}
	
	public void prop2Test_calc(){
		this.prop2Test_answer.clear();
		if(this.prop2Test_n1.getText().length() == 0 || this.prop2Test_x1.getText().length() == 0 || this.prop2Test_x2.getText().length() == 0 || this.prop2Test_n2.getText().length() == 0){
			this.prop2Test_answer.appendText("Please fill out all fields");
			return;
		}
		double x1 = Double.parseDouble(this.prop2Test_x1.getText());
		double x2 = Double.parseDouble(this.prop2Test_x2.getText());
		double n1 = Double.parseDouble(this.prop2Test_n1.getText());
		double n2 = Double.parseDouble(this.prop2Test_n2.getText());
		double Pc = (x1+x2)/(n1+n2);
		double sDev = Math.sqrt((1/n1 + 1/n2)*Pc*(1-Pc));
		double zValue = (x1/n1 - x2/n2)/sDev;
		NormalDistribution n = new NormalDistribution();
		double pValue = n.probability(Math.abs(zValue), 10000000);
		if(this.prop2Test_Type.getValue().equals("≠P2")) pValue *= 2;
		this.prop2Test_answer.appendText("Z: " + zValue + "\nP: " + pValue);
	
	}
	
	public void samp1Test_calcStat(){
		this.samp1Test_answerStat.clear();
		if(this.samp1Test_muStat.getText().length() == 0 || this.samp1Test_x.getText().length() == 0 || this.samp1Test_sx.getText().length() == 0 || this.samp1Test_n.getText().length() == 0){
			this.samp1Test_answerStat.appendText("Please fill out all fields");
			return;
		}
		double mu = Double.parseDouble(this.samp1Test_muStat.getText());
		double x = Double.parseDouble(this.samp1Test_x.getText());
		double sx = Double.parseDouble(this.samp1Test_sx.getText());
		double n = Double.parseDouble(this.samp1Test_n.getText());
		double tValue = (x-mu)/(sx/Math.sqrt(n));
		TDistribution t = new TDistribution(n-1);
		double pValue = t.probability(Math.abs(tValue), 10000000);
		if(this.samp1Test_TypeStat.getValue().equals("≠μo")) pValue*=2;
		this.samp1Test_answerStat.appendText("T: " + tValue + "\nP: " + pValue);
		
	}
	
	public void samp1Test_calcData(){
		this.samp1Test_answerData.clear();
		if(list1.getItems().size() == 0 || this.samp1Test_muData.getText().length() == 0){
			this.samp1Test_answerStat.appendText("Fill the Table");
			return;
		}
		double mu = Double.parseDouble(this.samp1Test_muData.getText());
		double total = 0;
		for(StatListL1 st: list1.getItems()){
			total += st.getl1();
		}
		double x = total/list1.getItems().size();
		double variance = 0;
		for(StatListL1 st: list1.getItems()){
			variance += Math.pow(st.getl1()-x,2);
		}
		double sx = Math.sqrt(variance/(list1.getItems().size()-1));
		double tValue = (x-mu)/(sx/Math.sqrt(list1.getItems().size()));
		TDistribution t = new TDistribution(list1.getItems().size()-1);
		double pValue = t.probability(Math.abs(tValue), 10000000);
		if(this.samp1Test_TypeData.getValue().equals("≠μo")) pValue*=2;
		this.samp1Test_answerData.appendText("T: "+tValue +"\nP: " + pValue + "\nX: " + x + "\nSx:" + sx + "\nN: " + list1.getItems().size());
	}
	
	public void samp2Test_calcStat(){
		this.samp2Test_answerStat.clear();
		if(this.samp2Test_n1.getText().length() == 0 || this.samp2Test_sx1.getText().length() == 0 ||this.samp2Test_x1.getText().length() == 0 ||this.samp2Test_sx2.getText().length() == 0 ||this.samp2Test_x2.getText().length() == 0 ||this.samp2Test_n2.getText().length() == 0){
			this.samp2Test_answerStat.appendText("Please fill out all fields");
			return;
		}
		double x1 = Double.parseDouble(this.samp2Test_x1.getText());
		double sx1 = Double.parseDouble(this.samp2Test_sx1.getText());
		double n1 = Double.parseDouble(this.samp2Test_n1.getText());
		double x2 = Double.parseDouble(this.samp2Test_x2.getText());
		double sx2 = Double.parseDouble(this.samp2Test_sx2.getText());
		double n2 = Double.parseDouble(this.samp2Test_n2.getText());
		double mean = x1-x2;
		double serror = Math.sqrt(Math.pow(sx1, 2)/n1 + Math.pow(sx2, 2)/n2);
		double tvalue = mean/serror;
		double upper = Math.pow((Math.pow(sx1, 2)/n1 + Math.pow(sx2, 2)/n2),2);
		double lowerLeft = Math.pow(sx1, 4)/((n1-1)*n1*n1);
		double lowerRight = Math.pow(sx2, 4)/((n2-1)*n2*n2);
		double df = upper/(lowerLeft + lowerRight);
		TDistribution t = new TDistribution(df);
		double pValue = t.probability(Math.abs(tvalue), 100000000);
		if(this.samp2Test_TypeStat.getValue().equals("≠μ2")) pValue *=2;
		this.samp2Test_answerStat.appendText("T: " + tvalue + "\nP: " + pValue + "\nDF: " + df);
	}
	
	public void samp2Test_calcData(){
		this.samp2Test_answerData.clear();
		if(this.list1.getItems().size() == 0 || this.list2.getItems().size() == 0){
			this.samp2Test_answerData.appendText("Please fill in the lists");
			return;
		}
		double total1 = 0;
		double n1 = list1.getItems().size();
		for(StatListL1 st: list1.getItems()){
			total1 += st.getl1();
		}
		double x1 = total1/n1;
		double variance = 0;
		for(StatListL1 st: list1.getItems()){
			variance += Math.pow(st.getl1()-x1,2);
		}
		double sx1 = Math.sqrt(variance/(n1-1));
		double total2 = 0;
		double n2 = list2.getItems().size();
		for(StatListL2 st: list2.getItems()){
			total2 += st.getl2();
		}
		double x2 = total2/n2;
		double variance2 = 0;
		for(StatListL2 st: list2.getItems()){
			variance2 += Math.pow(st.getl2()-x2,2);
		}
		double sx2 = Math.sqrt(variance2/(n2-1));
		double mean = x1-x2;
		double serror = Math.sqrt(Math.pow(sx1, 2)/n1 + Math.pow(sx2, 2)/n2);
		double tvalue = mean/serror;
		double upper = Math.pow((Math.pow(sx1, 2)/n1 + Math.pow(sx2, 2)/n2),2);
		double lowerLeft = Math.pow(sx1, 4)/((n1-1)*n1*n1);
		double lowerRight = Math.pow(sx2, 4)/((n2-1)*n2*n2);
		double df = upper/(lowerLeft + lowerRight);
		TDistribution t = new TDistribution(df);
		double pValue = t.probability(Math.abs(tvalue), 100000000);
		if(this.samp2Test_TypeStat.getValue().equals("≠μ2")) pValue *=2;
		this.samp2Test_answerData.appendText("T: " + tvalue + "\nP: " + pValue + "\nDF: " + df + "\nX1: " + x1 + "\nX2: " + x2 + "\nSx1: " + sx1 + "\nSx2: " + sx2 + "\nN1: " + n1 + "\nN2: " + n2);
	}
	
	//probably need a switcher between radians and degrees
	
	public void calculateFinalGrade(){
		this.finalGradeAnswer.clear();
		if(this.currentGrade.getText().length() == 0 || this.finalWorth.getText().length() == 0 || this.gradeDesired.getText().length() == 0){
			this.finalGradeAnswer.appendText("Please fill in all fields!");
			return;
		}
		double preFinalScore = Double.parseDouble(this.currentGrade.getText()) * (100-Double.parseDouble(this.finalWorth.getText()))/100;
		double finalScore = 100 * (Double.parseDouble(this.gradeDesired.getText()) - preFinalScore)/Double.parseDouble(this.finalWorth.getText());
		this.finalGradeAnswer.appendText(finalScore + "%");
		
	}
	
	public void var2Stats(){
		xStats.clear();
		yStats.clear();
		if(list1.getItems().size() == 0 || list2.getItems().size() == 0){
			if(list1.getItems().size() == 0) xStats.appendText("Please fill in x column");
			if(list2.getItems().size() == 0) yStats.appendText("Please fill in y column");
			return;
		}
		if(list1.getItems().size() != list2.getItems().size()){
			xStats.appendText("make sure there are equal amounts of x and y values");
			return;
		}
		double totalx = 0;
		double totalsqx = 0;
		int nx = list1.getItems().size();
		for(int i = 0; i < list1.getItems().size(); i++){
			totalx +=list1.getItems().get(i).getl1();
			totalsqx +=Math.pow(list1.getItems().get(i).getl1(),2);
		}
		double meanx = totalx/nx;
		double variancex = 0;
		for(int i = 0; i < list1.getItems().size(); i++){
			variancex += Math.pow(list1.getItems().get(i).getl1() - meanx,2);
		}
		double sx=Math.sqrt(variancex/(nx-1));
		double σx=Math.sqrt(variancex/(nx));
		ArrayList<Double> d = new ArrayList<Double>();
		for(int i = 0; i < list1.getItems().size(); i++){
			d.add(list1.getItems().get(i).getl1());
		}
		this.recursiveSort(0, d.size()-1, d);
		double minX = d.get(0);
		double maxX = d.get(d.size()-1);
		xStats.appendText("X: " + meanx + "\nΣX: " + totalx + "\nΣX2: " + totalsqx + "\nSx: " + sx + "\nσx: " + σx + "\nMinX: " + minX + "\nMaxX: "+maxX+ "\nN: " + list1.getItems().size());
		double totaly = 0;
		double totalsqy = 0;
		int ny = list2.getItems().size();
		for(int i = 0; i < list2.getItems().size(); i++){
			totaly +=list2.getItems().get(i).getl2();
			totalsqy +=Math.pow(list2.getItems().get(i).getl2(),2);
		}
		double meany = totaly/ny;
		double variancey = 0;
		for(int i = 0; i < list2.getItems().size(); i++){
			variancey += Math.pow(list2.getItems().get(i).getl2() - meany,2);
		}
		double sy=Math.sqrt(variancey/(ny-1));
		double σy=Math.sqrt(variancey/(ny));
		ArrayList<Double> d2 = new ArrayList<Double>();
		for(int i = 0; i < list2.getItems().size(); i++){
			d2.add(list2.getItems().get(i).getl2());
		}
		this.recursiveSort(0, d2.size()-1, d2);
		double minY = d2.get(0);
		double maxY = d2.get(d.size()-1);
		double xy = 0;
		for(int i = 0; i < list2.getItems().size(); i++){
			xy+=list1.getItems().get(i).getl1() * list2.getItems().get(i).getl2();
		}
		yStats.appendText("Y: " + meany + "\nΣY: " + totaly + "\nΣY2: " + totalsqy + "\nSy: " + sy + "\nσy: " + σy + "\nMinY: " + minY + "\nMaxY: "+maxY + "\nΣXY: " + xy);
	}
	
	public void x2GOF(){
		x2Answer.clear();
		if(list1.getItems().size() == 0 || list2.getItems().size() == 0){
			x2Answer.appendText("Please fill in the columns");
			return;
		}
		if(list1.getItems().size() != list2.getItems().size()){
			xStats.appendText("make sure there are equal amounts of x and y values");
		}
		double x2 = 0;
		ArrayList<Double> CNTRB = new ArrayList<Double>();
		for(int i = 0; i < list1.getItems().size(); i++){
			CNTRB.add(Math.pow(list1.getItems().get(i).getl1()-list2.getItems().get(i).getl2(), 2)/list2.getItems().get(i).getl2());
			x2 += Math.pow(list1.getItems().get(i).getl1()-list2.getItems().get(i).getl2(), 2)/list2.getItems().get(i).getl2();
		}
		ChiSquaredDistribution cs = new ChiSquaredDistribution(list1.getItems().size() - 1);
		double p = 1-cs.cumulativeProbability(x2);
		x2Answer.appendText("x2: " + x2 + "\nP: " + p + "\ndf: " + (list1.getItems().size()-1) + "\nCNTRB: " + CNTRB);
	}
	
	public void var1Stats(){
		xStats.clear();
		if(list1.getItems().size() == 0){
			xStats.appendText("Please fill in x column");
			return;
		}
		double total = 0;
		double totalsq = 0;
		int n = list1.getItems().size();
		for(int i = 0; i < list1.getItems().size(); i++){
			total +=list1.getItems().get(i).getl1();
			totalsq +=Math.pow(list1.getItems().get(i).getl1(),2);
		}
		double mean = total/n;
		double variance = 0;
		for(int i = 0; i < list1.getItems().size(); i++){
			variance += Math.pow(list1.getItems().get(i).getl1() - mean,2);
		}
		double sx=Math.sqrt(variance/(n-1));
		double σx=Math.sqrt(variance/(n));
		ArrayList<Double> fiveNumberStats = calcFiveNumbers(list1.getItems());
		double minX = fiveNumberStats.get(0);
		double q1 = fiveNumberStats.get(1);
		double median = fiveNumberStats.get(2);
		double q3 = fiveNumberStats.get(3);
		double maxX = fiveNumberStats.get(4);
		xStats.appendText("X: " + mean + "\nΣX: " + total + "\nΣX2: " + totalsq + "\nSx: " + sx + "\nσx: " + σx + "\nN: " + n + "\nMinX: " + minX + "\nQ1: " + q1 + "\nMed: " + median + "\nQ3: " + q3 + "\nMaxX: " + maxX);
	}
	private ArrayList<Double> calcFiveNumbers(ObservableList<StatListL1> items) {
		ArrayList<Double> temp = new ArrayList<Double>();
		for(int i = 0; i < items.size(); i++){
			temp.add(items.get(i).getl1());
		}
		recursiveSort(0, temp.size() -1, temp);
		ArrayList<Double> fiveNums = new ArrayList<Double>();
		fiveNums.add(temp.get(0));
		double median = midPoint(0, temp.size()-1, temp);
		double q1 = 0;
		double q3 = 0;
		if(temp.size() % 2 == 0){
			q1 = midPoint(0, temp.size()/2, temp);
			q3 = midPoint(temp.size()/2+1, temp.size()-1,temp);
		}else{
			q1 = midPoint(0, temp.size()/2-1, temp);
			q3 = midPoint(temp.size()/2+1, temp.size()-1,temp);
		}
		fiveNums.add(q1);
		fiveNums.add(median);
		fiveNums.add(q3);
		fiveNums.add(temp.get(temp.size()-1));
		
		
		return fiveNums;
	}
	
	private double midPoint(int start, int end, ArrayList<Double> a){
		if((start-end+1)%2 == 0){
			return (a.get((start+end)/2) + a.get((start+end)/2 +1))/2;
		}else{
			return a.get((start+end)/2);
		}
	}

	public void recursiveSort(int first, int last, ArrayList<Double> nums){
        if(last-first == 0) {
            return;
        }
        else if(last - first == 1) {
            if (nums.get(first) > nums.get(last)) {
                double temp1 = nums.get(first);
                nums.set(first, nums.get(last));
                nums.set(last, temp1);
            }
        }
        
        else {
            int mid = (last+first)/2;
            recursiveSort(first,mid,nums);
            recursiveSort(mid+1,last,nums);
            mergeSort(first,mid,last, nums);
        }

        
    }
    public void mergeSort(int first, int mid, int last, ArrayList<Double> nums){
        
        int aPtr = first, bPtr = mid+1, total = last-first+1, loop;
        boolean doneA = false, doneB = false;
        ArrayList<Double> temp = new ArrayList<Double>();
        for(loop = 1; loop <= total; loop++){
            if(doneA) {
                temp.add(nums.get(bPtr++));
            }
            else if(doneB){
                temp.add(nums.get(aPtr++));
            }
            else if(nums.get(aPtr) < nums.get(bPtr)){
                temp.add(nums.get(aPtr++));
            }
            else {
                temp.add(nums.get(bPtr++));
            }
            if(aPtr > mid) doneA = true;
            if(bPtr > last) doneB = true;
        }
        for(loop = first; loop <= last; loop++){ 
            nums.set(loop, temp.get(loop-first));
        }
        
    }

	public void addPoint(){
		StatListL1 sl1;
		StatListL2 sl2;
		if(addL2.getText().length() == 0){
			sl1 = new StatListL1(Double.parseDouble(addL1.getText()));
			this.list1.getItems().add(sl1);
		}else if(addL1.getText().length() == 0){
			sl2 = new StatListL2(Double.parseDouble(addL2.getText()));
			this.list2.getItems().add(sl2);
		}else{
			sl1 = new StatListL1(Double.parseDouble(addL1.getText())); 
			sl2 = new StatListL2(Double.parseDouble(addL2.getText()));
			this.list1.getItems().add(sl1);
			this.list2.getItems().add(sl2);
		}
		addL1.clear();
		addL2.clear();
	}
	
	public void deletePoint(){
		ObservableList<StatListL1> statPoint, allPoints; 
		statPoint = list1.getItems();
		allPoints = list1.getSelectionModel().getSelectedItems();
		statPoint.removeAll(allPoints);
		ObservableList<StatListL2> statPoint2, allPoints2; 
		statPoint2 = list2.getItems();
		allPoints2 = list2.getSelectionModel().getSelectedItems();
		statPoint2.removeAll(allPoints2);
	}
	public void linearRegression(){
		this.linReg.clear();
		if(list1.getItems().size() == 0 || list2.getItems().size() == 0){
			linReg.appendText("Please fill in the lists");
			return;
		}
		if(list1.getItems().size() != list2.getItems().size()){
			linReg.appendText("Please make sure there are equal number of x & y values");
			return;
		}
		SimpleRegression s = new SimpleRegression(true);
		for(int i = 0; i < list1.getItems().size(); i++){
			double x = list1.getItems().get(i).getl1();
			double y = list2.getItems().get(i).getl2();
			s.addData(x, y);
		}
		linReg.appendText("y=a+bx\n");
		linReg.appendText("a=" + s.getSlope());
		linReg.appendText("\nb=" + s.getIntercept());
		linReg.appendText("\nr=" + s.getR());
		linReg.appendText("\nr2=" + s.getRSquare());
		linReg.appendText("\ns=" + Math.sqrt(s.getSumSquaredErrors()/(list2.getItems().size()-2)));
		
	}
	
	public void enter(){
		if(leftOp.equals("") || leftOp.equals("0")){
			this.input.setText("0");
		}else if(oper ==Operation.DEFAULT){
			this.input.setText(leftOp);
		}else{
			if(oper == Operation.COMPUTATION){
				int comp = factorial(Integer.parseInt(leftOp))/(factorial(Integer.parseInt(leftOp)-Integer.parseInt(rightOp))*factorial(Integer.parseInt(rightOp)));
				this.input.clear();
				this.input.appendText(Double.toString(comp));
				this.leftOp = Double.toString(comp);
				this.rightOp = "";
			}else if(oper == Operation.DIVIDE){
				double divide = Double.parseDouble(leftOp) / Double.parseDouble(rightOp);
				this.input.clear();
				this.input.appendText(Double.toString(divide));
				this.leftOp = Double.toString(divide);
				this.rightOp = "";
			}else if(oper == Operation.MODULOUS){
				double mod = Double.parseDouble(leftOp) % Double.parseDouble(rightOp);
				this.input.clear();
				this.input.appendText(Double.toString(mod));
				this.leftOp = Double.toString(mod);
				this.rightOp = "";
			}else if(oper == Operation.MULTIPLY){
				double multiply = Double.parseDouble(leftOp) * Double.parseDouble(rightOp);
				this.input.clear();
				this.input.appendText(Double.toString(multiply));
				this.leftOp = Double.toString(multiply);
				this.rightOp = "";
			}else if(oper == Operation.PERMUTATION){
				int left = Integer.parseInt(leftOp);
				int right = Integer.parseInt(rightOp);
				int perm = factorial(left)/factorial(left-right);
				this.input.clear();
				this.input.appendText(Double.toString(perm));
				this.leftOp = Double.toString(perm);
				this.rightOp = "";
			}else if(oper == Operation.PLUS){
				double add = Double.parseDouble(leftOp) + Double.parseDouble(rightOp);
				this.input.clear();
				this.input.appendText(Double.toString(add));
				this.leftOp = Double.toString(add);
				this.rightOp = "";
			}else if(oper == Operation.POW){
				double pow = Math.pow(Double.parseDouble(leftOp),Double.parseDouble(rightOp));
				this.input.clear();
				this.input.appendText(Double.toString(pow));
				this.leftOp = Double.toString(pow);
				this.rightOp = "";
			}else if(oper == Operation.SUBTRACT){
				double sub = Double.parseDouble(leftOp) - Double.parseDouble(rightOp);
				this.input.clear();
				this.input.appendText(Double.toString(sub));
				this.leftOp = Double.toString(sub);
				this.rightOp = "";
			}
		}
		this.changeOperationText("DEFAULT");
		this.oper = Operation.DEFAULT;
	}
	
	public void scientificNotation(){
		double preText = Double.parseDouble(this.input.getText());
		String notator = notation(preText);
		this.input.clear();
		this.input.appendText(notator);
		if(this.oper != Operation.DEFAULT){
			this.rightOp = notator;
		}else{
			this.leftOp = notator;
		}
	}
	private String notation(double preText) {
		double base = preText;
		int power = 0;
		if(base > 1 || base < -1){
			while(base >= 10 || base <= -10){
				base /=10;
				power++;
			}
		}else{
			while(base < 1 && base > -1){
				base *=10;
				power--;
			}
		}
		return Double.toString(base) + "e" + Integer.toString(power);
	}
		
}

