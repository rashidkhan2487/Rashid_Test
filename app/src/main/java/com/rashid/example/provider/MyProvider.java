package com.rashid.example.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.rashid.example.adapter.MyAdapter;
import com.rashid.example.model.Comments;
import com.rashid.example.view.MainActivity;


public class MyProvider extends ContentProvider {

	 static final String PROVIDER_NAME = "com.rashid.example.myprovider";
	 static final String URL = "content://" + PROVIDER_NAME + "/comments";
	 static final Uri CONTENT_URI = Uri.parse(URL);

	 static final String name = "name";

	@Override
	public boolean onCreate() {
		 return true;
	}

	@Nullable
	@Override
	public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
		return null;
	}


	@Override
	public String getType(@NonNull Uri uri) {
		return null;
	}

	@Override
	public Uri insert(@NonNull Uri uri, ContentValues values) {
        Comments comments = new Comments();
        comments.setTitle(values.get(name).toString());
        comments.setId(MainActivity.itemsData.size() + 1);
        MyAdapter adapter = new MyAdapter();
        adapter.updateRecyclerView(comments);
        return ContentUris.withAppendedId(CONTENT_URI, MainActivity.itemsData.size() + 1);
	}

	@Override
	public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
		  return 0;
	}

	@Override
	public int update(@NonNull Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
		  return 0;
	}

}
