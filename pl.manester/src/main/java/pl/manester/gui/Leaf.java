package pl.manester.gui;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Leaf {
	
	private Label label;
	private CheckBox checkBox0;
	private CheckBox checkBox1;
	private Border border;
	private Pane leaf;
	
	
	public Leaf(Label label, CheckBox checkBox0, CheckBox checkBox1) {
		this.label = label;
		this.checkBox0 = checkBox0;
		this.checkBox1 = checkBox1;
	}
	
	public Leaf() {
//		BorderStroke borderStroke = new BorderStroke(null, null, null, null, null, null, null, null, null, null, null);
		border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
		
	}

	public Label getLabel() {
		label = new Label("Label");
		label.setLayoutX(2);
		label.setLayoutY(2);
//		label.setPrefSize(72, 24);
//		label.setMaxSize(72, 24);
		label.setBorder(border);
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public CheckBox getCheckBox0() {
		checkBox0 = new CheckBox("ch0");
		checkBox0.setLayoutX(90);
		checkBox0.setLayoutY(2);
//		checkBox0.setPrefSize(16, 16);
		return checkBox0;
	}

	public void setCheckBox0(CheckBox checkBox0) {
		this.checkBox0 = checkBox0;
	}

	public CheckBox getCheckBox1() {
		checkBox1 = new CheckBox("ch1");
		checkBox1.setLayoutX(144);
		checkBox1.setLayoutY(2);
//		checkBox1.setPrefSize(16, 16);
		return checkBox1;
	}

	public void setCheckBox1(CheckBox checkBox1) {
		this.checkBox1 = checkBox1;
	}

	public Border getBorder() {
		return border;
	}

	public void setBorder(Border border) {
		this.border = border;
	}

	public Pane getLeaf() {
		
		Pane pane = new Pane();
		
		return leaf;
	}

	public void setLeaf(Pane leaf) {
		this.leaf = leaf;
	}
	
	public Pane createLeaf() {
		
		Pane pane = new Pane();
		Label label = new Label();
		
		label = new Label("Label");
		label.setLayoutX(2);
		label.setLayoutY(2);
		label.setBorder(border);
		
		CheckBox checkBox0 = new CheckBox();
		checkBox0 = new CheckBox("ch0");
		checkBox0.setLayoutX(90);
		checkBox0.setLayoutY(2);
		
		CheckBox checkBox1 = new CheckBox();
		checkBox1 = new CheckBox("ch1");
		checkBox1.setLayoutX(144);
		checkBox1.setLayoutY(2);

		pane.getChildren().addAll(label, checkBox0, checkBox1);
		
		return pane;
	}

}
