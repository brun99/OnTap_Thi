package vn.edu.ntu.vancuong.ontap_thi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.vancuong.ontap_thi.controller.IController;
import vn.edu.ntu.vancuong.ontap_thi.model.ThongTin;


public class HienThiFragment extends Fragment {
    Toolbar toolbar;
    List<ThongTin> listThongTin = new ArrayList<>();
    ThongTinAdapter adapter;
    RecyclerView recyclerView;
    NavController navController;
    IController controller;
    Button btnThoat;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hien_thi, container, false);
        setHasOptionsMenu(true);
        addView(view);
        addEvent();
        return view;
    }

    private void addEvent() {
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_hienThiFragment_to_themFragment);
            }
        });
    }

    private void addView(View view) {
        btnThoat = view.findViewById(R.id.btnThoat);
        toolbar = view.findViewById(R.id.tbds);
        recyclerView = view.findViewById(R.id.rcvlist);

        navController = NavHostFragment.findNavController(HienThiFragment.this);
        controller = ((MainActivity)getActivity()).controller;

        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false); //Cho phép xuất hiện nút back
//        toolbar.setNavigationIcon(R.drawable.ic_action_back);

        recyclerView.setLayoutManager(new LinearLayoutManager(HienThiFragment.this.getActivity()));
        ThongTinAdapter adapter = new ThongTinAdapter(controller.getAllThongTin());
        recyclerView.setAdapter(adapter);
    }
    private class ThongTinViewHolder extends RecyclerView.ViewHolder{

        TextView txtname, txtphone, txtBrith, txtloai, txtgiohoc;
        public ThongTinViewHolder(@NonNull View itemView) {
            super(itemView);
           txtname = itemView.findViewById(R.id.txtName);
           txtBrith = itemView.findViewById(R.id.txtngaysinh);
           txtloai = itemView.findViewById(R.id.txtkhoahoc);
           txtgiohoc = itemView.findViewById(R.id.txtgiohoc);
           txtphone = itemView.findViewById(R.id.txtsdt);


        }
        public void bind(ThongTin thongTin){

            txtname.setText("chúc mừng bạn: " + thongTin.getTen());
            txtBrith.setText("sinh ngày: " + thongTin.getNgaysinh());
            txtloai.setText("đã đăng kí thành công: " + thongTin.getKhoahoc());
            txtgiohoc.setText("giờ học: " + thongTin.getGiohoc());
            txtphone.setText("chúng tôi sẻ liên hệ sau qua:" + thongTin.getSdt());
        }
    }
    private class ThongTinAdapter extends RecyclerView.Adapter<ThongTinViewHolder>{
        List<ThongTin> thongTinList = new ArrayList<>();


        public ThongTinAdapter(List<ThongTin> thongTinList) {
            this.thongTinList = thongTinList;
        }

        @NonNull
        @Override
        public ThongTinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater  = getLayoutInflater();
            View view = inflater.inflate(R.layout.hienthi,parent,false);
            return new ThongTinViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ThongTinViewHolder holder, int position) {
            holder.bind(thongTinList.get(position));
        }

        @Override
        public int getItemCount() {
            return thongTinList.size();
        }
    }
}