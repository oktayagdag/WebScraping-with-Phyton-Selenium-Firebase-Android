package software.nyxentech.searchtrendstr.pages;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import software.nyxentech.searchtrendstr.MainActivity;
import software.nyxentech.searchtrendstr.R;
import software.nyxentech.searchtrendstr.adapters.SearchAdapter;
import software.nyxentech.searchtrendstr.helper.AlertDialogManager;
import software.nyxentech.searchtrendstr.models.Searchs;


public class Home extends Fragment {

    public Home() {
        // Required empty public constructor
    }
    View view;
    Context context;

    private RecyclerView recyclerView;
    private SearchAdapter adapter;
    private List<Searchs> itemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_search, container, false);
        context = getContext();
        setUp_RecyclerviewAdapter();
        getTrendSearchs();


        return  view;
    }
    public void setUp_RecyclerviewAdapter(){
        recyclerView = view.findViewById(R.id.search_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        itemList = new ArrayList<>();
        adapter = new SearchAdapter(itemList, new SearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final String url) {
                AlertDialogManager.showConfirmationDialog(context,
                        "Uygulamadan Ayrılıyorsun!",
                        "Haber kaynağına gitmek istediğinizden emin misiniz?",
                        "Evet",
                        "Hayır",
                        new AlertDialogManager.DialogClickListener() {
                            @Override
                            public void onPositiveButtonClick() {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                startActivity(intent);
                            }

                            @Override
                            public void onNegativeButtonClick() {
                                Toast.makeText(context, "İptal Edildi.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        recyclerView.setAdapter(adapter);
    }
    public void getTrendSearchs(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference tasksRef = database.getReference("trending_searches/");
        tasksRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                itemList.clear();
                if (dataSnapshot.getChildrenCount() == 0){

                }else{
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        // Firebase'den verileri TodoItem nesnelerine dönüştürün ve listeye ekleyin.
                        Searchs searchsItem = snapshot.getValue(Searchs.class);
                        itemList.add(searchsItem);
                    }
                    adapter.setItemList(itemList);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Firebase", "Veri çekme işlemi başarısız: " + databaseError.getMessage());
            }
        });

    }


}