package Project.Trangchu;

import Project.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class TrangChuController {
    public void danhsach() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Danhsachtb/DanhSach.fxml"));
        Main.mainStage.setTitle("Danh Sách Thiết bị");
        Main.mainStage.setScene(new Scene(root,695,592));
    }

    public void user() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../User/User.fxml"));
        Main.mainStage.setTitle("Danh Sách Người Dùng");
        Main.mainStage.setScene(new Scene(root,695,592));
    }

    public void phieu() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../PhieuMuonDo/PhieuMuon.fxml"));
        Main.mainStage.setTitle("Phiếu Mượn Đồ Dùng");
        Main.mainStage.setScene(new Scene(root,695,592));
    }
}
