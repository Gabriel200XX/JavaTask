import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-35-166-113-35.us-west-2.compute.amazonaws.com/api/")

                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        try {
            // GET
            Call<List<Task>> callGet = api.getTask();

            Response<List<Task>> rGet = callGet.execute();

            List<Task> tGet = rGet.body();
            System.out.println(tGet);

            // GET ID
            Call<Task> callGetId = api.getTaskById(703);

            Response<Task> rGetId = callGetId.execute();

            Task tGetId = rGetId.body();
            System.out.println(tGetId);

            // POST
            Task taskPost = new Task();
            taskPost.setDescription("Alô");
            Call<Task> callPost = api.createTask(taskPost);
            Response<Task> rPost = callPost.execute();

            Task tPost = rPost.body();
            System.out.println(tPost);

            // PUT
            Task taskPut = new Task();
            taskPut.setDescription("Teste");
            Call<Void> callPut = api.updateTask(62, taskPut);
            Response<Void> rPut = callPut.execute();
            if (rPut.isSuccessful()) {
                System.out.println("Updateou!");
            }

            // DELETE
            Call<Void> callDelete = api.deleteTask(63);
            Response<Void> rDelete = callDelete.execute();
            if (rDelete.isSuccessful()) {
                System.out.println("Se foi!");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
