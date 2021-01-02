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
