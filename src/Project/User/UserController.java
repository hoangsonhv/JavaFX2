package Project.User;

import Project.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.ModelNguoiDung;
import model.entity.NguoiDung;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAge;
    public TextField txtSex;
    public TextField txtNote;
    public Text txtText1;
    public static NguoiDung editND;
    public TableView<NguoiDung> tbview;
    public TableColumn<NguoiDung,Integer> idND;
    public TableColumn<NguoiDung,String> tenND;
    public TableColumn<NguoiDung,Integer> tuoiND;
    public TableColumn<NguoiDung,String> gioiTinhND;
    public TableColumn<NguoiDung,String> ghiChu;

    ObservableList<NguoiDung> dsnd = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idND.setCellValueFactory(new PropertyValueFactory<NguoiDung,Integer>("id"));
        tenND.setCellValueFactory(new PropertyValueFactory<NguoiDung,String>("ten"));
        tuoiND.setCellValueFactory(new PropertyValueFactory<NguoiDung,Integer>("tuoi"));
        gioiTinhND.setCellValueFactory(new PropertyValueFactory<NguoiDung,String>("gioiTinh"));
        ghiChu.setCellValueFactory(new PropertyValueFactory<NguoiDung,String>("ghiChu"));

        ModelNguoiDung modelNguoiDung = new ModelNguoiDung();
        dsnd.addAll(modelNguoiDung.listND());
        tbview.setItems(dsnd);
        tbview.refresh();
    }

    public void editND(){
        try {
            NguoiDung nd = tbview.getSelectionModel().getSelectedItem();
            txtId.setText(nd.getId().toString());
            txtName.setText(nd.getTen());
            txtAge.setText(nd.getTuoi().toString());
            txtSex.setText(nd.getGioiTinh());
            txtNote.setText(nd.getGhiChu());
            editND = nd;
        }catch (Exception e){
            txtText1.setText("Vui lòng chọn danh mục sửa..!");
            txtText1.setDisable(false);
        }
    }

    public void updateND(){
        try {
            String ten = txtName.getText();
            Integer tuoi = Integer.parseInt(txtAge.getText());
            String gt = txtSex.getText();
            String gc = txtNote.getText();
            if(!ten.isEmpty()){
                if(editND != null){
                    editND.setTen(ten);
                    editND.setTuoi(tuoi);
                    editND.setGioiTinh(gt);
                    editND.setGhiChu(gc);
                    for(NguoiDung n:dsnd){
                        if(n.getId()== editND.getId()){
                            n = editND;
                            break;
                        }
                    }
                    tbview.refresh();
                    txtText1.setText("Sửa thành công.!");
                    ModelNguoiDung modelNguoiDung = new ModelNguoiDung();
                    modelNguoiDung.update(editND);
                    tbview.setItems(dsnd);
                    Parent root = FXMLLoader.load(getClass().getResource("../User/User.fxml"));
                    Main.mainStage.setScene(new Scene(root,695,592));
                }
            }else {
                txtText1.setText("Vui lòng nhập đầy đủ thông tin.!");
                txtText1.setDisable(false);
            }
        }catch (Exception e) {
            txtText1.setText("Vui lòng chọn danh mục sửa.!");
            txtText1.setDisable(false);
        }
    }

    public void deleteND(){
        try {
            NguoiDung nd = tbview.getSelectionModel().getSelectedItem();
            ModelNguoiDung modelNguoiDung = new ModelNguoiDung();
            if (modelNguoiDung.delete(nd)){
                dsnd.addAll(modelNguoiDung.listND());
                tbview.setItems(dsnd);
                tbview.refresh();
            }
            Parent root = FXMLLoader.load(getClass().getResource("../User/User.fxml"));
            Main.mainStage.setScene(new Scene(root, 695, 592));

        }catch (Exception e) {
            txtText1.setText("Vui lòng chọn danh mục xóa.!");
            txtText1.setDisable(false);
        }
    }

    public void addND(){
        try {
            String name = txtName.getText();
            Integer age = Integer.parseInt(txtAge.getText());
            String sex = txtSex.getText();
            String note = txtNote.getText();
            ModelNguoiDung modelNguoiDung = new ModelNguoiDung();
            NguoiDung nguoiDung = new NguoiDung(null,name,age,sex,note);
            if (!name.isEmpty() && age!=null && !sex.isEmpty() && !note.isEmpty()){
                modelNguoiDung.create(nguoiDung);
                txtText1.setText("Thêm thành công.!");
                Parent root = FXMLLoader.load(getClass().getResource("../User/User.fxml"));
                Main.mainStage.setScene(new Scene(root,695,592));
            }else{
                txtText1.setText("Vui lòng nhập đầy đủ thông tin!");
                txtText1.setDisable(false);
            }
        } catch (Exception e) {}
    }

    public void trove() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Trangchu/Home.fxml"));
        Main.mainStage.setTitle("Trang Chủ");
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
