package com.example.myfinances2.model;

public class HistoryRecord {
    private String m_category;
    private int m_value;
    private String m_date;


    public HistoryRecord(String category, int value, String date)
    {
        m_category = category;
        m_value = value;
        m_date = date;
    }

    public int getValue() {
        return m_value;
    }

    public String getCategory() {
        return m_category;
    }

    public String getDate() {
        return m_date;
    }

    public void setCategory(String m_category) {
        this.m_category = m_category;
    }

    public void setDate(String m_date) {
        this.m_date = m_date;
    }

    public void setValue(int m_value) {
        this.m_value = m_value;
    }

}
