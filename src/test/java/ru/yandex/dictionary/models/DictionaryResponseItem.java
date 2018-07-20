package ru.yandex.dictionary.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class DictionaryResponseItem {
    @SerializedName("gen")
    private String gen;
    @SerializedName("pos")
    private String partOfSpeech;
    @SerializedName("text")
    private String text;

    public String getText() {
        return text;
    }

    public DictionaryResponseItem setText(String text) {
        this.text = text;
        return this;
    }

    public String getGen() {
        return gen;
    }

    public DictionaryResponseItem setGen(String gen) {
        this.gen = gen;
        return this;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public DictionaryResponseItem setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictionaryResponseItem item = (DictionaryResponseItem) o;
        return Objects.equals(gen, item.gen) &&
                Objects.equals(partOfSpeech, item.partOfSpeech) &&
                Objects.equals(text, item.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gen, partOfSpeech, text);
    }

    @Override
    public String toString() {
        return "DictionaryResponseItem{" +
                "gen='" + gen + '\'' +
                ", partOfSpeech='" + partOfSpeech + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}