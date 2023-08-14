package com.human.runningup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CancellationSignal;

public class DbHelper extends SQLiteOpenHelper {
    private static String CREATE_TABLE = ("CREATE TABLE " + TABLA_FAVORITOS + "(" + KEY_ID + " TEXT," + ITEM_TITULO + " TEXT," + ITEM_CATEGORIA + " TEXT," + ITEM_TIEMPO + " INTEGER," + ITEM_IMAGEN + " TEXT," + FAVORITE_STATUS + " TEXT," + ITEM_DESCRIPCION + " TEXT)");
    public static String FAVORITE_STATUS = "fStatus";
    public static String ITEM_CATEGORIA = "itemcategoria";
    public static String ITEM_DESCRIPCION = "itemdescripcion";
    public static String ITEM_IMAGEN = "itemImage";
    public static String ITEM_TIEMPO = "itemtiempo";
    public static String ITEM_TITULO = "itemTiulo";
    public static String KEY_ID = "id";
    public static final String Nombre_BD = "Running_UP";
    private static String TABLA_FAVORITOS = "Favoritos";
    public static final String TABLA_IMC = "IMC";
    public static final int V_BD = 7;

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public DbHelper(Context context) {
        super(context, Nombre_BD, (SQLiteDatabase.CursorFactory) null, 7);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IMC(ID INTEGER PRIMARY KEY AUTOINCREMENT,Fecha TEXT NOT NULL,Calificación TEXT NOT NULL,Altura TEXT NOT NULL,Peso INTEGER NOT NULL,Evaluación  TEXT NOT NULL,ID_USUARIO TEXT NOT NULL)");
        sQLiteDatabase.execSQL(CREATE_TABLE);
    }

    public void insertIntoTheDatabase(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEM_TITULO, str);
        contentValues.put(ITEM_IMAGEN, str2);
        contentValues.put(KEY_ID, str3);
        contentValues.put(FAVORITE_STATUS, str4);
        contentValues.put(ITEM_DESCRIPCION, str5);
        contentValues.put(ITEM_CATEGORIA, str6);
        contentValues.put(ITEM_TIEMPO, Integer.valueOf(i));
        writableDatabase.insert(TABLA_FAVORITOS, (String) null, contentValues);
    }

    public Cursor LeertablaFav(String str) {
        return getReadableDatabase().rawQuery("select * from " + TABLA_FAVORITOS + " where " + KEY_ID + "=" + str + "", (String[]) null, (CancellationSignal) null);
    }

    public void remove_fav(String str) {
        getWritableDatabase().execSQL("UPDATE " + TABLA_FAVORITOS + " SET  " + FAVORITE_STATUS + " ='0' WHERE " + KEY_ID + "=" + str + "");
    }

    public Cursor select_favoritos_list() {
        return getReadableDatabase().rawQuery("SELECT * FROM " + TABLA_FAVORITOS + " WHERE " + FAVORITE_STATUS + " ='1'", (String[]) null, (CancellationSignal) null);
    }

    public void insertEmpty() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i = 1; i < 11; i++) {
            contentValues.put(KEY_ID, Integer.valueOf(i));
            contentValues.put(FAVORITE_STATUS, "0");
            writableDatabase.insert(TABLA_FAVORITOS, (String) null, contentValues);
        }
    }
}
