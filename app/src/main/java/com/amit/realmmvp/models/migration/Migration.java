package com.amit.realmmvp.models.migration;

import java.util.Date;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by Amit Barjatya on 10/9/17.
 */

public class Migration implements RealmMigration {

    /*
     * This value indicates the realm version after the migration has been run
     * Realm version value starts from 0
     * Increase this value if you'd like to upgrade realm schema further
     */
    public static final int VERSION = 1;

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        if(oldVersion == 0){
            schema.get("Book")
                    .addField("imageUri",String.class)
                    .addField("publisher",String.class)
                    .addField("createdOn", Date.class);
            oldVersion++;
        }

        if (oldVersion == 1){
            //use this block if you wish to upgrade schema further
        }
    }
}
