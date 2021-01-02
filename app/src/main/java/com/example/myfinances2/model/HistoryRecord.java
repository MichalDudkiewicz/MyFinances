/**
 * Copyright (c) 2015-2021 TomTom N.V. All rights reserved.
 * <p>
 * This software is the proprietary copyright of TomTom N.V. and its subsidiaries and may be used
 * for internal evaluation purposes or commercial use strictly subject to separate licensee
 * agreement between you and TomTom. If you are the licensee, you are only permitted to use
 * this Software in accordance with the terms of your license agreement. If you are not the
 * licensee then you are not authorised to use this software in any manner and should
 * immediately return it to TomTom N.V.
 */
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
