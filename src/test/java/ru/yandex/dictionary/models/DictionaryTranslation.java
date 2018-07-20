package ru.yandex.dictionary.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class  DictionaryTranslation{
    @SerializedName("text")
    private String text;
    @SerializedName("gen")
    private String gen;
    @SerializedName("pos")
    private String partOfSpeech;
    @SerializedName("syn")
    private List<DictionaryResponseItem> synonyms;
    @SerializedName("mean")
    private List<DictionaryResponseItem> meaning;
    @SerializedName("ex")
    private List<DictionaryExample> examples;

    public String getText() {
        return text;
    }

    public DictionaryTranslation setText(String text) {
        this.text = text;
        return this;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public DictionaryTranslation setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
        return this;
    }

    public List<DictionaryResponseItem> getSynonyms() {
        return synonyms;
    }

    public DictionaryTranslation setSynonyms(List<DictionaryResponseItem> synonyms) {
        this.synonyms = synonyms;
        return this;
    }

    public List<DictionaryResponseItem> getMeaning() {
        return meaning;
    }

    public DictionaryTranslation setMeaning(List<DictionaryResponseItem> meaning) {
        this.meaning = meaning;
        return this;
    }

    public List<DictionaryExample> getExamples() {
        return examples;
    }

    public DictionaryTranslation setExamples(List<DictionaryExample> examples) {
        this.examples = examples;
        return this;
    }

    public String getGen() {
        return gen;
    }

    public DictionaryTranslation setGen(String gen) {
        this.gen = gen;
        return this;
    }
}