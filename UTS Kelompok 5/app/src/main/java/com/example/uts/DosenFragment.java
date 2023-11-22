package com.example.uts;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DosenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DosenFragment extends Fragment {

    int[] images = {R.drawable.mobile, R.drawable.ar, R.drawable.astro, R.drawable.agama, R.drawable.web, R.drawable.math, R.drawable.pbo, R.drawable.kimia, R.drawable.indo, R.drawable.hij, R.drawable.al, R.drawable.star,R.drawable.mi, R.drawable.beast,R.drawable.pol, R.drawable.bill};
    String[] names = {"Pemrograman Mobile","Augmented Reality","Astrounot","Agama","Pemrograman Mobile","Matematika","Pemrograman Berorientasi Objek","Kimia","Bahasa Indonesia","Tata Busana","DKV","Geografi","Tata Boga","Strategi Bisnis","Kepolisian","Jurusan Model"};
    String[] namadosen = {"Dosen Bu Nova","Dosen Pak Andri","Dosen Pak Elon Musk","Dosen Pak Haji","Dosen Pak Dekky","Dosen Pak Einstien","Dosen Pak indra","Dosen Bu Sintia","Dosen Bu Meginta","Dosen Bu Sri Cahya","Dosen Pak Aldi Permana","Dosen Bu Syifa Reviana","Dosen Pak Tamboy kun","Dosen MR. Beast","Dosen Pak ZAMBO","Dosen Bu Billie Eilish"};


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DosenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DosenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DosenFragment newInstance(String param1, String param2) {
        DosenFragment fragment = new DosenFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dosen, container, false);
        ListView listViewDosen = view.findViewById(R.id.listview);
        listViewDosen.setAdapter(new CustomAdapter());

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TambahInformasi.class);
                startActivity(intent);
            }
        });

        return view;
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View v = inflater.inflate(R.layout.item, parent, false);

            ImageView image = v.findViewById(R.id.img);
            TextView name = v.findViewById(R.id.name);
            TextView namaDosen = v.findViewById(R.id.namadosen);

            image.setImageResource(images[position]);
            name.setText(names[position]);
            namaDosen.setText(namadosen[position]);

            return v;
        }
    }

}