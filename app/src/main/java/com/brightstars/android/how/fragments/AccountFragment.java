package com.brightstars.android.how.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.brightstars.android.how.R;
import com.brightstars.android.how.adapters.AccountAdapter;
import com.brightstars.android.how.models.AccountItem;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Afnan A. A. Abed on 9/24/2018.
 */

public class AccountFragment extends Fragment {

    CircleImageView accountImage;
    TextView accountName;
    TextView accountEmail;
    ListView listView;
    List<AccountItem> accountItems;
    AccountAdapter accountAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        accountImage = view.findViewById(R.id.account_image);
        accountName = view.findViewById(R.id.account_name);
        accountEmail = view.findViewById(R.id.account_email);
        listView = view.findViewById(R.id.account_list);

        // TODO: set the user's name, email and image
        accountName.setText("My name");
        accountEmail.setText("myemail@example.com");

        accountItems = getAccountItems();
        accountAdapter = new AccountAdapter(getContext(), R.layout.fragment_account, accountItems);
        listView.setAdapter(accountAdapter);

        if (getArguments() != null) {
            Bundle bundle = getArguments();
            String name = bundle.getString("key_name");

            Toast.makeText(getContext(), "You are in " + name, Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    private List<AccountItem> getAccountItems() {
        List<AccountItem> items = new ArrayList<>();

        AccountItem myLists = new AccountItem(
                R.drawable.ic_format_list_bulleted_black_24dp, "My List", 0);
        AccountItem likes = new AccountItem(
                R.drawable.ic_favorite_black_24dp, "Likes", 0);
        AccountItem downloads = new AccountItem(
                R.drawable.ic_file_download_black_24dp, "Downloads", 0);
        AccountItem history = new AccountItem(
                R.drawable.ic_history_black_24dp, "History", 0);
        items.add(myLists);
        items.add(likes);
        items.add(downloads);
        items.add(history);

        return items;
    }

//    // This method will calling after click on name row in fragment account :
//    public void editProfile(View view) {
//        Toast.makeText(getContext(), "Account name clicked", Toast.LENGTH_SHORT).show();
//    }
//
//    // This method will calling after click on list row in fragment account :
//    public void showMyList(View view) {
//        Toast.makeText(getContext(), "List clicked", Toast.LENGTH_SHORT).show();
//    }
//
//    // This method will calling after click on likes row in fragment account :
//    public void showMyLikes(View view) {
//        Toast.makeText(getContext(), "Likes clicked", Toast.LENGTH_SHORT).show();
//    }
//
//    // This method will calling after click on downlods row in fragment account :
//    public void showMyDownloads(View view) {
//        Toast.makeText(getContext(), "Downloads clicked", Toast.LENGTH_SHORT).show();
//    }
//
//    // This method will calling after click on history row in fragment account :
//    public void showMyHistory(View view) {
//        Toast.makeText(getContext(), "History clicked", Toast.LENGTH_SHORT).show();
//    }


}

