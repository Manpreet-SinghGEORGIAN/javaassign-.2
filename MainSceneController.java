import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class MainSceneController {

    @FXML
    private ListView<Movie> movieList;

    @FXML
    private void loadMovies() {
        try {
            URL apiUrl = new URL("your_api_url_here"); // Replace with your API URL
            InputStreamReader reader = new InputStreamReader(apiUrl.openStream());

            // Assuming the API response is a JSON array of movie objects
            Movie[] moviesArray = new Gson().fromJson(reader, Movie[].class);
            List<Movie> movies = Arrays.asList(moviesArray);

            movieList.getItems().addAll(movies);
        } catch (IOException e) {
            showAlertDialog("Error", "Failed to load movies", e.getMessage(), AlertType.ERROR);
        }
    }

    private void showAlertDialog(String title, String header, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
