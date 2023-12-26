package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class DatabaseConfiguration {
    public final boolean allowMainThreadQueries;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final RoomDatabase.JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;
    public final RoomDatabase.MigrationContainer migrationContainer;
    public final String name;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    public DatabaseConfiguration(Context context2, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer2, List<RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode2, Executor executor, boolean z2, Set<Integer> set) {
        this.sqliteOpenHelperFactory = factory;
        this.context = context2;
        this.name = str;
        this.migrationContainer = migrationContainer2;
        this.callbacks = list;
        this.allowMainThreadQueries = z;
        this.journalMode = journalMode2;
        this.queryExecutor = executor;
        this.requireMigration = z2;
        this.mMigrationNotRequiredFrom = set;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.mMigrationNotRequiredFrom;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isMigrationRequiredFrom(int r2) {
        /*
            r1 = this;
            boolean r0 = r1.requireMigration
            if (r0 == 0) goto L_0x0014
            java.util.Set<java.lang.Integer> r0 = r1.mMigrationNotRequiredFrom
            if (r0 == 0) goto L_0x0012
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r2 = r0.contains(r2)
            if (r2 != 0) goto L_0x0014
        L_0x0012:
            r2 = 1
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.isMigrationRequiredFrom(int):boolean");
    }
}
