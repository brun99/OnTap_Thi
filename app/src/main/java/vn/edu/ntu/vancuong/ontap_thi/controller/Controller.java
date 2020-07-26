package vn.edu.ntu.vancuong.ontap_thi.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.vancuong.ontap_thi.model.ThongTin;

public class Controller extends Application implements IController {
    List<ThongTin> listThongTin = new ArrayList<>();

    public Controller(){
        listThongTin.add(new ThongTin("phạm văn cường","10/05/1999","0898391944","nha trang","sáng","khóa học web"));
    }

    @Override
    public List<ThongTin> getAllThongTin() {
        return listThongTin;
    }

    @Override
    public void add(ThongTin thongTin) {
        listThongTin.add(thongTin);
    }
}
