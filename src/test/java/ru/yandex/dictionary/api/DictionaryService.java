package ru.yandex.dictionary.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.yandex.dictionary.models.DictionaryLookupResponse;

public interface DictionaryService {

    @GET("/api/v1/dicservice.json/lookup")
    public Call<DictionaryLookupResponse> lookup(@Query("key") String key,
                                                 @Query("text") String text,
                                                 @Query("lang") String lang);

}
