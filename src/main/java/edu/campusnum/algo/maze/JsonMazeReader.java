package edu.campusnum.algo.maze;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.campusnum.algo.maze.model.MazeCell;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Read a maze from a json file
 */
public class JsonMazeReader {

    private final Map<String,Map<String,List<MazeCell>>> content;

    /**
     * Create a new JsonMazeReader
     * @param resourceName the name of the resource to read
     * @throws IOException if the file is not found
     */
    public JsonMazeReader(String resourceName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonContent = this.getJsonContent(resourceName);
        this.content = mapper.readValue(jsonContent, new TypeReference<>() {
        });
    }

    /**
     * Get the content of a resource as a string
     * @param resourceName the name of the resource
     * @return the content of the resource
     * @throws IOException if the file is not found
     */
    private String getJsonContent(String resourceName) throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resourceName);
        int bufferSize = 1024;
        char[] buffer = new char[bufferSize];
        StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        for (int numRead; (numRead = in.read(buffer, 0, buffer.length)) > 0; ) {
            out.append(buffer, 0, numRead);
        }
        return out.toString();
    }

    /**
     * Get a list of all the sizes of maze available
     * @return set of sizes
     * @throws IOException if the file is not found
     */
    public Set<Integer> getSizes() throws IOException {
        return this.content.keySet().stream().map(Integer::parseInt).collect(Collectors.toSet());
    }

    /**
     * Get a list of all the mazes names for a given size
     * @param size the size of the maze
     * @return set of names
     * @throws IOException if the size is not found
     */
    public Set<String> getMazesNames(Integer size) throws IOException {
        return new HashSet<>(this.content.get(String.valueOf(size)).keySet());
    }

    /**
     * Get a maze for a given size and name
     * @param size the size of the maze
     * @param name the name of the maze
     * @return the maze
     * @throws JsonProcessingException if the maze is not found
     */
    public List<MazeCell> getMaze(Integer size, String name) throws JsonProcessingException {
        return this.content.get(String.valueOf(size)).get(name);
    }

}
