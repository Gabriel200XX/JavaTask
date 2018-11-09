import retrofit2.http.*;
import retrofit2.Call;

import java.util.List;

public interface Api {

    @Headers("Student: 1111007801")
    @GET("tasks")
    Call<List<Task>> getTask();

    @Headers("Student: 1111007801")
    @GET("tasks/{id}")
    Call<Task> getTaskById(@Path("id") long id);

    @Headers("Student: 1111007801")
    @POST("tasks")
    Call<Task> createTask(@Body Task task);

    @Headers("Student: 1111007801")
    @PUT("tasks/{id}")
    Call<Void> updateTask(@Path("id") long id, @Body Task task);

    @Headers("Student: 1111007801")
    @DELETE("tasks/{id}")
    Call<Void> deleteTask(@Path("id") long id);

}
