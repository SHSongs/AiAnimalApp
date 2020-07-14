package com.example.appprogrammingproject.database.model;
public class Note {
    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_ID = "id";            // 무엇을 알고 싶나요
    public static final String COLUMN_GROUP = "group";      // 무엇을 테스트 해볼까요
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_SELECT = "select";        // 선택한 것

    private int id;
    private String timestamp;

    public int getSelect() {
        return select;
    }

    private int select = 0;

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    private int group = 0;

    public void setSelect(int select) {
        this.select = select;
    }



    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_GROUP + " INTEGER,"
                    + COLUMN_SELECT + " INTEGER,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Note() {
    }



    public Note(int id, int group, int select, String timestamp) {
        this.id = id;
        this.group = group;
        this.select = select;
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
