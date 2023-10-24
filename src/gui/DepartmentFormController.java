package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.utils.Constraints;
import gui.utils.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {

	private Department entity;
	
	private DepartmentService service;

	public void setDepartment(Department entity) {
		this.entity = entity;
	}
	
	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entity null");
		}
		
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}

	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	@FXML
	private TextField txtId;

	@FXML
	private TextField txtName;

	@FXML
	private Label labelErrorName;

	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;

	@FXML
	private void onBtSaveAction() {
		entity = getFormData();
		service.saveOrUpdate(entity);
		
	}

	private Department getFormData() {
		Department obj = new Department();
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		return obj;
	}

	@FXML
	private void onBtCancelAction() {

	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		initializeNodes();

	}

	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 50);
	}

}
