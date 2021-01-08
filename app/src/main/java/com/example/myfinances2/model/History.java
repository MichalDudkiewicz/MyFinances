package com.example.myfinances2.model;

public class History {
    private final String m_category;
    private final Integer m_value;
    private final String m_date;

    public History(String category, Integer value, String date)
    {
        m_category = category;
        m_value = value;
        m_date = date;
    }

    public Integer value()
    {
        return m_value;
    }

    public String category()
    {
        return m_category;
    }

    public String date()
    {
        return m_date;
    }
}
