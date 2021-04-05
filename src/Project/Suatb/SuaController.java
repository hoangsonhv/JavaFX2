package Project.Suatb;

import Project.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.ModelThietBi;
import model.entity.ThietBi;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SuaController implements Initializable {
    public TextField txtid;
    public TextField txttentb;
    public TextField txtsoluong;
    public DatePicker txtngaynhap;
    public Text txtText;
    public static ThietBi editTB;
    public TableView<ThietBi> danhsachtb;
    public TableColumn<ThietBi,String >idtb;
    public TableColumn<ThietBi,String>tentb;
    public TableColumn<ThietBi,Integer>soluongtb;
    public TableColumn<ThietBi,String>ngaynhap;

    ObservableList<ThietBi> dstb = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idtb.setCellValueFactory(new PropertyValueFactory<ThietBi,String >("id"));
        tentb.setCellValueFactory(new PropertyValueFactory<ThietBi,String>("tenThietBi"));
        soluongtb.setCellValueFactory(new PropertyValueFactory<ThietBi,Integer>("soLuong"));
        ngaynhap.setCellValueFactory(new PropertyValueFactory<ThietBi,String >("ngayNhap"));
        ModelThietBi modelThietBi = new ModelThietBi();
        dstb.addAll(modelThietBi.getList());
        danhsachtb.setItems(dstb);
        danhsachtb.refresh();
    }

    public void edit(){
        try {
            ThietBi s = danhsachtb.getSelectionModel().getSelectedItem();
            txtid.setText(s.getId());
            txttentb.setText(s.getTenThietBi());
            txtsoluong.setText(s.getSoLuong());
            txtngaynhap.setValue(LocalDate.parse(s.getNgayNhap()));
            editTB = s;
        }catch (Exception e){
            txtText.setText("Vui lòng chọn danh mục sửa..!");
            txtText.setDisable(false);
            System.out.println(e.getMessage());
        }
    }

    public void update() {
        try {
            String ten = txttentb.getText();
            String soluong = txtsoluong.getText();
            LocalDate ngay = txtngaynhap.getValue();
            if(!ten.isEmpty()){
                if(editTB != null){
                    editTB.setTenThietBi(ten);
                    editTB.setSoLuong(soluong);
                    editTB.setNgayNhap(ngay.toString());
                    for(ThietBi ss:dstb){
                        if(ss.getId()== editTB.getId()){
                            ss = editTB;
                            break;
                        }
                    }
                    txtText.setText("Sửa thành công.!");
                    ModelThietBi modelThietBi = new ModelThietBi();
                    modelThietBi.update(editTB);
                    danhsachtb.setItems(dstb);
                    danhsachtb.refresh();
                    Parent root = FXMLLoader.load(getClass().getResource("../Suatb/suatb.fxml"));
                    Main.mainStage.setScene(new Scene(root,695,592));
                }
            }else {
                txtText.setText("Vui lòng nhập đầy đủ thông tin.!");
                txtText.setDisable(false);
            }
        }catch (Exception e) {
            txtText.setText("Vui lòng chọn danh mục sửa.!");
            txtText.setDisable(false);
        }
    }

    public void delete(){
        try {
            ThietBi s = danhsachtb.getSelectionModel().getSelectedItem();
            ModelThietBi modelThietBi = new ModelThietBi();
            if (modelThietBi.delete(s)){
                dstb.addAll(modelThietBi.getList());
                danhsachtb.setItems(dstb);
                danhsachtb.refresh();
            }
            Parent root = FXMLLoader.load(getClass().getResource("../Suatb/suatb.fxml"));
            Main.mainStage.setScene(new Scene(root, 695, 592));
        }catch (Exception e) {
            txtText.setText("Vui lòng chọn danh mục xóa.!");
            txtText.setDisable(false);
        }
    }

    public void trove() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Trangchu/Home.fxml"));
        Main.mainStage.setTitle("Trang Chủ");
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }

    public void back1() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Danhsachtb/DanhSach.fxml"));
        Main.mainStage.setTitle("Trang Chủ");
        Main.mainStage.setScene(new Scene(root, 695, 592));
    }
}
