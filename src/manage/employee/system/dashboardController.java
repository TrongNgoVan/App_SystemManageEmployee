/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage.employee.system;

import java.text.NumberFormat;
import java.util.Locale;


import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class dashboardController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private Label username;

    @FXML
    private Button home_btn;

    @FXML
    private Button addEmployee_btn;

    @FXML
    private Button salary_btn;
    
    @FXML
    private Button wday_btn;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalEmployees;

    @FXML
    private Label home_totalPresents;

    @FXML
    private Label home_totalInactiveEm;

    @FXML
    private BarChart<?, ?> home_chart;

    @FXML
    private AnchorPane addEmployee_form;

    @FXML
    private TableView<employeeData> addEmployee_tableView;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_employeeID;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_firstName;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_lastName;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_gender;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_phoneNum;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_position;

    @FXML
    private TableColumn<employeeData, String> addEmployee_col_date;

    @FXML
    private TextField addEmployee_search;

    @FXML
    private TextField addEmployee_employeeID;

    @FXML
    private TextField addEmployee_firstName;

    @FXML
    private TextField addEmployee_lastName;

    @FXML
    private ComboBox<String> addEmployee_gender;

    @FXML
    private TextField addEmployee_phoneNum;

    @FXML
    private ComboBox<String> addEmployee_position;

    @FXML
    private ImageView addEmployee_image;

    @FXML
    private Button addEmployee_importBtn;

    @FXML
    private Button addEmployee_addBtn;

    @FXML
    private Button addEmployee_updateBtn;

    @FXML
    private Button addEmployee_deleteBtn;

    @FXML
    private Button addEmployee_clearBtn;

    @FXML
    private AnchorPane salary_form;

    @FXML
    private  Label salary_employeeID;

    @FXML
    private Label salary_firstName;

    @FXML
    private Label salary_lastName;

    @FXML
    private Label salary_position;

    @FXML
    private TextField salary_salary1;
    
    @FXML
    private Label salary_salary2;
    
    @FXML
    private TextField salary_acc;
    
    @FXML
    private TextField salary_bank;
    

    @FXML
    private Button salary_updateBtn;

    @FXML
    private Button salary_clearBtn;

    @FXML
    private TableView<employeeData> salary_tableView;

    @FXML
    private TableColumn<employeeData, String> salary_col_employeeID;

    @FXML
    private TableColumn<employeeData, String> salary_col_firstName;

    @FXML
    private TableColumn<employeeData, String> salary_col_lastName;

    @FXML
    private TableColumn<employeeData, String> salary_col_position;

    @FXML
    private TableColumn<employeeData, String> salary_col_salary1;
    
    @FXML
    private TableColumn<employeeData, String> salary_col_salary2;
    
    @FXML
    private TableColumn<employeeData, String> salary_col_acc;
    
    @FXML
    private TableColumn<employeeData, String> salary_col_bank;
    
    
    @FXML
    private AnchorPane wday_form;
    @FXML
    private Label wday_employeeID;

    @FXML
    private Label wday_firstName;

    @FXML
    private Label wday_lastName;

    @FXML
    private Label wday_position;

    @FXML
    private TextField wday_wday1;
    
    @FXML
    private TextField wday_wday2;
    
    @FXML
    private TextField wday_wday3;
    
    @FXML
    private TextField wday_wday4;
   

    @FXML
    private Button wday_updateBtn;

    @FXML
    private Button wday_clearBtn;

    @FXML
    private TableView<employeeData> wday_tableView;

    @FXML
    private TableColumn<employeeData, String> wday_col_employeeID;

    @FXML
    private TableColumn<employeeData, String> wday_col_firstName;

    @FXML
    private TableColumn<employeeData, String> wday_col_lastName;

    @FXML
    private TableColumn<employeeData, String> wday_col_position;

    @FXML
    private TableColumn<employeeData, String> wday_col_wday1;
    
    @FXML
    private TableColumn<employeeData, String> wday_col_wday2;
    
    @FXML
    private TableColumn<employeeData, String> wday_col_wday3;
    
    @FXML
    private TableColumn<employeeData, String> wday_col_wday4;
    

    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

    private Image image;

    public void homeTotalEmployees() {

        String sql = "SELECT COUNT(employee_id) FROM employee";

        connect = database.connectDb();
        int countData = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(employee_id)");
            }

            home_totalEmployees.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeEmployeeTotalPresent() {

        String sql = "SELECT COUNT(employee_id) FROM employee WHERE salary2 > 0";

        connect = database.connectDb();
        int countData = 0;
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                countData = result.getInt("COUNT(employee_id)");
            }
            home_totalPresents.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeTotalInactive() {

        String sql = "SELECT COUNT(employee_id) FROM employee WHERE salary2 = 0";

        connect = database.connectDb();
        int countData = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(employee_id)");
            }
            home_totalInactiveEm.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeChart() {

        home_chart.getData().clear();


           String sql= "SELECT position, COUNT(employee_id) AS count FROM employee GROUP BY position";


        connect = database.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            home_chart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

public void addEmployeeAdd() {

    Date date = new Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

    String sql = "INSERT INTO employee "
            + "(employee_id,firstName,lastName,gender,phoneNum,position,image,date,wday1,wday2,wday3,wday4,salary1,salary2,acc,bank) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    connect = database.connectDb();

    try {
        Alert alert;
        if (addEmployee_employeeID.getText().isEmpty()
                || addEmployee_firstName.getText().isEmpty()
                || addEmployee_lastName.getText().isEmpty()
                || addEmployee_gender.getSelectionModel().getSelectedItem() == null
                || addEmployee_phoneNum.getText().isEmpty()
                || addEmployee_position.getSelectionModel().getSelectedItem() == null
                || getData.path == null || getData.path.isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            // Check phone number format
            String phoneNum = addEmployee_phoneNum.getText();
            if (!isValidPhoneNumber(phoneNum)) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid phone number format");
                alert.showAndWait();
                return;
            }

            String check = "SELECT employee_id FROM employee WHERE employee_id = '"
                    + addEmployee_employeeID.getText() + "'";

            statement = connect.createStatement();
            result = statement.executeQuery(check);

            if (result.next()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Employee ID: " + addEmployee_employeeID.getText() + " already exists!");
                alert.showAndWait();
            } else {
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, addEmployee_employeeID.getText());
                prepare.setString(2, addEmployee_firstName.getText());
                prepare.setString(3, addEmployee_lastName.getText());
                prepare.setString(4, (String) addEmployee_gender.getSelectionModel().getSelectedItem());
                prepare.setString(5, phoneNum);
                prepare.setString(6, (String) addEmployee_position.getSelectionModel().getSelectedItem());

                String uri = getData.path;
                uri = uri.replace("\\", "\\\\");

                prepare.setString(7, uri);
                prepare.setString(8, String.valueOf(sqlDate));
                prepare.setInt(9, 0);
                prepare.setInt(10, 0);
                prepare.setInt(11, 0);
                prepare.setInt(12, 0);
                prepare.setDouble(13, 0.0);
                prepare.setDouble(14, 0.0);
                prepare.setString(15, "Chưa nhập");
                prepare.setString(16, "Chưa nhập");
                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();

                addEmployeeShowListData();
                addEmployeeReset();
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

private boolean isValidPhoneNumber(String phoneNum) {
    // Define a regular expression pattern for a valid phone number
    // Here we assume a valid phone number is 10 digits long
    String regex = "\\d{10}";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(phoneNum);
    return matcher.matches();
}


    public void addEmployeeUpdate() {

        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "UPDATE employee SET firstName = '"
                + addEmployee_firstName.getText() + "', lastName = '"
                + addEmployee_lastName.getText() + "', gender = '"
                + addEmployee_gender.getSelectionModel().getSelectedItem() + "', phoneNum = '"
                + addEmployee_phoneNum.getText() + "', position = '"
                + addEmployee_position.getSelectionModel().getSelectedItem() + "', image = '"
                + uri + "', date = '" + sqlDate + "' WHERE employee_id ='"
                + addEmployee_employeeID.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;
            if (addEmployee_employeeID.getText().isEmpty()
                    || addEmployee_firstName.getText().isEmpty()
                    || addEmployee_lastName.getText().isEmpty()
                    || addEmployee_gender.getSelectionModel().getSelectedItem() == null
                    || addEmployee_phoneNum.getText().isEmpty()
                    || addEmployee_position.getSelectionModel().getSelectedItem() == null
                    || getData.path == null || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {
            // Check phone number format
            String phoneNum = addEmployee_phoneNum.getText();
            if (!isValidPhoneNumber(phoneNum)) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid phone number format");
                alert.showAndWait();
                return;
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Cofirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Employee ID: " + addEmployee_employeeID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    double salary = 0;

                    String checkData = "SELECT * FROM employee WHERE employee_id = '"
                            + addEmployee_employeeID.getText() + "'";

                    prepare = connect.prepareStatement(checkData);
                    result = prepare.executeQuery();

                    
                  
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Update thành công!!!!");
                    alert.showAndWait();

                    addEmployeeShowListData();
                    addEmployeeReset();
                }

            }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addEmployeeDelete() {

        String sql = "DELETE FROM employee WHERE employee_id = '"
                + addEmployee_employeeID.getText() + "'";

        connect = database.connectDb();

        try {

            Alert alert;
            if (addEmployee_employeeID.getText().isEmpty()
                    || addEmployee_firstName.getText().isEmpty()
                    || addEmployee_lastName.getText().isEmpty()
                    || addEmployee_gender.getSelectionModel().getSelectedItem() == null
                    || addEmployee_phoneNum.getText().isEmpty()
                    || addEmployee_position.getSelectionModel().getSelectedItem() == null
                    || getData.path == null || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Cofirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Employee ID: " + addEmployee_employeeID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
               
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    addEmployeeShowListData();
                    addEmployeeReset();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addEmployeeReset() {
        addEmployee_employeeID.setText("");
        addEmployee_firstName.setText("");
        addEmployee_lastName.setText("");
        addEmployee_gender.getSelectionModel().clearSelection();
        addEmployee_position.getSelectionModel().clearSelection();
        addEmployee_phoneNum.setText("");
        addEmployee_image.setImage(null);
        getData.path = "";
    }

    public void addEmployeeInsertImage() {

        FileChooser open = new FileChooser();
        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {
            getData.path = file.getAbsolutePath();

            image = new Image(file.toURI().toString(), 136, 141, false, true);
            addEmployee_image.setImage(image);
        }
    }

    private String[] positionList = {"Data Engineer", "Web BackEnd", "Web FrontEnd", "AI Engineer" ,"Marketing" ,"General Accounting"};

    public void addEmployeePositionList() {
        List<String> listP = new ArrayList<>();

        for (String data : positionList) {
            listP.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listP);
        addEmployee_position.setItems(listData);
    }

    private String[] listGender = {"Male", "Female"};

    public void addEmployeeGendernList() {
        List<String> listG = new ArrayList<>();

        for (String data : listGender) {
            listG.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);
        addEmployee_gender.setItems(listData);
    }

    public void addEmployeeSearch() {

        FilteredList<employeeData> filter = new FilteredList<>(addEmployeeList, e -> true);

        addEmployee_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateEmployeeData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateEmployeeData.getEmployeeId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getFirstName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getLastName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getGender().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getPhoneNum().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getPosition().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getDate().toString().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<employeeData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(addEmployee_tableView.comparatorProperty());
        addEmployee_tableView.setItems(sortList);
    }

    public ObservableList<employeeData> addEmployeeListData() {

        ObservableList<employeeData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employee";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            employeeData employeeD;

            while (result.next()) {
                employeeD = new employeeData(result.getInt("employee_id"),
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString("gender"),
                        result.getString("phoneNum"),
                        result.getString("position"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getInt("wday1"),
                        result.getInt("wday2"),
                        result.getInt("wday3"),
                        result.getInt("wday4"),
                        result.getDouble("salary1"),
                        result.getDouble("salary2"),
                        result.getString("acc"),
                        result.getString("bank"));
                listData.add(employeeD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    private ObservableList<employeeData> addEmployeeList;

    public void addEmployeeShowListData() {
        addEmployeeList = addEmployeeListData();

        addEmployee_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        addEmployee_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        addEmployee_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addEmployee_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addEmployee_col_phoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        addEmployee_col_position.setCellValueFactory(new PropertyValueFactory<>("position"));
        addEmployee_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        addEmployee_tableView.setItems(addEmployeeList);

    }

    public void addEmployeeSelect() {
        employeeData employeeD = addEmployee_tableView.getSelectionModel().getSelectedItem();
        int num = addEmployee_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addEmployee_employeeID.setText(String.valueOf(employeeD.getEmployeeId()));
        addEmployee_firstName.setText(employeeD.getFirstName());
        addEmployee_lastName.setText(employeeD.getLastName());
        addEmployee_phoneNum.setText(employeeD.getPhoneNum());
        addEmployee_gender.getSelectionModel().select((String) employeeD.getGender());
        addEmployee_position.getSelectionModel().select((String) employeeD.getPosition());
        

        getData.path = employeeD.getImage();

        String uri = "file:" + employeeD.getImage();

        image = new Image(uri, 136, 141, false, true);
        addEmployee_image.setImage(image);
    }

 
 public void salaryUpdate() {
    String sql = "UPDATE employee SET salary1 = ?, salary2 = ?, acc = ?, bank = ? WHERE employee_id = ?";
    connect = database.connectDb();

    try {
        Alert alert;

        if (salary_employeeID.getText().isEmpty()
                || salary_firstName.getText().isEmpty()
                || salary_lastName.getText().isEmpty()
                || salary_position.getText().isEmpty()
                || salary_salary1.getText().isEmpty()
                || salary_salary2.getText().isEmpty()
                || salary_acc.getText().isEmpty()
                || salary_bank.getText().isEmpty()) {
            
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng điền đầy đủ thông tin!!!");
            alert.showAndWait();
            
        } else {
            double salary1 = 0;
            double salary2 = 0;

            try {
                salary1 = Double.parseDouble(salary_salary1.getText());

                if (salary1 <= 0) {
                    throw new NumberFormatException("Lương đầu vào phải là một số nguyên dương");
                }
            } catch (NumberFormatException e) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Lương đầu vào phải là một số nguyên dương");
                alert.showAndWait();
                return;
            }

            

            // Set parameters for the prepared statement
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setDouble(1, salary1);
            preparedStatement.setDouble(2, salary2);
            preparedStatement.setString(3, salary_acc.getText());
            preparedStatement.setString(4, salary_bank.getText());
            preparedStatement.setString(5, salary_employeeID.getText());

            preparedStatement.executeUpdate();

            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Update thành công!!!!");
            alert.showAndWait();

            salaryShowListData();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}



    public void salaryReset() {
        salary_employeeID.setText("");
        salary_firstName.setText("");
        salary_lastName.setText("");
        salary_position.setText("");
        salary_salary1.setText("");
        salary_salary2.setText("");
        salary_acc.setText("");
        salary_bank.setText("");
    }

    public ObservableList<employeeData> salaryListData() {


        ObservableList<employeeData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employee";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            employeeData employeeD;

            while (result.next()) {
                employeeD = new employeeData(result.getInt("employee_id"),
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString("gender"),
                        result.getString("phoneNum"),
                        result.getString("position"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getInt("wday1"),
                        result.getInt("wday2"),
                        result.getInt("wday3"),
                        result.getInt("wday4"),
                        result.getDouble("salary1"),
                        result.getDouble("salary2"),
                        result.getString("acc"),
                        result.getString("bank"));
                listData.add(employeeD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<employeeData> salaryList;

    public void salaryShowListData() {
       

        salaryList = salaryListData();

        salary_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        salary_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        salary_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        salary_col_position.setCellValueFactory(new PropertyValueFactory<>("position"));
       salary_col_salary1.setCellValueFactory(cellData -> {
        Double salary1 = cellData.getValue().getSalary1();
        return new SimpleStringProperty(String.format("%.2f", salary1));
    });

    salary_col_salary2.setCellValueFactory(cellData -> {
        Double salary2 = cellData.getValue().getSalary2();
        return new SimpleStringProperty(String.format("%.2f", salary2));
    });
   
        salary_col_acc.setCellValueFactory(new PropertyValueFactory<>("acc"));
        salary_col_bank.setCellValueFactory(new PropertyValueFactory<>("bank"));
        salary_tableView.setItems(salaryList);

    }

    public void salarySelect() {
    employeeData employeeD = salary_tableView.getSelectionModel().getSelectedItem();
    int num = salary_tableView.getSelectionModel().getSelectedIndex();

    if ((num - 1) < -1) {
        return;
    }

    salary_employeeID.setText(String.valueOf(employeeD.getEmployeeId()));
    salary_firstName.setText(employeeD.getFirstName());
    salary_lastName.setText(employeeD.getLastName());
    salary_position.setText(employeeD.getPosition());

    // Format salary to two decimal places
    String formattedSalary1 = String.format("%.2f", employeeD.getSalary1());
    String formattedSalary2 = String.format("%.2f", employeeD.getSalary2());

    salary_salary1.setText(formattedSalary1);
    salary_salary2.setText(formattedSalary2);
    salary_acc.setText(employeeD.getAcc());
    salary_bank.setText(employeeD.getBank());
}

 public void wdayUpdate() {
    String sql = "UPDATE employee SET wday1 = '"
            + wday_wday1.getText() + "', wday2 = '"
            + wday_wday2.getText() + "', wday3 = '"
            + wday_wday3.getText() + "', wday4 = '"
            + wday_wday4.getText() + "' WHERE employee_id ='"
            + wday_employeeID.getText() + "'";

    connect = database.connectDb();

    try {
        Alert alert;

        if (wday_employeeID.getText().isEmpty()
                || wday_firstName.getText().isEmpty()
                || wday_lastName.getText().isEmpty()
                || wday_position.getText().isEmpty()
                || wday_wday1.getText().isEmpty()
                || wday_wday2.getText().isEmpty()
                || wday_wday3.getText().isEmpty()
                || wday_wday4.getText().isEmpty()) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng điền đầy đủ thông tin!!!");
            alert.showAndWait();

        } else {
            int wday1 = 0, wday2 = 0, wday3 = 0, wday4 = 0;

            try {
                wday1 = Integer.parseInt(wday_wday1.getText());
                wday2 = Integer.parseInt(wday_wday2.getText());
                wday3 = Integer.parseInt(wday_wday3.getText());
                wday4 = Integer.parseInt(wday_wday4.getText());

                if (wday1 < 0 || wday2 < 0 || wday3 < 0 || wday4 < 0) {
                    throw new NumberFormatException("Ngày làm việc phải là số nguyên không âm!");
                }

                int totalDays = wday1 + wday2 + wday3 + wday4;

                if (totalDays > 31) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Tổng số ngày trên 1 tháng không được vượt quá 31!");
                    alert.showAndWait();
                    return;
                }
            } catch (NumberFormatException e) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Ngày làm việc phải là số nguyên không âm!");
                alert.showAndWait();
                return;
            }

            statement = connect.createStatement();
            statement.executeUpdate(sql);

            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Update thành công!!!!");
            alert.showAndWait();

            wdayShowListData();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void wdayReset() {
        wday_employeeID.setText("");
        wday_firstName.setText("");
        wday_lastName.setText("");
        wday_position.setText("");
        wday_wday1.setText("");
        wday_wday2.setText("");
        wday_wday3.setText("");
        wday_wday4.setText("");
    }
    public ObservableList<employeeData> wdayListData() {
        ObservableList<employeeData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employee";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            employeeData employeeD;

            while (result.next()) {
                employeeD = new employeeData(result.getInt("employee_id"),
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString("gender"),
                        result.getString("phoneNum"),
                        result.getString("position"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getInt("wday1"),
                        result.getInt("wday2"),
                        result.getInt("wday3"),
                        result.getInt("wday4"),
                        result.getDouble("salary1"),
                        result.getDouble("salary2"),
                        result.getString("acc"),
                        result.getString("bank"));
                listData.add(employeeD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<employeeData> wdayList;

    public void wdayShowListData() {
        wdayList = wdayListData();

        wday_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        wday_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        wday_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        wday_col_position.setCellValueFactory(new PropertyValueFactory<>("position"));
        wday_col_wday1.setCellValueFactory(new PropertyValueFactory<>("wday1"));
        wday_col_wday2.setCellValueFactory(new PropertyValueFactory<>("wday2"));
        wday_col_wday3.setCellValueFactory(new PropertyValueFactory<>("wday3"));
        wday_col_wday4.setCellValueFactory(new PropertyValueFactory<>("wday4"));
        
        wday_tableView.setItems(wdayList);

    }

    public void wdaySelect() {

        employeeData employeeD = wday_tableView.getSelectionModel().getSelectedItem();
        int num = wday_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        wday_employeeID.setText(String.valueOf(employeeD.getEmployeeId()));
        wday_firstName.setText(employeeD.getFirstName());
        wday_lastName.setText(employeeD.getLastName());
        wday_position.setText(employeeD.getPosition());
        wday_wday1.setText(String.valueOf(employeeD.getWday1()));
        wday_wday2.setText(String.valueOf(employeeD.getWday2()));
        wday_wday3.setText(String.valueOf(employeeD.getWday3()));
        wday_wday4.setText(String.valueOf(employeeD.getWday4()));

    }
    

    public void defaultNav() {
        home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
    }

    public void displayUsername() {
        username.setText(getData.username);
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            addEmployee_form.setVisible(false);
            salary_form.setVisible(false);
            wday_form.setVisible(false);
            

            home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            addEmployee_btn.setStyle("-fx-background-color:transparent");
            salary_btn.setStyle("-fx-background-color:transparent");
            wday_btn.setStyle("-fx-background-color:transparent");

            homeTotalEmployees();
            homeEmployeeTotalPresent();
            homeTotalInactive();
            homeChart();

        } else if (event.getSource() == addEmployee_btn) {
            home_form.setVisible(false);
            addEmployee_form.setVisible(true);
            salary_form.setVisible(false);
             wday_form.setVisible(false);
            

            addEmployee_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            home_btn.setStyle("-fx-background-color:transparent");
            salary_btn.setStyle("-fx-background-color:transparent");
            wday_btn.setStyle("-fx-background-color:transparent");

            addEmployeeGendernList();
            addEmployeePositionList();
            addEmployeeSearch();

        } else if (event.getSource() == salary_btn) {
            home_form.setVisible(false);
            addEmployee_form.setVisible(false);
            salary_form.setVisible(true);
            wday_form.setVisible(false);

            salary_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            addEmployee_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            wday_btn.setStyle("-fx-background-color:transparent");

            salaryShowListData();

        }else if (event.getSource() == wday_btn) {
            home_form.setVisible(false);
            addEmployee_form.setVisible(false);
            salary_form.setVisible(false);
            wday_form.setVisible(true);

            wday_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            addEmployee_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            salary_btn.setStyle("-fx-background-color:transparent");

            wdayShowListData();

        }

    }

    private double x = 0;
    private double y = 0;

    public void logout() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        defaultNav();

        homeTotalEmployees();
        homeEmployeeTotalPresent();
        homeTotalInactive();
        homeChart();

        addEmployeeShowListData();
        addEmployeeGendernList();
        addEmployeePositionList();

        salaryShowListData();
        
        wdayShowListData();
    }

}
