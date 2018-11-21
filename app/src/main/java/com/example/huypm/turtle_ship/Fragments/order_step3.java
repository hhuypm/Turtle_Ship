package com.example.huypm.turtle_ship.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.huypm.turtle_ship.DBManager.TurtleShipManager;
import com.example.huypm.turtle_ship.R;
import com.example.huypm.turtle_ship.model.ChiTietDonHang;
import com.example.huypm.turtle_ship.model.DiaChi;
import com.example.huypm.turtle_ship.model.DonHang;
import com.example.huypm.turtle_ship.model.NguoiNhan;

import java.util.Calendar;

public class order_step3 extends Fragment {
    TextView tv_name_sent,tv_phone_sent;
    Spinner spn_sent_list_add,spn_district_receive,spn_state_receive;
    EditText et_name_receive,et_phone_step1,et_diachi_step1;
    TextView tv_info_dinhgia,tv_info_hinhthuc,vt_info_sl,vt_info_kl,tv_name_sent_step_3,tv_sdt_sent,tv_diachi_sent,tv_name_receive,tv_sdt_receive,tv_diachi_receive,vt_info_mota;
    Button btn_xacnhan;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_step_3, container, false);
        final Bundle bundle = getArguments();
        tv_name_sent_step_3 = view.findViewById(R.id.tv_name_sent_step_3);
        tv_name_sent_step_3.setText("Người gửi: "+bundle.getString("tv_name_sent"));

        tv_sdt_sent = view.findViewById(R.id.tv_sdt_sent);
        tv_sdt_sent.setText(bundle.getString("tv_phone_sent"));


        tv_diachi_sent = view.findViewById(R.id.tv_diachi_sent);
        tv_diachi_sent.setText("Địa chỉ:"+bundle.getString("spn_sent_list_add"));


        tv_name_receive = view.findViewById(R.id.tv_name_receive);
        tv_name_receive.setText("Người nhận: "+bundle.getString("et_name_receive"));


        tv_sdt_receive = view.findViewById(R.id.tv_sdt_receive);
        tv_sdt_receive.setText("Số điện thoại: "+bundle.getString("et_phone_step1"));

        tv_diachi_receive = view.findViewById(R.id.tv_diachi_receive);
        tv_diachi_receive.setText("Địa chỉ: "+bundle.getString("et_diachi_step1")+","+bundle.getString("spn_state_receive")+","+bundle.getString("spn_district_receive"));

        vt_info_mota = view.findViewById(R.id.vt_info_mota);
        vt_info_mota.setText("Mô tả: "+bundle.getString("et_mota"));

        vt_info_kl = view.findViewById(R.id.vt_info_kl);
        vt_info_kl.setText("Khối lượng: "+bundle.getString("et_KhoiLuong"));

        vt_info_sl = view.findViewById(R.id.vt_info_sl);
        vt_info_sl.setText("Khối lượng: "+bundle.getString("et_soluong"));

        tv_info_hinhthuc = view.findViewById(R.id.tv_info_hinhthuc);
        if (bundle.getString("hinhthuc").toString().equals("2"))
            tv_info_hinhthuc.setText("Người nhận trả phí");
        if (bundle.getString("hinhthuc").toString().equals("1"))
            tv_info_hinhthuc.setText("Người gửi trả phí");

        tv_info_dinhgia = view.findViewById(R.id.tv_info_dinhgia);
        tv_info_dinhgia.setText("Khối lượng: "+bundle.getString("et_dinhgia"));

        Button btn_back = (Button) view.findViewById(R.id.btn_back_step_2);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.popBackStack();
            }
        });
        btn_xacnhan = view.findViewById(R.id.btn_accept_order);
        btn_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TurtleShipManager db = new TurtleShipManager(getContext());
                int maxIdDChi = db.getMaxidAdd();
                int maxIdOrder = db.maxIdOrder();
                int maxIdOderDetail = db.maxIdOrderDetail();
                int maxIdNguoiNhan = db.getMaxIdNguoiNhan();
                db.addNguoiNhan(new NguoiNhan(maxIdNguoiNhan+1,bundle.getString("et_name_receive"),bundle.getString("et_phone_step1")));
                db.addDiaChi(new DiaChi(maxIdDChi+1,bundle.getInt("ID"),"Tp. Hồ Chí Minh",bundle.getString("spn_district_receive"),bundle.getString("spn_state_receive"),bundle.getString("et_diachi_step1"),maxIdNguoiNhan+1,0));
                db.addDonHang(new DonHang(maxIdOrder+1,bundle.getInt("ID"),maxIdNguoiNhan+1, String.valueOf(Calendar.getInstance().getTime()),"","",Integer.valueOf(bundle.getString("id_diachi_kh")),maxIdDChi+1,Integer.valueOf(bundle.getString("hinhthuc")),0,0));
                db.addCTDH(new ChiTietDonHang(maxIdOderDetail+1,"",bundle.getString("et_mota"),bundle.getString("et_dinhgia"),Integer.valueOf(bundle.getString("et_KhoiLuong")),Integer.valueOf(bundle.getString("et_soluong"))));
                Fragment fragment = new Orders();
                FragmentManager fm = getFragmentManager();
                fragment.setArguments(bundle);
                FragmentTransaction ft =  fm.beginTransaction();
                ft.replace(R.id.content_main,fragment);
                ft.commit();
            }
        });
        return view;
    }

}
