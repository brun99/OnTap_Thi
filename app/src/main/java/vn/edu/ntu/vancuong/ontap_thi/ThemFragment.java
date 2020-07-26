package vn.edu.ntu.vancuong.ontap_thi;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import vn.edu.ntu.vancuong.ontap_thi.controller.IController;
import vn.edu.ntu.vancuong.ontap_thi.model.ThongTin;

public class ThemFragment extends Fragment {
    Toolbar toolbar;
    //Nếu toolbar bị đè xuống thì vào res -> values -> styles.xml rồi sửa từ ...LightActionBar thành NoActionBar
    EditText edtngay, edtten, edtsdt, edtdiachi, edttime;
    RadioButton rbsang, rbchieu, rbtoi;
    Spinner spinner;
    ImageView imglich, imgtime;
    Button btnthem, btnxem;
    RadioGroup rdgGioHoc;

    //Nhớ thêm đủ các controller
    NavController navController;
    IController controller; // Nhớ thêm Icontroller bên main activity

    //Các biến có thể có để lấy dữ liệu
    ThongTin thongTin; //khai báo 1 phần tử trong recycleview để xử lý các hàm thêm và sửa
    String monhoc, phuongthuc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_them, container, false);
        addView(view);
        addEvent();
        return view;
    }

    private void addView(View view) {
        toolbar = view.findViewById(R.id.tbthem);
        toolbar.inflateMenu(R.menu.my_menu);

        edtten = view.findViewById(R.id.edtTen);
        edtsdt = view.findViewById(R.id.editSDT);
        edtdiachi = view.findViewById(R.id.editDiaChi);
        spinner = view.findViewById(R.id.spinner);
        rbsang = view.findViewById(R.id.rbSang);
        rbchieu = view.findViewById(R.id.rbChieu);
        rbtoi = view.findViewById(R.id.rbToi);
        //lịch
        edtngay = view.findViewById(R.id.edtngay);
        imglich = view.findViewById(R.id.imglich);
        //giờ
//        imgtime = view.findViewById(R.id.imgTime);
//        edttime = view.findViewById(R.id.editTime);
        rdgGioHoc = view.findViewById(R.id.rbgGioHoc);
        btnthem = view.findViewById(R.id.btnthem);

//        btnxem = view.findViewById(R.id.btnxem);

        navController = NavHostFragment.findNavController(ThemFragment.this);
        controller = ((MainActivity)getActivity()).controller;
        //Xử lý spinner
        String[] phuongthuc = new String[]{"khóa học java","khóa học android","khóa học web","khóa học SQL","khóa học LinQ"}; // Khai báo 1 mảng dữ liệu cho spinner

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ThemFragment.this.getActivity(),
                R.layout.support_simple_spinner_dropdown_item,phuongthuc);
        //Tạo ra một adapter cho spinner theo chiều dọc đi xuống (support_simple_spinner_dropdown_item)

        spinner.setAdapter(arrayAdapter);// gắn adapter cho spinner
    }
    private void addEvent() {
        imglich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                final DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(year).append("/")
                                .append(month+1).append("/")
                                .append(dayOfMonth);
                        edtngay.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),listener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
//        imgtime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Calendar calendar = Calendar.getInstance();
//                TimePickerDialog.OnTimeSetListener setListener = new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
//                        StringBuilder builder = new StringBuilder();
//                        builder.append(hourOfDay)
//                                .append(":")
//                                .append(minute);
//                        edttime.setText(builder.toString());
//                    }
//                };
//                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), setListener,calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),true);
//                timePickerDialog.show();
//            }
//        });

        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = rdgGioHoc.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton)rdgGioHoc.findViewById(selectedId);

                phuongthuc = spinner.getSelectedItem().toString();

                ThongTin thongTin = new ThongTin();
                thongTin.setTen(edtten.getText().toString());
                thongTin.setNgaysinh(edtngay.getText().toString());
                thongTin.setKhoahoc(phuongthuc);
                thongTin.setGiohoc(radioButton.getText().toString());
                thongTin.setSdt(edtsdt.getText().toString());

                controller.add(thongTin);
                Toast.makeText(getActivity(),"đã thêm",Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.action_themFragment_to_hienThiFragment);
            }
        });
    }
}