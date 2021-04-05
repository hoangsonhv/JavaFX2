package Project.Themtb;
import Project.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.ModelThietBi;
import model.entity.ThietBi;

import java.time.LocalDate;

public class ThemController {
    public TextField txttentb;
    public TextField txtsoluong;
    public DatePicker txtngaynhap;
    public Text txtText;

    public void add(){
        try {
            String ten = txttentb.getText();
            String soluong = txtsoluong.getText();
            LocalDate ngay = txtngaynhap.getValue();
            ModelThietBi modelThietBi = new ModelThietBi();
            ThietBi thietBi = new ThietBi(null,ten,soluong,ngay.toString());
            if (!ten.isEmpty() && !soluong.isEmpty() && ngay!=null){
                modelThietBi.create(thietBi);
                txtText.setText("Thêm thành công.!");
                Parent root = FXMLLoader.load(getClass().getResource("../Danhsachtb/DanhSach.fxml"));
                Main.mainStage.setScene(new Scene(root,695,592));
            }else {
                txtText.setText("Vui lòng nhập đầy đủ thông tin!");
                txtText.setDisable(false);
            }
        } catch (Exception e) {}
    }

    public void back() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Danhsachtb/DanhSach.fxml"));
        Main.mainStage.setScene(new Scene(root,695,592));
    }

    public void trove() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Trangchu/Home.fxml"));
        Main.mainStage.setTitle("Trang Chủ");
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}