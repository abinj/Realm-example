package com.example.abin.realm_example.utility;

import android.content.Context;
import android.util.Base64;

import com.example.abin.realm_example.model.User;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.exceptions.RealmException;

/**
 * Created by dxuser on 9/3/16.
 */
public class DbUtility {
    private Context context;
    // Create a RealmConfiguration which is to locate Realm file in package's "files" directory.
    private RealmConfiguration realmConfig = new RealmConfiguration.Builder(context).build();
    // Get a Realm instance for this thread
    private Realm realm = Realm.getInstance(realmConfig);

    public DbUtility(Context context) {
        this.context = context;
    }

    public boolean createUser(User user) {
        try {
            realm.beginTransaction();
            realm.copyToRealm(user);
            realm.commitTransaction();
            realm.close();
            return true;
        } catch (RealmException e) {
            e.printStackTrace();
        }
        return false;
    }
}
