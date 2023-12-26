package com.tekartik.sqflite;

/* compiled from: DatabaseTask */
interface DatabaseDelegate {
    int getDatabaseId();

    boolean isInTransaction();
}
