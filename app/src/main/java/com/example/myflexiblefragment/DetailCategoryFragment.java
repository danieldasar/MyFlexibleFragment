package com.example.myflexiblefragment;


import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OptionalDataException;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailCategoryFragment extends Fragment implements View.OnClickListener{
    private TextView tvCategoryName;
    private TextView tvCategoryDescription;
    private Button btnProfile;
    private Button btnShowDialog;
    public static String EXTRA_NAME="extra_name";
    private String description;

    public DetailCategoryFragment() {
        // Required empty public constructor
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_category, container, false);
        tvCategoryName = (TextView)view.findViewById(R.id.tv_category_name);
        tvCategoryDescription = (TextView)view.findViewById(R.id.tv_category_description);
        btnProfile = (Button) view.findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(this);
        btnShowDialog = (Button) view.findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_profile:
                Intent mIntent = new Intent(getActivity(),ProfileFragment.class);
                startActivity(mIntent);
                break;

            case R.id.btn_show_dialog:
                OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment();
//                mOptionDialogFragment.setOnOptionDialogListener(new OptionDialogFragment.OnptionaDialogListener(){
//                    @Override
//                    public void onOptionChoosen(String text) {
//                        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
//                    }
//                });
                FragmentManager mFragmentManager = getChildFragmentManager();
                mOptionDialogFragment.show(mFragmentManager,OptionDialogFragment.class.getSimpleName());
                break;
        }
    }

    private class ProfileFragment {
    }

    private class OptionDialogFragment {
        public void show(FragmentManager mFragmentManager, String simpleName) {
        }
    }
}
