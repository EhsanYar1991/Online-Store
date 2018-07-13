package com.yar.onlinestore.dao.domain.enums;

public enum CardType {

    TehranCard(0,"کیف پول تجارت"),
    FaraCard(3,"فرا کارت"),
    YazCard(4,"یزد کارت"),
    ZanjanCard(5,"زنجان کارت");

    private int index;

    private String name;

    CardType(int index, String name) {
        this.index = index;
        this.name = name;
    }


    public static CardType fromCode(int index) {

        switch (index) {
            case 0:
                return TehranCard;
            case 3:
                return FaraCard;
            case 4:
                return YazCard;
            case 5:
                return ZanjanCard;
            default:
                return TehranCard;
        }
    }

    public int getIndex() {
        return index;
    }



    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CardType{" +
                "index=" + index +
                ", name='" + name + '\'' +
                '}';
    }
}
