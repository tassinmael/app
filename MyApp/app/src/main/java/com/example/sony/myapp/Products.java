package com.example.sony.myapp;


public class Products {
    private int _id ;
    private String _date;
    private int _beers;
    private int _whisky;
    private int _wine;
    private int _vodka;

public Products(){}
    public Products(int beers, String date, int whisky, int wine, int vodka) {
        this._beers = beers;
        this._date = date;
        this._whisky = whisky;
        this._wine = wine;
        this._vodka = vodka;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public void set_beers(int _beers) {
        this._beers = _beers;
    }

    public void set_whisky(int _whisky) {
        this._whisky = _whisky;
    }

    public void set_wine(int _wine) {
        this._wine = _wine;
    }

    public void set_vodka(int _vodka) {
        this._vodka = _vodka;
    }

    public int get_id() {
        return _id;
    }

    public String get_date() {
        return _date;
    }

    public int get_beers() {
        return _beers;
    }

    public int get_whisky() {
        return _whisky;
    }

    public int get_wine() {
        return _wine;
    }

    public int get_vodka() {
        return _vodka;
    }
}
