package com.example.appprogrammingproject.database.model;
public class Note {
    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_ID = "id";            // 무엇을 알고 싶나요
    public static final String COLUMN_GROUPITEM = "groupitem";      // 무엇을 테스트 해볼까요
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_SELECTITEM = "selectitem";        // 선택한 것

    private int id;
    private String timestamp;

    public int getSelectitem() {
        return selectitem;
    }

    private int selectitem = 0;

    private int groupitem = 0;


    public int getGroupitem() {
        return groupitem;
    }

    public void setGroupitem(int groupitem) {
        this.groupitem = groupitem;
    }


    public void setSelectitem(int selectitem) {
        this.selectitem = selectitem;
    }



    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER,"
                    + COLUMN_GROUPITEM + " INTEGER,"
                    + COLUMN_SELECTITEM + " INTEGER,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Note() {
    }



    public Note(int id, int groupitem, int selectitem, String timestamp) {
        this.id = id;
        this.groupitem = groupitem;
        this.selectitem = selectitem;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }



    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
