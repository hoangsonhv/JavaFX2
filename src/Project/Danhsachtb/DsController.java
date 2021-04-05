package Project.Danhsachtb;
import Project.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ModelThietBi;
import model.entity.ThietBi;
import java.net.URL;
import java.util.ResourceBundle;

public class DsController implements Initializable {
    public TableView<ThietBi>danhsachtb;
    public TableColumn<ThietBi,String >idtb;
    public TableColumn<ThietBi,String>tentb;
    public TableColumn<ThietBi,Integer>soluongtb;
    public TableColumn<ThietBi,String>ngaynhap;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idtb.setCellValueFactory(new PropertyValueFactory<ThietBi,String >("id"));
        tentb.setCellValueFactory(new PropertyValueFactory<ThietBi,String>("tenThietBi"));
        soluongtb.setCellValueFactory(new PropertyValueFactory<ThietBi,Integer>("soLuong"));
        ngaynhap.setCellValueFactory(new PropertyValueFactory<ThietBi,String >("ngayNhap"));

        ObservableList<ThietBi> dstb = FXCollections.observableArrayList();
        ModelThietBi modelThietBi = new ModelThietBi();
        dstb.addAll(modelThietBi.getList());
        danhsachtb.setItems(dstb);
        danhsachtb.refresh();
    }

    public void sua() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Suatb/suatb.fxml"));
        Main.mainStage.setTitle("Cập Nhật");
        Main.mainStage.setScene(new Scene(root, 695, 592));
    }

    public void them() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Themtb/ThemThietBi.fxml"));
        Main.mainStage.setTitle("Thêm Thiết Bị");
        Main.mainStage.setScene(new Scene(root, 465, 400));
    }

    public void trove() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Trangchu/Home.fxml"));
        Main.mainStage.setTitle("Trang Chủ");
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
