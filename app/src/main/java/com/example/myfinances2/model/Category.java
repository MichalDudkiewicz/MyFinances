/**
 * Copyright (c) 2015-2020 TomTom N.V. All rights reserved.
 * <p>
 * This software is the proprietary copyright of TomTom N.V. and its subsidiaries and may be used
 * for internal evaluation purposes or commercial use strictly subject to separate licensee
 * agreement between you and TomTom. If you are the licensee, you are only permitted to use
 * this Software in accordance with the terms of your license agreement. If you are not the
 * licensee then you are not authorised to use this software in any manner and should
 * immediately return it to TomTom N.V.
 */
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
