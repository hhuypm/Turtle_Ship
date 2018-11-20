package com.example.huypm.turtle_ship.Fragments;

import android.content.Context;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.huypm.turtle_ship.DBManager.TurtleShipManager;
import com.example.huypm.turtle_ship.R;
import com.example.huypm.turtle_ship.model.Customer_Employee;
import com.example.huypm.turtle_ship.model.DiaChi;

import java.util.List;

public class order_step1 extends Fragment {
    Context context_1;
    int id_state;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context_1 = getContext();
        View view = inflater.inflate(R.layout.order_step_1,container,false);
        TurtleShipManager db = new TurtleShipManager(getContext());
        Bundle bundle = getArguments();
        List<DiaChi> listDiachi = db.getDiaChiId(bundle.getInt("ID"));
        Customer_Employee cus_emp_info = db.getCus_Emp(bundle.getInt("ID"));
        String[] listdiachi_spn = new String[listDiachi.size()];
        for (int i=0; i<listDiachi.size();i++ ){
            listdiachi_spn[i] = listDiachi.get(i).getDuong()+" "+listDiachi.get(i).getPhuong()+" "+listDiachi.get(i).getQuan()+" "+listDiachi.get(i).getTp();
            Log.d("TEstcainua"+String.valueOf(i),listDiachi.get(i).getDuong()+" "+listDiachi.get(i).getPhuong()+" "+listDiachi.get(i).getQuan()+" "+listDiachi.get(i).getTp());
        }
        Spinner spn = view.findViewById(R.id.spn_sent_list_add);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( getContext(), R.layout.dropdown_item,listdiachi_spn);
        spn.setAdapter(adapter);
        TextView tv_name = view.findViewById(R.id.tv_name_sent);
        tv_name.setText(cus_emp_info.getTen());
        //Bo quan va phuong vao
        Spinner spn_district_receive = (Spinner) view.findViewById(R.id.spn_district_receive);
        ArrayAdapter<CharSequence> adapter_district = ArrayAdapter.createFromResource(
                getContext(), R.array.District, R.layout.dropdown_item);
        spn_district_receive.setAdapter(adapter_district);

        //phuong
        Spinner spn_state_receive1 = (Spinner) view.findViewById(R.id.spn_state_receive);
        ArrayAdapter<CharSequence> adapter_state1 =ArrayAdapter.createFromResource(context_1, R.array.d1, R.layout.dropdown_item);
        spn_state_receive1.setAdapter(adapter_state1);
        final View v = view;
        spn_district_receive.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spn_state_receive = (Spinner) v.findViewById(R.id.spn_state_receive);
                ArrayAdapter<CharSequence> adapter_state = null;
                switch (position){
                    case 0:
                        adapter_state = ArrayAdapter.createFromResource(context_1, R.array.d1, R.layout.dropdown_item);
                        break;
                    case 1:
                        adapter_state = ArrayAdapter.createFromResource(context_1, R.array.d2, R.layout.dropdown_item);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        break;
                    case 16:
                        break;
                    case 17:
                        break;
                    case 18:
                        break;
                    case 19:
                        break;
                    case 20:
                        break;
                    case 21:
                        break;
                    case 22:
                        break;
                    case 23:
                        break;
                    case 24:
                        break;
                    default:
                }
                spn_state_receive.setAdapter(adapter_state);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button btn_step_2 = (Button) view.findViewById(R.id.btn_next_step_2);
        btn_step_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new order_step2();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft =  fm.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.content_main,fragment);

                ft.commit();
            }
        });
        return view;

    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("order_step_1");
    }
}
