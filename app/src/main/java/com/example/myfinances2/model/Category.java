package com.example.myfinances2.model;

public class Category {
    private final String m_name;
    private int m_value;

    public String name()
    {
        return m_name;
    }

    public int value()
    {
        return m_value;
    }

    public Category(String name)
    {
        m_name = name;
        m_value = 0;
    }

    public Category(String name, int value)
    {
        m_name = name;
        m_value = value;
    }

    public Category(Category category)
    {
        this.m_name = category.name();
        this.m_value = category.value();
    }

    public void addValue(int value)
    {
        m_value += value;
    }
}
