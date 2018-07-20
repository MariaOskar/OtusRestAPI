package ru.yandex.tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import static io.restassured.RestAssured.given;

public class BaseTest {
    protected static final String DICTIONARY_URL = "https://dictionary.yandex.net";
    protected static final String GETLANGS_API_URL = DICTIONARY_URL + "/api/v1/dicservice.json/getLangs";
    protected static final String LOOKUP_API_URL = DICTIONARY_URL + "/api/v1/dicservice.json/lookup";
    protected static final String DICT_API_KEY = "dict.1.1.20180718T152751Z.b148d97cf60bd06a.2a370f44d3c49000c6887d5aeb28a915485d162e";

    public Response getLangsResponse(){
        return given()
                .queryParam("key", DICT_API_KEY)
                .get(GETLANGS_API_URL);
    }

    public Response getLookupResponse(String lang, String word){
        return given()
                .queryParam("key", DICT_API_KEY)
                .queryParam("lang", lang)
                .queryParam("text", word)
                .get(LOOKUP_API_URL);
    }

    public JsonPath getJsonPath(Response response){
        return response.then().extract().body().jsonPath();
    }

    public Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(DICTIONARY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
