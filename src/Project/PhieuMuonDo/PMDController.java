package Project.PhieuMuonDo;
import Project.Main;
import config.Connected;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.ModelNguoiDung;
import model.ModelPhieu;
import model.ModelThietBi;
import model.entity.Phieu;
import model.entity.NguoiDung;
import model.entity.ThietBi;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PMDController implements Initializable {
    public TableView<ThietBi>danhsachtb;
    public TableColumn<ThietBi,String >idtb;
    public TableColumn<ThietBi,String>tentb;
    public TableColumn<ThietBi,Integer>soluongtb;
    public TableColumn<ThietBi,String>ngaynhap;
    public TableView<NguoiDung> tbview;
    public TableColumn<NguoiDung,Integer> idND;
    public TableColumn<NguoiDung,String> tenND;
    public TableColumn<NguoiDung,Integer> tuoiND;
    public TableColumn<NguoiDung,String> gioiTinhND;
    public TableColumn<NguoiDung,String> ghiChu;
    public TextField idP;
    public TextField tenP;
    public TextField slP;
    public DatePicker nmP;
    public DatePicker ntP;
    public TextField tbidP;
    public TextField usidP;
    public Text txtText2;
    public static Phieu editP;
    public TableView<Phieu> dsPhieu;
    public TableColumn<Phieu,Integer> tbID;
    public TableColumn<Phieu,String> tbName;
    public TableColumn<Phieu,String> tbSL;
    public TableColumn<Phieu,String> tbNgayMuon;
    public TableColumn<Phieu,String> tbNgayTra;
    public TableColumn<Phieu,Integer> tbTB_ID;
    public TableColumn<Phieu,Integer> tbUS_ID;

    ObservableList<Phieu> dsp = FXCollections.observableArrayList();
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

        ObservableList<NguoiDung> dsnd = FXCollections.observableArrayList();
        idND.setCellValueFactory(new PropertyValueFactory<NguoiDung,Integer>("id"));
        tenND.setCellValueFactory(new PropertyValueFactory<NguoiDung,String>("ten"));
        tuoiND.setCellValueFactory(new PropertyValueFactory<NguoiDung,Integer>("tuoi"));
        gioiTinhND.setCellValueFactory(new PropertyValueFactory<NguoiDung,String>("gioiTinh"));
        ghiChu.setCellValueFactory(new PropertyValueFactory<NguoiDung,String>("ghiChu"));
        ModelNguoiDung modelNguoiDung = new ModelNguoiDung();
        dsnd.addAll(modelNguoiDung.listND());
        tbview.setItems(dsnd);
        tbview.refresh();

        tbID.setCellValueFactory(new PropertyValueFactory<Phieu,Integer>("id"));
        tbName.setCellValueFactory(new PropertyValueFactory<Phieu,String>("ten"));
        tbSL.setCellValueFactory(new PropertyValueFactory<Phieu,String>("soLuong"));
        tbNgayMuon.setCellValueFactory(new PropertyValueFactory<Phieu,String>("ngayMuon"));
        tbNgayTra.setCellValueFactory(new PropertyValueFactory<Phieu,String>("ngayTra"));
        tbTB_ID.setCellValueFactory(new PropertyValueFactory<Phieu,Integer>("tb_id"));
        tbUS_ID.setCellValueFactory(new PropertyValueFactory<Phieu,Integer>("us_id"));

        ModelPhieu modelPhieu = new ModelPhieu();
        dsp.addAll(modelPhieu.listPM());
        dsPhieu.setItems(dsp);
        dsPhieu.refresh();
    }

    public void editPhieu(){
        try {
            Phieu p = dsPhieu.getSelectionModel().getSelectedItem();
            idP.setText(p.getId().toString());
            tenP.setText(p.getTen());
            slP.setText(p.getSoLuong().toString());
            nmP.setValue(LocalDate.parse(p.getNgayMuon()));
            ntP.setValue(LocalDate.parse(p.getNgayTra()));
            tbidP.setText(p.getTb_id().toString());
            usidP.setText(p.getUs_id().toString());
            editP = p;
        }catch (Exception e){
            txtText2.setText("Vui lòng chọn danh mục sửa..!");
            txtText2.setDisable(false);
        }
    }

    public void updateP(){
        try {
            String ten = tenP.getText();
            String sl = slP.getText();
            LocalDate  nm = nmP.getValue();
            LocalDate  nt = ntP.getValue();
            Integer tb_id = Integer.parseInt(tbidP.getText());
            Integer us_id = Integer.parseInt(usidP.getText());
            if(!ten.isEmpty()){
                if(editP != null){
                    editP.setTen(ten);
                    editP.setSoLuong(sl);
                    editP.setNgayMuon(nm.toString());
                    editP.setNgayTra(nt.toString());
                    editP.setTb_id(tb_id);
                    editP.setUs_id(us_id);
                    for(Phieu pp:dsp){
                        if(pp.getId()== editP.getId()){
                            pp = editP;
                            break;
                        }
                    }
                    dsPhieu.refresh();
                    txtText2.setText("Sửa thành công.!");
                    ModelPhieu modelPhieu = new ModelPhieu();
                    modelPhieu.updateP(editP);
                    dsPhieu.setItems(dsp);
                }
            }else {
                txtText2.setText("Vui lòng nhập đầy đủ thông tin.!");
                txtText2.setDisable(false);
            }
        }catch (Exception e) {
            txtText2.setText("Vui lòng chọn danh mục sửa.!");
            txtText2.setDisable(false);
        }
    }

    public void deletePhieu(){
        try {
            Phieu ph = dsPhieu.getSelectionModel().getSelectedItem();
            ModelPhieu modelPhieu = new ModelPhieu();
            if (modelPhieu.deleteP(ph)){
                dsp.addAll(modelPhieu.listPM());
                dsPhieu.setItems(dsp);
                dsPhieu.refresh();
            }
            Parent root = FXMLLoader.load(getClass().getResource("../PhieuMuonDo/PhieuMuon.fxml"));
            Main.mainStage.setScene(new Scene(root, 1100, 900));

        }catch (Exception e) {
            txtText2.setText("Vui lòng chọn danh mục xóa.!");
            txtText2.setDisable(false);
        }
    }

    public void addPhieu(){
        try {
            String ten = tenP.getText();
            String sluong = slP.getText();
            LocalDate nmuon = nmP.getValue();
            LocalDate ntra = ntP.getValue();
            Integer tbi_id = Integer.parseInt(tbidP.getText());
            Integer user_id = Integer.parseInt(usidP.getText());
            ModelPhieu modelPhieu = new ModelPhieu();
            Phieu phieu = new Phieu(null,ten,sluong,nmuon.toString(),ntra.toString(),tbi_id,user_id);
            if ( !sluong.isEmpty() && nmuon!=null && ntra!=null){
                modelPhieu.createP(phieu);
                txtText2.setText("Thêm thành công.!");
                Parent root = FXMLLoader.load(getClass().getResource("../PhieuMuonDo/PhieuMuon.fxml"));
                Main.mainStage.setScene(new Scene(root,1100,900));
            }else{
                txtText2.setText("Vui lòng nhập đầy đủ thông tin!");
                txtText2.setDisable(false);
            }
        } catch (Exception e) {
        }
    }

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Danhsachtb/DanhSach.fxml"));
        Main.mainStage.setTitle("Trang Chủ");
        Main.mainStage.setScene(new Scene(root, 1100, 900));
    }

    public void trove() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Trangchu/Home.fxml"));
        Main.mainStage.setTitle("Trang Chủ");
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
