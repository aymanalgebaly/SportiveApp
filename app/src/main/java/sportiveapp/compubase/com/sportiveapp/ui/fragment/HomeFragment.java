package sportiveapp.compubase.com.sportiveapp.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import sportiveapp.compubase.com.sportiveapp.R;
import sportiveapp.compubase.com.sportiveapp.ui.adapter.CentersAdapter;
import sportiveapp.compubase.com.sportiveapp.ui.api.API;
import sportiveapp.compubase.com.sportiveapp.ui.helper.RetrofitClient;
import sportiveapp.compubase.com.sportiveapp.ui.model.Center;
import sportiveapp.compubase.com.sportiveapp.ui.model.CentersModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements OnMapReadyCallback {



    @BindView(R.id.edite_search_center)
    EditText editeSearchCenter;
    @BindView(R.id.lin_one_home)
    LinearLayout linOneHome;
    @BindView(R.id.map_frame)
    FrameLayout mapFrame;
    @BindView(R.id.rcv_home)
    RecyclerView rcvHome;
    Unbinder unbinder;

    private SupportMapFragment supportMapFragment;
    GoogleMap mgoogleMap;
    private CentersAdapter adapter;
    private int[] img;
    private String[]num,name;
    private int i;
    private int page;
    private List<Center>centers = new ArrayList<>();

    private ArrayList<Center> centerArrayList = new ArrayList<>();


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frg);
        if (supportMapFragment == null){
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            supportMapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.frg,supportMapFragment).commit();

        }
        supportMapFragment.getMapAsync(this);

        setupRecycler();
        fetchData();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mgoogleMap = googleMap;
    }

    private void setupRecycler() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvHome.setLayoutManager(linearLayoutManager);
//        adapter = new CentersAdapter(getActivity());
//        rcvHome.setAdapter(adapter);

    }
    private void fetchData (){
        Call<ResponseBody> call2 = RetrofitClient.getInstant().create(API.class).ListOfCenters();

        call2.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();


                try {
                    assert response.body() != null;
                    List<Center> centerList = Arrays.asList(gson.fromJson(response.body().string(), Center[].class));

//                    Toast.makeText(getActivity(), centerList.get(0).getName(), Toast.LENGTH_SHORT).show();

                    if (response.isSuccessful()){

                        for (int j = 0; j <centerList.size() ; j++) {

                            Center center = new Center();

                            center.setName(centerList.get(j).getName());

                            centerArrayList.add(center);
                        }
                        adapter = new CentersAdapter(centerArrayList);
                        rcvHome.setAdapter(adapter);
//                        adapter.setTOAdapter(centerList);
                        adapter.notifyDataSetChanged();


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();

                Log.i("onFailure: ",t.getMessage());
            }
        });
        
        }

//    private void viewData(ResponseBody body) {
//        List<Center> centerList = new ArrayList<>();
//
//        for (int j = 0; j <centers.size() ; j++) {
//
//            center.setName(centerList.get(i).getName());
//
//            centerList.add(center);
//        }
//        adapter.setTOAdapter(centerList);
//        adapter.notifyDataSetChanged();
//    }

//    private void viewData(Center body) {
//        Center center = new Center();
//        center.setName(centers.);
//
//        centers.add(center);
//
//        adapter.setTOAdapter(centers);
//    }
}
