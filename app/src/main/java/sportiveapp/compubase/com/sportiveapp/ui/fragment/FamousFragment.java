package sportiveapp.compubase.com.sportiveapp.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import sportiveapp.compubase.com.sportiveapp.R;
import sportiveapp.compubase.com.sportiveapp.ui.adapter.CentersAdapter;
import sportiveapp.compubase.com.sportiveapp.ui.adapter.FamousAdapter;
import sportiveapp.compubase.com.sportiveapp.ui.model.CentersModel;
import sportiveapp.compubase.com.sportiveapp.ui.model.FamousModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class FamousFragment extends Fragment {


    @BindView(R.id.rcv_famous)
    RecyclerView rcvFamous;
    Unbinder unbinder;
    private FamousAdapter adapter;
    private int[] img;
    private String [] num,name;
    private int i ;

    public FamousFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_famous, container, false);
        unbinder = ButterKnife.bind(this, view);
        setupRecycler();
        fetchData();
        return view;
    }

    private void setupRecycler() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        rcvFamous.setLayoutManager(gridLayoutManager);
        adapter = new FamousAdapter(getActivity());
        rcvFamous.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    private void fetchData (){
        List<FamousModel> famousModels = new ArrayList<>();

        img = new int[]{R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
        num = new String[]{"gym", "gym", "gym", "gym", "gym", "gym", "gym", "gym", "gym"};
        name = new String[]{"name 1", "name 2", "name 3", "name 4", "name 5", "name 6", "name 7", "name 8", "name 9"};

        for ( i = 0; i <img.length ; i++) {
            famousModels.add(new FamousModel(img[i],num[i],name[i]));

//            ratingBar.setRating(num[i]);
        }

        adapter.setData(famousModels);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
